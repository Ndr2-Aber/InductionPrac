package accounts.model;

import util.Model;

public class Account extends Model implements AccountI {

	private double balance = 0.0;

	public Account(double initBal) {
		setBalance(initBal);
	}

	private void setBalance(double amount) {
		balance = 0.0;
		deposit(amount);
	}

	public void withdraw(double amt) {
		balance -= amt;
		notifyChanged(new Double(balance));
	}

	public void deposit(double amt) {
		balance += amt;
		notifyChanged(new Double(balance));
	}

	public double getBalance() {
		return balance;
	}
}
