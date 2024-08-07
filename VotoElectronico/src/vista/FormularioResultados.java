package vista;

import controlador.ControladorVoto;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class FormularioResultados extends JInternalFrame {
    private static final long serialVersionUID = 1L;

    public FormularioResultados(ControladorVoto controladorVoto) {
        setTitle("Resultados Generales");
        setSize(600, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new BorderLayout());

        // Crear el dataset y el gráfico
        DefaultCategoryDataset dataset = controladorVoto.obtenerDatosGrafico();
        JFreeChart barChart = ChartFactory.createBarChart(
            "Recuento de Votos",
            "Candidatos",
            "Votos",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);

        // Crear el panel del gráfico y añadirlo al formulario
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        add(chartPanel, BorderLayout.CENTER);
    }
}