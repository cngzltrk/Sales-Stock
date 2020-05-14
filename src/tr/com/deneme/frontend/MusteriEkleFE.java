package tr.com.deneme.frontend;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tr.com.deneme.dal.KategoryDAL;
import tr.com.deneme.dal.MusteriDAL;
import tr.com.deneme.dal.SehirDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.MusteriContract;
import tr.com.deneme.types.SehirConract;

public class MusteriEkleFE extends JDialog implements FeInterfaces {

	public MusteriEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Musteri Kayıt Alanı"));

		setTitle("Müşteri Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		JPanel fieldPanel=new JPanel(new GridLayout(4, 2));
		JPanel buttonPanel=new JPanel(new GridLayout(1, 2));

		JLabel adiLabel=new JLabel("Adı Soyadı :" ,JLabel.RIGHT);
		fieldPanel.add(adiLabel);
		JTextField adiField= new JTextField(15);
		fieldPanel.add(adiField);
		
		JLabel telLabel=new JLabel("Telefon No:",JLabel.RIGHT);
		fieldPanel.add(telLabel);
		JTextField telField= new JTextField(15);
		fieldPanel.add(telField);
		JLabel sehirLabel=new JLabel("Sehir Seç:",JLabel.RIGHT);
		fieldPanel.add(sehirLabel);
		JComboBox sehirBox=new JComboBox(new SehirDAL().GetAll().toArray());
		fieldPanel.add(sehirBox);
		sehirBox.insertItemAt("--Sehir Seçiniz--", 0);
		sehirBox.setSelectedIndex(0);
		JLabel adresLabel=new JLabel("Adres:",JLabel.LEFT);
		fieldPanel.add(adresLabel);
		JTextArea adresArea= new JTextArea(4,1);
		JScrollPane pane=new JScrollPane(adresArea);
		panel.add(fieldPanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
		
		JButton kaydetButton=new JButton("Kaydet");
		buttonPanel.add(kaydetButton);

		JButton iptalButton=new JButton("İptal");
		buttonPanel.add(iptalButton);
		
		panel.add(buttonPanel,BorderLayout.SOUTH);

		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusteriContract contract=new MusteriContract();
				
					contract.setAdiSoyadi(adiField.getText());
					contract.setTelNo(telField.getText());
					SehirConract casContract=(SehirConract)sehirBox.getSelectedItem();

					contract.setSehirId(casContract.getId());
					contract.setAdres(adresArea.getText());
					new MusteriDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, "Musteri Eklendi");
					
				
				
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
