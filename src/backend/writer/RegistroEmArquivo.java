package writer;

import register.Registro;
import tiposInvestimento.TipoInvestimento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroEmArquivo extends Registro {
    public RegistroEmArquivo(Registro registros) {
        String nomeArquivo = "registros.txt";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (TipoInvestimento r : registros.getRegistros()) {
                escritor.write("ID: " + r.getId() + ", Tipo do Investimento: " + r.getNomeInvestimento() + ", Valor inicial: R$" + String.format("%.2f", r.getCapital()) + ", Valor final: R$" + String.format("%.2f", r.getMontante()) + ", Rendimento: " + String.format("%.2f", r.getPorcRendimento()) + "%, Tempo: " + r.getTempoInvestido());
                boolean isAnual = r.getClass().getSuperclass().getSimpleName().equals("InvestimentoAnual");
                boolean isSingular = r.getTempoInvestido() == 1;
                if (isAnual && isSingular) escritor.write(" ano");
                else if (isAnual) escritor.write(" anos");
                else if (!isSingular) escritor.write(" meses");
                else escritor.write(" mês");
                escritor.write(", Taxa " + r.getNomeInvestimento() + ": " + (r.getTaxa() == 0 ? "Inexistente" : r.getTaxa() * 100 + "%"));
                escritor.newLine();
            }
            System.out.println("Listagem das simulações foi exportado para \"" + nomeArquivo + "\"!");
        } catch (IOException erro) {
            System.out.println("Houve um problema ao gravar o arquivo.");
            erro.printStackTrace();
        }

    }
}
