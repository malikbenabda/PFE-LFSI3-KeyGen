package services;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {
	public static void copy_to_clipboard(String source) {
		/* -- get system clipboard */

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		/* -- set clipboard content (string data) */

		StringSelection str = new StringSelection(source);
		clipboard.setContents(str, null);

	}

	public static String get_clipboard_text() {
		String s = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		/* -- get clipboard context */

		Transferable data = clipboard.getContents(null);

		/* -- is context string type ? */

		boolean bIsText = ((data != null) && (data
				.isDataFlavorSupported(DataFlavor.stringFlavor)));

		/* -- if yes, translate context to string type and write it */

		if (bIsText) {

			try {

				s = (String) data.getTransferData(DataFlavor.stringFlavor);

				System.out.println(s);
				return s;

			} catch (UnsupportedFlavorException ex) {
				Logger.getLogger(Window.class.getName()).log(Level.SEVERE,
						null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Window.class.getName()).log(Level.SEVERE,
						null, ex);
			}

		}
		return s;

	}
}
