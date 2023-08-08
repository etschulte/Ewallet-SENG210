import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frameWindow extends JFrame implements ActionListener {

	// Global variables, to work with action listener
	private static String derbyEmbeddedURL = "jdbc:derby:SENG;";
	private static final int MAX_LOGIN_ATTEMPTS = 5;
	private static int loginAttempts = 0;
	private JFileChooser fileChooser = new JFileChooser("src\\");
	private static JButton addIncome = new JButton();
	private static JButton addExpense = new JButton();
	private static JButton viewSummary = new JButton();
	private static JButton currencyConv = new JButton();
	private static JButton homeButton = new JButton();
	private static JButton loginButton = new JButton();
	private static JButton createAccountButton = new JButton();
	private static JTextField convertText = new JTextField();
	private static JButton convertButton = new JButton();
	private static JComboBox currSelectOne;
	private static JComboBox currSelectTwo;
	private static JLabel currResultLabel;

	//create account
	private static JPanel createAccPanel;
	private static JButton createAccHomeBtn = new JButton();
	private static JButton createAccountBtn = new JButton();
	private static JTextField addUsernameFld = new JTextField();
	private static JTextField addPasswordFld = new JTextField();
	private static JTextField confPasswordFld = new JTextField();
	private static JLabel usernameLbl = new JLabel();
	private static JLabel passwordLbl = new JLabel();
	private static JLabel confPasswordLbl = new JLabel();

	//file export
	private static JButton importExpenseButton = new JButton();
	private static JButton importIncomeButton = new JButton();

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

	//for the detailed report
	private static JPanel detailedSummaryPanel;
	private static JTextArea detailedSummaryTextArea = new JTextArea();
	private static JButton detailedSummaryHomeButton = new JButton();

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
	private static JButton detailedSummaryButton = new JButton();

	//For the expense report by type function
	private static JButton expenseByTypeButton = new JButton();
	private static JPanel expenseTypeOverviewPanel;
	private static JButton typeExpenseHomeButton = new JButton();
	private static JTextArea expenseTypeDetailsTextArea = new JTextArea();
	private static JLabel expenseTypeLabel = new JLabel();
	private static JLabel expenseTypeOverviewLabel = new JLabel();
	private static JComboBox expenseSortItems;
	private static JButton sortTypeSubmitButton = new JButton();
	private static JButton exportExpenseReportButton = new JButton();

	//income
	private static JLabel incomeLabel;
	private static JTextField incomeText = new JTextField();
	private static JComboBox incomeType;

	// Login Panel
	private Font loginPanelComponentFont;
	private static JPanel loginPanel;
	private static JButton loginHomeButton;
	private JLabel loginPanelDefaultMessage;
	private JLabel loginUsernameFieldLabel;
	private JLabel loginPasswordFieldLabel;
	private static JTextField loginUsernameField;
	private static JPasswordField loginPasswordField;
	private static JButton loginToAccountButton;

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
	private static JLabel incomeOverviewLabel = new JLabel();
	private static JButton exportIncomeReportButton = new JButton();


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
		chooseLabel.setBounds(65, 150, 400, 25);
		chooseLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		chooseLabel.setForeground(Color.white);
		chooseLabel.setVisible(true);

//Start Page Buttons
		addIncome = new JButton("Add an Income");
		addIncome.setFont(new Font("Courier New", Font.PLAIN, 13));
		addIncome.setBounds(30, 260, 182, 70);
		addIncome.setFocusable(false);
		addIncome.addActionListener(this);
		addIncome.setVisible(true);

		addExpense = new JButton("Add an Expense");
		addExpense.setFont(new Font("Courier New", Font.PLAIN, 13));
		addExpense.setBounds(233, 260, 182, 70);
		addExpense.setFocusable(false);
		addExpense.addActionListener(this);
		addExpense.setVisible(true);

		viewSummary = new JButton("View a Summary");
		viewSummary.setFont(new Font("Courier New", Font.PLAIN, 13));
		viewSummary.setBounds(30, 360, 182, 70);
		viewSummary.setFocusable(false);
		viewSummary.addActionListener(this);
		viewSummary.setVisible(true);

		currencyConv = new JButton("Convert Currency ");
		currencyConv.setFont(new Font("Courier New", Font.PLAIN, 13));
		currencyConv.setBounds(233, 360, 182, 70);
		currencyConv.setFocusable(false);
		currencyConv.addActionListener(this);
		currencyConv.setVisible(true);

		createAccountButton.setText("Create An Account");
		createAccountButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		createAccountButton.setBounds(30,460,182,70);
		createAccountButton.setFocusable(false);
		createAccountButton.addActionListener(this);

		loginButton.setText("Login");
		loginButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		loginButton.setBounds(233,460,182,70);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

// login panel configuration
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.black);
		loginPanel.setBounds(0, 0, 455, 600);

// Reusable font component configuration
		loginPanelComponentFont = new Font("Courier New", Font.PLAIN, 16);

// Login Button to go back to home page configuration
		loginHomeButton = new JButton("Home");
		loginHomeButton.setFont(new Font("Courier New", Font.PLAIN,13));
		loginHomeButton.addActionListener(this);
		loginHomeButton.setFocusable(false);
		loginHomeButton.setBounds(140,20,180,35);

// Login default message configuration
		loginPanelDefaultMessage = new JLabel();
		loginPanelDefaultMessage.setText("Login to an account here!");
		loginPanelDefaultMessage.setFont(new Font("Courier New", Font.PLAIN, 20));
		loginPanelDefaultMessage.setBounds(72, 210, 400, 25);
		loginPanelDefaultMessage.setForeground(Color.WHITE);

// Username field label configuration
		loginUsernameFieldLabel = new JLabel("Username:");
		loginUsernameFieldLabel.setFont(loginPanelComponentFont);
		loginUsernameFieldLabel.setBounds(40,300,100,50);
		loginUsernameFieldLabel.setForeground(Color.WHITE);

// Password field label configuration
		loginPasswordFieldLabel = new JLabel("Password:");
		loginPasswordFieldLabel.setFont(loginPanelComponentFont);
		loginPasswordFieldLabel.setBounds(40,370,100,50);
		loginPasswordFieldLabel.setForeground(Color.WHITE);

// Username Field configuration
		loginUsernameField = new JTextField();
		loginUsernameField.setFont(loginPanelComponentFont);
		loginUsernameField.setBounds(160,310,220,30);

// Password field configuration
		loginPasswordField = new JPasswordField();
		loginPasswordField.setFont(loginPanelComponentFont);
		loginPasswordField.setBounds(160,380,220,30);

