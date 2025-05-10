package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import controller.GestorAlquileres;
import controller.GestorUsuarios;
import model.Alquiler;
import model.Pelicula;
import model.Usuario;

public class IU_ALQUILAR extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String correoUsuario;
    private Pelicula pelicula;

    public void run() {
        try {
            IU_ALQUILAR frame = new IU_ALQUILAR(pelicula, correoUsuario);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Constructor que recibe una película
    public IU_ALQUILAR(Pelicula pelicula, String correo) {
        this.correoUsuario = correo;
        this.pelicula = pelicula;
        setTitle("Alquilar Película");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setBounds(100, 100, 400, 300);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Cambiar color de fondo de la ventana
        contentPane.setBackground(new Color(60, 63, 65));

        // Panel para mostrar información de la película
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(240, 248, 255)); // Asegurar que el panel tenga el mismo fondo
        contentPane.add(panelInfo, BorderLayout.CENTER);

        // Crear un área de texto para mostrar la información
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Solo lectura
        textArea.setText("Título: " + this.pelicula.getTitulo() + "\n"
                + "Director: " + this.pelicula.getDirector() + "\n"
                + "Año: " + this.pelicula.getAnio());
        textArea.setBackground(new Color(240, 248, 255)); // Fondo igual al de la ventana
        textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente
        contentPane.add(textArea, BorderLayout.CENTER);

        // Panel para los botones
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(240, 248, 255)); // Fondo igual al de la ventana
        contentPane.add(panelBoton, BorderLayout.SOUTH);

        // Botón para alquilar
        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAlquilar.setBackground(new Color(100, 149, 237)); // Color de fondo azul
        btnAlquilar.setForeground(Color.WHITE); // Color de texto blanco
        btnAlquilar.setFocusPainted(false); // Eliminar borde de foco
        panelBoton.add(btnAlquilar);

        // Acción del botón "Alquilar"
        btnAlquilar.addActionListener(e -> {
            // Buscar usuario por correo
            Usuario usuario = GestorUsuarios.getGUsuarios().buscarUsuario(correoUsuario);
            
            if (usuario.getSusAlquileres() == null) {
                Alquiler al = GestorAlquileres.getGAlquileres().crearAlquiler(usuario, pelicula);
                GestorAlquileres.getGAlquileres().anadirAlquiler(usuario, al);
                JOptionPane.showMessageDialog(this, "Has alquilado la película: " + pelicula.getTitulo());
            } else {
                if (usuario.laHeAlquilado(this.pelicula.getCodPeli())) {
                    // Si ya la tiene alquilada
                    JOptionPane.showMessageDialog(this, "Ya tenías alquilada la película: " + pelicula.getTitulo());
                } else {
                    // Si no está alquilada
                    Alquiler al = GestorAlquileres.getGAlquileres().crearAlquiler(usuario, pelicula);
                    GestorAlquileres.getGAlquileres().anadirAlquiler(usuario, al);
                    JOptionPane.showMessageDialog(this, "Has alquilado la película: " + pelicula.getTitulo());
                }
            }
            this.dispose(); // Cierra la ventana tras alquilar
        });
    }
}
