package tr.com.deneme.types;

import java.sql.Date;

public class StokContract {
	private int id;
	private int personelId;
	private int urunId;
	private int adet;
	private String tarih;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
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
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+ " "+personelId+ " "+urunId+ " "+adet+ " "+tarih;
	}
	
}
