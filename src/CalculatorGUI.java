import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class CalculatorGUI {
	final int WEST = 0,
			  EQUAL = 10,
			  MINUS = 11,
			  PLUS = 12,
			  PROD = 13,
			  DIV = 14,
			  CLEAR = 15,
			  POT = 16,
			  BACK = 17,
			  PAREN_ESQ = 18,
			  PAREN_DIR = 19,
			  DOT = 20,
			  END = 21;
			
	JButton[] buttons = new JButton[END + 1];
	JFrame frame;
	JTextPane text_Area;
	JPanel west_Panel,
		   east_Panel,
		   center_Panel;
	
	CalculatorEngine calculatorEngine;
	
	final int F_HEIGHT = 300,
			  F_WIDTH = 300;

	final int B_HEIGHT = 30,
			  B_WIDTH = 30;
	
	public CalculatorGUI () {
		calculatorEngine = new CalculatorEngine();
	
		frame = new JFrame();
		
		// West Panel
		west_Panel = new JPanel();
		west_Panel.setLayout(new BoxLayout(west_Panel, BoxLayout.Y_AXIS));
		west_Panel.setBackground(Color.WHITE);
		
		frame.getContentPane().add(BorderLayout.WEST, west_Panel);
		
		// East Panel
		east_Panel = new JPanel();
		east_Panel.setLayout(new BoxLayout(east_Panel, BoxLayout.Y_AXIS));
		east_Panel.setBackground(Color.WHITE);
		
		frame.getContentPane().add(BorderLayout.EAST, east_Panel);
				
		// Center Panel
		center_Panel = new JPanel();
		center_Panel.setLayout(new BoxLayout(center_Panel, BoxLayout.Y_AXIS));
		center_Panel.setBackground(Color.WHITE);
		
		frame.getContentPane().add(BorderLayout.CENTER, center_Panel);
		
		// Top Text Area
		text_Area = new JTextPane();
		frame.getContentPane().add(BorderLayout.NORTH, text_Area);
	}
	
	public void Run() {
		// Buttons
		for(int i = 0; i < END; i++) {
			if (i < 10) {
				buttons[i] = new JButton(Integer.toString(i));
				buttons[i].setSize(B_WIDTH, B_HEIGHT);
				buttons[i].addActionListener(new ButtomListener(Integer.toString(i)));
				if (i == 0)
					west_Panel.add(buttons[i], BorderLayout.SOUTH);
				else if (i < 4)
					west_Panel.add(buttons[i], BorderLayout.EAST);
				else if (i < 7)
					west_Panel.add(buttons[i], BorderLayout.CENTER);
				else
					west_Panel.add(buttons[i], BorderLayout.WEST);
			}
			else {
				switch (i) {
				case EQUAL:
					buttons[i] = new JButton("=");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("="));
					east_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case MINUS:
					buttons[i] = new JButton("-");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("-"));
					east_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case PLUS:
					buttons[i] = new JButton("+");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("+"));
					east_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case PROD:
					buttons[i] = new JButton("*");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("*"));
					east_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case DIV:
					buttons[i] = new JButton("/");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("/"));
					center_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case CLEAR:
					buttons[i] = new JButton("CE");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("CE"));
					center_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case POT:
					buttons[i] = new JButton("^");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("^"));
					center_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				/*case BACK:
					buttons[i] = new JButton("<-");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("<-"));
					center_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				case PAREN_ESQ:
					buttons[i] = new JButton("(");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("("));
					break;
				case PAREN_DIR:
					buttons[i] = new JButton(")");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener(")"));
					break;*/
				case DOT:
					buttons[i] = new JButton(".");
					buttons[i].setSize(B_WIDTH, B_HEIGHT);
					buttons[i].addActionListener(new ButtomListener("."));
					center_Panel.add(buttons[i], BorderLayout.WEST);
					break;
				default:
					break;
				}
			}
		}
		
		frame.setVisible(true); frame.setSize(F_WIDTH, F_HEIGHT);
		text_Area.setEditable(false);
	}
	
	class ButtomListener implements ActionListener {
		String value;
		
		public ButtomListener (String value) {
			super();
			
			this.value = value;
		}
		
		public void actionPerformed (ActionEvent event) {
			calculatorEngine.digit(value);
			
			text_Area.setEditable(true);
			text_Area.setText(calculatorEngine.getExpression());
			text_Area.setEditable(false);
		}
	}
}
