
/**
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 */
public class Node {

	private int coeff;
	private int degre;

	/**
	 * 
	 * @param coeff
	 * @param degre
	 *            Le construcetur par parametres dans lequel on fait appel aux
	 *            setteurs pour initialiser quelques attributs de la classe
	 *            Node.
	 */
	public Node(int coeff, int degre) {
		this.coeff = coeff;
		this.degre = degre;
	}

	/**
	 * Methode qui affiche le coeff en valeur absolue dans le cas ou il est
	 * negatif.
	 */
	public String toString() {
		if (this.degre > 1) {
			return Math.abs(coeff) + "x" + "<sup>" + degre + "</sup>";
		}
		if (this.degre == 1) {
			return Math.abs(coeff) + "x";
		} else
			return Math.abs(degre) + "";
	}

	/**
	 * 
	 * @return le coeff
	 */
	public int getCoeff() {
		return this.coeff;
	}

	/**
	 * 
	 * @return le degre
	 */
	public int getDegre() {
		return this.degre;

	}
}