// Login to account button configuration
		loginToAccountButton = new JButton("Login");
		loginToAccountButton.setFont(loginPanelComponentFont);
		loginToAccountButton.setFocusable(false);
		loginToAccountButton.addActionListener(this);
		loginToAccountButton.setBounds(140,480,180,35);

// Adding components to login panel
		loginPanel.add(loginHomeButton);
		loginPanel.add(loginPanelDefaultMessage);
		loginPanel.add(loginUsernameFieldLabel);
		loginPanel.add(loginUsernameField);
		loginPanel.add(loginPasswordFieldLabel);
		loginPanel.add(loginPasswordField);
		loginPanel.add(loginToAccountButton);
		loginPanel.setVisible(false);


//CREATE ACCOUNT PANEL
		createAccPanel = new JPanel();
		createAccPanel.setBackground(Color.black);
		createAccPanel.setBounds(0, 0, 455, 600);
		createAccPanel.setLayout(null);
		createAccPanel.setVisible(false);

		createAccHomeBtn = new JButton("Home");
		createAccHomeBtn.setFont(new Font("Courier New", Font.PLAIN, 15));
		createAccHomeBtn.setBounds(140, 20, 180, 35);
		createAccHomeBtn.setFocusable(false);
		createAccHomeBtn.addActionListener(this);
		createAccHomeBtn.setVisible(true);

		addUsernameFld.setFont(new Font("Courier New", Font.PLAIN, 13));
		addUsernameFld.setPreferredSize(new Dimension(20, 30));
		addUsernameFld.setCaretColor(Color.black); // cursor color
		addUsernameFld.setEditable(true);
		addUsernameFld.setBounds(200, 100, 180, 35);
		addUsernameFld.setVisible(true);

		usernameLbl = new JLabel("Enter Username: ");
		usernameLbl.setFont(new Font("Courier New", Font.PLAIN, 16));
		usernameLbl.setForeground(Color.white);
		usernameLbl.setBounds(30, 100, 180, 35);
		usernameLbl.setFocusable(false);
		usernameLbl.setVisible(true);

		addPasswordFld.setFont(new Font("Courier New", Font.PLAIN, 13));
		addPasswordFld.setPreferredSize(new Dimension(20, 30));
		addPasswordFld.setCaretColor(Color.black); // cursor color
		addPasswordFld.setEditable(true);
		addPasswordFld.setBounds(200, 175, 180, 35);
		addPasswordFld.setVisible(true);

		passwordLbl = new JLabel("Enter Password: ");
		passwordLbl.setFont(new Font("Courier New", Font.PLAIN, 16));
		passwordLbl.setForeground(Color.white);
		passwordLbl.setBounds(30, 175, 180, 35);
		passwordLbl.setFocusable(false);
		passwordLbl.setVisible(true);

		confPasswordFld.setFont(new Font("Courier New", Font.PLAIN, 13));
		confPasswordFld.setPreferredSize(new Dimension(20, 30));
		confPasswordFld.setCaretColor(Color.black); // cursor color
		confPasswordFld.setEditable(true);
		confPasswordFld.setBounds(220, 250, 180, 35);
		confPasswordFld.setVisible(true);

		confPasswordLbl = new JLabel("Confirm Password: ");
		confPasswordLbl.setFont(new Font("Courier New", Font.PLAIN, 16));
		confPasswordLbl.setForeground(Color.white);
		confPasswordLbl.setBounds(30, 250, 180, 35);
		confPasswordLbl.setFocusable(false);
		confPasswordLbl.setVisible(true);

		createAccountBtn = new JButton("Create Account");
		createAccountBtn.setFont(new Font("Courier New", Font.PLAIN, 15));
		createAccountBtn.setBounds(140, 400, 180, 35);
		createAccountBtn.setFocusable(false);
		createAccountBtn.addActionListener(this);
		createAccountBtn.setVisible(true);

		createAccPanel.add(createAccHomeBtn);
		createAccPanel.add(usernameLbl);
		createAccPanel.add(passwordLbl);
		createAccPanel.add(confPasswordLbl);
		createAccPanel.add(addUsernameFld);
		createAccPanel.add(addPasswordFld);
		createAccPanel.add(confPasswordFld);
		createAccPanel.add(createAccountBtn);

//currency Conversion window

//you can re-use the home button for other screens as long as you don't move it, if you want to move it, copy, rename, and change the position.
		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		homeButton.setBounds(140, 20, 180, 35);
		homeButton.setFocusable(false);
		homeButton.addActionListener(this);
		homeButton.setVisible(true);

		JLabel convertLabel = new JLabel();
		convertLabel.setText("Please Enter Your Balance To Convert:");
		convertLabel.setBounds(50, 330, 600, 25);
		convertLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		convertLabel.setForeground(Color.white);
		convertLabel.setVisible(true);

		JLabel convertToLabel = new JLabel();
		convertToLabel.setText("To");
		convertToLabel.setBounds(275, 390, 20, 25);
		convertToLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		convertToLabel.setForeground(Color.white);
		convertToLabel.setVisible(true);

		currResultLabel = new JLabel();
		currResultLabel.setText("");
		currResultLabel.setBounds(175, 480, 200, 25);
		currResultLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		currResultLabel.setForeground(Color.white);
		currResultLabel.setVisible(true);

		convertText.setPreferredSize(new Dimension(20, 30));
		convertText.setCaretColor(Color.black); // cursor color
		convertText.setText("100.00"); // starting text
		convertText.setEditable(true);
		convertText.setBounds(185, 390, 80, 25);
		convertText.setVisible(true);

		String[] currencyList = { "USD", "EUR", "CAD", };
		currSelectOne = new JComboBox(currencyList);
		currSelectOne.setFont(new Font("Courier New", Font.PLAIN, 13));
		currSelectOne.setBounds(110, 390, 60, 25);
		currSelectOne.setVisible(true);

		currSelectTwo = new JComboBox(currencyList);
		currSelectTwo.setBounds(305, 390, 60, 25);
		currSelectTwo.setVisible(true);
		currSelectTwo.setSelectedIndex(1);

		convertButton = new JButton("Convert!");
		convertButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		convertButton.setBounds(175, 440, 100, 30);
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

		importIncomeButton = new JButton("Import Income");
		importIncomeButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		importIncomeButton.setBounds(140, 70, 180, 60);
		importIncomeButton.setFocusable(false);
		importIncomeButton.addActionListener(this);
		importIncomeButton.setVisible(true);

		incomeHomeButton = new JButton("Home");
		incomeHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		incomeHomeButton.setBounds(140, 20, 180, 35);
		incomeHomeButton.setFocusable(false);
		incomeHomeButton.addActionListener(this);
		incomeHomeButton.setVisible(true);

		incomeLabel = new JLabel();
		incomeLabel.setText("Please Enter Your Monthly Income Amount:");
		incomeLabel.setBounds(30, 350, 600, 25);
		incomeLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		incomeLabel.setForeground(Color.white);
		incomeLabel.setVisible(true);

		inlabel = new JLabel();
		inlabel.setText("Type:");
		inlabel.setBounds(10, 390, 55, 25);
		inlabel.setFont(new Font("Courier New", Font.PLAIN, 13));
		inlabel.setForeground(Color.white);
		inlabel.setVisible(true);

		enterIncome = new JButton("Enter");
		enterIncome.setFont(new Font("Courier New", Font.PLAIN, 13));
		enterIncome.setBounds(310, 390, 100, 25);
		enterIncome.setFocusable(false);
		enterIncome.addActionListener(this);
		enterIncome.setVisible(true);

		String[] incometypeList = { "Primary", "Secondary", "Other", };
		incomeType = new JComboBox(incometypeList);
		incomeType.setFont(new Font("Courier New", Font.PLAIN, 13));
		incomeType.setBounds(60, 390, 140, 25);
		incomeType.setVisible(true);
		incomeText.setFont(new Font("Courier New", Font.PLAIN, 13));

		incomeText.setPreferredSize(new Dimension(20, 30));
		incomeText.setCaretColor(Color.black); // cursor color
		incomeText.setText("100.00"); // starting text
		incomeText.setEditable(true);
		incomeText.setBounds(210, 390, 80, 25);
		incomeText.setVisible(true);

		incomePanel.add(incomeText);
		incomePanel.add(incomeType);
		incomePanel.add(incomeLabel);
		incomePanel.add(inlabel);
		incomePanel.add(enterIncome);
		incomePanel.add(incomeHomeButton);
		incomePanel.add(importIncomeButton);

