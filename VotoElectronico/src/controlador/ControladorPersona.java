package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Persona;

public abstract class ControladorPersona {
    protected List<Persona> personas;

    public ControladorPersona() {
        personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public List<Persona> obtenerPersonas() {
        return personas;
    }
}