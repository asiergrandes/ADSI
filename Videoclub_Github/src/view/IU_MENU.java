package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_MENU extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton mrp;
    private JButton buscarPeli;
    private JButton actualizarDatos;
    private boolean esAdmin;
    private Controler controler = null;
    private String correo;
    private JButton adm_soli;
    private JButton adm_borrar;
    private JButton adm_modus;
    private JButton modus;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_MENU frame = new IU_MENU(correo, esAdmin);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_MENU(String email, boolean esAdmin) {
        this.correo = email;
        this.esAdmin = esAdmin;
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(238, 238, 238)); // Color de fondo similar a los anteriores
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        // Layout vertical con mayor espacio entre los botones
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color buttonColor = new Color(45, 150, 255); // Azul claro para los botones

        // Botones comunes
        mrp = createButton("PUNTUAR Y RESERÑAR", buttonFont, buttonColor);
        buscarPeli = createButton("BUSCAR PELICULA", buttonFont, buttonColor);
        actualizarDatos = createButton("ACTUALIZAR DATOS", buttonFont, buttonColor);
        modus = createButton("MODIFICAR MIS DATOS", buttonFont, buttonColor);

        // Agregar botones comunes al panel
        contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
        contentPane.add(mrp);
        contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
        contentPane.add(buscarPeli);
        contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
        contentPane.add(actualizarDatos);
        contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
        contentPane.add(modus);
        
        if (esAdmin) {
            // Botones específicos para Admin
            adm_soli = createButton("SOLICITUDES", buttonFont, buttonColor);
            adm_borrar = createButton("BORRAR USUARIOS", buttonFont, buttonColor);
            adm_modus = createButton("MODIFICAR USERS", buttonFont, buttonColor);

            // Agregar botones de Admin al panel
            contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
            contentPane.add(adm_soli);
            contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
            contentPane.add(adm_borrar);
            contentPane.add(Box.createVerticalStrut(20));  // Espaciado entre los botones
            contentPane.add(adm_modus);
        }

        // Añadir acción para cada botón
        this.mrp.addActionListener(this.getControler());
        this.buscarPeli.addActionListener(this.getControler());
        this.actualizarDatos.addActionListener(this.getControler());
        this.modus.addActionListener(this.getControler());
        if (esAdmin) {
            this.adm_soli.addActionListener(this.getControler());
            this.adm_borrar.addActionListener(this.getControler());
            this.adm_modus.addActionListener(this.getControler());
        }
    }

    private JButton createButton(String text, Font font, Color color) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setAlignmentX(CENTER_ALIGNMENT); // Centrar los botones
        return button;
    }

    public void closeWindow() {
        this.dispose();
    }

    private Controler getControler() {
        if (this.controler == null) {
            this.controler = new Controler();
        }
        return this.controler;
    }

    private class Controler implements ActionListener {
        private Controler() {}

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(mrp)) {
                // Iniciar ventana de puntuación y reseña
                closeWindow();
                IU_MRP iumrp = new IU_MRP(correo);
                iumrp.run();
            }

            if (e.getSource().equals(buscarPeli)) {
                // Iniciar ventana de búsqueda de película
                closeWindow();
                IU_BUSCARPELI iual = new IU_BUSCARPELI(correo);
                iual.run();
            }

            if (e.getSource().equals(actualizarDatos)) {
                // Iniciar ventana para actualizar datos
                closeWindow();
                IU_MOD_DATOS iumd = new IU_MOD_DATOS(correo);
                iumd.run();
            }

            if (e.getSource().equals(modus)) {
                // Iniciar ventana para modificar datos de usuario
                closeWindow();
                IU_MOD_DATOS iumd = new IU_MOD_DATOS(correo);
                iumd.run();
            }

            if (e.getSource().equals(adm_soli)) {
                // Iniciar ventana para gestionar solicitudes
                closeWindow();
                IU_SOLICITUDES_REG iusr = new IU_SOLICITUDES_REG(correo);
                iusr.run();
            }

            if (e.getSource().equals(adm_borrar)) {
                // Iniciar ventana para borrar usuarios
                closeWindow();
                IU_ADMIN_BORRAR_USUARIO iumd = new IU_ADMIN_BORRAR_USUARIO(correo);
                iumd.run();
            }

            if (e.getSource().equals(adm_modus)) {
                // Iniciar ventana para modificar usuarios
                closeWindow();
                IU_ADMIN_MOD_USUARIO iumu = new IU_ADMIN_MOD_USUARIO(correo);
                iumu.run();
            }
        }
    }
}
