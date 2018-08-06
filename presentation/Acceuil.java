package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import persistance.AccesBD;
import services.Requests;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Acceuil extends JFrame {

	private JPanel contentPane;
	
	//ceci est l'interface d'acceuil apres l'authentification de l'administrateur et qu'il soit accepté !! 
	 

	public Acceuil() {
		setTitle("G\u00E9nerateur SN Extrusion Soufflage"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 374);
		setVisible(false);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGestionDadministrateurs = new JMenu("Gestion d'administrateurs");
		menuBar.add(mnGestionDadministrateurs);
		
		JMenuItem mntmAjouter = new JMenuItem("ajouter");
		mntmAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajouter_admin ajoute= new Ajouter_admin();
			
				ajoute.setVisible(true);
			
			}
		});
		mnGestionDadministrateurs.add(mntmAjouter);
		
		JMenuItem mntmSupprimer = new JMenuItem("supprimer");
		mntmSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supprimer_admin supprimer= new Supprimer_admin();
				
					supprimer.setVisible(true);
				
			}
		});
		mnGestionDadministrateurs.add(mntmSupprimer);
		
		JMenuItem mntmChangerMotDe = new JMenuItem("changer mot de passe");
		mnGestionDadministrateurs.add(mntmChangerMotDe);
		mntmChangerMotDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Changer_mdp changer= new Changer_mdp();
			
				changer.setVisible(true);
				
			}
		});
		Gen gen= new Gen();
		contentPane.add(gen, BorderLayout.CENTER);
		gen.setVisible(true);
		setVisible(true);
	
	}
 
	
	
	
	
}
