package practica2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana() {

        setLayout(null);

        setTitle("Procesamiento de Datos");
        setBounds(300, 40, 800, 650);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        // setResizable(false);

        LaminaVentana lamina = new LaminaVentana(this);
        lamina.setBounds(10,10,765,150);
        lamina.setBackground(new Color(152, 251, 152));
        add(lamina);

    }

}

class LaminaVentana extends JPanel {

    JLabel ruta;
    JLabel titulo;

    JTextField campo_ruta;
    JTextField campo_titulo;

    JButton buscar;
    JButton aceptar;

    Ventana ventana;
    String rutaFile;

    CargaMasiva carga;
    CargaMasiva carga1;

    String[][] datos;
    String[] campos;

    int num_lineas1 = 0;

    JScrollPane scroll;

    public LaminaVentana(Ventana ventana) {

        this.ventana = ventana;

        setLayout(null);

        ruta = new JLabel("Ruta del archivo");
        ruta.setBounds(10, 10, 100, 20);
        add(ruta);

        campo_ruta = new JTextField();
        campo_ruta.setBounds(10, 40, 500, 25);
        add(campo_ruta);

        titulo = new JLabel("Titulo para la Grafica");
        titulo.setBounds(10, 70, 150, 20);
        add(titulo);

        campo_titulo = new JTextField();
        campo_titulo.setBounds(10, 100, 500, 25);
        add(campo_titulo);

        buscar = new JButton("Buscar");
        buscar.setBounds(550, 40, 100, 25);
        add(buscar);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(550, 100, 100, 25);
        add(aceptar);

        Buscar busqueda = new Buscar();
        buscar.addActionListener(busqueda);

        Aceptar aceptaste = new Aceptar();
        aceptar.addActionListener(aceptaste);

    }

    private class Buscar implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            carga = new CargaMasiva();

            // System.out.println("la ruta " + carga.rutaFile);
            campo_ruta.setText(carga.rutaFile);//   C:\Users\Darkun\Documents\datos.csv

        }

    }

    private class Aceptar implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String rutaIngresada = campo_ruta.getText();

            // System.out.println("La ruta ingresada es " + rutaIngresada);
            datos = carga.datos;

            int num_lineas = 0;

            int i = 0;

            File archivo = new File(rutaIngresada);

            try {
                // Abrir el .csv en buffer de lectura

                FileReader lector = new FileReader(archivo);
                BufferedReader bufferLectura = new BufferedReader(lector);

                String linea;

                while ((linea = bufferLectura.readLine()) != null) {

                    num_lineas++;// para poder llevar el conteo de las filas
                }

                //System.out.println("el numero de lineas en la clase Ventana es " + num_lineas);

                datos = new String[num_lineas][2];

            } catch (IOException ae) {
                System.out.println("El archivo no se ha encontrado");
            }

            try {
                // Abrir el .csv en buffer de lectura
                FileReader lector = new FileReader(archivo);
                BufferedReader bufferLectura = new BufferedReader(lector);

                String linea1;

                while ((linea1 = bufferLectura.readLine()) != null) {

                    campos = linea1.split(","); // guarda la informacion en un arreglo de tipo String

                    for (int j = 0; j < campos.length; j++) {

                        datos[i][j] = campos[j];

                    }

                    i++;// para poder llevar el conteo de las filas
                }
            } catch (IOException f) {

                JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");

            }

            String titulo = campo_titulo.getText();

            LaminaGrafica grafica = new LaminaGrafica(carga, titulo, datos, num_lineas);
            //grafica.setBounds(10, 170, 665, 420);
            //grafica.setBackground(new Color(127, 255, 0));

            scroll = new JScrollPane();
            scroll.setViewportView(grafica);
            scroll.setBounds(10, 200, 760, 400);

            grafica.setPreferredSize(new Dimension(1200, 800));

            //scroll.setVisible(true);
            ventana.add(scroll);
            ventana.setVisible(true);

            int opcion = JOptionPane.showConfirmDialog(null, "Desea Ordenar La Grafica", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (opcion == 0) {

                //System.out.println("Has seleccionado yes ");
                OpcionesOrdenamiento ordenamiento = new OpcionesOrdenamiento(carga, titulo, datos, num_lineas);
                ordenamiento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ordenamiento.setVisible(true);
            }

        }

    }

}
