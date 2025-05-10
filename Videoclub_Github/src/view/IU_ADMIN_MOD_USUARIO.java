package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;
import model.Usuario;

public class IU_ADMIN_MOD_USUARIO extends JFrame {

	private JPanel contentPane;
	private String correo;
	private JButton modUserBtn;
    private Controler controler = null;
    JList<String> listaUsuarios;
    ArrayList<Usuario> listaCompleta;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_ADMIN_MOD_USUARIO frame = new IU_ADMIN_MOD_USUARIO(correo);
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public IU_ADMIN_MOD_USUARIO(String correo) {
		this.correo = correo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
	    ArrayList<Usuario> listaCompleta = GestorUsuarios.getGUsuarios().getListaUsuarios();
	    listaUsuarios = new JList<>();
		listaUsuarios.setBounds(1, 1, 1, 1);
		listaUsuarios = new JList<>(listModel);
		contentPane.add(new JScrollPane(listaUsuarios));
		
		
		for(Usuario u : listaCompleta) {
			listModel.addElement(u.getCorreo());
			
		}
		listaUsuarios.setModel(listModel);

		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		modUserBtn = new JButton("BORRAR");
		modUserBtn.addActionListener(getControler());
		contentPane.add(modUserBtn);
		
		
		
		
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
        	if(e.getSource().equals(modUserBtn)) {
        		//CHECKEAR Y PROCEDER CON EL LOGIN
        		
        		String emailUsAModificar = listaUsuarios.getSelectedValue();
        		closeWindow();
        		IU_MOD_DATOS iumd = new IU_MOD_DATOS(emailUsAModificar);
        		iumd.run();
        		
        	}
        }
    }

}
