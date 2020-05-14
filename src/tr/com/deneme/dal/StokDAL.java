package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.complex.types.StokContractComplex;
import tr.com.deneme.complex.types.StokSumContractComplex;
import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.StokContract;

public class StokDAL extends ObjectHelper implements DALInterfaces<StokContract> {

	@Override
	public void Insert(StokContract entity) {
		Connection connection=getConnection();
		
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into stok (personelid,urunid,tarih,adet) values ("+entity.getPersonelId()+","+entity.getUrunId()+",'"+entity.getTarih()+"',"+entity.getAdet()+");" );
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<StokContractComplex> GetAllStok(){
		List<StokContractComplex> dataContract=new ArrayList<StokContractComplex>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resulSet=statement.executeQuery("select s.id,p.AdiSoyadi,u.adi,s.adet,s.tarih from stok s  "
					+ "left join urunler u on s.urunid =u.id "
					+ "left join personel p on s.personelid =p.id  order by s.id desc;");
			while(resulSet.next())
			{
				StokContractComplex contract=new StokContractComplex();
				contract.setId(resulSet.getInt("id"));
				contract.setPersonelAdi(resulSet.getString("adisoyadi"));
				contract.setUrunAdi(resulSet.getString("adi"));
				contract.setAdet(resulSet.getInt("adet"));
				contract.setTarih(resulSet.getString("tarih"));
				dataContract.add(contract);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataContract;
	}
	public List<StokSumContractComplex> GetSumStok(){
		List<StokSumContractComplex> dataContract=new ArrayList<StokSumContractComplex>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resulSet=statement.executeQuery("select sum(s.adet) as toplam,u.adi ,count(*) as adet from stok s "
					+ "left join urunler u on s.urunid =u.id "
					+ "left join personel p on s.personelid =p.id "
					+ "group by u.adi ;");
			while(resulSet.next())
			{
				StokSumContractComplex contract=new StokSumContractComplex();
				contract.setUrunAdi(resulSet.getString("adi"));
				contract.setAdet(resulSet.getInt("adet"));
				contract.setToplam(resulSet.getInt("toplam"));
				dataContract.add(contract);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataContract;
	}

	@Override
	public List<StokContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StokContract Delete(StokContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(StokContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StokContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
