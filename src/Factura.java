import java.util.Date;

public class Factura implements IFactura {
    private String idFactura;
    private String idCliente;
    private double monto;
    private Date fechaEmision;
    private boolean pagada;

    public Factura(String idFactura, String idCliente, double monto, Date fechaEmision) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.pagada = false;
    }

    public String getIdFactura() { return idFactura; }
    public String getIdCliente() { return idCliente; }
    public double getMonto() { return monto; }
    public Date getFechaEmision() { return fechaEmision; }
    public boolean isPagada() { return pagada; }

    public void setMonto(double monto) { this.monto = monto; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }
    
    public void marcarComoPagada() {
        this.pagada = true;
    }

    @Override
    public String toString() {
        return String.format(
            "Factura ID: %s | Cliente: %s | Monto: %.2f | %s",
            idFactura, idCliente, monto, pagada ? "Pagada" : "Pendiente"
        );
    }
}
