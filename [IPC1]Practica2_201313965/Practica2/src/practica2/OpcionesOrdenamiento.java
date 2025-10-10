package practica2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class OpcionesOrdenamiento extends JFrame {

    public OpcionesOrdenamiento(CargaMasiva carga, String titulo, String[][] datos, int num_lineas) {

        setLayout(null);

        setTitle("Opciones de Ordenamiento");
        setBounds(450, 200, 403, 430);
        setResizable(false);

        LaminaTipoOrdenamiento orden = new LaminaTipoOrdenamiento(carga, titulo, datos, num_lineas, this);
        orden.setBounds(5, 5, 386, 387);
        orden.setBorder(LineBorder.createBlackLineBorder());
        add(orden);

    }

}

class LaminaTipoOrdenamiento extends JPanel {

    JLabel tipo;

    ButtonGroup grupo1;
    JRadioButton ascendente;
    JRadioButton descendente;
    
    OpcionesOrdenamiento opor;

    public LaminaTipoOrdenamiento(CargaMasiva carga, String titulo, String[][] datos, int num_lineas, OpcionesOrdenamiento opor) {

        setLayout(null);
        
        this.opor = opor;

        tipo = new JLabel("Tipo de Ordenamiento");
        tipo.setBounds(10, 10, 200, 30);
        add(tipo);

        grupo1 = new ButtonGroup();

        ascendente = new JRadioButton("Ascendente", true);
        ascendente.setBounds(10, 50, 100, 30);
        add(ascendente);

        descendente = new JRadioButton("Descendente", false);
        descendente.setBounds(250, 50, 100, 30);
        add(descendente);

        grupo1.add(ascendente);
        grupo1.add(descendente);

        LaminaVelocidadOrdenamiento velocidad = new LaminaVelocidadOrdenamiento(this);
        velocidad.setBounds(5, 110, 190, 200);
        velocidad.setBorder(LineBorder.createBlackLineBorder());
        add(velocidad);

        AlgoritmoOrdenamiento algoritmo = new AlgoritmoOrdenamiento(velocidad);
        algoritmo.setBounds(200, 110, 180, 200);
        algoritmo.setBorder(LineBorder.createBlackLineBorder());
        add(algoritmo);

        OrdenarCancelar botones = new OrdenarCancelar(algoritmo, carga, titulo, datos, num_lineas);
        botones.setBounds(5, 315, 375, 65);
        botones.setBorder(LineBorder.createBlackLineBorder());
        add(botones);

    }

}

class LaminaVelocidadOrdenamiento extends JPanel {

    JLabel velocidad;

    ButtonGroup grupo2;

    JRadioButton baja;
    JRadioButton media;
    JRadioButton alta;

    LaminaTipoOrdenamiento tipo;

    public LaminaVelocidadOrdenamiento(LaminaTipoOrdenamiento tipo) {

        setLayout(null);

        this.tipo = tipo;

        velocidad = new JLabel("Velocidad de Ordenamiento");
        velocidad.setBounds(10, 10, 200, 30);
        add(velocidad);

        baja = new JRadioButton("Baja", true);
        baja.setBounds(10, 50, 100, 30);
        add(baja);

        media = new JRadioButton("Media", false);
        media.setBounds(10, 90, 100, 30);
        add(media);

        alta = new JRadioButton("Alta", false);
        alta.setBounds(10, 130, 100, 30);
        add(alta);

        grupo2 = new ButtonGroup();

        grupo2.add(baja);
        grupo2.add(media);
        grupo2.add(alta);

    }

}

class AlgoritmoOrdenamiento extends JPanel {

    JLabel algoritmo;

    ButtonGroup grupo3;

    JRadioButton bubble;
    JRadioButton quick;
    JRadioButton shell;

    LaminaVelocidadOrdenamiento velocidad;

    public AlgoritmoOrdenamiento(LaminaVelocidadOrdenamiento velocidad) {

        setLayout(null);

        this.velocidad = velocidad;

        algoritmo = new JLabel("Algoritmo de Ordenamiento");
        algoritmo.setBounds(10, 10, 200, 30);
        add(algoritmo);

        bubble = new JRadioButton("BubbleSort", true);
        bubble.setBounds(10, 50, 100, 30);
        add(bubble);

        quick = new JRadioButton("QuickSort", false);
        quick.setBounds(10, 90, 100, 30);
        add(quick);

        shell = new JRadioButton("ShellSort", false);
        shell.setBounds(10, 130, 100, 30);
        add(shell);

        grupo3 = new ButtonGroup();

        grupo3.add(bubble);
        grupo3.add(quick);
        grupo3.add(shell);

    }

}

