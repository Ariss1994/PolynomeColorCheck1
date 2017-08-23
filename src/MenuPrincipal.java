/**
 *@author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 */
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

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	public MenuPrincipal() {
		setAutoRequestFocus(false);
		setBackground(Color.CYAN);
		setResizable(false);
		setFont(new Font("Algerian", Font.BOLD, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Samsung\\Workspace1\\devoir\\Image\\simple-background.jpg"));
		this.setTitle("Menu Principal");
		this.setSize(477, 435);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(SystemColor.inactiveCaption);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 438,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446,
								Short.MAX_VALUE).addContainerGap()));
		new HashSet<Color>();
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Samsung\\Workspace1\\devoir\\Image\\bienvenue.jpg"));
		label_1.setBounds(97, 85, 284, 175);
		panel.add(label_1);

		JLabel lblElarissAhmad = new JLabel("&& EL-Ariss Ahmad (p1008651)");
		lblElarissAhmad.setHorizontalAlignment(SwingConstants.CENTER);
		lblElarissAhmad.setForeground(Color.YELLOW);
		lblElarissAhmad.setFont(new Font("Andalus", Font.BOLD, 14));
		lblElarissAhmad.setBounds(0, 23, 471, 27);
		panel.add(lblElarissAhmad);

		JLabel lblJeanCharleEmanuel = new JLabel(
				"&& Jean Emmanuel Charles (p1065027)");
		lblJeanCharleEmanuel.setForeground(Color.YELLOW);
		lblJeanCharleEmanuel.setFont(new Font("Andalus", Font.BOLD, 14));
		lblJeanCharleEmanuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblJeanCharleEmanuel.setBounds(0, 47, 471, 27);
		panel.add(lblJeanCharleEmanuel);

		JLabel lblxxddf = new JLabel(
				"R\u00C9ALIS\u00C9 PAR Nezha Chahid (p1060244)");
		lblxxddf.setForeground(Color.YELLOW);
		lblxxddf.setFont(new Font("Andalus", Font.BOLD, 14));
		lblxxddf.setHorizontalAlignment(SwingConstants.CENTER);
		lblxxddf.setBounds(0, 0, 471, 27);
		panel.add(lblxxddf);

		JButton btnNewButton = new JButton("Partie I (Polynome)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(153, 102, 255));
		btnNewButton.setBounds(10, 271, 186, 50);
		panel.add(btnNewButton);

		JButton btnPartieIicheccolor = new JButton("Partie II (ChecColor)");
		btnPartieIicheccolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColorCheck frame1 = new ColorCheck();
				frame1.setVisible(true);
			}
		});
		btnPartieIicheccolor.setForeground(new Color(255, 255, 255));
		btnPartieIicheccolor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPartieIicheccolor.setBackground(new Color(153, 102, 255));
		btnPartieIicheccolor.setBounds(275, 271, 186, 50);
		panel.add(btnPartieIicheccolor);

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setForeground(new Color(255, 255, 255));
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuitter.setBackground(new Color(153, 102, 255));
		btnQuitter.setBounds(149, 345, 186, 50);
		panel.add(btnQuitter);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Samsung\\Workspace1\\devoir\\Image\\backgrounds-computer-images-nice-service-118812.jpg"));
		label.setBounds(0, 0, 471, 406);
		panel.add(label);

		this.setVisible(true);

	}
}
