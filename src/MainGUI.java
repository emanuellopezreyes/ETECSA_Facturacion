import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private ETECSAFacturacionService servicio;
    private JTabbedPane tabbedPane;

    public MainGUI() {
        super("Sistema de Facturación ETECSA");
        servicio = new ETECSAFacturacionService();
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();
        
        // Crear los paneles
        FacturaPanel facturaPanel = new FacturaPanel(servicio);
        ClientePanel clientePanel = new ClientePanel(servicio);
        PagoPanel pagoPanel = new PagoPanel(servicio);
        
        // Añadir los paneles al tabbedPane
        tabbedPane.addTab("Facturas", facturaPanel);
        tabbedPane.addTab("Clientes", clientePanel);
        tabbedPane.addTab("Pagos", pagoPanel);
        
        add(tabbedPane, BorderLayout.CENTER);
        
        // Barra de estado
        JLabel statusLabel = new JLabel(" Sistema de Facturación ETECSA - Versión 1.0");
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainGUI().setVisible(true);
        });
    }
}