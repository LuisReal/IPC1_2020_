package practica2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BubbleSort extends JFrame {

    JScrollPane scroll;

    public BubbleSort(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String velocidad, String ordenRadio) {

        setLayout(null);

        setTitle("Bubble Sort");
        setBounds(300, 50, 800, 650);
        getContentPane().setBackground(new Color(144, 238, 144));

        if (velocidad.equals("1")) {

            // System.out.println("el valor de grupo es " + velocidad);
            LaminaBubbleSort1 laminabubble1 = new LaminaBubbleSort1(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble1);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble1.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("2")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaBubbleSort2 laminabubble2 = new LaminaBubbleSort2(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble2);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble2.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("3")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaBubbleSort3 laminabubble3 = new LaminaBubbleSort3(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminabubble3);
            scroll.setBounds(10, 20, 760, 580);

            laminabubble3.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        }
    }

}

class LaminaBubbleSort1 extends JPanel {

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

    public LaminaBubbleSort1(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Bubble Sort");
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

        //SlidingCategoryDataset demo = new SlidingCategoryDataset(datosGrafica);
        Temporizador1 reloj = new Temporizador1(this);
        Baja comenzar = new Baja(this, reloj);

        //SlidingCategoryDataset sliding = new SlidingCategoryDataset(datosGrafica, 1, 200);
        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        int ancho = num_lineas - 1;

        double margen = -1 * renderer.getItemMargin();

        barras = new ChartPanel(chart);

        barras.setBounds(10, 150, 720, 420);
        add(barras);

        System.out.println("Velocidad Baja");
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

class Temporizador1 extends Thread {

    LaminaBubbleSort1 laminabubble;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public Temporizador1(LaminaBubbleSort1 laminabubble) {

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

class Baja extends Thread {

    LaminaBubbleSort1 laminabubble;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    Temporizador1 reloj;
    
     BufferedImage image;
     BufferedImage image1;

    public Baja(LaminaBubbleSort1 laminabubble, Temporizador1 reloj) {

        this.laminabubble = laminabubble;
        this.y = laminabubble.y;
        this.x = laminabubble.x;
        this.reloj = reloj;
        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminabubble.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }
        
        

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminabubble.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }
        
        float aux = 0;
        String aux1 = "";

        int c = 0;

        if (laminabubble.ordenRadio.equals("Ascendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] > y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(1000);// baja

                        } catch (InterruptedException e) {

                        }

                    }

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();
            
            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;

            String[][] datos_desordenados = laminabubble.datos_carga;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

        if (laminabubble.ordenRadio.equals("Descendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] < y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(1000);// baja

                        } catch (InterruptedException e) {

                        }

                    }// fin del if

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();
            
            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;

            String[][] datos_desordenados = laminabubble.datos_carga;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

    } // fin del metodo run()

}

class LaminaBubbleSort2 extends JPanel {

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

    public LaminaBubbleSort2(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Bubble Sort");
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

        Temporizador2 reloj = new Temporizador2(this);
        Media comenzar = new Media(this, reloj);

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

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

class Temporizador2 extends Thread {

    LaminaBubbleSort2 laminabubble;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public Temporizador2(LaminaBubbleSort2 laminabubble) {

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

class Media extends Thread {

    LaminaBubbleSort2 laminabubble;
    float[] y;
    String[] x;

    int contador = 0;
    String contador1 = "";
    Temporizador2 reloj;
    
    BufferedImage image;
     BufferedImage image1;

    public Media(LaminaBubbleSort2 laminabubble, Temporizador2 reloj) {

        this.laminabubble = laminabubble;
        this.y = laminabubble.y;
        this.x = laminabubble.x;
        this.reloj = reloj;

        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminabubble.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }
        
        

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminabubble.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        float aux = 0;
        String aux1 = "";

        int c = 0;

        if (laminabubble.ordenRadio.equals("Ascendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] > y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(500);// media

                        } catch (InterruptedException e) {

                        }

                    }

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();
            
            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;

            String[][] datos_desordenados = laminabubble.datos_carga;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);
        }

        if (laminabubble.ordenRadio.equals("Descendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] < y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(500);// media

                        } catch (InterruptedException e) {

                        }

                    }

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();
            
            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;

            String[][] datos_desordenados = laminabubble.datos_carga;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);
        }

    } // fin del metodo run()

}

class LaminaBubbleSort3 extends JPanel {

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

