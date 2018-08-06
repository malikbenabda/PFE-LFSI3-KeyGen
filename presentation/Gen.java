package presentation;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import services.Serial;
import services.Utility;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Gen extends JInternalFrame {
	
	private JTextField txtcode,txtsn;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Gen() {
		setBounds(100, 100, 500, 355);
		setMinimumSize(getSize());
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 0, 10));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodeClient = new JLabel("Code Client :");
		lblCodeClient.setBounds(20, 34, 75, 45);
		panel_2.add(lblCodeClient);
		
		txtcode = new JTextField();
		txtcode.setHorizontalAlignment(SwingConstants.CENTER);
		txtcode.setBounds(100, 31, 300, 48);
		panel_2.add(txtcode);
		txtcode.setColumns(30);
		
		JButton paste = new JButton("");
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			txtcode.setText(Utility.get_clipboard_text());
			}
		});
		paste.setIcon(new ImageIcon(Gen.class.getResource("/Clipboard Paste.png")));
		paste.setBounds(400, 30, 48, 48);
		panel_2.add(paste);
		
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BorderLayout(40, 30));
		
		JButton btnGenerer = new JButton("Generer");
		btnGenerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String code= txtcode.getText();
			String type="";
			
			txtsn.setText(Serial.md5Java(code+"soufflage"));
			}
		});
		btnGenerer.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		panel.add(btnGenerer, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSnGener = new JLabel("SN :");
		lblSnGener.setBounds(20, 33, 48, 41);
		panel_3.add(lblSnGener);
		
		txtsn = new JTextField("clic sur generer pour creer le SN");
		txtsn.setHorizontalAlignment(SwingConstants.CENTER);
		txtsn.setBounds(100, 30, 300, 48);
		txtsn.setEditable(false);
		panel_3.add(txtsn);
		txtsn.setColumns(40);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Utility.copy_to_clipboard(txtsn.getText());
			}
		});
		button.setIcon(new ImageIcon(Gen.class.getResource("/Clipboard Copy.png")));
		button.setBounds(400, 30, 48, 48);
		panel_3.add(button);

	}

	
	
		
	}

