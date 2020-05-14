package tr.com.deneme.complex.types;

public class StokSumContractComplex {
	private String urunAdi;
	private String personelAdi;
	private int toplam;
	private int adet;
	
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public int getToplam() {
		return toplam;
	}
	public void setToplam(int toplam) {
		this.toplam = toplam;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public Object[] getVeriler()
	{
		Object[] data= {"","",urunAdi,toplam,"",adet};
		
		return data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return personelAdi+ " "+ urunAdi;
	
	}

}
