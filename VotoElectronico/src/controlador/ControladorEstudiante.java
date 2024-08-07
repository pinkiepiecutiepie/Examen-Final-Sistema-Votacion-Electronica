package controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import modelo.Estudiante;

public class ControladorEstudiante extends ControladorPersona {

    public ControladorEstudiante() {
        super();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        personas.add(estudiante);
    }

    public void actualizarEstadoEstudiante(String cedula, boolean estado) {
        Optional<Estudiante> estudianteOpt = personas.stream()
                .filter(p -> p instanceof Estudiante && ((Estudiante) p).getCedula().equals(cedula))
                .map(p -> (Estudiante) p)
                .findFirst();
        if (estudianteOpt.isPresent()) {
            Estudiante estudiante = estudianteOpt.get();
            estudiante.setEstado(estado);
        }
    }

    public List<Estudiante> obtenerEstudiantes() {
        return personas.stream()
                .filter(p -> p instanceof Estudiante)
                .map(p -> (Estudiante) p)
                .collect(Collectors.toList());
    }
}