package practica2;

import java.awt.*;
import java.io.*;

import javax.swing.*;

public class CargaMasiva {

    public static String[][] datos;
    String[] campos;
    String rutaFile;
    int num_lineas = 0;
    int i = 0;

    public CargaMasiva() {

        File archivo;
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.showOpenDialog(null);

        archivo = seleccionar.getSelectedFile();

        rutaFile = seleccionar.getSelectedFile().toString();

    }

}
