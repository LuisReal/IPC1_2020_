package proyecto1;

import javax.swing.*;
import java.awt.event.*;

public class VentanaVentas extends JFrame {

    private LaminaVentanaVentas lamina_ventas;

    public VentanaVentas(Object[][] elementoProducto) {

        setTitle("Administracion de Ventas");
        setBounds(200, 200, 400, 400);
        setResizable(false);

        lamina_ventas = new LaminaVentanaVentas(elementoProducto);
        add(lamina_ventas);
    }

    public Object[][] getElementoVentas() {
        return lamina_ventas.getElementoVentas();
    }
    
    public String[][] getArregloProductos() {
        return lamina_ventas.getArregloProductos();
    }

}

class LaminaVentanaVentas extends JPanel {

    JButton dashboard;
    JButton cargaVentas;
    JButton creacion_ventas;
    JButton consulta;

    public static Object[][] elementoVenta;
    public static Object[][] elementoProducto;
    private DashboardVentas dash2;
    public static ImageIcon icono;
    public String[][] arregloProductos;

    public LaminaVentanaVentas(Object[][] elementoProducto) {
        LaminaVentanaVentas.elementoProducto = elementoProducto;

        setLayout(null);

        cargaVentas = new JButton("Cargar Ventas");
        cargaVentas.setBounds(100, 50, 200, 30);
        add(cargaVentas);

        dashboard = new JButton("Dashboard Ventas");
        dashboard.setBounds(100, 100, 200, 30);
        add(dashboard);

        creacion_ventas = new JButton("Creacion Ventas");
        creacion_ventas.setBounds(100, 150, 200, 30);
        add(creacion_ventas);

        consulta = new JButton("Consulta Ventas");
        consulta.setBounds(100, 200, 200, 30);
        add(consulta);

        CargarVentas carga = new CargarVentas();
        cargaVentas.addActionListener(carga);

        DashboardVentasOyente dashventas = new DashboardVentasOyente();
        dashboard.addActionListener(dashventas);

        CrearVentas nuevav = new CrearVentas();
        creacion_ventas.addActionListener(nuevav);

        ConsultarVentas consultar = new ConsultarVentas();
        consulta.addActionListener(consultar);

    }

    public Object[][] getElementoVentas() {
        return elementoVenta;
    }
    
    public String[][] getArregloProductos() {
        return arregloProductos;
    }

    private class CargarVentas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            CargaMasivaVentas carga = new CargaMasivaVentas();
            elementoVenta = carga.elementoVenta;
        }

    }

    private class DashboardVentasOyente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (elementoVenta == null) {

                JOptionPane.showMessageDialog(null, "No ha cargado los datos todavia");

            } else {
                dash2 = new DashboardVentas(elementoVenta, elementoProducto);
                arregloProductos = dash2.getArregloProductos();
                dash2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dash2.setVisible(true);

            }

        }

    }

    private class CrearVentas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Object[][] elementoVenta, String[] producto_unico
            if (dash2 != null) {
                CrearVenta nueva = new CrearVenta(elementoVenta, elementoProducto, dash2.getArregloProductoUnico(), dash2.getArregloCantidadProductos());
                nueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nueva.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Tiene que dar click en dashboard primero");
            }

        }
    }

    private class ConsultarVentas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent w) {

            if (dash2 != null) {
                ConsultarVenta miConsulta = new ConsultarVenta();
                miConsulta.setElementos(elementoVenta, elementoProducto);
                miConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                miConsulta.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Tiene que dar click en dashboard primero");
            }
        }

    }
}
