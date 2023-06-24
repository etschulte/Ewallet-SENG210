import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class frameWindow extends JFrame implements ActionListener{

	//Global variables, to work with action listener
private static JButton addIncome = new JButton();	
private static JButton addExpense = new JButton();	
private static JButton viewSummary = new JButton();	
private static JButton currencyConv = new JButton();
private static JButton homeButton = new JButton();
private static JTextField convertText = new JTextField();
private static JButton convertButton = new JButton();
private static JComboBox currSelectOne;
private static JComboBox currSelectTwo;
private static JLabel currResultLabel;
private static JButton expenseHomeButton = new JButton();
private static JComboBox expenseSelectOne;
private static JButton expenseSubmitButton = new JButton();
private static JComboBox expenseSelectTwo;
private static JComboBox expenseSelectThree;
private static JComboBox expenseSelectFour;
private static JComboBox expenseSelectFive;
private static JLabel expenseAddtionalLabel = new JLabel();
private static JLabel expenseFrequencyLabel = new JLabel();
private static JLabel expenseCategoryLabel = new JLabel();
private static JComboBox expenseSelectSix;
private static JLabel expenseAmountLabel = new JLabel();
private static JTextField expenseAmountText = new JTextField();
private static JButton addtionalInfoSubmitButton = new JButton();


private static JPanel expensePanel;
private static JPanel conPanel;
private static JPanel startPanel;

	frameWindow() {
		

//start panel
startPanel = new JPanel();
startPanel.setBackground(Color.black);
startPanel.setBounds(0, 0, 455, 600);
startPanel.setLayout(null);
startPanel.setVisible(true);
//Start Page Labels			
		
JLabel titleLabel = new JLabel();
titleLabel.setText("E-Wallet");
titleLabel.setBounds(165, 30, 150, 25);
titleLabel.setFont(new Font("Arial", Font.PLAIN, 25));
titleLabel.setForeground(Color.white);
titleLabel.setVisible(true);

JLabel chooseLabel = new JLabel();
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
homeButton.setVisible(true);


JLabel convertLabel = new JLabel();
convertLabel.setText("Please enter your balance to convert");
convertLabel.setBounds(85, 350, 600, 25);
convertLabel.setFont(new Font("Arial", Font.PLAIN, 17));
convertLabel.setForeground(Color.white);
convertLabel.setVisible(true);

JLabel convertToLabel = new JLabel();
convertToLabel.setText("To");
convertToLabel.setBounds(275, 390, 20, 25);
convertToLabel.setFont(new Font("Arial", Font.PLAIN, 17));
convertToLabel.setForeground(Color.white);
convertToLabel.setVisible(true);

currResultLabel = new JLabel();
currResultLabel.setText("");
currResultLabel.setBounds(175, 470, 200, 25);
currResultLabel.setFont(new Font("Arial", Font.PLAIN, 17));
currResultLabel.setForeground(Color.white);
currResultLabel.setVisible(true);


convertText.setPreferredSize(new Dimension(20, 30));
convertText.setCaretColor(Color.black); //cursor color
convertText.setText("100.00"); //starting text
convertText.setEditable(true);
convertText.setBounds(185, 390, 80, 25);
convertText.setVisible(true);

String[] currencyList = {"USD", "EUR", "CAD",};
currSelectOne = new JComboBox(currencyList);
currSelectOne.setBounds(115, 390, 60, 25);
currSelectOne.setVisible(true);


currSelectTwo = new JComboBox(currencyList);
currSelectTwo.setBounds(305, 390, 60, 25);
currSelectTwo.setVisible(true);
currSelectTwo.setSelectedIndex(1); 

convertButton = new JButton("Convert!");
convertButton.setBounds(175, 430, 100, 30);
convertButton.setFocusable(false);
convertButton.addActionListener(this);
convertButton.setVisible(true);


conPanel = new JPanel();
conPanel.setBackground(Color.black);
conPanel.setBounds(0, 0, 455, 600);
conPanel.setLayout(null);
conPanel.setVisible(false);

//ADD EXPENSE WINDOW ////////////////////////
expensePanel = new JPanel();
expensePanel.setBackground(Color.black);
expensePanel.setBounds(0, 0, 455, 600);
expensePanel.setLayout(null);
expensePanel.setVisible(false);

expenseHomeButton = new JButton("Home");
expenseHomeButton.setBounds(170, 30, 120, 70);
expenseHomeButton.setFocusable(false);
expenseHomeButton.addActionListener(this);
expenseHomeButton.setVisible(true);

JLabel expenseLabel = new JLabel();
expenseLabel.setText("Please Enter the Type of Expense");
expenseLabel.setBounds(100, 250, 600, 25);
expenseLabel.setFont(new Font("Arial", Font.PLAIN, 17));
expenseLabel.setForeground(Color.white);
expenseLabel.setVisible(true);

String[] expenseList = {"Transportation", "Bills", "Recreational","Grocery" };
expenseSelectOne = new JComboBox(expenseList);
expenseSelectOne.setBounds(90, 290, 150, 35);
expenseSelectOne.setVisible(true);
expenseSelectOne.setSelectedIndex(0); 

String[] expenseList2 = {"Gas", "Maintenance" };
expenseSelectTwo = new JComboBox(expenseList2);
expenseSelectTwo.setBounds(190, 400, 140, 30);
expenseSelectTwo.setVisible(false);
expenseSelectTwo.setSelectedIndex(0); 

String[] expenseList3 = {"Rent", "Electricity" };
expenseSelectThree = new JComboBox(expenseList3);
expenseSelectThree.setBounds(190, 400, 140, 30);
expenseSelectThree.setVisible(false);
expenseSelectThree.setSelectedIndex(0); 

String[] expenseList4 = {"Entertainment", "Shopping" };
expenseSelectFour = new JComboBox(expenseList4);
expenseSelectFour.setBounds(190, 400, 140, 30);
expenseSelectFour.setVisible(false);
expenseSelectFour.setSelectedIndex(0); 

String[] expenseList5 = {"Produce", "Meat" };
expenseSelectFive = new JComboBox(expenseList5);
expenseSelectFive.setBounds(190, 400, 140, 30);
expenseSelectFive.setVisible(false);
expenseSelectFive.setSelectedIndex(0); 

expenseFrequencyLabel.setBounds(100, 440, 600, 25);
expenseFrequencyLabel.setFont(new Font("Arial", Font.PLAIN, 17));
expenseFrequencyLabel.setForeground(Color.white);
expenseFrequencyLabel.setVisible(true);

//combo box for the frequency of when the expense occurs
String[] expenseList6 = {"Annually", "Monthy", "Biweekly"};
expenseSelectSix = new JComboBox(expenseList6);
expenseSelectSix.setBounds(190, 440, 140, 30);
expenseSelectSix.setVisible(false);
expenseSelectSix.setSelectedIndex(0); 

expenseAddtionalLabel.setBounds(120, 350, 600, 25);
expenseAddtionalLabel.setFont(new Font("Arial", Font.PLAIN, 17));
expenseAddtionalLabel.setForeground(Color.white);
expenseAddtionalLabel.setVisible(true);

expenseAmountLabel.setBounds(100, 480, 600, 25);
expenseAmountLabel.setFont(new Font("Arial", Font.PLAIN, 17));
expenseAmountLabel.setForeground(Color.white);
expenseAmountLabel.setVisible(true);

expenseCategoryLabel.setBounds(100, 400, 600, 25);
expenseCategoryLabel.setFont(new Font("Arial", Font.PLAIN, 17));
expenseCategoryLabel.setForeground(Color.white);
expenseCategoryLabel.setVisible(true);

expenseAmountText.setPreferredSize(new Dimension(20, 30));
expenseAmountText.setCaretColor(Color.black); //cursor color
expenseAmountText.setEditable(true);
expenseAmountText.setBounds(190, 480, 136, 25);
expenseAmountText.setVisible(false);

//submit button for type of expense 
expenseSubmitButton = new JButton("Submit!");
expenseSubmitButton.setBounds(270, 290, 100, 30);
expenseSubmitButton.setFocusable(false);
expenseSubmitButton.addActionListener(this);
expenseSubmitButton.setVisible(true);

addtionalInfoSubmitButton = new JButton("Submit!");
addtionalInfoSubmitButton.setBounds(200, 520, 100, 30);
addtionalInfoSubmitButton.setFocusable(false);
addtionalInfoSubmitButton.addActionListener(this);
addtionalInfoSubmitButton.setVisible(false);
////////////////////////////////////////////////////////

//add to window
this.add(startPanel);
this.add(conPanel);
this.add(expensePanel);

expensePanel.add(expenseHomeButton);
expensePanel.add(expenseLabel);
expensePanel.add(expenseSelectOne);
expensePanel.add(expenseSubmitButton);
expensePanel.add(expenseSelectTwo);
expensePanel.add(expenseSelectThree);
expensePanel.add(expenseSelectFour);
expensePanel.add(expenseSelectFive);
expensePanel.add(expenseAddtionalLabel);
expensePanel.add(expenseFrequencyLabel);
expensePanel.add(expenseCategoryLabel);
expensePanel.add(expenseSelectSix);
expensePanel.add(expenseAmountLabel);
expensePanel.add(expenseAmountText);
expensePanel.add(addtionalInfoSubmitButton);

conPanel.add(convertButton);
conPanel.add(currSelectOne);
conPanel.add(convertText);
conPanel.add(convertLabel);
conPanel.add(convertToLabel);
conPanel.add(currSelectTwo);
conPanel.add(currResultLabel);
conPanel.add(homeButton);
startPanel.add(viewSummary);
startPanel.add(currencyConv);
startPanel.add(addExpense);
startPanel.add(addIncome);
startPanel.add(titleLabel);
startPanel.add(chooseLabel);







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
		if (e.getSource() == addExpense) {
			try {
				expenseWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == expenseSubmitButton) {
			Object selectedExpense = expenseSelectOne.getSelectedItem();
			String expenseOne = selectedExpense.toString();
	
			if(expenseOne.equals("Transportation")) {
				expenseSelectTwo.setVisible(true);
				
				expenseAddtionalLabel.setText("Enter Additional Information");
				expenseAddtionalLabel.setVisible(true);
				
				expenseFrequencyLabel.setText("Frequency:");
				expenseFrequencyLabel.setVisible(true);
				
				expenseCategoryLabel.setText("Category:");
				expenseCategoryLabel.setVisible(true);
				
				expenseAmountLabel.setText("Amount:");
				expenseAmountLabel.setVisible(true);

				expenseSelectSix.setVisible(true);
				
				expenseAmountText.setVisible(true);
				
				addtionalInfoSubmitButton.setVisible(true);
				

				
			}
			else if(expenseOne.equals("Bills")) {
				expenseSelectThree.setVisible(true);
				
				expenseAddtionalLabel.setText("Enter Additional Information");
				expenseAddtionalLabel.setVisible(true);
				
				expenseFrequencyLabel.setText("Frequency:");
				expenseFrequencyLabel.setVisible(true);
				
				expenseCategoryLabel.setText("Category:");
				expenseCategoryLabel.setVisible(true);
				
				expenseAmountLabel.setText("Amount:");
				expenseAmountLabel.setVisible(true);
				
				expenseSelectSix.setVisible(true);
				
				expenseAmountText.setVisible(true);
				
				addtionalInfoSubmitButton.setVisible(true);
				
			}
			else if(expenseOne.equals("Recreational")) {
				expenseSelectFour.setVisible(true);
				
				expenseAddtionalLabel.setText("Enter Additional Information");
				expenseAddtionalLabel.setVisible(true);
				
				expenseFrequencyLabel.setText("Frequency:");
				expenseFrequencyLabel.setVisible(true);
				
				expenseCategoryLabel.setText("Category:");
				expenseCategoryLabel.setVisible(true);
				
				expenseAmountLabel.setText("Amount:");
				expenseAmountLabel.setVisible(true);
				
				expenseSelectSix.setVisible(true);
				
				expenseAmountText.setVisible(true);
				
				addtionalInfoSubmitButton.setVisible(true);
			
			}
			else if(expenseOne.equals("Grocery")) {
				expenseSelectFive.setVisible(true);
				
				expenseAddtionalLabel.setText("Enter Additional Information");
				expenseAddtionalLabel.setVisible(true);
				
				expenseFrequencyLabel.setText("Frequency:");
				expenseFrequencyLabel.setVisible(true);
				
				expenseCategoryLabel.setText("Category:");
				expenseCategoryLabel.setVisible(true);
				
				expenseAmountLabel.setText("Amount:");
				expenseAmountLabel.setVisible(true);
				
				expenseSelectSix.setVisible(true);
				
				expenseAmountText.setVisible(true);
				
				addtionalInfoSubmitButton.setVisible(true);
			
			}
		}
		
		if(e.getSource()== addtionalInfoSubmitButton) { 
			 String selectedExpenseOne = expenseSelectOne.getSelectedItem().toString();
		      String selectedExpenseTwo = "";
		      String selectedFrequency = expenseSelectSix.getSelectedItem().toString(); 
		      
		      if (selectedExpenseOne.equals("Transportation")) {
		            selectedExpenseTwo = expenseSelectTwo.getSelectedItem().toString();
		        } else if (selectedExpenseOne.equals("Bills")) {
		            selectedExpenseTwo = expenseSelectThree.getSelectedItem().toString();
		        } else if (selectedExpenseOne.equals("Recreational")) {
		            selectedExpenseTwo = expenseSelectFour.getSelectedItem().toString();
		        } else if (selectedExpenseOne.equals("Grocery")) {
		            selectedExpenseTwo = expenseSelectFive.getSelectedItem().toString();
		        }
		      double amount = Double.parseDouble(expenseAmountText.getText());
		      
		      Expenser.addExpense(selectedExpenseOne, selectedExpenseTwo, amount, selectedFrequency);
		      
		      JOptionPane.showMessageDialog(null, "Expense added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		      expenseAmountText.setText("");
		      expenseSelectOne.setSelectedIndex(0);
		      expenseSelectTwo.setSelectedIndex(0);
		      expenseSelectThree.setSelectedIndex(0);
		      expenseSelectFour.setSelectedIndex(0);
		      expenseSelectFive.setSelectedIndex(0);
		      expenseSelectSix.setSelectedIndex(0);
		      
		      // Hide additional components
		      expenseSelectTwo.setVisible(false);
		      expenseSelectThree.setVisible(false);
		      expenseSelectFour.setVisible(false);
		      expenseSelectFive.setVisible(false);
		      expenseSelectSix.setVisible(false);
		      expenseAmountText.setVisible(false);
		      addtionalInfoSubmitButton.setVisible(false);
		      expenseAmountLabel.setVisible(false);
		      expenseCategoryLabel.setVisible(false);
		      expenseFrequencyLabel.setVisible(false);
		      expenseAddtionalLabel.setVisible(false);
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
		if(e.getSource()==convertButton) { //converts currency
			
			Object selectedConversionOne = currSelectOne.getSelectedItem(); //getting the selected option
			String currOne = selectedConversionOne.toString(); //converting to a string to pass variable
			Object selectedConversionTwo = currSelectTwo.getSelectedItem();
			String currTwo = selectedConversionTwo.toString();
			
			String ammountToConvert = convertText.getText();
			double convertAmmount = Double.parseDouble(ammountToConvert);
			double converResults = Expenser.convertForeignCurrency(currOne, currTwo, convertAmmount);
			currResultLabel.setText(currTwo + ": " + converResults);
			currResultLabel.setVisible(true);
			
			}
		if(e.getSource()==homeButton) { //resets to home screen
				try {
					screenReset();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		if(e.getSource()==expenseHomeButton) { //resets to home screen
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
		startPanel.setVisible(true);
		conPanel.setVisible(false);
		expensePanel.setVisible(false);
	}
	
	public static void convertWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		conPanel.setVisible(true);
		
		
	}
	
	public static void expenseWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		expensePanel.setVisible(true);
		
		
	}
}

