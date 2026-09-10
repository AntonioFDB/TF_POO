package Objetos;

import Abstract.Sensor;

public class SensorLuminosidade extends Sensor {
    
    private String localInstalacao;
    private boolean ligado = false;
    private double potenciaWatts = 0.0;

    public SensorLuminosidade(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo, String localInstalacao) {
        super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
        this.localInstalacao = localInstalacao;
    }

    public double getPotenciaWatts() {
        return potenciaWatts;
    }

    public void setPotenciaWatts(double potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
    }

    public String getLocalInstalacao() {
        return localInstalacao;
    }

    public void setLocalInstalacao(String localInstalacao) {
        this.localInstalacao = localInstalacao;
    }

    @Override
    public void lerDado() {
        
        System.out.println("Lendo dado de luminosidade em " + localInstalacao + ": " + getLeituraAtual() + getUnidade());
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Sensor ligado (potencia = " + potenciaWatts + "W).");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Sensor desligado.");
    }

    @Override
    public boolean verificarStatus() {
        System.out.println("Verificando status do sensor de luminosidade.");
        return ligado;
    }
}