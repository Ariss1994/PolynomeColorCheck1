import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 */
public class Polynome {

	private LinkedList<Node> LinkedList1 = new LinkedList<Node>();
	private ListIterator<Node> iterator;
	public static ArrayList<Polynome> polynomes = new ArrayList<Polynome>();

	/**
	 * Introduit l'iterateur.
	 */
	public Polynome() {
		this.iterator = LinkedList1.listIterator();
	}

	/**
	 * 
	 * @param LinkedList1
	 */
	public Polynome(LinkedList<Node> LinkedList1) {
		this.LinkedList1 = LinkedList1;
		this.iterator = LinkedList1.listIterator();
	}

	/**
	 * 
	 * @param poly1
	 *            Introduit un iterateur au premier polynome
	 */
	public static void ListPolynome(Polynome poly1) {
		poly1.iterator = poly1.LinkedList1.listIterator();
	}

	/**
	 * 
	 * @return true si iterator.hasNext() est vraie
	 */
	public boolean existAuMoinUn() {
		this.iterator = this.LinkedList1.listIterator();
		if (this.iterator.hasNext())
			return true;
		return false;
	}

	/**
	 * Methode qui ajoute poly1 à poly2.
	 * 
	 * @param poly
	 * @return le resultat.
	 */
	public static Polynome AddList(Polynome poly) {
		Polynome.ListPolynome(poly);
		LinkedList<Node> listpoly = new LinkedList<Node>();

		while (poly.iterator.hasNext()) {
			Node currNode = poly.iterator.next();
			int coeff = currNode.getCoeff();
			int degre = currNode.getDegre();

			Node node = new Node(coeff, degre);
			listpoly.addLast(node);

		}
		Polynome result = new Polynome(listpoly);
		Polynome.ListPolynome(result);
		return result;
	}

	/**
	 * Methode qui lie le coefficient.
	 * 
	 * @param coeff
	 * @return le signeCoeff
	 */
	public String signeCoeffPoly(int coeff) {
		String signeCoeff = "";
		if (coeff < 0) {
			signeCoeff = " - ";
		}

		else
			signeCoeff = " + ";
		return signeCoeff;

	}

	public String toString() {

		Polynome.ListPolynome(this);
		String signeCoeff = "";
		;
		int coeff;
		this.iterator = LinkedList1.listIterator();
		String result = "<html>";

		while (iterator.hasNext()) {
			Node node = iterator.next();
			coeff = node.getCoeff();
			signeCoeff = signeCoeffPoly(coeff);

			result += signeCoeff + node.toString();
		}
		return result + "</html>";
	}

	/**
	 * Methode trouve le degre maximal d'un polynome
	 * 
	 * @param poly1
	 * @param poly2
	 * @return le maxdegreP
	 */
	public static Polynome getMaxDegre(Polynome poly1, Polynome poly2) {
		int poly1MaxDegre = ((Node) poly1.iterator.next()).getDegre();
		int poly2MaxDegre = ((Node) poly2.iterator.next()).getDegre();
		poly2.iterator.previous();
		poly1.iterator.previous();

		Polynome maxdegreP;

		new Polynome();

		if (poly1MaxDegre > poly2MaxDegre) {
			maxdegreP = poly1;
		} else {
			maxdegreP = poly2;
		}
		return maxdegreP;
	}

	/**
	 * Methode trouve le degre minimal d'un polynome
	 * 
	 * @param poly1
	 * @param poly2
	 * @return le mindegreP
	 */
	public static Polynome getMinDegre(Polynome poly1, Polynome poly2) {
		int poly1MaxDegre = ((Node) poly1.iterator.next()).getDegre();
		int poly2MaxDegre = ((Node) poly2.iterator.next()).getDegre();
		poly2.iterator.previous();
		poly1.iterator.previous();

		Polynome mindegreP;
		new Polynome();

		if (poly1MaxDegre < poly2MaxDegre) {
			mindegreP = poly1;
		} else {
			mindegreP = poly2;
		}
		return mindegreP;
	}

	public static boolean memeDegre(Polynome poly1, Polynome poly2) {
		if (((Node) poly1.iterator.next()).getDegre() == ((Node) poly2.iterator
				.next()).getDegre())

		{
			poly1.iterator.previous();
			poly2.iterator.previous();
			return true;
		}
		poly1.iterator.previous();
		poly2.iterator.previous();
		return false;
	}

