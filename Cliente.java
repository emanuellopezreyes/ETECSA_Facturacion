import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Factura> facturas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        if (factura != null && factura.getIdCliente().equals(this.idCliente)) {
            facturas.add(factura);
        }
    }

    public List<Factura> getFacturas() {
        return new ArrayList<>(facturas); // Copia para evitar modificaciones externas
    }

    // Getters
    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
} 
