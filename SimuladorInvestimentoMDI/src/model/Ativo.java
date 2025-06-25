package model;

public abstract class Ativo {
    private String nome;
    private double valorInvestido;
    

    public Ativo(String nome) {
        this.nome = nome;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) throws RuntimeException {
        if (valorInvestido <= 0) {
            throw new RuntimeException("Valor investido inválido.");
        }
        this.valorInvestido = valorInvestido;
    }
    
}