//SaveScreen
		savePanel = new JPanel();
		savePanel.setBackground(Color.black);
		savePanel.setBounds(0, 0, 455, 600);
		savePanel.setLayout(null);
		savePanel.setVisible(false);

		savePanelHomeButton = new JButton("Home");
		savePanelHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		savePanelHomeButton.setBounds(140, 20, 180, 35);
		savePanelHomeButton.setFocusable(false);
		savePanelHomeButton.addActionListener(this);
		savePanelHomeButton.setVisible(true);

		JLabel saveAmountLabel = new JLabel();
		saveAmountLabel.setBounds(100, 300, 600, 25);
		saveAmountLabel.setText("Please Enter The Item Amount:");
		saveAmountLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		saveAmountLabel.setForeground(Color.white);
		saveAmountLabel.setVisible(true);

		saveAmountText = new JTextField();
		saveAmountText.setFont(new Font("Courier New", Font.PLAIN, 13));
		saveAmountText.setPreferredSize(new Dimension(20, 30));
		saveAmountText.setCaretColor(Color.black); // cursor color
		saveAmountText.setText("100.00"); // starting text
		saveAmountText.setEditable(true);
		saveAmountText.setBounds(130, 360, 80, 25);
		saveAmountText.setVisible(true);

		savePanelSubmit = new JButton("Submit");
		savePanelSubmit.setFont(new Font("Courier New", Font.PLAIN, 13));
		savePanelSubmit.setBounds(230, 360, 120, 25);
		savePanelSubmit.setFocusable(false);
		savePanelSubmit.addActionListener(this);
		savePanelSubmit.setVisible(true);

		saveResLabel = new JLabel();
		saveResLabel.setBounds(70, 440, 600, 25);
		saveResLabel.setText("Estimated Months to Save:");
		saveResLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		saveResLabel.setForeground(Color.white);
		saveAmountLabel.setVisible(true);

//ADD EXPENSE WINDOW ////////////////////////
		expensePanel = new JPanel();
		expensePanel.setBackground(Color.black);
		expensePanel.setBounds(0, 0, 455, 600);
		expensePanel.setLayout(null);
		expensePanel.setVisible(false);

		expenseHomeButton = new JButton("Home");
		expenseHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		expenseHomeButton.setBounds(140, 20, 180, 35);
		expenseHomeButton.setFocusable(false);
		expenseHomeButton.addActionListener(this);
		expenseHomeButton.setVisible(true);

		importExpenseButton = new JButton("Import Expense");
		importExpenseButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		importExpenseButton.setBounds(140, 70, 180, 60);
		importExpenseButton.setFocusable(false);
		importExpenseButton.addActionListener(this);
		importExpenseButton.setVisible(true);

		JLabel expenseLabel = new JLabel();
		expenseLabel.setText("Please Enter the Type of Expense:");
		expenseLabel.setBounds(70, 250, 600, 25);
		expenseLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		expenseLabel.setForeground(Color.white);
		expenseLabel.setVisible(true);

		String[] expenseList = { "Transportation", "Bills", "Recreational", "Grocery" };
		expenseSelectOne = new JComboBox(expenseList);
		expenseSelectOne.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectOne.setBounds(80, 290, 170, 35);
		expenseSelectOne.setVisible(true);
		expenseSelectOne.setSelectedIndex(0);

		String[] expenseList2 = { "Gas", "Maintenance" };
		expenseSelectTwo = new JComboBox(expenseList2);
		expenseSelectTwo.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectTwo.setBounds(190, 400, 140, 30);
		expenseSelectTwo.setVisible(false);
		expenseSelectTwo.setSelectedIndex(0);

		String[] expenseList3 = { "Rent", "Electricity" };
		expenseSelectThree = new JComboBox(expenseList3);
		expenseSelectThree.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectThree.setBounds(190, 400, 140, 30);
		expenseSelectThree.setVisible(false);
		expenseSelectThree.setSelectedIndex(0);

		String[] expenseList4 = { "Entertainment", "Shopping" };
		expenseSelectFour = new JComboBox(expenseList4);
		expenseSelectFour.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectFour.setBounds(190, 400, 140, 30);
		expenseSelectFour.setVisible(false);
		expenseSelectFour.setSelectedIndex(0);

		String[] expenseList5 = { "Produce", "Meat" };
		expenseSelectFive = new JComboBox(expenseList5);
		expenseSelectFive.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectFive.setBounds(190, 400, 140, 30);
		expenseSelectFive.setVisible(false);
		expenseSelectFive.setSelectedIndex(0);

		expenseFrequencyLabel.setBounds(100, 440, 600, 25);
		expenseFrequencyLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		expenseFrequencyLabel.setForeground(Color.white);
		expenseFrequencyLabel.setVisible(true);

