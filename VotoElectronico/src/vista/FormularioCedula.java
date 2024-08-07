package vista;

import controlador.ControladorCandidato;
import controlador.ControladorEstudiante;
import controlador.ControladorVoto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCedula extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorEstudiante controladorEstudiante;
    private ControladorVoto controladorVoto;
    private ControladorCandidato controladorCandidato;
    private JTextField cedulaField;

    public FormularioCedula(ControladorEstudiante controladorEstudiante, ControladorVoto controladorVoto, ControladorCandidato controladorCandidato) {
        this.controladorEstudiante = controladorEstudiante;
        this.controladorVoto = controladorVoto;
        this.controladorCandidato = controladorCandidato;
        setTitle("Ingreso de Cédula");
        setSize(300, 200);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(2, 2));

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaField = new JTextField();
        JButton enviarButton = new JButton("Enviar");

        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioVotacion();
            }
        });

        add(cedulaLabel);
        add(cedulaField);
        add(enviarButton);
    }

    private void mostrarFormularioVotacion() {
        String cedula = cedulaField.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La cédula no puede estar vacía.");
            return;
        }
        if (controladorEstudiante.obtenerEstudiantes().stream().noneMatch(e -> e.getCedula().equals(cedula))) {
            JOptionPane.showMessageDialog(this, "Cédula no encontrada.");
            return;
        } else {
            FormularioVotacion formulario = new FormularioVotacion(controladorEstudiante, controladorVoto, controladorCandidato, cedula);
            getDesktopPane().add(formulario);
            formulario.setVisible(true);
            dispose();
        }
    }
}