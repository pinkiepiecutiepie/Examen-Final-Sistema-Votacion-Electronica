package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Curso;

public class ControladorCurso {
    private List<Curso> cursos;

    public ControladorCurso() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }
    
    public List<Curso> obtenerCursosElectivos() {
        return cursos.stream()
                     .filter(c -> c instanceof Curso)
                     .map(c -> (Curso) c)
                     .collect(Collectors.toList());
    }
}