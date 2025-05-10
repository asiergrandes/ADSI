package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class IU_MOD_DATOS extends JFrame {

	private JPanel contentPane;
	private JTextField newNombre;
	private JTextField newContrasena;
	private JButton confirmCambios;
    private Controler controler = null;
    private String correoUsuario;

    
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_ERROR_LOGIN frame = new IU_ERROR_LOGIN();
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public IU_MOD_DATOS(String correo) {
		this.correoUsuario = correo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		newNombre = new JTextField();
		newNombre.setBounds(147, 44, 96, 19);
		contentPane.add(newNombre);
		newNombre.setColumns(10);
		
		newContrasena = new JTextField();
		newContrasena.setBounds(147, 113, 96, 19);
		contentPane.add(newContrasena);
		newContrasena.setColumns(10);
		
		confirmCambios = new JButton("CONFIRM");
		confirmCambios.setBounds(147, 211, 96, 21);
		contentPane.add(confirmCambios);
		
		JLabel lblNewLabel = new JLabel("nombre");
		lblNewLabel.setBounds(147, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("contrase\u00F1a");
		lblNewLabel_2.setBounds(147, 101, 58, 13);
		contentPane.add(lblNewLabel_2);
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
        	if(e.getSource().equals(confirmCambios)) {
        		//UPDATE USER DATA
        		String contrasenaN = newContrasena.getText();
        		String nombreN = newNombre.getText();
        		
        		GestorUsuarios.getGUsuarios().modificarDatosUser(correoUsuario, nombreN, contrasenaN);
        		closeWindow();
        		IU_MENU ium = new IU_MENU(correoUsuario, GestorUsuarios.getGUsuarios().esAdmin(correoUsuario));
        		ium.run();
        	}
        }
    }
}
