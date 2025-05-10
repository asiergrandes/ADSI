package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pelicula;

public class IU_ERROR_VALORAR extends JFrame {

	private JPanel contentPane;
    private Controler controler = null;
    private JButton backToRegBtn;
    private String correo;
    private Pelicula pPelicula;

	/**
	 * Launch the application.
	 */
	 public void run() {
			try {
				IU_ERROR_VALORAR frame = new IU_ERROR_VALORAR(correo, pPelicula);
				frame.setVisible(true);
			} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public IU_ERROR_VALORAR(String usuario, Pelicula pelicula) {
		this.correo = usuario;
		this.pPelicula = pelicula;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backToRegBtn = new JButton("ACEPTAR");
		backToRegBtn.setBounds(164, 212, 85, 21);
		backToRegBtn.addActionListener(getControler());
		contentPane.add(backToRegBtn);
		
		JLabel lblNewLabel = new JLabel("VALORACION YA EXISTENTE O");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(123, 82, 233, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PUNTACION NO VALIDA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(123, 105, 257, 13);
		contentPane.add(lblNewLabel_1);
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
        	if(e.getSource().equals(backToRegBtn)) {
        		System.out.println("pulso");
        		closeWindow();
        		IU_PYR iur = new IU_PYR(correo, pPelicula);
        		iur.run();
        	}
        }
    }
}