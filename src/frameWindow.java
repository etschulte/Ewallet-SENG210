import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class frameWindow extends JFrame implements ActionListener{

	//Global variables, to work with action listener
private static JButton addIncome = new JButton();	
private static JButton addExpense = new JButton();	
private static JButton viewSummary = new JButton();	
private static JButton currencyConv = new JButton();
private static JButton homeButton = new JButton();
private static JLabel titleLabel;
private static JLabel chooseLabel;
private static JLabel convertLabel;
	
//window	
	frameWindow() {
		
	
//Start Page Labels	
titleLabel = new JLabel();
titleLabel.setText("E-Wallet");
titleLabel.setBounds(165, 30, 150, 25);
titleLabel.setFont(new Font("Arial", Font.PLAIN, 25));
titleLabel.setForeground(Color.white);
titleLabel.setVisible(true);

chooseLabel = new JLabel();
chooseLabel.setText("What would you like to do?");
chooseLabel.setBounds(65, 250, 400, 25);
chooseLabel.setFont(new Font("Arial", Font.PLAIN, 25));
chooseLabel.setForeground(Color.white);
chooseLabel.setVisible(true);
		
//Start Page Buttons
addIncome = new JButton("Add an income");
addIncome.setBounds(30, 330, 165, 70);
addIncome.setFocusable(false);
addIncome.addActionListener(this);
addIncome.setVisible(true);

addExpense = new JButton("Add an expense");
addExpense.setBounds(250, 330, 165, 70);
addExpense.setFocusable(false);
addExpense.addActionListener(this);
addExpense.setVisible(true);

viewSummary = new JButton("View a Summary");
viewSummary.setBounds(30, 450, 165, 70);
viewSummary.setFocusable(false);
viewSummary.addActionListener(this);
viewSummary.setVisible(true);

currencyConv = new JButton("Currency Conversion");
currencyConv.setBounds(250, 450, 165, 70);
currencyConv.setFocusable(false);
currencyConv.addActionListener(this);
currencyConv.setVisible(true);











//currency Conversion window

//you can re-use the home button for other screens as long as you don't move it, if you want to move it, copy, rename, and change the position.
homeButton = new JButton("Home");
homeButton.setBounds(170, 30, 120, 70);
homeButton.setFocusable(false);
homeButton.addActionListener(this);
homeButton.setVisible(false);


convertLabel = new JLabel();
convertLabel.setText("Please enter your balance to convert");
convertLabel.setBounds(85, 350, 600, 25);
convertLabel.setFont(new Font("Arial", Font.PLAIN, 17));
convertLabel.setForeground(Color.white);
convertLabel.setVisible(false);



//add to window
this.add(convertLabel);
this.add(viewSummary);
this.add(currencyConv);
this.add(addExpense);
this.add(addIncome);
this.add(titleLabel);
this.add(chooseLabel);
this.add(homeButton);

//define start window
this.setSize(455, 600); 
this.setTitle("E-Wallet"); 
this.setLayout(new BorderLayout(10, 10));
this.setResizable(false); 
this.getContentPane().setBackground(Color.black);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
this.setVisible(true);
	
	
	}
	

	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//Controls the buttons when pressed
		if(e.getSource()==addExpense) { 
		System.out.println("you hit the expense button");
		}
		if(e.getSource()==addIncome) { 
			System.out.println("you hit the income button");
			}
		if(e.getSource()==currencyConv) { 
			System.out.println("you hit the currency button");
			try {
				convertWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		if(e.getSource()==viewSummary) { 
			System.out.println("you hit the summary button");
			}
		if(e.getSource()==homeButton) { 
				try {
					screenReset();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	
	
	
	//function to reset screen to base window, anytime you add a button on another window, set it to false here so when we add a back to home button, it makes it invisible.
	public static void screenReset() throws IOException {
		viewSummary.setVisible(true);
		currencyConv.setVisible(true);
		addExpense.setVisible(true);
		addIncome.setVisible(true);
		titleLabel.setVisible(true);
		chooseLabel.setVisible(true);
		homeButton.setVisible(false);
		convertLabel.setVisible(false);
	}
	
	public static void convertWindow() throws IOException {
		//hiding original screen
		viewSummary.setVisible(false);
		currencyConv.setVisible(false);
		addExpense.setVisible(false);
		addIncome.setVisible(false);
		titleLabel.setVisible(false);
		chooseLabel.setVisible(false);

		//making conversion screen
		convertLabel.setVisible(true);
		homeButton.setVisible(true);
	}
}

