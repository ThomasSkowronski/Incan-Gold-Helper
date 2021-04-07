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
	
	private JButton gemButton;
	private JButton spiButton;
	private JButton rocButton;
	private JButton snaButton;
	private JButton mumButton;
	private JButton firButton;
	private JButton artButton;
	private JButton steButton;
	private JButton escButton;

	private JLabel labelFailRate;
	private JPanel panelTop;
	private JPanel panelMid;
	private JPanel panelBot;
	private JLabel welcomeTxt;
	private JLabel history;

	
	IncanGoldHelper obj = new IncanGoldHelper();
	
	
	public GUI () {
		
		frame = new JFrame();
		
		spiButton = new JButton("Spider");
		spiButton.addActionListener(this);
		
		rocButton = new JButton("Rocks");
		rocButton.addActionListener(this);
		
		snaButton = new JButton("Snake");
		snaButton.addActionListener(this);
		
		mumButton = new JButton("Mummy");
		mumButton.addActionListener(this);
		
		firButton = new JButton("Fire");
		firButton.addActionListener(this);
		
		gemButton = new JButton("Gems");
		gemButton.addActionListener(this);
		
		artButton = new JButton("Artifact");
		artButton.addActionListener(this);
		
		steButton = new JButton("Steal");
		steButton.addActionListener(this);
		
		escButton = new JButton("Escape");
		escButton.addActionListener(this);
		
		labelFailRate = new JLabel();
		labelFailRate.setHorizontalAlignment(0);
		
		welcomeTxt = new JLabel();
		history = new JLabel();
		
		panelTop = new JPanel();
		panelTop.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
		panelTop.setLayout(new GridLayout(2, 0));
		
		panelTop.add(welcomeTxt);
		welcomeTxt.setText
			("<html>Welcome to the Incan Gold Helper!<br>Use the buttons below to select which card was drawn in each round.<br>If the artifact is stolen click 'Steal'.<br>If every player leaves before a second hazard is drawn, click 'Escape'</html>");
		
		panelTop.add(history);

		panelMid = new JPanel();
		panelMid.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelMid.setLayout(new GridLayout(2, 0));
		
		panelMid.add(gemButton);
		panelMid.add(spiButton);
		panelMid.add(rocButton);
		panelMid.add(snaButton);
		panelMid.add(mumButton);
		panelMid.add(firButton);
		panelMid.add(artButton);
		panelMid.add(steButton);
		panelMid.add(escButton);
		
		panelBot = new JPanel();
		panelBot.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
		panelBot.setLayout(new GridLayout(2, 0));
		
		panelBot.add(labelFailRate);
		
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelMid, BorderLayout.CENTER);
		frame.add(panelBot, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1));
		frame.setTitle("Incan Gold Helper");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		labelFailRate.setText(obj.newRound(e));
		history.setText(obj.history(e));
	}
}
