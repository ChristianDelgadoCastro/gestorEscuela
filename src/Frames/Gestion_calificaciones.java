/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import javax.swing.table.DefaultTableModel;
import Clases.Conectar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Christian Delgado
 */
public class Gestion_calificaciones extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_calificaciones
     */
    public Gestion_calificaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla("");
    }

    void mostrarTabla(String valor){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Grado");
        modelo.addColumn("Materia");
        modelo.addColumn("Promedio");
        
        tabla_gestion_calificaciones.setModel(modelo);
        
        String sql = "SELECT alumnos.nombre AS nombre,"
                +    "alumnos.apellido AS apellido,"
                +    "alumnos.grado AS grado,"
                +    "alumnos.id_curso_asignado AS curso,"
                +    " SUM(notas.calificacion) AS totalCalificacion"
                +    " FROM alumnos"
                +    " INNER JOIN notas"
                +    " ON alumnos.id_alumnos = notas.id_alumno_nota"
                +    " GROUP BY alumnos.id_alumnos";
        
        String datos[]=new String[5];
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
                
            }
            tabla_gestion_calificaciones.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error en el inner join");
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
        btnVolver = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_gestion_calificaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Gestion de calificaciones");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        tabla_gestion_calificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_gestion_calificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(30, 30, 30)
                                .addComponent(btnImprimir)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnImprimir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        Document documento = new Document();
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        String verFecha = formato.format(fecha);
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/desktop/" + "CALIFICACIONES" + ".pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20, Font.BOLD, BaseColor.BLACK));
            parrafo.add("CALIFICACIONES. \n \n");
            
            Paragraph poner_fecha = new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.setFont(FontFactory.getFont("Arial", 20, Font.BOLD, BaseColor.BLACK));
            poner_fecha.add("Fecha: "+verFecha+"\n \n");
            
            documento.open();
            documento.add(parrafo);
            documento.add(poner_fecha);
            
            PdfPTable tablaAlumno = new PdfPTable(5);
            
            tablaAlumno.addCell("Nombre");
            tablaAlumno.addCell("Apellido");
            tablaAlumno.addCell("Grado");
            tablaAlumno.addCell("Materia");
            tablaAlumno.addCell("Promedio");
            
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT alumnos.nombre,"
                        + "alumnos.apellido,"
                        + "alumnos.grado,"
                        + "alumnos.id_curso_asignado,"
                        + " SUM(notas.calificacion) AS totalCalificacion"
                        + " FROM alumnos"
                        + " INNER JOIN notas"
                        + " ON alumnos.id_alumnos = notas.id_alumno_nota"
                        + " GROUP BY alumnos.id_alumnos");

                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    do {
                        tablaAlumno.addCell(rs.getString("alumnos.nombre"));
                        tablaAlumno.addCell(rs.getString("alumnos.apellido"));
                        tablaAlumno.addCell(rs.getString("alumnos.grado"));
                        tablaAlumno.addCell(rs.getString("alumnos.id_curso_asignado"));
                        tablaAlumno.addCell(rs.getString("totalCalificacion"));
                    } while (rs.next());
                    {
                        documento.add(tablaAlumno);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener datos del alumno" +e);
            }
                documento.close();
                JOptionPane.showMessageDialog(null, "Documento creado con exito!");
        } catch (DocumentException | IOException e) {
            System.err.println("Error en el PDF o ruta "+e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");
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
            java.util.logging.Logger.getLogger(Gestion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_gestion_calificaciones;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();
}
