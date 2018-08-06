package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Admin;


import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import persistance.AccesBD;
import services.Requests;

public class Ajouter_admin extends JFrame {
	private JPasswordField textField,textField2;
	private JTextField combobox;
	private Requests rq;
	private Admin admin;
	public Ajouter_admin() {
		setBounds(100, 100, 450, 300);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnOk = new JButton("OK");
		panel_1.add(btnOk);
		
		JButton btnQuitter = new JButton("Quitter");
		panel_1.add(btnQuitter);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblLogin = new JLabel("Login");
		panel.add(lblLogin);
		
		combobox = new JTextField();
		panel.add(combobox);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		panel.add(lblMotDePasse);
		
		textField = new JPasswordField();
		textField2 = new JPasswordField();
		panel.add(textField);
		panel.add(new JLabel("confirmer mot de passe"));
		panel.add(textField2);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOk_1 = new JButton("Ajouter");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 3 test d'entrée sur la longeur de login et mdp et sa confirmation !!
				//longeur de chaqun 4 char minimum
				if (combobox.getText().length()<4) 
					JOptionPane.showMessageDialog(null,"longeur minimale de login est 4 caracteres");
				else
					if (textField.getPassword().length<4)
						JOptionPane.showMessageDialog(null,"longeur minimale de mot de passe est 4 caracteres");
					else
						if ( !String.valueOf(textField.getPassword()).equals(String.valueOf(textField2.getPassword()) )  )
							JOptionPane.showMessageDialog(null,"verifier la confirmation de mot de passe"+String.valueOf(textField.getPassword()));
						else
							{rq = new Requests();
							admin=new Admin();
							admin.setLogin(combobox.getText());
							admin.setMdp(String.valueOf(textField.getPassword()));
							rq.ajouter(admin);
							JOptionPane.showMessageDialog(null, "administrateur "+admin.getLogin()+" ajouté avec succés");
							}
							dispose();
			}
		});
		panel_2.add(btnOk_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		panel_2.add(btnAnnuler);

	}

}
