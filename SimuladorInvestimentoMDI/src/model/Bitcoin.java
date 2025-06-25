package model;

import java.util.ArrayList;

/*      RENDIMENTOS BITCOIN
COTAÇÃO DO DOLAR = R$5,72 - 22/04/2025
0,4978 reais    - 30/12/2010 | 577.825,28 reais - 31/12/2024 | JUROS = 1.160.757,894736842
873,82 reais    - 26/12/2014 | 577.825,28 reais - 31/12/2024 | JUROS = 661,2635096472958
29.611,82 reais - 28/12/2019 | 577.825,28 reais - 31/12/2024 | JUROS = 19,51333217613777
DADOS RETIRADOS DO SITE COINMARKETCAP
(https://coinmarketcap.com/currencies/bitcoin/)
 */

public class Bitcoin extends Ativo implements Operacoes {
    private ArrayList<DadosJuros> inflacao = new ArrayList<>();
    private ArrayList<DadosJuros> rendimento = new ArrayList<>();
    private static final String NOME_ATIVO = "Bitcoin";

    public Bitcoin() {
        super(NOME_ATIVO);
    }

    @Override
    public void dadosInvestimento() {
        
        rendimento.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 19.51333217613777));
        rendimento.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 661.2635096472958));
        rendimento.add(new DadosJuros("14 anos - 12/2010 | 12/2024", 1160757.894736842));

        inflacao.add(new DadosJuros("05 anos - 12/2019 | 12/2024", 1.61058320));
        inflacao.add(new DadosJuros("10 anos - 12/2014 | 12/2024", 2.15866780));
        inflacao.add(new DadosJuros("14 anos - 12/2010 | 12/2024", 2.67787550));

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
