package vista;

import controlador.ControladorEstudiante;
import modelo.Curso;
import modelo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioEstudiantes extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorEstudiante controladorEstudiante;
    private JTextField cedulaField, nombreField;
    private JComboBox<Curso> cursoComboBox;

    public FormularioEstudiantes(ControladorEstudiante controladorEstudiante, java.util.List<Curso> cursos) {
        this.controladorEstudiante = controladorEstudiante;
        setTitle("Agregar Estudiante");
        setSize(300, 200);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(4, 2));

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel cursoLabel = new JLabel("Curso:");
        cursoComboBox = new JComboBox<>(cursos.toArray(new Curso[0]));
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEstudiante();
            }
        });

        add(cedulaLabel);
        add(cedulaField);
        add(nombreLabel);
        add(nombreField);
        add(cursoLabel);
        add(cursoComboBox);
        add(agregarButton);
    }

    private void agregarEstudiante() {
        String cedula = cedulaField.getText().trim();
        String nombre = nombreField.getText().trim();
        Curso curso = (Curso) cursoComboBox.getSelectedItem();

        if (cedula.isEmpty() || nombre.isEmpty() || curso == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Long id = obtenerNuevoId();
        Boolean estado = true;

        Estudiante estudiante = new Estudiante(id, nombre, cedula, estado, curso);
        controladorEstudiante.agregarEstudiante(estudiante);
        JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
        limpiarCampos();
    }

    private Long obtenerNuevoId() {
        return System.currentTimeMillis();
    }

    private void limpiarCampos() {
        cedulaField.setText("");
        nombreField.setText("");
        cursoComboBox.setSelectedIndex(0);
    }
}