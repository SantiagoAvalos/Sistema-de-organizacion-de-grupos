import java.util.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuariox
 */
public class Principal extends javax.swing.JFrame implements DatosD {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        agregar_materias();
        
        //Matriculas preecargadas
        Matriculas.add("20080094");
        Matriculas.add("20080098");
        Matriculas.add("20080105");
        Matriculas.add("20080071");
        Matriculas.add("20090459");       
        Matriculas.add("20080077");
        Matriculas.add("19070257");
        Matriculas.add("20080114");
        Matriculas.add("20080102");
        Matriculas.add("20080104");
        
        //Nombres preecargados
        Nombres.add("AVALOS FRANCO SANTIAGO EMMANUEL");
        Nombres.add("CORONEL CHAVEZ JOHANA");
        Nombres.add("GUAJARDO MONTAÑO JAMIE JAZMIN");
        Nombres.add("MUÑOZ RAMIREZ JESUS EMILIANO");
        Nombres.add("SANDOVAL MACHADO BRAYAN DANIEL");        
        Nombres.add("ESPINOZA MARTINEZ KARYME");
        Nombres.add("GARCÍA BLANCO FRANCISCO JAVIER ");
        Nombres.add("BALDERAS ZARAGOZA ARIANA ELIZABETH");
        Nombres.add("JIMENEZ GUERRERO JESUS ROGELIO");
        Nombres.add("GARCIA SOTO ANGEL ADRIAN");
        
        
        //Numero de Lista precargado
        Num.add("3");
        Num.add("4");
        Num.add("2");
        Num.add("5");
        Num.add("1");
        Num.add("6");
        Num.add("10");
        Num.add("7");
        Num.add("8");
        Num.add("9");
    }
    
    List Nose = new ArrayList();
    DefaultComboBoxModel m = new DefaultComboBoxModel(); 
    DefaultComboBoxModel M = new DefaultComboBoxModel(); 
    DefaultComboBoxModel or = new DefaultComboBoxModel();
    
    LinkedList<String> Matriculas = new LinkedList<>();//Datos preecargados    
    LinkedList<String> Nombres = new LinkedList<>();//Datos preecargados
    LinkedList<String> Num = new LinkedList<>();//Datos preecargados
    
    
    
    //Aqui se ira definiendo el grupo al cual pertenecera dependiendo de la carrera, turno, cuatrimestre y grupo que haya seleccionado
    public static LinkedList<String> Grupo_Asignado = new LinkedList<>();
    
    //Metodo temporal para comprobar que los datos se esten almacenando
    public void mostrar_informacion(){
        JOptionPane.showMessageDialog(rootPane,Numero_Lista.getLast()+" "+ Nombres_Guardados.getLast() + "\n" + Matriculas_Guardadas.getLast() + "\n" + Carreras.getLast() + "\n" + Turno.getLast() + "\n" + Cuatrimestres.getLast() + "\n" + Grupos.getLast());
    }
    
    int [] ordenamiento = new int [10];
    
    public void ordenar_seleccion(){
        or.removeAllElements();
        int contador = 0;
        for (int i = 0; i < ordenamiento.length; i++) {
            ordenamiento[i] = Integer.parseInt(cbCuatrimestre.getItemAt(i));
        }
        
        int aux;
        for (int v = 0; v < ordenamiento.length - 1; v++) {
            aux = ordenamiento[v];
            int posicion = v;
            for (int z = v + 1; z < ordenamiento.length; z++) {
                if (ordenamiento[z] < aux) {
                    aux = ordenamiento[z];
                    posicion = z;
                }
            }
            if (posicion != v) {
                int aux2 = ordenamiento[v];
                ordenamiento[v] = ordenamiento[posicion];
                ordenamiento[posicion] = aux2;
                contador++;
            }
        }
        
        for (int i = 0; i < ordenamiento.length; i++) {
            or.addElement(ordenamiento[i]);
        }
        
        cbCuatrimestre.setModel(or);
        jLabel16.setText("" + contador);
    }
    
     public void almacenar_alumnos(){
            for (int i = 0; i < Matriculas.size(); i++) {
              if (txt_Matricula.getText().equals(Matriculas.get(i))) {
                Numero_Lista.add(Num.get(i)); 
                Nombres_Guardados.add(Nombres.get(i));
                Matriculas_Guardadas.add(Matriculas.get(i));
                Carreras.add(Carrera.getSelectedItem().toString());
                Cuatrimestres.add(cbx_Cuatrimestre.getSelectedItem().toString());
                Grupos.add(cbx_Grupo.getSelectedItem().toString());
                if (TurnoM.isSelected()) {
                    Turno.add("Turno matutino");
                }else if(TurnoV.isSelected()){
                    Turno.add("Turno vespertino");
                }else if(TurnoN.isSelected()){
                    Turno.add("Turno nocturno");
                    }   
                }   
            }
            
            //A partir de este switch se viene una cantidad de codigo innecesariamente grande para asignarle un grupo a cada alumno
            switch(Carrera.getSelectedItem().toString()){
             case "ITI"://ITI
                //TURNO MATUTINO GRUPO A 
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_1A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_2A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_3A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_4A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_5A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_6A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_7A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_8A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_9A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_10A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10A TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITI TURNO MATUTINO GRUPO B
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_1B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_2B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_3B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_4B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_5B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_6B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_7B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_8B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_9B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_10B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10B TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITI TURNO MATUTINO GRUPO C
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_1C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_2C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_3C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_4C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_5C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_6C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_7C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_8C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_9C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_10C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10C TM");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // ITI TURNO VESPERTINO GRUPO A
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITI_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10A TV");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITI TURNO VESPERTINO GRUPO B
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_2B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_3B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_4B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_5B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_6B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_7B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_8B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_9B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_10B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10B TV");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITI TURNO VESPERTINO GRUPO C
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_1C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 1C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_2C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_3C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 3C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_4C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 4C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_5C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 5C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_6C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 6C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_7C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 7C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_8C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 8C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_9C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 9C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITI_10C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 10C TV");
                }
             break;//cierre case 0 
             
             case "IBIO"://IBIO
                //TURNO MATUTINO GRUPO A 
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_1A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_2A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_3A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_4A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_5A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_6A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_7A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_8A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_9A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_10A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10A TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IBIO TURNO MATUTINO GRUPO B
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_1B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_2B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_3B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_4B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_5B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_6B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_7B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_8B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_9B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_10B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10B TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IBIO TURNO MATUTINO GRUPO C
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_1C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_2C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_3C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_4C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_5C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_6C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_7C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_8C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_9C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_10C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10C TM");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // IBIO TURNO VESPERTINO GRUPO A
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    IBIO_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10A TV");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IBIO TURNO VESPERTINO GRUPO B
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITI_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITI 2B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    IBIO_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10B TV");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IBIO TURNO VESPERTINO GRUPO C
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 1C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 3C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 4C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 5C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 6C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 7C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 8C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 9C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    IBIO_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 10C TV");
                }
             break;//cierre case 1
             
             case "IAEV"://IAEV
                //TURNO MATUTINO GRUPO A 
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_1A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_2A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 2A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_3A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_4A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_5A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_6A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_7A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_8A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_9A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_10A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10A TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IAEV TURNO MATUTINO GRUPO B
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_1B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_2B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 2B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_3B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_4B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_5B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_6B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_7B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_8B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_9B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_10B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10B TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IAEV TURNO MATUTINO GRUPO C
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_1C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_2C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 2C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_3C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_4C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_5C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_6C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_7C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_8C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_9C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_10C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10C TM");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // IAEV TURNO VESPERTINO GRUPO A
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 2A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    IAEV_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10A TV");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IAEV TURNO VESPERTINO GRUPO B
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_2B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 2B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_3B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_4B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_5B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_6B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_7B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_8B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_9B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    IAEV_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10B TV");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // IAEV TURNO VESPERTINO GRUPO C
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_1C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 1C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_2C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IBIO 2C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_3C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 3C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_4C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 4C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_5C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 5C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_6C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 6C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_7C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 7C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_8C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 8C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_9C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 9C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    IAEV_10C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("IAEV 10C TV");
                }
             break;//cierre case 2
             
             case "ITM"://ITM
                //TURNO MATUTINO GRUPO A 
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_1A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_2A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_3A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_4A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_5A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_6A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_7A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_8A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_9A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_10A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10A TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO MATUTINO GRUPO B
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_1B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_2B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_3B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_4B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_5B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_6B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_7B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_8B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_9B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_10B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10B TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO MATUTINO GRUPO C
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_1C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_2C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_3C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_4C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_5C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_6C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_7C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_8C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_9C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_10C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10C TM");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // ITM TURNO VESPERTINO GRUPO A
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10A TV");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO VESPERTINO GRUPO B
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_2B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_3B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_4B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_5B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_6B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_7B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_8B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_9B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_10B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10B TV");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO VESPERTINO GRUPO C
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_1C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_2C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_3C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_4C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_5C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_6C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_7C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_8C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_9C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_10C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10C TV");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // ITM TURNO NOCTURNO GRUPO A
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_1A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_2A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_3A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_4A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_5A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_6A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_7A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_8A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_9A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9A TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    ITM_10A_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10A TN");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO NOCTURNO GRUPO B
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_1B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_2B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_3B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_4B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_5B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_6B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_7B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_8B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_9B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9B TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    ITM_10B_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10B TN");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // ITM TURNO NOCTURNO GRUPO C
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_1C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 1C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_2C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 2C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_3C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 3C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_4C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 4C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_5C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 5C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_6C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 6C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_7C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 7C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_8C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 8C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_9C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 9C TN");
                }
                if (TurnoN.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    ITM_10C_TN.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("ITM 10C TN");
                }
             break;//cierre case 3
             
             case "LNI"://LNI
                //TURNO MATUTINO GRUPO A 
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_1A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_2A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_3A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_4A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_5A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_6A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_7A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_8A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_9A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9A TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_10A_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10A TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // LNI TURNO MATUTINO GRUPO B
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_1B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_2B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_3B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_4B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_5B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_6B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_7B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_8B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_9B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9B TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_10B_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10B TM");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // LNI TURNO MATUTINO GRUPO C
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_1C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_2C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_3C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_4C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_5C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_6C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_7C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_8C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_9C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9C TM");
                }
                if (TurnoM.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_10C_TM.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10C TM");
                }
                
                //FJSDALKGFJLSADGJLASDJGFPSOADFJSAÑLOGJLISDAFGJSADPOIGJSAPODIJFGPOSADJGFPOSADJGPOSADJGFPASDOJGPOASDJGPSAODS
                
                // LNI TURNO VESPERTINO GRUPO A
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_1A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_2A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_3A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_4A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_5A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_6A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_7A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_8A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_9A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9A TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 0) {
                    LNI_10A_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10A TV");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                // LNI TURNO VESPERTINO GRUPO B
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_2B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_3B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_4B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_5B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_6B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_7B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_8B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_9B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9B TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 1) {
                    LNI_1B_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10B TV");
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                // LNI TURNO VESPERTINO GRUPO C
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 0 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_1C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 1C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 1 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_2C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 2C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 2 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_3C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 3C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 3 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_4C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 4C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 4 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_5C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 5C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 5 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_6C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 6C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 6 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_7C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 7C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 7 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_8C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 8C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 8 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_9C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 9C TV");
                }
                if (TurnoV.isSelected() && cbx_Cuatrimestre.getSelectedIndex() == 9 && cbx_Grupo.getSelectedIndex() == 2) {
                    LNI_10C_TV.add(Matriculas_Guardadas.getLast() + " " + Nombres_Guardados.getLast());
                    Grupo_Asignado.add("LNI 10C TV");
                }
             break;//cierre case 2
             
             
         }//cierre del switch
        
    }
    
    
    
    public void agregar_materias(){
        if (cbCarrera.getSelectedIndex() == 0) {
            agregar_materias_iti();
        }
        if (cbCarrera.getSelectedIndex() == 1) {
            agregar_materias_itm();
        }
        if (cbCarrera.getSelectedIndex() == 2) {
            agregar_materias_ibio();
        }
        if (cbCarrera.getSelectedIndex() == 3) {
            agregar_materias_iaev();
        }
        if (cbCarrera.getSelectedIndex() == 4) {
            agregar_materias_lni();
        }
    }
    
    public void agregar_materias_iti(){
        switch(cbCuatrimestre.getSelectedIndex())
        {
         case 0:
            m.removeAllElements();
            m.addElement("INGLES I");
            m.addElement("QUIMICA BASICA");
            m.addElement("ALGEBRA LINEAL");
            m.addElement("INTRODUCCION A LA PROGRAMACION");
            m.addElement("INTRODUCCION A LAS TECNOLOGIAS DE INFORMACION");
            m.addElement("HERRAMIENTAS OFIMATICAS");
            m.addElement("EXPRESION ORAL Y ESCRITA I");
            cbMateria.setModel(m);
         break;
         
         case 1:
            m.removeAllElements();
            m.addElement("INGLES II");
            m.addElement("DESARROLLO HUMANO Y VALORES");
            m.addElement("FUNCIONES MATEMATICAS");
            m.addElement("FISICA");
            m.addElement("ELECTRICIDAD Y MAGNETISMO");
            m.addElement("MATEMATICAS BASICAS PARA COMPUTACION");
            m.addElement("ARQUITECTURA DE COMPUTADORAS");
            cbMateria.setModel(m);
         break;
         
         case 2:
            m.removeAllElements();
            m.addElement("INGLES III");
            m.addElement("INTELIGENCIA EMOCIONAL Y MANEJO DE CONFLICTOS");
            m.addElement("CALCULO DIFERENCIAL");
            m.addElement("PROBABILIDAD Y ESTADISTICA");
            m.addElement("PROGRAMACION");
            m.addElement("INTRODUCCION A REDES");
            m.addElement("MANTENIMIENTO A EQUIPO DE COMPUTO");
            cbMateria.setModel(m);
         break;
         case 3:
            m.removeAllElements();
            m.addElement("INGLES IV");
            m.addElement("HABILIDADES COGNITIVAS Y CREATIVIDAD");
            m.addElement("CALCULO INTEGRAL");
            m.addElement("INGENIERIA DE SOFTWARE");
            m.addElement("ESTRUCTURA DE DATOS");
            m.addElement("RUTEO Y CONMUTACION");
            m.addElement("ESTANCIA I");
            cbMateria.setModel(m);
         break;
         
         case 4:
            m.removeAllElements();
            m.addElement("INGLES V");
            m.addElement("ETICA PROFESIONAL");
            m.addElement("MATEMATICAS PARA INGENIERIA I");
            m.addElement("FISICA PARA INGENIERIA");
            m.addElement("FUNDAMENTOS DE PROGRAMACION ORIANTADA A OBJETOS");
            m.addElement("ESCALAMIENTO DE REDES");
            m.addElement("BASE DE DATOS");
            cbMateria.setModel(m);
         break;
         
         case 5:
            m.removeAllElements();
            m.addElement("INGLES VI");
            m.addElement("HABILIDADES GERENCIALES");
            m.addElement("MATEMATICAS PARA INGENIERIA II");
            m.addElement("SISTEMAS OPERATIVOS");
            m.addElement("PROGRAMACION ORIENTADA A OBJETOS");
            m.addElement("INTERCONEXION DE REDES");
            m.addElement("ADMINISTRACION DE BASE DE DATOS");
            cbMateria.setModel(m);
         break;
         
         case 6:
            m.removeAllElements();
            m.addElement("INGLES VII");
            m.addElement("LIDERAZGO DE EQUIPOS DE ALTO DESEMPEÑO");
            m.addElement("FORMULACION DE PROYECTOS DE TECNOLOGIAS DE INGORMACION");
            m.addElement("LENGUAJES Y AUTOMATAS");
            m.addElement("PROGRAMACION WEB");
            m.addElement("INGENIERIA DE REQUISITOS");
            m.addElement("ESTANCIA II");
            cbMateria.setModel(m);
         break;
         
         case 7:
            m.removeAllElements();
            m.addElement("INGLES VIII");
            m.addElement("TECNOLOGIAS DE VIRTUALIZACION");
            m.addElement("ADMINISTRACION DE PROYECTOS DE TECNOLOGIAS DE INFORMACION");
            m.addElement("TECNOLOGIAS Y APLICACIONES EN INTERNET");
            m.addElement("DISEÑO DE INTERFACES");
            m.addElement("SISTEMAS INTELIGENTES");
            m.addElement("GESTION DE DESARROLLO DE SOFTWARE");
            cbMateria.setModel(m);
         break;
         
         case 8:
            m.removeAllElements();
            m.addElement("INGLES IX");
            m.addElement("INTELIGENCIA DE NEGOCIOS");
            m.addElement("DESARROLLO DE NEGOCIOS PARA TECNOLOGIAS DE INFORMACION");
            m.addElement("SISTEMAS EMBEBIDOS");
            m.addElement("PROGRAMACION MOVIL");
            m.addElement("SEGURIDAD INFORMATICA");
            m.addElement("EXPRESION ORAL Y ESCRITA II");
            cbMateria.setModel(m);
         break;
         
         case 9:
            m.removeAllElements();
            m.addElement("ESTADIA PROFESIONAL");
            cbMateria.setModel(m);
         break;
        }
    }
    
    public void agregar_materias_itm(){
        switch(cbCuatrimestre.getSelectedIndex())
        {
         case 0:
            m.removeAllElements();
            m.addElement("INGLES I");
            m.addElement("DESARROLLO HUMANO Y VALORES");
            m.addElement("FUNCIONES MATEMATICAS");
            m.addElement("ALGEBRA LINEAL");
            m.addElement("METROLOGIA PARA LA MANUFACTURA");
            m.addElement("SEGURIDAD, HIGIENE Y SUSTENTABILIDAD");
            m.addElement("EXPRESION ORAL Y ESCRITA I");
            cbMateria.setModel(m);
         break;
         
         case 1:
            m.removeAllElements();
            m.addElement("INGLES II");
            m.addElement("INTELIGENCIA EMOCIONAL Y MANEJO DE CONFLICTOS");
            m.addElement("CALCULO DIFERENCIAL");
            m.addElement("PROBABILIDAD Y ESTADISTICA");
            m.addElement("FUNDAMENTOS DE LA CALIDAD");
            m.addElement("DIBUJO INDUSTRIAL");
            m.addElement("ESTUDIO DEL TRABAJO");
            cbMateria.setModel(m);
         break;
         
         case 2:
            m.removeAllElements();
            m.addElement("INGLES III");
            m.addElement("HABILIDADES COGNITIVAS Y CREATIVIDAD");
            m.addElement("CALCULO INTEGRAL");
            m.addElement("QUIMICA BASICA");
            m.addElement("GESTION DE LA CALIDAD");
            m.addElement("DIBUJO PARA INGENIERIA");
            m.addElement("PROCESOS PRIMARIOS DE MANUFACTURA");
            cbMateria.setModel(m);
         break;
         case 3:
            m.removeAllElements();
            m.addElement("INGLES IV");
            m.addElement("ETICA PROFESIONAL");
            m.addElement("MATAMATICAS PARA INGENIERIA I");
            m.addElement("FISICA");
            m.addElement("SISTEMAS AVANZADOS DE LA CALIDAD");
            m.addElement("INGENIERIA DE PLASTICOS");
            m.addElement("ESTANCIA I");
            cbMateria.setModel(m);
         break;
         
         case 4:
            m.removeAllElements();
            m.addElement("INGLES V");
            m.addElement("HABILIDADES GERENCIALES");
            m.addElement("MATEMATICAS PARA INGENIERIA");
            m.addElement("ELECTRICIDAD Y MAGNETISMO");
            m.addElement("FUNDAMENTOS DE MECANICA");
            m.addElement("ESTRUCTURA Y PROPIEDADES DE LOS MATERIALES");
            m.addElement("PROCESOS SECUNDARIOS DE MANUFACTURA");
            cbMateria.setModel(m);
         break;
         
         case 5:
            m.removeAllElements();
            m.addElement("INGLES VI");
            m.addElement("LIDERAZGO DE EQUIPOS DE ALTO DESEMPEÑO");
            m.addElement("TERMODINAMICA");
            m.addElement("ELECTRICIDAD Y ELECTRONICA INSUSTRIAL");
            m.addElement("MECANICA DE MATERIALES PARA MANUFACTURA");
            m.addElement("MANTENIMIENTO INDUSTRIAL");
            m.addElement("PROCESOS ESPECIALES DE MANUFACTURA");
            cbMateria.setModel(m);
         break;
         
         case 6:
            m.removeAllElements();
            m.addElement("INGLES VII");
            m.addElement("FISICA PARA INGENIERIA");
            m.addElement("LOGICA DIGITAL PARA LA MANUFACTURA");
            m.addElement("DISEÑO DEL PRODUCTO");
            m.addElement("SISTEMAS NEUMATICOS E HIDRAULICOS");
            m.addElement("PRONOSTICOS E INVENTARIOS");
            m.addElement("ESTANCIA II");
            cbMateria.setModel(m);
         break;
         
         case 7:
            m.removeAllElements();
            m.addElement("INGLES VIII");
            m.addElement("ADMINISTRACION FINANCIERA");
            m.addElement("CONTROLADORES LOGICOS PROGRAMABLES");
            m.addElement("INGENIERIA ASISTIDA PRO COMPUTADORA");
            m.addElement("DISEÑO Y MANUFACTURA ASISTIDA POR COMPUTADORA");
            m.addElement("INVESTIGACION DE OPERACIONES");
            m.addElement("SISTEMAS DE PRODUCCION");
            cbMateria.setModel(m);
         break;
         
         case 8:
            m.removeAllElements();
            m.addElement("INGLES IX");
            m.addElement("FORMULACION Y EVALUACION DE PROYECTOS");
            m.addElement("MANUFACTURA INTEGRADA POR COMPUTADORA");
            m.addElement("LEAN SIX SIGMA");
            m.addElement("TOPICOS DE NUEVAS TECNOLOGIAS DE MANUFACTURA");
            m.addElement("SIMULACION DE PROCESOS DE MANUFACTURA");
            m.addElement("EXPRESION ORAL Y ESCRITA II");
            cbMateria.setModel(m);
         break;
         
         case 9:
            m.removeAllElements();
            m.addElement("ESTADIA PROFESIONAL");
            cbMateria.setModel(m);
         break;
        }
    }
    
    public void agregar_materias_ibio(){
        switch(cbCuatrimestre.getSelectedIndex())
        {
         case 0:
            m.removeAllElements();
            m.addElement("INGLES I");
            m.addElement("QUIMICA BASICA");
            m.addElement("ALGEBRA LINEAL");
            m.addElement("QUIMICA ORGANICA");
            m.addElement("FISICA PARA INGENIERIA");
            m.addElement("BIOTECNOLOGIA Y DESARROLLO SUSTENTABLE");
            m.addElement("EXPRESION ORAL Y ESCRITA I");
            cbMateria.setModel(m);
         break;
         
         case 1:
            m.removeAllElements();
            m.addElement("INGLES II");
            m.addElement("DESARROLLO HUMANO Y VALORES");
            m.addElement("FUNCIONES MATEMATICAS");
            m.addElement("PROBABILIDAD Y ESTADISTICA");
            m.addElement("QUIMICA INORGANICA");
            m.addElement("BIOLOGIA");
            m.addElement("QUIMICA ANALITICA");
            cbMateria.setModel(m);
         break;
         
         case 2:
            m.removeAllElements();
            m.addElement("INGLES III");
            m.addElement("INTELIGENCIA EMOCIONAL Y MANEJO DE CONFLICTOS");
            m.addElement("CALCULO DIFERENCIAL");
            m.addElement("FUNDAMENTOS DE MICROBIOLOGIA");
            m.addElement("BIOQUIMICA");
            m.addElement("TERMODINAMICA");
            m.addElement("ANALISIS DE BIOPRODUCTOS");
            cbMateria.setModel(m);
         break;
         case 3:
            m.removeAllElements();
            m.addElement("INGLES IV");
            m.addElement("HABILIDADES COGNITIVAS Y CREATIVIDAD");
            m.addElement("CALCULO INTEGRAL");
            m.addElement("BALANCE DE MATERIA Y ENERGIA");
            m.addElement("MICROBIOLOGIA AVANZADA");
            m.addElement("FISICOQUIMICA");
            m.addElement("ESTANCIA I");
            cbMateria.setModel(m);
         break;
         
         case 4:
            m.removeAllElements();
            m.addElement("INGLES V");
            m.addElement("ETICA PROFESIONAL");
            m.addElement("MATEMATICAS PARA INGENIERIA I");
            m.addElement("BIOCATALISIS");
            m.addElement("FUNDAMENTOS DE BIOPROCESOS");
            m.addElement("FENOMENOS DE TRANSPORTE");
            m.addElement("BIOLOGIA MOLECULAR");
            cbMateria.setModel(m);
         break;
         
         case 5:
            m.removeAllElements();
            m.addElement("INGLES VI");
            m.addElement("HABILIDADES GERENCIALES");
            m.addElement("MATEMATICAS PARA INGENIERIA II");
            m.addElement("OPERACIONES UNITARIAS");
            m.addElement("INGENIERIA DE BIORREACTORES");
            m.addElement("CONTROL ESTADISTICO");
            m.addElement("INGENIERIA GENETICA");
            cbMateria.setModel(m);
         break;
         
         case 6:
            m.removeAllElements();
            m.addElement("INGLES VII");
            m.addElement("LIDERAZGO DE EQUIPOS DE ALTO DESEMPEÑO");
            m.addElement("BIOINFORMATICA");
            m.addElement("INGENIERIA DE BIOPROCESOS");
            m.addElement("INGENIERIA DE PROYECTOS");
            m.addElement("ESTANCIA II");
            cbMateria.setModel(m);
         break;
         
         case 7:
            m.removeAllElements();
            m.addElement("INGLES VIII");
            m.addElement("BIOSEGURIDAD E HIGIENE");
            m.addElement("CONTROL DE BIOPROCESOS");
            m.addElement("METABOLOMICA");
            m.addElement("CONTROL DE CALIDAD");
            m.addElement("BIOTECNOLOGIA AMBIENTAL");
            m.addElement("BIOTECNOLOGIA AGROPECUARIA");
            cbMateria.setModel(m);
         break;
         
         case 8:
            m.removeAllElements();
            m.addElement("INGLES IX");
            m.addElement("MEJORA DE BIOPROCESOS");
            m.addElement("BIOTECNOLOGIA EN ALIMENTOS");
            m.addElement("BIOTECNOLOGIA MEDICO-FARMACEUTICA");
            m.addElement("GESTION DE PROYECTOS");
            m.addElement("EXPRESION ORAL Y ESCRITA II");
            cbMateria.setModel(m);
         break;
         
         case 9:
            m.removeAllElements();
            m.addElement("ESTADIA PROFESIONAL");
            cbMateria.setModel(m);
         break;
        }
    }
    
    public void agregar_materias_iaev(){
        switch(cbCuatrimestre.getSelectedIndex())
        {
         case 0:
            m.removeAllElements();
            m.addElement("INGLES I");
            m.addElement("VALORES DEL SER");
            m.addElement("HISTORIA DEL ARTE Y LA ANIMACION");
            m.addElement("ANATOMIA HUMANA Y ANIMAL");
            m.addElement("NARRATIVA");
            m.addElement("REGIONAL 1");
            m.addElement("ALGEBRA LINEAL");
            cbMateria.setModel(m);
         break;
         
         case 1:
            m.removeAllElements();
            m.addElement("INGLES II");
            m.addElement("INTELIGENCIA EMOCIONAL");
            m.addElement("DIBUJO DIGITAL");
            m.addElement("DIBUJO ARTISTICO Y TECNICAS DE REPRESENTACION");
            m.addElement("GUIONISMO");
            m.addElement("TEORIA DEL COLOR");
            m.addElement("CALCULO DIFERENCIAL E INTEGRAL");
            cbMateria.setModel(m);
         break;
         
         case 2:
            m.removeAllElements();
            m.addElement("INGLES III");
            m.addElement("DESARROLLO INTERPERSONAL");
            m.addElement("FUNDAMENTOS DE LA ANIMACION");
            m.addElement("SEMIOTICA Y CREACION DE PERSONAJES");
            m.addElement("TALLER DE MODELADO");
            m.addElement("STORYBOARD");
            m.addElement("FUNDAMENTOS DE FISICA");
            cbMateria.setModel(m);
         break;
         case 3:
            m.removeAllElements();
            m.addElement("INGLES IV");
            m.addElement("HABILIDADES DEL PENSAMIENTO");
            m.addElement("ANIMACION 2D");
            m.addElement("INTRODUCCIO AL MODELADO 3D");
            m.addElement("FUNDAMENTOS DE FOTOGRAFIA");
            m.addElement("PROBABILIDAD Y ESTADISTICA");
            m.addElement("ESTANCIA I");
            cbMateria.setModel(m);
         break;
         
         case 4:
            m.removeAllElements();
            m.addElement("INGLES V");
            m.addElement("HABILIDADES ORGANIZACIONALES");
            m.addElement("CARACTERIZACION DE PERSONAJES 3D");
            m.addElement("DISEÑO DE ESCENARIOS EN MAQUETA");
            m.addElement("EDICION Y COMPOSICION FOTOGRAFICA");
            m.addElement("INTRODUCCION A LA ANIMACION 3D");
            m.addElement("GRABACION DE AUDIO");
            cbMateria.setModel(m);
         break;
         
         case 5:
            m.removeAllElements();
            m.addElement("INGLES VI");
            m.addElement("ETICA PROFESIONAL");
            m.addElement("DIRECCION ARTISTICA");
            m.addElement("TECNICAS DE CINE");
            m.addElement("RIGGING");
            m.addElement("REGIONAL 2");
            m.addElement("DISEÑO DE AUDIO");
            cbMateria.setModel(m);
         break;
         
         case 6:
            m.removeAllElements();
            m.addElement("INGLES VII");
            m.addElement("CINEMATOGRAFIA");
            m.addElement("ANIMACION DE PERSONAJES 3D");
            m.addElement("MERCADOTECNIA");
            m.addElement("FUNDAMENTOS Y PRODUCCION DE EFECTOS VISUALES");
            m.addElement("REGIONAL 3");
            m.addElement("ESTANCIA II");
            cbMateria.setModel(m);
         break;
         
         case 7:
            m.removeAllElements();
            m.addElement("INGLES VIII");
            m.addElement("RIGGIN AVANZADO");
            m.addElement("GESTION DE PROYECTOS");
            m.addElement("DINAMICOS Y FLUIDOS");
            m.addElement("COMPOSICION DE EFECTOS");
            m.addElement("PAINTING 3D");
            m.addElement("REGIONAL 4");
            cbMateria.setModel(m);
         break;
         
         case 8:
            m.removeAllElements();
            m.addElement("INGLES IX");
            m.addElement("ANIMAION 3D AVANZADA");
            m.addElement("EMPRENDEDOR");
            m.addElement("DINAMICOS Y CABELLO Y TELAS");
            m.addElement("RENDERING");
            m.addElement("PROPIEDAD INTELECTUAL");
            m.addElement("REGIONAL 5");
            cbMateria.setModel(m);
         break;
         
         case 9:
            m.removeAllElements();
            m.addElement("ESTADIA PROFESIONAL");
            cbMateria.setModel(m);
         break;
        }
    }
    
    public void agregar_materias_lni(){
        switch(cbCuatrimestre.getSelectedIndex())
        {
         case 0:
            m.removeAllElements();
            m.addElement("INGLES I");
            m.addElement("VALORES DEL SER");
            m.addElement("CONTABILIDAD");
            m.addElement("PLANEACION Y ORGANIZACION");
            m.addElement("INTRODUCCION A LAS MATEMATICAS");
            m.addElement("ECONOMIA");
            m.addElement("FUNDAMENTOS DE NEGOCIOS INTERNACIONALES");
            cbMateria.setModel(m);
         break;
         
         case 1:
            m.removeAllElements();
            m.addElement("INGLES II");
            m.addElement("INTELIGENCIA EMOCIONAL");
            m.addElement("CONTABILIDAD DE COSTOS");
            m.addElement("DIRECCION Y CONTROL");
            m.addElement("CALCULO DIFERENCIAL E INTEGRAL");
            m.addElement("HERRAMIENTAS OFIMATICAS");
            m.addElement("GEOGRAFIA ECONOMICA INTERNACIONAL");
            cbMateria.setModel(m);
         break;
         
         case 2:
            m.removeAllElements();
            m.addElement("INGLES III");
            m.addElement("DESARROLLO INTERPERSONAL");
            m.addElement("MATEMATICAS FINANCIERAS");
            m.addElement("ADMINISTRACION DEL CAPITAL HUMANO");
            m.addElement("METODOLOGIA DE LA INVESTIGACION");
            m.addElement("LEGISLACION APLICADA A LOS NEGOCIOS");
            m.addElement("MERCADOTECNIA INTERNACIONAL");
            cbMateria.setModel(m);
         break;
         case 3:
            m.removeAllElements();
            m.addElement("INGLES IV");
            m.addElement("HABILIDADES DEL PENSAMIENTO");
            m.addElement("FINANZAS CORPORATIVAS");
            m.addElement("ADMINISTRACION DE LA PRODUCCION");
            m.addElement("PROBABILIDAD Y ESTADISTICA");
            m.addElement("DERECHO FISCAL Y FINANCIERO");
            m.addElement("ESTANCIA I");
            cbMateria.setModel(m);
         break;
         
         case 4:
            m.removeAllElements();
            m.addElement("INGLES V");
            m.addElement("HABILIDADES ORGANIZACIONALES");
            m.addElement("COMERCIO EXTERIOR");
            m.addElement("GESTION DE LA CALIDAD");
            m.addElement("METODOS CUANTITATIVOS PARA LA TOMA DE DESICIONES");
            m.addElement("TRATADOS Y ORGANISMOS PARA LOS NEGOCIOS INTERNACIONALES");
            m.addElement("CREDITO Y COBRANZA INTERNACIONAL");
            cbMateria.setModel(m);
         break;
         
         case 5:
            m.removeAllElements();
            m.addElement("INGLES VI");
            m.addElement("ETICA PROFESIONAL");
            m.addElement("ECONOMIA INTERNACIONAL");
            m.addElement("GESTION DE LA CADENA DE SUMINISTROS");
            m.addElement("INVESTIGACION DE MERCADOS INTERNACIONALES");
            m.addElement("DERECHO ADUANERO");
            m.addElement("TECNOLOGIAS DE INFORMACION APLICADAS A LOS NEGOCIOS");
            cbMateria.setModel(m);
         break;
         
         case 6:
            m.removeAllElements();
            m.addElement("INGLES VII");
            m.addElement("OPORTUNIDADES DE NEGOCIOS");
            m.addElement("DISEÑO DE PRONOSTICOS Y PROSPECTIVA");
            m.addElement("LOGISTICA INTERNACIONAL");
            m.addElement("MULTICULTURALIDAD Y PROTOCOLO DE NEGOCIOS");
            m.addElement("DERECHO INTERNACIONAL");
            m.addElement("ESTANCIA II");
            cbMateria.setModel(m);
         break;
         
         case 7:
            m.removeAllElements();
            m.addElement("INGLES VIII");
            m.addElement("PLAN DE NEGOCIOS DE EXPORTACION");
            m.addElement("MERCADOS FINANCIEROS Y BURSATILES");
            m.addElement("DESARROLLO EMPRENDEDOR");
            m.addElement("VENTAS INTERNACIONALES");
            m.addElement("NEGOCIOS Y SUSTENTABILIDAD");
            m.addElement("SEMINARIO DE COMERCIO EXTERIOR");
            cbMateria.setModel(m);
         break;
         
         case 8:
            m.removeAllElements();
            m.addElement("INGLES IX");
            m.addElement("EVALUACION DE PROYECTOS");
            m.addElement("CONSULTORIA");
            m.addElement("SEMINARIO DE HABILIDADES GERENCIALES");
            m.addElement("COMPRAS INTERNACIONALES");
            m.addElement("ADUANAS");
            m.addElement("TURISMO Y TRADICIONES REGIONALES");
            cbMateria.setModel(m);
         break;
         
         case 9:
            m.removeAllElements();
            m.addElement("ESTADIA PROFESIONAL");
            cbMateria.setModel(m);
         break;
        }
    }
    
