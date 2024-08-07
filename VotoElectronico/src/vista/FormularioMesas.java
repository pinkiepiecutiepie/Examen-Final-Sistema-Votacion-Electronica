package vista;

import controlador.ControladorMesa;
import modelo.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioMesas extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorMesa controladorMesa;
    private JTextField idField, nombreField, presidenteField, secretarioField;

    public FormularioMesas(ControladorMesa controladorMesa) {
        this.controladorMesa = controladorMesa;
        setTitle("Agregar Mesa");
        setSize(300, 200);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel presidenteLabel = new JLabel("Presidente:");
        presidenteField = new JTextField();
        JLabel secretarioLabel = new JLabel("Secretario:");
        secretarioField = new JTextField();
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMesa();
            }
        });

        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(presidenteLabel);
        add(presidenteField);
        add(secretarioLabel);
        add(secretarioField);
        add(agregarButton);
    }

    private void agregarMesa() {
        try {
            String idText = idField.getText().trim();
            String nombre = nombreField.getText().trim();
            String presidente = presidenteField.getText().trim();
            String secretario = secretarioField.getText().trim();

            if (idText.isEmpty() || nombre.isEmpty() || presidente.isEmpty() || secretario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long id = Long.parseLong(idText);
            Mesa mesa = new Mesa(id, nombre, presidente, secretario);
            controladorMesa.agregarMesa(mesa);
            JOptionPane.showMessageDialog(this, "Mesa agregada correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        presidenteField.setText("");
        secretarioField.setText("");
    }
}