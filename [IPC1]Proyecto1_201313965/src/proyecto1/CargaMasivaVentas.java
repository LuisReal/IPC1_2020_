
package proyecto1;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CargaMasivaVentas {
    
    public String[] camposVenta;
    public Object[][] elementoVenta;

    String[] cadena;
    
    public CargaMasivaVentas(){
    
        int i = 0;
        elementoVenta = new Object[500][4];

        File archivo;
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.showOpenDialog(null);

        archivo = seleccionar.getSelectedFile();

        try {
            // Abrir el .csv en buffer de lectura
            FileReader lector = new FileReader(archivo);
            BufferedReader bufferLectura = new BufferedReader(lector);

            String linea;

            while ((linea = bufferLectura.readLine()) != null) {

                //texto = texto + linea;
                camposVenta = linea.split(","); // guarda la informacion en un arreglo de tipo String

                for (int j = 0; j < camposVenta.length; j++) {

                    elementoVenta[i][j] = camposVenta[j];

                    // System.out.println("El elemento "+elemento[i][j]);
                }
                i++;// para poder llevar el conteo de las filas
            }
        } catch (IOException e) {
            System.out.println("El archivo no se ha encontrado");
        }
        
        int m = 1;
        cadena = new String[500];
        

        
        for (int j = 0; j < elementoVenta.length; j++) {

            if ((elementoVenta[j][2]) != null) {

                cadena[j] = String.valueOf(elementoVenta[j][2]); // guarda los nombres de los productos

                // System.out.println("La cadena Nombre de Venta en la posicion " + j + " = " + cadena[j]);
            }

        }

       /* int contador = 0;

        for (int k = 0; k < (cadena.length); k++) { // tamano cadena 9

            if (cadena[k] != null) {

                for(int b=k+1; b<cadena.length; b++ ) {

                    //System.out.println("La cadena k "+cadena[k]);
                    //System.out.println("La cadena b "+cadena[b]);
                    
                    if (cadena[k].equals(cadena[b])) {

                        contador++;

                        System.out.println("La venta repetida es " + cadena[k]);
                        
                        JOptionPane.showMessageDialog(null, "La venta que se repite es "+cadena[k]);
                        //System.out.println("El contador es "+contador);
                    }
                }
            }
        }// fin del for*/
        
            LaminaVentanaVentas lamina_venta1 = new LaminaVentanaVentas();
            lamina_venta1.setDatos(elementoVenta); // envia elementoVenta a VentanaVentas
        
        
       /* if (contador == 0) {

            System.out.println("Si se puede cargar el archivo");
            
            LaminaVentanaVentas lamina_venta1 = new LaminaVentanaVentas();
            lamina_venta1.setDatos(elementoVenta); // envia elementoVenta a VentanaVentas

        }else{
        
            JOptionPane.showMessageDialog(null, "No se puede cargar el archivo, Hay Ventas que se repiten");
        
        }*/
    
    }// fin del constructor CargaMasivaVentas
}
