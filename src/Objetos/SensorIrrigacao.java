package Objetos;

import Abstract.Sensor;

public class SensorIrrigacao extends Sensor {
 
    private double nivelAguaAtual;
    private boolean ligado = false;
    private double vazao = 0.0; 

    public SensorIrrigacao(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo, double nivelAguaAtual) {
        super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
        this.nivelAguaAtual = nivelAguaAtual;
    }

    public double getVazao() {
        return vazao;
    }

    public void setVazao(double vazao) {
        this.vazao = vazao;
    }

    public double getNivelAguaAtual() {
        return nivelAguaAtual;
    }

    public void setNivelAguaAtual(double nivelAguaAtual) {
        this.nivelAguaAtual = nivelAguaAtual;
    }

    @Override
    public void lerDado() {
        
        System.out.println("Lendo dado de nível de água: " + nivelAguaAtual + getUnidade());
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Sensor de irrigação ligado (vazao = " + vazao + ").");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Sensor de irrigação desligado.");
    }

    @Override
    public boolean verificarStatus() {
        System.out.println("Verificando status do sensor de irrigação.");
        return ligado; 
    }

}
