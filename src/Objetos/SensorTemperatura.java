package Objetos;

import Abstract.Sensor;

public class SensorTemperatura extends Sensor {
    
    private double temperaturaAtual;
    private boolean ligado = false;
    private int potencia = 0;

    public SensorTemperatura(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo, double temperaturaAtual) {
        super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
        this.temperaturaAtual = temperaturaAtual;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public void setTemperaturaAtual(double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    @Override
    public void lerDado() {
        
        System.out.println("Lendo dado de temperatura: " + temperaturaAtual + getUnidade());
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Sensor ligado (potencia = " + potencia + ").");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Sensor desligado.");
    }

    @Override
    public boolean verificarStatus() {
        System.out.println("Verificando status do sensor de temperatura.");
        return ligado; 
    }

}
