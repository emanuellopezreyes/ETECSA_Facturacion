import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class PagoTest {
    @Test
    public void testPagoExitoso() {
        ETECSAFacturacionService servicio = new ETECSAFacturacionService();
        Factura factura = new Factura("F001", "C001", 100.0, new Date());
        servicio.registrarFactura(factura);
        
        assertTrue(servicio.realizarPago("F001"));
        assertTrue(factura.isPagada());
    }

    @Test
    public void testPagoFacturaInexistente() {
        ETECSAFacturacionService servicio = new ETECSAFacturacionService();
        assertFalse(servicio.realizarPago("F999"));
    }
}