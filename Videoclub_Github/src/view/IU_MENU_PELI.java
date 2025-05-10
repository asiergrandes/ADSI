package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;

import model.Pelicula;

public class IU_MENU_PELI extends JFrame {

    private JPanel contentPane;
    private JButton valorar;
    private JButton alquilar;
    private JButton vpp;

    private Controler controler = null;
    private Pelicula pPelicula;
    private String correo;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_MENU_PELI frame = new IU_MENU_PELI(pPelicula, correo);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_MENU_PELI(Pelicula pelicula, String usuario) {
        this.pPelicula = pelicula;
        this.correo = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Usar BoxLayout para una disposición vertical de los botones
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Cambiar color de fondo de la ventana
        contentPane.setBackground(new Color(240, 248, 255)); // Azul claro como ejemplo
        contentPane.setBackground(new Color(60, 63, 65));
        // Crear los botones
        valorar = new JButton("PUNTUAR Y RESERÑAR");
        configurarBoton(valorar);
        contentPane.add(valorar);

        // Agregar separación vertical entre los botones
        contentPane.add(Box.createVerticalStrut(20)); // Separación de 20 píxeles

        alquilar = new JButton("ALQUILAR");
        configurarBoton(alquilar);
        contentPane.add(alquilar);

        // Más separación vertical
        contentPane.add(Box.createVerticalStrut(20)); // Separación de 20 píxeles

        vpp = new JButton("VER PUNTUACIONES PROMEDIO");
        configurarBoton(vpp);
        contentPane.add(vpp);

        // Agregar acción a los botones
        this.valorar.addActionListener(this.getControler());
        this.alquilar.addActionListener(this.getControler());
        this.vpp.addActionListener(this.getControler());
    }

    // Método para configurar el estilo de los botones
    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente
        boton.setBackground(new Color(100, 149, 237)); // Color de fondo (azul)
        boton.setForeground(Color.WHITE); // Color de texto
        boton.setFocusPainted(false); // Elimina el borde de foco
        boton.setAlignmentX(CENTER_ALIGNMENT); // Centra los botones
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
        private Controler() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(valorar)) {
                // Iniciar una ventana de puntuación y reseña
                closeWindow();
                IU_PYR iupyr = new IU_PYR(correo, pPelicula);
                iupyr.run();
            }

            if (e.getSource().equals(alquilar)) {
                // Iniciar una ventana de alquilar película
                closeWindow();
                IU_ALQUILAR iual = new IU_ALQUILAR(pPelicula, correo);
                iual.run();
            }

            if (e.getSource().equals(vpp)) {
                // Iniciar una ventana para ver las puntuaciones promedio
                closeWindow();
                IU_VPP iuvpp = new IU_VPP(pPelicula);
                iuvpp.run();
            }
        }
    }
}
