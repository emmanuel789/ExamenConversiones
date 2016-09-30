/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author crixo
 */
public class Convertidor extends JFrame {

    JTextField pantalla;
    double resultado;
    JPanel pNumeros, pOperaciones;
    boolean nuevaOperacion = true;
    String operacion;

    public Convertidor() {
        super();
        setSize(350, 400);
        setTitle("Convertidor de unidades");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        // Caracteristicas del panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(true);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        pNumeros = new JPanel();
        pNumeros.setLayout(new GridLayout(4, 3));
        pNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);

        }
        nuevoBotonNumerico(".");
        panel.add("Center", pNumeros);
        
        pOperaciones = new JPanel();
        pOperaciones.setLayout(new GridLayout(6, 1));
        pOperaciones.setBorder(new EmptyBorder(4,4,4,4));

        nuevoBotonOperacion("Convertir");
        nuevoBotonOperacion("CE");

        panel.add("East", pOperaciones);

        validate();

    }

    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        });
        pNumeros.add(btn);
    }

    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.DARK_GRAY);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });

        pOperaciones.add(btn);
    }

    private void operacionPulsado(String dato) {
        if (dato.equals("Convertir")) {
            resultado = new Double(pantalla.getText());
            calcularOperacion();
        } else if (dato.equals("CE")) {
            pantalla.setText("0");
            resultado = 0;
            nuevaOperacion = true;
        } 
        
        nuevaOperacion = true;
    }


private void calcularOperacion(){
       
        resultado = (resultado/19);
        
        pantalla.setText("" + resultado);
        operacion = "";
        
            
        
    }
}