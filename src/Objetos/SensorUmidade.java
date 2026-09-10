package Objetos;

import Abstract.Sensor;

public class SensorUmidade extends Sensor {
    
    private double umidadeSolo;
    private boolean ligado = false;
    private int porcentagem = 0;


    public SensorUmidade(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo, double umidadeSolo) {
        super(id, tipo, unidade, leituraAtual, limiteMinimo, limiteMaximo);
        this.umidadeSolo = umidadeSolo;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getUmidadeSolo() {
        return umidadeSolo;
    }

    public void setUmidadeSolo(double umidadeSolo) {
        this.umidadeSolo = umidadeSolo;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Sensor ligado (porcentagem = " + porcentagem + ").");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Sensor desligado.");
    }

    @Override
    public boolean verificarStatus() {
        System.out.println("Verificando status do sensor de umidade.");
        return ligado; 
    }

    @Override
    public void lerDado() {
        
        System.out.println("Lendo dado de umidade do solo: " + umidadeSolo + getUnidade());
    }
}
