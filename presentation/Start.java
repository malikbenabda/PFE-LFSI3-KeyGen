package presentation;

import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.EventQueue;

import persistance.AccesBD;
import services.Requests;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Start extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JComboBox<String> comboBox ;
	private Requests req = new Requests() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
					UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "static-access", "static-access" })
	public Start() {
		setTitle("Login Generateur SN Extrusion Soufflage");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==e.VK_ESCAPE)
				exit();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("login");
		panel.add(lblNewLabel);
		
		 comboBox = new JComboBox<String>();
		
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("mot de passe");
		panel.add(lblNewLabel_1);
		
		
		
		
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = comboBox.getSelectedItem().toString();
				System.out.println(req.getmdp(login));
			if ( !req.getmdp(login).equals(  String.valueOf(passwordField.getPassword())   )    ) 
					JOptionPane.showMessageDialog(null,"Mot de passe erroné ! ");
				else {
					acces(); dispose();
				}
			}
		});
		panel_1.add(btnOk);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			exit();}
		});
		panel_1.add(btnQuitter);
		AccesBD ac = new AccesBD();
		ac.MAJ("CREATE  TABLE  IF NOT EXISTS 'admins' ( 'login' VARCHAR PRIMARY KEY  NOT NULL  UNIQUE , 'mdp' VARCHAR NOT NULL )");
		try {
			if ( !ac.getStatment("select * from 'admins'").next()  ){
				ac.MAJ("insert into admins values('root','12345')");
				ac.disconnect();}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.setModel(req.getlogins());
		ac.disconnect();
	}
	public void acces(){
		Acceuil A = new Acceuil();
		
	}

	public void exit(){
	 int rep=JOptionPane.showConfirmDialog(null, "confirmer quiter ? ");
	if (rep== JOptionPane.YES_OPTION) dispose();
	}



}
