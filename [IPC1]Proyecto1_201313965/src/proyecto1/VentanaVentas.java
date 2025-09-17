
package proyecto1;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class VentanaVentas extends JFrame{
    
    public VentanaVentas(){
    
        setTitle("Administracion de Ventas");
        setBounds(200, 200, 400, 400);
        setResizable(false);
    
        LaminaVentanaVentas lamina_ventas = new LaminaVentanaVentas();
        add(lamina_ventas);
    }
    
    
}

class LaminaVentanaVentas extends JPanel{

    JButton dashboard;
    JButton cargaVentas;
    JButton creacion_ventas;
    JButton consulta;
    

    public static Object[][] elementoVenta;
    public static ImageIcon icono;
    
    public LaminaVentanaVentas(){
    
        setLayout(null);

        dashboard = new JButton("Dashboard Ventas");
        dashboard.setBounds(100, 50, 200, 30);
        add(dashboard);

        cargaVentas = new JButton("Carga Masiva");
        cargaVentas.setBounds(100, 100, 200, 30);
        add(cargaVentas);

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
    
    public void setDatos(Object[][] elementoVenta) {

        this.elementoVenta = elementoVenta; // proviene de la clase CargaMasiva
        
        

    }
    
    private class CargarVentas implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            CargaMasivaVentas carga = new CargaMasivaVentas();

        }

    }

    private class DashboardVentasOyente implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            
            
        
        }
    
    }
    
    private class CrearVentas implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
        
            CrearVenta nueva = new CrearVenta(elementoVenta);
            nueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nueva.setVisible(true);
            
            LaminaCrearVenta crear_nueva = new LaminaCrearVenta(elementoVenta);
            crear_nueva.setElemento(elementoVenta); // envia a la clase CrearVenta (en la lamina)
            
            
            
        }
    }
}
