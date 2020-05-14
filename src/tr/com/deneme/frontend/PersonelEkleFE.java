package tr.com.deneme.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.deneme.dal.KategoryDAL;
import tr.com.deneme.dal.PersonelDAL;
import tr.com.deneme.dal.UrunlerDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.PersonelContract;
import tr.com.deneme.types.UrunlerContract;

public class PersonelEkleFE extends JDialog implements FeInterfaces {

	public PersonelEkleFE() {
		initPencere();
		
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Personel Kayıt Alanı"));

		setTitle("Personel Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(3, 2));
		JLabel adiLabel=new JLabel("Adı Soyadı:" ,JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiSoyadiField= new JTextField(15);
		panel.add(adiSoyadiField);
		JLabel emailLabel=new JLabel("Email :" ,JLabel.RIGHT);
		panel.add(emailLabel);
		JTextField emailField= new JTextField(15);
		panel.add(emailField);
		
		
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton=new JButton("İptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract=new PersonelContract();
				
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setEmail(emailField.getText());
				
				
				new PersonelDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, "Personel eklenmiştir");
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
