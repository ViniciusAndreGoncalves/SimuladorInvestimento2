package model;

import java.util.ArrayList;

/*  
        RENDIMENTO TESOURO SELIC
    286.115809% - 15 anos - 12/2009 | 12/2024 - 3.86115809
    142,014757% - 10 anos - 12/2014 | 12/2024 - 2.42014757
    51,108591%  - 05 anos - 12/2019 | 12/2024 - 1.51108591

    DADOS RETIRADOS DA CALCULADORA DO BANCO CENTRAL DO BRASIL
    (https://www3.bcb.gov.br/CALCIDADAO/publico/exibirFormCorrecaoValores.do?method=exibirFormCorrecaoValores&aba=4)
*/
public class RendaFixa extends Ativo implements Operacoes{

    private ArrayList<DadosJuros> inflacao = new ArrayList<>();
    private ArrayList<DadosJuros> rendimento = new ArrayList<>();
    private static final String NOME_ATIVO = "Tesouro SELIC";

    public RendaFixa() {
        super(NOME_ATIVO);
    }

    @Override
    public void dadosInvestimento() {
        
        rendimento.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 1.51108591));
        rendimento.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 2.42014757));
        rendimento.add(new DadosJuros("15 anos - 12/2009 | 12/2024", 3.86115809));

        inflacao.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 1.61058320));
        inflacao.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 2.15866780));
        inflacao.add(new DadosJuros("15 anos - 12/2009 | 12/2024", 2.9529476));

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
            sb.append(String.format("  Inflação do período: %.2f%%\n", (dadoInflacao.getJuros() * 100) - 100));
            sb.append(String.format("  Valor corrigido pela inflação: R$ %.2f\n", valorCorrigidoInflacao));
            sb.append(String.format("  ► Rendimento real(SEM IMPOSTOS): R$ %.2f\n", rendimentoReal));
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}
