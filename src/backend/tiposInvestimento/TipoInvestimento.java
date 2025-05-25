package tiposInvestimento;

public abstract class TipoInvestimento {
    private double capital, montante, porcRendimento;
    private String nomeInvestimento, textoTempoInvestido;
    private static int contador = 1;
    private final int id;

    public TipoInvestimento(double capital) {
        this.capital = capital;
        this.id = contador++;
    }

    public abstract void calcRentabilidade();
    public abstract void calcValorFinal();
    public abstract int getTempoInvestido();
    public abstract void setTempoInvestido(int tempo);

    public double getCapital() {
        return capital;
    }

    public int getId() {
        return id;
    }

    public void setCapital(double capital) {
        this.capital = capital;
        calcValorFinal();
        calcRentabilidade();
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public double getPorcRendimento() {
        return porcRendimento;
    }

    public void setPorcRendimento(double porcRendimento) {
        this.porcRendimento = porcRendimento;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public String getTextoTempoInvestido() {
        return textoTempoInvestido;
    }

    public void setTextoTempoInvestido(String textoTempoInvestido) {
        this.textoTempoInvestido = textoTempoInvestido;
    }

    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    public abstract double getTaxa();

    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Tipo do Investimento: " + getNomeInvestimento() +
                ", Valor inicial: R$" + String.format("%.2f", getCapital()) +
                ", Valor final: R$" + String.format("%.2f", getMontante()) +
                ", Rendimento: " + String.format("%.2f", getPorcRendimento()) + "%" +
                ", Tempo: ";
    }
}