package tiposInvestimento;

import java.util.Random;
public class Acao extends InvestimentoMensal {
    Random random = new Random();
    public Acao(double capital, int quantMeses) {
        super(capital, quantMeses);
        setNomeInvestimento("Ações");
    }

    @Override
    public void calcRentabilidade() {
        setPorcRendimento(((getMontante() - getCapital()) / getCapital()) * 100);
    }

    @Override
    public void calcValorFinal() {
        setMontante(getCapital());
        for (int i = 0; i < getTempoInvestido(); i++) {
            int subiuOuNao = random.nextInt(2);
            boolean subiu = subiuOuNao == 1;
            double porcAlteracao = random.nextDouble(21);
            if (subiu) {
                setMontante(getMontante() * (1 + (porcAlteracao / 100)));
            } else {
                setMontante(getMontante() * (1 - (porcAlteracao / 100)));
            }
        }
        calcRentabilidade();
    }

    @Override
    public double getTaxa() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}