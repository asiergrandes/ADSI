package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

public class IU_REGISTRO extends JFrame {

    private JPanel contentPane;
    private JTextField nombre;
    private JTextField correo;
    private JTextField contrasena;
    private JTextField fechaNacimiento;
    private Controler controler = null;
    private JButton registerBtn;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_REGISTRO frame = new IU_REGISTRO();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_REGISTRO() {
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        setResizable(false);

        // Configuración del panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 63, 65)); // Fondo oscuro
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Etiqueta para el título
        JLabel titleLabel = new JLabel("Registro de Usuario");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(titleLabel);

        // Espaciado después del título
        contentPane.add(Box.createVerticalStrut(20));

        // Campo de texto: Nombre
        addLabeledField("Nombre:", nombre = new JTextField());

        // Campo de texto: Correo
        addLabeledField("Correo:", correo = new JTextField());

        // Campo de texto: Contraseña
        addLabeledField("Contraseña:", contrasena = new JTextField());

        // Campo de texto: Fecha de nacimiento
        addLabeledField("Fecha Nacimiento (DD/MM/YYYY):", fechaNacimiento = new JTextField());

        // Espaciado antes del botón
        contentPane.add(Box.createVerticalStrut(20));

        // Botón de registro
        registerBtn = new JButton("REGISTRAR");
        registerBtn.setFont(new Font("Arial", Font.BOLD, 14));
        registerBtn.setBackground(new Color(45, 150, 255)); // Azul claro
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFocusPainted(false);
        registerBtn.setBorderPainted(false);
        registerBtn.setOpaque(true);
        registerBtn.setAlignmentX(CENTER_ALIGNMENT);
        registerBtn.addActionListener(getControler());
        contentPane.add(registerBtn);

        // Espaciado inferior
        contentPane.add(Box.createVerticalStrut(20));
    }

    // Método auxiliar para añadir campos etiquetados
    private void addLabeledField(String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(label);

        contentPane.add(Box.createVerticalStrut(5));

        textField.setMaximumSize(new Dimension(300, 30)); // Aumentar ancho del campo
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setMinimumSize(new Dimension(300, 30));
        textField.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(textField);

        contentPane.add(Box.createVerticalStrut(10));
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
            if (e.getSource().equals(registerBtn)) {
                // CHECKEAR Y PROCEDER CON EL REGISTRO
                String nombreR = nombre.getText();
                String correoR = correo.getText();
                String contrasenaR = contrasena.getText();
                String fechaNacR = fechaNacimiento.getText();

                boolean registroExitoso = GestorUsuarios.getGUsuarios().anadirRegistro(nombreR, correoR, contrasenaR, fechaNacR);

                if (registroExitoso) {
                    // PASAR AL MENÚ
                    System.out.println("Hago close y abro menú");
                    closeWindow();
                    IU_MENU iueli = new IU_MENU(correoR, false);
                    iueli.run();
                } else {
                    // MOSTRAR ERROR
                    closeWindow();
                    IU_ERROR_REGISTER iuer = new IU_ERROR_REGISTER();
                    iuer.run();
                }
            }
        }
    }
}