class OrdenarCancelar extends JPanel {

    JButton ordenar;
    JButton cancelar;

    AlgoritmoOrdenamiento algoritmo;

    CargaMasiva carga;
    String titulo;
    String[][] datos;
    int num_lineas;

    public OrdenarCancelar(AlgoritmoOrdenamiento algoritmo, CargaMasiva carga, String titulo, String[][] datos, int num_lineas) {

        setLayout(null);
        this.algoritmo = algoritmo;

        this.carga = carga;
        this.titulo = titulo;
        this.datos = datos;
        this.num_lineas = num_lineas;

        ordenar = new JButton("Ordenar");
        ordenar.setBounds(90, 20, 100, 30);
        add(ordenar);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(200, 20, 100, 30);
        add(cancelar);

        Ordenar orden = new Ordenar();
        ordenar.addActionListener(orden);
        
        Cancelar cancela = new Cancelar();
        cancelar.addActionListener(cancela);

    }
    
    private class Cancelar implements ActionListener{
    
        public void actionPerformed(ActionEvent a){
        
            algoritmo.velocidad.tipo.opor.dispose();
            
        
        }
    
    }

    private class Ordenar implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String velocidad = "";

            

            if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                
                velocidad = "1";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad, orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            } else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "2";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad,orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            } else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "3";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad, orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            }

            if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "1";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad,orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "2";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad,orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.bubble.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "3";

                BubbleSort bubble = new BubbleSort(carga, titulo, datos, num_lineas, velocidad,orden);
                bubble.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bubble.setVisible(true);

            }
            
            
        //*****************************QUICK SORT *******************************************************    
            
            if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                
                velocidad = "1";

                QuickSort quick1 = new QuickSort(carga, titulo, datos, num_lineas, velocidad, orden);
                quick1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick1.setVisible(true);

            }else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "2";

                QuickSort quick2 = new QuickSort(carga, titulo, datos, num_lineas, velocidad,orden);
                quick2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick2.setVisible(true);

            } else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "3";

                QuickSort quick3 = new QuickSort(carga, titulo, datos, num_lineas, velocidad, orden);
                quick3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick3.setVisible(true);

            }
            
            
            if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "1";

                QuickSort quick1 = new QuickSort(carga, titulo, datos, num_lineas, velocidad,orden);
                quick1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick1.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "2";

                QuickSort quick2 = new QuickSort(carga, titulo, datos, num_lineas, velocidad,orden);
                quick2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick2.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.quick.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "3";

                QuickSort quick3 = new QuickSort(carga, titulo, datos, num_lineas, velocidad,orden);
                quick3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                quick3.setVisible(true);

            }
            
            //*****************************SHELL SORT *******************************************************
            
            if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                
                velocidad = "1";

                ShellSort shell1 = new ShellSort(carga, titulo, datos, num_lineas, velocidad, orden);
                shell1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell1.setVisible(true);

            }else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "2";

                ShellSort shell2 = new ShellSort(carga, titulo, datos, num_lineas, velocidad,orden);
                shell2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell2.setVisible(true);

            } else if (algoritmo.velocidad.tipo.ascendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.ascendente.getText();
                velocidad = "3";

                ShellSort shell3 = new ShellSort(carga, titulo, datos, num_lineas, velocidad, orden);
                shell3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell3.setVisible(true);

            }
            
            
            if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.baja.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "1";

                ShellSort shell1 = new ShellSort(carga, titulo, datos, num_lineas, velocidad,orden);
                shell1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell1.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.media.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "2";

                ShellSort shell2 = new ShellSort(carga, titulo, datos, num_lineas, velocidad,orden);
                shell2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell2.setVisible(true);

            } else if (algoritmo.velocidad.tipo.descendente.isSelected() && algoritmo.velocidad.alta.isSelected() && algoritmo.shell.isSelected()) {

                String orden = algoritmo.velocidad.tipo.descendente.getText();
                velocidad = "3";

                ShellSort shell3 = new ShellSort(carga, titulo, datos, num_lineas, velocidad,orden);
                shell3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shell3.setVisible(true);

            }
            
        }// fin del metodo actionPerformed

    }

}
