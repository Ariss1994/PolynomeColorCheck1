/**
 @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author CHAHID NEZHA p1060244
 * @version 1.0
 * @since 16 Avril 2014
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ColorCheck extends JFrame {

	private JPanel container = new JPanel();
	private JTextField RedField;
	private JTextField GreenField;
	private JTextField BlueField;
	private JTextField CheckColor;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JButton btnMenu;

	public ColorCheck() {
		setResizable(false);
		setFont(new Font("Algerian", Font.PLAIN, 16));
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"C:\\Users\\Samsung\\Workspace1\\videoclub7\\videoclub7\\Image\\simple-background.jpg"));
		this.setTitle("ColorChecker Interface");
		this.setSize(477, 486);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE));
		final Set<Color> couleurs1 = new HashSet<Color>();
		final JButton btnCheckcolor = new JButton("Check Color");
		btnCheckcolor.setForeground(new Color(153, 0, 0));
		btnCheckcolor.setFont(new Font("Harrington", Font.BOLD, 17));
		btnCheckcolor.setBounds(10, 396, 135, 36);
		btnCheckcolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnCheckcolor) {
					System.out.println("RedField.getText() "
							+ RedField.getText().isEmpty());

					if (RedField.getText().isEmpty() == false
							&& GreenField.getText().isEmpty() == false
							&& BlueField.getText().isEmpty() == false) {
						System.out.println("RedField.getText() "
								+ RedField.getText());
						if (Integer.parseInt(RedField.getText()) <= 255
								&& Integer.parseInt(RedField.getText()) >= 0
								&& Integer.parseInt(GreenField.getText()) <= 255
								&& Integer.parseInt(GreenField.getText()) >= 0
								&& Integer.parseInt(BlueField.getText()) <= 255
								&& Integer.parseInt(BlueField.getText()) >= 0) {

							Color A = new Color(Integer.parseInt(RedField
									.getText()), Integer.parseInt(GreenField
									.getText()), Integer.parseInt(BlueField
									.getText()));
							couleurs1.add(Color.BLACK);
							couleurs1.add(Color.BLUE);
							couleurs1.add(Color.CYAN);
							couleurs1.add(Color.DARK_GRAY);
							couleurs1.add(Color.GRAY);
							couleurs1.add(Color.GREEN);
							couleurs1.add(Color.LIGHT_GRAY);
							couleurs1.add(Color.MAGENTA);
							couleurs1.add(Color.ORANGE);
							couleurs1.add(Color.PINK);
							couleurs1.add(Color.RED);
							couleurs1.add(Color.WHITE);
							couleurs1.add(Color.YELLOW);

							if (couleurs1.contains(A)) {
								if (A.equals(Color.BLACK))
									CheckColor.setText("BLACK");
								else if (A.equals(Color.BLUE))
									CheckColor.setText("BLUE");
								else if (A.equals(Color.RED))
									CheckColor.setText("RED");
								else if (A.equals(Color.YELLOW))
									CheckColor.setText("YELLOW");
								else if (A.equals(Color.CYAN))
									CheckColor.setText("CYAN");
								else if (A.equals(Color.DARK_GRAY))
									CheckColor.setText("DARK GRAY");
								else if (A.equals(Color.GRAY))
									CheckColor.setText("GRAY");
								else if (A.equals(Color.GREEN))
									CheckColor.setText("GREEN");
								else if (A.equals(Color.LIGHT_GRAY))
									CheckColor.setText("LIGHT GRAY");
								else if (A.equals(Color.MAGENTA))
									CheckColor.setText("MAGENTA");
								else if (A.equals(Color.ORANGE))
									CheckColor.setText("ORANGE");
								else if (A.equals(Color.PINK))
									CheckColor.setText("PINK");
								else if (A.equals(Color.WHITE))
									CheckColor.setText("WHITE");

							}
						} else
							CheckColor.setText("La couleur n'existe pas.");

					}
				}

			}
		});

		RedField = new JTextField();
		RedField.setBounds(102, 35, 106, 30);
		RedField.setFont(new Font("Old English Text MT", Font.BOLD, 15));
		RedField.setForeground(SystemColor.desktop);
		RedField.setHorizontalAlignment(SwingConstants.CENTER);
		RedField.setBackground(Color.RED);
		RedField.setColumns(10);

		GreenField = new JTextField();
		GreenField.setBounds(102, 163, 106, 31);
		GreenField.setFont(new Font("Old English Text MT", Font.BOLD, 15));
		GreenField.setForeground(Color.BLACK);
		GreenField.setHorizontalAlignment(SwingConstants.CENTER);
		GreenField.setBackground(Color.GREEN);
		GreenField.setColumns(10);

		BlueField = new JTextField();
		BlueField.setBounds(102, 297, 106, 30);
		BlueField.setFont(new Font("Old English Text MT", Font.BOLD, 15));
		BlueField.setForeground(Color.WHITE);
		BlueField.setHorizontalAlignment(SwingConstants.CENTER);
		BlueField.setBackground(Color.BLUE);
		BlueField.setColumns(10);

		CheckColor = new JTextField();
		CheckColor.setEditable(false);
		CheckColor.setForeground(new Color(102, 0, 204));
		CheckColor.setFont(new Font("Monotype Corsiva", Font.BOLD, 19));
		CheckColor.setHorizontalAlignment(SwingConstants.CENTER);
		CheckColor.setBounds(155, 398, 189, 33);
		CheckColor.setColumns(10);

		txtRed = new JTextField();
		txtRed.setBounds(10, 30, 86, 39);
		txtRed.setForeground(Color.RED);
		txtRed.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		txtRed.setHorizontalAlignment(SwingConstants.CENTER);
		txtRed.setText("Red");
		txtRed.setEditable(false);
		txtRed.setColumns(10);

		txtGreen = new JTextField();
		txtGreen.setBounds(10, 157, 86, 42);
		txtGreen.setForeground(Color.GREEN);
		txtGreen.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		txtGreen.setHorizontalAlignment(SwingConstants.CENTER);
		txtGreen.setText("Green");
		txtGreen.setEditable(false);
		txtGreen.setColumns(10);

		txtBlue = new JTextField();
		txtBlue.setBounds(10, 292, 86, 39);
		txtBlue.setForeground(Color.BLUE);
		txtBlue.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		txtBlue.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlue.setText("Blue");
		txtBlue.setEditable(false);
		txtBlue.setColumns(10);
		panel.setLayout(null);

		btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 13));
		btnMenu.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					hide();
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}
		});
		btnMenu.setBounds(389, 423, 72, 23);
		panel.add(btnMenu);

		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBackground(new Color(102, 255, 153));
		table.setForeground(new Color(204, 51, 51));
		table.setFont(new Font("Charlemagne Std", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "COULEURS", "R,G,B" }, { null, null }, { "BLACK", "0,0,0" },
				{ "WHITE", "255,255,255" }, { "RED", "255,0,0" },
				{ "BLUE", "0,0,255" }, { "YELLOW", "255,255,0" },
				{ "CYAN", "0,255,255" }, { "MAGENTA", "255,0,255" },
				{ "GREEN", "0,255,0" }, { "ORANGE", "255,200,0" },
				{ "GRAY", "128,128,128" }, { "LIGHT GRAY", "192,192,192" },
				{ "DARK GRAY", "64,64,64" }, { "PINK", "255,175,175" }, },
				new String[] { "Couleurs", "R,G,B" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(241, 86, 220, 224);
		panel.add(table);
		panel.add(btnCheckcolor);
		panel.add(CheckColor);
		panel.add(txtGreen);
		panel.add(GreenField);
		panel.add(txtRed);
		panel.add(RedField);
		panel.add(txtBlue);
		panel.add(BlueField);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\Samsung\\Workspace1\\devoir\\Image\\wallpaper-surprising-nice-background-wallpaper-hd-wallpapers.jpg"));
		lblNewLabel_1.setBounds(0, 0, 475, 457);
		panel.add(lblNewLabel_1);
		getContentPane().setLayout(groupLayout);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		RedField.addKeyListener(new ClavierListener(RedField));
		GreenField.addKeyListener(new ClavierListener(GreenField));
		BlueField.addKeyListener(new ClavierListener(BlueField));

		this.setVisible(true);

	}
}
