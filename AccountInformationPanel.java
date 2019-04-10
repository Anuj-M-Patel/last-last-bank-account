import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountInformationPanel extends JPanel {

	public AccountInformationPanel(BankAccount bankAccount, CardLayout layout, JPanel overall) {
	GridBagConstraints constraints = new GridBagConstraints();
		GridBagLayout gridLayout = new GridBagLayout();
		setLayout(gridLayout);
		
		JLabel idLabel = new JLabel("Account ID: " + bankAccount.getAccountNumber());
		JLabel balanceLabel = new JLabel("Balance: $" + bankAccount.getBalance());
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				layout.show(overall, "");
				
			}
			
		});
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		add(idLabel, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(balanceLabel, constraints);
	}
	
}
