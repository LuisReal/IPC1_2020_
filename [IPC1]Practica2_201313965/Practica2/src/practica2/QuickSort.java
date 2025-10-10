package practica2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class QuickSort extends JFrame {

    JScrollPane scroll;

    public QuickSort(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String velocidad, String ordenRadio) {

        setLayout(null);

        setTitle("Quick Sort");
        setBounds(300, 50, 800, 650);
        getContentPane().setBackground(new Color(144, 238, 144));

        if (velocidad.equals("1")) {

            // System.out.println("el valor de grupo es " + velocidad);
            LaminaQuickSort1 laminabubble1 = new LaminaQuickSort1(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble1);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble1.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("2")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaQuickSort2 laminabubble2 = new LaminaQuickSort2(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble2);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble2.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("3")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaQuickSort3 laminabubble3 = new LaminaQuickSort3(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble3);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble3.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        }

    }

}

class LaminaQuickSort1 extends JPanel {

    ChartPanel barras;

    String[] datos1;

    float[] y;
    String[] x;

    int k = 0;

    CargaMasiva carga;
    CargaMasiva carga1;
    String[][] datos_carga;
    DefaultCategoryDataset datosGrafica;

    String titulo;

    JFreeChart chart;
    BarRenderer renderer;

    JLabel algoritmo;
    JLabel velocidad;
    JLabel orden;
    JLabel pasos;
    JLabel tiempo;

    JLabel muestra_algoritmo;
    JLabel muestra_velocidad;
    JLabel muestra_orden;
    JLabel muestra_pasos;
    JLabel muestra_tiempo;

    String ordenRadio = "";

    float mayor, menor;
    String mayor1, menor1;

