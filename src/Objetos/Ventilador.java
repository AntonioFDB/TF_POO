package Objetos;

import Interfaces.Controlavel;

public class Ventilador implements Controlavel {
    private boolean ligado;
    private int potencia; 

    public Ventilador(int potencia) {
        this.potencia = potencia;
        this.ligado = false;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Ventilador ligado (potencia = " + potencia + ").");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Ventilador desligado.");
    }

    @Override
    public boolean verificarStatus() {
        return ligado;
    }

    public void acionar() {
        if (ligado) {
            System.out.println("Ventilador acionando: circulando ar (potencia = " + potencia + ").");
        }
    }
}
