package tr.com.deneme.types;

public class SehirConract {
	int id;
	String sehir;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sehir;
	}

}
