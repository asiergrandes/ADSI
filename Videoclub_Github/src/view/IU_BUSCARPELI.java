package view;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import javax.swing.JList;
import model.Pelicula;
import model.Valoracion;
import controller.GestorPelis;
import controller.GestorValoraciones;

public class IU_BUSCARPELI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList<String> list;
	private GestorPelis gestorPeliculas; // Gestor de películas
	String correoUsuario;
	
	
	public void run() {
		try {
			IU_BUSCARPELI frame = new IU_BUSCARPELI(correoUsuario);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}

	// Constructor de la ventana
	public IU_BUSCARPELI(String correo) {
		this.correoUsuario = correo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);

		gestorPeliculas = GestorPelis.getGPelis(); // Inicializa el gestor de películas
		cargarPeliculas(); // Cargar algunas películas de ejemplo
		actualizarLista(); // Actualiza la JList con las películas
		agregarListSelectionListener();
	}

	// Método para cargar algunas películas de ejemplo
	private void cargarPeliculas() {
		//gestorValoraciones.anadirValoracion(...)
		gestorPeliculas.anadirPelicula(new Pelicula(1,"El Padrino", "Francis Ford Coppola","asier", 1972,"fvh","dfghjkl"));
	}

	// Método para actualizar la lista con las películas
	private void actualizarLista() {
		Iterator<Pelicula> iterador = gestorPeliculas.getIterador();
		DefaultListModel<String> modelo = new DefaultListModel<>(); // Modelo para la lista
		
		while (iterador.hasNext()) {
			Pelicula pelicula = iterador.next();
			modelo.addElement(pelicula.getTitulo());
		}
		list.setModel(modelo); // Establecer el modelo en la JList
	}
	
	public void closeWindow() {
		this.dispose();
	}
	
	private void agregarListSelectionListener() {
		list.addListSelectionListener(new ListSelectionListener() {
			

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { // Evitar manejar eventos duplicados
					String titulo = list.getSelectedValue(); // Obtener el título seleccionado
					Pelicula pelicula = gestorPeliculas.buscarPeliculaPorTitulo(titulo); // Buscar la película

					if (pelicula != null) {
						// Abrir la ventana IU_MENU_PELI con la película seleccionada
						closeWindow();
						IU_MENU_PELI ventanaMenuPeli = new IU_MENU_PELI(pelicula, correoUsuario);
						ventanaMenuPeli.run();
						
					}
				}
			}
		});
	}

	// Panel contenedor de la JList
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getList(), BorderLayout.CENTER);
		}
		return panel;
	}

	// Método para obtener la JList
	private JList<String> getList() {
		if (list == null) {
			list = new JList<>();
		}
		return list;
	}
}