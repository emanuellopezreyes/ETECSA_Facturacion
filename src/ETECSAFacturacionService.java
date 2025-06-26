import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del servicio de facturación.
 * Responsable: Alonso Pérez Carlos Manuel
 * Fecha de entrega: 14/06/2023
 */
public class ETECSAFacturacionService implements FacturacionService {
    private List<IFactura> facturas = new ArrayList<>();

    @Override
    public void registrarFactura(IFactura factura) {
        if (factura != null) {
            facturas.add(factura);
        }
    }

    @Override
    public boolean realizarPago(String idFactura) {
        for (IFactura factura : facturas) {
            if (factura.getIdFactura().equals(idFactura)) {
                factura.marcarComoPagada();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<IFactura> consultarFacturasPorCliente(String idCliente) {
        List<IFactura> resultado = new ArrayList<>();
        for (IFactura factura : facturas) {
            if (factura.getIdCliente().equals(idCliente)) {
                resultado.add(factura);
            }
        }
        return resultado;
    }
}
