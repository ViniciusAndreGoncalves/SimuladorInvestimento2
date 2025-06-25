package model;

import java.util.ArrayList;

/*
    IVVB11 é um ETF que busca obter desempenho igual ou superior ao da carteira de ativos do S&P 500, o índice mais importante do mercado de ações dos Estados Unidos.
    Para obter esse desempenho, o fundo investe no mínimo 95% de seu patrimônio em ações do S&P 500 em qualquer proporção.

    O índice S&P 500 é um índice de mercado que mede o retorno de um investimento em uma carteira teórica calculada pela Standard & Poor’s, voltado ao setor de mercado de grande capitalização, na qual contém as 500 maiores companhias do mercado norte americano
    (https://investidor10.com.br/etfs/ivvb11/)
    O gestor é a BlackRock Brasil.
    (https://www.infomoney.com.br/cotacoes/b3/etf/etf-ivvb11/)
*/
/*  
        RENDIMENTO IVVB11
    74,31 reais  | 339,25 reais - 9 anos - 13/05/2016 | 22/04/2025 | JUROS = 4,565334409904454
    169,28 reais | 339,25 reais - 5 anos - 22/04/2020 | 22/04/2025 | JUROS = 2,004076086956522
    

    DADOS RETIRADOS DO GOOGLE FINANCE E STATUS INVEST
    (https://www.google.com/finance/quote/IVVB11:BVMF?sa=X&ved=2ahUKEwi4mZ_Rke2MAxXfD7kGHTYtFDcQ3ecFegQILxAX&window=MAX)
    (https://statusinvest.com.br/etfs/ivvb11)
*/

public class RendaVariavelUSA extends Ativo implements Operacoes {
    private ArrayList<DadosJuros> inflacao = new ArrayList<>();
    private ArrayList<DadosJuros> rendimento = new ArrayList<>();
    private static final String NOME_ATIVO = "IVVB11";
    
    public RendaVariavelUSA() {
        super(NOME_ATIVO);
    }

    @Override
    public void dadosInvestimento() {

        rendimento.add(new DadosJuros("5 anos - 22/04/2020 | 22/04/2025", 2.004076086956522));
        rendimento.add(new DadosJuros("9 anos - 13/05/2016 | 22/04/2025", 4.565334409904454));

        inflacao.add(new DadosJuros("5 anos - 04/2020 | 03/2025", 1.56680850));
        inflacao.add(new DadosJuros("9 anos - 05/2016 | 03/2025", 1.89734470));

    }


    @Override
    public String mostrarInvestimento() {

        dadosInvestimento(); // Carrega os dados do rendimento do ativo e da inflação
        StringBuilder sb = new StringBuilder();
        
        sb.append("→ SIMULAÇÃO DO INVESTIMENTO EM ").append(getNome().toUpperCase()).append("\n");
        sb.append(String.format("  Valor investido: R$ %.2f\n\n", getValorInvestido()));
        
        for (int i = 0; i < rendimento.size(); i++) {
            DadosJuros dadoRendimento = rendimento.get(i);
            DadosJuros dadoInflacao = inflacao.get(i);
        
            double valorInvestido = getValorInvestido();
        
            double rendimentoNominal = valorInvestido * (dadoRendimento.getJuros());
            double valorCorrigidoInflacao = valorInvestido * (dadoInflacao.getJuros());
            double rendimentoReal = rendimentoNominal - valorCorrigidoInflacao;
        
            sb.append(dadoRendimento.getDuracao()).append("\n");
            sb.append(String.format("  Rentabilidade: %.2f%%\n", (dadoRendimento.getJuros() * 100) - 100));
            sb.append(String.format("  Rendimento nominal: R$ %.2f\n", rendimentoNominal));
            sb.append(String.format("  Inflação do período: %.2f%%\n", (dadoInflacao.getJuros() * 100)- 100));
            sb.append(String.format("  Valor corrigido pela inflação: R$ %.2f\n", valorCorrigidoInflacao));
            sb.append(String.format("  ► Rendimento real(SEM IMPOSTOS): R$ %.2f\n", rendimentoReal));
            sb.append("\n");
        }
        
        return sb.toString();
    }

}
