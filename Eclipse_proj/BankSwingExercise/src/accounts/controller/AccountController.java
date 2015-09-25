package accounts.controller;

import accounts.model.AccountI;
import accounts.view.AccountGui;
import util.Model;

public class AccountController implements ControllerI {

	private AccountI model;
	private AccountGui view;

	public AccountController(Model model) {
		this.model = (AccountI) model;

		// Create GUI
		this.view = new AccountGui(this, model);
	}

	public void processUserAction(String action) {
		double amount = Double.valueOf(view.getAmountFieldValue());
		if (action.equals("Withdraw")) {
			model.withdraw(amount);
		} else if (action.equals("Deposit")) {
			model.deposit(amount);
		}

	}

}
