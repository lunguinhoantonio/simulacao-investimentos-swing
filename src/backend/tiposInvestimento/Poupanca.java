package tiposInvestimento;

public class Poupanca extends InvestimentoMensal {

    public Poupanca(double capital, int quantMeses) {
        super(capital, quantMeses);
        setNomeInvestimento("Poupança");
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
        return 0.006743;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Taxa " + getNomeInvestimento() + ": " + getTaxa() * 100 + "%";
    }
}