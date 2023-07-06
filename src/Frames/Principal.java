/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Conectar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Christian Delgado
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    int xMouse, yMouse;

    private String[] imagenes = {
        "carrusel1.png",
        "carrusel2.png",
        "carrusel3.png",
        "carrusel4.png"
    };
    private int indiceImagenActual = 0;

    public Principal() {
        initComponents();
        Thread threadHora = new Thread(this::actualizarHora);
        mostrarFechaHoraActual();
        threadHora.start();
        cerrar();
        this.setLocationRelativeTo(null);
        iniciarCarrusel();
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

    private void iniciarCarrusel() {
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar a la siguiente imagen
                indiceImagenActual = (indiceImagenActual + 1) % imagenes.length;
                actualizarImagen();
            }
        });

        // Iniciar el temporizador
        timer.start();
    }

    private void actualizarImagen() {
        String imagenActual = imagenes[indiceImagenActual];
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/carrusel/" + imagenActual));

        // Obtener el ancho y alto del panel
        int anchoPanel = panelCarrusel.getWidth();
        int altoPanel = panelCarrusel.getHeight();

        // Redimensionar la imagen al tamaño del panel
        Image imagenRedimensionada = icono.getImage().getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen redimensionada
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        // Establecer el nuevo ImageIcon en el JLabel
        labelImagen.setIcon(iconoRedimensionado);
    }

    private void mostrarFechaHoraActual() {
        try {
            // Obtener la fecha y hora actual
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("'Hoy es' dd 'de' MMMM 'de' yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("'Hora actual:' HH:mm:ss");

            // Configurar el texto de las etiquetas con la fecha y hora actual
            lblFecha.setText(formatoFecha.format(fechaActual));
            lblHora.setText(formatoHora.format(fechaActual));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarHora() {
        while (true) {
            try {
                // Actualizar la hora cada segundo
                Thread.sleep(1000);
                mostrarFechaHoraActual();
            } catch (InterruptedException e) {
                e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panelGruposBtn = new javax.swing.JPanel();
        lblGruposBtn = new javax.swing.JLabel();
        panelAsignaturasBtn = new javax.swing.JPanel();
        lblAsignaturaBtn = new javax.swing.JLabel();
        panelAlumnosBtn = new javax.swing.JPanel();
        lblAlumnosbtn = new javax.swing.JLabel();
        panelTablasBtn = new javax.swing.JPanel();
        lblTablasBtn = new javax.swing.JLabel();
        panelCerrarSesion = new javax.swing.JPanel();
        lblCerrarSesion = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        minimizeBtn = new javax.swing.JPanel();
        minimizeTxt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        panelCarrusel = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Bienvenido a ICIIBA");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 750, -1));

        jPanel3.setBackground(new java.awt.Color(96, 22, 22));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-new (1).png"))); // NOI18N
        jLabel9.setText("ICIIBA");

        jPanel4.setBackground(new java.awt.Color(96, 22, 22));

        panelGruposBtn.setBackground(new java.awt.Color(123, 22, 22));

        lblGruposBtn.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        lblGruposBtn.setForeground(new java.awt.Color(255, 255, 255));
        lblGruposBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grupo-principal-2.png"))); // NOI18N
        lblGruposBtn.setText("Grupos");
        lblGruposBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGruposBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGruposBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGruposBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGruposBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelGruposBtnLayout = new javax.swing.GroupLayout(panelGruposBtn);
        panelGruposBtn.setLayout(panelGruposBtnLayout);
        panelGruposBtnLayout.setHorizontalGroup(
            panelGruposBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGruposBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        panelGruposBtnLayout.setVerticalGroup(
            panelGruposBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGruposBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        panelAsignaturasBtn.setBackground(new java.awt.Color(123, 22, 22));

        lblAsignaturaBtn.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        lblAsignaturaBtn.setForeground(new java.awt.Color(255, 255, 255));
        lblAsignaturaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asignatura-principal-2.png"))); // NOI18N
        lblAsignaturaBtn.setText("Asignaturas");
        lblAsignaturaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAsignaturaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAsignaturaBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAsignaturaBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAsignaturaBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAsignaturasBtnLayout = new javax.swing.GroupLayout(panelAsignaturasBtn);
        panelAsignaturasBtn.setLayout(panelAsignaturasBtnLayout);
        panelAsignaturasBtnLayout.setHorizontalGroup(
            panelAsignaturasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignaturasBtnLayout.createSequentialGroup()
                .addComponent(lblAsignaturaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAsignaturasBtnLayout.setVerticalGroup(
            panelAsignaturasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAsignaturaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelAlumnosBtn.setBackground(new java.awt.Color(123, 22, 22));

        lblAlumnosbtn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblAlumnosbtn.setForeground(new java.awt.Color(255, 255, 255));
        lblAlumnosbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAlumnosbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alumnos-principal-2.png"))); // NOI18N
        lblAlumnosbtn.setText("     Alumnos");
        lblAlumnosbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAlumnosbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlumnosbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAlumnosbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAlumnosbtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAlumnosBtnLayout = new javax.swing.GroupLayout(panelAlumnosBtn);
        panelAlumnosBtn.setLayout(panelAlumnosBtnLayout);
        panelAlumnosBtnLayout.setHorizontalGroup(
            panelAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlumnosbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlumnosBtnLayout.setVerticalGroup(
            panelAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAlumnosbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        panelTablasBtn.setBackground(new java.awt.Color(123, 22, 22));

        lblTablasBtn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblTablasBtn.setForeground(new java.awt.Color(255, 255, 255));
        lblTablasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tablas-principal-2.png"))); // NOI18N
        lblTablasBtn.setText("Tablas");
        lblTablasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTablasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTablasBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTablasBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTablasBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelTablasBtnLayout = new javax.swing.GroupLayout(panelTablasBtn);
        panelTablasBtn.setLayout(panelTablasBtnLayout);
        panelTablasBtnLayout.setHorizontalGroup(
            panelTablasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablasBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTablasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablasBtnLayout.setVerticalGroup(
            panelTablasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablasBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTablasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelCerrarSesion.setBackground(new java.awt.Color(123, 22, 22));

        lblCerrarSesion.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrarSesion.setText("Cerrar Sesion");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelCerrarSesionLayout = new javax.swing.GroupLayout(panelCerrarSesion);
        panelCerrarSesion.setLayout(panelCerrarSesionLayout);
        panelCerrarSesionLayout.setHorizontalGroup(
            panelCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCerrarSesionLayout.createSequentialGroup()
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCerrarSesionLayout.setVerticalGroup(
            panelCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAsignaturasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGruposBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(panelAlumnosBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addComponent(panelTablasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(panelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAsignaturasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelGruposBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlumnosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(panelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 580));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setBackground(new java.awt.Color(255, 255, 255));
        exitTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(0, 0, 0));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        minimizeBtn.setBackground(new java.awt.Color(255, 255, 255));

        minimizeTxt.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        minimizeTxt.setForeground(new java.awt.Color(0, 0, 0));
        minimizeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeTxt.setText("—");
        minimizeTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout minimizeBtnLayout = new javax.swing.GroupLayout(minimizeBtn);
        minimizeBtn.setLayout(minimizeBtnLayout);
        minimizeBtnLayout.setHorizontalGroup(
            minimizeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(minimizeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(minimizeTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );
        minimizeBtnLayout.setVerticalGroup(
            minimizeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(minimizeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(minimizeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(859, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(minimizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 30));

        jPanel2.setBackground(new java.awt.Color(194, 152, 66));

        lblFecha.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblFecha.setText("jLabel1");

        lblHora.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblHora.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblFecha)
                .addGap(301, 301, 301)
                .addComponent(lblHora)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(lblHora))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 750, 60));

        panelCarrusel.setBackground(new java.awt.Color(255, 255, 255));

        labelImagen.setText("Cargando imagenes...");

        javax.swing.GroupLayout panelCarruselLayout = new javax.swing.GroupLayout(panelCarrusel);
        panelCarrusel.setLayout(panelCarruselLayout);
        panelCarruselLayout.setHorizontalGroup(
            panelCarruselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarruselLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagen)
                .addContainerGap(589, Short.MAX_VALUE))
        );
        panelCarruselLayout.setVerticalGroup(
            panelCarruselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarruselLayout.createSequentialGroup()
                .addComponent(labelImagen)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        jPanel1.add(panelCarrusel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 710, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAsignaturaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsignaturaBtnMouseClicked
        Registrar_Asignatura registrar_curso = new Registrar_Asignatura();
        registrar_curso.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblAsignaturaBtnMouseClicked

    private void lblGruposBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGruposBtnMouseClicked
        Registrar_Grupos registrar_Grupos = new Registrar_Grupos();
        registrar_Grupos.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblGruposBtnMouseClicked

    private void lblAlumnosbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlumnosbtnMouseClicked
        Ver_Alumnos ver_Alumnos = new Ver_Alumnos();
        ver_Alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblAlumnosbtnMouseClicked

    private void lblAsignaturaBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsignaturaBtnMouseEntered
        panelAsignaturasBtn.setBackground(new Color(170, 22, 22));
        lblAsignaturaBtn.setBackground(new Color(170, 22, 22));
    }//GEN-LAST:event_lblAsignaturaBtnMouseEntered

    private void lblAsignaturaBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsignaturaBtnMouseExited
        panelAsignaturasBtn.setBackground(new Color(123, 22, 22));
        lblAsignaturaBtn.setBackground(new Color(123, 22, 22));
    }//GEN-LAST:event_lblAsignaturaBtnMouseExited

    private void lblGruposBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGruposBtnMouseEntered
        panelGruposBtn.setBackground(new Color(170, 22, 22));
        lblGruposBtn.setBackground(new Color(170, 22, 22));
    }//GEN-LAST:event_lblGruposBtnMouseEntered

    private void lblGruposBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGruposBtnMouseExited
        panelGruposBtn.setBackground(new Color(123, 22, 22));
        lblGruposBtn.setBackground(new Color(123, 22, 22));
    }//GEN-LAST:event_lblGruposBtnMouseExited

    private void lblAlumnosbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlumnosbtnMouseEntered
        panelAlumnosBtn.setBackground(new Color(170, 22, 22));
        lblAlumnosbtn.setBackground(new Color(170, 22, 22));
    }//GEN-LAST:event_lblAlumnosbtnMouseEntered

    private void lblAlumnosbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlumnosbtnMouseExited
        panelAlumnosBtn.setBackground(new Color(123, 22, 22));
        lblAlumnosbtn.setBackground(new Color(123, 22, 22));
    }//GEN-LAST:event_lblAlumnosbtnMouseExited

    private void lblTablasBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTablasBtnMouseClicked
        Importar_Gestionar importar_gestionar = new Importar_Gestionar();
        importar_gestionar.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblTablasBtnMouseClicked

    private void lblTablasBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTablasBtnMouseEntered
        panelTablasBtn.setBackground(new Color(170, 22, 22));
        lblAlumnosbtn.setBackground(new Color(170, 22, 22));
    }//GEN-LAST:event_lblTablasBtnMouseEntered

    private void lblTablasBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTablasBtnMouseExited
        panelTablasBtn.setBackground(new Color(123, 22, 22));
        lblAlumnosbtn.setBackground(new Color(123, 22, 22));
    }//GEN-LAST:event_lblTablasBtnMouseExited

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar el sistema?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        panelCerrarSesion.setBackground(new Color(170, 22, 22));
        lblCerrarSesion.setBackground(new Color(170, 22, 22));
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        panelCerrarSesion.setBackground(new Color(123, 22, 22));
        lblCerrarSesion.setBackground(new Color(123, 22, 22));
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void minimizeTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeTxtMouseClicked
        setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeTxtMouseClicked

    private void minimizeTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeTxtMouseEntered
        minimizeBtn.setBackground(Color.GRAY);
        minimizeTxt.setForeground(Color.white);
    }//GEN-LAST:event_minimizeTxtMouseEntered

    private void minimizeTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeTxtMouseExited
        minimizeBtn.setBackground(Color.white);
        minimizeTxt.setForeground(Color.black);
    }//GEN-LAST:event_minimizeTxtMouseExited

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    Conectar con = new Conectar();
    Connection cn = con.conexion();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel lblAlumnosbtn;
    private javax.swing.JLabel lblAsignaturaBtn;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGruposBtn;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTablasBtn;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel minimizeBtn;
    private javax.swing.JLabel minimizeTxt;
    private javax.swing.JPanel panelAlumnosBtn;
    private javax.swing.JPanel panelAsignaturasBtn;
    private javax.swing.JPanel panelCarrusel;
    private javax.swing.JPanel panelCerrarSesion;
    private javax.swing.JPanel panelGruposBtn;
    private javax.swing.JPanel panelTablasBtn;
    // End of variables declaration//GEN-END:variables
}
