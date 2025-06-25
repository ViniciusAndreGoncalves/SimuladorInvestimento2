package model;

import java.util.ArrayList;

/*
    O ETF PIBB11 é um fundo de índice negociado na bolsa brasileira (B3) 
    que busca replicar o desempenho do índice IBRX50, que é composto pelas 50 empresas 
    mais negociadas aqui na bolsa brasileira. Esse índice é um dos mais importantes 
    e acompanhados do Brasil, servindo como referência para o desempenho do mercado 
    acionário brasileiro.
*/
/*  
        RENDIMENTO PIBB11
    132.82% - 15 anos - 12/2009 | 12/2024
    152.17% - 10 anos - 12/2014 | 12/2024
    16.42%  - 5 anos  - 12/2019 | 12/2024
    dado capturado * valor investido

    DADOS RETIRADOS DO GOOGLE FINANCE
    (https://www.google.com/finance/quote/PIBB11:BVMF?sa=X&ved=2ahUKEwjnm6PP2eqMAxVeP7kGHR_EDvoQ3ecFegQIJxAX&window=MAX)
*/
public class RendaVariavel extends Ativo implements Operacoes {

    private ArrayList<DadosJuros> inflacao = new ArrayList<>();
    private ArrayList<DadosJuros> rendimento = new ArrayList<>();
    private static final String NOME_ATIVO = "PIBB11";
    
    public RendaVariavel() {
        super(NOME_ATIVO);
    }

    @Override
    public void dadosInvestimento() {

        /*
         Bom, se por exemplo, em 12/2014 eu investisse 1000 reais no PIBB11, ele me renderia até 12/2024 152,17% de 1000 reais, que resulta nominalmente em 2.521,7 reais. Só que 1000 reais em 2014 equivalem a aproximadamente 2.158,67 reais em 12/2024. Ou seja, o meu rendimento real em 5 anos foi positivo em aproximadamente 363,03 reais.
         Logo, eu preciso que realize exatamente esse mesmo procedimento em todos os 3 períodos que destaquei(5, 10 e 15 anos).
         Rendimento nominal = valor investido * juros rendimento
         Inflação = valor investido * juros inflação
         Rendimento real = Rendimento nominal - Inflação
         */
    
        // Rendimento acumulado em cada período
        rendimento.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 1.1642));
        rendimento.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 2.5217));
        rendimento.add(new DadosJuros("15 anos - 12/2009 | 12/2024", 2.3282));

        // Inflação acumulada em cada período
        inflacao.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 1.61058320));
        inflacao.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 2.15866780));
        inflacao.add(new DadosJuros("15 anos - 12/2009 | 12/2024", 2.9529476));

    }


    @Override
    public String mostrarInvestimento() {

        dadosInvestimento(); // Carrega os dados
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
            sb.append(String.format("  Rentabilidade: %.2f%%\n", (dadoRendimento.getJuros() * 100)- 100));
            sb.append(String.format("  Rendimento nominal: R$ %.2f\n", rendimentoNominal));
            sb.append(String.format("  Inflação do período: %.2f%%\n", (dadoInflacao.getJuros() * 100) - 100));
            sb.append(String.format("  Valor corrigido pela inflação: R$ %.2f\n", valorCorrigidoInflacao));
            sb.append(String.format("  ► Rendimento real(SEM IMPOSTOS): R$ %.2f\n", rendimentoReal));
            sb.append("\n");
        }
        
        return sb.toString();
    }

}
