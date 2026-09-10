package Objetos;

import Interfaces.Controlavel;

public class Irrigador implements Controlavel {
    private boolean ligado;
    private double vazao;

    public Irrigador(double vazao) {
        this.vazao = vazao;
        this.ligado = false;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Irrigador ligado (vazao = " + vazao + ").");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Irrigador desligado.");
    }

    @Override
    public boolean verificarStatus() {
        return ligado;
    }

    
    public void acionar() {
        if (ligado) {
            System.out.println("Irrigador acionando: distribuindo água a " + vazao + " L/min.");
        } else {
            System.out.println("Irrigador está desligado; não pode acionar.");
        }
    }
}
