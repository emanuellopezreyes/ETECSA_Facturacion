import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PagoTest {
    @Test
    void testPagoExitoso() {
        FacturacionService servicio = new ETECSAFacturacionService();
        Factura factura = new Factura("F001", "C001", 100.0, new Date());
        servicio.registrarFactura(factura);
        
        assertTrue(servicio.realizarPago("F001"));
        assertTrue(factura.isPagada());
    }

    @Test
    void testPagoFacturaInexistente() {
        FacturacionService servicio = new ETECSAFacturacionService();
        assertFalse(servicio.realizarPago("F999"));
    }
}