public void Validar_DatosCA()
{
    if (txt_Matricula.getText().isEmpty() == true || (buttonGroup1.isSelected(TurnoM.getModel())== false && buttonGroup1.isSelected(TurnoV.getModel())== false && buttonGroup1.isSelected(TurnoN.getModel())== false)) {
        JOptionPane.showMessageDialog(this, "Llene toda la informacion solicitada");
    }else if (txt_Matricula.getText().length() < 7){
        JOptionPane.showMessageDialog(this, "Ingrese una matricula valida(No menor a 7 digitos)");
    }else{
        if (Matriculas.contains(txt_Matricula.getText()) == false) {
        JOptionPane.showMessageDialog(this, "Matricula no encontrada en el sistema \n No estas inscrito");
    }else if (Matriculas_Guardadas.contains(txt_Matricula.getText())) {
        JOptionPane.showMessageDialog(this, "Esta matricula ya existe en el sistema\n ingrese una diferente");
    }else {
        almacenar_alumnos();
        JOptionPane.showMessageDialog(this, "Datos almacenados correctamente");
        JOptionPane.showMessageDialog(this, Grupo_Asignado.getLast());
        mostrar_informacion();
        }
    }
}


public void LimpiarD()
{
    txt_NombreD.setText("");
    txt_NumEmpl.setText("");
    txt_HoraI.setText("");
    txt_MinutoI.setText("");
    txt_HoraF.setText("");
    txt_MinutoF.setText("");
}

