package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Mesa;

public class ControladorMesa {
    private List<Mesa> mesas;

    public ControladorMesa() {
        mesas = new ArrayList<>();
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public List<Mesa> obtenerMesas() {
        return mesas;
    }
    
    public List<Mesa> obtenerMesasDeVotacion() {
        return mesas.stream()
                    .filter(m -> m instanceof Mesa)
                    .map(m -> (Mesa) m)
                    .collect(Collectors.toList());
    }
}