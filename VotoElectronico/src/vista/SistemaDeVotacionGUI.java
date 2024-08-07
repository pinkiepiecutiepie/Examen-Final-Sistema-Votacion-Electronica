package vista;

import controlador.ControladorEstudiante;
import controlador.ControladorMesa;
import controlador.ControladorCurso;
import controlador.ControladorCandidato;
import controlador.ControladorVoto;
import modelo.Candidato;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SistemaDeVotacionGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    private ControladorEstudiante controladorEstudiante;
    private ControladorMesa controladorMesa;
    private ControladorCurso controladorCurso;
    private ControladorCandidato controladorCandidato;
    private ControladorVoto controladorVoto;

    public SistemaDeVotacionGUI(ControladorEstudiante controladorEstudiante, ControladorMesa controladorMesa,
                                ControladorCurso controladorCurso, ControladorCandidato controladorCandidato,
                                ControladorVoto controladorVoto) {
        this.controladorEstudiante = controladorEstudiante;
        this.controladorMesa = controladorMesa;
        this.controladorCurso = controladorCurso;
        this.controladorCandidato = controladorCandidato;
        this.controladorVoto = controladorVoto;

        setTitle("Sistema de Votación Electrónica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu archivoMenu = new JMenu("Archivo");
        JMenuItem salirMenuItem = new JMenuItem("Salir");
        salirMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        archivoMenu.add(salirMenuItem);

        JMenu administracionMenu = new JMenu("Administración");
        JMenuItem mesasMenuItem = new JMenuItem("Mesas");
        mesasMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioMesas();
            }
        });
        administracionMenu.add(mesasMenuItem);

        JMenuItem cursosMenuItem = new JMenuItem("Cursos");
        cursosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioCursos();
            }
        });
        administracionMenu.add(cursosMenuItem);

        JMenuItem estudiantesMenuItem = new JMenuItem("Estudiantes");
        estudiantesMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioEstudiantes();
            }
        });
        administracionMenu.add(estudiantesMenuItem);

        JMenuItem candidatosMenuItem = new JMenuItem("Candidatos");
        candidatosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioCandidatos();
            }
        });
        administracionMenu.add(candidatosMenuItem);

        JMenu procesoMenu = new JMenu("Proceso");
        JMenuItem sufragarMenuItem = new JMenuItem("Sufragar");
        sufragarMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioCedula();
            }
        });
        procesoMenu.add(sufragarMenuItem);

        JMenu reportesMenu = new JMenu("Reportes");
        JMenuItem padronElectoralMenuItem = new JMenuItem("Padrón Electoral");
        padronElectoralMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioPadronElectoral();
            }
        });
        reportesMenu.add(padronElectoralMenuItem);

        JMenuItem resultadosMenuItem = new JMenuItem("Resultados Generales");
        resultadosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioResultados();
            }
        });
        reportesMenu.add(resultadosMenuItem);

        menuBar.add(archivoMenu);
        menuBar.add(administracionMenu);
        menuBar.add(procesoMenu);
        menuBar.add(reportesMenu);

        setJMenuBar(menuBar);
    }

    private boolean hayAlgunFormularioAbierto() {
        return Arrays.stream(desktopPane.getAllFrames()).anyMatch(frame -> frame.isVisible());
    }

    private void mostrarFormularioMesas() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioMesas formulario = new FormularioMesas(controladorMesa);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioCursos() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioCursos formulario = new FormularioCursos(controladorCurso, controladorMesa.obtenerMesas());
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioEstudiantes() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioEstudiantes formulario = new FormularioEstudiantes(controladorEstudiante, controladorCurso.obtenerCursos());
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioCandidatos() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioCandidatos formulario = new FormularioCandidatos(controladorCandidato, controladorEstudiante.obtenerEstudiantes());
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioCedula() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioCedula formulario = new FormularioCedula(controladorEstudiante, controladorVoto, controladorCandidato);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioPadronElectoral() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioPadronElectoral formulario = new FormularioPadronElectoral(controladorEstudiante, controladorMesa, controladorCurso, controladorCandidato);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioResultados() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioResultados formulario = new FormularioResultados(controladorVoto);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private static Long obtenerNuevoId() {
        // Implementa la lógica para generar o obtener un nuevo ID
        return System.currentTimeMillis(); // Ejemplo simple
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear instancias de los controladores
                ControladorEstudiante controladorEstudiante = new ControladorEstudiante();
                ControladorMesa controladorMesa = new ControladorMesa();
                ControladorCurso controladorCurso = new ControladorCurso();
                ControladorCandidato controladorCandidato = new ControladorCandidato();
                ControladorVoto controladorVoto = new ControladorVoto();

                // Crear la GUI
                SistemaDeVotacionGUI sistemaDeVotacionGUI = new SistemaDeVotacionGUI(
                        controladorEstudiante, controladorMesa, controladorCurso, controladorCandidato, controladorVoto);
                sistemaDeVotacionGUI.setVisible(true);

                // Inicializar mesas
                Mesa[] mesas = {
                    new Mesa(1L, "Estrella del Saber", "Carlos Mendoza", "Ana García"),
                    new Mesa(2L, "Horizonte del Futuro", "Luis Fernández", "María Pérez"),
                    new Mesa(3L, "Pioneros del Cambio", "Juan Castillo", "Laura Morales"),
                    new Mesa(4L, "Voces del Mañana", "Miguel Torres", "Sofía Jiménez"),
                    new Mesa(5L, "Guardianes del Progreso", "Jorge Silva", "Isabel López")
                };
                for (Mesa mesa : mesas) {
                    controladorMesa.agregarMesa(mesa);
                }

                // Inicializar cursos
                Curso[] cursos = {
                    new Curso(1L, "Primero 'A'", mesas[0]),
                    new Curso(2L, "Primero 'B'", mesas[1]),
                    new Curso(3L, "Segundo 'A'", mesas[2]),
                    new Curso(4L, "Segundo 'B'", mesas[3]),
                    new Curso(5L, "Tercero 'A'", mesas[4])
                };
                for (Curso curso : cursos) {
                    controladorCurso.agregarCurso(curso);
                }

                // Inicializar estudiantes
                Estudiante[] estudiantes = {
                    new Estudiante(obtenerNuevoId(), "Juan Pérez", "0012345678", true, cursos[0]),
                    new Estudiante(obtenerNuevoId(), "María González", "0012345679", true, cursos[1]),
                    new Estudiante(obtenerNuevoId(), "Carlos Ramírez", "0012345680", true, cursos[2]),
                    new Estudiante(obtenerNuevoId(), "Ana López", "0012345681", true, cursos[3]),
                    new Estudiante(obtenerNuevoId(), "Luis Martínez", "0012345682", true, cursos[4]),
                    new Estudiante(obtenerNuevoId(), "Laura Fernández", "0012345683", true, cursos[0]),
                    new Estudiante(obtenerNuevoId(), "Jorge Morales", "0012345684", true, cursos[1]),
                    new Estudiante(obtenerNuevoId(), "Isabel Díaz", "0012345685", true, cursos[2]),
                    new Estudiante(obtenerNuevoId(), "Pedro Silva", "0012345686", true, cursos[3]),
                    new Estudiante(obtenerNuevoId(), "Sofía Torres", "0012345687", true, cursos[4]),
                    new Estudiante(obtenerNuevoId(), "Ricardo Gómez", "0012345688", true, cursos[0]),
                    new Estudiante(obtenerNuevoId(), "Camila Romero", "0012345689", true, cursos[1]),
                    new Estudiante(obtenerNuevoId(), "Felipe Vargas", "0012345690", true, cursos[2]),
                    new Estudiante(obtenerNuevoId(), "Valentina Paredes", "0012345691", true, cursos[3]),
                    new Estudiante(obtenerNuevoId(), "Andrés Ruiz", "0012345692", true, cursos[4]),
                    new Estudiante(obtenerNuevoId(), "Natalia Castro", "0012345693", true, cursos[0]),
                    new Estudiante(obtenerNuevoId(), "Sebastián Núñez", "0012345694", true, cursos[1]),
                    new Estudiante(obtenerNuevoId(), "Daniela Soto", "0012345695", true, cursos[2]),
                    new Estudiante(obtenerNuevoId(), "Miguel Ángel", "0012345696", true, cursos[3]),
                    new Estudiante(obtenerNuevoId(), "Camila Herrera", "0012345697", true, cursos[4]),
                    new Estudiante(obtenerNuevoId(), "Oscar Delgado", "0012345698", true, cursos[0])
                };
                for (Estudiante estudiante : estudiantes) {
                    controladorEstudiante.agregarEstudiante(estudiante);
                }

                // Inicializar candidatos
                Candidato[] candidatos = {
                    new Candidato(obtenerNuevoId(), "Juan Pérez", "", "Partido A"),
                    new Candidato(obtenerNuevoId(), "Ana Gómez", "", "Partido B"),
                    new Candidato(obtenerNuevoId(), "Luis Martínez", "", "Partido C")
                };
                for (Candidato candidato : candidatos) {
                    controladorCandidato.agregarCandidatoComoEstudiante(candidato);
                    controladorCandidato.agregarCandidato(candidato);
                }
            }
        });
    }
}