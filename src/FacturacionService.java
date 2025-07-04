import java.util.List;

/**
 * Interfaz del servicio de facturación.
 * Responsable: Alonso Pérez Carlos Manuel
 * Fecha de entrega: 14/06/2023
 */
public interface FacturacionService {
    void registrarFactura(IFactura factura);
    boolean realizarPago(String idFactura);
    List<IFactura> consultarFacturasPorCliente(String idCliente);
}
