import java.util.Date;

public interface IFactura {
    String getIdFactura();
    String getIdCliente();
    double getMonto();
    Date getFechaEmision();
    boolean isPagada();
    void setMonto(double monto);
    void setFechaEmision(Date fechaEmision);
    void marcarComoPagada();
}
