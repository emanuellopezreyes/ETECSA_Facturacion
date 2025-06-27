import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ClienteTest {
    @Test
    public void testAgregarFacturaValida() {
        Cliente cliente = new Cliente("C001", "Juan Pérez");
        Factura factura = new Factura("F001", "C001", 100.0, new Date());
        
        cliente.agregarFactura(factura);
        assertEquals(1, cliente.getFacturas().size());
    }

    @Test
    public void testNoAgregarFacturaDeOtroCliente() {
        Cliente cliente = new Cliente("C001", "Juan Pérez");
        Factura factura = new Factura("F001", "C002", 100.0, new Date());
        
        cliente.agregarFactura(factura);
        assertTrue(cliente.getFacturas().isEmpty());
    }
}