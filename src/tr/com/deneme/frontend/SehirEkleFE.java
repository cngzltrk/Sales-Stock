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

import tr.com.deneme.dal.KategoryDAL;
import tr.com.deneme.dal.SehirDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.SehirConract;

public class SehirEkleFE extends JDialog implements FeInterfaces {

	public SehirEkleFE()  {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel =initPanel();
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Şehir ekle"));
		
		setTitle("Şehir Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new GridLayout(2,2));
		JLabel adiLabel=new JLabel("Şehir adı");
		panel.add(adiLabel);
		JTextField adiField=new JTextField(20);
		panel.add(adiField);
		JButton kaydetButton=new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SehirConract contract=new SehirConract();
				
				contract.setSehir(adiField.getText());
				new SehirDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, "Sehir Eklendi");

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
