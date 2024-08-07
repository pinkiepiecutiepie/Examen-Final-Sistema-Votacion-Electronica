package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Candidato;

public class ControladorCandidato extends ControladorPersona {
	private List<Candidato> candidatos;
	
    public ControladorCandidato() {
        super();
        candidatos = new ArrayList<>();
    }

    public void agregarCandidatoComoEstudiante(Candidato candidato) {
        personas.add(candidato);
    }
    
    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }
    
    public List<Candidato> obtenerCandidatos() {
        return candidatos;
    }
    
    public List<Candidato> obtenerCandidatosComoEstudiantes() {
        return candidatos.stream()
                       .filter(p -> p instanceof Candidato)
                       .map(p -> (Candidato) p)
                       .collect(Collectors.toList());
    }
}