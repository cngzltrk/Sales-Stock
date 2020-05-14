package tr.com.deneme.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import tr.com.deneme.dal.UrunlerDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.UrunlerContract;

public class UrunEkleFE extends JDialog implements FeInterfaces{

	public UrunEkleFE() {
		initPencere();
		
	}
	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Urun Kayıt Alanı"));

		setTitle("Ürün Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(5, 2));
		JLabel adiLabel=new JLabel("Adı :" ,JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField= new JTextField(10);
		panel.add(adiField);
		JLabel kategoriLabel=new JLabel("Kategori :" ,JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox=new JComboBox(new KategoryDAL().GetAll().toArray());
		panel.add(kategoriBox);
		JLabel tarihLabel=new JLabel("Tarih :" ,JLabel.RIGHT);
		panel.add(tarihLabel);
		JDateChooser tarihDate=new JDateChooser();
		panel.add(tarihDate);
		JLabel fiyatLabel=new JLabel("Fiyat :" ,JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatField=new JTextField();
		panel.add(fiyatField);
		
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton=new JButton("İptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract=new UrunlerContract();
				KategoryContract casContract=(KategoryContract) kategoriBox.getSelectedItem();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				contract.setAdi(adiField.getText());
				contract.setKategoriId(casContract.getId());
				contract.setTarih(format.format(tarihDate.getDate()));
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));
				
				new UrunlerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, "Ürün eklenmiştir");
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
