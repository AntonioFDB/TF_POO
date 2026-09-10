package Abstract;
import Interfaces.Controlavel;


public abstract class Sensor implements Controlavel {
    private int id;
    private String tipo;
    private String unidade;
    private double leituraAtual;
    private double limiteMinimo;
    private double limiteMaximo;

    public Sensor(int id, String tipo, String unidade, double leituraAtual, double limiteMinimo, double limiteMaximo) {
        this.id = id;
        this.tipo = tipo;
        this.unidade = unidade;
        this.leituraAtual = leituraAtual;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    public double getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setLeituraAtual(double leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public void setLimiteMinimo(double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public void setLimiteMaximo(double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public boolean verificarAlerta() {
        if (leituraAtual < limiteMinimo || leituraAtual > limiteMaximo) { // se estiver fora do limite, retorna tru, ou seja, retorna um alerta
            return true;
        }
        return false;
    }

    

    public abstract void lerDado();

    @Override
    public void ligar() {
        
    }

    @Override
    public void desligar() {
        
    }

    @Override
    public boolean verificarStatus() {
        
        return true; 
    }


}
