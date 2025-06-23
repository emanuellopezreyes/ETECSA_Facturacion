import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del servicio de facturación.
 * Responsable: Alonso Pérez Carlos Manuel
 * Fecha de entrega: 14/06/2023
 */
public class ETECSAFacturacionService implements FacturacionService {
    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void registrarFactura(Factura factura) {
        if (factura != null) {
            facturas.add(factura);
        }
    }

    @Override
    public boolean realizarPago(String idFactura) {
        for (Factura factura : facturas) {
            if (factura.getIdFactura().equals(idFactura)) {
                factura.marcarComoPagada();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Factura> consultarFacturasPorCliente(String idCliente) {
        List<Factura> resultado = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getIdCliente().equals(idCliente)) {
                resultado.add(factura);
            }
        }
        return resultado;
    }
}
