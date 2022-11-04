
import java.util.ArrayList;
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
public class Visualizar extends javax.swing.JFrame implements DatosD,Datos_E  {

    /**
     * Creates new form Visualizar
     */
    public Visualizar() {
        initComponents();
        lbNumEmpleado.setVisible(false);
        lbMatricula.setVisible(false);
        txt_Matricula.setVisible(false);
        txt_Num.setVisible(false);
        jTextField1.setVisible(false);
        jLabel2.setVisible(false);
       if(INOD.isEmpty())
       {
        //Vizualizar info de alumnos
       }
       else
       {
         VisualizarD();  
       }
    }
    int aux = 0;
   public void VisualizarDo()
    {
        if (NumEmpDoce.contains(Integer.parseInt(txt_Num.getText()))== false)
        {
            JOptionPane.showMessageDialog(this, "Este numero de empleado no existe en el sistema");
        } 
        else
        {
         for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                INOD.clear();
                INOD.add(NomDoce.indexOf(NomDoce.get(i)));
             }
         }
         for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                INUD.clear();
                INUD.add(NumEmpDoce.indexOf(NumEmpDoce.get(i)));
             }
         }
         for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                IHID.clear();
                IHID.add(HoraIDoce.indexOf(HoraIDoce.get(i)));
             }
         }
         for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                IHFD.clear();
                IHFD.add(HoraFDoce.indexOf(HoraFDoce.get(i)));
             }
         }
          for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                ICAD.clear();
                ICAD.add(CarreraDoce.indexOf(CarreraDoce.get(i)));
             }
         }
          for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                ICUD.clear();
                ICUD.add(CuatriDoce.indexOf(CuatriDoce.get(i)));
             }
         }
          for (int i=0; i<NumEmpDoce.size(); i++)
         {
             if(txt_Num.getText().equals(NumEmpDoce.get(i).toString()))
             {
                IMD.clear();
                IMD.add(MateriaDoce.indexOf(MateriaDoce.get(i)));
             }
         }
        
        }
    }
    
    Grupos g = new Grupos();
    
    DefaultListModel mostrar_nombres = new DefaultListModel();
    DefaultListModel uno = new DefaultListModel();
    DefaultListModel mostrar_carreras = new DefaultListModel();
    DefaultListModel mostrar_turnos = new DefaultListModel();
    DefaultListModel mostrar_cuatrimestres = new DefaultListModel();
    DefaultListModel mostrar_grupos = new DefaultListModel();
    DefaultListModel pre = new DefaultListModel();
    
    Principal p = new Principal();
    
    ArrayList nombre = new ArrayList();
    ArrayList matricula = new ArrayList();
    
    public void VisualizarD()
    {
        jTextField1.setText(NomDoce.get(INOD.get(0)));
       // txt_Num.setText(NumEmpDoce.get(INUD.get(0)).toString());
        MH.clear();
        MH.addElement("De "+HoraIDoce.get(IHID.get(0)));
        MH.addElement("a "+HoraFDoce.get(IHFD.get(0)));
        JLHora.setModel(MH);
        txt_Carrera1.setText(CarreraDoce.get(ICAD.get(0)));
        txt_Cuatri.setText(CuatriDoce.get(ICUD.get(0)));
        txt_Turno1.setText(MateriaDoce.get(IMD.get(0)));
    }
    
    public void Buscar(){
        if (txt_Matricula.isVisible() == true)
        {
            JOptionPane.showMessageDialog(this, aux);
            for(int x = 0; x<AlumnosA.size(); x++)
                {
                    if(jTextField1.getText().equals(AlumnosA.get(x))==true)
                    {
                        aux = x;
                        JOptionPane.showMessageDialog(this, aux);
                    }
                }
            aux = Indice.get(aux);
            JOptionPane.showMessageDialog(this, aux);
            Prueba.clear();
            Prueba.addElement(H.get(aux));
        for (int i = 0; i < p.Matriculas_Guardadas.size(); i++) {
            if (txt_Matricula.getText().equals(p.Matriculas_Guardadas.get(i))) {
                mostrar_nombres.clear();
                mostrar_carreras.clear();
                mostrar_turnos.clear();
                mostrar_cuatrimestres.clear();
                mostrar_grupos.clear();
                mostrar_nombres.addElement(p.Nombres_Guardados.get(i));
                mostrar_carreras.addElement(p.Carreras.get(i));
                mostrar_turnos.addElement(p.Turno .get(i));
                mostrar_cuatrimestres.addElement(p.Cuatrimestres.get(i));
                mostrar_grupos.addElement(p.Grupos.get(i));
                JLNombre.setModel(mostrar_nombres);
                //JLCarrera.setModel(mostrar_carreras);
                //JLTurno.setModel(mostrar_turnos);
                //JLCuatri.setModel(mostrar_cuatrimestres);
                //JLGrupo.setModel(mostrar_grupos);
               
                uno.clear();
                uno.addElement(p.Grupo_Asignado.get(i));
                JLHora.setModel(uno);
                JLHora.setModel(Prueba);
                pre.clear();
                pre.addElement(p.ITI_1A_TM);
                prueba.setModel(pre);
                
                txt_Carrera1.setText(p.Carreras.get(i));
                txt_Turno1.setText(p.Turno .get(i));
                txt_Cuatri.setText(p.Cuatrimestres.get(i));
                jTextField3.setText(p.Grupos.get(i));
                
            }
        }
        }
        else 
        {
            VisualizarDo();
            VisualizarD();
        }
    }
    public void ModD()
    {
       NumEmpDoce.add(INOD.get(0), Integer.parseInt(txt_Num.getText()));
       NomDoce.add(INOD.get(0), jTextField1.getText());
       CarreraDoce.add(INOD.get(0), txt_Carrera1.getText());
       MateriaDoce.add(INOD.get(0), txt_Turno1.getText());
       CuatriDoce.add(INOD.get(0), txt_Cuatri.getText());
    }
    
    public void Modificaralumnos(){
        for (int i = 0; i < Matriculas_Guardadas.size(); i++) {
            
            if (txt_Carrera1.getText()==""||txt_Turno1.getText()==""||txt_Cuatri.getText()==""||jTextField3.getText()==""){
            JOptionPane.showMessageDialog(this, "Favor de llenar todos los campos");
        }else if(Carreras.get(i).equals(txt_Carrera1.getText()) && Turno.get(i).equals(txt_Turno1.getText()) && Cuatrimestres.get(i).equals(txt_Cuatri) && Grupos.get(i).equals(jTextField3)){
                JOptionPane.showMessageDialog(this, "Ingrese informacion distinta");
    }else if(txt_Carrera1.getText().equals("ITI") == false && txt_Carrera1.getText().equals("ITM") == false && txt_Carrera1.getText().equals("IBIO") == false && txt_Carrera1.getText().equals("IAEV") == false && txt_Carrera1.getText().equals("LNI") == false){
            JOptionPane.showMessageDialog(this, "Ingrese una carrera valida \n ITI \n IBIO \n IAEV \n ITM \n LNI");
    }else if(Integer.parseInt(txt_Cuatri.getText())>10 || Integer.parseInt(txt_Cuatri.getText())<1){
            JOptionPane.showMessageDialog(this, "Ingrese un cuatrimestre valido \n 1 - 10");
    }else if(jTextField3.getText().equals("A") == false && jTextField3.getText().equals("B") == false && jTextField3.getText().equals("C") == false){
            JOptionPane.showMessageDialog(this, "Ingrese un grupo valido \n A \n B \n C");
    }else{
            
            if (Matriculas_Guardadas.contains(txt_Matricula.getText())) {
                Carreras.add(i, txt_Carrera1.getText());
                Turno.add(i, txt_Turno1.getText());
                Cuatrimestres.add(i, txt_Cuatri.getText());
                Grupos.add(i, jTextField3.getText());
                JOptionPane.showMessageDialog(this, "Modificacion Exitosa");
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

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbMatricula = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JLHora = new javax.swing.JList<>();
        lbNumEmpleado = new javax.swing.JLabel();
        txt_Num = new javax.swing.JTextField();
        txt_Matricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JLNombre = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        prueba = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txt_Cuatri = new javax.swing.JTextField();
        txt_Carrera1 = new javax.swing.JTextField();
        txt_Turno1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbMatricula.setText("Matricula");
        getContentPane().add(lbMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        btnModificar1.setText("Regresar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, -1, -1));

        jLabel3.setText("Horario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setText("Carrera");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel5.setText("Cuatrimestre");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel6.setText("Turno");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jScrollPane3.setViewportView(JLHora);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 68));

        lbNumEmpleado.setText("Numero de empleado");
        getContentPane().add(lbNumEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Num.setEnabled(false);
        txt_Num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NumKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Num, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 116, -1));

        txt_Matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MatriculaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, -1, -1));

        jLabel7.setText("Grupo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 40));

        jScrollPane1.setViewportView(JLNombre);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 40));

        jScrollPane7.setViewportView(prueba);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 230, 70));

        jLabel2.setText("Materia");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));
        getContentPane().add(txt_Cuatri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 320, 40));
        getContentPane().add(txt_Carrera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 40));
        getContentPane().add(txt_Turno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 320, 40));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 320, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txt_Num.isVisible()==true)
        {
            if(NumEmpDoce.contains(Integer.parseInt(txt_Num.getText()))==true&&NomDoce.contains(jTextField1.getText())==true && CarreraDoce.contains(txt_Carrera1.getText())==true && MateriaDoce.contains(txt_Turno1.getText())==true && CuatriDoce.contains(txt_Cuatri.getText())==true )
            {
                JOptionPane.showMessageDialog(this, "Ingrese Informacion distinta a la actual");
            }
            else if (txt_Num.getText()==""||jTextField1.getText()==""||txt_Carrera1.getText()==""||txt_Turno1.getText()==""||txt_Cuatri.getText()=="")
                    {
                        JOptionPane.showMessageDialog(this, "Favor de llenar todos los campos");
                    }
            else if (Integer.parseInt(txt_Cuatri.getText())>10 || Integer.parseInt(txt_Cuatri.getText())<1)
            {
                JOptionPane.showMessageDialog(this, "Ingrese un cuatrimestre valido");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Modificación exitosa");
                ModD();
            }
        }else{
            Modificaralumnos();
        }
        
        /*else{//modificar alumno
            if(Carreras.contains(txt_Carrera1.getText())==true && Turno.contains(txt_Turno1.getText())==true && Cuatrimestres.contains(txt_Cuatri.getText())==true && Grupos.contains(jTextField3.getText()))
            {
                JOptionPane.showMessageDialog(this, "Ingrese Informacion distinta a la actual");
            }
            else if (txt_Carrera1.getText()==""||txt_Turno1.getText()==""||txt_Cuatri.getText()==""||jTextField3.getText()=="")
                    {
                        JOptionPane.showMessageDialog(this, "Favor de llenar todos los campos");
                        if(txt_Carrera1.getText() != "ITI" || txt_Carrera1.getText() != "ITM" || txt_Carrera1.getText() != "IBIO" || txt_Carrera1.getText() != "IAEV" || txt_Carrera1.getText() != "LNI"){
                            JOptionPane.showMessageDialog(this, "Ingrese una carrera valida \n ITI \n IBIO \n IAEV \n ITM \n LNI");
                    }
                    }
            else if (Integer.parseInt(txt_Cuatri.getText())>10 || Integer.parseInt(txt_Cuatri.getText())<1)
            {
                JOptionPane.showMessageDialog(this, "Ingrese un cuatrimestre valido \n 1 - 10");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Modificación exitosa");
                Modificaralumnos();
            }
        }*/
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        // TODO add your handling code here:
        Principal ir = new Principal ();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void txt_NumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NumKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_Num.getText().length() > 3) evt.consume();
    }//GEN-LAST:event_txt_NumKeyTyped

    private void txt_MatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MatriculaKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (n < '0' || n > '9') evt.consume();
        if (txt_Matricula.getText().length() > 7) evt.consume();
    }//GEN-LAST:event_txt_MatriculaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
         char n = evt.getKeyChar();
        if ((n< 'a' || n > 'z') && (n < 'A') | n > 'Z') evt.consume();
        if (jTextField1.getText().length() > 25) evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JLHora;
    public javax.swing.JList<String> JLNombre;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public static javax.swing.JLabel lbMatricula;
    public static javax.swing.JLabel lbNumEmpleado;
    public javax.swing.JList<String> prueba;
    private javax.swing.JTextField txt_Carrera1;
    private javax.swing.JTextField txt_Cuatri;
    public static javax.swing.JTextField txt_Matricula;
    public javax.swing.JTextField txt_Num;
    private javax.swing.JTextField txt_Turno1;
    // End of variables declaration//GEN-END:variables
}
