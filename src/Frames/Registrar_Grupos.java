/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Conectar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Delgado
 */
public class Registrar_Grupos extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_curso
     */
    public Registrar_Grupos() {
        initComponents();
//        TextPrompt nombre_curso = new TextPrompt("Escribe curso", txtNombre);
        this.setLocationRelativeTo(null);
        // Llamar al método de mostrar grupos activos al inicio
        mostrarGruposActivos();
// Establecer la selección predeterminada en el comboBox
        establecerSeleccionPredeterminada();
//        limpiar();
//        txtNumControlGrupo.setEnabled(true);
        cerrar();
//        txtIDGrupo.setEnabled(false);
//
//        cargarAsignaturas();

        // Remover todos los elementos existentes del comboBox
        cmbMostrar.removeAllItems();

// Agregar las opciones deseadas
        cmbMostrar.addItem("Ver activos");
        cmbMostrar.addItem("Ver inactivos");

        cmbMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = cmbMostrar.getSelectedItem().toString();

                if (seleccion.equals("Ver activos")) {
                    mostrarGruposActivos();
                    limpiarCampos();
                } else if (seleccion.equals("Ver inactivos")) {
                    mostrarGruposInactivos();
                    limpiarCampos();
                }
            }
        });

    }

//    void limpiar() {
//
//        txtNumControlGrupo.setText("");
//        txtNombre.setText("");
//
//    }
//    private void cargarAsignaturas() {
//        try {
//            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();
//
//            // Agregar el elemento "Seleccione una asignatura" al modelo del JComboBox
//            modeloCombo.addElement("Seleccione una asignatura");
//
//            // Establecer conexión a la base de datos
//            Conectar con = new Conectar();
//            Connection conn = con.conexion();
//
//            // Consultar las asignaturas
//            String query = "SELECT nombreAsignatura FROM iciibaSFR.asignaturas";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            // Agregar los nombres de las asignaturas al modelo del JComboBox
//            while (rs.next()) {
//                String nombreAsignatura = rs.getString("nombreAsignatura");
//                modeloCombo.addElement(nombreAsignatura);
//            }
//
//            // Cerrar la conexión y liberar recursos
//            rs.close();
//            ps.close();
//            conn.close();
//
//            // Establecer el modelo del JComboBox
//            cmbAsignaturas.setModel(modeloCombo);
//
//            // Establecer el primer elemento seleccionado por defecto
//            cmbAsignaturas.setSelectedIndex(0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Grupo");
        modelo.addColumn("Especialidad");

        tabla_registro_grupos.setModel(modelo);
        tabla_registro_grupos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla_registro_grupos.getTableHeader().setOpaque(false);
//        tabla_registro_grupos.getTableHeader().setBackground(new Color(32, 136, 203));
//        tabla_registro_grupos.getTableHeader().setForeground(new Color(255, 255, 255));
        //tabla_registro_grupos.setRowHeight(WIDTH);

        String sql = "SELECT grupo, especialidad FROM dbo.grupos WHERE activo = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String grupo = rs.getString("grupo");
                String especialidad = rs.getString("especialidad");

                modelo.addRow(new Object[]{grupo, especialidad});
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar grupos, contacte al administrador");
        }

        // Desactivar la edición de todas las celdas de la tabla
        for (int column = 0; column < tabla_registro_grupos.getColumnCount(); column++) {
            Class<?> columnClass = tabla_registro_grupos.getColumnClass(column);
            tabla_registro_grupos.setDefaultEditor(columnClass, null);
        }
    }

    public void cerrar() {

        try {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {

                    confirmarSalida();

                }

            });

        } catch (Exception e) {
        }
    }

    public void confirmarSalida() {

        int valor = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar la aplicacion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Hasta pronto", "", JOptionPane.INFORMATION_MESSAGE);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_grupos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnAdminGrupos = new javax.swing.JButton();
        btnGuardarGrupo = new javax.swing.JButton();
        btnEliminarGrupo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        cmbMostrar = new javax.swing.JComboBox<>();
        btnDeshabilitar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();

        popEliminar.setText("Borrar");
        popEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popEliminarActionPerformed(evt);
            }
        });
        popBorrar.add(popEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control de las grupos");

        tabla_registro_grupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_registro_grupos.setComponentPopupMenu(popBorrar);
        tabla_registro_grupos.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tabla_registro_grupos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla_registro_grupos.setShowHorizontalLines(true);
        tabla_registro_grupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_gruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_grupos);

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_icon.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAdminGrupos.setText("Administrar grupo!");
        btnAdminGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminGruposActionPerformed(evt);
            }
        });

        btnGuardarGrupo.setText("Guardar");
        btnGuardarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGrupoActionPerformed(evt);
            }
        });

        btnEliminarGrupo.setText("Eliminar");
        btnEliminarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarGrupoActionPerformed(evt);
            }
        });

        jLabel2.setText("Grupo:");

        jLabel3.setText("Especialidad:");

        cmbMostrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtGrupo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cmbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnDeshabilitar.setText("Deshabilitar");
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });

        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnAdminGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVolver)
                            .addComponent(btnAdminGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(354, 354, 354))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

