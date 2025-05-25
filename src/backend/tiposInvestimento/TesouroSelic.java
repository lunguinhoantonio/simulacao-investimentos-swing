package tiposInvestimento;

public class TesouroSelic extends InvestimentoAnual {
    public TesouroSelic(double capital, int quantAnos) {
        super(capital, quantAnos);
        setNomeInvestimento("Tesouro Selic");
    }

    @Override
    public void calcRentabilidade() {
        setPorcRendimento(((getMontante() - getCapital()) / getCapital()) * 100);
    }

    @Override
    public void calcValorFinal() {
        setMontante(getCapital() * Math.pow(1 + getTaxa(), getTempoInvestido()));
        calcRentabilidade();
    }

    @Override
    public double getTaxa() {
        return 0.1475;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Taxa Selic: " + getTaxa() * 100 + "%";
    }
}