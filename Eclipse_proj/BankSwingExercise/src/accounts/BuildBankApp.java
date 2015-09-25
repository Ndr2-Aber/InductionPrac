package accounts;

import accounts.controller.AccountController;
import accounts.model.Account;
import util.Model;

public class BuildBankApp {

	public static void main(String[] args) {
		Model account = new Account(0.0);
		new AccountController(account);

	}

}
