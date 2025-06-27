import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientePanel extends JPanel {
    private ETECSAFacturacionService servicio;
    private JTextField idClienteField, nombreField;
    private JTextArea clientesArea;

    public ClientePanel(ETECSAFacturacionService servicio) {
        this.servicio = servicio;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        
        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        inputPanel.add(new JLabel("ID Cliente:"));
        idClienteField = new JTextField();
        inputPanel.add(idClienteField);
        
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);
        
        JButton agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });
        inputPanel.add(agregarButton);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // Área de visualización
        clientesArea = new JTextArea();
        clientesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(clientesArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarCliente() {
        String idCliente = idClienteField.getText();
        String nombre = nombreField.getText();
        
        if (idCliente.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // En un sistema real, aquí se guardaría el cliente en una base de datos
        clientesArea.append("Cliente agregado: " + idCliente + " - " + nombre + "\n");
        limpiarCampos();
    }

    private void limpiarCampos() {
        idClienteField.setText("");
        nombreField.setText("");
    }
}