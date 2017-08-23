import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 * 
 */
public class RunProgramme {

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws PolynomeFormatException
	 * 
	 *             Methode qui lit le contenu du fichier.
	 */

	public static void LectureFichier() throws NumberFormatException,
			IOException, PolynomeFormatException {
		String file = System.getProperty("user.dir");
		file += "\\poly.txt";
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try {
			boolean valid = true;
			String line = "";
			Polynome poly;
			while (valid == true) {
				line = br.readLine();
				System.out.println("line: " + line);

				if (line.equals("end")) {
					// System.out.println("here");
					valid = false;
					fr.close();
				} else if (line.equals("")) {
					throw new PolynomeFormatException("le fichier est vide");
				}

				if (!line.equals("end")) {
					poly = processLine(line);
					Polynome.polynomes.add(poly);
				}
			}
		} finally {
			fr.close();

		}
	}

	/**
	 * 
	 * @param input
	 *            Methode qui decompose la ligne du fichier.
	 * @return les elements de chaque ligne.
	 */
	public static String[] breakIntoParts(String input) {
		String[] result = input.split("\\s(?=\\()|(?<=\\))\\s");
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i].trim();
		}
		return result;
	}

	public static int trouverUnRempli(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ',') {
				result = i;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param str
	 *            Methode qui verifie si le fichier contient une virgule.
	 * @return result
	 */
	public static Boolean commaValid(String str) {
		boolean result = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ',') {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Methode qui prend les coefficients.
	 * 
	 * @param str
	 * @return
	 * @throws NumberFormatException
	 * @throws PolynomeFormatException
	 */
	public static int extraireCoeff(String str) throws NumberFormatException,
			PolynomeFormatException {
		int endIndex = trouverUnRempli(str);
		if (1 > endIndex)
			throw new PolynomeFormatException(
					"Erreur dans le format dans le fichier des polynomes!");
		String newStr = str.substring(1, endIndex);
		int result = Integer.parseInt(newStr);
		return result;
	}

	/**
	 * Methode qui prend les degres.
	 * 
	 * @param str
	 * @return
	 * @throws NumberFormatException
	 * @throws PolynomeFormatException
	 */
	public static int extraireDegre(String str) throws NumberFormatException,
			PolynomeFormatException {
		String newStr = str.substring(trouverUnRempli(str) + 2,
				(str.length() - 1));
		int result = Integer.parseInt(newStr);
		if (result < 0)
			throw new PolynomeFormatException(
					"le fichier ne doit pas contenir un degre négatif ! "
							+ result);

		return result;
	}

	public static Polynome processLine(String str)
			throws NumberFormatException, PolynomeFormatException {
		String[] brokenUp = breakIntoParts(str);
		int coeff = 0;
		int degre = 0;
		LinkedList<Node> link = new LinkedList<Node>();
		for (int i = 0; i < brokenUp.length; i++) {
			if (commaValid(str)) {
				coeff = extraireCoeff(brokenUp[i]);
				degre = extraireDegre(brokenUp[i]);
				Node node = new Node(coeff, degre);
				link.addLast(node);
			}
		}
		Polynome poly = new Polynome(link);
		return poly;

	}

	public static void main(String[] args) {
		try {
			RunProgramme.LectureFichier();
		} catch (NumberFormatException e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "FORMAT EXCEPTION");
		} catch (PolynomeFormatException e) {
		} catch (IOException e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "IO EXCEPTION");
		}

		if (Polynome.polynomes.size() > 0) {
			MenuPrincipal frame = new MenuPrincipal();
			frame.setVisible(true);
		} else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
					"ERREUR DE LECTURE DES DONNEES.");
			System.exit(1);
		}
	}

}