//    private String obtenerNumControlAsignaturaSeleccionada() {
//        String asignaturaSeleccionada = cmbAsignaturas.getSelectedItem().toString();
//
//        try {
//            // Establecer conexión a la base de datos
//            Conectar con = new Conectar();
//            Connection conn = con.conexion();
//
//            // Realizar la consulta para obtener el número de control de la asignatura seleccionada
//            String query = "SELECT numControlAsignatura FROM iciibaSFR.asignaturas WHERE nombreAsignatura = ?";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, asignaturaSeleccionada);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                // Obtener el número de control de la asignatura
//                String numControlAsignatura = rs.getString("numControlAsignatura");
//                return numControlAsignatura;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return ""; // Si no se pudo obtener el número de control, devolver cadena vacía
//    }
//
//    private void quitarAsignatura() {
//        try {
//            // Obtener el ID del grupo
//            int idGrupo = Integer.parseInt(txtIDGrupo.getText());
//
//            // Actualizar el campo numControlAsignatura del grupo a NULL o a un valor vacío según tus necesidades
//            PreparedStatement ps = cn.prepareStatement("UPDATE iciibaSFR.grupo SET numControlAsignatura = NULL WHERE idGrupo = ?");
//            ps.setInt(1, idGrupo);
//
//            int respuesta = ps.executeUpdate();
//
//            if (respuesta > 0) {
//                AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//                JOptionPane.showMessageDialog(null, "Asignatura eliminada del grupo");
//
//                // Actualizar la fila correspondiente en la tabla
//                int fila = tabla_registro_grupos.getSelectedRow();
//                tabla_registro_grupos.setValueAt("Sin asignatura", fila, 3); // Actualizar el valor en la columna numControlAsignatura
//
//            } else {
//                AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//                JOptionPane.showMessageDialog(null, "No se pudo eliminar la asignatura del grupo");
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//            AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//            JOptionPane.showMessageDialog(null, "Error al quitar la asignatura del grupo... Contacte al administrador");
//        }
//    }
//
//
//    private String obtenerNumControlAsignatura(String nombreAsignatura) {
//        try {
//            // Establecer conexión a la base de datos
//            Conectar con = new Conectar();
//            Connection conn = con.conexion();
//
//            // Realizar la consulta para obtener el número de control de la asignatura
//            String query = "SELECT numControlAsignatura FROM iciibaSFR.asignaturas WHERE nombreAsignatura = ?";
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, nombreAsignatura);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                // Obtener el número de control de la asignatura
//                String numControlAsignatura = rs.getString("numControlAsignatura");
//                return numControlAsignatura;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return ""; // Si no se pudo obtener el número de control, devolver cadena vacía
//    }
//
//    private void seleccionarAsignaturaEnComboBox(String numControlAsignatura) {
//        for (int i = 0; i < cmbAsignaturas.getItemCount(); i++) {
//            String asignatura = cmbAsignaturas.getItemAt(i).toString();
//            if (obtenerNumControlAsignatura(asignatura).equals(numControlAsignatura)) {
//                cmbAsignaturas.setSelectedIndex(i);
//                break;
//            }
//        }
//    }
//
//    private String obtenerNumControlAsignaturaEnFilaSeleccionada() {
//        int fila = tabla_registro_grupos.getSelectedRow();
//        if (fila != -1) {
//            Object numControlAsignatura = tabla_registro_grupos.getValueAt(fila, 3);
//            if (numControlAsignatura != null) {
//                return numControlAsignatura.toString();
//            }
//        }
//        return "";
//    }
//
//
    private void tabla_registro_gruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_gruposMouseClicked

