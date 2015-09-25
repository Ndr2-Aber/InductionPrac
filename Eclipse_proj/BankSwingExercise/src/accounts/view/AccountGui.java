package accounts.view;

import util.View;
import util.Model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import accounts.controller.ControllerI;
import accounts.model.AccountI;

public class AccountGui extends View implements ActionListener {

	private Model account;
	ControllerI controller;
	private TextPanel textPanel = new TextPanel();
	private ButtonPanel buttonPanel = new ButtonPanel();

	public AccountGui(ControllerI controller, Model account) {
		this.account = account;
		this.controller = controller;

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				buildAccountGui();
			}
		});
	}

	public void update(Observable o, Object arg) {
		if (o instanceof AccountI) {
			double balance = ((AccountI) o).getBalance();
			textPanel.balanceField.setText("" + balance);
		}
	}

	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		controller.processUserAction(action);
	}

	private void buildAccountGui() {
		setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonPanel buttonPanel = new ButtonPanel();
		add(buttonPanel, BorderLayout.NORTH);

		textPanel = new TextPanel();
		add(textPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);

		registerWithModel(account);
	}

	public String getAmountFieldValue() {
		return textPanel.inputField.getText();
	}

	// ///////////////////////////////////////////////////////////////////////
	// ///////PRIVATE INNER CLASSES //////////////////////////////////////////

	public class ButtonPanel extends JPanel {
		public ButtonPanel() {
			JButton b = new JButton("Deposit");
			b.addActionListener(AccountGui.this);
			add(b);
			b = new JButton("Withdraw");
			b.addActionListener(AccountGui.this);
			add(b);
		}
	}

	public class TextPanel extends JPanel {
		private JTextField inputField;
		private JTextField balanceField;

		public TextPanel() {
			setLayout(new GridLayout(2, 2, 5, 5));
			add(new JLabel("Amount: "));
			inputField = new JTextField(8);
			add(inputField);

			add(new JLabel("Balance: "));
			balanceField = new JTextField(8);
			add(balanceField);

		}

	}

}
