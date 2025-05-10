package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;
import model.Usuario;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class IU_ADMIN_BORRAR_USUARIO extends JFrame {

	private JPanel contentPane;
	private JButton borrarUserBtn;
    private Controler controler = null;
    JList<String> listaUsuarios;
    ArrayList<Usuario> listaCompleta;
    private String correoAdm;

	/**
	 * Launch the application.
	 */
	
	
	public void run() {
		try {
			IU_ADMIN_BORRAR_USUARIO frame = new IU_ADMIN_BORRAR_USUARIO(correoAdm);
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public IU_ADMIN_BORRAR_USUARIO(String pCorreo) {
		this.correoAdm = pCorreo;
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
		
		
		
		borrarUserBtn = new JButton("BORRAR");
		borrarUserBtn.addActionListener(getControler());
		contentPane.add(borrarUserBtn);
	}
		
	
	public void closeWindow() {
		this.removeAll();
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
        	if(e.getSource().equals(borrarUserBtn)) {
        		System.out.println("click");
        		String correoUser = listaUsuarios.getSelectedValue();
        		
        		closeWindow();
        		
        		GestorUsuarios.getGUsuarios().eliminarUsuario(correoUser,correoAdm);
        		run();
        		
        	}
        }
    }

}
