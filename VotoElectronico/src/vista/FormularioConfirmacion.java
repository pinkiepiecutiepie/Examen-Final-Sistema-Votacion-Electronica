package vista;

import controlador.ControladorVoto;
import controlador.ControladorEstudiante;
import modelo.Candidato;
import modelo.Estudiante;
import modelo.Voto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioConfirmacion extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorVoto controladorVoto;
    private ControladorEstudiante controladorEstudiante;
    private String cedulaEstudiante;
    private Candidato candidatoSeleccionado;

    public FormularioConfirmacion(ControladorVoto controladorVoto, ControladorEstudiante controladorEstudiante, String cedulaEstudiante, Candidato candidatoSeleccionado) {
        this.controladorVoto = controladorVoto;
        this.controladorEstudiante = controladorEstudiante;
        this.cedulaEstudiante = cedulaEstudiante;
        this.candidatoSeleccionado = candidatoSeleccionado;

        setTitle("Confirmación de Voto");
        setSize(300, 200);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new GridLayout(2, 1));

        JLabel confirmacionLabel = new JLabel("Gracias por tu voto a " + candidatoSeleccionado.getNombre());
        JButton finalizarButton = new JButton("Finalizar");

        finalizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVoto();
                JOptionPane.showMessageDialog(FormularioConfirmacion.this, "Voto registrado correctamente.");
                dispose();
            }
        });

        add(confirmacionLabel);
        add(finalizarButton);
    }

    private void registrarVoto() {
        Estudiante estudiante = controladorEstudiante.obtenerEstudiantes().stream()
                .filter(e -> e.getCedula().equals(cedulaEstudiante))
                .findFirst()
                .orElse(null);
        if (estudiante != null && candidatoSeleccionado != null) {
            Voto voto = new Voto(null, estudiante, candidatoSeleccionado);
            controladorVoto.registrarVoto(voto);
            controladorEstudiante.actualizarEstadoEstudiante(cedulaEstudiante, false); // Bloquear al estudiante
            System.out.println(voto);
        }
    }
}