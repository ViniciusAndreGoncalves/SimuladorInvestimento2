package model;
/*
Dados da inflação do real foram extraídos do site do Banco Central do Brasil
(https://www3.bcb.gov.br/CALCIDADAO/publico/exibirFormCorrecaoValores.do?method=exibirFormCorrecaoValores&aba=1)
*/
public class DadosJuros {
    private String duracao;
    private double juros;

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public DadosJuros(String duracao, double juros) {
        this.duracao = duracao;
        this.juros = juros;
    }

}