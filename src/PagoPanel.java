import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagoPanel extends JPanel {
    private ETECSAFacturacionService servicio;
    private JTextField idFacturaField;
    private JTextArea resultadoArea;

    public PagoPanel(ETECSAFacturacionService servicio) {
        this.servicio = servicio;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        
        inputPanel.add(new JLabel("ID Factura:"));
        idFacturaField = new JTextField();
        inputPanel.add(idFacturaField);
        
        JButton pagarButton = new JButton("Realizar Pago");
        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPago();
            }
        });
        inputPanel.add(pagarButton);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // Área de resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void realizarPago() {
        String idFactura = idFacturaField.getText();
        
        if (idFactura.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID de factura es requerido", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean resultado = servicio.realizarPago(idFactura);
        
        if (resultado) {
            resultadoArea.append("Pago realizado con éxito para la factura: " + idFactura + "\n");
        } else {
            resultadoArea.append("No se encontró la factura con ID: " + idFactura + "\n");
        }
        
        idFacturaField.setText("");
    }
}