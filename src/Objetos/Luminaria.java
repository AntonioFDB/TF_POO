package Objetos;

import Interfaces.Controlavel;

public class Luminaria implements Controlavel {
    private boolean ligada;
    private double potenciaWatts;

    public Luminaria(double potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
        this.ligada = false;
    }

    @Override
    public void ligar() {
        ligada = true;
        System.out.println("Luminária ligada (potencia = " + potenciaWatts + "W).");
    }

    @Override
    public void desligar() {
        ligada = false;
        System.out.println("Luminária desligada.");
    }

    @Override
    public boolean verificarStatus() {
        return ligada;
    }

    public void acionar() {
        if (ligada) {
            System.out.println("Luminária acesa (potencia=" + potenciaWatts + "W).");
        }
    }
}
