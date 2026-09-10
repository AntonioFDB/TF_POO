package Objetos;

import ENUMs.StatusEstufa;
import Abstract.Sensor;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Estufa {
    private int id;
    private String localizacao;
    private double area;
    private List<Cultura> culturas;
    private List<Sensor> sensores;
    private List<java.lang.Object> dispositivos;
    private StatusEstufa status;

    public Estufa(int id, String localizacao, double area) {
        this.id = id;
        this.localizacao = localizacao;
        this.area = area;
        this.culturas = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
        this.status = StatusEstufa.ATIVA;
    }

    
    public int getId() { 
        return id; 
    }
    
    public String getLocalizacao() { 
        return localizacao; 
    }
    
    public double getArea() { 
        return area; 
    }
    
    public List<Cultura> getCulturas() { 
        return culturas; 
    }
    
    public List<Sensor> getSensores() { 
        return sensores; 
    }

    public List<java.lang.Object> getDispositivos() {
        return dispositivos;
    }
    
    public StatusEstufa getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusEstufa status) { 
        this.status = status; 
    }


    public void cadastrarCultura(Cultura c) {
        this.culturas.add(c);
    }

    public void removerCultura(int idCultura) {
        this.culturas.removeIf(c -> c.getId() == idCultura);
    }

    public void cadastrarSensor(Sensor s) {
        this.sensores.add(s);
    }

    public void removerSensor(int idSensor) {
        this.sensores.removeIf(s -> s.getId() == idSensor);
    }

    public void adicionarDispositivo(Object dispositivo) {
        this.dispositivos.add(dispositivo);
    }

   
    public double calcularMediaTemperatura() {
        OptionalDouble avg = sensores.stream()
                .filter(s -> s.getTipo().equalsIgnoreCase("Temperatura"))
                .mapToDouble(Sensor::getLeituraAtual)
                .average(); 
        return avg.isPresent() ? avg.getAsDouble() : 0.0;
    }

    public double calcularMediaUmidade() {
        OptionalDouble avg = sensores.stream()
                .filter(s -> s.getTipo().equalsIgnoreCase("Umidade"))
                .mapToDouble(Sensor::getLeituraAtual)
                .average();
        return avg.isPresent() ? avg.getAsDouble() : 0.0;
    }

    public double calcularMediaLuminosidade() {
        OptionalDouble avg = sensores.stream()
                .filter(s -> s.getTipo().equalsIgnoreCase("Luminosidade"))
                .mapToDouble(Sensor::getLeituraAtual)
                .average();
        return avg.isPresent() ? avg.getAsDouble() : 0.0;
    }

    
    public List<String> gerarAlertas() {
        return sensores.stream()
                .filter(Sensor::verificarAlerta)
                .map(s -> "Sensor " + s.getTipo() + " (id=" + s.getId() + ") fora do intervalo [" + s.getLimiteMinimo() + ", " + s.getLimiteMaximo() + "], leitura=" + s.getLeituraAtual())
                .collect(Collectors.toList());
    }

    
    public Relatorio gerarRelatorioAtual() {
        double mediaTemp = calcularMediaTemperatura();
        double mediaUmid = calcularMediaUmidade();
        double mediaLum = calcularMediaLuminosidade();
        ArrayList<String> alertas = new ArrayList<>(gerarAlertas());
        Relatorio r = new Relatorio(java.time.LocalDate.now(), this, mediaTemp, mediaUmid, mediaLum, alertas);
        return r;
    }

    
    public void atuarAutomaticamente() {
        double mediaUmidade = calcularMediaUmidade();
        double necessidadeMedia = culturas.stream().mapToDouble(Cultura::getNecessidadeHidrica).average().orElse(0.0);

        
        dispositivos.stream()
                .filter(d -> d instanceof Irrigador)
                .forEach(d -> {
                    Irrigador irr = (Irrigador) d;
                    if (mediaUmidade < necessidadeMedia) {
                        if (!irr.verificarStatus()) irr.ligar();
                        irr.acionar(); 
                    } else {
                        if (irr.verificarStatus()) irr.desligar();
                    }
                });

        
        double mediaTemp = calcularMediaTemperatura();
        dispositivos.stream()
                .filter(d -> d instanceof Ventilador)
                .forEach(d -> {
                    Ventilador v = (Ventilador) d;
                    if (mediaTemp > 35.0) {
                        if (!v.verificarStatus()) v.ligar();
                        v.acionar();
                    } else {
                        if (v.verificarStatus()) v.desligar();
                    }
                });

    
        double mediaLum = calcularMediaLuminosidade();
        dispositivos.stream()
                .filter(d -> d instanceof Luminaria)
                .forEach(d -> {
                    Luminaria l = (Luminaria) d;
                    if (mediaLum < 220.0) {
                        if (!l.verificarStatus()) l.ligar();
                        l.acionar();
                    } else {
                        if (l.verificarStatus()) l.desligar();
                    }
                });
    }

    
    public boolean preverIrrigacao() {
        double mediaUmidade = calcularMediaUmidade();
        double necessidadeMedia = culturas.stream().mapToDouble(Cultura::getNecessidadeHidrica).average().orElse(0.0);
        return mediaUmidade < (necessidadeMedia * 0.9);
    }

    @Override
    public String toString() {
        return "Estufa {id=" + id + ", localizacao='" + localizacao + "', area=" + area + ", status=" + status + "}";
    }
}
