package view;

import java.awt.EventQueue;
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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU_SOLICITUDES_REG extends JFrame {

	private JPanel contentPane;
	private JList<String> listaSolicitudes;
    private Controler controler = null;
    JButton aceptarSolicitudBtn;
    private String correoAdmin;

	/**
	 * Launch the application.
	 */
    public void run() {
		try {
			IU_SOLICITUDES_REG frame = new IU_SOLICITUDES_REG(correoAdmin);
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public IU_SOLICITUDES_REG(String pCorreo) {
		this.correoAdmin = pCorreo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> listaSolicitudes = new JList<>(listModel);
		ArrayList<Usuario> listaCompleta = GestorUsuarios.getGUsuarios().getListaUsuarios();
		
		for(Usuario u : listaCompleta) {
			if(!u.esValidoUsuario()) {
				listModel.addElement(u.getCorreo());
			}
		}
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		listaSolicitudes.setModel(listModel);
		listaSolicitudes.setBounds(1, 1, 1, 1);
		contentPane.add(new JScrollPane(listaSolicitudes));
		
		JButton aceptarSolicitudBtn = new JButton("ACEPTAR");
		aceptarSolicitudBtn.addActionListener(getControler());
		contentPane.add(aceptarSolicitudBtn);
		
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
        	if(e.getSource().equals(aceptarSolicitudBtn)) {
        		System.out.println(listaSolicitudes.getSelectedValue());
        		GestorUsuarios.getGUsuarios().marcarRegistrado(listaSolicitudes.getSelectedValue(),correoAdmin);
        		IU_SOLICITUDES_REG iusr = new IU_SOLICITUDES_REG(correoAdmin);
        		iusr.run();
        		closeWindow();
        	}
        }
    }
}
