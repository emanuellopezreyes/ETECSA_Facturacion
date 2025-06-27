import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FacturaPanel extends JPanel {
    private ETECSAFacturacionService servicio;
    private JTextField idFacturaField, idClienteField, montoField;
    private JButton registrarButton;
    private JTextArea facturasArea;

    public FacturaPanel(ETECSAFacturacionService servicio) {
        this.servicio = servicio;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        inputPanel.add(new JLabel("ID Factura:"));
        idFacturaField = new JTextField();
        inputPanel.add(idFacturaField);
        
        inputPanel.add(new JLabel("ID Cliente:"));
        idClienteField = new JTextField();
        inputPanel.add(idClienteField);
        
        inputPanel.add(new JLabel("Monto:"));
        montoField = new JTextField();
        inputPanel.add(montoField);
        
        registrarButton = new JButton("Registrar Factura");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarFactura();
            }
        });
        inputPanel.add(registrarButton);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // Área de visualización
        facturasArea = new JTextArea();
        facturasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(facturasArea);
        add(scrollPane, BorderLayout.CENTER);
        
        // Botón para listar facturas
        JButton listarButton = new JButton("Listar Todas las Facturas");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarFacturas();
            }
        });
        add(listarButton, BorderLayout.SOUTH);
    }

    private void registrarFactura() {
        try {
            String idFactura = idFacturaField.getText();
            String idCliente = idClienteField.getText();
            double monto = Double.parseDouble(montoField.getText());
            
            Factura factura = new Factura(idFactura, idCliente, monto, new Date());
            servicio.registrarFactura(factura);
            
            JOptionPane.showMessageDialog(this, "Factura registrada exitosamente", 
                                         "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un número válido", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la factura: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarFacturas() {
        facturasArea.setText("");
        for (IFactura factura : servicio.consultarFacturasPorCliente(idClienteField.getText())) {
            facturasArea.append(factura.toString() + "\n");
        }
    }

    private void limpiarCampos() {
        idFacturaField.setText("");
        montoField.setText("");
    }
}