package tr.com.deneme.frontend;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.deneme.dal.KategoryDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.KategoryContract;

public class KategoriEkleFE extends JDialog implements FeInterfaces {

	public KategoriEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Kayıt Alanı"));

		setTitle("Kategori	 Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(3, 2));
		JLabel adiLabel=new JLabel("Kategori Adı :" ,JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField= new JTextField(10);
		panel.add(adiField);
		
		JLabel kategoriLabel=new JLabel("Kategori Seç:",JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox=new JComboBox(new KategoryDAL().GetAllParentId().toArray());
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("--Kategori Seçiniz--", 0);
		kategoriBox.setSelectedIndex(0);
		
		
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KategoryContract contract=new KategoryContract();
				if(kategoriBox.getSelectedIndex()!=0)
				{
					KategoryContract casContract=(KategoryContract)kategoriBox.getSelectedItem();

					contract.setAdi(adiField.getText());
					contract.setParentId(casContract.getId());
					new KategoryDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, "Kategori Eklendi");
				}
				else
				{
					contract.setAdi(adiField.getText());
					contract.setParentId(0);
					new KategoryDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, "Kategori Eklendi");
					
					
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
