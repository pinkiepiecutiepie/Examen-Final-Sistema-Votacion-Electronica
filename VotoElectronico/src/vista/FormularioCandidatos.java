package vista;

import controlador.ControladorCandidato;
import modelo.Candidato;
import modelo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCandidatos extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorCandidato controladorCandidato;
    private JTextField idField, nombrePartidoField, fotoField;
    private JComboBox<Estudiante> estudianteComboBox;

    public FormularioCandidatos(ControladorCandidato controladorCandidato, java.util.List<Estudiante> estudiantes) {
        this.controladorCandidato = controladorCandidato;
        setTitle("Agregar Candidato");
        setSize(300, 250);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nombrePartidoLabel = new JLabel("Nombre Partido:");
        nombrePartidoField = new JTextField();
        JLabel fotoLabel = new JLabel("Foto:");
        fotoField = new JTextField();
        JLabel estudianteLabel = new JLabel("Estudiante:");
        estudianteComboBox = new JComboBox<>(estudiantes.toArray(new Estudiante[0]));
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCandidato();
            }
        });

        add(idLabel);
        add(idField);
        add(nombrePartidoLabel);
        add(nombrePartidoField);
        add(fotoLabel);
        add(fotoField);
        add(estudianteLabel);
        add(estudianteComboBox);
        add(agregarButton);
    }

    private void agregarCandidato() {
        try {
            String idText = idField.getText().trim();
            String nombrePartido = nombrePartidoField.getText().trim();
            String foto = fotoField.getText().trim();
            Estudiante estudiante = (Estudiante) estudianteComboBox.getSelectedItem();

            if (idText.isEmpty() || nombrePartido.isEmpty() || foto.isEmpty() || estudiante == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long id = Long.parseLong(idText);
            String nombre = estudiante.getNombre();

            Candidato candidato = new Candidato(id, nombre, foto, nombrePartido);
            controladorCandidato.agregarCandidatoComoEstudiante(candidato);
            controladorCandidato.agregarCandidato(candidato);
            JOptionPane.showMessageDialog(this, "Candidato agregado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombrePartidoField.setText("");
        fotoField.setText("");
        estudianteComboBox.setSelectedIndex(0);
    }
}
