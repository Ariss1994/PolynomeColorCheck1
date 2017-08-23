/**
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel container = new JPanel();

	public MainFrame() {
		setAutoRequestFocus(false);
		setBackground(Color.CYAN);
		setResizable(false);
		setFont(new Font("Algerian", Font.BOLD, 16));
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"C:\\Users\\Samsung\\Workspace1\\videoclub7\\videoclub7\\Image\\simple-background.jpg"));
		this.setTitle("Calcul des Polynomes");
		this.setSize(477, 438);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setForeground(Color.CYAN);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE));
		new HashSet<Color>();
		panel.setLayout(null);

		JButton btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 13));
		btnMenu.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				try {
					hide();
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMenu.setBounds(384, 381, 76, 23);
		panel.add(btnMenu);

		final JComboBox<String> Poly1 = new JComboBox<String>();
		Poly1.setBackground(UIManager.getColor("Button.background"));
		Poly1.setBounds(240, 11, 220, 30);
		panel.add(Poly1);

		JLabel lblPoly1 = new JLabel("Choisir le 1er polynome :");
		lblPoly1.setForeground(new Color(255, 255, 0));
		lblPoly1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblPoly1.setBounds(20, 13, 200, 23);
		panel.add(lblPoly1);

		final JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setBackground(new Color(51, 255, 255));
		lblResultat.setForeground(new Color(255, 255, 0));
		lblResultat.setFont(new Font("Broadway", Font.BOLD, 17));
		lblResultat.setBounds(20, 146, 387, 20);
		panel.add(lblResultat);

		final JComboBox<String> Poly2 = new JComboBox<String>();
		Poly2.setBackground(UIManager.getColor("Button.background"));
		Poly2.setBounds(240, 59, 220, 30);
		panel.add(Poly2);

		JLabel lbPoly2 = new JLabel("Choisir le 2eme polynome :");
		lbPoly2.setForeground(new Color(255, 255, 0));
		lbPoly2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lbPoly2.setBounds(20, 55, 200, 35);
		panel.add(lbPoly2);

		for (int i = 0; i < Polynome.polynomes.size(); i++) {
			Poly1.addItem(Polynome.polynomes.get(i).toString());
			Poly2.addItem(Polynome.polynomes.get(i).toString());
		}
		JPanel panelOp = new JPanel();
		panelOp.setBackground(new Color(153, 0, 255));
		panelOp.setBounds(10, 100, 450, 35);
		panel.add(panelOp);
		getContentPane().setLayout(groupLayout);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		final JLabel Resultat = new JLabel("");
		Resultat.setForeground(Color.CYAN);
		Resultat.setVerticalAlignment(SwingConstants.TOP);
		Resultat.setBackground(Color.DARK_GRAY);
		Resultat.setFont(new Font("Harrington", Font.BOLD, 20));
		Resultat.setBounds(20, 177, 440, 193);
		panel.add(Resultat);
		JButton BoutonAdd = new JButton("ADDITION");
		BoutonAdd.setBackground(Color.WHITE);
		BoutonAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		BoutonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Polynome P1;
				Polynome P2;

				Polynome Blank = new Polynome();

				P1 = Polynome.AddList(Polynome.polynomes.get(Poly1
						.getSelectedIndex()));
				P2 = Polynome.AddList(Polynome.polynomes.get(Poly2
						.getSelectedIndex()));

				Polynome.ListPolynome(P1);
				Polynome.ListPolynome(P2);
				lblResultat.setText("La somme est :");

				Resultat.setText(Polynome.additionPolynome(P1, P2, Blank, true)
						.toString());

			}
		});
		panelOp.add(BoutonAdd);

		JButton btnSoustraction = new JButton("SOUSTRACTION");
		btnSoustraction.setBackground(Color.WHITE);
		btnSoustraction.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSoustraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Polynome P1;
				Polynome P2;

				Polynome Blank = new Polynome();

				P1 = Polynome.AddList(Polynome.polynomes.get(Poly1
						.getSelectedIndex()));
				P2 = Polynome.AddList(Polynome.polynomes.get(Poly2
						.getSelectedIndex()));

				Polynome.ListPolynome(P1);
				Polynome.ListPolynome(P2);

				Polynome polyR = Polynome.soustractionPoly(P1, P2, Blank);
				Polynome.ListPolynome(polyR);

				lblResultat.setText("La soustraction est :");

				if (!polyR.existAuMoinUn()) {
					Resultat.setText("0");
				} else {
					Resultat.setText(polyR.toString());
				}
			}
		});

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelOp.add(tabbedPane);
		panelOp.add(btnSoustraction);

		JButton btnDerivee = new JButton("MULTIPLICATION");
		btnDerivee.setBackground(Color.WHITE);
		btnDerivee.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDerivee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Polynome P1;
				Polynome P2;

				P1 = Polynome.AddList(Polynome.polynomes.get(Poly1
						.getSelectedIndex()));
				P2 = Polynome.AddList(Polynome.polynomes.get(Poly2
						.getSelectedIndex()));

				Polynome.ListPolynome(P1);
				Polynome.ListPolynome(P2);

				lblResultat.setText("La multiplication est :");

				Resultat.setText(Polynome.multiplicationPolynome(P1, P2)
						.toString());
			}
		});
		panelOp.add(btnDerivee);

		JButton btnDerive = new JButton("DERIVE");
		btnDerive.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynome P1;

				P1 = Polynome.AddList(Polynome.polynomes.get(Poly1
						.getSelectedIndex()));
				Polynome.AddList(Polynome.polynomes.get(Poly1
						.getSelectedIndex()));

				Polynome.ListPolynome(P1);

				lblResultat.setText("La derivé du 1er polynome est :");

				Resultat.setText(Polynome.derivePolynome(P1).toString());
				String Resultat1 = Polynome.derivePolynome(P1).toString();
				Resultat.setText(Resultat1);

			}
		});
		btnDerive.setBackground(Color.WHITE);
		btnDerive.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelOp.add(btnDerive);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Samsung\\Workspace1\\devoir\\Image\\Nice-Abstract-Background.jpg"));
		label.setBounds(0, 0, 471, 409);
		panel.add(label);

		JLabel lblResultat1 = new JLabel("");
		lblResultat1.setForeground(Color.YELLOW);
		lblResultat1.setFont(new Font("Broadway", Font.BOLD, 17));
		lblResultat1.setBackground(new Color(51, 255, 255));
		lblResultat1.setBounds(20, 223, 387, 20);
		panel.add(lblResultat1);

		this.setVisible(true);

	}
}
