package presentation;

import java.awt.BorderLayout;

import javax.swing.JPanel;







import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bean.Admin;
import persistance.AccesBD;
import services.Requests;
@SuppressWarnings("serial")
public class Changer_mdp extends JFrame {
	private JComboBox<String> combobox;
	private JPasswordField textField,textField2;
	Requests req;
	
	public Changer_mdp() {
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
		req= new Requests();
		panel.add(combobox);
		combobox.setModel(req.getlogins()); 
		//remplisage de combobox d'une liste de logins depuis la db
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		panel.add(lblMotDePasse);
		
		textField = new JPasswordField();
		textField2 = new JPasswordField();
		panel.add(textField);
		panel.add(new JLabel("nouveau mot de passe"));
		panel.add(textField2);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOk_1 = new JButton("Changer mot de passe");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = combobox.getSelectedItem().toString();
				req= new Requests();
				if ( !req.getmdp(login).equals( ( String.valueOf(textField.getPassword()) )  )    ) 
				JOptionPane.showMessageDialog(null,"Mot de passe erroné ! ");
			else 
				if ( textField2.getPassword().length<4)
					JOptionPane.showMessageDialog(null,"longeur minimale de mot de passe est 4 caracteres");
				else {
					Admin a = new Admin();
					a.setLogin(login);a.setMdp( String.valueOf(textField2.getPassword()) );
							req.changer_mdp(a);
							System.out.println("changemenrr dans changer_mdp valide");
				dispose();	}
			}
		});
		panel_2.add(btnOk_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_2.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

}