    public LaminaQuickSort1(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Quick Sort");
        muestra_algoritmo.setBounds(100, 10, 100, 30);
        add(muestra_algoritmo);

        velocidad = new JLabel("Velocidad:");
        velocidad.setBounds(10, 50, 70, 30);
        add(velocidad);

        muestra_velocidad = new JLabel("Baja");
        muestra_velocidad.setBounds(100, 50, 100, 30);
        add(muestra_velocidad);

        orden = new JLabel("Orden:");
        orden.setBounds(10, 90, 70, 30);
        add(orden);

        if (ordenRadio.equals("Ascendente")) {

            muestra_orden = new JLabel("Ascendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        if (ordenRadio.equals("Descendente")) {

            muestra_orden = new JLabel("Descendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        pasos = new JLabel("Pasos:");
        pasos.setBounds(400, 50, 70, 30);
        add(pasos);

        muestra_pasos = new JLabel("0");
        muestra_pasos.setBounds(480, 50, 100, 30);
        add(muestra_pasos);

        tiempo = new JLabel("Tiempo:");
        tiempo.setBounds(400, 10, 70, 30);
        add(tiempo);

        muestra_tiempo = new JLabel("00:00:00");
        muestra_tiempo.setBounds(480, 10, 100, 30);
        add(muestra_tiempo);

        datos1 = new String[num_lineas - 1];
        y = new float[num_lineas - 1];
        x = new String[num_lineas - 1];

        System.out.println("El tamano del arreglo y en clase QuickSort(LaminaQuickSort1) es " + y.length);

        datos_carga = carga.datos;// colocar primero esto (es importante el orden)
        datos_carga = datos;// despues esta asignacion(para que todo funcione)

        //System.out.println("El tamano del arreglo datos_carga es " + datos_carga.length);
        for (int a = 1; a < datos_carga.length; a++) {

            if (datos_carga[a][0] != null) {

                datos1[k] = datos_carga[a][1];

                /* if (datos1[k] != null) {
                    System.out.println("datos1 " + datos1[k]);
                }*/
                y[k] = Float.parseFloat(datos1[k]);

                x[k] = datos_carga[a][0];

                k++;
            }
        }

        mayor = menor = y[0];
        int numero_arreglo = 0;
        for (int i = 0; i < y.length; i++) {

            if (y[i] != 0) {

                numero_arreglo = i + 1;

                if (y[i] > mayor) {

                    mayor = y[i];
                    mayor1 = x[i];
                }

                if (y[i] < menor) {

                    menor = y[i];
                    menor1 = x[i];
                }

            }
        }

        datosGrafica = new DefaultCategoryDataset();

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        TemporizadorQuick1 reloj = new TemporizadorQuick1(this);
        BajaQuick comenzar = new BajaQuick(this, reloj);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        int ancho = num_lineas - 1;

        double margen = -1 * renderer.getItemMargin();

        //System.out.println("el margen de las barras en la clase QuickSort(Lamina) es " + margen);
        barras = new ChartPanel(chart);

        barras.setBounds(10, 150, 720, 420);
        add(barras);

        // System.out.println("Velocidad Baja");
    }

    protected void paintComponent(Graphics e) {
        super.paintComponent(e);
        Graphics2D degradado = (Graphics2D) e;
        degradado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0,
                (new Color(240, 255, 255)), 0, getHeight(),
                getBackground().darker().darker());
        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class TemporizadorQuick1 extends Thread {

    LaminaQuickSort1 laminabubble;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorQuick1(LaminaQuickSort1 laminabubble) {

        this.laminabubble = laminabubble;
        this.start();
    }

    public void run() {

        try {

            for (minutos = 0; minutos < 60; minutos++) {

                for (segundos = 0; segundos < 60; segundos++) {

                    for (milisegundos = 0; milisegundos < 1000; milisegundos++) {
                        Thread.sleep(1);

                        segundos1 = String.valueOf(segundos);
                        minutos1 = String.valueOf(minutos);
                        milisegundos1 = String.valueOf(milisegundos);
                        laminabubble.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class BajaQuick extends Thread {

    LaminaQuickSort1 laminasort;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorQuick1 reloj;

    BufferedImage image;
    BufferedImage image1;

    public BajaQuick(LaminaQuickSort1 laminasort, TemporizadorQuick1 reloj) {

        this.laminasort = laminasort;
        this.y = laminasort.y;
        this.x = laminasort.x;
        this.reloj = reloj;

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminasort.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        image = laminasort.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        this.start();

    }

    public void run() {

        quicksort2(y, 0, y.length - 1);// y.length-1 = (13-1) = posicion 12 (ultima del arreglo y))

        reloj.stop();

        String pasos = laminasort.muestra_pasos.getText();
        String tiempo = laminasort.muestra_tiempo.getText();
        String algoritmo = laminasort.muestra_algoritmo.getText();
        String velocidad = laminasort.muestra_velocidad.getText();
        String orden = laminasort.muestra_orden.getText();
        float mayor = laminasort.mayor;
        float menor = laminasort.menor;
        String mayor1 = laminasort.mayor1;
        String menor1 = laminasort.menor1;

        String[][] datos_desordenados = laminasort.datos_carga;

        image1 = laminasort.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image1, "png", new File("go.jpg"));
        } catch (Exception e) {
        }

        ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

    } // fin del metodo run()

    public void quicksort2(float[] y, int izq, int der) {

        int i = izq, j = der;

        float pivote = y[(i + j) / 2];

        float aux = 0;
        String aux1 = "";

        do {

            if (laminasort.ordenRadio.equals("Ascendente")) {

                while (pivote > y[i]) {

                    i++;

                }

                while (pivote < y[j]) {

                    j--;

                }

            }// fin del if ascendente

            if (laminasort.ordenRadio.equals("Descendente")) {

                while (pivote < y[i]) {

                    i++;

                }

                while (pivote > y[j]) {

                    j--;

                }

            }// fin del if descendente

            for (int b = 0; b < y.length; b++) {

                laminasort.datosGrafica.removeValue("1", x[b]);
            }

            if (i <= j) {

                aux = y[i];
                aux1 = x[i];

                y[i] = y[j];
                x[i] = x[j];

                y[j] = aux;
                x[j] = aux1;

                for (int a = 0; a < y.length; a++) {

                    laminasort.datosGrafica.setValue(y[a], "1", x[a]);
                }

                try {
                    Thread.sleep(1000); // BAJA

                } catch (InterruptedException e) {

                }

                contador++;

                contador1 = String.valueOf(contador);

                laminasort.muestra_pasos.setText(contador1);

                i++;

                j--;

            }

        } while (i <= j);

        if (izq < j) {

            quicksort2(y, izq, j);

        }
        if (der > i) {

            quicksort2(y, i, der);

        }

    }// fin del metodo quicksort2

}

class LaminaQuickSort2 extends JPanel {

    ChartPanel barras;

    String[] datos1;

    float[] y;
    String[] x;

    int k = 0;

    CargaMasiva carga;
    CargaMasiva carga1;
    String[][] datos_carga;
    DefaultCategoryDataset datosGrafica;

    String titulo;

    JFreeChart chart;
    BarRenderer renderer;

    JLabel algoritmo;
    JLabel velocidad;
    JLabel orden;
    JLabel pasos;
    JLabel tiempo;

    JLabel muestra_algoritmo;
    JLabel muestra_velocidad;
    JLabel muestra_orden;
    JLabel muestra_pasos;
    JLabel muestra_tiempo;

    String ordenRadio = "";
    
    float mayor, menor;
    String mayor1, menor1;

    public LaminaQuickSort2(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Quick Sort");
        muestra_algoritmo.setBounds(100, 10, 100, 30);
        add(muestra_algoritmo);

        velocidad = new JLabel("Velocidad:");
        velocidad.setBounds(10, 50, 70, 30);
        add(velocidad);

        muestra_velocidad = new JLabel("Media");
        muestra_velocidad.setBounds(100, 50, 100, 30);
        add(muestra_velocidad);

        orden = new JLabel("Orden:");
        orden.setBounds(10, 90, 70, 30);
        add(orden);

        if (ordenRadio.equals("Ascendente")) {
            muestra_orden = new JLabel("Ascendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        if (ordenRadio.equals("Descendente")) {
            muestra_orden = new JLabel("Descendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        pasos = new JLabel("Pasos:");
        pasos.setBounds(400, 50, 70, 30);
        add(pasos);

        muestra_pasos = new JLabel("0");
        muestra_pasos.setBounds(480, 50, 100, 30);
        add(muestra_pasos);

        tiempo = new JLabel("Tiempo:");
        tiempo.setBounds(400, 10, 70, 30);
        add(tiempo);

        muestra_tiempo = new JLabel("00:00:00");
        muestra_tiempo.setBounds(480, 10, 100, 30);
        add(muestra_tiempo);

        datos1 = new String[num_lineas - 1];
        y = new float[num_lineas - 1];
        x = new String[num_lineas - 1];

        datos_carga = carga.datos;// colocar primero esto (es importante el orden)
        datos_carga = datos;// despues esta asignacion(para que todo funcione)

        //System.out.println("El tamano del arreglo datos_carga es " + datos_carga.length);
        for (int a = 1; a < datos_carga.length; a++) {

            if (datos_carga[a][0] != null) {

                datos1[k] = datos_carga[a][1];

                /* if (datos1[k] != null) {
                    System.out.println("datos1 " + datos1[k]);
                }*/
                y[k] = Float.parseFloat(datos1[k]);

                x[k] = datos_carga[a][0];

                k++;
            }
        }
        
        mayor = menor = y[0];
        int numero_arreglo = 0;
        for (int i = 0; i < y.length; i++) {

            if (y[i] != 0) {

                numero_arreglo = i + 1;

                if (y[i] > mayor) {

                    mayor = y[i];
                    mayor1 = x[i];
                }

                if (y[i] < menor) {

                    menor = y[i];
                    menor1 = x[i];
                }

            }
        }

        datosGrafica = new DefaultCategoryDataset();

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        TemporizadorQuick2 reloj = new TemporizadorQuick2(this);
        MediaQuick comenzar = new MediaQuick(this, reloj);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        barras = new ChartPanel(chart);

        barras.setBounds(10, 150, 720, 420);
        add(barras);

        System.out.println("Velocidad Media");
    }

    protected void paintComponent(Graphics e) {
        super.paintComponent(e);
        Graphics2D degradado = (Graphics2D) e;
        degradado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0,
                (new Color(245, 245, 220)), 0, getHeight(),
                getBackground().darker().darker());

        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class TemporizadorQuick2 extends Thread {

    LaminaQuickSort2 laminaquick;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorQuick2(LaminaQuickSort2 laminaquick) {

        this.laminaquick = laminaquick;
        this.start();
    }

    public void run() {

        try {

            for (minutos = 0; minutos < 60; minutos++) {

                for (segundos = 0; segundos < 60; segundos++) {

                    for (milisegundos = 0; milisegundos < 1000; milisegundos++) {
                        Thread.sleep(1);

                        segundos1 = String.valueOf(segundos);
                        minutos1 = String.valueOf(minutos);
                        milisegundos1 = String.valueOf(milisegundos);
                        laminaquick.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class MediaQuick extends Thread {

    LaminaQuickSort2 laminasort;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorQuick2 reloj;
    
    BufferedImage image;
    BufferedImage image1;

    public MediaQuick(LaminaQuickSort2 laminasort, TemporizadorQuick2 reloj) {

        this.laminasort = laminasort;
        this.y = laminasort.y;
        this.x = laminasort.x;
        this.reloj = reloj;

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminasort.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }
        
        image = laminasort.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        this.start();

    }

    public void run() {

        quicksort2(y, 0, y.length - 1);// 
        reloj.stop();
        
        String pasos = laminasort.muestra_pasos.getText();
        String tiempo = laminasort.muestra_tiempo.getText();
        String algoritmo = laminasort.muestra_algoritmo.getText();
        String velocidad = laminasort.muestra_velocidad.getText();
        String orden = laminasort.muestra_orden.getText();
        float mayor = laminasort.mayor;
        float menor = laminasort.menor;
        String mayor1 = laminasort.mayor1;
        String menor1 = laminasort.menor1;

        String[][] datos_desordenados = laminasort.datos_carga;

        image1 = laminasort.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image1, "png", new File("go.jpg"));
        } catch (Exception e) {
        }

        ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

    } // fin del metodo run()

    public void quicksort2(float[] y, int izq, int der) {

        int i = izq, j = der;

        float pivote = y[(i + j) / 2];

        float aux = 0;
        String aux1 = "";

        do {

            if (laminasort.ordenRadio.equals("Ascendente")) {

                while (pivote > y[i]) {

                    i++;

                }

                while (pivote < y[j]) {

                    j--;

                }

            }// fin del if ascendente

            if (laminasort.ordenRadio.equals("Descendente")) {

                while (pivote < y[i]) {

                    i++;

                }

                while (pivote > y[j]) {

                    j--;

                }

            }// fin del if descendente

            for (int b = 0; b < y.length; b++) {

                laminasort.datosGrafica.removeValue("1", x[b]);
            }

            if (i <= j) {

                aux = y[i];
                aux1 = x[i];

                y[i] = y[j];
                x[i] = x[j];

                y[j] = aux;
                x[j] = aux1;

                for (int a = 0; a < y.length; a++) {

                    laminasort.datosGrafica.setValue(y[a], "1", x[a]);
                }

                try {
                    Thread.sleep(500); // MEDIA

                } catch (InterruptedException e) {

                }

                contador++;

                contador1 = String.valueOf(contador);

                laminasort.muestra_pasos.setText(contador1);

                i++;

                j--;

            }

        } while (i <= j);

        if (izq < j) {

            quicksort2(y, izq, j);

        }
        if (der > i) {

            quicksort2(y, i, der);

        }

    }// fin del metodo quicksort2

}

class LaminaQuickSort3 extends JPanel {

    ChartPanel barras;

    String[] datos1;

    float[] y;
    String[] x;

    int k = 0;

    CargaMasiva carga;
    CargaMasiva carga1;
    String[][] datos_carga;
    DefaultCategoryDataset datosGrafica;

    String titulo;

    JFreeChart chart;
    BarRenderer renderer;

    JLabel algoritmo;
    JLabel velocidad;
    JLabel orden;
    JLabel pasos;
    JLabel tiempo;

    JLabel muestra_algoritmo;
    JLabel muestra_velocidad;
    JLabel muestra_orden;
    JLabel muestra_pasos;
    JLabel muestra_tiempo;

    String ordenRadio = "";
    
    float mayor, menor;
    String mayor1, menor1;

    public LaminaQuickSort3(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Quick Sort");
        muestra_algoritmo.setBounds(100, 10, 100, 30);
        add(muestra_algoritmo);

        velocidad = new JLabel("Velocidad:");
        velocidad.setBounds(10, 50, 70, 30);
        add(velocidad);

        muestra_velocidad = new JLabel("Alta");
        muestra_velocidad.setBounds(100, 50, 100, 30);
        add(muestra_velocidad);

        orden = new JLabel("Orden:");
        orden.setBounds(10, 90, 70, 30);
        add(orden);

        if (ordenRadio.equals("Ascendente")) {
            muestra_orden = new JLabel("Ascendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        if (ordenRadio.equals("Descendente")) {
            muestra_orden = new JLabel("Descendente");
            muestra_orden.setBounds(100, 90, 100, 30);
            add(muestra_orden);
        }

        pasos = new JLabel("Pasos:");
        pasos.setBounds(400, 50, 70, 30);
        add(pasos);

        muestra_pasos = new JLabel("0");
        muestra_pasos.setBounds(480, 50, 100, 30);
        add(muestra_pasos);

        tiempo = new JLabel("Tiempo:");
        tiempo.setBounds(400, 10, 70, 30);
        add(tiempo);

        muestra_tiempo = new JLabel("00:00:00");
        muestra_tiempo.setBounds(480, 10, 100, 30);
        add(muestra_tiempo);

        datos1 = new String[num_lineas - 1];
        y = new float[num_lineas - 1];
        x = new String[num_lineas - 1];

        datos_carga = carga.datos;// colocar primero esto (es importante el orden)
        datos_carga = datos;// despues esta asignacion(para que todo funcione)

        //System.out.println("El tamano del arreglo datos_carga es " + datos_carga.length);
        for (int a = 1; a < datos_carga.length; a++) {

            if (datos_carga[a][0] != null) {

                datos1[k] = datos_carga[a][1];

                /* if (datos1[k] != null) {
                    System.out.println("datos1 " + datos1[k]);
                }*/
                y[k] = Float.parseFloat(datos1[k]);

                x[k] = datos_carga[a][0];

                k++;
            }
        }
        
        mayor = menor = y[0];
        int numero_arreglo = 0;
        for (int i = 0; i < y.length; i++) {

            if (y[i] != 0) {

                numero_arreglo = i + 1;

                if (y[i] > mayor) {

                    mayor = y[i];
                    mayor1 = x[i];
                }

                if (y[i] < menor) {

                    menor = y[i];
                    menor1 = x[i];
                }

            }
        }

        datosGrafica = new DefaultCategoryDataset();

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        TemporizadorQuick3 reloj = new TemporizadorQuick3(this);
        AltaQuick comenzar = new AltaQuick(this, reloj);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        barras = new ChartPanel(chart);

        barras.setBounds(10, 150, 720, 420);
        add(barras);

        System.out.println("Velocidad Media");
    }

    protected void paintComponent(Graphics e) {
        super.paintComponent(e);
        Graphics2D degradado = (Graphics2D) e;
        degradado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0,
                (new Color(245, 245, 220)), 0, getHeight(),
                getBackground().darker().darker());

        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class TemporizadorQuick3 extends Thread {

    LaminaQuickSort3 laminaquick;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorQuick3(LaminaQuickSort3 laminaquick) {

        this.laminaquick = laminaquick;
        this.start();
    }

    public void run() {

        try {

            for (minutos = 0; minutos < 60; minutos++) {

                for (segundos = 0; segundos < 60; segundos++) {

                    for (milisegundos = 0; milisegundos < 1000; milisegundos++) {
                        Thread.sleep(1);

                        segundos1 = String.valueOf(segundos);
                        minutos1 = String.valueOf(minutos);
                        milisegundos1 = String.valueOf(milisegundos);
                        laminaquick.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class AltaQuick extends Thread {

    LaminaQuickSort3 laminasort;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorQuick3 reloj;
    
    BufferedImage image;
    BufferedImage image1;
    
    public AltaQuick(LaminaQuickSort3 laminasort, TemporizadorQuick3 reloj) {

        this.laminasort = laminasort;
        this.y = laminasort.y;
        this.x = laminasort.x;
        this.reloj = reloj;

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminasort.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        this.start();
        // y.length-1 = (13-1) = posicion 12 (ultima del arreglo y))

    }

    public void run() {

        quicksort2(y, 0, y.length - 1);

        reloj.stop();
        
        String pasos = laminasort.muestra_pasos.getText();
        String tiempo = laminasort.muestra_tiempo.getText();
        String algoritmo = laminasort.muestra_algoritmo.getText();
        String velocidad = laminasort.muestra_velocidad.getText();
        String orden = laminasort.muestra_orden.getText();
        float mayor = laminasort.mayor;
        float menor = laminasort.menor;
        String mayor1 = laminasort.mayor1;
        String menor1 = laminasort.menor1;

        String[][] datos_desordenados = laminasort.datos_carga;

        image1 = laminasort.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image1, "png", new File("go.jpg"));
        } catch (Exception e) {
        }

        ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

    } // fin del metodo run()

    public void quicksort2(float[] y, int izq, int der) {

        int i = izq, j = der;

        float pivote = y[(i + j) / 2];

        float aux = 0;
        String aux1 = "";

        do {

            if (laminasort.ordenRadio.equals("Ascendente")) {

                while (pivote > y[i]) {

                    i++;

                }

                while (pivote < y[j]) {

                    j--;

                }

            }// fin del if ascendente

            if (laminasort.ordenRadio.equals("Descendente")) {

                while (pivote < y[i]) {

                    i++;

                }

                while (pivote > y[j]) {

                    j--;

                }

            }// fin del if descendente

            for (int b = 0; b < y.length; b++) {

                laminasort.datosGrafica.removeValue("1", x[b]);
            }

            if (i <= j) {

                aux = y[i];
                aux1 = x[i];

                y[i] = y[j];
                x[i] = x[j];

                y[j] = aux;
                x[j] = aux1;

                for (int a = 0; a < y.length; a++) {

                    laminasort.datosGrafica.setValue(y[a], "1", x[a]);
                }

                try {
                    Thread.sleep(100); // ALTA

                } catch (InterruptedException e) {

                }

                contador++;

                contador1 = String.valueOf(contador);

                laminasort.muestra_pasos.setText(contador1);

                i++;

                j--;

            }

        } while (i <= j);

        if (izq < j) {

            quicksort2(y, izq, j);

        }
        if (der > i) {

            quicksort2(y, i, der);

        }

    }// fin del metodo quicksort2

}
