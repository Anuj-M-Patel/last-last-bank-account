import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	public HomePanel() {
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		//setLayout(null);
		GridBagConstraints constraint = new GridBagConstraints();
		
		JLabel label = new JLabel("bazz");

		constraint.gridx = 0;
		constraint.gridy = 0;
		//label.setBounds(0, 0, 50, 100);
		add(label, constraint);
		setVisible(true);
	}
	
}
