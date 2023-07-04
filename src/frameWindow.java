import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;




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

//Save for item
private static JLabel saveResLabel;
private static JTextField saveAmountText;
private static JButton itemSave;
private static JButton savePanelHomeButton = new JButton();
private static JButton savePanelSubmit = new JButton();

// add expense
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

//For the report expense function 
private static JPanel fullExpenseOverviewPanel;
private static JTextArea expenseDetailsTextArea = new JTextArea();
private static JButton fullExpenseReportsButton = new JButton();
private static JButton fullExpenseHomeButton = new JButton();
private static JLabel expenseOverviewLabel = new JLabel();

//Save for item
private static JPanel savePanel;
//Summary view menu 
private static JPanel summaryOverviewPanel;
private static JButton summaryHomeButton = new JButton();

//For the expense report by type function 
private static JButton expenseByTypeButton = new JButton();
private static JPanel expenseTypeOverviewPanel;
private static JButton typeExpenseHomeButton = new JButton();
private static JTextArea expenseTypeDetailsTextArea = new JTextArea();
private static JLabel expenseTypeLabel = new JLabel();
private static JLabel expenseTypeOverviewLabel = new JLabel();
private static JComboBox expenseSortItems;
private static JButton sortTypeSubmitButton = new JButton();

//income 
private static JLabel incomeLabel;
private static JTextField incomeText = new JTextField();
private static JComboBox incomeType;
//private static JComboBox incomemonth;
//private static JTextField incomeyear = new JTextField();
//private static JLabel moneylabel;
private static JLabel inlabel;
private static JButton enterIncome = new JButton();
private static JButton incomeHomeButton = new JButton();
private static JPanel expensePanel;
private static JPanel conPanel;
private static JPanel startPanel;
private static JPanel incomePanel;

