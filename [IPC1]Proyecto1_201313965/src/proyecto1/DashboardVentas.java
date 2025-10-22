package proyecto1;

import javax.swing.*;
import org.jfree.chart.ChartPanel;

public class DashboardVentas extends JFrame {

    private LaminaDashboardVentas lamina_ventas;

    public DashboardVentas(Object[][] elementoVenta, Object[][] elementoProduco) {

        setTitle("Graficas Ventas");
        setBounds(150, 50, 1050, 670);

        lamina_ventas = new LaminaDashboardVentas(elementoVenta, elementoProduco);
        add(lamina_ventas);

    }

    public String[] getArregloProductoUnico() {
        return lamina_ventas.getArregloProductoUnico();
    }

    public int[] getArregloCantidadProductos() {
        return lamina_ventas.getArregloCantidadProductos();
    }
    
    public String[][] getArregloProductos() {
        return lamina_ventas.getArregloProductos();
    }
}

class LaminaDashboardVentas extends JPanel {

    JScrollPane scroll;
    ChartPanel Pie;
    ChartPanel barras;

    public String[] columnas = {"Codigo Venta", "NIT cliente", "Producto", "Cantidad"}; // para usar en la tabla
    public String[] columnas2 = {"Producto", "Cantidad Total"}; // para usar en la tabla

    String[] producto_unico2 = new String[200]; //contiene un arreglo de los productos SIN repetirse
    int[] cantidad_producto_unico = new int[200]; //contiene un arreglo de los productos SIN repetirse
    String[][] arreglo_productos = new String[200][2]; // contiene los productos y las cantidades SIN repetirse

