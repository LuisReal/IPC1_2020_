
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Administracion extends JFrame {
    
    JButton clientes;
    JButton productos;
    JButton ventas;
    JButton reportes;
    
    public Administracion(){
    
        setLayout(null);
        setBounds(250,300,500,400);
        setTitle("ADMINISTRACION"); //hoLA
        setResizable(false);
        
        clientes = new JButton("Administracion de Clientes");
        clientes.setBounds(150,100,200,30);
        add(clientes);
        
        productos = new JButton("Administracion de Productos");
        productos.setBounds(150,150,200,30);
        add(productos);
        
        ventas = new JButton("Administracion de Ventas");
        ventas.setBounds(150,200,200,30);
        add(ventas);
        
        reportes = new JButton("Reportes");
        reportes.setBounds(150,250,200,30);
        add(reportes);
        
        Clientes clientes1 = new Clientes();
        clientes.addActionListener(clientes1);
        
        Productos productos1 = new Productos();
        productos.addActionListener(productos1);
        
        Ventas ventas1 = new Ventas();
        ventas.addActionListener(ventas1);
        
    }
    
    private class Clientes implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
        
            VentanaClientes ventana1 = new VentanaClientes();
            
            ventana1.setVisible(true);
        
        }
    
    
    }
    
    private class Productos implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
        
            VentanaProductos ventana2 = new VentanaProductos();
            
            ventana2.setVisible(true);
        
        }
    
    
    }
    
    private class Ventas implements ActionListener{
    
        public void actionPerformed(ActionEvent v){
        
            VentanaVentas ventana3 = new VentanaVentas();
            ventana3.setVisible(true);
        
        }
    
    
    }

   
    
}