    public LaminaBubbleSort3(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Bubble Sort");
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

        System.out.println("El numero mayor es " + mayor);
        System.out.println("El numero menor es " + menor);

        datosGrafica = new DefaultCategoryDataset();

        Temporizador3 reloj = new Temporizador3(this);
        Alta comenzar = new Alta(this, reloj);

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

        barras = new ChartPanel(chart);

        barras.setBounds(10, 150, 720, 420);
        add(barras);

        System.out.println("Velocidad Alta");
    }

    protected void paintComponent(Graphics e) {
        super.paintComponent(e);
        Graphics2D degradado = (Graphics2D) e;
        degradado.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0,
                (new Color(224, 255, 255)), 0, getHeight(),
                (new Color(25, 25, 112)));

        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class Temporizador3 extends Thread {

    LaminaBubbleSort3 laminabubble;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public Temporizador3(LaminaBubbleSort3 laminabubble) {

        this.laminabubble = laminabubble;
        this.start();
        // Alta alta = new Alta(this);
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

class Alta extends Thread {

    LaminaBubbleSort3 laminabubble;
    float[] y;
    String[] x;

    float aux = 0;
    String aux1 = "";

    int contador = 0;
    String contador1 = "";

    boolean bool = false;
    Temporizador3 reloj;

    BufferedImage image;
     BufferedImage image1;

    public Alta(LaminaBubbleSort3 laminabubble, Temporizador3 reloj) {

        this.laminabubble = laminabubble;
        this.y = laminabubble.y;
        this.x = laminabubble.x;
        this.reloj = reloj;

        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminabubble.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminabubble.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        if (laminabubble.ordenRadio.equals("Ascendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] > y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(100); // ALTA

                        } catch (InterruptedException e) {

                        }

                    }// fin del if

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();

            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;

            String[][] datos_desordenados = laminabubble.datos_carga;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

        if (laminabubble.ordenRadio.equals("Descendente")) {

            for (int a = 0; a < (y.length - 1); a++) {

                for (int b = 0; b < (y.length - 1); b++) {

                    if (y[b] < y[b + 1]) { // Descendente<   ascendente>

                        for (int i = 0; i < y.length; i++) {

                            laminabubble.datosGrafica.removeColumn(x[i]);
                        }

                        aux = y[b];
                        aux1 = x[b];

                        y[b] = y[b + 1];
                        x[b] = x[b + 1];

                        y[b + 1] = aux;
                        x[b + 1] = aux1;

                        for (int j = 0; j < y.length; j++) {
                            laminabubble.datosGrafica.setValue(y[j], "1", x[j]);
                        }
                        try {
                            Thread.sleep(100); // ALTA

                        } catch (InterruptedException e) {

                        }

                    }// fin del if

                    contador++;

                    contador1 = String.valueOf(contador);

                    laminabubble.muestra_pasos.setText(contador1);
                }

            }

            reloj.stop();

            String pasos = laminabubble.muestra_pasos.getText();
            String tiempo = laminabubble.muestra_tiempo.getText();
            String algoritmo = laminabubble.muestra_algoritmo.getText();
            String velocidad = laminabubble.muestra_velocidad.getText();
            String orden = laminabubble.muestra_orden.getText();
            float mayor = laminabubble.mayor;
            float menor = laminabubble.menor;
            String mayor1 = laminabubble.mayor1;
            String menor1 = laminabubble.menor1;
            
            image1 = laminabubble.chart.createBufferedImage(600, 400);
            
            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            String[][] datos_desordenados = laminabubble.datos_carga;

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

    } // fin del metodo run()

}