public void Validar_D()
{
if(txt_NombreD.getText().isEmpty()==true||txt_NumEmpl.getText().isEmpty()==true||txt_HoraI.getText().isEmpty()==true||txt_MinutoI.getText().isEmpty()==true||txt_HoraF.getText().isEmpty()==true||txt_MinutoF.getText().isEmpty()==true)
            {
            JOptionPane.showMessageDialog(this, "Llene toda la informacion solicitada");
            }
         else
        {
          if(NumEmpDoce.contains(Integer.parseInt(txt_NumEmpl.getText())) == true)
            {
                JOptionPane.showMessageDialog(this, "Este numero de empleado ya existe en el sistema\n ingrese uno diferente");
            }
          else 
            {
                if ((Integer.parseInt(txt_HoraI.getText()) <= 7 && Integer.parseInt(txt_MinutoI.getText()) < 30 && HorarioID.getSelectedItem() == "AM")||(Integer.parseInt(txt_HoraF.getText()) <= 7 && Integer.parseInt(txt_MinutoF.getText()) < 30 && HorarioFD.getSelectedItem() == "AM")||(Integer.parseInt(txt_HoraI.getText()) >= 9 && Integer.parseInt(txt_MinutoI.getText()) > 0 && HorarioID.getSelectedItem() == "PM")||(Integer.parseInt(txt_HoraF.getText()) >= 9 && Integer.parseInt(txt_MinutoF.getText()) > 0 && HorarioFD.getSelectedItem() == "PM") )
                        {
                            JOptionPane.showMessageDialog(this, "Horario de trabajo: De 7:30AM a 9:00PM \n Ingrese una hora dentro del horario de trabajo");
                        }
                else
                {
                    if(Integer.parseInt(txt_HoraI.getText())<1 || Integer.parseInt(txt_HoraI.getText())>12 || Integer.parseInt(txt_HoraF.getText())<1 || Integer.parseInt(txt_HoraF.getText())>12 || Integer.parseInt(txt_MinutoI.getText())< 0 || Integer.parseInt(txt_MinutoI.getText())> 59 || Integer.parseInt(txt_MinutoF.getText())< 0 || Integer.parseInt(txt_MinutoF.getText())> 59)
                    {
                        JOptionPane.showMessageDialog(this, "¡Ingrese un Horario valido!");
                    }
                    else
                    {
                        if (txt_NumEmpl.getText().length()<4)
                        {
                        JOptionPane.showMessageDialog(this, "Ingrese un Numero de empleado valido (4 digitos)");
                        }
                        else
                        {
                        NomDoce.add(txt_NombreD.getText());
                        NumEmpDoce.add(Integer.parseInt(txt_NumEmpl.getText()));
                        HoraIDoce.add(txt_HoraI.getText() + ":" + txt_MinutoI.getText() + HorarioID.getSelectedItem());
                        HoraFDoce.add(txt_HoraF.getText() + ":" + txt_MinutoF.getText() + HorarioFD.getSelectedItem());
                        CarreraDoce.add(cbCarrera.getSelectedItem().toString());
                        CuatriDoce.add(cbCuatrimestre.getSelectedItem().toString());
                        MateriaDoce.add(cbMateria.getSelectedItem().toString());
                    
                        JOptionPane.showMessageDialog(this, "¡Docente registrado con exito!"); 
                        LimpiarD(); 
                    
            
                        }
                    }
                }
            }
        }       
        
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbx_Cuatrimestre = new javax.swing.JComboBox<>();
        lbl_Turno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TurnoM = new javax.swing.JRadioButton();
        TurnoV = new javax.swing.JRadioButton();
        TurnoN = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cbx_Grupo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_Matricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_NombreD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_NumEmpl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_MinutoI = new javax.swing.JTextField();
        HorarioID = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_HoraF = new javax.swing.JTextField();
        HorarioFD = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cbCarrera = new javax.swing.JComboBox<>();
        Carrera = new javax.swing.JComboBox<>();
        txt_HoraI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_MinutoF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbCuatrimestre = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Control de organización - UPGOP");

        jButton5.setText("Organizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("Disponibilidad");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton5))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Alumnos");

        cbx_Cuatrimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));

        lbl_Turno.setText("Turno");

        jLabel3.setText("Carrera");

        jLabel4.setText("Cuatrimestre");

        buttonGroup1.add(TurnoM);
        TurnoM.setText("Matutino");
        TurnoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TurnoMActionPerformed(evt);
            }
        });

        buttonGroup1.add(TurnoV);
        TurnoV.setText("Vespertino");
        TurnoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TurnoVActionPerformed(evt);
            }
        });

        buttonGroup1.add(TurnoN);
        TurnoN.setText("Nocturno");
        TurnoN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TurnoNActionPerformed(evt);
            }
        });

        jLabel5.setText("Grupo");

        cbx_Grupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        jLabel7.setText("Matricula");

        txt_Matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MatriculaKeyTyped(evt);
            }
        });

        jButton1.setText("Agregar Alumno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar Alumno");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Docentes");

        jLabel9.setText("Nombre");

        txt_NombreD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreDActionPerformed(evt);
            }
        });
        txt_NombreD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreDKeyTyped(evt);
            }
        });

        jLabel10.setText("Numero de empleado");

        txt_NumEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NumEmplKeyTyped(evt);
            }
        });

        jLabel11.setText("Horario");

        jLabel12.setText("De");

        txt_MinutoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MinutoIActionPerformed(evt);
            }
        });
        txt_MinutoI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MinutoIKeyTyped(evt);
            }
        });

        HorarioID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jLabel13.setText("a");

        txt_HoraF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HoraFActionPerformed(evt);
            }
        });
        txt_HoraF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_HoraFKeyTyped(evt);
            }
        });

        HorarioFD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jLabel14.setText("Carrera:");

        jButton6.setText("Agregar Docente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Buscar Docente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria en Tecnologias de la Informacion(ITI)", "Ingenieria en Tecnologias de Manufactura(ITM)", "Ingenieria en Biotecnologia(IBIO)", "Ingenieria en Animacion y Efectos Visuales(IAEV)", "Licenciatura en Negocios Internacionales(LNI)" }));
        cbCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCarreraActionPerformed(evt);
            }
        });

        Carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITI", "IBIO", "IAEV", "ITM", "LNI" }));
        Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarreraActionPerformed(evt);
            }
        });

        txt_HoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HoraIActionPerformed(evt);
            }
        });
        txt_HoraI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_HoraIKeyTyped(evt);
            }
        });

        jLabel6.setText(":");

        jLabel17.setText(":");

        txt_MinutoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MinutoFActionPerformed(evt);
            }
        });
        txt_MinutoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MinutoFKeyTyped(evt);
            }
        });

        jLabel18.setText("Cuatrimestre:");

        cbCuatrimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "1", "5", "4", "6", "8", "10", "3", "9", "7" }));
        cbCuatrimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuatrimestreActionPerformed(evt);
            }
        });

        jLabel19.setText("Materia:");

        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        jButton4.setText("Ordenar por seleccion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel15.setText("Cantidad de movimientos:");

        jLabel16.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbx_Cuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbx_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel2))
                            .addComponent(Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_Turno)
                            .addComponent(TurnoM)
                            .addComponent(TurnoN)
                            .addComponent(TurnoV)
                            .addComponent(txt_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_NumEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(txt_NombreD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11)
                                .addComponent(jLabel14)
                                .addComponent(jLabel19)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbCuatrimestre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4)))
                            .addGap(58, 58, 58)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13))
                            .addComponent(jLabel12))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_HoraI, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(txt_HoraF))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_MinutoI, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(HorarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_MinutoF, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(HorarioFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton6)
                        .addGap(26, 26, 26)
                        .addComponent(jButton7))
                    .addComponent(jLabel8))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lbl_Turno)
                        .addGap(5, 5, 5)
                        .addComponent(TurnoM)
                        .addGap(0, 0, 0)
                        .addComponent(TurnoV)
                        .addGap(0, 0, 0)
                        .addComponent(TurnoN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(cbx_Cuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NombreD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NumEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_MinutoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HorarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_HoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_MinutoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(HorarioFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txt_HoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Validar_DatosCA();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_NombreDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreDActionPerformed

    private void txt_MinutoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MinutoIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MinutoIActionPerformed

    private void txt_HoraFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HoraFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoraFActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:  
         Validar_D();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarreraActionPerformed

    private void txt_MatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MatriculaKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_Matricula.getText().length() > 8) evt.consume();
        
    }//GEN-LAST:event_txt_MatriculaKeyTyped

    private void txt_NombreDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreDKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if ((n< 'a' || n > 'z') && (n < 'A') | n > 'Z') evt.consume();
        if (txt_NombreD.getText().length() > 25) evt.consume();
    }//GEN-LAST:event_txt_NombreDKeyTyped

    private void txt_NumEmplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NumEmplKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_NumEmpl.getText().length() > 3) evt.consume();
    }//GEN-LAST:event_txt_NumEmplKeyTyped

    private void txt_MinutoIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MinutoIKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_MinutoI.getText().length() > 1) evt.consume();
    }//GEN-LAST:event_txt_MinutoIKeyTyped

    private void txt_HoraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HoraIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoraIActionPerformed

    private void txt_HoraIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HoraIKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_HoraI.getText().length() > 1) evt.consume();
    }//GEN-LAST:event_txt_HoraIKeyTyped

    private void txt_MinutoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MinutoFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MinutoFActionPerformed

    private void txt_MinutoFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MinutoFKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_MinutoF.getText().length() > 1) evt.consume();
    }//GEN-LAST:event_txt_MinutoFKeyTyped

    private void txt_HoraFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HoraFKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_HoraF.getText().length() > 1) evt.consume();
    }//GEN-LAST:event_txt_HoraFKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Visualizar ir = new Visualizar();
        ir.setVisible(true);
        this.dispose();
        ir.lbMatricula.setVisible(true);
        ir.txt_Matricula.setVisible(true);
        ir.lbNumEmpleado.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:          
        Visualizar ir = new Visualizar();
        ir.JLNombre.setVisible(false);
        ir.jTextField1.setVisible(true);
        ir.txt_Num.setVisible(true);
        ir.txt_Num.setEnabled(true);
        ir.lbNumEmpleado.setVisible(true);
        ir.prueba.setVisible(false);
        ir.jLabel7.setVisible(false);
