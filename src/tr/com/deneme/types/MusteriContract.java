package tr.com.deneme.types;

public class MusteriContract {
	private int id;
	private String adiSoyadi;
	private String telNo;
	private String adres;
	private int sehirId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdiSoyadi() {
		return adiSoyadi;
	}
	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public int getSehirId() {
		return sehirId;
	}
	public void setSehirId(int sehirId) {
		this.sehirId = sehirId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adiSoyadi;
	}
}
