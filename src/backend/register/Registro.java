package register;
import tiposInvestimento.TipoInvestimento;
import java.util.ArrayList;
import java.util.List;
public class Registro {
    List<TipoInvestimento> registros = new ArrayList<>();

    public void add(TipoInvestimento simulacao) {
        registros.add(simulacao);
    }

    public void remove(int index) {
        registros.remove(index);
    }

    public int size() {
        return registros.size();
    }

    public List<TipoInvestimento> getRegistros() {
        return new ArrayList<>(registros);
    }

    public boolean isEmpty() {
        return registros.isEmpty();
    }

    public TipoInvestimento get(int index) {
        return registros.get(index);
    }

    public int exists(int idSimulacaoAProcurar) {
        int index = 0;
        for (TipoInvestimento t : registros) {
            if (t.getId() == idSimulacaoAProcurar) return index;
            index++;
        }
        return -1;
    }
}
