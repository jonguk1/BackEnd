package notice;
import javax.swing.*;
import java.sql.*;
import java.awt.BorderLayout;
public class Board extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPane;

	public Board(){
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(48, 42, 304, 59);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(48, 122, 304, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 192, 304, 50);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(48, 271, 304, 50);
		panel.add(textField_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 356, 304, 200);
		panel.add(scrollPane);
		
	}
	
	public static void main(String[] args) {

	}
}
