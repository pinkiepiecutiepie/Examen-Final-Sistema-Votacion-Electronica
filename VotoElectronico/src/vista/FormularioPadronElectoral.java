package vista;

import javax.swing.*;

import controlador.ControladorCandidato;
import controlador.ControladorCurso;
import controlador.ControladorEstudiante;
import controlador.ControladorMesa;
import modelo.Candidato;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Mesa;

import java.awt.*;
import java.util.List;

public class FormularioPadronElectoral extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private ControladorEstudiante controladorEstudiante;
    private ControladorMesa controladorMesa;
    private ControladorCurso controladorCurso;
    private ControladorCandidato controladorCandidato;

    public FormularioPadronElectoral(ControladorEstudiante controladorEstudiante, ControladorMesa controladorMesa,
                                     ControladorCurso controladorCurso, ControladorCandidato controladorCandidato) {
        this.controladorEstudiante = controladorEstudiante;
        this.controladorMesa = controladorMesa;
        this.controladorCurso = controladorCurso;
        this.controladorCandidato = controladorCandidato;

        setTitle("Padrón Electoral");
        setSize(600, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new BorderLayout());

        JTextArea padronArea = new JTextArea();
        padronArea.setText(obtenerPadronElectoral());
        padronArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(padronArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private String obtenerPadronElectoral() {
        StringBuilder sb = new StringBuilder();

        sb.append("Mesas:\n");
        List<Mesa> mesas = controladorMesa.obtenerMesas();
        for (Mesa mesa : mesas) {
            sb.append("Mesa ID: ").append(mesa.getId()).append(", Ubicación: ").append(mesa.getNombre()).append("\n");
        }

        sb.append("\nCursos:\n");
        List<Curso> cursos = controladorCurso.obtenerCursos();
        for (Curso curso : cursos) {
            sb.append("Curso ID: ").append(curso.getId()).append(", Nombre: ").append(curso.getNombre()).append("\n");
        }

        sb.append("\nEstudiantes:\n");
        List<Estudiante> estudiantes = controladorEstudiante.obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            sb.append("Cédula: ").append(estudiante.getCedula()).append(", Nombre: ").append(estudiante.getNombre()).append("\n");
        }

        sb.append("\nCandidatos:\n");
        List<Candidato> candidatos = controladorCandidato.obtenerCandidatos();
        for (Candidato candidato : candidatos) {
            sb.append("Cédula: ").append(candidato.getId()).append(", Nombre: ").append(candidato.getNombre()).append("\n");
        }

        return sb.toString();
    }
}