//combo box for the frequency of when the expense occurs
		String[] expenseList6 = { "Annually", "Monthly", "Biweekly" };
		expenseSelectSix = new JComboBox(expenseList6);
		expenseSelectSix.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSelectSix.setBounds(190, 440, 140, 30);
		expenseSelectSix.setVisible(false);
		expenseSelectSix.setSelectedIndex(0);

		expenseAddtionalLabel.setBounds(90, 350, 600, 25);
		expenseAddtionalLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		expenseAddtionalLabel.setForeground(Color.white);
		expenseAddtionalLabel.setVisible(true);

		expenseAmountLabel.setBounds(100, 480, 600, 25);
		expenseAmountLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		expenseAmountLabel.setForeground(Color.white);
		expenseAmountLabel.setVisible(true);

		expenseCategoryLabel.setBounds(100, 400, 600, 25);
		expenseCategoryLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		expenseCategoryLabel.setForeground(Color.white);
		expenseCategoryLabel.setVisible(true);
		expenseAmountText.setFont(new Font("Courier New", Font.PLAIN, 13));

		expenseAmountText.setPreferredSize(new Dimension(20, 30));
		expenseAmountText.setCaretColor(Color.black); // cursor color
		expenseAmountText.setEditable(true);
		expenseAmountText.setBounds(190, 480, 136, 25);
		expenseAmountText.setVisible(false);

//submit button for type of expense
		expenseSubmitButton = new JButton("Submit!");
		expenseSubmitButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSubmitButton.setBounds(270, 290, 100, 30);
		expenseSubmitButton.setFocusable(false);
		expenseSubmitButton.addActionListener(this);
		expenseSubmitButton.setVisible(true);

		addtionalInfoSubmitButton = new JButton("Submit!");
		addtionalInfoSubmitButton.setFont(new Font("Courier New", Font.PLAIN, 13));
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
		summaryHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		summaryHomeButton.setBounds(140, 20, 180, 35);
		summaryHomeButton.setFocusable(false);
		summaryHomeButton.addActionListener(this);
		summaryHomeButton.setVisible(true);

		fullExpenseReportsButton = new JButton("Full Expense Report");
		fullExpenseReportsButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		fullExpenseReportsButton.setBounds(130, 120, 190, 70);
		fullExpenseReportsButton.setFocusable(false);
		fullExpenseReportsButton.addActionListener(this);
		fullExpenseReportsButton.setVisible(true);

		fullIncomeReportsButton = new JButton("View Income Reports");
		fullIncomeReportsButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		fullIncomeReportsButton.setBounds(130, 360, 190, 70);
		fullIncomeReportsButton.setFocusable(false);
		fullIncomeReportsButton.addActionListener(this);
		fullIncomeReportsButton.setVisible(true);

		detailedSummaryButton = new JButton("Detailed Summary");
		detailedSummaryButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		detailedSummaryButton.setBounds(130, 440, 190, 70);
		detailedSummaryButton.setFocusable(false);
		detailedSummaryButton.addActionListener(this);
		detailedSummaryButton.setVisible(true);

		itemSave = new JButton("Save for Item");
		itemSave.setFont(new Font("Courier New", Font.PLAIN, 13));
		itemSave.setBounds(130, 280, 190, 70);
		itemSave.setFocusable(false);
		itemSave.addActionListener(this);
		itemSave.setVisible(true);

		expenseByTypeButton = new JButton("Sort Expense by Type");
		expenseByTypeButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseByTypeButton.setBounds(130, 200, 190, 70);
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
		fullExpenseHomeButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		fullExpenseHomeButton.setBounds(80, 10, 150, 35);
		fullExpenseHomeButton.setFocusable(false);
		fullExpenseHomeButton.addActionListener(this);
		fullExpenseHomeButton.setVisible(true);

		exportExpenseReportButton = new JButton("Export Report");
		exportExpenseReportButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		exportExpenseReportButton.setBounds(250, 10, 150, 35);
		exportExpenseReportButton.setFocusable(false);
		exportExpenseReportButton.addActionListener(this);
		exportExpenseReportButton.setVisible(true);

		expenseDetailsTextArea = new JTextArea();
		expenseDetailsTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		expenseDetailsTextArea.setEditable(false); // Set the text area as non-editable
		JScrollPane expensePane = new JScrollPane(expenseDetailsTextArea);
		expensePane.setBounds(30, 65, 400, 450);

//detailed summary pane
		detailedSummaryPanel = new JPanel();
		detailedSummaryPanel.setBackground(Color.black);
		detailedSummaryPanel.setBounds(0, 0, 455, 600);
		detailedSummaryPanel.setLayout(null);
		detailedSummaryPanel.setVisible(false);

		detailedSummaryHomeButton = new JButton("Home");
		detailedSummaryHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		detailedSummaryHomeButton.setBounds(140, 20, 180, 35);
		detailedSummaryHomeButton.setFocusable(false);
		detailedSummaryHomeButton.addActionListener(this);
		detailedSummaryHomeButton.setVisible(true);

		detailedSummaryTextArea = new JTextArea();
		detailedSummaryTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
// Set the position and size of the text area
		detailedSummaryTextArea.setEditable(false); // Set the text area as non-editable
		JScrollPane detailedSummaryPane = new JScrollPane(detailedSummaryTextArea);
		detailedSummaryPane.setBounds(30, 70, 395, 480);

		// VIEW INCOME OVERVIEW OPTION
		fullIncomeOverviewPanel = new JPanel();
		fullIncomeOverviewPanel.setBackground(Color.black);
		fullIncomeOverviewPanel.setBounds(0, 0, 455, 600);
		fullIncomeOverviewPanel.setLayout(null);
		fullIncomeOverviewPanel.setVisible(false);

		fullIncomeHomeButton = new JButton("Home");
		fullIncomeHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		fullIncomeHomeButton.setBounds(50, 10, 150, 35);
		fullIncomeHomeButton.setFocusable(false);
		fullIncomeHomeButton.addActionListener(this);
		fullIncomeHomeButton.setVisible(true);

		fullIncomeReporter = new JButton("Find!");
		fullIncomeReporter.setFont(new Font("Courier New", Font.PLAIN, 13));
		fullIncomeReporter.setBounds(270, 60, 120, 30);
		fullIncomeReporter.setFocusable(false);
		fullIncomeReporter.addActionListener(this);
		fullIncomeReporter.setVisible(true);

