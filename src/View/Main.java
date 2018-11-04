package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.StateMachine;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtEntrada;
	private JTextField txtSaida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Trabalho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTexto = new JLabel("Insira a String para ser avaliada:");
		lblTexto.setHorizontalAlignment(SwingConstants.LEFT);
		lblTexto.setBounds(10, 11, 158, 14);
		contentPane.add(lblTexto);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(177, 8, 325, 20);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		txtSaida = new JTextField();
		txtSaida.setEditable(false);
		txtSaida.setBounds(10, 39, 492, 163);
		contentPane.add(txtSaida);
		txtSaida.setColumns(10);
		
		JButton btnIniciar = new JButton("Verificar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				StateMachine st = new StateMachine();
				st.setTexto(txtEntrada.getText());
				if(st.MudancaEstado())
				{
					txtSaida.setText("String válida: " + st.getTexto());
				}
				else
				{
					txtSaida.setText("String Inválida: " + st.getTexto());
				}
			}
		});
		btnIniciar.setBounds(413, 213, 89, 23);
		contentPane.add(btnIniciar);
	}
}
