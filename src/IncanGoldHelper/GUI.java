package IncanGoldHelper;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	
	private JFrame frame;
	
	private JButton spiButton;
	private JButton rocButton;
	//private JButton spiButton;
	//private JButton spiButton;
	//private JButton spiButton;
	//private JButton spiButton;
	//private JButton spiButton;

	private JLabel label;
	private JPanel panel;
	
	IncanGoldHelper obj = new IncanGoldHelper();
	
	
	public GUI () {
		frame = new JFrame();
		
		spiButton = new JButton("Spider");
		spiButton.addActionListener(this);
		
		rocButton = new JButton("Rocks");
		rocButton.addActionListener(this);
		
		label = new JLabel();
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(1, 0));
		
		panel.add(spiButton);
		panel.add(rocButton);
		
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Incan Gold Helper");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText(obj.newRound(e));
	}
}
