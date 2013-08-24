import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainGui {
	
	JFrame mainFrame;
	JTextField[] arrayOfChoices;
	Dice dice;
	Label outputText;
	MyDrawPanel outputImage;
	
	public static void main(String[] args) {
		new MainGui().go();
	}
	
	public void go() {
		
		mainFrame = new JFrame("Dice Man Game");
		JPanel leftPanel = new JPanel();
		arrayOfChoices = new JTextField[6];
		dice = new Dice();
		outputImage = new MyDrawPanel();
		outputText = new Label();
		
		outputText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		outputText.setAlignment(Label.CENTER);
		Font commonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);	
		
		//Create the top panel which contains the title and description
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel heading = new JLabel("Dice Game");
		heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		JLabel desc = new JLabel("Make 6 choices then roll the dice.");
		desc.setFont(commonFont);
		topPanel.add(heading);
		topPanel.add(desc);
		
		//Create the text field box area using a for loop.
		JPanel textFieldWrapper = new JPanel(new GridLayout(0, 2));
		textFieldWrapper.setBorder(new EmptyBorder(10, 10, 10, 10));
		for(int i = 0; i < arrayOfChoices.length; i++) {
			arrayOfChoices[i] = new JTextField(8);
			arrayOfChoices[i].setFont(commonFont);
			textFieldWrapper.add(new Label("Choice " + (i + 1) + ":")).setFont(commonFont);
			textFieldWrapper.add(arrayOfChoices[i]);
		}
		
		//Create the button area
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JButton rollButton = new JButton("Roll the dice!");
		rollButton.setFont(commonFont);
		rollButton.addActionListener(new RollButtonListener());
		bottomPanel.add(rollButton);
		
		//Create the output area
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.PAGE_AXIS));
		outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		outputPanel.add(outputImage);
		outputPanel.add(outputText);	
		
		//Add the text field area to the main panel
		//leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
		leftPanel.add(textFieldWrapper);
		leftPanel.add(outputPanel);
		
		//Add the Components to the frame
		Container pane = mainFrame.getContentPane();
		pane.add(BorderLayout.NORTH, topPanel);
		pane.add(BorderLayout.WEST, leftPanel);
		pane.add(BorderLayout.SOUTH, bottomPanel);
		//pane.add(BorderLayout.EAST, outputPanel);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600, 500);
		mainFrame.setVisible(true);
	}// end go
	
	class RollButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			dice.rollDice();
			String selectionText = arrayOfChoices[(dice.getCurrentNumber() - 1)].getText();
			outputText.setText(selectionText);
			outputImage.repaint();
		}
	}
	
	
	//Create a class which will be used to display the output depending on what number the dice is.
	class MyDrawPanel extends JPanel {
		
		public Dimension getPreferredSize() {
			return new Dimension(150, 150);
		}
		
		public Dimension getMinimumSize() {
			return getPreferredSize();
		}
		
		public Dimension getMaximumSize() {
			return getPreferredSize();
		}
		
		public void paintComponent(Graphics g) {
			
			int width = this.getWidth();
			int height = this.getHeight();
			
			//Clear the panel
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			//Draw the rectangle shape of the dice
			g.setColor(Color.cyan);
			//g.fillRect(25, 25, this.getWidth() - 50, this.getHeight() - 50);
			g.fillRoundRect(10, 10, (this.getWidth() - 20), (this.getHeight() - 20), 10, 10);
			g.setColor(Color.black);
			
			//Determine what number the dice has landed on then draw the dice image accordingly.
			switch(dice.getCurrentNumber()) {

				case(2):
					for(int i = 0; i < 2; i++) {
						g.fillOval(25 + (75 * i), 25 + (75 * i), 25, 25);
					}
					break;
					
				case(3):
					g.fillOval(width/2 - 10, height/2 - 10, 25, 25);
					for(int i = 0; i < 2; i++) {
						g.fillOval(25 + (75 * i), 25 + (75 * i), 25, 25);
					}
					break;
					
				case(4):
					for(int i = 0; i < 2; i++) {
						g.fillOval(25 + (75 * i), 25, 25, 25);
						g.fillOval(25 + (75 * i), 100, 25, 25);
					}
					break;
					
				case(5):
					g.fillOval(width/2 - 10, height/2 - 10, 25, 25);
					for(int i = 0; i < 2; i++) {
						g.fillOval(25 + (75 * i), 25, 25, 25);
						g.fillOval(25 + (75 * i), 100, 25, 25);
					}
					break;
					
				case(6):
					for(int i = 0; i < 3; i++) {
							g.fillOval(25 + (i * 40), 25, 25, 25);
							g.fillOval(25 + (i * 40), 100, 25, 25);
					}
					break;
				
				default:
					g.fillOval(width/2 - 10, height/2 - 10, 25, 25);
					break;
			}
		} //end paintComponent
	} //end MyDrawPanel
	
} //end MainGui
