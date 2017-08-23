import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 * @category Classe d'exceptions.
 */
public class PolynomeFormatException extends IOException {

	private static final long serialVersionUID = 1L;

	PolynomeFormatException() {
	}

	PolynomeFormatException(String str) {
		super(str);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame,
				"FICHIER POLYNOME EXCEPTION: DATABASE DOIT CONTENIR AU MOINS UN POLYNOME \n"
						+ str);
	}

}
