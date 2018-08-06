package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

import bean.Admin;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import services.Requests;

@SuppressWarnings("serial")
public class Supprimer_admin extends JFrame {

	private JPasswordField textField;
	private JComboBox<String> combobox;
	private Requests req = new Requests() ;
	public Supprimer_admin() {
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
		
		combobox = new JComboBox<String>();
		combobox.setModel(req.getlogins());
		panel.add(combobox);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		panel.add(lblMotDePasse);
		
		textField = new JPasswordField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOk_1 = new JButton("Supprimer");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = combobox.getSelectedItem().toString();
				
				if ( !req.getmdp(login).equals( String.valueOf(textField.getPassword()) )  ) 
						JOptionPane.showMessageDialog(null,"Mot de passe erroné ! ");
				
				else 
				{		Admin a = new Admin(); 
				a.setLogin(login);
				a.setMdp(String.valueOf(textField.getPassword()));
				req.supprimer_admin(a);
				combobox.setModel(req.getlogins());}
					
			}
		});
		panel_2.add(btnOk_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();}
		});
		panel_2.add(btnAnnuler);

	}

}