//        int fila = tabla_registro_grupos.getSelectedRow();
//
//        txtIDGrupo.setText(tabla_registro_grupos.getValueAt(fila, 0).toString());
//        txtNumControlGrupo.setText(tabla_registro_grupos.getValueAt(fila, 1).toString());
//        txtNombre.setText(tabla_registro_grupos.getValueAt(fila, 2).toString());
//
//        String numControlAsignatura = obtenerNumControlAsignaturaEnFilaSeleccionada();
//        seleccionarAsignaturaEnComboBox(numControlAsignatura);
        int filaSeleccionada = tabla_registro_grupos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String grupo = tabla_registro_grupos.getValueAt(filaSeleccionada, 0).toString();
            String especialidad = tabla_registro_grupos.getValueAt(filaSeleccionada, 1).toString();

            txtGrupo.setText(grupo);
            txtEspecialidad.setText(especialidad);
        }
    }//GEN-LAST:event_tabla_registro_gruposMouseClicked

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed

//        try {
//
//            PreparedStatement ps = cn.prepareStatement("DELETE FROM iciibaSFR.asignaturas WHERE numControlAsignatura = '" + txtNumControlGrupo.getText() + "'");
//            int respuesta = ps.executeUpdate();
//            if (respuesta > 0) {
//                AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//                JOptionPane.showMessageDialog(null, "Asignatura eliminado");
//                limpiar();
//                mostrarTabla("");
//            } else {
//                AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//                JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
//            JOptionPane.showMessageDialog(null, "Error al eliminar, contacte al administador");
//        }

    }//GEN-LAST:event_popEliminarActionPerformed

//    private boolean verificarAlumnosGrupo(int numControlGrupo) {
//        boolean tieneAlumnos = false;
//
//        try {
//            String sql = "SELECT * FROM iciibaSFR.alumnos_grupo WHERE numControlGrupo = ?";
//            PreparedStatement statement = cn.prepareStatement(sql);
//            statement.setInt(1, numControlGrupo);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                tieneAlumnos = true;
//            }
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return tieneAlumnos;
//    }

    private void btnAdminGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminGruposActionPerformed

        int filaSeleccionada = tabla_registro_grupos.getSelectedRow();
        if (filaSeleccionada == -1) {
            AdministracionGrupos.SoundPlayer.playSystemNotificationSound();
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún grupo. Por favor, seleccione uno.");
        } else {
            String grupo = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 0);
            String especialidad = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 1);

            AdministracionGrupos administracionGrupos = new AdministracionGrupos(grupo, especialidad);
            administracionGrupos.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_btnAdminGruposActionPerformed

    private void btnGuardarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGrupoActionPerformed
        String grupo = txtGrupo.getText();
        String especialidad = txtEspecialidad.getText();

        if (!grupo.isEmpty() && !especialidad.isEmpty()) {
            try {
                String sql = "INSERT INTO dbo.grupos (grupo, especialidad, activo) VALUES (?, ?, 1)";

                PreparedStatement statement = cn.prepareStatement(sql);
                statement.setString(1, grupo);
                statement.setString(2, especialidad);

                int resultado = statement.executeUpdate();

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Grupo registrado exitosamente");
                    limpiarCampos();
                    mostrarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar grupo, contacte al administrador");
                }
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al registrar grupo, contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_btnGuardarGrupoActionPerformed

    private void btnEliminarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGrupoActionPerformed
        String grupo = txtGrupo.getText();
        String especialidad = txtEspecialidad.getText();

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar de manera definitiva el grupo " + grupo + " - " + especialidad + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar de manera definitiva
            try {
                String sql = "DELETE FROM dbo.grupos WHERE grupo = ?";
                PreparedStatement statement = cn.prepareStatement(sql);
                statement.setString(1, grupo);

                int resultado = statement.executeUpdate();

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Grupo eliminado exitosamente");
                    limpiarCampos();
                    mostrarTabla(); // Actualizar la tabla después de la eliminación
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar grupo, contacte al administrador");
                }
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al eliminar grupo, contacte al administrador");
            }
        }
    }//GEN-LAST:event_btnEliminarGrupoActionPerformed

    private void cmbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMostrarActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = tabla_registro_grupos.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún grupo. Por favor, seleccione uno.");
        } else {
            // Obtener el grupo y la especialidad de la fila seleccionada
            String grupo = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 0);
            String especialidad = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 1);

            // Verificar el estatus del grupo
            String sqlVerificar = "SELECT activo FROM dbo.grupos WHERE grupo = ?";
            try {
                PreparedStatement statementVerificar = cn.prepareStatement(sqlVerificar);
                statementVerificar.setString(1, grupo);
                ResultSet rs = statementVerificar.executeQuery();

                if (rs.next()) {
                    int estatus = rs.getInt("activo");

                    // Verificar si el grupo ya está activo
                    if (estatus == 1) {
                        JOptionPane.showMessageDialog(null, "Debes seleccionar un grupo que no esté activo. Por favor, ve a la pestaña de inactivos.");
                    } else {
                        // Actualizar el estatus del grupo a activo (1) en la base de datos
                        String sql = "UPDATE dbo.grupos SET activo = 1 WHERE grupo = ?";
                        try {
                            PreparedStatement statement = cn.prepareStatement(sql);
                            statement.setString(1, grupo);
                            int filasActualizadas = statement.executeUpdate();

                            if (filasActualizadas > 0) {
                                JOptionPane.showMessageDialog(null, "El grupo ha sido habilitado correctamente.");

                                // Actualizar la tabla para reflejar los cambios
                                mostrarGruposActivos();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo habilitar el grupo. Por favor, intenta nuevamente.");
                            }
                        } catch (SQLException ex) {
                            System.err.println(ex);
                            JOptionPane.showMessageDialog(null, "Error al habilitar el grupo. Contacta al administrador.");
                        }
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(null, "Error al verificar el estatus del grupo. Contacta al administrador.");
            }
        }
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = tabla_registro_grupos.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún grupo. Por favor, seleccione uno.");
        } else {
            // Obtener el grupo y la especialidad de la fila seleccionada
            String grupo = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 0);
            String especialidad = (String) tabla_registro_grupos.getValueAt(filaSeleccionada, 1);

            // Verificar el estatus del grupo
            String sqlVerificar = "SELECT activo FROM dbo.grupos WHERE grupo = ?";
            try {
                PreparedStatement statementVerificar = cn.prepareStatement(sqlVerificar);
                statementVerificar.setString(1, grupo);
                ResultSet rs = statementVerificar.executeQuery();

                if (rs.next()) {
                    int estatus = rs.getInt("activo");

                    // Verificar si el grupo ya está inactivo
                    if (estatus == 0) {
                        JOptionPane.showMessageDialog(null, "Debes seleccionar un grupo que no esté activo. Por favor, ve a la pestaña de activos.");
                    } else {
                        // Actualizar el estatus del grupo a inactivo (0) en la base de datos
                        String sql = "UPDATE dbo.grupos SET activo = 0 WHERE grupo = ?";
                        try {
                            PreparedStatement statement = cn.prepareStatement(sql);
                            statement.setString(1, grupo);
                            int filasActualizadas = statement.executeUpdate();

                            if (filasActualizadas > 0) {
                                JOptionPane.showMessageDialog(null, "El grupo ha sido deshabilitado correctamente.");

                                // Actualizar la tabla para reflejar los cambios
                                mostrarGruposActivos();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo deshabilitar el grupo. Por favor, intenta nuevamente.");
                            }
                        } catch (SQLException ex) {
                            System.err.println(ex);
                            JOptionPane.showMessageDialog(null, "Error al deshabilitar el grupo. Contacta al administrador.");
                        }
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(null, "Error al verificar el estatus del grupo. Contacta al administrador.");
            }
        }

    }//GEN-LAST:event_btnDeshabilitarActionPerformed

