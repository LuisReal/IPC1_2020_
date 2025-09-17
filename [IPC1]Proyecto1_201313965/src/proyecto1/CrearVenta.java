package proyecto1;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class CrearVenta extends JFrame {

    public CrearVenta(Object[][] elementoVenta) {

        setTitle("Crear Venta");

        setBounds(400, 100, 400, 500);

        LaminaCrearVenta crearV = new LaminaCrearVenta(elementoVenta);
        add(crearV);
    }
}

class LaminaCrearVenta extends JPanel {

    public static Object[][] elementoVenta = new Object[500][4];

    public int x = 0;

    JLabel nit_cliente;
    JLabel agregar_producto;
    JLabel producto;
    JLabel cantidad;
    JLabel ingresados_venta;

    JTextField campo_nit_cliente;
    JComboBox elegir_producto;
    String[] nombre_producto;

    JTextField campo_cantidad_producto;
    JButton agregar;

    String ruta_imagen;
    
    int cantidad_maxima=0;
    int cantidad_sumada=0;

    JFileChooser chooser;

    public LaminaCrearVenta(Object[][] elementoVenta) {

        setLayout(null);

        nit_cliente = new JLabel("NIT del Cliente");
        nit_cliente.setBounds(30, 30, 100, 30);
        add(nit_cliente);

        campo_nit_cliente = new JTextField();
        campo_nit_cliente.setBounds(200, 30, 150, 30);
        add(campo_nit_cliente);

        agregar_producto = new JLabel("Agregar Productos");
        agregar_producto.setBounds(130, 80, 200, 30);
        add(agregar_producto);

        producto = new JLabel("Producto");
        producto.setBounds(30, 130, 100, 30);
        add(producto);

        elegir_producto = new JComboBox();
        elegir_producto.setBounds(200, 130, 150, 30);

        nombre_producto = new String[200];

        for (int i = 0; i < elementoVenta.length; i++) {

            if (elementoVenta[i][2] != null) {

                //System.out.println("El elemento Venta " + elementoVenta[i][2]);
                nombre_producto[i] = String.valueOf(elementoVenta[i][2]);
            }
        }

        for (int j = 0; j < nombre_producto.length; j++) {

            elegir_producto.addItem(nombre_producto[j]);

        }

        add(elegir_producto);

        cantidad = new JLabel("Cantidad");
        cantidad.setBounds(30, 180, 100, 30);
        add(cantidad);

        campo_cantidad_producto = new JTextField();
        campo_cantidad_producto.setBounds(200, 180, 150, 30);
        add(campo_cantidad_producto);

        agregar = new JButton("Agregar");
        agregar.setBounds(250, 230, 100, 30);
        add(agregar);

        ingresados_venta = new JLabel("Ingresados en la venta");
        ingresados_venta.setBounds(130, 280, 150, 30);
        add(ingresados_venta);

        Agregar agrega = new Agregar();
        agregar.addActionListener(agrega);

    }

    public void setElemento(Object[][] elementoVenta) {

        this.elementoVenta = elementoVenta; // proviene de la clase VentanaVentas

    }

    private class Agregar implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int contador = 0;

            for (int d = 0; d < elementoVenta.length; d++) {

                if (campo_nit_cliente.getText().equals(elementoVenta[d][1])) {

                    // System.out.println("El NIT ingresado ya existe  en la posicion " + d + " " + elementoVenta[d][0]);
                    //JOptionPane.showMessageDialog(null, "El Producto ingresado ya existe");
                }
                contador++; // suma 1 al contador si ya existe el NIT

                if (contador == 1) {
                    if (campo_nit_cliente.getText().equals(elementoVenta[d][1]) == false) {

                        JOptionPane.showMessageDialog(null, "El NIT ingresado no existe");

                    }
                }
            }

            int contador1 = 0;

            String[] cantidad_productos = new String[500];
            int[] cantidades = new int[500];
            

            for (int b = 0; b < cantidad_productos.length; b++) {

                if (elementoVenta[b][3] != null) {

                    cantidad_productos[b] = String.valueOf(elementoVenta[b][3]);

                    //System.out.println("El valor de cantidad_productos es " + b + " = " + cantidad_productos[b]);
                }
            }

            for (int c = 0; c < cantidades.length; c++) {

                if (cantidad_productos[c] != null) { // colocar esto sino dara error

                    cantidades[c] = Integer.valueOf(cantidad_productos[c]);

                    // System.out.println("El valor de cantidades " + c + " = " + cantidades[c]);
                }
            }

            int contador2 = 0;
            int contador3 = 0;
            
            int campo_cantidades = Integer.parseInt(campo_cantidad_producto.getText());
            
           // System.out.println("El valor de la cantidad sumada ANTES de ingresar al if (cantidad_sumada<=5) "+cantidad_sumada);
            
           /* if(cantidad_sumada<=5){
            
             cantidad_sumada = (cantidad_sumada+cantidad_maxima);
             System.out.println("El valor (dentro del if) de la cantidad_sumada = "+cantidad_sumada);
            
            }*/
            
            cantidad_sumada =(cantidad_sumada + campo_cantidades);
            System.out.println("El valor de la cantidad_sumada ANTES de entrar al if es " + cantidad_sumada);
            
            
            
            for (int a = 0; a < elementoVenta.length; a++) {

                if (elementoVenta[a][2] != null) {

                    if (elegir_producto.getSelectedItem().equals(elementoVenta[a][2])) {

                        //System.out.println("El producto elegido es " + elegir_producto.getSelectedItem());

                        for (int b = 0; b < cantidades.length; b++) {

                            //System.out.println("La cantidad ingresada es " + campo_cantidad_producto.getText() + " o "
                            // + campo_cantidades);
                            if (contador3 < 5) {

                                if (contador2 == 0) { // para que imprime una sola vez el mensaje "La cantidad ingresa x existe"
                                    // if (cantidades[b] != 0) {
                                    if (campo_cantidades <= cantidades[a]) {

                                        if (cantidad_sumada <= 5) {

                                            System.out.println("La cantidad ingresada campo_cantidades " + campo_cantidades + " SI existe " + b+"\n");
                                           
                                            cantidad_sumada = (cantidad_sumada+campo_cantidades);
                                             System.out.println("El valor (dentro del if) de la cantidad_sumada es = "+cantidad_sumada);
                                        }  
                                        
                                        if(cantidad_sumada>5){

                                            System.out.println("No puede ingresar mas de 5 productos, Porfavor vuelva a ingresar la informacion" );
                                            JOptionPane.showMessageDialog(null, "No puede ingresar mas de 5 productos, vuelva a ingresar la informacion");
                                           
                                            cantidad_sumada = 0;
                                            System.out.println("El valor de la cantidad_sumada reseteada es "+cantidad_sumada+"\n");
                                            campo_cantidad_producto.setText("");
                                            campo_nit_cliente.setText("");
                                         }

                                        

                                    } else {

                                        System.out.println("La cantidad ingresada NO existe " + b);
                                        JOptionPane.showMessageDialog(null, "La cantidad ingresada NO existe");

                                    }

                                    contador2++;
                                }
                            }
                            //System.out.println("El valor de contador3 es "+contador3);
                            contador3++;
                        }
                    }

                }
                contador1++;

                /* if (contador == 1) {
                    if (campo_cantidad_producto.getText().equals(elementoVenta[a][3]) == false) {

                        JOptionPane.showMessageDialog(null, "La cantidad ingresada no existe");

                    }
                }*/
            }

        }

    }

}
