package PWGenerator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class pwGenerator {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JCheckBox lowercase_CB;
	private JCheckBox uppercase_CB;
	private JSpinner pwLength;
	private JCheckBox numbers_CB;
	private JCheckBox specchar_CB;
	
	private String pwFinal;
	String pwPlacement = "";
	private JTextField pwTxt;

	String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String low = "abcdefghijklmnopqrstuvwxyz";
	String num = "0123456789";
	String specialChar = "!@#$%^&*()_+{}:<>?";
	
	
	String [] pwFinalRandom;

	//String [] whichField = {"upperCase", "numbers"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pwGenerator window = new pwGenerator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pwGenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		uppercase_CB = new JCheckBox("");
		uppercase_CB.setBackground(Color.DARK_GRAY);
		uppercase_CB.setBounds(277, 110, 18, 18);
		frame.getContentPane().add(uppercase_CB);
		
		JButton generate_BTN = new JButton("Generate");
		generate_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//lblNewLabel_1.setText("AYO");
				Random randNum = new Random();
				Random randLetter = new Random();
				Random randOption = new Random();
				pwTxt.setText("");
				
				int length = (Integer) pwLength.getValue();
				pwFinalRandom = new String[length];
				int spinnerValue = (Integer) pwLength.getValue();
				
				if (spinnerValue == 0)
				{
					JOptionPane.showMessageDialog(null, "Password length must not be 0");
					
				}
	
				if ((lowercase_CB.isSelected() == false)&&(uppercase_CB.isSelected() == false)&&(numbers_CB.isSelected() == false) &&(specchar_CB.isSelected() == false))
				{
					JOptionPane.showMessageDialog(null, "Please Select at least one Check box.");
				}
				
				for (int i = 0; i < length; i++)
				{
					pwPlacement += getString(randNum.nextInt(4));
				}

				pwTxt.setText(pwPlacement);
				pwPlacement = "";
				//testing
				
				StringSelection stringSelection = new StringSelection(pwTxt.getText());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			
			}
		});
		generate_BTN.setForeground(Color.WHITE);
		generate_BTN.setBackground(Color.BLACK);
		generate_BTN.setBounds(173, 506, 89, 23);
		frame.getContentPane().add(generate_BTN);
		
		JLabel lblNewLabel = new JLabel("SST Password-Generator 28 ");
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 28));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(50, 11, 349, 67);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Include Uppercase Letters");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(82, 110, 180, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lowercase_CB = new JCheckBox("", true);
		lowercase_CB.setBackground(Color.DARK_GRAY);
		lowercase_CB.setBounds(277, 149, 18, 18);
		frame.getContentPane().add(lowercase_CB);
		
		JLabel lblIncludLowercaseLetters = new JLabel("Include Lowercase Letters");
		lblIncludLowercaseLetters.setForeground(Color.WHITE);
		lblIncludLowercaseLetters.setBounds(82, 149, 180, 14);
		frame.getContentPane().add(lblIncludLowercaseLetters);
		
		pwTxt = new JTextField();
		pwTxt.setHorizontalAlignment(SwingConstants.CENTER);
		pwTxt.setBounds(31, 457, 368, 38);
		frame.getContentPane().add(pwTxt);
		pwTxt.setColumns(10);
		
		pwLength = new JSpinner();
		pwLength.setBounds(276, 76, 30, 20);
		frame.getContentPane().add(pwLength);
		
		JLabel lblPasswordLength = new JLabel("Password Length");
		lblPasswordLength.setForeground(Color.WHITE);
		lblPasswordLength.setBounds(82, 76, 180, 14);
		frame.getContentPane().add(lblPasswordLength);
		
		JLabel lblIncludeNumbers = new JLabel("Include Numbers");
		lblIncludeNumbers.setForeground(Color.WHITE);
		lblIncludeNumbers.setBounds(82, 190, 180, 14);
		frame.getContentPane().add(lblIncludeNumbers);
		
		JLabel lblIncludeSpeicalCharacters = new JLabel("Include Special Characters");
		lblIncludeSpeicalCharacters.setForeground(Color.WHITE);
		lblIncludeSpeicalCharacters.setBounds(82, 234, 180, 14);
		frame.getContentPane().add(lblIncludeSpeicalCharacters);
		
		numbers_CB = new JCheckBox("");
		numbers_CB.setBackground(Color.DARK_GRAY);
		numbers_CB.setBounds(277, 186, 18, 18);
		frame.getContentPane().add(numbers_CB);
		
		specchar_CB = new JCheckBox("");
		specchar_CB.setBackground(Color.DARK_GRAY);
		specchar_CB.setBounds(277, 230, 18, 18);
		frame.getContentPane().add(specchar_CB);
		
		JLabel lblClickText = new JLabel("Text will be copied to Clipboard on Generate");
		lblClickText.setForeground(Color.WHITE);
		lblClickText.setBounds(115, 421, 284, 14);
		frame.getContentPane().add(lblClickText);
		
		
		//test
		//change
	}
	
	public String getString(int a)
	{
		Random randLetter = new Random();
		Random rands = new Random();
		Random randNumber = new Random();
		Random randChar = new Random();
		if ((a == 0) && (lowercase_CB.isSelected())) {
			return Character.toString((char) (randLetter.nextInt(26) + 'a'));
		}if ((a == 1) && (uppercase_CB.isSelected())) {
			return (Character.toString((char) (randLetter.nextInt(26) + 'a'))).toUpperCase();
		}if ((a == 2) && (numbers_CB.isSelected())) {
			return Integer.toString(randNumber.nextInt(9));
		}if ((a==3) && (specchar_CB.isSelected())) {	
			return Character.toString(specialChar.charAt(randChar.nextInt(17)));
		}
		
		return getString(rands.nextInt(3));
	}

	public String getPwFinal() {
		
		return pwFinal;
	}

	public void setPwFinal(String pwFinal) {
		this.pwFinal = pwFinal;
	}
}
