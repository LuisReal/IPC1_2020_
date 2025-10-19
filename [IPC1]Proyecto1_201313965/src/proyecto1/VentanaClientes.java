package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaClientes extends JFrame {

    public VentanaClientes() {

        setTitle("Administracion de Clientes");
        setBounds(200, 200, 400, 400);
        setResizable(false);

        Lamina lamina10 = new Lamina();
        add(lamina10);

    }

}

class Lamina extends JPanel {

    JButton dashboard;
    JButton carga;
    JButton creacion_clientes;
    JButton consulta;
    JButton modificar;

    public static Object[][] elemento;
    public static ImageIcon icono;

    public Lamina() {

        setLayout(null);
        
        carga = new JButton("Cargar Clientes");
        carga.setBounds(100, 50, 200, 30);
        add(carga);
        
        dashboard = new JButton("Dashboard Clientes");
        dashboard.setBounds(100, 100, 200, 30);
        add(dashboard);

        creacion_clientes = new JButton("Creacion Clientes");
        creacion_clientes.setBounds(100, 150, 200, 30);
        add(creacion_clientes);

        consulta = new JButton("Consulta Clientes");
        consulta.setBounds(100, 200, 200, 30);
        add(consulta);

        modificar = new JButton("Modificar Clientes");
        modificar.setBounds(100, 250, 200, 30);
        add(modificar);

        CargarClientes cargar1 = new CargarClientes();
        carga.addActionListener(cargar1);

        Dashboard dash = new Dashboard();
        dashboard.addActionListener(dash);

        CrearClientes nuevo = new CrearClientes();
        creacion_clientes.addActionListener(nuevo);

        Consulta consultar = new Consulta();
        consulta.addActionListener(consultar);

        Modificar modifica = new Modificar();
        modificar.addActionListener(modifica);

    }

    public void setDatos(Object[][] elemento) {

        this.elemento = elemento; // proviene de la clase CargaMasiva

    }

    public void setNuevoElemento() {

        Lamina3 lamina = new Lamina3();

        this.elemento = lamina.getElemento(); // proviene de la clase NuevoCliente (Lamina3)

    }

    private class Dashboard implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (elemento == null) {

                JOptionPane.showMessageDialog(null, "No ha cargado los datos todavia");

            } else {
                DashboardClientes dashboard = new DashboardClientes(elemento); // pasa los elementos que proviene de CargaMasiva
                dashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dashboard.setVisible(true);

            }
            

        }

    }

    private class CargarClientes implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            CargaMasivaClientes carga = new CargaMasivaClientes();

        }

    }

    private class CrearClientes implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            NuevoCliente nuevo = new NuevoCliente();
            nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nuevo.setVisible(true);

            Lamina3 elementos = new Lamina3();
            elementos.setElemento(elemento);
            // pasa los valores ingresados por carga masiva (elemento) a NuevoCliente en clase Lamina3

        }

    }

    private class Consulta implements ActionListener {

        public void actionPerformed(ActionEvent w) {

            Consultar consulta = new Consultar();
            consulta.setElemento(elemento); // envia los elementos de la carga masiva + nuevos creados a la clase CONSULTAR
            consulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            consulta.setVisible(true);
        }

    }

    private class Modificar implements ActionListener {

        public void actionPerformed(ActionEvent w) {

            ModificarCliente modifica = new ModificarCliente(); // envia todos los elementos CargaMasiva y NuevoCliente
            modifica.setElemento(elemento);
            modifica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            modifica.setVisible(true);

        }

    }

}// FIN CLASE Lamina
