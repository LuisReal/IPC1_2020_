package practica2;

import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

class LaminaGrafica extends JPanel {

    ChartPanel barras;

    String[] datos1;

    float[] y;
    String[] x;

    int k = 0;

    CargaMasiva carga;
    CargaMasiva carga1;
    String[][] datos_carga;

    JButton boton;
    JScrollPane scroll;

    public LaminaGrafica(CargaMasiva carga, String titulo, String[][] datos, int num_lineas) {

        setLayout(null);
        //setPreferredSize(new Dimension(400,400));

        this.carga = carga;

        //System.out.println("El tamano de num_lineas en clase Grafica es "+num_lineas);
        datos1 = new String[num_lineas - 1];
        y = new float[num_lineas - 1];
        x = new String[num_lineas - 1];

        //System.out.println("El tamano del arreglo datos1 en clase Grafica es "+datos1.length);
        datos_carga = carga.datos;// colocar primero esto (es importante el orden)
        datos_carga = datos;// despues esta asignacion(para que todo funcione)

        for (int a = 1; a < datos_carga.length; a++) {

            if (datos_carga[a][0] != null) {

                //System.out.println("datos_carga[a][0] es "+a+" = "+datos_carga[a][0]);
                datos1[k] = datos_carga[a][1];

                // System.out.println("datos1[k] es "+k+" = "+datos1[k]);
                y[k] = Float.parseFloat(datos1[k]);

                // System.out.println("y[k] es "+k+" = "+y[k]);
                x[k] = datos_carga[a][0];

                k++;
            }
        }

        DefaultCategoryDataset datosGrafica = new DefaultCategoryDataset();

        for (int i = 0; i < (y.length); i++) {// k es el contador que lleva el conteo de las veces que se repite los numeros
            //int                  string
            datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        JFreeChart chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        barras = new ChartPanel(chart);

        barras.setBounds(10, 20, 730, 350);
        add(barras);

    }

}
