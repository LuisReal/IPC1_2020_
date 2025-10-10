package practica2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class VentanaPrueba extends JFrame {

    JScrollPane scroll;

    public VentanaPrueba() {

        setLayout(null);

        setTitle("Ventana Prueba");
        setBounds(100, 100, 500, 500);

        Lamina lamina = new Lamina();
        lamina.setBackground(new Color(200, 200, 200));
        lamina.setBorder(LineBorder.createBlackLineBorder());

        scroll = new JScrollPane();
        scroll.setViewportView(lamina);
        scroll.setBounds(10, 10, 400, 400);

        lamina.setPreferredSize(new Dimension(500, 800));

        add(scroll);

    }
}

class Lamina extends JPanel {

    JButton boton;

    public Lamina() {

        setLayout(null);

        boton = new JButton("Boton");
        boton.setBounds(10, 500, 100, 30);
        add(boton);

    }

}
