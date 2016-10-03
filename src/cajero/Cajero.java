/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author intel
 */
public class Cajero extends JFrame implements ActionListener{
    JTextField Nombre,Clave,Sueldo,Cantidad;
    JLabel Texto;
    JButton Termine,Altas,Continuar,Retirar,Depositar,Donar5,Donar10,Donar15;
    
    private ArrayList <Metodos> lista;
public Cajero(){
   super("Cajero");
   //Cosas para la ventana
    setSize(450, 400);//tamaño de la ventana
    setLocation(0, 0); //posicion
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para cuando le den clic a la cruz se cierre el programa
    //Cuadros de texto
        Clave = new JTextField("");
        Clave.setBounds(100, 50, 90, 30);
        add(Clave);
        Clave.setEnabled(true);
        Clave.addActionListener(this);
        
        Nombre = new JTextField("");
        Nombre.setBounds(100, 100, 90, 30);
        add(Nombre);
        Nombre.setEnabled(true);
        Nombre.addActionListener(this);
        
        Sueldo = new JTextField("");
        Sueldo.setBounds(280, 70, 90, 30);
        add(Sueldo);
        Sueldo.setEnabled(false);
        Sueldo.addActionListener(this);
        
        Cantidad = new JTextField("");
        Cantidad.setBounds(120, 250, 90, 30);
        add(Cantidad);
        Cantidad.setEnabled(false);
        Cantidad.addActionListener(this);
    //Botones
        Altas = new JButton("Dar de alta"); 
        Altas.setBounds(60, 200, 100, 15);
        add(Altas); 
        Altas.addActionListener(this);
        
        Termine = new JButton("Terminé"); 
        Termine.setBounds(100, 330, 100, 15);
        add(Termine); 
        Termine.setEnabled(false);
        Termine.addActionListener(this);
        
        Continuar = new JButton("Continuar"); 
        Continuar.setBounds(180, 200, 100, 15);
        add(Continuar); 
        Continuar.addActionListener(this);
        
        Retirar = new JButton("Retirar"); 
        Retirar.setBounds(50, 300, 100, 15);
        add(Retirar);
        Retirar.setEnabled(false);
        Retirar.addActionListener(this);
        
        Depositar = new JButton("Depositar"); 
        Depositar.setBounds(170, 300, 100, 15);
        add(Depositar); 
        Depositar.setEnabled(false);
        Depositar.addActionListener(this);
    //Textos y eso  
        Texto = new JLabel("Ingrese la cantidad que desee retirar/depositar: ");
        Texto.setBounds(40, 225, 300, 10);
        add(Texto);
        
        Texto = new JLabel("Sueldo $ ");
        Texto.setBounds(220,80, 70, 9);
        add(Texto);
        
        Texto = new JLabel("Clave: ");
        Texto.setBounds(40, 110, 70, 9);
        add(Texto);
        
        Texto = new JLabel("Nombre: ");
        Texto.setBounds(40, 60, 70, 9);
        add(Texto);

    // Arreglo para las listas
        lista = new ArrayList();
        
        setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
         String[] options = {"Donar $5", "Donar $10", "Donar $15", "Cancelar"};                   
        String auxiliar = e.getActionCommand();//asignando el "e.getActionCommand();" a una variable de mismo tipo String me ahorro poner este codigo en todas las validaciones
        if (auxiliar.equals("Dar de alta")) {//Digo los eventos correspondientes cuando se di clic en "altas"
            Sueldo.setEnabled(true);
            Altas.setText("Listo");
            Continuar.setEnabled(false);
        }
        if (auxiliar.equals("Listo")) {//Digo los eventos correspondientes cuando se di clic en "altas"
            Metodos persona = new Metodos();
            persona.setClave(Clave.getText());
            persona.setNombre(Nombre.getText());
            persona.setSueldo(Float.parseFloat(Sueldo.getText()));//Convierte los datos del cuadro de texto "Sueldo" a flotantes
            JOptionPane.showMessageDialog(null, "Persona Añadida Exitosamente");//Despliego un mensaje
            lista.add(persona);
            Clave.setText("");
            Nombre.setText("");
            Sueldo.setText("");
            Sueldo.setEnabled(false);
            Altas.setText("Dar de alta");
            Altas.setEnabled(true);
            Continuar.setEnabled(true);
            
        }
        if (auxiliar.equals("Continuar")) {
            int total;
            String clave;
            int regresa = 0;
            Metodos persona = new Metodos();
            total = lista.size();
            clave = this.Clave.getText();
            for (int i = 0; i < total; i++) {
                persona = lista.get(i);
                if (clave.equals(persona.getClave())) {
                    Nombre.setText(persona.getNombre());
                    Sueldo.setText(String.valueOf(persona.getSueldo()));
                    Depositar.setEnabled(true);
                    Retirar.setEnabled(true);
                    Cantidad.setEnabled(true);
                    Termine.setEnabled(true);
                    Altas.setEnabled(false);
                    Continuar.setEnabled(false);
                    regresa = 1;
                    break;
                }
            }
            if (regresa == 0) {
                JOptionPane.showMessageDialog(null, "Persona NO Encontrada");
                Nombre.setEnabled(true);
                
            }
            this.Clave.setEnabled(true);

        }
                    if (auxiliar.equals("Retirar")) {
                    float Resultado;
                    float Menos = new Float(Cantidad.getText());  
                    float Esto = new Float(Sueldo.getText());      
                    Resultado = Esto - Menos;
                    Sueldo.setText(String.valueOf(Resultado));
                    Metodos persona = new Metodos();
                    int total = lista.size();
                    String clave = this.Clave.getText();
                    for (int i = 0; i < total; i++) {
                    persona = lista.get(i);
                    if (clave.equals(persona.getClave())) {
                    persona.setSueldo(Float.parseFloat(Sueldo.getText()));
                    break;
                    
                } 
            }
                    }
                    if (auxiliar.equals("Depositar")) {
                    float Resultado;
                    float Mas = new Float(Cantidad.getText());  
                    float Esto = new Float(Sueldo.getText());      
                    Resultado = Esto + Mas;
                    Sueldo.setText(String.valueOf(Resultado));
                    Metodos persona = new Metodos();
                    int total = lista.size();
                    String clave = this.Clave.getText();
                    for (int i = 0; i < total; i++) {
                    persona = lista.get(i);
                    if (clave.equals(persona.getClave())) {
                    persona.setSueldo(Float.parseFloat(Sueldo.getText()));
                    break;
                    
                } 
            }
        }
                    if (auxiliar.equals("Terminé")) { 
                    int seleccion = JOptionPane.showOptionDialog(null,"¿Desea ayudar a alguien más?","Título", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
                    if (seleccion == 0) {
                    float Resultado;
                    float Mas = 5;  
                    float Esto = new Float(Sueldo.getText());      
                    Resultado = Esto - Mas;
                    Sueldo.setText(String.valueOf(Resultado));
                    Metodos persona = new Metodos();
                    int total = lista.size();
                    String clave = this.Clave.getText();
                    for (int i = 0; i < total; i++) {
                    persona = lista.get(i);
                    if (clave.equals(persona.getClave())) {
                    persona.setSueldo(Float.parseFloat(Sueldo.getText()));
                    break;
                    
                } 
            }
        }
                    if (seleccion == 1) {
                    float Resultado;
                    float Mas = 10;  
                    float Esto = new Float(Sueldo.getText());      
                    Resultado = Esto - Mas;
                    Sueldo.setText(String.valueOf(Resultado));
                    Metodos persona = new Metodos();
                    int total = lista.size();
                    String clave = this.Clave.getText();
                    for (int i = 0; i < total; i++) {
                    persona = lista.get(i);
                    if (clave.equals(persona.getClave())) {
                    persona.setSueldo(Float.parseFloat(Sueldo.getText()));
                    break;
                    
                } 
            }
        }
                    if (seleccion == 2) {
                    float Resultado;
                    float Mas = 15;  
                    float Esto = new Float(Sueldo.getText());      
                    Resultado = Esto - Mas;
                    Sueldo.setText(String.valueOf(Resultado));
                    Metodos persona = new Metodos();
                    int total = lista.size();
                    String clave = this.Clave.getText();
                    for (int i = 0; i < total; i++) {
                    persona = lista.get(i);
                    if (clave.equals(persona.getClave())) {
                    persona.setSueldo(Float.parseFloat(Sueldo.getText()));
                    break;
                    }
                    
                } 
            }
                    Clave.setText("");
                    Nombre.setText("");
                    Sueldo.setText("");
                    Cantidad.setText("");
                    Depositar.setEnabled(false);
                    Retirar.setEnabled(false);
                    Termine.setEnabled(false);
                    Cantidad.setEnabled(false);
                    Altas.setEnabled(true);
                    Continuar.setEnabled(true);
        }
    }
}
