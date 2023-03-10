/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import javax.swing.table.DefaultTableModel;
import Clases.Conectar;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian Delgado
 */
public class Registrar_alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_alumnos
     */
    public Registrar_alumnos() {
        initComponents();
        
        TextPrompt nombre = new TextPrompt("Escribe tu nombre", txtNombre);
        TextPrompt apellidos = new TextPrompt("Escribe tus apellidos", txtApellidos);
        TextPrompt telefono = new TextPrompt("Escribe tu telefono", txtTelefono);
        TextPrompt buscar = new TextPrompt("Buscar", txtBuscar);
        
        this.setLocationRelativeTo(null);
        
        limpiar();
        txtIdAlumno.setEnabled(false);
        txtCantidad.setEditable(false);
        mostrarTabla("");
        cerrar();
        cargarComboCurso(cmb_Materia);
        
        for(int i=0; i<=tabla_registro_alumnos.getRowCount(); i++)
            {
                txtCantidad.setText(" "+i);
            }
    }
    
    void limpiar(){
        
        txtIdAlumno.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        cmb_Grado.setSelectedIndex(0);
        cmb_Materia.setSelectedIndex(0);
    }
    
    void mostrarTabla(String valor){
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Grado");
        modelo.addColumn("Telefono");
        modelo.addColumn("Materia");
        
        tabla_registro_alumnos.setModel(modelo);
        
        String sql = "SELECT * FROM alumnos WHERE CONCAT (nombre,' ',apellido,' ',grado,' ',id_curso_asignado) "
                + "LIKE '%"+valor+"' ";
        
        String datos[] = new String[6];
        Statement st;
        
        
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);//id_alumno
                datos[1]=rs.getString(2);//nombre
                datos[2]=rs.getString(3);//apellido
                datos[3]=rs.getString(4);//grado
                datos[4]=rs.getString(5);//telefono
                datos[5]=rs.getString(6);//id_curso
                
                modelo.addRow(datos);
        }
            tabla_registro_alumnos.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void cargarComboCurso(JComboBox comboDelCurso){
     
        try {
            String sql = "SELECT nombre_curso FROM curso";
            Statement st=cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                comboDelCurso.addItem(rs.getString("nombre_curso"));
            }
        } catch (SQLException e) {
                System.err.println(e);
        }
        
    }
    
    public void cerrar(){
        
        try {
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                addWindowListener(new WindowAdapter() {
                    
                    public void windowClosing(WindowEvent e){
                        
                        confirmarSalida();
                        
                    }
                    
                });
            
        } catch (Exception e) {
        }        
    }
 
    public void confirmarSalida(){
        
        int valor = JOptionPane.showConfirmDialog
        (this, "??Deseas cerrar la aplicacion?", "Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valor==JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Hasta pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            
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

        popBorrar = new javax.swing.JPopupMenu();
        popEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdAlumno = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmb_Grado = new javax.swing.JComboBox<>();
        cmb_Materia = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_alumnos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        popEliminar.setText("Borrar");
        popEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popEliminarActionPerformed(evt);
            }
        });
        popBorrar.add(popEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setText("Registro de alumnos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setText("Id Alumno");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Grado");

        jLabel6.setText("Telefono");

        jLabel7.setText("Materia");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cmb_Grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmb_Materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione una materia" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdAlumno)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_Grado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_Materia, 0, 173, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cmb_Grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tabla_registro_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_registro_alumnos.setColumnSelectionAllowed(true);
        tabla_registro_alumnos.setComponentPopupMenu(popBorrar);
        tabla_registro_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_alumnos);
        tabla_registro_alumnos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel8.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel9.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(54, 54, 54)
                                .addComponent(btnActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnVolver))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM alumnos WHERE id_alumnos = '"+txtIdAlumno.getText()+"' ");
            
            int respuesta = ps.executeUpdate();
            
            if(respuesta>0){
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
                limpiar();
                mostrarTabla("");
                
                for(int i=0; i<=tabla_registro_alumnos.getRowCount(); i++)
                {
                    txtCantidad.setText(" "+i);
                }
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno... Contacte al administrador");
        }
        
        
        
    }//GEN-LAST:event_popEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String id_curso_asignado = cmb_Materia.getSelectedItem().toString();
        String materia = (String) cmb_Materia.getSelectedItem();
        String grado = (String) cmb_Grado.getSelectedItem();
        
        try {
            if(txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el cambo nombre vacio");
            }
            ////////////////////////////////////////////////////////
            else if(txtApellidos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el cambo apellidos vacio");
            }
            ////////////////////////////////////////////////////////
            else if(txtTelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el cambo telefono vacio");
            }
            ////////////////////////////////////////////////////////
            else if(grado.equals("Seleccione grado")){
                JOptionPane.showMessageDialog(null, "Debes seleccionar un grado");
            }
            ////////////////////////////////////////////////////////
            else if(materia.equals("Seleccione materia")){
                JOptionPane.showMessageDialog(null, "Debes seleccionar uns materia");
            }
            else{
                 PreparedStatement ps = cn.prepareStatement("INSERT INTO alumnos (nombre,apellido,grado,telefono,id_curso_asignado) VALUES (?,?,?,?,?) ");
                 ps.setString(1, txtNombre.getText());
                 ps.setString(2, txtApellidos.getText());
                 ps.setString(3, cmb_Grado.getSelectedItem().toString());
                 ps.setString(4, txtTelefono.getText());
                 ps.setString(5, id_curso_asignado);
                 
                 ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Alumno registrado con exito!");
                 mostrarTabla("");
                 limpiar();
                 
                 for(int i=0; i<=tabla_registro_alumnos.getRowCount(); i++)
                 {
                    txtCantidad.setText(" "+i);
                 }
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar alumno");
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tabla_registro_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_alumnosMouseClicked
       
        int fila = this.tabla_registro_alumnos.getSelectedRow();
        
        this.txtIdAlumno.setText(this.tabla_registro_alumnos.getValueAt(fila, 0).toString());
        this.txtNombre.setText(this.tabla_registro_alumnos.getValueAt(fila, 1).toString());
        this.txtApellidos.setText(this.tabla_registro_alumnos.getValueAt(fila, 2).toString());
        this.cmb_Grado.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila, 3).toString());
        this.txtTelefono.setText(this.tabla_registro_alumnos.getValueAt(fila, 4).toString());
        this.cmb_Materia.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila, 5).toString());
        
    }//GEN-LAST:event_tabla_registro_alumnosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        String materia = (String) cmb_Materia.getSelectedItem();
        String grado = (String) cmb_Grado.getSelectedItem();
        
        try {
            
            if(txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacio");
            }
            ///////////////////////////////////////////
            else if(txtApellidos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el cambo apellidos vacio");
            }
            ////////////////////////////////////////////////////////
            else if(txtTelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el cambo telefono vacio");
            }
            ////////////////////////////////////////////////////////
            else if(grado.equals("Seleccione grado")){
                JOptionPane.showMessageDialog(null, "Debes seleccionar un grado");
            }
            ////////////////////////////////////////////////////////
            else if(materia.equals("Seleccione materia")){
                JOptionPane.showMessageDialog(null, "Debes seleccionar uns materia");
            }
            ////////////////////////////////////////////////
            
            else{
                PreparedStatement ps = cn.prepareStatement("UPDATE alumnos SET nombre  = '"+txtNombre.getText()+"', apellido = '"+txtApellidos.getText()+"',grado = '"+cmb_Grado.getSelectedItem().toString()+"',telefono = '"+txtTelefono.getText()+"', id_curso_asignado = '"+cmb_Materia.getSelectedItem().toString()+"' WHERE id_alumnos = '"+txtIdAlumno.getText()+"' ");
                int respuesta = ps.executeUpdate();
                
                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Datos del alumno modificados");
                    limpiar();
                    mostrarTabla("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
                }
            }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erorr al actualizar alumno... contacte al administrador");
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
                
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
        mostrarTabla(txtBuscar.getText());
            for(int i=0; i<=tabla_registro_alumnos.getRowCount(); i++)
                {
                    txtCantidad.setText(" "+i);
                }
        
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
     
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmb_Grado;
    private javax.swing.JComboBox<String> cmb_Materia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popBorrar;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JTable tabla_registro_alumnos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();
}
