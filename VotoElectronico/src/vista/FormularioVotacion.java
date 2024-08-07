package vista;

import controlador.ControladorCandidato;
import controlador.ControladorEstudiante;
import controlador.ControladorVoto;
import modelo.Candidato;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormularioVotacion extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorEstudiante controladorEstudiante;
    private ControladorVoto controladorVoto;
    private ControladorCandidato controladorCandidato;
    private String cedulaEstudiante;
    private JComboBox<Candidato> candidatoComboBox;

    public FormularioVotacion(ControladorEstudiante controladorEstudiante, ControladorVoto controladorVoto, ControladorCandidato controladorCandidato, String cedulaEstudiante) {
        this.controladorEstudiante = controladorEstudiante;
        this.controladorVoto = controladorVoto;
        this.controladorCandidato = controladorCandidato;
        this.cedulaEstudiante = cedulaEstudiante;

        setTitle("Votación");
        setSize(400, 300);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(3, 1));

        JLabel saludoLabel = new JLabel("Bienvenido, " + obtenerNombreEstudiante() + ", escoge un candidato:");

        List<Candidato> candidatos = obtenerCandidatos();
        if (candidatos != null && !candidatos.isEmpty()) {
            candidatoComboBox = new JComboBox<>(candidatos.toArray(new Candidato[0]));
        } else {
            candidatoComboBox = new JComboBox<>();
            candidatoComboBox.addItem(new Candidato(0L, "No hay candidatos disponibles", "", ""));
        }

        JButton votarButton = new JButton("Votar");

        votarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Candidato candidatoSeleccionado = (Candidato) candidatoComboBox.getSelectedItem();
                if (candidatoSeleccionado != null) {
                    mostrarFormularioConfirmacion(candidatoSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(FormularioVotacion.this, "Por favor, selecciona un candidato.");
                }
            }
        });

        add(saludoLabel);
        add(candidatoComboBox);
        add(votarButton);
    }

    private List<Candidato> obtenerCandidatos() {
        return controladorCandidato.obtenerCandidatos();
    }

    private String obtenerNombreEstudiante() {
        return controladorEstudiante.obtenerEstudiantes().stream()
            .filter(e -> e.getCedula().equals(cedulaEstudiante))
            .map(e -> e.getNombre())
            .findFirst()
            .orElse("Desconocido");
    }

    private void mostrarFormularioConfirmacion(Candidato candidatoSeleccionado) {
        FormularioConfirmacion formulario = new FormularioConfirmacion(controladorVoto, controladorEstudiante, cedulaEstudiante, candidatoSeleccionado);
        getDesktopPane().add(formulario);
        formulario.setVisible(true);
        dispose();
    }
}