//export functions
		exportIncomeReportButton = new JButton("Export Report");
		exportIncomeReportButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		exportIncomeReportButton.setBounds(50, 60, 150, 35);
		exportIncomeReportButton.setFocusable(false);
		exportIncomeReportButton.addActionListener(this);
		exportIncomeReportButton.setVisible(true);

		String[] typeList = { "Primary", "Secondary", "Other", "All" };
		typeSorter = new JComboBox(typeList);
		typeSorter.setFont(new Font("Courier New", Font.PLAIN, 13));
		typeSorter.setBounds(270, 25, 120, 30);
		typeSorter.setVisible(true);

		IncomeDetailsTextArea = new JTextArea();
		IncomeDetailsTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		IncomeDetailsTextArea.setEditable(false); // Set the text area as non-editable
		JScrollPane incomePane = new JScrollPane(IncomeDetailsTextArea);
		incomePane.setBounds(30, 110, 400, 430);

		incomeOverviewLabel = new JLabel();
		incomeOverviewLabel.setBounds(110, 300, 500, 500);
		incomeOverviewLabel.setText("Total Compounded Income:");
		incomeOverviewLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		incomeOverviewLabel.setForeground(Color.white);
		incomeOverviewLabel.setVisible(true);

		fullIncomeOverviewPanel.add(fullIncomeHomeButton);
		fullIncomeOverviewPanel.add(fullIncomeReporter);
		fullIncomeOverviewPanel.add(typeSorter);
		fullIncomeOverviewPanel.add(incomePane);
		fullIncomeOverviewPanel.add(exportIncomeReportButton);
		fullIncomeOverviewPanel.add(incomeOverviewLabel);

		fullExpenseOverviewPanel.add(exportExpenseReportButton);

//add to window
		getContentPane().add(startPanel);
		getContentPane().add(conPanel);
		getContentPane().add(expensePanel);
		getContentPane().add(incomePanel);
		getContentPane().add(summaryOverviewPanel);
		getContentPane().add(fullExpenseOverviewPanel);
		getContentPane().add(fullIncomeOverviewPanel);
		getContentPane().add(savePanel);
		getContentPane().add(detailedSummaryPanel);
		getContentPane().add(createAccPanel);

		expenseOverviewLabel = new JLabel();
		expenseOverviewLabel.setBounds(110, 295, 500, 500);
		expenseOverviewLabel.setText("Total Compounded Expenses:");
		expenseOverviewLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		expenseOverviewLabel.setForeground(Color.white);
		expenseOverviewLabel.setVisible(true);

//VIEW EXPENSE BY TYPE
		expenseTypeOverviewPanel = new JPanel();
		expenseTypeOverviewPanel.setBackground(Color.black);
		expenseTypeOverviewPanel.setBounds(0, 0, 455, 600);
		expenseTypeOverviewPanel.setLayout(null);
		expenseTypeOverviewPanel.setVisible(false);

		typeExpenseHomeButton = new JButton("Home");
		typeExpenseHomeButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		typeExpenseHomeButton.setBounds(130, 10, 200, 35);
		typeExpenseHomeButton.setFocusable(false);
		typeExpenseHomeButton.addActionListener(this);
		typeExpenseHomeButton.setVisible(true);

		expenseTypeDetailsTextArea = new JTextArea(400, 400);
		expenseTypeDetailsTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		expenseTypeDetailsTextArea.setEditable(false);
		JScrollPane expensetypePane = new JScrollPane(expenseTypeDetailsTextArea);
		expensetypePane.setBounds(30, 100, 400, 410);

		expenseTypeLabel = new JLabel();
		expenseTypeLabel.setBounds(40, 40, 110, 65);
		expenseTypeLabel.setText("Sort By Type:");
		expenseTypeLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		expenseTypeLabel.setForeground(Color.white);
		expenseTypeLabel.setVisible(true);

		expenseTypeOverviewLabel = new JLabel();
		expenseTypeOverviewLabel.setBounds(110, 295, 500, 500);
		expenseTypeOverviewLabel.setText("Total Compounded Expenses:");
		expenseTypeOverviewLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		expenseTypeOverviewLabel.setForeground(Color.white);
		expenseTypeOverviewLabel.setVisible(true);

		String[] expenseSortList = { "Transportation", "Bills", "Recreational", "Grocery" };
		expenseSortItems = new JComboBox(expenseSortList);
		expenseSortItems.setFont(new Font("Courier New", Font.PLAIN, 13));
		expenseSortItems.setBounds(150, 55, 165, 35);
		expenseSortItems.setVisible(true);
		expenseSortItems.setSelectedIndex(0);

		sortTypeSubmitButton = new JButton("Submit!");
		sortTypeSubmitButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		sortTypeSubmitButton.setBounds(330, 60, 100, 25);
		sortTypeSubmitButton.setFocusable(false);
		sortTypeSubmitButton.addActionListener(this);
		sortTypeSubmitButton.setVisible(true);

//add to window

		getContentPane().add(startPanel);
		getContentPane().add(conPanel);
		getContentPane().add(expensePanel);
		getContentPane().add(incomePanel);
		getContentPane().add(summaryOverviewPanel);
		getContentPane().add(fullExpenseOverviewPanel);
		getContentPane().add(savePanel);
		getContentPane().add(expenseTypeOverviewPanel);
		getContentPane().add(detailedSummaryPanel);
		getContentPane().add(createAccPanel);
		getContentPane().add(loginPanel);

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
		expensePanel.add(importExpenseButton);

//full expense overview report
		fullExpenseOverviewPanel.add(fullExpenseHomeButton);
		fullExpenseOverviewPanel.add(expenseOverviewLabel);
		fullExpenseOverviewPanel.add(expensePane);

//expense report by type
		expenseTypeOverviewPanel.add(typeExpenseHomeButton);
		expenseTypeOverviewPanel.add(expensetypePane);
		expenseTypeOverviewPanel.add(expenseTypeLabel);
		expenseTypeOverviewPanel.add(expenseTypeOverviewLabel);
		expenseTypeOverviewPanel.add(expenseSortItems);
		expenseTypeOverviewPanel.add(sortTypeSubmitButton);

//detailed summary report
		detailedSummaryPanel.add(detailedSummaryPane);
		detailedSummaryPanel.add(detailedSummaryHomeButton);

///summary report overview menu
		summaryOverviewPanel.add(summaryHomeButton);
		summaryOverviewPanel.add(fullExpenseReportsButton);
		summaryOverviewPanel.add(fullIncomeReportsButton);
		summaryOverviewPanel.add(itemSave);
		summaryOverviewPanel.add(expenseByTypeButton);
		summaryOverviewPanel.add(detailedSummaryButton);

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
		startPanel.add(createAccountButton);
		startPanel.add(loginButton);

