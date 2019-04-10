import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() {
		
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		bankAccounts.add(new CheckingAccount("Bob", 1, 1, 1));
		bankAccounts.add(new CheckingAccount("Hef", 2, 2, 2));
		
		setTitle("Bank Account");
		setBounds(100, 100, 400, 300);
		
		//MENU CHOICES
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem homeOption = new JMenuItem("Home");
		homeOption.setMaximumSize(new Dimension(0, 50));
		menuBar.add(homeOption);
		
		menuBar.add(Box.createHorizontalGlue());
		//menuBar.add(Box.createHorizontalGlue());
		
		JMenuItem accountOption = new JMenuItem("Account");
		accountOption.setMaximumSize(new Dimension(0, 50));
		menuBar.add(accountOption);
		
		JMenu transactionsMenu = new JMenu("Transactions");
		menuBar.add(transactionsMenu);
		
		JMenuItem depositOption = new JMenuItem("Deposit");
		transactionsMenu.add(depositOption);
		
		JMenuItem withdrawalOption = new JMenuItem("Withdrawl");
		transactionsMenu.add(withdrawalOption);
		
		JMenuItem transferOption = new JMenuItem("Transfer");
		transactionsMenu.add(transferOption);
		
		//LAYOUT
		CardLayout layout = new CardLayout();
		JPanel overall = new JPanel(layout);
		
		//HOME PANEL
		JPanel homePanel = new HomePanel();
		overall.add(homePanel, "Home");
		homeOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(overall, "Home");
			}
		});
		layout.show(overall, "Home");
		
		//ACCOUNT PANEL
		JPanel accountPanel = new AccountPanel(bankAccounts);
		overall.add(accountPanel, "Account");
		accountOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(overall, "Account");
			}
		});
			
		//DEPOSIT PANEL
		JPanel depositPanel = new DepositPanel();
		overall.add(depositPanel, "Deposit");
		depositOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(overall, "Deposit");
			}
		});
		
		//WITHDRAW PANEL
		JPanel withdrawPanel = new WithdrawPanel();
		overall.add(withdrawPanel, "Withdraw");
		withdrawalOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(overall, "Withdraw");
			}
		});
		
		//TRANSFER PANEL
		JPanel transferPanel = new TransferPanel();
		overall.add(transferPanel, "Transfer");
		transferOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(overall, "Transfer");
			}
		});
		
		add(overall);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Window();
		
	}

}
