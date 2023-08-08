import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Expenser {

	public User userAtHand = null;

	public static List<Map<String, Object>> expensesList = new ArrayList<>();

	public static List<Map<String, Object>> incomeAmount = new ArrayList<>();
	public static double monthlyIncome = 0;

	public static void exportMapListToTxt(List<Map<String, Object>> mapList, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Map<String, Object> map : mapList) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					writer.write(entry.getKey() + "=" + entry.getValue());
					writer.newLine();
				}
				writer.newLine(); // Add an empty line between each map
			}
			System.out.println("Map list exported to " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// As a user I'd like to add a monthly expense so I can track and report my expenses - 3pts
	public static void addExpensesFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] expenseData = line.split(",");

				// Extract expense details from the line
				String category = expenseData[0].trim();
				String subcategory = expenseData[1].trim();
				double amount = Double.parseDouble(expenseData[2].trim());
				String frequency = expenseData[3].trim();

				// Call the addExpense function with the extracted details
				addExpense(category, subcategory, amount, frequency);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void addExpense(String category, String subcategory, double amount, String frequency) {
		Map<String, Object> expenseDetails = new HashMap<>();
		expenseDetails.put("Category", category);
		expenseDetails.put("Subcategory", subcategory);
		expenseDetails.put("Amount", amount);
		expenseDetails.put("Frequency", frequency);

		expensesList.add(expenseDetails);

		// Print expense details to console for confirmation
		System.out.println("Expense added:");
		System.out.println("Category: " + category);
		System.out.println("Subcategory: " + subcategory);
		System.out.println("Amount: " + amount);
		System.out.println("Frequency: " + frequency);
		System.out.println();
	}

	public static void addIncome(String intype, double income) {
		Map<String, Object> incomeDetailsMap = new HashMap<>();
		incomeDetailsMap.put("Type", intype);
		incomeDetailsMap.put("Income", income);

		System.out.println("Income added:");
		System.out.println("Type: " + intype);
		System.out.println("Amount: " + income);
		System.out.println();

		incomeAmount.add(incomeDetailsMap);

	}

	public static void addIncomesFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] incomeData = line.split(",");

				// Extract income details from the line
				String intype = incomeData[0].trim();
				double income = Double.parseDouble(incomeData[1].trim());

				// Call the addIncome function with the extracted details
				addIncome(intype, income);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//As  a user I would like to view a detailed report of all expenses, income, and summary information 
	//summary information include : total income, total income for each type, total income for each month, total expense, total expense for each type, 
	//total savings (total income- total expenses) to date, if the total savings are less than zero it should be reported as total new debt. 	
	public void PrintFullreport();

	//As  a user I would like to view a detailed report of all expenses, and summary information for expenses 
	public static List<Map<String, Object>> PrintExpensereport() {
		return expensesList;

	}

	//As  a user I would like to view a detailed report of all income, and summary information for income
	public static List<Map<String, Object>> PrintIncomereport() {
		return incomeAmount;

	}
	//As  a user I would like to view a detailed report of income of a certain type, and summary information for income

	public static List<Map<String, Object>> PrintIncomereportbyType(String type) {
		List<Map<String, Object>> filteredIncome = new ArrayList<>();

		for (Map<String, Object> incomeDetailsMap : incomeAmount) {
			String category = (String) incomeDetailsMap.get("Type");

			if (category.equals(type)) {
				filteredIncome.add(incomeDetailsMap);
			}
		}
		return filteredIncome;
	}

	//As  a user I would like to view a detailed report of expense of a certain type , and summary information for expenses
	public static List<Map<String, Object>> PrintExpensebyType(String type) {
		List<Map<String, Object>> filteredExpenses = new ArrayList<>();

		for (Map<String, Object> expenseDetails : expensesList) {
			String category = (String) expenseDetails.get("Category");

			if (category.equals(type)) {
				filteredExpenses.add(expenseDetails);
			}
		}
		return filteredExpenses;
	}

	// As a user I would like to choose a report and export it as an external file (any type is fine preferences are csv or JSON)
	public void exportReport(String reportTitle);

	//	As a user I would like to view my current balance in a different currency
	//Bonus : try to use the same convert function to convert from foreign currency to USD 
	public static double convertForeignCurrency(String currOne, String currTwo, Double ammount) {
		double USDtoEUR = 0.91270;
		double EURtoUSD = 1.09565;
		double CADtoEUR = 1.47065;
		double EURtoCAD = 0.67997;
		double USDtoCAD = 0.74490;
		double CADtoUSD = 1.34246;
		
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
	public int whenCanIBuy(String itemname, double price);

	// updates monthly savings based on latest added income and expenses. This is an internal function not called by the users.  Bonus: what is the most efficient way to call it (when?)?
	public static double updateMonthlySavings() {
		double monthlySavings = 0.0d;
		double monthlyBills = 0.0d;
		double monthlyIncome = 0.0d;
		double secondIncome = 0.0d;
		double primIncome = 0.0d;
		double otherIncome = 0.0d;

		//correction on keys

		for (Map<String, Object> income : incomeAmount) {
			if (income.containsKey("Income") && income.containsKey("Type")) {

				Object incomeAmount = income.get("Income");
				Object incomeType = income.get("Type");

				// Do something with the amount and frequency
				String incomeAsString = incomeType.toString();
				double monthlyIncomeAmount = (double) incomeAmount;

				System.out.println("Income: " + incomeAmount);
				System.out.println("Income Type: " + incomeType);

				if (incomeAsString.equals("Primary")) {

					primIncome += monthlyIncomeAmount;

				} else if (incomeAsString.equals("Secondary")) {

					secondIncome += monthlyIncomeAmount;

				} else {

					otherIncome += monthlyIncomeAmount;

				}

			}
		}
		monthlyIncome = otherIncome + secondIncome + primIncome;


		for (Map<String, Object> expense : expensesList) {
			if (expense.containsKey("Amount") && expense.containsKey("Frequency")) {

				double addVal = 0.0d;
				Object amount = expense.get("Amount");
				Object frequency = expense.get("Frequency");

				// Do something with the amount and frequency
				String compString = frequency.toString();
				double compAmount = (double) amount;

				System.out.println("Amount: " + amount);
				System.out.println("Frequency: " + frequency);
				System.out.println(compString);
				if (compString.equals("Monthly")) {
					System.out.println("Monthly cost: " + compAmount);
					monthlyBills += compAmount;

				}
				else if (compString.equals("Biweekly")) {

					addVal = compAmount * 2.0;
					monthlyBills += addVal;

				}

			}
		}
		System.out.println("Monthly Income: " + monthlyIncome);
		System.out.println("Monthly bills: " + monthlyBills);
		monthlySavings = monthlyIncome - monthlyBills;
		return monthlySavings;
	}

	static double getAnnualExpenseTotal(double amountToSaveFor) {

		double totalExpense = 0.0D;
		int years = 0;
		for (Map<String, Object> expense : expensesList) {
			if (expense.containsKey("Amount") && expense.containsKey("Frequency")) {

				Object amount = expense.get("Amount");
				Object frequency = expense.get("Frequency");

				String compString = frequency.toString();
				double compAmount = (double) amount;

				if (compString.equals("Annually")) {

					totalExpense += compAmount;
				}
			}
		}
		for (int i = 0; amountToSaveFor > ((updateMonthlySavings() * 12) * i); i++) {
			if (updateMonthlySavings() == 0) {
				break;
			}
			years++;
			System.out.println("Years: " + years);
		}

		if (amountToSaveFor > updateMonthlySavings() * 12) {
			return totalExpense * years;
		} else {
			return totalExpense;
		}
	}
}
	

		
	