//define start window
		this.setSize(455, 600);
		this.setTitle("E-Wallet");
		getContentPane().setLayout(new BorderLayout(10, 10));
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/// ACTIONS EVENTS +
	/// LOGIC/////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		// Controls the buttons when pressed
		if (e.getSource() == createAccountButton) {
			try {
				createAccWindow();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == createAccountBtn) {
			if (addUsernameFld.getText().equals("") && addPasswordFld.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Username and password field are empty!","E-WALLET - Warning Message", JOptionPane.WARNING_MESSAGE);
			}
			else if(addUsernameFld.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Username field is empty!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else if(addPasswordFld.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Password field is empty!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else if(confPasswordFld.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Please confirm your password!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (queryForItem("\"User\"", "username", addUsernameFld.getText())) {
					JOptionPane.showMessageDialog(this, "Username already in use!", "E-WALLET Authentication Service", JOptionPane.INFORMATION_MESSAGE);
					addUsernameFld.setText("");
					addPasswordFld.setText("");
					confPasswordFld.setText("");
				}
				else if (!addPasswordFld.getText().equals(confPasswordFld.getText())) {
					JOptionPane.showMessageDialog(this, "Passwords do not match!", "E-WALLET Authentication Service", JOptionPane.INFORMATION_MESSAGE);
					addUsernameFld.setText("");
					addPasswordFld.setText("");
					confPasswordFld.setText("");
				}
				else {
					addUser(addUsernameFld.getText(), addPasswordFld.getText(), countRowsInTable() + 1);
					JOptionPane.showMessageDialog(this, "Account Created Succesfully!", "E-WALLET Authentication Service", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (e.getSource() == addExpense) {
			try {
				expenseWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource() == loginButton) {
			try {
				showLoginPanel();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}

		}

		if(e.getSource() == loginHomeButton) {
			try {
				screenReset();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		if(e.getSource() == loginToAccountButton) {
			if (loginAttempts > MAX_LOGIN_ATTEMPTS) {
				System.exit(0);
			}
			if(loginUsernameField.getText().equals("") && loginPasswordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Username and password field are empty!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else if(loginUsernameField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Username field is empty!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else if(loginPasswordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Password field is empty!","E-WALLET - Warning Message",JOptionPane.WARNING_MESSAGE);
			}
			else {
				if(queryForItem("\"User\"","username",loginUsernameField.getText())) {
					try {
						int userID = Integer.parseInt(queryForAdjacentItem("\"User\"", "username", "ID", loginUsernameField.getText()));
						if (loginPasswordField.getText().equals(queryForAdjacentItem("\"User\"","ID","password",String.valueOf(userID)))) {
							JOptionPane.showMessageDialog(this, "Login Successful","E-WALLET Authentication Service",JOptionPane.INFORMATION_MESSAGE);
							loginUsernameField.setText("");
							loginPasswordField.setText("");
							loginAttempts = 0;
						} else {
							JOptionPane.showMessageDialog(this, "Incorrect Credentials","E-WALLET Authentication Service",JOptionPane.INFORMATION_MESSAGE);
							loginAttempts++;
						}
					} catch (NumberFormatException numberFormatException) {
						System.out.println(numberFormatException.getMessage());
					}
				}
			}
		}

		if (e.getSource() == expenseSubmitButton) {
			Object selectedExpense = expenseSelectOne.getSelectedItem();
			String expenseOne = selectedExpense.toString();

			if (expenseOne.equals("Transportation")) {
				expenseSelectTwo.setVisible(true);

				expenseAddtionalLabel.setText("Enter Additional Information:");
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

			} else if (expenseOne.equals("Bills")) {
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

			} else if (expenseOne.equals("Recreational")) {
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

			} else if (expenseOne.equals("Grocery")) {
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

		if (e.getSource() == addtionalInfoSubmitButton) {
			try {
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
				if (amount >= 0.01D) {
					Expenser.addExpense(selectedExpenseOne, selectedExpenseTwo, amount, selectedFrequency);

					JOptionPane.showMessageDialog(this, selectedExpenseTwo + " expense for " +
							String.format("$%.2f added.",amount), "Success", JOptionPane.INFORMATION_MESSAGE);

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
				} else {
					throw new Exception("Invalid amount.");
				}
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this, "Please enter a valid submission.", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (e.getSource() == addIncome) {

			try {
				incomeWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == enterIncome) {
			try {
				String selectedincomeType = incomeType.getSelectedItem().toString();
				double cashflow = Double.parseDouble(incomeText.getText());

				if (cashflow >= 0.01d) {
					JOptionPane.showMessageDialog(this,
							"Adding " + selectedincomeType + " income for " + String.format("$%.2f",cashflow) + " successful.",
							"Income Added", JOptionPane.INFORMATION_MESSAGE);
					Expenser.addIncome(selectedincomeType, cashflow);
					System.out.println("You entered the " + incomeType.getSelectedItem() + " type income with $"
							+ incomeText.getText() + ".");
				} 
				else { 
					throw new Exception("Invalid input.");
				}
				
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this, "Please enter a valid submission.", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// want to enter information into an array, then enter it into a display into
		// viewer
		// WILL ONLY ENTER INTO AN ARRAY BASED ON TYPE FOR NOW
		if (e.getSource() == currencyConv) {
			try {
				convertWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == expenseByTypeButton) {
			try {
				expenseTypeOverviewWindow();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == sortTypeSubmitButton) {

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

				expenseTypeDetailsTextArea.append("------------------------------------------\n");
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

					expenseDetailsTextArea.append("---------------------------------------------\n");
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

			if (typeSorter.getSelectedIndex() != 3) {
				String selectedinType = typeSorter.getSelectedItem().toString();
				System.out.print(selectedinType);
//expenseTypeDetailsTextArea
				IncomeDetailsTextArea.setText("");

				List<Map<String, Object>> filteredIncome = Expenser.PrintIncomereportbyType(selectedinType);

				for (Map<String, Object> incomeDetailsMap : filteredIncome) {
					String category = (String) incomeDetailsMap.get("Type");
					double amount = (double) incomeDetailsMap.get("Income");

					IncomeDetailsTextArea.append("Type: " + category + "\n");
					IncomeDetailsTextArea.append("Income: " + amount + "\n");
					IncomeDetailsTextArea.append("------------------------------------------\n");
				}

				double totalIncome = 0;
				for (Map<String, Object> IncomeDetailsMap : filteredIncome) {
					double amount = (double) IncomeDetailsMap.get("Income");
					totalIncome += amount;
				}

				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				String formattedTotalIncome = decimalFormat.format(totalIncome);

				if (totalIncome > 0) {
					incomeOverviewLabel.setText("Total Compounded Income: " + formattedTotalIncome);
				} else {
					incomeOverviewLabel.setText("Total Compounded Income: " + formattedTotalIncome);
				}
			} else {
				IncomeDetailsTextArea.setText("");

				List<Map<String, Object>> incomeAmount = Expenser.PrintIncomereport();

				// Iterate over the expenses list and append details to the text area
				for (Map<String, Object> incomeDetailsMap : incomeAmount) {
					String category = (String) incomeDetailsMap.get("Type");
					double amount = (double) incomeDetailsMap.get("Income");

					IncomeDetailsTextArea.append("Type: " + category + "\n");
					IncomeDetailsTextArea.append("Income: " + amount + "\n");
					IncomeDetailsTextArea.append("------------------------------------------\n");
				}

				double totalIncome = 0;
				for (Map<String, Object> IncomeDetailsMap : incomeAmount) {
					double amount = (double) IncomeDetailsMap.get("Income");
					totalIncome += amount;
				}

				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				String formattedTotalIncome = decimalFormat.format(totalIncome);

				if (totalIncome > 0) {
					incomeOverviewLabel.setText("Total Compounded Income: " + formattedTotalIncome);
				} else {
					incomeOverviewLabel.setText("Total Compounded Income: " + formattedTotalIncome);
				}
			}

		}

		if (e.getSource() == savePanelSubmit) {
			try {
				double currMonthlySavings = Expenser.updateMonthlySavings();
				double currAmount = Double.parseDouble(saveAmountText.getText());
				double currRes = (currAmount + Expenser.getAnnualExpenseTotal(currAmount)) / currMonthlySavings;

				// Format currRes to one decimal place
				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				String formattedRes = decimalFormat.format(currRes);

				if (currRes >= 0.01 && currAmount >= 0.01) {
					saveResLabel.setText("Estimated Months to Save: " + formattedRes);
					saveResLabel.setText("Estimated Months to Save: " + formattedRes);

				} else {
					saveAmountText.setText("");
					throw new Exception("Less than penny or negative value entered.");
				}
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this, "Please enter a valid submission.", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == detailedSummaryButton) {

			try {

				detailedSummaryTextArea.setText("");

				detailedSummaryOverviewWindow();

				List<Map<String, Object>> incomeAmount = Expenser.PrintIncomereport();

				List<Map<String, Object>> expensesList = Expenser.PrintExpensereport();

				// Iterate over the expenses list and append details to the text area

				for (Map<String, Object> incomeDetailsMap : incomeAmount) {

					if (typeSorter.getSelectedIndex() == 0) {

						if ((String) incomeDetailsMap.get("Type") == "Primary") {

							String intype = (String) incomeDetailsMap.get("Type");

							double inamount = (double) incomeDetailsMap.get("Income");

							// Append expense details to the text area

							detailedSummaryTextArea.append("Income Type: " + intype + "\n");

							detailedSummaryTextArea.append("Income Amount: " + inamount + "\n");

							detailedSummaryTextArea.append("------------------------------------------\n");

						}

					}

					else if (typeSorter.getSelectedIndex() == 1) {

						if ((String) incomeDetailsMap.get("Type") == "Secondary") {

							String intype = (String) incomeDetailsMap.get("Type");

							double inamount = (double) incomeDetailsMap.get("Income");

							// Append expense details to the text area

							detailedSummaryTextArea.append("Income Type: " + intype + "\n");

							detailedSummaryTextArea.append("Income Amount: " + inamount + "\n");

							detailedSummaryTextArea.append("------------------------------------------\n");

						}

					}

					else if (typeSorter.getSelectedIndex() == 2) {

						if ((String) incomeDetailsMap.get("Type") == "Other") {

							String intype = (String) incomeDetailsMap.get("Type");

							double inamount = (double) incomeDetailsMap.get("Income");

							// Append expense details to the text area

							detailedSummaryTextArea.append("Income Type: " + intype + "\n");

							detailedSummaryTextArea.append("Income Amount: " + inamount + "\n");

							detailedSummaryTextArea.append("------------------------------------------\n");

						}

					}

					else if (typeSorter.getSelectedIndex() == 3) {

						String intype = (String) incomeDetailsMap.get("Type");

						double inamount = (double) incomeDetailsMap.get("Income");

						// Append expense details to the text area

						detailedSummaryTextArea.append("Income Type: " + intype + "\n");

						detailedSummaryTextArea.append("Income Amount: " + inamount + "\n");

						detailedSummaryTextArea.append("------------------------------------------\n");

					}

				}

				// Iterate over the expenses list and append details to the text area

				for (Map<String, Object> expenseDetails : expensesList) {

					String category = (String) expenseDetails.get("Category");

					String subcategory = (String) expenseDetails.get("Subcategory");

					double amount = (double) expenseDetails.get("Amount");

					String frequency = (String) expenseDetails.get("Frequency");

					// Append expense details to the text area

					detailedSummaryTextArea.append("Category: " + category + "\n");

					detailedSummaryTextArea.append("Subcategory: " + subcategory + "\n");

					detailedSummaryTextArea.append("Amount: " + amount + "\n");

					detailedSummaryTextArea.append("Frequency: " + frequency + "\n");

					detailedSummaryTextArea.append("------------------------------------------\n");

				}

			} catch (IOException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();

			}

		}

		if (e.getSource() == detailedSummaryHomeButton) {
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == viewSummary) {
			try {
				Expenser.updateMonthlySavings();
				SummaryWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == convertButton) { // converts currency
			try {
				Object selectedConversionOne = currSelectOne.getSelectedItem(); // getting the selected option
				String currOne = selectedConversionOne.toString(); // converting to a string to pass variable
				Object selectedConversionTwo = currSelectTwo.getSelectedItem();
				String currTwo = selectedConversionTwo.toString();

				String ammountToConvert = convertText.getText();
				double convertAmmount = Double.parseDouble(ammountToConvert);
				double converResults = Expenser.convertForeignCurrency(currOne, currTwo, convertAmmount);
				currResultLabel.setText(currTwo + ": " + converResults);
				currResultLabel.setVisible(true);
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "Please enter a valid submission.", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == homeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == createAccHomeBtn) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == expenseHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == incomeHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == summaryHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == fullExpenseHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == fullIncomeHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == savePanelHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == itemSave) { // resets to home screen
			try {
				saveScreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == typeExpenseHomeButton) { // resets to home screen
			try {
				screenReset();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == importExpenseButton) {

			try {
				fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Text Files (*.txt)","txt"));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);

				int fileChooserChoice = fileChooser.showOpenDialog(this);

				if (fileChooserChoice == JFileChooser.APPROVE_OPTION) {
					Expenser.addExpensesFromFile(fileChooser.getSelectedFile().getAbsolutePath());

					JOptionPane.showMessageDialog(this, "Expense added! Look in Console for details!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (fileChooserChoice == JFileChooser.CANCEL_OPTION){
					JOptionPane.showMessageDialog(this, "File selection canceled.", "Canceled",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, "Error importing expenses from the file!", "Error",
						JOptionPane.ERROR_MESSAGE);

				ex.printStackTrace();

			}

		}

		if (e.getSource() == importIncomeButton) {

			try {
				fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Text Files (*.txt)","txt"));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);

				int fileChooserChoice = fileChooser.showOpenDialog(this);

				if (fileChooserChoice == JFileChooser.APPROVE_OPTION) {
					Expenser.addIncomesFromFile(fileChooser.getSelectedFile().getAbsolutePath());

					JOptionPane.showMessageDialog(this, "Income added! Look in Console for details!", "Success",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (fileChooserChoice == JFileChooser.CANCEL_OPTION){
					JOptionPane.showMessageDialog(this, "File selection canceled.", "Canceled",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, "Error importing incomes from the file!", "Error",
						JOptionPane.ERROR_MESSAGE);

				ex.printStackTrace();

			}

		}

		if (e.getSource() == exportIncomeReportButton) {

			String fileName = "incomeoutput.txt";
			String homeDirectory = System.getProperty("user.home");
			String filePath = Paths.get(homeDirectory, fileName).toString();
			List<Map<String, Object>> incomeAmount = Expenser.PrintIncomereport();
			Expenser.exportMapListToTxt(incomeAmount, filePath);
		}

		if (e.getSource() == exportExpenseReportButton) {

			String fileName = "exportoutput.txt";
			String homeDirectory = System.getProperty("user.home");
			String filePath = Paths.get(homeDirectory, fileName).toString();
			List<Map<String, Object>> expensesList = Expenser.PrintExpensereport();
			Expenser.exportMapListToTxt(expensesList, filePath);
		}
	}

	/**
	 * Generic method used to look for data in a unique column in a table.
	 * For example, this can be used to look in a user table for a username column that has the username "Thomas" in it.  The method will
	 * @param tableName name of the table
	 * @param columnName name of the column to look at
	 * @param textToLookFor specific text data to search for
	 * @return true if text is found, false otherwise.
	 */
	private static boolean queryForItem(String tableName, String columnName, String textToLookFor) {
		try (Connection conn = DriverManager.getConnection(derbyEmbeddedURL); PreparedStatement preparedStatement = conn.prepareStatement("SELECT " + columnName + " FROM " + tableName + " WHERE " + columnName + " = ?");
		){
			preparedStatement.setString(1, textToLookFor);
			ResultSet results = preparedStatement.executeQuery();
			if(results.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to get adjacent data in a database table row.
	 * For example, this could be used to look for usernames in the User table and get the userID of the user with that username.
	 * @param tableName name of table
	 * @param initialColumn column to look for text in
	 * @param adjacentColumn column to get text from
	 * @param initialColumnText text to find in initialColumn
	 * @return text that is in adjacent column.
	 */
	private static String queryForAdjacentItem(String tableName, String initialColumn, String adjacentColumn, String initialColumnText) {
		try (Connection conn = DriverManager.getConnection(derbyEmbeddedURL); PreparedStatement preparedStatement = conn.prepareStatement(
				"SELECT " + initialColumn + ", " + adjacentColumn + " FROM " + tableName + " WHERE " + initialColumn + " = ?");
		) {
			preparedStatement.setString(1, initialColumnText);
			ResultSet results = preparedStatement.executeQuery();
			if (results.next()) {
				return results.getString(adjacentColumn);
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void addUser(String username, String password, int userID) {
		String sql = "INSERT INTO \"User\" VALUES (?,?,?)";
		
		try (Connection conn = DriverManager.getConnection(derbyEmbeddedURL); PreparedStatement preparedStmt = conn.prepareStatement(sql)) {
			preparedStmt.setInt(1, userID);
			preparedStmt.setString(2, username);
			preparedStmt.setString(3, password);
			preparedStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected static int countRowsInTable() {
        try (Connection conn = DriverManager.getConnection(derbyEmbeddedURL); PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT COUNT(*) FROM \"User\"");
        ) {
            ResultSet results = preparedStatement.executeQuery();
            if (results.next()) {
                return results.getInt(1);
            }
			return 0;
        } catch (SQLException sqlException) {
		sqlException.printStackTrace();
                return 0;
        }
    }


	/////////////////////////////////////////////////////////////////

	// function to reset screen to base window, anytime you add a button on another
	// window, set it to false here so when we add a back to home button, it makes
	// it invisible.
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
		detailedSummaryPanel.setVisible(false);
		loginPanel.setVisible(false);
		createAccPanel.setVisible(false);
	}

	public static void createAccWindow() throws IOException {
		startPanel.setVisible(false);
		createAccPanel.setVisible(true);

	}

	public static void convertWindow() throws IOException {
		// hiding original screen
		startPanel.setVisible(false);

		// making conversion screen
		conPanel.setVisible(true);

	}

	public static void incomeWindow() throws IOException {
		incomePanel.setVisible(true);
		startPanel.setVisible(false);
		conPanel.setVisible(false);
		expensePanel.setVisible(false);

	}

	public static void SummaryWindow() throws IOException {
		// hiding original screen
		startPanel.setVisible(false);

		// making conversion screen
		summaryOverviewPanel.setVisible(true);

	}

	public static void expenseWindow() throws IOException {
		// hiding original screen
		startPanel.setVisible(false);

		// making conversion screen
		expensePanel.setVisible(true);

	}

	public static void expenseOverviewWindow() throws IOException {
		// hiding original screen
		summaryOverviewPanel.setVisible(false);

		// making conversion screen
		fullExpenseOverviewPanel.setVisible(true);

	}

	public static void detailedSummaryOverviewWindow() throws IOException {

		summaryOverviewPanel.setVisible(false);

		detailedSummaryPanel.setVisible(true);
	}

	public static void incomeOverviewWindow() throws IOException {
		// hiding original screen
		summaryOverviewPanel.setVisible(false);

		// making conversion screen
		fullIncomeOverviewPanel.setVisible(true);

	}

	public static void expenseTypeOverviewWindow() throws IOException {
		// hiding original screen
		summaryOverviewPanel.setVisible(false);

		// making conversion screen
		expenseTypeOverviewPanel.setVisible(true);

	}

	public static void saveScreen() throws IOException {
		// hiding original screen
		summaryOverviewPanel.setVisible(false);

		// making conversion screen
		savePanel.setVisible(true);

	}

	public static void showLoginPanel() throws IOException {
		// hiding original screen
		startPanel.setVisible(false);

		// showing login screen
		loginPanel.setVisible(true);
	}
}