	/**
	 * Methode qui multiplie deux polynomes
	 * 
	 * @param poly1
	 * @param poly2
	 * @return resultat
	 */
	public static Polynome multiplicationPolynome(Polynome poly1, Polynome poly2) {
		Polynome result = new Polynome();
		Polynome blah = new Polynome();
		Boolean firstPass = true;

		while (poly1.iterator.hasNext()) {
			Node nodePol1 = poly1.iterator.next();

			LinkedList<Node> polyll = new LinkedList<Node>();
			while (poly2.iterator.hasNext()) {
				Node nodePol2 = poly2.iterator.next();
				int coeff = nodePol1.getCoeff() * nodePol2.getCoeff();
				int degre = nodePol1.getDegre() + nodePol2.getDegre();
				Node nodeRes = new Node(coeff, degre);
				polyll.addLast(nodeRes);
			}
			Polynome.ListPolynome(poly2);
			Polynome interm = new Polynome(polyll);
			if (firstPass == true) {
				firstPass = false;
				Polynome.ListPolynome(interm);
				result = Polynome.additionPolynome(blah, interm, blah, false);
			} else if (firstPass == false) {
				Polynome.ListPolynome(interm);
				Polynome.ListPolynome(result);
				result = Polynome.additionPolynome(interm, result, blah, false);
			}
		}
		return result;
	}

	/**
	 * Methode qui calcule la derivée d'un polynome
	 * 
	 * @param poly1
	 * @return resultat
	 */

	public static Polynome derivePolynome(Polynome poly1) {
		Polynome.ListPolynome(poly1);
		LinkedList<Node> derive = new LinkedList<Node>();
		while (poly1.iterator.hasNext()) {
			Node nodePol = poly1.iterator.next();
			int coeff = nodePol.getCoeff();
			int degre = nodePol.getDegre();
			coeff = degre * coeff;
			degre--;
			if (coeff != 0) {
				Node newNode = new Node(coeff, degre);
				derive.addLast(newNode);
			}
		}
		Polynome result = new Polynome(derive);
		return result;
	}

	/**
	 * Methode qui calcule l'addition de deux polynomes
	 * 
	 * @param poly1
	 * @param poly2
	 * @param resultAddPoly
	 * @param boolPoly
	 * @return resultat
	 */
	public static Polynome additionPolynome(Polynome poly1, Polynome poly2,
			Polynome resultAddPoly, boolean boolPoly) {
		Polynome grandP;
		Polynome petitP;

		if (boolPoly == false) {
			resultAddPoly = new Polynome();
			boolPoly = true;
		}

		if (poly1.iterator.hasNext() && poly2.iterator.hasNext()) {
			if (!memeDegre(poly1, poly2)) {
				grandP = getMaxDegre(poly1, poly2);
				petitP = getMinDegre(poly1, poly2);
				resultAddPoly.LinkedList1.addLast(grandP.iterator.next());

				Polynome.additionPolynome(grandP, petitP, resultAddPoly, true);

			} else if (memeDegre(poly1, poly2)) {
				Node poly1Node = ((Node) poly1.iterator.next());
				Node poly2Node = ((Node) poly2.iterator.next());
				int degre = poly1Node.getDegre();
				int coeff = poly1Node.getCoeff() + poly2Node.getCoeff();

				if (coeff != 0) {
					Node newEle = new Node(coeff, degre);
					resultAddPoly.LinkedList1.addLast(newEle);
				}

				Polynome.additionPolynome(poly1, poly2, resultAddPoly, true);
			}
		}

		else if (poly1.iterator.hasNext() || poly2.iterator.hasNext()) {
			if (poly1.iterator.hasNext()) {
				resultAddPoly.LinkedList1.addLast(poly1.iterator.next());
				Polynome.additionPolynome(poly1, poly2, resultAddPoly, true);
			} else if (poly2.iterator.hasNext()) {
				resultAddPoly.LinkedList1.addLast(poly2.iterator.next());
				Polynome.additionPolynome(poly1, poly2, resultAddPoly, true);
			}
		}

		return resultAddPoly;
	}

	/**
	 * Methode qui calcule la soustraction de deux polynomes
	 * @param poly1
	 * @param poly2
	 * @param resultSous
	 * @return resultat
	 */
	public static Polynome soustractionPoly(Polynome poly1, Polynome poly2,
			Polynome resultSous) {
		Polynome.ListPolynome(poly2);

		LinkedList<Node> nouvelleList = new LinkedList<Node>();

		while (poly2.iterator.hasNext()) {
			Node node1 = ((Node) poly2.iterator.next());
			int degre = node1.getDegre();
			int coeff = (node1.getCoeff() * -1);
			Node node = new Node(coeff, degre);
			nouvelleList.addLast(node);
		}
		Polynome negativePoly = new Polynome(nouvelleList);
		Polynome.ListPolynome(negativePoly);

		Polynome subtractionP = Polynome.additionPolynome(poly1, negativePoly,
				resultSous, false);
		return subtractionP;
	}
}