private static JPanel fullIncomeOverviewPanel;
private static JTextArea IncomeDetailsTextArea = new JTextArea();
private static JButton fullIncomeReportsButton = new JButton();
private static JButton fullIncomeHomeButton = new JButton();
private static JButton fullIncomeReporter = new JButton();
private static JComboBox typeSorter;
	frameWindow() {
		

//start panel
startPanel = new JPanel();
startPanel.setBackground(Color.black);
startPanel.setBounds(0, 0, 455, 600);
startPanel.setLayout(null);
startPanel.setVisible(true);
//Start Page Labels			
		
JLabel titleLabel = new JLabel();
titleLabel.setText("E-WALLET");
titleLabel.setBounds(170, 30, 150, 25);
titleLabel.setFont(new Font("Courier New", Font.PLAIN, 25));
titleLabel.setForeground(Color.white);
titleLabel.setVisible(true);

JLabel chooseLabel = new JLabel();
chooseLabel.setText("What Would You Like To Do?");
chooseLabel.setBounds(65, 250, 400, 25);
chooseLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
chooseLabel.setForeground(Color.white);
chooseLabel.setVisible(true);
		
//Start Page Buttons
addIncome = new JButton("Add an Income");
addIncome.setFont(new Font("Courier New", Font.PLAIN, 13));
addIncome.setBounds(30, 330, 182, 70);
addIncome.setFocusable(false);
addIncome.addActionListener(this);
addIncome.setVisible(true);

addExpense = new JButton("Add an Expense");
addExpense.setFont(new Font("Courier New", Font.PLAIN, 13));
addExpense.setBounds(233, 330, 182, 70);
addExpense.setFocusable(false);
addExpense.addActionListener(this);
addExpense.setVisible(true);

viewSummary = new JButton("View a Summary");
viewSummary.setFont(new Font("Courier New", Font.PLAIN, 13));
viewSummary.setBounds(30, 450, 182, 70);
viewSummary.setFocusable(false);
viewSummary.addActionListener(this);
viewSummary.setVisible(true);

currencyConv = new JButton("Convert Currency ");
currencyConv.setFont(new Font("Courier New", Font.PLAIN, 13));
currencyConv.setBounds(233, 450, 182, 70);
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


//ADD INCOME PANEL
incomePanel = new JPanel();
incomePanel.setBackground(Color.black);
incomePanel.setBounds(0, 0, 455, 600);
incomePanel.setLayout(null);
incomePanel.setVisible(false);

incomeHomeButton = new JButton("Home");
incomeHomeButton.setBounds(170, 30, 120, 70);
incomeHomeButton.setFocusable(false);
incomeHomeButton.addActionListener(this);
incomeHomeButton.setVisible(true);


incomeLabel = new JLabel();
incomeLabel.setText("Please enter your monthly income amount:");
incomeLabel.setBounds(45, 350, 600, 25);
incomeLabel.setFont(new Font("Arial", Font.PLAIN, 17));
incomeLabel.setForeground(Color.white);
incomeLabel.setVisible(true);

inlabel = new JLabel();
inlabel.setText("Type:");
inlabel.setBounds(40, 390, 30, 25);
inlabel.setFont(new Font("Arial", Font.PLAIN, 12));
inlabel.setForeground(Color.white);
inlabel.setVisible(true);


enterIncome = new JButton("Enter");
enterIncome.setBounds(175, 430, 100, 30);
enterIncome.setFocusable(false);
enterIncome.addActionListener(this);
enterIncome.setVisible(true);

String[] incometypeList = {"Primary", "Secondary", "Other",};
incomeType = new JComboBox(incometypeList);
incomeType.setBounds(85, 390, 80, 25);
incomeType.setVisible(true);


incomeText.setPreferredSize(new Dimension(20, 30));
incomeText.setCaretColor(Color.black); //cursor color
incomeText.setText("100.00"); //starting text
incomeText.setEditable(true);
incomeText.setBounds(185, 390, 80, 25);
incomeText.setVisible(true);


incomePanel.add(incomeText);
incomePanel.add(incomeType);
incomePanel.add(incomeLabel);
incomePanel.add(inlabel);
incomePanel.add(enterIncome);
incomePanel.add(incomeHomeButton);

//SaveScreen
savePanel = new JPanel();
savePanel.setBackground(Color.black);
savePanel.setBounds(0, 0, 455, 600);
savePanel.setLayout(null);
savePanel.setVisible(false);

savePanelHomeButton = new JButton("Home");
savePanelHomeButton.setBounds(170, 30, 120, 70);
savePanelHomeButton.setFocusable(false);
savePanelHomeButton.addActionListener(this);
savePanelHomeButton.setVisible(true);

JLabel saveAmountLabel = new JLabel();
saveAmountLabel.setBounds(100, 300, 600, 25);
saveAmountLabel.setText("Please enter the amount of the item");
saveAmountLabel.setFont(new Font("Arial", Font.PLAIN, 17));
saveAmountLabel.setForeground(Color.white);
saveAmountLabel.setVisible(true);

saveAmountText = new JTextField();
saveAmountText.setPreferredSize(new Dimension(20, 30));
saveAmountText.setCaretColor(Color.black); //cursor color
saveAmountText.setText("100.00"); //starting text
saveAmountText.setEditable(true);
saveAmountText.setBounds(185, 340, 80, 25);
saveAmountText.setVisible(true);

savePanelSubmit = new JButton("Submit");
savePanelSubmit.setBounds(170, 390, 120, 70);
savePanelSubmit.setFocusable(false);
savePanelSubmit.addActionListener(this);
savePanelSubmit.setVisible(true);

saveResLabel = new JLabel();
saveResLabel.setBounds(100, 460, 600, 25);
saveResLabel.setText("Months to Save:");
saveResLabel.setFont(new Font("Arial", Font.PLAIN, 17));
saveResLabel.setForeground(Color.white);
saveAmountLabel.setVisible(true);

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


//SUMMARY VIEW MENU OPTIONS////////////////////////////////
summaryOverviewPanel = new JPanel();
summaryOverviewPanel.setBackground(Color.black);
summaryOverviewPanel.setBounds(0, 0, 455, 600);
summaryOverviewPanel.setLayout(null);
summaryOverviewPanel.setVisible(false);

summaryHomeButton = new JButton("Home");
summaryHomeButton.setBounds(170, 30, 120, 70);
summaryHomeButton.setFocusable(false);
summaryHomeButton.addActionListener(this);
summaryHomeButton.setVisible(true);

fullExpenseReportsButton = new JButton("View Full Expense Reports");
fullExpenseReportsButton.setBounds(130, 135, 190, 70);
fullExpenseReportsButton.setFocusable(false);
fullExpenseReportsButton.addActionListener(this);
fullExpenseReportsButton.setVisible(true);

fullIncomeReportsButton = new JButton("View Income Reports");
fullIncomeReportsButton.setBounds(130, 360, 190, 70);
fullIncomeReportsButton.setFocusable(false);
fullIncomeReportsButton.addActionListener(this);
fullIncomeReportsButton.setVisible(true);

itemSave = new JButton("Save for Item");
itemSave.setBounds(130, 285, 190, 70);
itemSave.setFocusable(false);
itemSave.addActionListener(this);
itemSave.setVisible(true);

expenseByTypeButton = new JButton("Sort Expense by Type");
expenseByTypeButton.setBounds(130, 210, 190, 70);
expenseByTypeButton.setFocusable(false);
expenseByTypeButton.addActionListener(this);
expenseByTypeButton.setVisible(true);

//VIEW FULL EXPENSE OPTION 
fullExpenseOverviewPanel = new JPanel();
fullExpenseOverviewPanel.setBackground(Color.black);
fullExpenseOverviewPanel.setBounds(0, 0, 455, 600);
fullExpenseOverviewPanel.setLayout(null);
fullExpenseOverviewPanel.setVisible(false);

fullExpenseHomeButton = new JButton("Home");
fullExpenseHomeButton.setBounds(130, 10, 200, 35);
fullExpenseHomeButton.setFocusable(false);
fullExpenseHomeButton.addActionListener(this);
fullExpenseHomeButton.setVisible(true);

expenseDetailsTextArea = new JTextArea();
expenseDetailsTextArea.setBounds(30, 65, 400, 450); // Set the position and size of the text area
expenseDetailsTextArea.setEditable(false); // Set the text area as non-editable

//VIEW INCOME OVERVIEW OPTION 
fullIncomeOverviewPanel = new JPanel();
fullIncomeOverviewPanel.setBackground(Color.black);
fullIncomeOverviewPanel.setBounds(0, 0, 455, 600);
fullIncomeOverviewPanel.setLayout(null);
fullIncomeOverviewPanel.setVisible(false);

fullIncomeHomeButton = new JButton("Home");
fullIncomeHomeButton.setBounds(50, 30, 120, 70);
fullIncomeHomeButton.setFocusable(false);
fullIncomeHomeButton.addActionListener(this);
fullIncomeHomeButton.setVisible(true);

fullIncomeReporter = new JButton("Find!");
fullIncomeReporter.setBounds(350, 30, 65, 50);
fullIncomeReporter.setFocusable(false);
fullIncomeReporter.addActionListener(this);
fullIncomeReporter.setVisible(true);

String[] typeList = {"Primary", "Secondary", "Other","All"};
typeSorter = new JComboBox(typeList);
typeSorter.setBounds(250, 30, 80, 50);
typeSorter.setVisible(true);

IncomeDetailsTextArea = new JTextArea();
IncomeDetailsTextArea.setBounds(30, 130, 395, 400); // Set the position and size of the text area
IncomeDetailsTextArea.setEditable(false); // Set the text area as non-editable

fullIncomeOverviewPanel.add(fullIncomeHomeButton);
fullIncomeOverviewPanel.add(fullIncomeReporter);
fullIncomeOverviewPanel.add(typeSorter);
fullIncomeOverviewPanel.add(IncomeDetailsTextArea);


//add to window
this.add(startPanel);
this.add(conPanel);
this.add(expensePanel);
this.add(incomePanel);
this.add(summaryOverviewPanel);
this.add(fullExpenseOverviewPanel);
this.add(fullIncomeOverviewPanel);
this.add(savePanel);

expenseOverviewLabel = new JLabel();
expenseOverviewLabel.setBounds(170, 295, 500, 500);
expenseOverviewLabel.setText("Total Compounded Expenses:");
expenseOverviewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
expenseOverviewLabel.setForeground(Color.white);
expenseOverviewLabel.setVisible(true);


//VIEW EXPENSE BY TYPE
expenseTypeOverviewPanel = new JPanel();
expenseTypeOverviewPanel.setBackground(Color.black);
expenseTypeOverviewPanel.setBounds(0, 0, 455, 600);
expenseTypeOverviewPanel.setLayout(null);
expenseTypeOverviewPanel.setVisible(false);

typeExpenseHomeButton = new JButton("Home");
typeExpenseHomeButton.setBounds(130, 10, 200, 35);
typeExpenseHomeButton.setFocusable(false);
typeExpenseHomeButton.addActionListener(this);
typeExpenseHomeButton.setVisible(true);


expenseTypeDetailsTextArea = new JTextArea(400,400);
expenseTypeDetailsTextArea.setBounds(30, 100, 400, 410);// Set the position and size of the text area
expenseTypeDetailsTextArea.setEditable(false); 

expenseTypeLabel = new JLabel();
expenseTypeLabel.setBounds(45, 40, 100, 65);
expenseTypeLabel.setText("Sort By Type:");
expenseTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
expenseTypeLabel.setForeground(Color.white);
expenseTypeLabel.setVisible(true);

expenseTypeOverviewLabel = new JLabel();
expenseTypeOverviewLabel.setBounds(170, 290, 500, 500);
expenseTypeOverviewLabel.setText("Total Compounded Expenses:");
expenseTypeOverviewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
expenseTypeOverviewLabel.setForeground(Color.white);
expenseTypeOverviewLabel.setVisible(true);

String[] expenseSortList = {"Transportation", "Bills", "Recreational","Grocery" };
expenseSortItems = new JComboBox(expenseSortList);
expenseSortItems.setBounds(160, 55, 150, 35);
expenseSortItems.setVisible(true);
expenseSortItems.setSelectedIndex(0); 

sortTypeSubmitButton = new JButton("Submit!");
sortTypeSubmitButton.setBounds(330, 60, 100, 25);
sortTypeSubmitButton.setFocusable(false);
sortTypeSubmitButton.addActionListener(this);
sortTypeSubmitButton.setVisible(true);


//NOTE TO SELF///////
/*
 * You need to parse the info from the expense sort list and then drive it into the function and 
 * then print it out and don't forget about the total for the items also
 * find a way to make it a scroll pane
 */




//add to window
getContentPane().add(startPanel);
getContentPane().add(conPanel);
getContentPane().add(expensePanel);
getContentPane().add(incomePanel);
getContentPane().add(summaryOverviewPanel);
getContentPane().add(fullExpenseOverviewPanel);
getContentPane().add(savePanel);
getContentPane().add(expenseTypeOverviewPanel);


//save panel
savePanel.add(savePanelHomeButton);
savePanel.add(saveAmountLabel);
savePanel.add(saveAmountText);
savePanel.add(saveResLabel);
savePanel.add(savePanelSubmit);

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


//full expense overview report
fullExpenseOverviewPanel.add(fullExpenseHomeButton);
fullExpenseOverviewPanel.add(expenseDetailsTextArea);
fullExpenseOverviewPanel.add(expenseOverviewLabel);


//expense report by type 
expenseTypeOverviewPanel.add(typeExpenseHomeButton);
expenseTypeOverviewPanel.add(expenseTypeDetailsTextArea);
expenseTypeOverviewPanel.add(expenseTypeLabel);
expenseTypeOverviewPanel.add(expenseTypeOverviewLabel);
expenseTypeOverviewPanel.add(expenseSortItems);
expenseTypeOverviewPanel.add(sortTypeSubmitButton);

///summary report overview menu 
summaryOverviewPanel.add(summaryHomeButton);
summaryOverviewPanel.add(fullExpenseReportsButton);
summaryOverviewPanel.add(fullIncomeReportsButton);
summaryOverviewPanel.add(itemSave);
summaryOverviewPanel.add(expenseByTypeButton);

//currency conv
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
getContentPane().setLayout(new BorderLayout(10, 10));
this.setResizable(false); 
this.getContentPane().setBackground(Color.black);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
this.setVisible(true);
	
	
	}
	

	
	
	///ACTIONS EVENTS + LOGIC/////////////////////////////////////////////////////////////////
	

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
				try {
					incomeWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		}
		if(e.getSource()== enterIncome) {
			String selectedincomeType = incomeType.getSelectedItem().toString();
			double cashflow = Double.parseDouble(incomeText.getText());
			Expenser.addIncome(selectedincomeType, cashflow);
			System.out.println("You entered the " + incomeType.getSelectedItem() + " type income with $" + incomeText.getText() +  ".");
			JOptionPane.showMessageDialog(null, "Income added! Look in Console for details!", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// want to enter information into an array, then enter it into a display into viewer 
		//WILL ONLY ENTER INTO AN ARRAY BASED ON TYPE FOR NOW 
		if(e.getSource()==currencyConv) { 
			System.out.println("you hit the currency button");
			try {
				convertWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		if(e.getSource()==expenseByTypeButton) { 
			try {
				expenseTypeOverviewWindow();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getSource()==sortTypeSubmitButton) { 
		
				String selectedType = expenseSortItems.getSelectedItem().toString();
				System.out.print(selectedType);
//expenseTypeDetailsTextArea
				expenseTypeDetailsTextArea.setText("");
				
				List<Map<String, Object>> filteredExpenses = Expenser.PrintExpensebyType(selectedType);
				
			    for (Map<String, Object> expenseDetails : filteredExpenses) {
			        String category = (String) expenseDetails.get("Category");
			        String subcategory = (String) expenseDetails.get("Subcategory");
			        double amount = (double) expenseDetails.get("Amount");
			        String frequency = (String) expenseDetails.get("Frequency");
			        
			        expenseTypeDetailsTextArea.append("Category: " + category + "\n");
			        expenseTypeDetailsTextArea.append("Subcategory: " + subcategory + "\n");
			        expenseTypeDetailsTextArea.append("Amount: " + amount + "\n");
			        expenseTypeDetailsTextArea.append("Frequency: " + frequency + "\n");
			        
			        expenseTypeDetailsTextArea.append("----------------------------------------------------------------------------\n");
			    }
			    
			    double totalExpense = 0;
			    for (Map<String, Object> expenseDetails : filteredExpenses) {
			        double amount = (double) expenseDetails.get("Amount");
			        totalExpense += amount;
			    }

			    DecimalFormat decimalFormat = new DecimalFormat("#.##");
			    String formattedTotalExpense = decimalFormat.format(totalExpense);

			    if (totalExpense > 0) {
			    	expenseTypeOverviewLabel.setText("Total Compounded Expenses: " + formattedTotalExpense);
			    } else {
			    	expenseTypeOverviewLabel.setText("Total Compounded Expenses: " + formattedTotalExpense);
			    }
		}
		

		if (e.getSource() == fullExpenseReportsButton) {
				try {
					expenseOverviewWindow();
			
					
					expenseDetailsTextArea.setText("");
					
					 List<Map<String, Object>> expensesList = Expenser.PrintExpensereport();
					    
					    // Iterate over the expenses list and append details to the text area
					    for (Map<String, Object> expenseDetails : expensesList) {
					        String category = (String) expenseDetails.get("Category");
					        String subcategory = (String) expenseDetails.get("Subcategory");
					        double amount = (double) expenseDetails.get("Amount");
					        String frequency = (String) expenseDetails.get("Frequency");
					        
					        // Append expense details to the text area
					        expenseDetailsTextArea.append("Category: " + category + "\n");
					        expenseDetailsTextArea.append("Subcategory: " + subcategory + "\n");
					        expenseDetailsTextArea.append("Amount: " + amount + "\n");
					        expenseDetailsTextArea.append("Frequency: " + frequency + "\n"); 
					        
					        expenseDetailsTextArea.append("----------------------------------------------------------------------------\n");
					    }
					    
					    double totalExpense = 0;
					    for (Map<String, Object> expenseDetails : expensesList) {
					        double amount = (double) expenseDetails.get("Amount");
					        totalExpense += amount;
					    }

					    DecimalFormat decimalFormat = new DecimalFormat("#.##");
					    String formattedTotalExpense = decimalFormat.format(totalExpense);

					    if (totalExpense > 0) {
					        expenseOverviewLabel.setText("Total Compounded Expenses: " + formattedTotalExpense);
					    } else {
					        expenseOverviewLabel.setText("Total Compounded Expenses: " + formattedTotalExpense);
					    }
					    
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		} 
		
		
		if (e.getSource() == fullIncomeReportsButton) {
			try {
				incomeOverviewWindow();
				    
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	      }
		
		if (e.getSource() == fullIncomeReporter) {
			IncomeDetailsTextArea.setText("");
			
			 List<Map<String, Object>> incomeAmount = Expenser.PrintIncomereport();
			    
			    // Iterate over the expenses list and append details to the text area
			    for (Map<String, Object> incomeDetailsMap : incomeAmount) {
			        
			    	
			    if (typeSorter.getSelectedIndex()== 0) {	
			        if((String) incomeDetailsMap.get("Type") == "Primary") { 
			        String intype = (String) incomeDetailsMap.get("Type");
			        double inamount = (double) incomeDetailsMap.get("Income");
			        
			        // Append expense details to the text area
			        IncomeDetailsTextArea.append("Income Type: " + intype+ "\n");
			        IncomeDetailsTextArea.append("Income Amount: " + inamount + "\n");
			       
			        IncomeDetailsTextArea.append("-------------------------------------------------\n");
			        }
			    }
			    else if (typeSorter.getSelectedIndex()== 1) {	
			        if((String) incomeDetailsMap.get("Type") == "Secondary") { 
			        String intype = (String) incomeDetailsMap.get("Type");
			        double inamount = (double) incomeDetailsMap.get("Income");
			        
			        // Append expense details to the text area
			        IncomeDetailsTextArea.append("Income Type: " + intype+ "\n");
			        IncomeDetailsTextArea.append("Income Amount: " + inamount + "\n");
			       
			        IncomeDetailsTextArea.append("-------------------------------------------------\n");
			        }
			    }
			    else if (typeSorter.getSelectedIndex()== 2) {	
			        if((String) incomeDetailsMap.get("Type") == "Other") { 
			        String intype = (String) incomeDetailsMap.get("Type");
			        double inamount = (double) incomeDetailsMap.get("Income");
			        
			        // Append expense details to the text area
			        IncomeDetailsTextArea.append("Income Type: " + intype+ "\n");
			        IncomeDetailsTextArea.append("Income Amount: " + inamount + "\n");
			       
			        IncomeDetailsTextArea.append("-------------------------------------------------\n");
			        }
			    }
			    else if (typeSorter.getSelectedIndex()== 3) {	
			       
			        String intype = (String) incomeDetailsMap.get("Type");
			        double inamount = (double) incomeDetailsMap.get("Income");
			        
			        // Append expense details to the text area
			        IncomeDetailsTextArea.append("Income Type: " + intype+ "\n");
			        IncomeDetailsTextArea.append("Income Amount: " + inamount + "\n");
			       
			        IncomeDetailsTextArea.append("-------------------------------------------------\n");
			        }
			    }
		}

		if(e.getSource()==savePanelSubmit) {
			double currMonthlySavings = Expenser.updateMonthlySavings();
			double currAmount = Double.parseDouble(saveAmountText.getText());
			double currRes = currAmount/currMonthlySavings;
			double roundedResult = Math.round(currRes * 10.0) / 10.0;
			if (currRes > 0) {
				saveResLabel.setText("Months to Save: " + currRes);
			} else {
				saveResLabel.setText("You currently have a negative income" + currRes);
			}
			
			
			
		}
		if(e.getSource()==viewSummary) { 
			try {
				Expenser.updateMonthlySavings();
				SummaryWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		
		if(e.getSource()==incomeHomeButton) { //resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	if(e.getSource()==summaryHomeButton) { //resets to home screen
		try {
			screenReset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource()==fullExpenseHomeButton) { //resets to home screen
		try {
			screenReset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource()==fullIncomeHomeButton) { //resets to home screen
		try {
			screenReset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource()==savePanelHomeButton) { //resets to home screen
		try {
			screenReset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if(e.getSource()==itemSave) { //resets to home screen
		try {
			saveScreen();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource()==typeExpenseHomeButton) { //resets to home screen
		try {
			screenReset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}
	/////////////////////////////////////////////////////////////////
	
	//function to reset screen to base window, anytime you add a button on another window, set it to false here so when we add a back to home button, it makes it invisible.
	public static void screenReset() throws IOException {
		startPanel.setVisible(true);
		conPanel.setVisible(false);
		expensePanel.setVisible(false);
		incomePanel.setVisible(false);
		summaryOverviewPanel.setVisible(false);
		fullExpenseOverviewPanel.setVisible(false);
		fullIncomeOverviewPanel.setVisible(false);
		savePanel.setVisible(false);
		expenseTypeOverviewPanel.setVisible(false);
	}
	
	public static void convertWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		conPanel.setVisible(true);
		
		
	}
	public static void incomeWindow() throws IOException {
	    incomePanel.setVisible(true);
		startPanel.setVisible(false);
		conPanel.setVisible(false);
		expensePanel.setVisible(false);

	

} 
	
	public static void SummaryWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		summaryOverviewPanel.setVisible(true);
		
		
	}

	public static void expenseWindow() throws IOException {
		//hiding original screen
		startPanel.setVisible(false);

		//making conversion screen
		expensePanel.setVisible(true);
		
		
	}
	
	public static void expenseOverviewWindow() throws IOException {
		//hiding original screen
		summaryOverviewPanel.setVisible(false);

		//making conversion screen
		fullExpenseOverviewPanel.setVisible(true);
		
		
	}

	
	public static void incomeOverviewWindow() throws IOException {
		//hiding original screen
		summaryOverviewPanel.setVisible(false);

		//making conversion screen
		fullIncomeOverviewPanel.setVisible(true);
		
	}
		

	public static void expenseTypeOverviewWindow() throws IOException {
		//hiding original screen
		summaryOverviewPanel.setVisible(false);
		
		//making conversion screen
		expenseTypeOverviewPanel.setVisible(true);
		
	}
	
	public static void saveScreen() throws IOException {
		//hiding original screen
		summaryOverviewPanel.setVisible(false);

		//making conversion screen
		savePanel.setVisible(true);
		
	}
}

