package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Consultas.Script;
import Controladores.ControladorBBDD;
import clases.Profesor;

import java.awt.SystemColor;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class VistaDatosVenta{

	private JFrame frame;
	private JTextField JTF_IDprofesor;
	private JTextField JTF_NIFprofesor;
	private JTextField JTF_nombreprofesor;
	private JTextField JTF_especialidad;
	private JTextField JTF_telefono;
	private ControladorBBDD micontro;
	private JLabel JLB_sistema;
	private Profesor miprofe;
	private JButton BTN_Cancelar;
	private JButton BTN_aceptar;
	private JButton btnModificar;
	private JButton BTN_Crear;
	private JLabel JLB_IDprof;
	private JButton JBT_anterior;
	private JButton JBT_primero;
	private JButton JBT_ulltimo;
	private JButton JBT_siguiente;
	private JButton JBT_eliminarbbdd;
	private JButton JBT_SIII;
	private JButton JBT_noo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaDatosVenta window = new VistaDatosVenta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaDatosVenta() {
		initialize(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
			
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setForeground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 634, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLB_IDprof = new JLabel("ID ");
		JLB_IDprof.setBackground(new Color(255, 255, 255));
		JLB_IDprof.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLB_IDprof.setBounds(76, 154, 58, 27);
		frame.getContentPane().add(JLB_IDprof);
		
		JTF_IDprofesor = new JTextField();
		JTF_IDprofesor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTF_IDprofesor.setBounds(151, 158, 96, 19);
		frame.getContentPane().add(JTF_IDprofesor);
		JTF_IDprofesor.setColumns(10);
		
		
		JLabel Titulo = new JLabel("Datos profesor");
		Titulo.setBackground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Tahoma", Font.ITALIC, 30));
		Titulo.setBounds(194, 64, 224, 44);
		frame.getContentPane().add(Titulo);
		
		JLabel JLB_NIF = new JLabel("Nif ");
		JLB_NIF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLB_NIF.setBounds(78, 201, 56, 19);
		frame.getContentPane().add(JLB_NIF);
		
		JTF_NIFprofesor = new JTextField();
		JTF_NIFprofesor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTF_NIFprofesor.setBounds(151, 201, 96, 19);
		frame.getContentPane().add(JTF_NIFprofesor);
		JTF_NIFprofesor.setColumns(10);
		
		JLabel JLB_nombre = new JLabel("Nombre");
		JLB_nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLB_nombre.setBounds(63, 242, 58, 19);
		frame.getContentPane().add(JLB_nombre);
		
		JTF_nombreprofesor = new JTextField();
		JTF_nombreprofesor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTF_nombreprofesor.setBounds(151, 244, 96, 19);
		frame.getContentPane().add(JTF_nombreprofesor);
		JTF_nombreprofesor.setColumns(10);
		
		JLabel JLB_especialidad = new JLabel("Especialidad");
		JLB_especialidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLB_especialidad.setBounds(63, 281, 81, 19);
		frame.getContentPane().add(JLB_especialidad);
		
		JLabel JLB_telefono = new JLabel("Telefono");
		JLB_telefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLB_telefono.setBounds(63, 323, 58, 19);
		frame.getContentPane().add(JLB_telefono);
		
		JTF_especialidad = new JTextField();
		JTF_especialidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTF_especialidad.setBounds(151, 283, 96, 19);
		frame.getContentPane().add(JTF_especialidad);
		JTF_especialidad.setColumns(10);
		
		JTF_telefono = new JTextField();
		JTF_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JTF_telefono.setColumns(10);
		JTF_telefono.setBounds(151, 323, 96, 19);
		frame.getContentPane().add(JTF_telefono);
		
		
		JLB_sistema = new JLabel("");
		JLB_sistema.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLB_sistema.setBounds(10, 373, 583, 27);
		frame.getContentPane().add(JLB_sistema);
		
		
		
		crearbotones();
		
		
		micontro= new ControladorBBDD();
		micontro.crearBBDD();
		
		
		actuaizar();
		micontro.consultaprofe("Profesor");
		miprofe=micontro.siguiente();
		actuaizar();
		
		
	}
	
	/**
	 * comportamiento que añade campos a una tablaa de la bbdd (en este caso a la tabla profesores)
	 * @return
	 */
	public String crear() {
		
		micontro.crear(JTF_IDprofesor.getText(),JTF_NIFprofesor.getText(),JTF_nombreprofesor.getText(),JTF_especialidad.getText(),JTF_telefono.getText());
		return "campo añadido";
 	}
	
	/**
	 * comportamiento para crear botones con sus caciones cuando se hace click en ellos
	 */
	public void crearbotones() {
		
		//boton aceptar
		BTN_aceptar = new JButton("Aceptar");
		BTN_aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLB_sistema.setText(crear());
				BTN_aceptar.setVisible(false);
				BTN_Cancelar.setVisible(false);
				mostrarbotones();
				actuaizar();
	
				micontro.cerrarconexion();
				micontro.consultaprofe("profesor");
			}
		});
		BTN_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BTN_aceptar.setBounds(487, 234, 123, 35);
		frame.getContentPane().add(BTN_aceptar);
		
		
		//boton cancelar
		BTN_Cancelar = new JButton("Cancelar");
		BTN_Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BTN_aceptar.setVisible(false);
				BTN_Cancelar.setVisible(false);
				//btnModificar.setVisible(true);
				mostrarbotones();
				actuaizar();
			}
		});
		BTN_Cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BTN_Cancelar.setBounds(487, 282, 123, 35);
		frame.getContentPane().add(BTN_Cancelar);
		
		
		//boton crear
		BTN_Crear = new JButton("Crear");
		BTN_Crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reset();
				BTN_aceptar.setVisible(true);
				BTN_Cancelar.setVisible(true);
				//btnModificar.setVisible(true);
				ocultarbotones();
				
				
			}
		});
		BTN_Crear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BTN_Crear.setBounds(487, 327, 123, 35);
		frame.getContentPane().add(BTN_Crear);
		
		//boton siguiente
		JBT_siguiente = new JButton("Siguiente");
		JBT_siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miprofe=micontro.siguiente();
				actuaizar();
				JLB_sistema.setText("");
			}
		});
		JBT_siguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBT_siguiente.setBounds(327, 185, 133, 35);
		frame.getContentPane().add(JBT_siguiente);
		
		//boton primero
		JBT_primero = new JButton("Primero");
		JBT_primero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miprofe=micontro.primero();
				actuaizar();
				JLB_sistema.setText("");
			}
		});
		JBT_primero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				micontro.primero();
				actuaizar();
			}
		});
		JBT_primero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBT_primero.setBounds(327, 140, 133, 35);
		frame.getContentPane().add(JBT_primero);
		
		
		//boton ultimo
		JBT_ulltimo = new JButton("Ultimo");
		JBT_ulltimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miprofe=micontro.ultimo();
				actuaizar();
				JLB_sistema.setText("");
			}
		});
		JBT_ulltimo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBT_ulltimo.setBounds(327, 281, 133, 35);
		frame.getContentPane().add(JBT_ulltimo);
		
		//boton modificar
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLB_sistema.setText(modificar());
				micontro.cerrarconexion();
				micontro.consultaprofe("profesor");
				
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(327, 330, 133, 35);
		frame.getContentPane().add(btnModificar);
		
		
		
		
		//boton anterior
		JBT_anterior = new JButton("Anterior");
		JBT_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JBT_anterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miprofe=micontro.anterior();
				actuaizar();
				JLB_sistema.setText("");
			}
		});
		JBT_anterior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBT_anterior.setBounds(327, 234, 133, 35);
		frame.getContentPane().add(JBT_anterior);
		
		
		//eliminar bbdd
		JBT_eliminarbbdd = new JButton("");
		JBT_eliminarbbdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//micontro.borrarBBDD();
				JBT_SIII.setVisible(true);
				JBT_noo.setVisible(true);
				ocultarbotones();
			}
		});
		JBT_eliminarbbdd.setBackground(Color.RED);
		JBT_eliminarbbdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JBT_eliminarbbdd.setForeground(Color.WHITE);
		JBT_eliminarbbdd.setBounds(605, 10, 5, 2);
		frame.getContentPane().add(JBT_eliminarbbdd);
		
		JBT_SIII = new JButton("Me gustan los botones rojos\r\n");
		JBT_SIII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				micontro.borrarBBDD();
				mostrarbotones();
				JBT_SIII.setVisible(false);
				JBT_noo.setVisible(false);
				reset();
				micontro.cerrarconexion();
				JLB_sistema.setText("Has traicionado la fe del comunismo, borrando base datos... borrado completado, a reiniciar");
			}
		});
		JBT_SIII.setBackground(Color.GREEN);
		JBT_SIII.setBounds(204, 108, 205, 21);
		frame.getContentPane().add(JBT_SIII);
		
		JBT_noo = new JButton("Un boton rojo es malo");
		JBT_noo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JBT_SIII.setVisible(false);
				JBT_noo.setVisible(false);
				mostrarbotones();
				JLB_sistema.setText("Bien hecho compañero patriota, comunismo al poder ahora a beber vodka");
			}
		});
		JBT_noo.setForeground(Color.WHITE);
		JBT_noo.setBackground(Color.RED);
		JBT_noo.setBounds(419, 108, 191, 22);
		frame.getContentPane().add(JBT_noo);
		
		
		BTN_aceptar.setVisible(false);
		BTN_Cancelar.setVisible(false);
		JBT_SIII.setVisible(false);
		JBT_noo.setVisible(false);
		
		
	}
	
	/**
	 * comportamiento para ocultar algunos botones
	 */
	public void ocultarbotones() {
		btnModificar.setVisible(false);
		JBT_primero.setVisible(false);
		JBT_ulltimo.setVisible(false);
		JBT_siguiente.setVisible(false);
		JBT_siguiente.setVisible(false);
		BTN_Crear.setVisible(false);
		JBT_anterior.setVisible(false);
		JBT_eliminarbbdd.setVisible(false);
	}
	
	/**
	 * comportamientos para mostrar los botnes ocultos
	 */
	public void mostrarbotones() {
		btnModificar.setVisible(true);
		JBT_primero.setVisible(true);
		JBT_ulltimo.setVisible(true);
		JBT_siguiente.setVisible(true);
		JBT_siguiente.setVisible(true);
		BTN_Crear.setVisible(true);
		JBT_anterior.setVisible(true);
		JBT_eliminarbbdd.setVisible(true);
	}
	
	/**
	 * comportamiento para modificar un registro de la bbdd
	 * @return
	 */
	public String modificar() {
		micontro.modificar("NIF_P","profesor",JTF_NIFprofesor.getText(),"IdProfesor",JTF_IDprofesor.getText());
		micontro.modificar("Nombre","profesor",JTF_nombreprofesor.getText(),"IdProfesor",JTF_IDprofesor.getText());
		micontro.modificar("Especialidad","profesor",JTF_especialidad.getText(),"IdProfesor",JTF_IDprofesor.getText());
		micontro.modificar("Telefono","profesor",JTF_telefono.getText(),"IdProfesor",JTF_IDprofesor.getText());
		//JLB_sistema.setText("");
		
		return "datos modificados de profesor";
 	}
	
	/**
	 * comportamiento que resetea los JTF del Jpanel
	 */
	public void reset() {
		JTF_IDprofesor.setText("");
		JTF_NIFprofesor.setText("");
		JTF_telefono.setText("");
		JTF_especialidad.setText("");
		JTF_nombreprofesor.setText("");
	}
	
	/**
	 * comportamiento que vuelca los datos del objeto profesor en los JTF
	 */
	public void actuaizar() {
		
		
		if (miprofe!=null) {
			
			JTF_IDprofesor.setText(miprofe.getIdprofesor());
			JTF_NIFprofesor.setText(miprofe.getNifP());
			JTF_telefono.setText(miprofe.getTelefono());
			JTF_especialidad.setText(miprofe.getEspecialidad());
			JTF_nombreprofesor.setText(miprofe.getNombre());
			
			}
		
	}
}
