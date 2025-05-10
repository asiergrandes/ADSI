package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import controller.GestorValoraciones;
import model.Pelicula;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class IU_PYR extends JFrame {

	private JPanel contentPane;
	private JTextField puntuacion;
	private JTextField resena;
	private Controler controler = null;
	private JButton valoracion;
	private Pelicula pPelicula;
	private String correo;
    private boolean esAdmin;


	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_PYR frame = new IU_PYR(correo, pPelicula);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	
	/**
	 * Create the frame.
	 */
	public IU_PYR(String usuario, Pelicula pelicula) {
		this.correo = usuario;
		this.pPelicula = pelicula;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		puntuacion = new JTextField();
		puntuacion.setBounds(162, 92, 96, 19);
		contentPane.add(puntuacion);
		puntuacion.setColumns(10);
		puntuacion.addActionListener(getControler());
		
		
		resena = new JTextField();
		resena.setBounds(162, 145, 96, 19);
		contentPane.add(resena);
		resena.setColumns(10);
		resena.addActionListener(getControler());
		
		valoracion = new JButton("VALORAR");
		valoracion.setBounds(162, 202, 96, 21);
		contentPane.add(valoracion);
		valoracion.addActionListener(getControler());
		
		
		
		JLabel lblNewLabel = new JLabel("Puntuación");
		lblNewLabel.setBounds(162, 131, 73, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reseña");
		lblNewLabel_1.setBounds(162, 77, 45, 13);
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
            if(e.getSource().equals(valoracion)) {
            	
            	Double puntacionV = Double.parseDouble(puntuacion.getText());
        		String resenaV = resena.getText();
        		
        		Boolean valoracionExitosa = GestorValoraciones.getGV().anadirVal(correo, pPelicula, puntacionV, resenaV);
        		
        		if(valoracionExitosa) {
        			//pasar al menu
        			closeWindow();
        			IU_MENU ium = new IU_MENU(correo, esAdmin);
        			ium.run();
        		}
        		else {
        			
        			//mostrar error
        			closeWindow();
        			IU_ERROR_VALORAR iuev = new IU_ERROR_VALORAR(correo, pPelicula);
        			iuev.run();
        		}
        		
                
            }
        }
    }

}
