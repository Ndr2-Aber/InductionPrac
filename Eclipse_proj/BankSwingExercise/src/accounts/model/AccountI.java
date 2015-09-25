package accounts.model;

public interface AccountI {

	void deposit(double amount);

	double getBalance();

	void withdraw(double amount);
}
