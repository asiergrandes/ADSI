package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;
import controller.GestorValoraciones;

public class IU_MRP extends JFrame {

	private JPanel contentPane;
	private String correo;
	
    private Controler controler = null;
	private JTextField newPuntuacion;
	private JTextField newResena;
	private JButton confirmCambios;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_MRP frame = new IU_MRP(correo);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	public IU_MRP(String email) {	
		
		this.correo = email;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		newPuntuacion = new JTextField();
		newPuntuacion.setBounds(147, 44, 96, 19);
		contentPane.add(newPuntuacion);
		newPuntuacion.setColumns(10);
		
		newResena = new JTextField();
		newResena.setBounds(147, 113, 96, 19);
		contentPane.add(newResena);
		newResena.setColumns(10);
		
		confirmCambios = new JButton("CONFIRM");
		confirmCambios.setBounds(147, 211, 96, 21);
		contentPane.add(confirmCambios);
		
		JLabel lblNewLabel = new JLabel("Puntuacion");
		lblNewLabel.setBounds(147, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("rese\u00F1a");
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
        		Double puntuacionN = Double.parseDouble(newPuntuacion.getText());
        		String resenaN = newResena.getText();
        		
        		GestorValoraciones.getGV().modificarValoracion(correo, puntuacionN, resenaN);
        	}
        }
    }
}
