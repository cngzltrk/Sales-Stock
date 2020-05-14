package tr.com.deneme.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.deneme.dal.PersonelDAL;
import tr.com.deneme.dal.YetkilerDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.PersonelContract;
import tr.com.deneme.types.Yetkiler;

public class YetkiEkleFE extends JDialog implements FeInterfaces{

	public YetkiEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle Alanı"));

		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);// ekran kapanan kadar açık kalır.
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(2, 2));
		JLabel adiLabel=new JLabel("Yetki Adı:" ,JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField yetkiField= new JTextField(15);
		panel.add(yetkiField);
		
		
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton=new JButton("İptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Yetkiler contract=new Yetkiler();
				
				contract.setAdi(yetkiField.getText());
				
				
				new YetkilerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, "Yetki eklenmiştir");
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
