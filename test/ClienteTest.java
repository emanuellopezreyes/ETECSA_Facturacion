import org.junit.jupiter.api.Test;

public class ClienteTest {
    @Test
    void testAgregarFacturaValida() {
        Cliente cliente = new Cliente("C001", "Juan Pérez");
        Factura factura = new Factura("F001", "C001", 100.0, new Date());
        
        cliente.agregarFactura(factura);
        assertEquals(1, cliente.getFacturas().size());
    }

    @Test
    void testNoAgregarFacturaDeOtroCliente() {
        Cliente cliente = new Cliente("C001", "Juan Pérez");
        Factura factura = new Factura("F001", "C002", 100.0, new Date());
        
        cliente.agregarFactura(factura);
        assertTrue(cliente.getFacturas().isEmpty());
    }
}
