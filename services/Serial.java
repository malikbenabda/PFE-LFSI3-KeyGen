package services;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Serial {

	public static String GetMACadress() {
		InetAddress ip = null;
		StringBuilder sb = new StringBuilder();
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NetworkInterface network = null;
		try {
			network = NetworkInterface.getByInetAddress(ip);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] mac = null;
		try {
			mac = network.getHardwareAddress();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ""
					: ""));
		}

		String s = sb.toString();

		return (s);
	}

	// hashage MD5Java depuis :
	// http://javarevisited.blogspot.com/2013/03/generate-md5-hash-in-java-string-byte-array-example-tutorial.html
	// created by " Javin Paul "

	public static String md5Java(String message) {
		String digest = null;

		// converting byte array to Hexadecimal String
		StringBuilder sb = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8"));

			sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		digest = sb.toString();

		return digest;
	}
}

// methode de generation de SN :
// -get @MAC append it to String nom de Simulateur : String result=
// "@mac"+"type" ;
// - hash the result with MD5Java : md5Java(result)
// give it to user ;
// apres l'installation , une fenetre de loading apparait ,
// si le SN est déja entré dans la DB alors on donne acces au Simulateur
// "Welcome"
// else un frame qui fournis l'@mac' dans un champs et demande le SN dans un
// autre va apparaitre
// si verification valide on le logicielle sera fermé et l'utilisateur et invité
// à le reouvrir et l'utiliser