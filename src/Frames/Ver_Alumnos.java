/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;

/**
 *
 * @author Christian Delgado
 */
public class Ver_Alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Ver_Alumnos
     */
    public Ver_Alumnos() {
        initComponents();
        //cargarCalificaciones();
        String filtro = "";

        mostrarTabla();
        Actualizar();
        this.setLocationRelativeTo(null);

        // Obtén el Document del campo de texto txtFiltro
        Document filtroDocument = txtFiltro.getDocument();

// Agrega un DocumentListener al Document del campo de texto
        filtroDocument.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                aplicarFiltro();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                aplicarFiltro();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                aplicarFiltro();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnosFiltro = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizarCalificacion = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAlumnosFiltro.setBackground(new java.awt.Color(255, 255, 255));
        tablaAlumnosFiltro.setForeground(new java.awt.Color(0, 0, 0));
        tablaAlumnosFiltro.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAlumnosFiltro.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tablaAlumnosFiltro);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizarCalificacion.setText("Actualizar calificaciones");
        btnActualizarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCalificacionActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_icon.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar Tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnActualizarCalificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 5) { // Índice de la columna "Calificación"
                    return Integer.class; // Cambia a la clase adecuada para los valores de calificación
                }
                return super.getColumnClass(columnIndex);
            }
        };

        modelo.addColumn("nControl");
        modelo.addColumn("Nombre");
        modelo.addColumn("Grupo");
        modelo.addColumn("Asignatura");
        modelo.addColumn("nControlAsignatura");
        modelo.addColumn("Calificación");

        tablaAlumnosFiltro.setModel(modelo);

        String sql = "SELECT c.ncontrol, a.nombre, c.grupo, asignaturas.asignatura, c.nControlAsignatura, c.calificacion FROM dbo.calificaciones c "
                + "INNER JOIN dbo.alumnos a ON c.ncontrol = a.ncontrol "
                + "INNER JOIN dbo.asignaturas asignaturas ON c.nControlAsignatura = asignaturas.nControlAsignatura "
                + "WHERE a.estatus = 'ac' ORDER BY c.ncontrol";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nControl = rs.getString("ncontrol");
                String nombre = rs.getString("nombre");
                String grupo = rs.getString("grupo");
                String asignatura = rs.getString("asignatura");
                String nControlAsignatura = rs.getString("nControlAsignatura");
                int calificacion = rs.getInt("calificacion");

                modelo.addRow(new Object[]{nControl, nombre, grupo, asignatura, nControlAsignatura, calificacion});
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar datos, contacte al administrador");
        }

        // Ajustar automáticamente el tamaño de las columnas según el contenido
        tablaAlumnosFiltro.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaAlumnosFiltro.getColumnModel().getColumn(0).setPreferredWidth(50); // nControl
        tablaAlumnosFiltro.getColumnModel().getColumn(1).setPreferredWidth(230); // Nombre
        tablaAlumnosFiltro.getColumnModel().getColumn(2).setPreferredWidth(100); // Grupo
        tablaAlumnosFiltro.getColumnModel().getColumn(3).setPreferredWidth(150); // Asignatura
        tablaAlumnosFiltro.getColumnModel().getColumn(4).setPreferredWidth(120); // nControlAsignatura
        tablaAlumnosFiltro.getColumnModel().getColumn(5).setPreferredWidth(50); // Calificación

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 5) { // Índice de la columna "Calificación"
                    setHorizontalAlignment(JLabel.CENTER);
                } else {
                    setHorizontalAlignment(JLabel.LEFT);
                }
                return component;
            }
        };

        tablaAlumnosFiltro.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaAlumnosFiltro.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaAlumnosFiltro.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaAlumnosFiltro.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tablaAlumnosFiltro.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tablaAlumnosFiltro.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
    }

    public void aplicarFiltro() {
        String filtro = txtFiltro.getText().trim().toLowerCase();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tablaAlumnosFiltro.getModel());
        tablaAlumnosFiltro.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(filtro));
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // String filtro = txtFiltro.getText().trim();
        aplicarFiltro();
        // mostrarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCalificacionActionPerformed
        int selectedRow = tablaAlumnosFiltro.getSelectedRow();

        if (selectedRow != -1) {
            String nControl = tablaAlumnosFiltro.getValueAt(selectedRow, 0).toString();
            String nControlAsignatura = tablaAlumnosFiltro.getValueAt(selectedRow, 4).toString();
            String nombre = tablaAlumnosFiltro.getValueAt(selectedRow, 1).toString();
            String asignatura = tablaAlumnosFiltro.getValueAt(selectedRow, 3).toString();
            String calificacion = tablaAlumnosFiltro.getValueAt(selectedRow, 5).toString();
            
            CalificacionAlumno ventanaCalificacion = new CalificacionAlumno();
            ventanaCalificacion.setNControl(nControl);
            ventanaCalificacion.setNControlAsignatura(nControlAsignatura);
            ventanaCalificacion.setNombre(nombre);
            ventanaCalificacion.setAsignatura(asignatura);
            ventanaCalificacion.setCalificacion(calificacion);
            ventanaCalificacion.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila antes de continuar.");
        }
    }//GEN-LAST:event_btnActualizarCalificacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Obtener los datos de la tabla "alumnos"
        String sql = "SELECT ncontrol, grupo FROM alumnos";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            Set<String> ncontrols = new HashSet<>();  // Utilizamos un conjunto para evitar duplicados

            while (rs.next()) {
                String ncontrol = rs.getString("ncontrol");
                String grupo = rs.getString("grupo");

                // Verificar si el ncontrol ya existe en la tabla "calificaciones"
                if (!existeNControlEnCalificaciones(ncontrol)) {
                    // Insertar los datos en la tabla "calificaciones"
                    insertarCalificacion(ncontrol, grupo);
                }
            }

            // Actualizar la tabla de calificaciones después de insertar los nuevos datos
            mostrarTabla();
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla de calificaciones, contacte al administrador");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void Actualizar() {
        // Obtener los datos de la tabla "alumnos"
        String sql = "SELECT ncontrol, grupo FROM alumnos";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            Set<String> ncontrols = new HashSet<>();  // Utilizamos un conjunto para evitar duplicados

            while (rs.next()) {
                String ncontrol = rs.getString("ncontrol");
                String grupo = rs.getString("grupo");

                // Verificar si el ncontrol ya existe en la tabla "calificaciones"
                if (!existeNControlEnCalificaciones(ncontrol)) {
                    // Insertar los datos en la tabla "calificaciones"
                    insertarCalificacion(ncontrol, grupo);
                }
            }

            // Actualizar la tabla de calificaciones después de insertar los nuevos datos
            mostrarTabla();
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla de calificaciones, contacte al administrador");
        }
    }

    // Función para verificar si un ncontrol ya existe en la tabla "calificaciones"
    private boolean existeNControlEnCalificaciones(String ncontrol) {
        String sql = "SELECT COUNT(*) AS count FROM calificaciones WHERE ncontrol = ?";
        try {
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, ncontrol);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

// Función para insertar una calificación en la tabla "calificaciones"
    private void insertarCalificacion(String ncontrol, String grupo) {
        String sql = "INSERT INTO calificaciones (ncontrol, grupo) VALUES (?, ?)";
        try {
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, ncontrol);
            statement.setString(2, grupo);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
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
            java.util.logging.Logger.getLogger(Ver_Alumnos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Alumnos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Alumnos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Alumnos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Alumnos().setVisible(true);
            }
        });
    }

    Conectar con = new Conectar();
    Connection cn = con.conexion();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarCalificacion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumnosFiltro;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
