package tr.com.deneme.frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import datechooser.beans.editor.descriptor.BorderDescriptor;
import tr.com.deneme.complex.types.SatisContractComplex;
import tr.com.deneme.complex.types.StokContractComplex;
import tr.com.deneme.complex.types.StokSumContractComplex;
import tr.com.deneme.dal.MusteriDAL;
import tr.com.deneme.dal.SatisDAL;
import tr.com.deneme.dal.StokDAL;
import tr.com.deneme.dal.UrunlerDAL;
import tr.com.deneme.interfaces.FeInterfaces;
import tr.com.deneme.types.MusteriContract;
import tr.com.deneme.types.PersonelContract;
import tr.com.deneme.types.SatisContract;
import tr.com.deneme.types.StokContract;
import tr.com.deneme.types.UrunlerContract;
import tr.com.deneme.utilities.MenulerCom;

public class AnaPencereFE extends JFrame implements FeInterfaces{

	public AnaPencereFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel=initPanel();
		add(panel);
		JMenuBar bar=initBar();
		
		//add(tabs);
		setJMenuBar(bar);
		setTitle("Satiş ve Stok Programı");
		//pack();//içine konulacak buonları aynı boyutta yansıtır
		setSize(800, 400);
		setVisible(true);//görünürlük
		setLocationRelativeTo(null);// pencereyi ortalar
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		JTabbedPane pane =initTabs();
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = MenulerCom.initBar();
		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		JTabbedPane pane=new JTabbedPane();
		//ImageIcon icon= new ImageIcon("icons/stok.png");
		ImageIcon imageIcon = new ImageIcon("icons/stok.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		ImageIcon imageIcon2 = new ImageIcon("icons/stok2.png"); // load the image to a imageIcon
		Image image2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon2 = new ImageIcon(newimg2);
		
		JPanel stokPanel=new JPanel(new BorderLayout());
		JPanel satisPanel =new JPanel(new BorderLayout());
		
		
		/**
		 * Stok İşlemleri
		 */
		JPanel stokSolPanel=new JPanel(new BorderLayout());
		JPanel stokSolUstPanel= new JPanel(new GridLayout(5,2));
		JPanel stokSolAltPanel= new JPanel();
		
		stokSolUstPanel.setBorder(BorderFactory.createTitledBorder("Stok işlemleri"));
		Object[] stokKolonlar= {"Id","Personel Adı","Ürün Adı","Adet","Tarihi","Toplam"};
 		DefaultTableModel model=new DefaultTableModel(stokKolonlar,0);
		JTable table=new JTable(model);
		JScrollPane stokTablePane=new JScrollPane(table);
		
		for(StokContractComplex contract:new StokDAL().GetAllStok())
		{
			model.addRow(contract.getVeriler());
		}
		
		
		JLabel stokUrunAdiLabel=new JLabel("Ürün adı :",JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		JComboBox stokUrunAdiBox=new JComboBox(new UrunlerDAL().GetAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		JLabel stokAdetLabel=new JLabel("Adet :",JLabel.RIGHT);
		stokSolUstPanel.add(stokAdetLabel);
		JTextField stokAdetField=new JTextField(10);
		stokSolUstPanel.add(stokAdetField);
		JLabel stokTarihLabel=new JLabel("Stok Tarih :",JLabel.RIGHT);
		stokSolUstPanel.add(stokTarihLabel);
		JDateChooser stokTarihi=new JDateChooser();
		stokSolUstPanel.add(stokTarihi);
		
		JButton stokEkleButton=new JButton("Stok Ekle");
		stokSolUstPanel.add(stokEkleButton);
		JButton stokYenileButton=new JButton(" Yenile ");
		stokSolUstPanel.add(stokYenileButton);
		JButton stokToplamButton=new JButton(" Toplam Stok ");
		stokSolUstPanel.add(stokToplamButton);
		
		stokEkleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StokContract contract=new StokContract();
				UrunlerContract uContract=(UrunlerContract)stokUrunAdiBox.getSelectedItem();
				PersonelContract pContract=(PersonelContract) LoginFE.emailBox.getSelectedItem();
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				contract.setTarih(format.format(stokTarihi.getDate()));
				contract.setAdet(Integer.parseInt(stokAdetField.getText()));
				
				
				new StokDAL().Insert(contract);
				JOptionPane.showMessageDialog(null,uContract.getAdi()+ " Ürün eklenmiştir ");
				
				int satir=model.getRowCount();
				for (int i = satir- 1; i >=0; i--) {
					model.removeRow(i);
				}
				for(StokContractComplex cContract:new StokDAL().GetAllStok())
				{
					model.addRow(cContract.getVeriler());
				}
			}
		});
		stokYenileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int satir=model.getRowCount();
				for (int i = satir- 1; i >=0; i--) {
					model.removeRow(i);
				}
				for(StokContractComplex cContract:new StokDAL().GetAllStok())
				{
					model.addRow(cContract.getVeriler());
				}
			}
		});
		stokToplamButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int satir=model.getRowCount();
				for (int i = satir- 1; i >=0; i--) {
					model.removeRow(i);
				}
				for(StokSumContractComplex cContract:new StokDAL().GetSumStok())
				{
					model.addRow(cContract.getVeriler());
				}
			}
		});
		/**
		 * Satış işlemleri
		 */
		JPanel satisSagPanel=new JPanel(new BorderLayout());
		JPanel satisSagUstPanel= new JPanel(new GridLayout(5,2));
		JPanel satisSagAltPanel= new JPanel();
		
		satisSagUstPanel.setBorder(BorderFactory.createTitledBorder("Satış işlemleri"));
		Object[] satisKolonlar= {"Ekleme Tarihi","Personel Adı","Müşteri Adı","Ürün Adı","Adet","id"};
 		DefaultTableModel satisModel=new DefaultTableModel(stokKolonlar,0);
		JTable satisTable=new JTable(satisModel);
		JScrollPane satisTablePane=new JScrollPane(satisTable);
		
		for(SatisContractComplex cContract:new SatisDAL().GetAllSatis())
		{
			satisModel.addRow(cContract.getVeriler());
		}
		
		JLabel satisMusteriLabel=new JLabel("Müşteri adı :",JLabel.RIGHT);
		satisSagUstPanel.add(satisMusteriLabel);
		JComboBox satisMusteriAdiBox=new JComboBox(new MusteriDAL().GetAll().toArray());
		satisSagUstPanel.add(satisMusteriAdiBox);
		JLabel satisUrunAdiLabel=new JLabel("Ürün adı :",JLabel.RIGHT);
		satisSagUstPanel.add(satisUrunAdiLabel);
		JComboBox satisUrunAdiBox=new JComboBox(new UrunlerDAL().GetAll().toArray());
		satisSagUstPanel.add(satisUrunAdiBox);
		JLabel satisAdetLabel=new JLabel("Adet :",JLabel.RIGHT);
		satisSagUstPanel.add(satisAdetLabel);
		JTextField satisAdetField=new JTextField(10);
		satisSagUstPanel.add(satisAdetField);
		JLabel satisTarihLabel=new JLabel("Satış Tarih :",JLabel.RIGHT);
		satisSagUstPanel.add(satisTarihLabel);
		JDateChooser satisTarihi=new JDateChooser();
		satisSagUstPanel.add(satisTarihi);
		
		JButton satisEkleButton=new JButton("Satış Yap");
		satisSagUstPanel.add(satisEkleButton);
		JButton satisIptalButton=new JButton(" Yenile ");
		satisSagUstPanel.add(satisIptalButton);
		
		
		satisEkleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SatisContract contract=new SatisContract();
				PersonelContract pContract=(PersonelContract) LoginFE.emailBox.getSelectedItem(); 
				UrunlerContract uContract=(UrunlerContract) satisUrunAdiBox.getSelectedItem();
				MusteriContract mContract=(MusteriContract) satisMusteriAdiBox.getSelectedItem();
				
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setMusteriId(mContract.getId());
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				contract.setTarih(format.format(satisTarihi.getDate()));
				contract.setAdet(Integer.parseInt(satisAdetField.getText()));
				
				
				new SatisDAL().Insert(contract);
				
				StokContract sContract=new StokContract();
				sContract.setPersonelId(pContract.getId());
				sContract.setUrunId(uContract.getId());
				sContract.setTarih(format.format(satisTarihi.getDate()));
				sContract.setAdet(-Integer.parseInt(satisAdetField.getText()));
				
				
				new StokDAL().Insert(sContract);
				JOptionPane.showMessageDialog(null,uContract.getAdi()+ "satış  eklenmiştir ");
				
				int satir=satisModel.getRowCount();
				for (int i = satir- 1; i >=0; i--) {
					satisModel.removeRow(i);
				}
				for(SatisContractComplex cContract:new SatisDAL().GetAllSatis())
				{
					satisModel.addRow(cContract.getVeriler());
				}
				
			}
		});
		
		
		stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel,BorderLayout.SOUTH);
		
		satisSagPanel.add(satisSagUstPanel,BorderLayout.NORTH);
		satisSagPanel.add(satisSagAltPanel,BorderLayout.SOUTH);
		
		stokPanel.add(stokSolPanel,BorderLayout.WEST);
		stokPanel.add(stokTablePane,BorderLayout.CENTER);
		satisPanel.add(satisSagPanel,BorderLayout.EAST);
		satisPanel.add(satisTablePane,BorderLayout.CENTER);
		
		pane.addTab("Stoklar ", imageIcon,stokPanel,
				"Does nothing");
		pane.addTab("Satışlar",imageIcon2,satisPanel,"yazı");
		return pane;
	}
	public void closeWindow(){
        this.dispose();
   }

}