// Método para mostrar los grupos activos en la tabla
    private void mostrarGruposActivos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Grupo");
        modelo.addColumn("Especialidad");

        tabla_registro_grupos.setModel(modelo);

        String sql = "SELECT grupo, especialidad FROM dbo.grupos WHERE activo = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String grupo = rs.getString("grupo");
                String especialidad = rs.getString("especialidad");

                modelo.addRow(new Object[]{grupo, especialidad});
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar grupos activos, contacte al administrador");
        }
    }

// Método para mostrar los grupos inactivos en la tabla
    private void mostrarGruposInactivos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Grupo");
        modelo.addColumn("Especialidad");

        tabla_registro_grupos.setModel(modelo);

        String sql = "SELECT grupo, especialidad FROM dbo.grupos WHERE activo = 0";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String grupo = rs.getString("grupo");
                String especialidad = rs.getString("especialidad");

                modelo.addRow(new Object[]{grupo, especialidad});
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar grupos inactivos, contacte al administrador");
        }
    }

// Método para establecer la selección predeterminada en "Ver activos"
    private void establecerSeleccionPredeterminada() {
        cmbMostrar.setSelectedItem("Ver activos");
    }

    private void limpiarCampos() {
        txtGrupo.setText("");
        txtEspecialidad.setText("");
    }

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
            java.util.logging.Logger.getLogger(Registrar_Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_Grupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminGrupos;
    private javax.swing.JButton btnDeshabilitar;
    private javax.swing.JButton btnEliminarGrupo;
    private javax.swing.JButton btnGuardarGrupo;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popBorrar;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JTable tabla_registro_grupos;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtGrupo;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();
}
