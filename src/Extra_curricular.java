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
public class Extra_curricular extends javax.swing.JFrame implements Datos_E,DatosD{

    /**
     * Creates new form Extra_curricular
     */
    public Extra_curricular() {
        initComponents();
        for (int i = 0; i <NomDoce.size(); i++)
        {
            jComboBox1.addItem(NomDoce.get(i));
        }
       Cargar.clear();
       for (int i = 0; i<Nombres_Guardados.size(); i++)
       {
           Cargar.addElement(Nombres_Guardados.get(i));
       }
       Alum.setModel(Cargar);
    }
    
 
    public void Validar_A_L()
    {       
        
        
            if(AO.contains(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString())== true || LO.contains(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString())== true)
            {
                JOptionPane.showMessageDialog(this, "Esta Aula o Laboratorio ya esta ocupado");
            }
            else
            {
            if (jTextField1.getText().isEmpty() == true ||  HoraI.getText().isEmpty() == true || HoraF.getText().isEmpty() == true || MinI.getText().isEmpty() == true || MinF.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(rootPane, "Faltan Rellenar Campos");
            }        
            else
            {
                if ((Integer.parseInt(HoraI.getText()) <= 7 && Integer.parseInt(MinI.getText()) < 30 && HorarioI.getSelectedItem() == "AM")||(Integer.parseInt(HoraF.getText()) <= 7 && Integer.parseInt(MinF.getText()) < 30 && HorarioF.getSelectedItem() == "AM")||(Integer.parseInt(HoraI.getText()) >= 9 && Integer.parseInt(MinI.getText()) > 0 && HorarioI.getSelectedItem() == "PM")||(Integer.parseInt(HoraF.getText()) >= 9 && Integer.parseInt(MinF.getText()) > 0 && HorarioF.getSelectedItem() == "PM"))
                {
                    JOptionPane.showMessageDialog(this, "Horario de trabajo: De 7:30AM a 9:00PM \n Ingrese una hora dentro del horario de trabajo");
                }
                if(Integer.parseInt(HoraI.getText())<1 || Integer.parseInt(HoraI.getText())>12 || Integer.parseInt(HoraF.getText())<1 || Integer.parseInt(HoraF.getText())>12 || Integer.parseInt(MinI.getText())< 0 || Integer.parseInt(MinI.getText())> 59 || Integer.parseInt(MinF.getText())< 0 || Integer.parseInt(MinF.getText())> 59) 
                {
                    JOptionPane.showMessageDialog(this, "¡Ingrese un Horario valido!");
                }
                else
                {
                    if(Alum.getSelectedValuesList().size()!= Integer.parseInt(CAlum.getSelectedItem().toString()))
                    {
                        JOptionPane.showMessageDialog(this, "Seleccione el numero correcto de Alumnos ("+CAlum.getSelectedItem().toString()+")");
                    }
                    else
                    {
                        Asignar();
                        JOptionPane.showMessageDialog(this, "Asignación exitosa");
                        JOptionPane.showMessageDialog(this, Horario.get(0));
                     
                    }
                }
            }
            }
    }
    
public void Asignar()
    {
       if (Tipo.getSelectedValue()== "Aula")
        {
            AO.add(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString());   
            H.add("De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem());
            Horario.clear();
            Horario.add("Actividad: "+jTextField1.getText()+"\n"+"Edificio: "+Edificio.getSelectedItem()+"\n"+Tipo.getSelectedValue()+NumAL.getSelectedItem()+"\n"+"De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem()+"\n"+"Cantidad de alumnos: "+CAlum.getSelectedItem()+"\n"+"Alumnos: "+Alum.getSelectedValuesList()+"\n"+"Encargado: "+jComboBox1.getSelectedItem());
        }
        else
        {
           LO.add(Edificio.getSelectedItem()+Tipo.getSelectedValue()+NumAL.getSelectedItem());       
           H.add("De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem());
           Horario.clear();
            Horario.add("Actividad: "+jTextField1.getText()+"\n"+"Edificio: "+Edificio.getSelectedItem()+"\n"+Tipo.getSelectedValue()+NumAL.getSelectedItem()+"\n"+"De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem()+"\n"+"Cantidad de alumnos: "+CAlum.getSelectedItem()+"\n"+"Alumnos: "+Alum.getSelectedValuesList()+"\n"+"Encargado: "+jComboBox1.getSelectedItem()); 
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Edificio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tipo = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        NumAL = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        HoraI = new javax.swing.JTextField();
        HorarioI = new javax.swing.JComboBox<>();
        HorarioF = new javax.swing.JComboBox<>();
        HoraF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CAlum = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Alum = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        MinI = new javax.swing.JTextField();
        MinF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Actividad");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setText("Edificio");

        Edificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "Laboratorios de uso pesado", "Edificio de Talleres" }));

        jLabel4.setText("Tipo");

        Tipo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Aula", "Laboratorio" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Tipo);

        jLabel5.setText("Numero de Aula o Laboratorio");

        NumAL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        jLabel8.setText("Horario");

        jLabel12.setText("De");

        HoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraIActionPerformed(evt);
            }
        });
        HoraI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HoraIKeyTyped(evt);
            }
        });

        HorarioI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        HorarioF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        HorarioF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioFActionPerformed(evt);
            }
        });

        HoraF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraFActionPerformed(evt);
            }
        });
        HoraF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HoraFKeyTyped(evt);
            }
        });

        jLabel13.setText("a");

        jLabel14.setText("Cantidad de alumnos");

        CAlum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " ", " " }));

        jLabel10.setText("Alumnos");

        Alum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Alum);

        jLabel11.setText("Encargado");

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Actividades Extracurriculares ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
        );

        MinI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinIActionPerformed(evt);
            }
        });
        MinI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MinIKeyTyped(evt);
            }
        });

        MinF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinFActionPerformed(evt);
            }
        });
        MinF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MinFKeyTyped(evt);
            }
        });

        jLabel9.setText("Hora");

        jLabel15.setText("Minutos");

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paco", "Pacheco", "Pancho" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(NumAL, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jLabel8))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGap(72, 72, 72))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel12))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(HoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(MinI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(HoraF, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(MinF, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(HorarioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(HorarioI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(56, 56, 56)
                                            .addComponent(jLabel9)
                                            .addGap(71, 71, 71)
                                            .addComponent(jLabel15)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NumAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(HoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HorarioI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(HoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HorarioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(CAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void HoraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraIActionPerformed

    private void HoraFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraFActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1KeyTyped

    private void MinIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinIActionPerformed

    private void MinFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinFActionPerformed

    private void HoraIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HoraIKeyTyped
        // TODO add your handling code here:
         char n = evt.getKeyChar();
        if (HoraI.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_HoraIKeyTyped

    private void HoraFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HoraFKeyTyped
        // TODO add your handling code here:
         char n = evt.getKeyChar();
        if (HoraF.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_HoraFKeyTyped

    private void MinIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MinIKeyTyped
        // TODO add your handling code here:
         char n = evt.getKeyChar();
        if (MinI.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_MinIKeyTyped

    private void MinFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MinFKeyTyped
        // TODO add your handling code here:
         char n = evt.getKeyChar();
        if (MinF.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_MinFKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Validar_A_L();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Principal ir = new Principal ();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void HorarioFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioFActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(Extra_curricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Extra_curricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Extra_curricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extra_curricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Extra_curricular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Alum;
    private javax.swing.JComboBox<String> CAlum;
    private javax.swing.JComboBox<String> Edificio;
    private javax.swing.JTextField HoraF;
    private javax.swing.JTextField HoraI;
    private javax.swing.JComboBox<String> HorarioF;
    private javax.swing.JComboBox<String> HorarioI;
    private javax.swing.JTextField MinF;
    private javax.swing.JTextField MinI;
    private javax.swing.JComboBox<String> NumAL;
    private javax.swing.JList<String> Tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
