package modelo;

public class Candidato extends Persona {
    private String foto;
    private String nombrePartido;

    public Candidato(Long id, String nombre, String foto, String nombrePartido) {
        super(id, nombre);
        this.foto = foto;
        this.nombrePartido = nombrePartido;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + nombrePartido + ")";
    }

    // Getters y setters
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getNombrePartido() { return nombrePartido; }
    public void setNombrePartido(String nombrePartido) { this.nombrePartido = nombrePartido; }
}