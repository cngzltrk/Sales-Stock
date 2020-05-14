package tr.com.deneme.frontend;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.deneme.dal.AccountsDAL;
import tr.com.deneme.dal.PersonelDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.PersonelContract;

public class LoginFE extends JDialog implements FeInterfaces{
	public static JComboBox emailBox;
	public LoginFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		
		JPanel panel =initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Lütfen giriş yapınız"));
		setTitle("Login");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel =new JPanel(new GridLayout(3,2));
		
		JLabel emailLabel=new JLabel("Email :",JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox=new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(emailBox);
		JLabel passLabel=new JLabel("Şifre :",JLabel.RIGHT);
		panel.add(passLabel);
		JPasswordField passField=new JPasswordField(15);
		panel.add(passField);
		JButton loginButton=new JButton("Giriş yap");
		panel.add(loginButton);
		JButton iptalButton=new JButton("İptal");
		panel.add(iptalButton);
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract=(PersonelContract)emailBox.getSelectedItem();
				if(new AccountsDAL().GetSingle(contract.getId(), passField.getText()).getId()!=0) {
					new AnaPencereFE();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Giriş başarısız");
				}
			}
		});
		
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
