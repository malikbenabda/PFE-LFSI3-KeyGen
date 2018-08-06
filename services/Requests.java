package services;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import persistance.AccesBD;
import bean.Admin;

public class Requests {
AccesBD ac ;
public void ajouter(Admin a) { // on prend un bean admin et on le met dans
									// la BD si'il existe pas
		String sql = "INSERT INTO 'admins' VALUES ('" + a.getLogin() + "', '"
				+ a.getMdp() + "')";
		 ac=new AccesBD();
		try {
			if ( !ac.getStatment("select login from admins where (login='" + a.getLogin()+ "')" ).next() )
				//test if selection is null -- ce admin existe pas dans la db
				ac.MAJ(sql);
			else
				JOptionPane.showMessageDialog(null,
						"l'administrateur " + a.getLogin() + " existe deja");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ac.disconnect();	
	}

	public void supprimer_admin(Admin a) {
		String sql = "DELETE FROM admins WHERE (login='" + a.getLogin()
				+ "')";

		 ac=new AccesBD();
		 ac.MAJ(sql);
		 ac.disconnect();
	}

	public Admin get_admin(String login) { // retoure l'objet admin recherché
											// depuis son login
		
		String sql = "select * from admins where login = '"+login+"'";
		Admin a = new Admin();
		a = null;
		ac=new AccesBD();
		try {
			ResultSet rst = ac.getStatment(sql);
			a.setLogin(rst.getString("login"));
			a.setMdp(rst.getString("mdp"));
			ac.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}

	public String getmdp ( String login){
		String s ="";
		ac=new AccesBD();
		ResultSet rs = ac.getStatment("select mdp from admins where login='"+login+"'");
		try {
			s= rs.getString		("mdp");
			ac.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return s;
	
	}
	
	
	
	public void changer_mdp(Admin a) {
		supprimer_admin(a);
		ajouter(a);
		System.out.println("changement done");
	}

	@SuppressWarnings("null")
	public DefaultComboBoxModel<String> getlogins() { // retourne un model de combobox pour liste d'admins logins des admins
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		ac=new AccesBD();
		ResultSet rez =ac.getStatment("select login from admins");
	
		try {
			while (rez.next()) {
				model.addElement( rez.getString("login") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ac.disconnect();
		return model;}

}
