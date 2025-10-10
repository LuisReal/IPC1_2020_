package practica2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ShellSort extends JFrame {

    JScrollPane scroll;

    public ShellSort(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String velocidad, String ordenRadio) {

        setLayout(null);

        setTitle("Shell Sort");
        setBounds(300, 50, 800, 650);
        getContentPane().setBackground(new Color(144, 238, 144));

        if (velocidad.equals("1")) {

            LaminaShellSort1 laminashell1 = new LaminaShellSort1(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminashell1);
            scroll.setBounds(10, 20, 760, 580);

            laminashell1.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("2")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaShellSort2 laminashell2 = new LaminaShellSort2(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminashell2);
            scroll.setBounds(10, 20, 760, 580);

            laminashell2.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        } else if (velocidad.equals("3")) {

            //System.out.println("el valor de grupo es " + velocidad);
            LaminaShellSort3 laminashell3 = new LaminaShellSort3(carga, titulo, datos, num_lineas, ordenRadio);

            scroll = new JScrollPane();
            scroll.setViewportView(laminashell3);
            scroll.setBounds(10, 20, 760, 580);

            laminashell3.setPreferredSize(new Dimension(900, 600));
            add(scroll);

        }
    }
}

class LaminaShellSort1 extends JPanel {

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

    public LaminaShellSort1(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Shell Sort");
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

        chart = ChartFactory.createBarChart3D(titulo, datos_carga[0][0], datos_carga[0][1], datosGrafica,
                PlotOrientation.VERTICAL, true, true, false);

        TemporizadorShell1 reloj = new TemporizadorShell1(this);
        BajaShell comenzar = new BajaShell(this, reloj);

        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setItemMargin(-4);

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

class TemporizadorShell1 extends Thread {

    LaminaShellSort1 laminashell;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorShell1(LaminaShellSort1 laminashell) {

        this.laminashell = laminashell;
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
                        laminashell.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class BajaShell extends Thread {

    LaminaShellSort1 laminashell;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorShell1 reloj;
    BufferedImage image;
    BufferedImage image1;

    public BajaShell(LaminaShellSort1 laminashell, TemporizadorShell1 reloj) {

        this.laminashell = laminashell;
        this.y = laminashell.y;
        this.x = laminashell.x;
        this.reloj = reloj;

        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminashell.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminashell.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        int salto, i, k, j;

        float aux;
        String aux1;

        salto = y.length / 2;

        if (laminashell.ordenRadio.equals("Ascendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] <= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(1000); // BAJA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

        if (laminashell.ordenRadio.equals("Descendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] >= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(1000); // BAJA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

    } // fin del metodo run()

}

class LaminaShellSort2 extends JPanel {

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

    public LaminaShellSort2(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Shell Sort");
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

        TemporizadorShell2 reloj = new TemporizadorShell2(this);
        MediaShell comenzar = new MediaShell(this, reloj);

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
                (new Color(240, 255, 255)), 0, getHeight(),
                getBackground().darker().darker());
        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class TemporizadorShell2 extends Thread {

    LaminaShellSort2 laminashell;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorShell2(LaminaShellSort2 laminashell) {

        this.laminashell = laminashell;
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
                        laminashell.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class MediaShell extends Thread {

    LaminaShellSort2 laminashell;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorShell2 reloj;
    
    BufferedImage image;
    BufferedImage image1;

    public MediaShell(LaminaShellSort2 laminashell, TemporizadorShell2 reloj) {

        this.laminashell = laminashell;
        this.y = laminashell.y;
        this.x = laminashell.x;
        this.reloj = reloj;
        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminashell.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminashell.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        int salto, i, k, j;

        float aux;
        String aux1;

        salto = y.length / 2;

        if (laminashell.ordenRadio.equals("Ascendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] <= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(500); // MEDIA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

        if (laminashell.ordenRadio.equals("Descendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] >= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(500); // MEDIA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

    } // fin del metodo run()

}

class LaminaShellSort3 extends JPanel {

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

    public LaminaShellSort3(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, String ordenRadio) {

        setLayout(null);

        this.carga = carga;
        this.titulo = titulo;
        this.ordenRadio = ordenRadio;

        algoritmo = new JLabel("Algoritmo:");
        algoritmo.setBounds(10, 10, 70, 30);
        add(algoritmo);

        muestra_algoritmo = new JLabel("Shell Sort");
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

        TemporizadorShell3 reloj = new TemporizadorShell3(this);
        AltaShell comenzar = new AltaShell(this, reloj);

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
                (new Color(240, 255, 255)), 0, getHeight(),
                getBackground().darker().darker());
        degradado.setPaint(gp);
        degradado.fillRect(0, 0, getWidth(), getHeight());

    }
}

class TemporizadorShell3 extends Thread {

    LaminaShellSort3 laminashell;

    int minutos = 0;
    int segundos = 0;
    int milisegundos = 0;

    String minutos1 = "";
    String segundos1 = "";
    String milisegundos1 = "";

    public TemporizadorShell3(LaminaShellSort3 laminashell) {

        this.laminashell = laminashell;
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
                        laminashell.muestra_tiempo.setText(minutos1 + ":" + segundos1 + ":" + milisegundos1);
                    }
                }
            }

        } catch (InterruptedException e) {

        }

    }

}

class AltaShell extends Thread {

    LaminaShellSort3 laminashell;
    float[] y;
    String[] x;
    int contador = 0;
    String contador1 = "";
    TemporizadorShell3 reloj;
    
    BufferedImage image;
    BufferedImage image1;

    public AltaShell(LaminaShellSort3 laminashell, TemporizadorShell3 reloj) {

        this.laminashell = laminashell;
        this.y = laminashell.y;
        this.x = laminashell.x;
        this.reloj = reloj;
        this.start();

    }

    public void run() {

        for (int i = 0; i < y.length; i++) {
            //int                  string
            laminashell.datosGrafica.setValue(y[i], "1", x[i]); // (enteros,"1",String)

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        image = laminashell.chart.createBufferedImage(600, 400);

        try {
            ImageIO.write(image, "png", new File("gd.jpg"));
        } catch (Exception e) {
        }

        int salto, i, k, j;

        float aux;
        String aux1;

        salto = y.length / 2;

        if (laminashell.ordenRadio.equals("Ascendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] <= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(100); // ALTA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

        if (laminashell.ordenRadio.equals("Descendente")) {

            while (salto > 0) {

                for (i = salto; i < y.length; i++) {

                    j = i - salto;

                    while (j >= 0) {
                        k = j + salto;

                        if (y[j] >= y[k]) {
                            j = -1;
                        } else {

                            for (int c = 0; c < y.length; c++) {

                                laminashell.datosGrafica.removeValue("1", x[c]);

                            }

                            aux = y[j];
                            aux1 = x[j];

                            y[j] = y[k];
                            x[j] = x[k];

                            y[k] = aux;
                            x[k] = aux1;

                            for (int d = 0; d < y.length; d++) {

                                laminashell.datosGrafica.setValue(y[d], "1", x[d]);

                            }

                            try {

                                Thread.sleep(100); // ALTA

                            } catch (InterruptedException e) {

                            }

                            contador++;

                            contador1 = String.valueOf(contador);

                            laminashell.muestra_pasos.setText(contador1);

                            j = j - salto;
                        }
                    }

                }

                salto = salto / 2;

            }

            reloj.stop();
            
            String pasos = laminashell.muestra_pasos.getText();
            String tiempo = laminashell.muestra_tiempo.getText();
            String algoritmo = laminashell.muestra_algoritmo.getText();
            String velocidad = laminashell.muestra_velocidad.getText();
            String orden = laminashell.muestra_orden.getText();
            float mayor = laminashell.mayor;
            float menor = laminashell.menor;
            String mayor1 = laminashell.mayor1;
            String menor1 = laminashell.menor1;

            String[][] datos_desordenados = laminashell.datos_carga;
            
            image1 = laminashell.chart.createBufferedImage(600, 400);

            try {
                ImageIO.write(image1, "png", new File("go.jpg"));
            } catch (Exception e) {
            }

            ReportesHTML b3 = new ReportesHTML(pasos, tiempo, algoritmo, velocidad,
                    orden, mayor, menor, mayor1, menor1, datos_desordenados, y, x);

        }

    } // fin del metodo run()

}
