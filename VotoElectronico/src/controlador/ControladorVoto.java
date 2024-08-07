package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.data.category.DefaultCategoryDataset;

import modelo.Candidato;
import modelo.Voto;

public class ControladorVoto {
    private List<Voto> votos;
    private List<Candidato> candidatos;
    private Map<Candidato, Integer> recuentoVotos;

    public ControladorVoto() {
        votos = new ArrayList<>();
        candidatos = new ArrayList<>();
        recuentoVotos = new HashMap<>();
    }

    public void registrarVoto(Voto voto) {
        votos.add(voto);
        recuentoVotos.put(voto.getCandidato(), recuentoVotos.getOrDefault(voto.getCandidato(), 0) + 1);
    }

    public List<Voto> obtenerVotos() {
        return votos;
    }

    public List<Candidato> obtenerCandidatos() {
        return candidatos;
    }

    public void agregarCandidato(Candidato candidato) {
        if (candidato != null && !candidatos.contains(candidato)) {
            candidatos.add(candidato);
        }
    }

    public DefaultCategoryDataset obtenerDatosGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Candidato, Integer> entry : recuentoVotos.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey().getNombre(), "");
        }
        return dataset;
    }
}