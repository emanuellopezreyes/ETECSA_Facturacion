import java.util.Date;
import java.util.List;

/**
 * Clase principal para ejecutar el sistema.
 * Responsable: López Reyes Emanuel
 * Fecha de entrega: 15/06/2023
 */
public class Main {
    public static void main(String[] args) {
        // Crear servicio
        ETECSAFacturacionService servicio = new ETECSAFacturacionService();

        // Registrar facturas
        Factura factura1 = new Factura("F001", "C001", 150.50, new Date());
        Factura factura2 = new Factura("F002", "C001", 200.75, new Date());
        servicio.registrarFactura(factura1);
        servicio.registrarFactura(factura2);

        // Realizar pago
        servicio.realizarPago("F001");

        // Consultar facturas
        List<Factura> facturasCliente = servicio.consultarFacturasPorCliente("C001");
        System.out.println("=== Facturas del Cliente C001 ===");
        for (Factura factura : facturasCliente) {
            System.out.println(factura);
        }
    }
}
