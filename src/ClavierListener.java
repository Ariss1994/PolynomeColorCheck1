import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 * @category Classe controle de saisie du clavier
 */
class ClavierListener implements KeyListener {
	public JTextField textReplace;
	public int indice;

	public ClavierListener(JTextField text) {
		this.textReplace = text;
	}

	public void keyReleased(KeyEvent event) {
		if (!(((event.getKeyCode() >= 37) && (event.getKeyCode() <= 39))
				|| ((event.getKeyCode() >= 48) && (event.getKeyCode() <= 57)) || ((event
				.getKeyCode() >= 96) && (event.getKeyCode() <= 105)))) {
			textReplace.setText(textReplace.getText().replace(
					String.valueOf(event.getKeyChar()), ""));
		}
	}

	public void keyPressed(KeyEvent event) {
	}

	public void keyTyped(KeyEvent event) {
	}

}
