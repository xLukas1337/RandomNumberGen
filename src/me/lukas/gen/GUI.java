package me.lukas.gen;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class GUI {

	JFrame frame;
	private JTextField textFieldMinNum;
	private JLabel labelMaxNumber;
	private JTextField textFieldMaxNum;
	private JLabel lblGenerated;
	private JLabel labelNumber;
	public JCheckBox floatCheckbox = new JCheckBox("Float?");

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMinNumber = new JLabel("Min. Number:");
		lblMinNumber.setFont(new Font("Comfortaa", Font.BOLD, 15));
		lblMinNumber.setBounds(10, 11, 164, 25);
		frame.getContentPane().add(lblMinNumber);

		textFieldMinNum = new JTextField();
		textFieldMinNum.setBounds(10, 35, 164, 20);
		frame.getContentPane().add(textFieldMinNum);
		textFieldMinNum.setColumns(10);

		labelMaxNumber = new JLabel("Max. Number:");
		labelMaxNumber.setFont(new Font("Comfortaa", Font.BOLD, 15));
		labelMaxNumber.setBounds(10, 66, 164, 25);
		frame.getContentPane().add(labelMaxNumber);

		textFieldMaxNum = new JTextField();
		textFieldMaxNum.setColumns(10);
		textFieldMaxNum.setBounds(10, 90, 164, 20);
		frame.getContentPane().add(textFieldMaxNum);
		floatCheckbox.setFont(new Font("Comfortaa", Font.BOLD, 15));

		floatCheckbox.setBounds(10, 117, 97, 23);
		frame.getContentPane().add(floatCheckbox);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Comfortaa", Font.BOLD, 14));
		btnGenerate.setBounds(10, 147, 164, 23);
		btnGenerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI gui = new GUI();
				if (gui.floatCheckbox.isSelected()) {
					// If it should be a float
					if (Float.isNaN(Float.valueOf(textFieldMinNum.getText()))
							|| Float.isNaN(Float.valueOf(textFieldMaxNum.getText()))) {
						JOptionPane.showMessageDialog(frame, "Min or Max is not a number", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					labelNumber.setText(String.valueOf(Generator.generateFloat(Float.valueOf(textFieldMinNum.getText()),
							Float.valueOf(textFieldMaxNum.getText()))));
				} else {
					if (Float.isNaN(Float.valueOf(textFieldMinNum.getText()))
							|| Float.isNaN(Float.valueOf(textFieldMaxNum.getText()))) {
						JOptionPane.showMessageDialog(frame, "Min or Max is not a number", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					labelNumber.setText(String.valueOf(Generator.generateInt(Integer.parseInt(textFieldMinNum.getText()),
							Integer.parseInt(textFieldMaxNum.getText()))));
				}
			}
		});
		frame.getContentPane().add(btnGenerate);

		lblGenerated = new JLabel("Generated:");
		lblGenerated.setFont(new Font("Comfortaa", Font.BOLD, 15));
		lblGenerated.setBounds(10, 176, 86, 25);
		frame.getContentPane().add(lblGenerated);

		labelNumber = new JLabel("");
		labelNumber.setFont(new Font("Comfortaa", Font.BOLD, 15));
		labelNumber.setBounds(106, 176, 68, 25);
		frame.getContentPane().add(labelNumber);
	}
}
