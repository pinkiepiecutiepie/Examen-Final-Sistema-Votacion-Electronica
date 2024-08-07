package modelo;

public class Mesa {
    private Long id;
    private String nombre;
    private String presidente;
    private String secretario;

    public Mesa(Long id, String nombre, String presidente, String secretario) {
        this.id = id;
        this.nombre = nombre;
        this.presidente = presidente;
        this.secretario = secretario;
    }
    
    @Override
    public String toString() {
        return nombre + " #" + id;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }

    public String getSecretario() { return secretario; }
    public void setSecretario(String secretario) { this.secretario = secretario; }
}