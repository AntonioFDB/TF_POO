package Objetos;

import ENUMs.FaseCultura;


public class Cultura {
    
    private int id;
    private String nome;
    private FaseCultura faseCrescimento;
    private double necessidadeHidrica;
    private double producaoEstimativa;

    public Cultura(int id, String nome, FaseCultura faseCrescimento, double necessidadeHidrica, double producaoEstimativa) {
        this.id = id;
        this.nome = nome;
        this.faseCrescimento = faseCrescimento;
        this.necessidadeHidrica = necessidadeHidrica;
        this.producaoEstimativa = producaoEstimativa;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public FaseCultura getFaseCrescimento() {
        return faseCrescimento;
    }

    public double getNecessidadeHidrica() {
        return necessidadeHidrica;
    }

    public double getProducaoEstimativa() {
        return producaoEstimativa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFaseCrescimento(FaseCultura faseCrescimento) {
        this.faseCrescimento = faseCrescimento;
    }

    public void setNecessidadeHidrica(double necessidadeHidrica) {
        this.necessidadeHidrica = necessidadeHidrica;
    }

    public void setProducaoEstimativa(double producaoEstimativa) {
        this.producaoEstimativa = producaoEstimativa;
    }

    public void calcularProdutividadeEstimada() {
        double fator = 1.0;

        if (faseCrescimento == FaseCultura.GERMINACAO) {
            fator = 0.5;
        } else if (faseCrescimento == FaseCultura.CRESCIMENTO) {
            fator = 1.0;
        } else if (faseCrescimento == FaseCultura.FLORACAO) {
            fator = 1.5;
        }   
        else if (faseCrescimento == FaseCultura.COLHEITA) {
            fator = 2.0;
        }

        if (necessidadeHidrica <= 0) {
        this.producaoEstimativa = 0;
        return;
        }

    this.producaoEstimativa = (100 / necessidadeHidrica) * fator;
    
}

public void atualizarFaseDeCrescimento() {

        if (faseCrescimento == FaseCultura.GERMINACAO) {
            faseCrescimento = FaseCultura.CRESCIMENTO;

        } else if (faseCrescimento == FaseCultura.CRESCIMENTO) {
            faseCrescimento = FaseCultura.FLORACAO;

        } else if (faseCrescimento == FaseCultura.FLORACAO) {
            faseCrescimento = FaseCultura.COLHEITA;

        } else if (faseCrescimento == FaseCultura.COLHEITA) {
            System.out.println("A cultura já está na fase de COLHEITA. Não é possível avançar para outra fase.");
        }
    }
 
}
