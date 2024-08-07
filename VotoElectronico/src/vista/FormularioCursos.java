package vista;

import controlador.ControladorCurso;
import modelo.Curso;
import modelo.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCursos extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorCurso controladorCurso;
    private JTextField idField, nombreField;
    private JComboBox<Mesa> mesaComboBox;

    public FormularioCursos(ControladorCurso controladorCurso, java.util.List<Mesa> mesas) {
        this.controladorCurso = controladorCurso;
        setTitle("Agregar Curso");
        setSize(300, 200);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel mesaLabel = new JLabel("Mesa:");
        mesaComboBox = new JComboBox<>(mesas.toArray(new Mesa[0]));
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCurso();
            }
        });

        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(mesaLabel);
        add(mesaComboBox);
        add(agregarButton);
    }

    private void agregarCurso() {
        try {
            String idText = idField.getText().trim();
            String nombre = nombreField.getText().trim();
            Mesa mesa = (Mesa) mesaComboBox.getSelectedItem();

            if (idText.isEmpty() || nombre.isEmpty() || mesa == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long id = Long.parseLong(idText);
            Curso curso = new Curso(id, nombre, mesa);
            controladorCurso.agregarCurso(curso);
            JOptionPane.showMessageDialog(this, "Curso agregado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        mesaComboBox.setSelectedIndex(0);
    }
}