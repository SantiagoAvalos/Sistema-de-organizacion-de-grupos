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
public interface DatosD {
    LinkedList<String> NomDoce = new LinkedList<>();
    LinkedList<Integer> NumEmpDoce = new LinkedList<>();
    LinkedList<String> HoraIDoce = new LinkedList<>();
    LinkedList<String> HoraFDoce = new LinkedList<>();
    LinkedList<String> CarreraDoce = new LinkedList<>();
    LinkedList<String> CuatriDoce = new LinkedList<>();
    LinkedList<String> MateriaDoce = new LinkedList<>();
    //Nose
    LinkedList<String> AlumnosA = new LinkedList<>(); 
    LinkedList<Integer>Indice = new LinkedList<>();
    //Aqui se ira guardando los datos
    LinkedList<String> Numero_Lista = new LinkedList<>();
    LinkedList<String> Nombres_Guardados = new LinkedList<>();    
    LinkedList<String> Matriculas_Guardadas = new LinkedList<>();
    LinkedList<String> Carreras = new LinkedList<>();
    LinkedList<String> Turno = new LinkedList<>();
    LinkedList<String> Cuatrimestres = new LinkedList<>();
    LinkedList<String> Grupos = new LinkedList<>();
    String NL[] = new String[10];
    String NG[] = new String[10];
    
    LinkedList<Integer> INOD = new LinkedList<>();
    LinkedList<Integer> INUD = new LinkedList<>();
    LinkedList<Integer> IHID = new LinkedList<>();
    LinkedList<Integer> IHFD = new LinkedList<>();
    LinkedList<Integer> ICAD = new LinkedList<>();
    LinkedList<Integer> ICUD = new LinkedList<>();
    LinkedList<Integer> IMD = new LinkedList<>();
    
    
    DefaultListModel MH = new DefaultListModel();
    DefaultListModel MN = new DefaultListModel();
    DefaultListModel MC = new DefaultListModel();
    DefaultListModel MCU = new DefaultListModel();
    DefaultListModel MM = new DefaultListModel();
    DefaultListModel Cargar = new DefaultListModel();
    DefaultListModel X = new DefaultListModel();
    
}
