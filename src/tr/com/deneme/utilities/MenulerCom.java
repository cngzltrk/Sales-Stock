package tr.com.deneme.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.deneme.dal.AccountsDAL;
import tr.com.deneme.frontend.AnaPencereFE;
import tr.com.deneme.frontend.KategoriEkleFE;
import tr.com.deneme.frontend.LoginFE;
import tr.com.deneme.frontend.MusteriEkleFE;
import tr.com.deneme.frontend.PersonelEkleFE;
import tr.com.deneme.frontend.SehirEkleFE;
import tr.com.deneme.frontend.SifreBelirleFE;
import tr.com.deneme.frontend.UrunEkleFE;
import tr.com.deneme.frontend.YetkiEkleFE;
import tr.com.deneme.types.PersonelContract;


public class MenulerCom {
	
	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();
		JMenu dosyaMenu=new JMenu("Dosya");
		JMenuItem cikisItem=new JMenuItem("Çıkış");
		dosyaMenu.add(cikisItem);
		bar.add(dosyaMenu);
		
		JMenu urunlerMenu=new JMenu("Ürünler");
		JMenuItem urunEkleItem=new JMenuItem("Ürün Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem=new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem=new JMenuItem("Ürün Düzünle");
		urunlerMenu.add(urunDuzenleItem);
		JMenuItem kategoriDuzenleItem=new JMenuItem("Kategori Düzünle");
		urunlerMenu.add(kategoriDuzenleItem);
		bar.add(urunlerMenu);
		
		JMenu personellerMenu=new JMenu("Personeller");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem=new JMenuItem("Personel ekle");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem=new JMenuItem("Yetki Ekle");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem=new JMenuItem("Şifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();
		JMenuItem personelDüzenleItem=new JMenuItem("Personel Düzenle");
		personellerMenu.add(personelDüzenleItem);
		JMenuItem yetkiDuzenleItem=new JMenuItem("Yetki Düzenle");
		personellerMenu.add(yetkiDuzenleItem);
		JMenuItem sifreDuzenleItem=new JMenuItem("Şifre Düzenle");
		personellerMenu.add(sifreDuzenleItem);
		
		/*
		 * Müşteriler Menüsü
		 */
		JMenu musterilerMenu=new JMenu("Musteriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem=new JMenuItem("Müşteri ekle");
		musterilerMenu.add(musteriEkleItem);
		JMenuItem sehirEkleItem=new JMenuItem("Şehir ekle");
		musterilerMenu.add(sehirEkleItem);
		musterilerMenu.addSeparator();
		JMenuItem musteriDuzenleItem=new JMenuItem("Müşteri Düzenle");
		musterilerMenu.add(musteriDuzenleItem);
		
		PersonelContract contract=(PersonelContract) LoginFE.emailBox.getSelectedItem();
		
		if(new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==2)
		{
			personellerMenu.hide();
		}
		else if(new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==3)
		{
			musterilerMenu.hide();
			personellerMenu.hide();
			urunlerMenu.hide();
		}
		urunEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new UrunEkleFE();
						
					}
				});
				
			}
		});
		
		kategoriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new KategoriEkleFE();
				
			}
		});
		personelEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new PersonelEkleFE();
						
					}
				});
				
				
			}
		});
		yetkiEkleItem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SwingUtilities.invokeLater(new Runnable() {
							
							@Override
							public void run() {
								new YetkiEkleFE();
								
							}
						});
						
						
					}
				});
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new SifreBelirleFE();
						
					}
				});
				
				
			}
		});
		
		musteriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new MusteriEkleFE();
						
					}
				});
			}
		});
		sehirEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SehirEkleFE();
				
			}
		});
		cikisItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFE();
				
			}
		});
		
		return bar;
	}

}
