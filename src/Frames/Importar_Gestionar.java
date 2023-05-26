/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Christian Delgado
 */
public class Importar_Gestionar extends javax.swing.JFrame {

    /**
     * Creates new form Importar_Gestionar
     */
    private JTable tabla;

    public Importar_Gestionar() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Crear un contenedor para los componentes
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        // Establecer el administrador de diseño
        contentPane.setLayout(new FlowLayout());

        // Crear y agregar el botón
        JButton btnImport = new JButton("Importar datos");
        contentPane.add(btnImport);

        //Creamos un boton para volver a la pantalla principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal = new Principal();
                principal.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);
        //*--------------------------------------------------

        //Creamos un boton para guardar los cambios de la tabla al excel
        JButton guardarBoton = new JButton("Guardar");
        guardarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                // Agregar un filtro de extensión para los archivos de Excel
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel (*.xlsx)", "xlsx");
                fileChooser.setFileFilter(filter);

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    // Obtener la ruta del archivo seleccionado
                    String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();

                    // Agregar la extensión ".xlsx" si no se proporciona
                    if (!rutaArchivo.endsWith(".xlsx")) {
                        rutaArchivo += ".xlsx";
                    }

                    File archivo = new File(rutaArchivo);

                    // Verificar si el archivo ya existe
                    if (archivo.exists()) {
                        // Mostrar un cuadro de diálogo de confirmación
                        int opcion = JOptionPane.showConfirmDialog(null,
                                "Ya existe un archivo con el mismo nombre. ¿Desea reemplazarlo?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            // Si el usuario elige reemplazar el archivo existente, eliminarlo primero
                            archivo.delete();
                        } else {
                            // Si el usuario elige no reemplazar, mostrar nuevamente el cuadro de diálogo para seleccionar una ubicación y nombre de archivo diferente
                            JFileChooser nuevoFileChooser = new JFileChooser();
                            nuevoFileChooser.setFileFilter(filter);
                            int nuevoSeleccion = nuevoFileChooser.showSaveDialog(null);
                            if (nuevoSeleccion == JFileChooser.APPROVE_OPTION) {
                                rutaArchivo = nuevoFileChooser.getSelectedFile().getAbsolutePath();

                                if (!rutaArchivo.endsWith(".xlsx")) {
                                    rutaArchivo += ".xlsx";
                                }

                                archivo = new File(rutaArchivo);
                            } else {
                                // Si el usuario cancela la selección, salir del método sin guardar
                                return;
                            }
                        }
                    }

                    try {
                        // Crear el archivo de Excel
                        FileOutputStream file = new FileOutputStream(rutaArchivo);

                        // Crear el libro de trabajo de Excel
                        Workbook workbook = new XSSFWorkbook();

                        // Crear una hoja en el libro
                        Sheet sheet = workbook.createSheet("Hoja 1");

                        // Obtener los datos de la tabla y guardarlos en el archivo de Excel
                        for (int row = 0; row < tabla.getRowCount(); row++) {
                            Row fila = sheet.createRow(row);
                            for (int column = 0; column < tabla.getColumnCount(); column++) {
                                Object valorCelda = tabla.getValueAt(row, column);
                                Cell celda = fila.createCell(column);
                                celda.setCellValue(valorCelda.toString());
                            }
                        }

                        // Escribir el libro en el archivo
                        workbook.write(file);

                        // Cerrar el archivo
                        file.close();

                        JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente en: " + rutaArchivo);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Agregar el botón "Guardar" a la ventana
        contentPane.add(guardarBoton);

        ///---------------------------------
        ///Agregamos un boton bata añadir mas filas
        JButton botonAgregarFila = new JButton("Agregar Fila");

        // Agrega el botón a tu JFrame o JPanel
        contentPane.add(botonAgregarFila);

        botonAgregarFila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();

                // Crea un arreglo de objetos vacío para representar una nueva fila
                Object[] filaNueva = new Object[model.getColumnCount()];

                // Agrega la nueva fila al modelo de la tabla
                model.addRow(filaNueva);
            }
        });

        //----------------------------
        //Boton para eliminar una fila
        JButton botonEliminarFila = new JButton("Eliminar Fila");

        // Agrega el botón a tu JFrame o JPanel
        contentPane.add(botonEliminarFila);

        botonEliminarFila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén el índice de la fila seleccionada
                int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    // Obtén el modelo de la tabla
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();

                    // Elimina la fila seleccionada del modelo de la tabla
                    model.removeRow(filaSeleccionada);
                }
            }
        });

        //------------------------------------------------------
        // Manejador de eventos para el botón
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importarDatosDesdeExcel();
            }

            private void importarDatosDesdeExcel() {
                // Crear un cuadro de diálogo para seleccionar el archivo de Excel
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar archivo de Excel");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Excel", "xlsx"));

                int seleccion = fileChooser.showOpenDialog(Importar_Gestionar.this);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    try {
                        // Obtener el archivo seleccionado
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                        // Abrir el archivo de Excel
                        Workbook workbook = new XSSFWorkbook(filePath);

                        // Obtener la primera hoja del archivo
                        Sheet sheet = workbook.getSheetAt(0);

                        // Limpiar la tabla existente (si es necesario)
                        // tableModel.setRowCount(0);
                        // Leer los datos de cada fila y columna del archivo de Excel y almacenarlos en una estructura de datos
                        List<String[]> datos = new ArrayList<>();
                        for (Row row : sheet) {
                            List<String> fila = new ArrayList<>();
                            for (Cell cell : row) {
                                fila.add(cell.toString());
                            }
                            datos.add(fila.toArray(new String[0]));
                        }

                        // Crear el modelo de tabla y establecer los datos
                        DefaultTableModel tableModel = new DefaultTableModel(
                                datos.toArray(new String[0][0]), // Datos
                                new String[]{"Nombre", "Apellido", "Curso", "Carrera"} // Nombres de columnas
                        );

                        // Crear la tabla con el modelo
                        tabla = new JTable(tableModel);

                        // Ajustar el modo de ajuste automático de las columnas
                        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                        // Ajustar automáticamente el ancho de las columnas
                        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        for (int column = 0; column < tabla.getColumnCount(); column++) {
                            TableColumn tableColumn = tabla.getColumnModel().getColumn(column);
                            int preferredWidth = tableColumn.getMinWidth();
                            int maxWidth = tableColumn.getMaxWidth();

                            for (int row = 0; row < tabla.getRowCount(); row++) {
                                TableCellRenderer cellRenderer = tabla.getCellRenderer(row, column);
                                Component c = tabla.prepareRenderer(cellRenderer, row, column);
                                int width = c.getPreferredSize().width + tabla.getIntercellSpacing().width;
                                preferredWidth = Math.max(preferredWidth, width);

                                // Si la columna excede el ancho máximo, ajustarlo al ancho máximo
                                if (preferredWidth >= maxWidth) {
                                    preferredWidth = maxWidth;
                                    break;
                                }
                            }

                            tableColumn.setPreferredWidth(preferredWidth);
                        }

                        // Crear el JScrollPane para la tabla
                        JScrollPane scrollPane = new JScrollPane(tabla);

                        // Agregar el JScrollPane a la ventana
                        add(scrollPane);

                        // Llamar a revalidate para actualizar el layout
                        revalidate();

                        workbook.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(Importar_Gestionar.this, "Error al importar datos desde el archivo de Excel: " + e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Importar_Gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Importar_Gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Importar_Gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Importar_Gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Importar_Gestionar().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