    public LaminaDashboardVentas(Object[][] elementoVenta, Object[][] elementoProducto) {

        setLayout(null);//para poder controlar la posicion de los elementos manualmente

        JLabel etiqueta = new JLabel("DATOS VENTAS");
        etiqueta.setBounds(400, 20, 200, 30);
        add(etiqueta);

        JTable table = new JTable(elementoVenta, columnas);

        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(200, 80, 500, 100);// modifica el tamano de la tabla junto con el scroll
        add(scroll);

        int k = 0;

        int cantidad_producto1;
        int cantidad_producto2;

        System.out.println("\n----------------------ESTOY EN DASHBORAD VENTAS------------------------------");
        //System.out.println("El tamano de elementoVenta es: "+ elementoVenta.length);

        String[] producto_unico = new String[200];

        int producto_repetido = 0;

        for (int j = 0; j < elementoVenta.length; j++) { //el tamaño de elementoVenta es 200

            if (elementoVenta[j][2] != null) { //el archivo de prueba csv contiene 142 valores, por eso se hace esta validacion

                String producto1 = elementoVenta[j][2].toString();

                for (int a = 0; a < producto_unico.length; a++) { //valida si ya se analizo el producto para que no se repita y no se vuelva a sumar

                    if (producto_unico[a] != null && producto_unico[a].equals(producto1)) {
                        producto_repetido++;
                    }
                }

                if (producto_repetido > 0) {
                    producto_repetido = 0;
                    continue;
                }

                cantidad_producto1 = Integer.parseInt(elementoVenta[j][3].toString());

                for (int m = j + 1; m < elementoVenta.length; m++) {

                    if (elementoVenta[m][2] != null) {

                        String producto2 = elementoVenta[m][2].toString();

                        if (producto1.equals(producto2)) {

                            producto_unico[j] = producto1;

                            cantidad_producto2 = Integer.parseInt(elementoVenta[m][3].toString());

                            //System.out.println("El nombre de producto1 es: "+producto1+" En la posicion: "+j+ " y el de producto2 es: "+producto2+" En la posicion: "+m);
                            cantidad_producto1 += cantidad_producto2;

                            //System.out.println("La cantidad_producto1 es: "+cantidad_producto1);
                        }

                    }
                }

                cantidad_producto_unico[j] = cantidad_producto1; //contiene un arreglo de la cantidad de los productos SIN repetirse
                producto_unico2[j] = producto1;  //contiene un arreglo de los productos SIN repetirse

                //System.out.println("\nEl producto es: " + producto1 + " y la cantidad total es: " + cantidad_producto1);
                //System.out.println("Productos "+cantidad_productos[j]);
                k++;

                /*0,128,P35,2
                  0,128,P43,4
                  0,128,P48,1
                  1,143,P27,3*/
            }
        }

        
        int cont = 0;
        //IMPRIMIENDO EL ARREGLO CANTIDAD_PRODUCTO_UNICO
        for (int i = 0; i < cantidad_producto_unico.length; i++) {

            if (cantidad_producto_unico[i] != 0) {

                arreglo_productos[cont][0] = producto_unico2[i];
                arreglo_productos[cont][1] = String.valueOf(cantidad_producto_unico[i]);
                cont++;

                //System.out.println("\nEl productos es: " + producto_unico2[i]);
                //System.out.println("La cantidad es: " + cantidad_producto_unico[i]);
            }

        }

        for (int i = 0; i < arreglo_productos.length - 1; i++) {

            for (int j = 0; j < arreglo_productos.length - 1 - i; j++) {

                if (arreglo_productos[j+1][1] != null) {
                    
                    if (Integer.parseInt(arreglo_productos[j][1]) < Integer.parseInt(arreglo_productos[j + 1][1])) {

                        int temp = Integer.parseInt(arreglo_productos[j][1]);
                        String temp2 = arreglo_productos[j][0];
                        arreglo_productos[j][1] = arreglo_productos[j + 1][1];
                        arreglo_productos[j][0] = arreglo_productos[j + 1][0];
                        arreglo_productos[j + 1][1] = String.valueOf(temp);
                        arreglo_productos[j + 1][0] = temp2;

                    }
                }

            }
        }

        //IMPRIMIENDO EL ARREGLO CANTIDAD_PRODUCTO_UNICO
        for (int i = 0; i < arreglo_productos.length; i++) {

            if (arreglo_productos[i][0] != null) {

                System.out.println("\nEl productos es: " + arreglo_productos[i][0]);
                System.out.println("La cantidad es: " + arreglo_productos[i][1]);
            }

        }

        int mayor, menor;

        mayor = menor = cantidad_producto_unico[0];
        int total_cantidades = 0;
        int posicion_mayor = 0;
        int posicion_menor = 0;

        for (int i = 0; i < cantidad_producto_unico.length; i++) {

            if (cantidad_producto_unico[i] != 0) {

                total_cantidades += cantidad_producto_unico[i];

                if (cantidad_producto_unico[i] > mayor) {

                    mayor = cantidad_producto_unico[i];
                    posicion_mayor = i;
                }

                if (cantidad_producto_unico[i] < menor) {

                    menor = cantidad_producto_unico[i];
                    posicion_menor = i;
                }

            }
        }

        System.out.println("\nLa cantidad mayor es " + mayor + " y el producto es: " + producto_unico2[posicion_mayor]);   //P13 Y P7 son los que mayor cantidad tienen con 16 cada uno
        System.out.println("La cantidad menor es " + menor + " y el producto es: " + producto_unico2[posicion_menor]);
        System.out.println("El total de cantidades es " + total_cantidades);

        String[][] productos_mayor_cantidad = new String[200][4];
        String[][] solo_productos_mayores = new String[200][2];

        int rows = 0;
        int rows2 = 0;

        for (int i = 0; i < producto_unico2.length; i++) {   //producto_unico2 contiene un arreglo de los productos SIN repetirse igual que cantidad_producto_unico

            if (producto_unico2[i] != null && cantidad_producto_unico[i] == mayor) { //cantidad_producto_unico contiene las cantidades de productos SIN repetirse

                solo_productos_mayores[rows2][0] = producto_unico2[i];
                solo_productos_mayores[rows2][1] = String.valueOf(cantidad_producto_unico[i]);
                //System.out.println("\nOBTENIENDO Y ANALIZANDO SEGUNDO RESULTAD0");
                //System.out.println("El producto es: " + solo_productos_mayores[i][0] + " y la cantidad total es: " + solo_productos_mayores[i][1]);
                rows2++;

                for (int j = 0; j < elementoVenta.length; j++) {

                    if (elementoVenta[j][2] != null) {

                        if (producto_unico2[i].equals(elementoVenta[j][2].toString())) {

                            for (int m = 0; m < 4; m++) {
                                productos_mayor_cantidad[rows][m] = elementoVenta[j][m].toString();
                            }

                            rows++;
                        }
                    }

                }

            }

        }

        // -------------------------  Calculando el valor total de las ventas ------------------------------------------
        double total_venta = 0.0;
        double[] array_total_ventas = new double[200];

        for (int i = 0; i < producto_unico2.length; i++) {   //producto_unico2 contiene un arreglo de los productos SIN repetirse igual que cantidad_producto_unico

            if (producto_unico2[i] != null) {

                for (int j = 0; j < elementoProducto.length; j++) {

                    if (elementoProducto[j][0] != null) {

                        if (producto_unico2[i].equals(elementoProducto[j][0].toString())) {

                            double precio = Double.parseDouble(elementoProducto[j][1].toString());
                            double total = Double.valueOf(cantidad_producto_unico[i]) * precio;
                            array_total_ventas[i] = Double.valueOf(cantidad_producto_unico[i]) * precio;

                            total_venta += total;
                        }

                    }

                }

            }

        }

        total_venta = Math.round(total_venta * 100.0) / 100.0;

        System.out.println("\n -------------------EL TOTAL DE VENTAS ES: " + total_venta + " ----------------------");

        // -------------------------- FIN calculo del valor total de las ventas -----------------------------------------
// -------------------------- INICIO calculo del total del producto mas vendido  -----------------------------------------
        double total_venta_mayor = array_total_ventas[0];

        int posicion_mayor2 = 0;

        for (int i = 0; i < array_total_ventas.length; i++) {

            if (array_total_ventas[i] != 0) {

                if (array_total_ventas[i] > total_venta_mayor) {

                    total_venta_mayor = array_total_ventas[i];
                    posicion_mayor2 = i;
                }

            }
        }

        System.out.println("\nLa cantidad VENTA mayor es " + total_venta_mayor + " y el producto es: " + producto_unico2[posicion_mayor2]);

        // -------------------------- FIN calculo del total del producto mas vendido  -----------------------------------------
        /*
        for (int i = 0; i < productos_mayor_cantidad.length; i++) {

            if (productos_mayor_cantidad[i][2] != null) {

                System.out.println("\nCodigo Venta: " + productos_mayor_cantidad[i][0] + " NIT cliente: " + productos_mayor_cantidad[i][1] + " Producto: " + productos_mayor_cantidad[i][2] + " Cantidad: " + productos_mayor_cantidad[i][3]);
            }

        }*/
        JLabel cantidad_mayor = new JLabel("Cantidad Vendida Mayor: ");
        cantidad_mayor.setBounds(100, 550, 200, 30);
        add(cantidad_mayor);

        JLabel valor_mayor = new JLabel(String.valueOf(mayor));
        valor_mayor.setBounds(300, 550, 50, 30);
        add(valor_mayor);

        JLabel etiqueta_total_venta = new JLabel("Total ventas: ");
        etiqueta_total_venta.setBounds(350, 550, 100, 30);
        add(etiqueta_total_venta);

        JLabel valor_total_venta = new JLabel(String.valueOf(total_venta));
        valor_total_venta.setBounds(450, 550, 200, 30);
        add(valor_total_venta);

        JLabel cantidad_venta_mayor = new JLabel("Total Venta Mayor: ");
        cantidad_venta_mayor.setBounds(550, 550, 200, 30);
        add(cantidad_venta_mayor);

        JLabel valor_venta_mayor = new JLabel(String.valueOf(total_venta_mayor));
        valor_venta_mayor.setBounds(670, 550, 50, 30);
        add(valor_venta_mayor);

        // ------ INICIO Total Producto Mayor Venta --------------------
        JLabel etiqueta_venta_mayor = new JLabel("Producto de Mayor Venta: ");
        etiqueta_venta_mayor.setBounds(770, 550, 200, 30);
        add(etiqueta_venta_mayor);

        JLabel total_producto_mayor = new JLabel(String.valueOf(producto_unico2[posicion_mayor2]));
        total_producto_mayor.setBounds(970, 550, 50, 30);
        add(total_producto_mayor);
        // ------ FIN Total Producto Mayor Venta --------------------

        JLabel titulo_table2 = new JLabel("DETALLE DE LA VENTA MAS GRANDE SEGUN CANTIDAD PRODUCTOS VENDIDOS");
        titulo_table2.setBounds(200, 200, 500, 30);
        add(titulo_table2);

        JTable table2 = new JTable(productos_mayor_cantidad, columnas);

        table2.setRowHeight(30);

        scroll = new JScrollPane(table2);
        scroll.setBounds(200, 250, 500, 100);// modifica el tamano de la tabla junto con el scroll
        add(scroll);

        JLabel titulo_table3 = new JLabel("PRODUCTOS MAS VENDIDOS");
        titulo_table3.setBounds(350, 400, 200, 30);
        add(titulo_table3);

        JTable table3 = new JTable(solo_productos_mayores, columnas2);

        table3.setRowHeight(30);

        scroll = new JScrollPane(table3);
        scroll.setBounds(200, 450, 500, 100);// modifica el tamano de la tabla junto con el scroll
        add(scroll);

    }// fin constructor LaminaDashboardVentas

    public String[] getArregloProductoUnico() {

        // ------------- ORDENANDO el arreglo producto_unico2 y el arreglo  cantidad_producto_unico --------------------------
        return producto_unico2;
    }

    public int[] getArregloCantidadProductos() {
        return cantidad_producto_unico;
    }
    
    public String[][] getArregloProductos() {
        return arreglo_productos;
    }
}
