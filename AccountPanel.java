import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountPanel extends JPanel {

	public AccountPanel(ArrayList<BankAccount> bankAccounts) {
		
		GridBagConstraints constraints = new GridBagConstraints();
		GridBagLayout gridLayout = new GridBagLayout();
		setLayout(gridLayout);
		
		JLabel idLabel = new JLabel("Account ID");
		JTextField idInput = new JTextField();
		idInput.setPreferredSize(new Dimension(100, 25));
		JLabel statusLabel = new JLabel("");
		JButton button = new JButton("Get Account");
		button.setPreferredSize(new Dimension(150, 25));
		JButton findAccountButton = new JButton("Find Account");
		findAccountButton.setPreferredSize(new Dimension(150, 25));
		JLabel balanceLabel = new JLabel("");
		JButton backButton = new JButton("Back");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) {
					//statusLabel.setText("Account Not Found");
					repaint();
				}
				int givenID = 0;
				try {
					givenID = Integer.parseInt(idInput.getText());
				}
				catch(NumberFormatException e) {
					//statusLabel.setText("Account Not Found");
				}
				for (BankAccount bankAccount : bankAccounts) {
					if (bankAccount.getAccountNumber() == givenID) {
						
						constraints.insets = new Insets(5, 5, 5, 5);
						constraints.gridx = 0;
						constraints.gridy = 2;
						add(balanceLabel, constraints);
						constraints.gridx = 0;
						constraints.gridy = 3;
						add(backButton, constraints);
						idLabel.setText("Account ID: " + bankAccount.getAccountNumber());
						balanceLabel.setText("Balance: $" + bankAccount.getBalance());
						remove(button);
						remove(statusLabel);
						remove(idInput);
						remove(findAccountButton);
						repaint();
					}
					else {
						//statusLabel.setText("Account Not Found");
						repaint();
					}
				}
			}
		});
		
		findAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//overall.add(new FindAccountPanel(), "Find Account");
				//layout.show(overall, "Find Account");
				
			}
			
		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				idLabel.setText("Account ID");
				remove(balanceLabel);
				remove(backButton);
				//constraints.gridx = 0;
				//constraints.gridy = 1;
				constraints.insets = new Insets(5, 5, 5, 5);
				//add(idLabel, constraints);
				constraints.gridx = 1;
				constraints.gridy = 1;
				add(idInput, constraints);
				constraints.gridx = 0;
				constraints.gridy = 2;
				constraints.gridwidth = 2;
				add(button, constraints);
				constraints.gridx = 0;
				constraints.gridy = 0;
				constraints.gridwidth = 2;
				add(statusLabel, constraints);
				constraints.gridx = 0;
				constraints.gridy = 3;
				constraints.insets = new Insets(1, 1, 1, 1);
				constraints.gridwidth = 2;
				add(findAccountButton, constraints);
				repaint();
				
				
				
			}
			
		});
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		add(idLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(idInput, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		add(button, constraints);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		add(statusLabel, constraints);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.insets = new Insets(1, 1, 1, 1);
		constraints.gridwidth = 2;
		add(findAccountButton, constraints);
		
	}
	
}
