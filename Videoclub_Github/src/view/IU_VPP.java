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
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;
import controller.GestorValoraciones;
import model.Pelicula;
import model.Usuario;
import model.Valoracion;

public class IU_VPP extends JFrame {

	private JPanel contentPane;
	private JButton ordenarBtn;
    private Controler controler = null;
    JList<String> listaValoraciones;
    ArrayList<Valoracion> listaCompleta;
    private Pelicula pPelicula;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_VPP frame = new IU_VPP(pPelicula);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}


	/**
	 * Create the frame.
	 */
	public IU_VPP(Pelicula pelicula) {
		this.pPelicula = pelicula;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
	    ArrayList<Valoracion> listaCompleta = GestorValoraciones.getGV().getListaValoracionPorPelicula(pPelicula);
	    listaValoraciones = new JList<>();
		listaValoraciones.setBounds(1, 1, 1, 1);
		listaValoraciones = new JList<>(listModel);
		contentPane.add(new JScrollPane(listaValoraciones));
		
		if (listaCompleta != null) {
			for(Valoracion v : listaCompleta) {
				listModel.addElement(v.getUsuario().getNombre());
				listModel.addElement(Double.toString(v.getPuntuacion()));
				listModel.addElement(v.getResena());
			}
			listaValoraciones.setModel(listModel);	
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			ordenarBtn = new JButton("ORDENAR POR PUNTUACION");
			ordenarBtn.addActionListener(getControler());
			contentPane.add(ordenarBtn);
		}
		else {
			System.out.println("Esta pelicula no tiene valoraciones");
		}
		
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
        	 if (e.getSource().equals(ordenarBtn)) {
                 System.out.println("click");
                 // Ordenar la lista de valoraciones de mayor a menor por puntuación
                 listaCompleta.sort((v1, v2) -> Double.compare(v2.getPuntuacion(), v1.getPuntuacion()));

                 // Limpiar el modelo de la lista actual
                 DefaultListModel<String> nuevoListModel = new DefaultListModel<>();

                 // Poblar el modelo con los datos ordenados
                 for (Valoracion v : listaCompleta) {
                     nuevoListModel.addElement(v.getUsuario().getNombre());
                     nuevoListModel.addElement(Double.toString(v.getPuntuacion()));
                     nuevoListModel.addElement(v.getResena());
                 }

                 // Asignar el nuevo modelo al JList
                 listaValoraciones.setModel(nuevoListModel);
             }
         }
    }
}
