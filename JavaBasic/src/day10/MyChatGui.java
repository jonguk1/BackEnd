package day10;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyChatGui extends JFrame{
	Container cp;
	private JTextField tf;

	public MyChatGui() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 32, 362, 437);
		panel.add(scrollPane);
		
		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setBorder(new LineBorder(Color.blue));
		
		tf = new JTextField();
		tf.setBounds(12, 490, 362, 62);
		panel.add(tf);
		tf.setColumns(10);
		tf.setBorder(new TitledBorder("message"));
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 22));
		btnNewButton.setBounds(12, 591, 362, 62);
		panel.add(btnNewButton);
		
	}
}
