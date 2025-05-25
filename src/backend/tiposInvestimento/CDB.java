package tiposInvestimento;

public class CDB extends InvestimentoAnual {
    public CDB(double capital, int quantAnos) {
        super(capital, quantAnos);
        setNomeInvestimento("CDB");
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
        return 0.1146;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Taxa CDI: " + String.format("%.2f", getTaxa() * 100) + "%";
    }
}