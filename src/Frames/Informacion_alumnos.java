/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Conectar;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import Clases.Conectar;
import static Frames.Gestion_alumnos.idalumno;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Delgado
 */
public class Informacion_alumnos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    int idAlumno = 0;

    public static int idCalificacion = 0;

    /**
     * Creates new form Informacion_alumnos
     */
    public Informacion_alumnos() {
        initComponents();

        this.setLocationRelativeTo(null);
        //cerrar();

        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtTelefono.setEditable(false);
        txtCalificacion.setEditable(false);
        lblAprobado.setEditable(false);
        cmbGrado.setEnabled(false);
        idAlumno = Gestion_alumnos.idalumno;

        try {
            Connection cn = con.conexion();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumnos='" + idAlumno + "' ");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                setTitle("Informacion del alumno: " + rs.getString("nombre"));
                lblInfoAlumno.setText("Informacion del alumno: " + rs.getString("nombre"));

                txtNombre.setText(rs.getString("nombre"));
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                cmbGrado.setSelectedItem(rs.getString("grado"));
                txtTelefono.setText(rs.getString("telefono"));
            }

            //cn.close():
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar alumno... contacte al administrador");
        }

        /////////////////////////////////////////////////////////////////////////
        try {
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT id_notas,tarea,calificacion FROM notas WHERE id_alumno_nota = '" + idAlumno + "' ");

            ResultSet rs = pst.executeQuery();

            tabla_calificaciones = new JTable(modelo);
            jScrollPane1.setViewportView(tabla_calificaciones);

            modelo.addColumn("ID_nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Calificacion");

            while (rs.next()) {
                Object[] fila = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
                ////////////////////////////////////////////////////////////

                int filax = 0;
                int total = 0;

                for (int i = 0; i < tabla_calificaciones.getRowCount(); i++) {
                    filax = Integer.parseInt(tabla_calificaciones.getValueAt(i, 2).toString());
                    total += filax;

                    txtCalificacion.setText("" + total);
                }
                int califa = Integer.parseInt(txtCalificacion.getText());

                if (califa >= 80) {
                    lblAprobado.setText(String.valueOf("Aprobado"));
                    txtCalificacion.setBackground(Color.green);
                } else {
                    lblAprobado.setText(String.valueOf("Reprobado"));
                    txtCalificacion.setBackground(Color.red);
                }

            }

        } catch (Exception e) {
            System.err.println("Error en el llenado de la tabla calificaciones" + e);
        }

        tabla_calificaciones.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_calificaciones.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idCalificacion = (int) modelo.getValueAt(fila_point, columna_point);
                    Informacion_calificaciones informacion_calificaciones = new Informacion_calificaciones();
                    informacion_calificaciones.setVisible(true);
                    dispose();
                }
            }
        });
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

        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblInfoAlumno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbGrado = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_calificaciones = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblAprobado = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRegistrarAlumno = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();

        jLabel5.setText("Grado");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblInfoAlumno.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblInfoAlumno.setText("Informacion alumno");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Grado");

        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Telefono");

        tabla_calificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_calificaciones);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("Estatus:");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print_icon.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star_icon.png"))); // NOI18N
        btnRegistrarAlumno.setText("Registrar Calificacion");
        btnRegistrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAlumnoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Calificacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(txtNombre)
                                .addComponent(jLabel2)
                                .addComponent(cmbGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfoAlumno)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoAlumno)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(lblAprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnRegistrarAlumno)
                    .addComponent(jLabel8)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        Gestion_alumnos gestion_alumnos = new Gestion_alumnos();
        gestion_alumnos.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAlumnoActionPerformed

        Registrar_calificaciones registrar_calificaciones = new Registrar_calificaciones();
        registrar_calificaciones.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnRegistrarAlumnoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        Document documento = new Document();

        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
        String varFecha = formato.format(fecha);

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/desktop/" + txtNombre.getText() + ".pdf"));
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
            parrafo.add("Informacion del alumno. \n \n");

            Paragraph poner_fecha = new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.add("Fecha: " + varFecha + "\n \n");

            documento.open();

            documento.add(parrafo);
            documento.add(poner_fecha);

            PdfPTable tablaAlumno = new PdfPTable(4);

            tablaAlumno.addCell("Nombre");
            tablaAlumno.addCell("Apellido");
            tablaAlumno.addCell("Grado");
            tablaAlumno.addCell("Materia");

            try {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumnos = '" + idAlumno + "'");

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tablaAlumno.addCell(rs.getString(2));
                        tablaAlumno.addCell(rs.getString(3));
                        tablaAlumno.addCell(rs.getString(4));
                        tablaAlumno.addCell(rs.getString(6));
                    } while (rs.next());
                    {
                        documento.add(tablaAlumno);
                    }
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
                parrafo2.add("\n \n Tareas registradas \n \n");

                documento.add(parrafo2);
                PdfPTable tablaTareas = new PdfPTable(2);
                tablaTareas.addCell("Tarea");
                tablaTareas.addCell("Calificacion");

                try {
                    Connection cn2 = con.conexion();

                    PreparedStatement ps2 = cn2.prepareStatement("SELECT tarea,calificacion FROM notas WHERE id_alumno_nota = '" + idAlumno + "'");

                    ResultSet rs2 = ps2.executeQuery();

                    if (rs2.next()) {
                        do {

                            tablaTareas.addCell(rs2.getString(1));
                            tablaTareas.addCell(rs2.getString(2));

                        } while (rs2.next());
                        {
                            documento.add(tablaTareas);
                        }

                    }

                } catch (SQLException e) {
                    System.err.println("Error al cargar tareas " + e);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener datos del alumno " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado con exito");
            
        } catch (DocumentException | IOException e) {
            System.err.println("Error en el pdf o en la ruta " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF... Contacte al administrador");
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegistrarAlumno;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField lblAprobado;
    private javax.swing.JLabel lblInfoAlumno;
    private javax.swing.JTable tabla_calificaciones;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();
}
