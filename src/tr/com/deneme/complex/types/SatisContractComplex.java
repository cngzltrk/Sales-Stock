package tr.com.deneme.complex.types;

import java.sql.Date;

public class SatisContractComplex {

	private int id;
	private String musteriAdi;
	private String personelAdi;
	private String urunAdi;
	private int adet;
	private String tarih;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMüsteriAdi() {
		return musteriAdi;
	}
	public void setMüsteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public String getTarih() {
		return tarih;
	}
	public Object[] getVeriler()
	{
		Object[] data= {tarih,personelAdi,musteriAdi,urunAdi,adet,id};
		
		return data;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return musteriAdi+" "+ personelAdi+ " "+ urunAdi;
	}

}
