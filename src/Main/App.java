package Main;

import Objetos.*;
import ENUMs.FaseCultura;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        
        Estufa estufa = new Estufa(1, "PUCRS - Lab", 50.0);

        
        Cultura c1 = new Cultura(1, "Cenoura", FaseCultura.CRESCIMENTO, 40.0, 200.0);
        Cultura c2 = new Cultura(2, "Espinafre", FaseCultura.GERMINACAO, 30.0, 120.0);
        estufa.cadastrarCultura(c1);
        estufa.cadastrarCultura(c2);

        
        SensorTemperatura st = new SensorTemperatura(80, "Temperatura", "°C", 100.5, 10.0, 40.0, 32.5);
        SensorUmidade su = new SensorUmidade(2, "Umidade", "%", 35.0, 20.0, 80.0, 35.0);
        SensorLuminosidade sl = new SensorLuminosidade(3, "Luminosidade", "lx", 150.0, 50.0, 2000.0, "teto");
        SensorIrrigacao si = new SensorIrrigacao(4, "Irrigação", "L", 0.0, 0.0, 1000.0, 500.0);

        estufa.cadastrarSensor(st);
        estufa.cadastrarSensor(su);
        estufa.cadastrarSensor(sl);
        estufa.cadastrarSensor(si);

        
        Irrigador irrigador = new Irrigador(12.0);
        Ventilador ventilador = new Ventilador(4);
        Luminaria luminaria = new Luminaria(180.0);

        estufa.adicionarDispositivo(irrigador);
        estufa.adicionarDispositivo(ventilador);
        estufa.adicionarDispositivo(luminaria);

        
        System.out.println("Simulando leituras...");
        estufa.getSensores().forEach(s -> {
            s.lerDado();
            if (s.verificarAlerta()) {
                System.out.println("ALERTA: sensor id= " + s.getId() + " tipo = " + s.getTipo());
            }
        });

        
        System.out.println("\nAtuação automática (com base nas médias e nas culturas)...");
        estufa.atuarAutomaticamente();

        
        boolean precisaIrrigar = estufa.preverIrrigacao();
        System.out.println("\nPrevisão de irrigação: " + (precisaIrrigar ? "Recomenda irrigar" : "Irrigação não recomendada"));

        
        Relatorio rel = estufa.gerarRelatorioAtual();
        System.out.println("\nResumo do relatório:\n" + rel.gerarResumo());
        String nomeArquivo = "Relatorio_Estufa_" + estufa.getId() + "_" + LocalDate.now().toString() + ".txt";
        rel.salvarEmArquivo(nomeArquivo);

        System.out.println("\nExecução finalizada.");
    }
}
