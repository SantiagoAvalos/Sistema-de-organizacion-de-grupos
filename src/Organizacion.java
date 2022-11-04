
import java.util.Collections;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuariox
 */
public class Organizacion extends javax.swing.JFrame implements Datos_E, DatosD {

    /**
     * Creates new form Organización
     */
    public Organizacion() {
        initComponents();       
        
        Conteo.setVisible(false);
        PasarD();
        for (int i = 0; i<NomDoce.size(); i++)
        {
            jComboBox9.addItem(NomDoce.get(i));
        }
    }
    int Contador = 0;
    int aux = 0;
    String AL = "";
    public void PasarD()
    {
        for (int i = 0; i<Numero_Lista.size(); i++)
        {
            NL [i] = Numero_Lista.get(i);
        }
        for (int i = 0; i<Nombres_Guardados.size(); i++)
        {
            NG [i] = Nombres_Guardados.get(i);
        }
    }
    public void Burbuja()
    {
        String NumL, NomG = "";
          for(int i = 1; i<Numero_Lista.size();i++ )
        {
            if(Integer.parseInt(NL[i])<Integer.parseInt(NL[i-1]))
            {
                NumL = NL [i];
                NomG = NG [i];
                NL [i] = NL [i-1];
                NG [i] = NG [i-1];
                NL [i-1] = NumL;
                NG [i-1] = NomG;
                Contador++;
            }
        }
          Conteo.setVisible(true);
          Conteo.setText("Movimientos: "+ Contador);
    }
   public void cargarAl()
   {
       Cargar.clear();
       for (int i = 0; i<Numero_Lista.size(); i++)
       {
           if (Carreras.get(i).equals(Carrera.getSelectedItem().toString())==true && Turno.get(i).equals("Turno matutino")==true && jRadioButton1.isSelected() == true)
           {
               Cargar.addElement(/*Numero_Lista.get(i)+"._"+*/Nombres_Guardados.get(i));
           }
               if (Carreras.get(i).equals(Carrera.getSelectedItem().toString())==true && Turno.get(i).equals("Turno vespertino")==true && jRadioButton2.isSelected() == true)
               {
                   Cargar.addElement(/*Numero_Lista.get(i)+"._"+*/Nombres_Guardados.get(i));
               }
               else if (Carreras.get(i).equals(Carrera.getSelectedItem().toString())==true && Turno.get(i).equals("Turno nocturno")==true && jRadioButton3.isSelected() == true)
               {
                   Cargar.addElement(/*Numero_Lista.get(i)+"._"+*/Nombres_Guardados.get(i));
               }
       }
       Alum.setModel(Cargar);
   }
   public void Validar_As()
    {
         if ((jRadioButton1.isSelected() == false && jRadioButton2.isSelected() == false && jRadioButton3.isSelected() == false) || (HoraI.getText().isEmpty() == true || HoraF.getText().isEmpty() == true || MinI.getText().isEmpty() == true || MinF.getText().isEmpty() == true)) {
            JOptionPane.showMessageDialog(rootPane, "Faltan Rellenar Campos");
        }
        else
        {
            if ((Integer.parseInt(HoraI.getText()) <= 7 && Integer.parseInt(MinI.getText()) < 30 && HorarioI.getSelectedItem() == "AM")||(Integer.parseInt(HoraF.getText()) <= 7 && Integer.parseInt(MinF.getText()) < 30 && HorarioF.getSelectedItem() == "AM")||(Integer.parseInt(HoraI.getText()) >= 9 && Integer.parseInt(MinI.getText()) > 0 && HorarioI.getSelectedItem() == "PM")||(Integer.parseInt(HoraF.getText()) >= 9 && Integer.parseInt(MinF.getText()) > 0 && HorarioF.getSelectedItem() == "PM"))
                {
                JOptionPane.showMessageDialog(this, "Horario de trabajo: De 7:30AM a 9:00PM \n Ingrese una hora dentro del horario de trabajo");
                }
            else 
            {
                 if(Integer.parseInt(HoraI.getText())<1 || Integer.parseInt(HoraI.getText())>12 || Integer.parseInt(HoraF.getText())<1 || Integer.parseInt(HoraF.getText())>12 || Integer.parseInt(MinI.getText())< 0 || Integer.parseInt(MinI.getText())> 59 || Integer.parseInt(MinF.getText())< 0 || Integer.parseInt(MinF.getText())> 59)
                    {
                        JOptionPane.showMessageDialog(this, "¡Ingrese un Horario valido!");
                    }
                 else
                {
                   if(AO.contains(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString())== true || LO.contains(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString())== true)
                    {
                        JOptionPane.showMessageDialog(this, "Esta Aula o Laboratorio ya esta ocupado");
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
        
    }
   public void Asignar()
   { 
       
       if (Tipo.getSelectedValue()== "Aula")
       {
           AO.add(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString());
           AL = Alum.getSelectedValuesList().toString();
           for(int i = 0; i<=Integer.parseInt(CAlum.getSelectedItem().toString()); i++)
           {            
               if(Cargar.isEmpty()== false)
               {
                   if(Cargar.get(0).equals(Alum.getSelectedValue())==true)
                   {
                       AlumnosA.add(Cargar.get(0).toString());
                       Indice.add(aux);
                   }  
                   Cargar.remove(0);
               }
                   
           }
           for(int i = 0; i<AlumnosA.size(); i++)
           {
               JOptionPane.showMessageDialog(this, AlumnosA.get(i)+ Indice);
           } 
            aux++;
           cargarAl();
           H.add("De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem());
           String Turno = " ";
           if (jRadioButton1.isSelected()==true)
           {
               Turno = "Matutino";                       
           }
           else if (jRadioButton2.isSelected()==true)
           {
               Turno = "Vespertino"; 
           }
           else
           {
               Turno = "Nocturno";
           }
           Horario.clear();
           Horario.add("Edificio: "+Edificio.getSelectedItem()+"\n"+"Carrera: "+Carrera.getSelectedItem()+"\n"+"Turno: "+Turno+"\n"+"Grupo: "+jComboBox8.getSelectedItem()+"\n"+Tipo.getSelectedValue()+NumAL.getSelectedItem().toString()+"\n"+"De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem()+"\n"+"Cantidad de alumnos: "+CAlum.getSelectedItem().toString()+"\n"+"Alumnos: "+AL+"\n"+"Encargado: "+jComboBox9.getSelectedItem());
       }
       else
       {
           LO.add(Edificio.getSelectedItem().toString()+Tipo.getSelectedValue().toString()+NumAL.getSelectedItem().toString());
           H.add("De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem());
           String Turno = " ";
           if (jRadioButton1.isSelected()==true)
           {
               Turno = "Matutino";                       
           }
           else if (jRadioButton2.isSelected()==true)
           {
               Turno = "Vespertino"; 
           }
           else
           {
               Turno = "Nocturno";
           }
           Horario.clear();
           Horario.add("Edificio: "+Edificio.getSelectedItem()+"\n"+"Carrera: "+Carrera.getSelectedItem()+"\n"+"Turno: "+Turno+"\n"+"Grupo: "+jComboBox8.getSelectedItem()+"\n"+Tipo.getSelectedValue()+NumAL.getSelectedItem().toString()+"\n"+"De "+HoraI.getText()+":"+MinI.getText()+HorarioI.getSelectedItem()+"\n"+"a "+HoraF.getText()+":"+MinF.getText()+HorarioF.getSelectedItem()+"\n"+"Cantidad de alumnos: "+CAlum.getSelectedItem().toString()+"\n"+"Alumnos: "+AL+"\n"+"Encargado: "+jComboBox9.getSelectedItem());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Edificio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tipo = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        NumAL = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Carrera = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        HoraI = new javax.swing.JTextField();
        HoraF = new javax.swing.JTextField();
        HorarioI = new javax.swing.JComboBox<>();
        HorarioF = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Alum = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        CAlum = new javax.swing.JComboBox<>();
        MinI = new javax.swing.JTextField();
        MinF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Organiza = new javax.swing.JButton();
        Conteo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Asignación de aulas y laboratorios");

        jButton4.setText("Actividad Extracurricular");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

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

        NumAL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));

        jLabel6.setText("Carrera");

        Carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITI", "IBIO", "IAEV", "ITM", "LNI" }));
        Carrera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CarreraItemStateChanged(evt);
            }
        });
        Carrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarreraMouseClicked(evt);
            }
        });
        Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarreraActionPerformed(evt);
            }
        });

        jLabel7.setText("Turno");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Matutino");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Vespertino");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Nocturno");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        jLabel8.setText("Horario");

        jLabel12.setText("De");

        jLabel13.setText("a");

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

        HorarioI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        HorarioF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jLabel9.setText("Grupo");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        jLabel10.setText("Alumnos");

        Alum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Alum);

        jLabel11.setText("Docente");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paco", "Pacheco", "Pancho" }));

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setText("Cantidad de alumnos");

        CAlum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));

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

        jLabel15.setText("Horas");

        jLabel16.setText("Minutos");

        Organiza.setText("Metodo Burbuja");
        Organiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizaActionPerformed(evt);
            }
        });

        Conteo.setText("jLabel17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addComponent(Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Organiza)
                                .addGap(18, 18, 18)
                                .addComponent(Conteo)
                                .addContainerGap())
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(129, 129, 129))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HoraF, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MinI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinF, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HorarioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HorarioI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(36, 36, 36)))
                        .addComponent(jButton3))))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel15)
                .addGap(68, 68, 68)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
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
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(HoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HorarioI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HorarioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(HoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MinF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Organiza)
                            .addComponent(Conteo))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(CAlum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public int x;
    private void HoraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraIActionPerformed

    private void HoraFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraFActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Principal ir = new Principal ();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MinIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinIActionPerformed

    private void MinIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MinIKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (MinI.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_MinIKeyTyped

    private void MinFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinFActionPerformed

    private void MinFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MinFKeyTyped
        // TODO add your handling code here:
        char n = evt.getKeyChar();
        if (MinF.getText().length() > 1) evt.consume();
        if (n < '0' || n > '9') evt.consume();
    }//GEN-LAST:event_MinFKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       Validar_As();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Extra_curricular ir = new Extra_curricular ();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void OrganizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizaActionPerformed
        // TODO add your handling code here:
        Burbuja();
        X.clear();
        for(int c = 0; c<NL.length; c++)
        {
            if (NL[c] == null)
            {
                X.addElement("");
            }
            else
            {
               X.addElement(NL [c]+"._"+NG [c]); 
            }            
        }
        Alum.setModel(X);        
    }//GEN-LAST:event_OrganizaActionPerformed

    private void CarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarreraMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_CarreraMouseClicked

    private void CarreraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CarreraItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CarreraItemStateChanged

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged
        // TODO add your handling code here:
  
    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarreraActionPerformed
        // TODO add your handling code here:
         cargarAl();
    }//GEN-LAST:event_CarreraActionPerformed

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
            java.util.logging.Logger.getLogger(Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Organizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Alum;
    private javax.swing.JComboBox<String> CAlum;
    private javax.swing.JComboBox<String> Carrera;
    private javax.swing.JLabel Conteo;
    private javax.swing.JComboBox<String> Edificio;
    private javax.swing.JTextField HoraF;
    private javax.swing.JTextField HoraI;
    private javax.swing.JComboBox<String> HorarioF;
    private javax.swing.JComboBox<String> HorarioI;
    private javax.swing.JTextField MinF;
    private javax.swing.JTextField MinI;
    private javax.swing.JComboBox<String> NumAL;
    private javax.swing.JButton Organiza;
    private javax.swing.JList<String> Tipo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
