import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public interface Expenser {
	
	public User userAtHand = null;
	public Dictionary<String, String> expenseCategories = new Hashtable<>(); 
	public Dictionary<Double, String> expenseAmount = new Hashtable<>(); 
	//public Dictionary<String, String> incomeTypes = new Hashtable<>(); 
	public Dictionary<Double, String> incomeAmount = new Hashtable<>(); 
	
	
// As a user I'd like to add a monthly expense so I can track and report my expenses - 3pts
	public static void addExpense(String category, String subcategory, double amount, String frequency) { // ADDED
		expenseCategories.put(category, subcategory);
		expenseAmount.put(amount, frequency);
	
	}
	public static void addIncome(String intype, double income){
		incomeAmount.put(income,intype);
	}
	
	// As a user I'd like to add a monthly income so I can track and report my income all year - 3pts
	public void addMonthlyIncome (Wage W);
	//As  a user I would like to view a detailed report of all expenses, income, and summary information 
	//summary information include : total income, total income for each type, total income for each month, total expense, total expense for each type, 
	//total savings (total income- total expenses) to date, if the total savings are less than zero it should be reported as total new debt. 	
	public void PrintFullreport();
	//As  a user I would like to view a detailed report of all expenses, and summary information for expenses 
	public void PrintExpensereport();
	//As  a user I would like to view a detailed report of all income, and summary information for income
	public void PrintIncomereport();
	//As  a user I would like to view a detailed report of income of a certain type, and summary information for income
	public void PrintIncomereportbyTpe();
	//As  a user I would like to view a detailed report of expense of a certain type , and summary information for expenses
	public void PrintExpensebyType();
	// As a user I would like to choose a report and export it as an external file (any type is fine preferences are csv or JSON)
	public void exportReport(String reportTitle);
	//	As a user I would like to view my current balance in a different currency 
	//Bonus : try to use the same convert function to convert from foreign currency to USD 
	public static double convertForeignCurrency(String currOne, String currTwo, Double ammount) {
		double USDtoEUR = 0.915;
		double EURtoUSD = 1.0915;
		double CADtoEUR = 1.441;
		double EURtoCAD = 0.6934;
		double USDtoCAD = 0.7567;
		double CADtoUSD = 1.26;
		double conRate = 0;
		if (currOne.equals("USD")) {
			if (currTwo.equals("EUR")) {
				 conRate = USDtoEUR;
			} else if 
			(currTwo.equals("CAD")) {
				 conRate = USDtoCAD;
			}
		}
			if (currOne.equals("EUR")) {
				if (currTwo.equals("USD")) {
					 conRate = EURtoUSD;
				} else if 
				(currTwo.equals("CAD")) {
					 conRate = EURtoCAD;
				}
			}
				if (currOne.equals("CAD")) {
					if (currTwo.equals("EUR")) {
						 conRate = CADtoEUR;
					} else if 
					(currTwo.equals("USD")) {
						 conRate = CADtoUSD;
					}
			}
			if (conRate == 0.0) {
				conRate = 1.0;
			}
			
			double results = ammount * conRate;
			double roundedResult = Math.round(results * 100.0) / 100.0;
			return roundedResult;
			
	}
		
	//	As a user I would like to load multiple expenses from an external file all at once returning true if loaded successfully and false otherwise 
	public boolean loadExpenseFile(String filePath); 
	//	As a user I would like to load multiple income from an external file all at once returning true if loaded successfully and false otherwise 
	public boolean loadIncomeFile(String filePath); 	
	// As a user I would like to provide an item and a price and get an estimate in number of months needed to save up to buy this item. (based on current monthly saving. 
	public int whenCanIBuy(String itemname,double  price);
	// updates monthly savings based on latest added income and expenses. This is an internal function not called by the users.  Bonus: what is the most efficient way to call it (when?)? 
	public void updateMonthlySavings(); 
	
//add/update monthly income ability. add monthly expenses/names of them to two lists, to keep track of them for summary.
	
	
	
}