//        ir.JLGrupo.setVisible(false);
        ir.jLabel2.setVisible(true);
        ir.jLabel6.setVisible(false);
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         Organizacion ir = new Organizacion ();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         Disponibles ir = new Disponibles ();
        ir.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cbCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCarreraActionPerformed
        // TODO add your handling code here:
       agregar_materias();
    }//GEN-LAST:event_cbCarreraActionPerformed

    private void cbCuatrimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuatrimestreActionPerformed
        // TODO add your handling code here:
        agregar_materias();
    }//GEN-LAST:event_cbCuatrimestreActionPerformed

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void TurnoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TurnoMActionPerformed
        // TODO add your handling code here:
        M.removeAllElements();
        M.addElement("ITI");
        M.addElement("IBIO");
        M.addElement("IAEV");
        M.addElement("ITM");
        M.addElement("LNI");
        Carrera.setModel(M);
    }//GEN-LAST:event_TurnoMActionPerformed

    private void TurnoNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TurnoNActionPerformed
        // TODO add your handling code here:
        M.removeAllElements();
        M.addElement("ITM");
        Carrera.setModel(M);
    }//GEN-LAST:event_TurnoNActionPerformed

    private void TurnoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TurnoVActionPerformed
        // TODO add your handling code here:
        M.removeAllElements();
        M.addElement("ITI");
        M.addElement("IBIO");
        M.addElement("IAEV");
        M.addElement("ITM");
        M.addElement("LNI");
        Carrera.setModel(M);
    }//GEN-LAST:event_TurnoVActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ordenar_seleccion();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    //Grupos asignados ITI
    public static LinkedList<String> ITI_1A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_2A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_3A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_4A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_5A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_6A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_7A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_8A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_9A_TM = new LinkedList<>();
    public static LinkedList<String> ITI_10A_TM = new LinkedList<>();
    
    public static LinkedList<String> ITI_1B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_2B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_3B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_4B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_5B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_6B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_7B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_8B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_9B_TM = new LinkedList<>();
    public static LinkedList<String> ITI_10B_TM = new LinkedList<>();
    
    public static LinkedList<String> ITI_1C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_2C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_3C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_4C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_5C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_6C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_7C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_8C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_9C_TM = new LinkedList<>();
    public static LinkedList<String> ITI_10C_TM = new LinkedList<>();
    
    //Grupos asignados ITM
    public static LinkedList<String> ITM_1A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_2A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_3A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_4A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_5A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_6A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_7A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_8A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_9A_TM = new LinkedList<>();
    public static LinkedList<String> ITM_10A_TM = new LinkedList<>();
    
    public static LinkedList<String> ITM_1B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_2B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_3B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_4B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_5B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_6B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_7B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_8B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_9B_TM = new LinkedList<>();
    public static LinkedList<String> ITM_10B_TM = new LinkedList<>();
   
    public static LinkedList<String> ITM_1C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_2C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_3C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_4C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_5C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_6C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_7C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_8C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_9C_TM = new LinkedList<>();
    public static LinkedList<String> ITM_10C_TM = new LinkedList<>();
    
    //Grupos asignados IBIO
    public static LinkedList<String> IBIO_1A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_2A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_3A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_4A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_5A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_6A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_7A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_8A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_9A_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_10A_TM = new LinkedList<>();
    
    public static LinkedList<String> IBIO_1B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_2B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_3B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_4B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_5B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_6B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_7B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_8B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_9B_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_10B_TM = new LinkedList<>();
    
    public static LinkedList<String> IBIO_1C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_2C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_3C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_4C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_5C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_6C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_7C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_8C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_9C_TM = new LinkedList<>();
    public static LinkedList<String> IBIO_10C_TM = new LinkedList<>();
    
    //Grupos asignados IAEV
    public static LinkedList<String> IAEV_1A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_2A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_3A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_4A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_5A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_6A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_7A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_8A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_9A_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_10A_TM = new LinkedList<>();
    
    public static LinkedList<String> IAEV_1B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_2B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_3B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_4B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_5B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_6B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_7B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_8B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_9B_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_10B_TM = new LinkedList<>();
    
    public static LinkedList<String> IAEV_1C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_2C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_3C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_4C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_5C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_6C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_7C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_8C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_9C_TM = new LinkedList<>();
    public static LinkedList<String> IAEV_10C_TM = new LinkedList<>();
    
    //Grupos asignados LNI
    public static LinkedList<String> LNI_1A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_2A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_3A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_4A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_5A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_6A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_7A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_8A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_9A_TM = new LinkedList<>();
    public static LinkedList<String> LNI_10A_TM = new LinkedList<>();
    
    public static LinkedList<String> LNI_1B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_2B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_3B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_4B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_5B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_6B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_7B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_8B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_9B_TM = new LinkedList<>();
    public static LinkedList<String> LNI_10B_TM = new LinkedList<>();
    
    public static LinkedList<String> LNI_1C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_2C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_3C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_4C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_5C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_6C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_7C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_8C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_9C_TM = new LinkedList<>();
    public static LinkedList<String> LNI_10C_TM = new LinkedList<>();
    
    //Grupos asignados ITI
    public static LinkedList<String> ITI_1A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_2A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_3A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_4A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_5A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_6A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_7A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_8A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_9A_TV = new LinkedList<>();
    public static LinkedList<String> ITI_10A_TV = new LinkedList<>();
    
    public static LinkedList<String> ITI_1B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_2B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_3B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_4B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_5B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_6B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_7B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_8B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_9B_TV = new LinkedList<>();
    public static LinkedList<String> ITI_10B_TV = new LinkedList<>();
    
    public static LinkedList<String> ITI_1C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_2C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_3C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_4C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_5C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_6C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_7C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_8C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_9C_TV = new LinkedList<>();
    public static LinkedList<String> ITI_10C_TV = new LinkedList<>();
    
    //Grupos asignados ITM
    public static LinkedList<String> ITM_1A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_2A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_3A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_4A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_5A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_6A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_7A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_8A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_9A_TV = new LinkedList<>();
    public static LinkedList<String> ITM_10A_TV = new LinkedList<>();
    
    public static LinkedList<String> ITM_1B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_2B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_3B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_4B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_5B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_6B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_7B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_8B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_9B_TV = new LinkedList<>();
    public static LinkedList<String> ITM_10B_TV = new LinkedList<>();
   
    public static LinkedList<String> ITM_1C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_2C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_3C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_4C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_5C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_6C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_7C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_8C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_9C_TV = new LinkedList<>();
    public static LinkedList<String> ITM_10C_TV = new LinkedList<>();
    
    //Grupos asignados IBIO
    public static LinkedList<String> IBIO_1A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_2A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_3A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_4A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_5A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_6A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_7A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_8A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_9A_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_10A_TV = new LinkedList<>();
    
    public static LinkedList<String> IBIO_1B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_2B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_3B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_4B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_5B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_6B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_7B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_8B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_9B_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_10B_TV = new LinkedList<>();
    
    public static LinkedList<String> IBIO_1C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_2C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_3C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_4C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_5C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_6C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_7C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_8C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_9C_TV = new LinkedList<>();
    public static LinkedList<String> IBIO_10C_TV = new LinkedList<>();
    
    //Grupos asignados IAEV
    public static LinkedList<String> IAEV_1A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_2A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_3A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_4A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_5A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_6A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_7A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_8A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_9A_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_10A_TV = new LinkedList<>();
    
    public static LinkedList<String> IAEV_1B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_2B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_3B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_4B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_5B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_6B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_7B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_8B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_9B_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_10B_TV = new LinkedList<>();
    
    public static LinkedList<String> IAEV_1C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_2C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_3C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_4C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_5C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_6C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_7C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_8C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_9C_TV = new LinkedList<>();
    public static LinkedList<String> IAEV_10C_TV = new LinkedList<>();
    
    //Grupos asignados LNI
    public static LinkedList<String> LNI_1A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_2A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_3A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_4A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_5A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_6A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_7A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_8A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_9A_TV = new LinkedList<>();
    public static LinkedList<String> LNI_10A_TV = new LinkedList<>();
    
    public static LinkedList<String> LNI_1B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_2B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_3B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_4B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_5B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_6B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_7B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_8B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_9B_TV = new LinkedList<>();
    public static LinkedList<String> LNI_10B_TV = new LinkedList<>();
    
    public static LinkedList<String> LNI_1C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_2C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_3C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_4C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_5C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_6C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_7C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_8C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_9C_TV = new LinkedList<>();
    public static LinkedList<String> LNI_10C_TV = new LinkedList<>();
    
    //Grupos asignados ITM
    public static LinkedList<String> ITM_1A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_2A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_3A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_4A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_5A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_6A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_7A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_8A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_9A_TN = new LinkedList<>();
    public static LinkedList<String> ITM_10A_TN = new LinkedList<>();
    
    public static LinkedList<String> ITM_1B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_2B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_3B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_4B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_5B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_6B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_7B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_8B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_9B_TN = new LinkedList<>();
    public static LinkedList<String> ITM_10B_TN = new LinkedList<>();
   
    public static LinkedList<String> ITM_1C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_2C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_3C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_4C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_5C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_6C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_7C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_8C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_9C_TN = new LinkedList<>();
    public static LinkedList<String> ITM_10C_TN = new LinkedList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Carrera;
    private javax.swing.JComboBox<String> HorarioFD;
    private javax.swing.JComboBox<String> HorarioID;
    public static javax.swing.JRadioButton TurnoM;
    private javax.swing.JRadioButton TurnoN;
    public static javax.swing.JRadioButton TurnoV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCarrera;
    private javax.swing.JComboBox<String> cbCuatrimestre;
    private javax.swing.JComboBox<String> cbMateria;
    public static javax.swing.JComboBox<String> cbx_Cuatrimestre;
    public static javax.swing.JComboBox<String> cbx_Grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Turno;
    private javax.swing.JTextField txt_HoraF;
    private javax.swing.JTextField txt_HoraI;
    private javax.swing.JTextField txt_Matricula;
    private javax.swing.JTextField txt_MinutoF;
    private javax.swing.JTextField txt_MinutoI;
    private javax.swing.JTextField txt_NombreD;
    private javax.swing.JTextField txt_NumEmpl;
    // End of variables declaration//GEN-END:variables
}
