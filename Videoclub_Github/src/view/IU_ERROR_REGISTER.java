package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_ERROR_REGISTER extends JFrame {

    private JPanel contentPane;
    private Controler controler = null;
    private JButton backToRegBtn;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_ERROR_REGISTER frame = new IU_ERROR_REGISTER();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_ERROR_REGISTER() {
        setTitle("Error en el Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        // Configuración del panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 63, 65)); // Fondo oscuro
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Etiqueta para el mensaje de error
        JLabel lblErrorMessage1 = new JLabel("Correo ya existente o");
        lblErrorMessage1.setFont(new Font("Arial", Font.BOLD, 14));
        lblErrorMessage1.setForeground(Color.WHITE);
        lblErrorMessage1.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblErrorMessage1);

        JLabel lblErrorMessage2 = new JLabel("fecha de nacimiento no válida.");
        lblErrorMessage2.setFont(new Font("Arial", Font.BOLD, 14));
        lblErrorMessage2.setForeground(Color.WHITE);
        lblErrorMessage2.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblErrorMessage2);

        // Espaciado entre el mensaje y el botón
        contentPane.add(Box.createVerticalStrut(20));

        // Botón de aceptar
        backToRegBtn = new JButton("ACEPTAR");
        backToRegBtn.setFont(new Font("Arial", Font.BOLD, 14));
        backToRegBtn.setBackground(new Color(45, 150, 255)); // Azul claro
        backToRegBtn.setForeground(Color.WHITE);
        backToRegBtn.setFocusPainted(false);
        backToRegBtn.setBorderPainted(false);
        backToRegBtn.setOpaque(true);
        backToRegBtn.setAlignmentX(CENTER_ALIGNMENT);
        backToRegBtn.addActionListener(getControler());
        contentPane.add(backToRegBtn);

        // Espaciado inferior
        contentPane.add(Box.createVerticalStrut(20));
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
            if (e.getSource().equals(backToRegBtn)) {
                System.out.println("Volviendo a la pantalla de registro...");
                closeWindow();
                IU_REGISTRO iur = new IU_REGISTRO();
                iur.run();
            }
        }
    }
}
