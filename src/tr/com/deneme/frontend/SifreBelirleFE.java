package tr.com.deneme.frontend;

import java.awt.GridLayout;
import java.awt.TextField;
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
import javax.swing.JTextField;

import tr.com.deneme.dal.AccountsDAL;
import tr.com.deneme.dal.KategoryDAL;
import tr.com.deneme.dal.PersonelDAL;
import tr.com.deneme.dal.YetkilerDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.AccountsContract;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.PersonelContract;
import tr.com.deneme.types.Yetkiler;

public class SifreBelirleFE extends JDialog implements FeInterfaces {

	public SifreBelirleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Sifre İslemleri Alanı"));

		setTitle("Şifre Belirle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(5, 2));
		JLabel personelLabel=new JLabel("Personeller :" ,JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox=new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelBox);
		personelBox.insertItemAt("--Personel Seçiniz--", 0);
		personelBox.setSelectedIndex(0);
		
		JLabel yetkiLabel=new JLabel("Yetkiler :",JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox=new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(yetkiBox);
		yetkiBox.insertItemAt("--Yetki Seçiniz--", 0);
		yetkiBox.setSelectedIndex(0);
		JLabel passLabel=new JLabel("Şifre :",JLabel.RIGHT);
		panel.add(passLabel);
		JPasswordField passField=new JPasswordField(15);
		panel.add(passField);
		JLabel passTekrarLabel=new JLabel("Şifre Tekrar :",JLabel.RIGHT);
		panel.add(passTekrarLabel);
		JPasswordField passTekrarField=new JPasswordField(15);
		panel.add(passTekrarField);
		
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountsContract contract=new AccountsContract();
				PersonelContract pContract=(PersonelContract) personelBox.getSelectedItem();
				Yetkiler yContract=(Yetkiler) yetkiBox.getSelectedItem();
				
				if(passField.getText().equals(passTekrarField.getText()))
				{
					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(passField.getText());
					
					new AccountsDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, "Şifre eklendi");

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Şifre Aynı değil");

				}
				//peceriyi yeniler
				//kategoriBox.removeAll();
				//kategoriBox;
				
			}
		});
		
		
		JButton iptalButton=new JButton("İptal");
		panel.add(iptalButton);
		
		
		
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
