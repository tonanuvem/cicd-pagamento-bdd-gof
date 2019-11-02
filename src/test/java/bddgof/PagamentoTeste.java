package bddgof;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class PagamentoTeste {

    protected long id;
    protected String statusPagamento;
    protected int valorPagamento;


    public PagamentoTeste() {
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    @Override
    public String toString() {
        return "PagamentoTeste{" +
                "id='" + id +
                ", statusPagamento=" + statusPagamento +
                ", valorPagamento=" + valorPagamento +
                '}';
    }
}
