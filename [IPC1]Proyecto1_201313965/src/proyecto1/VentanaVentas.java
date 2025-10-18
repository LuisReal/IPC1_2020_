
package proyecto1;

import javax.swing.*;
import java.awt.event.*;


public class VentanaVentas extends JFrame{
    
    public VentanaVentas(Object [][] elementoProducto){
    
        setTitle("Administracion de Ventas");
        setBounds(200, 200, 400, 400);
        setResizable(false);
    
        LaminaVentanaVentas lamina_ventas = new LaminaVentanaVentas(elementoProducto);
        add(lamina_ventas);
    }
    
    
}

class LaminaVentanaVentas extends JPanel{

    JButton dashboard;
    JButton cargaVentas;
    JButton creacion_ventas;
    JButton consulta;
    

    public static Object[][] elementoVenta;
    public static Object[][] elementoProducto;
    
    public static ImageIcon icono;
    
    public LaminaVentanaVentas(Object [][] elementoProducto){
        this.elementoProducto = elementoProducto;
        
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

        DashboardVentasOyente dashventas =  new DashboardVentasOyente();
        dashboard.addActionListener(dashventas);
        
        CrearVentas nuevav = new CrearVentas();
        creacion_ventas.addActionListener(nuevav);
       
    }
    
    
    private class CargarVentas implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            CargaMasivaVentas carga = new CargaMasivaVentas();
            elementoVenta = carga.elementoVenta;
        }

    }

    private class DashboardVentasOyente implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
            
            
            if (elementoVenta == null) {

                JOptionPane.showMessageDialog(null, "No ha cargado los datos todavia");

            } else {
                DashboardVentas dash2 = new DashboardVentas(elementoVenta);
                dash2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dash2.setVisible(true);

            }
        
        }
    
    }
    
    private class CrearVentas implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
        
            CrearVenta nueva = new CrearVenta(elementoVenta);
            nueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nueva.setVisible(true);
            
            LaminaCrearVenta crear_nueva = new LaminaCrearVenta(elementoVenta);
            crear_nueva.setElemento(elementoVenta); // envia a la clase CrearVenta (en la lamina)
            
            
            
        }
    }
}
