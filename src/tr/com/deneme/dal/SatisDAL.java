package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.complex.types.SatisContractComplex;
import tr.com.deneme.complex.types.StokContractComplex;
import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.SatisContract;

public class SatisDAL extends ObjectHelper implements DALInterfaces<SatisContract> {

	@Override
	public void Insert(SatisContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into satis (urunid,musteriid,tarih,adet,personelid) values ("
					+ entity.getUrunId() + "," + entity.getMusteriId() + ",'" + entity.getTarih() + "',"
					+ entity.getAdet() + "," + entity.getPersonelId() + " );");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<SatisContractComplex> GetAllSatis(){
		List<SatisContractComplex> dataContract=new ArrayList<SatisContractComplex>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resulSet=statement.executeQuery("select s.id,p.AdiSoyadi,u.adi,m.adisoyadi as madi,s.adet,s.tarih from satis s  "
					+ "left join urunler u on s.urunid =u.id "
					+ "left join personel p on s.personelid =p.id  "
					+ "left join musteri m on s.musteriid =m.id "
					+ "order by s.id desc;");
			while(resulSet.next())
			{
				SatisContractComplex contract=new SatisContractComplex();
				contract.setId(resulSet.getInt("id"));
				contract.setPersonelAdi(resulSet.getString("adisoyadi"));
				contract.setUrunAdi(resulSet.getString("adi"));
				contract.setAdet(resulSet.getInt("adet"));
				contract.setTarih(resulSet.getString("tarih"));
				contract.setMüsteriAdi(resulSet.getString("madi"));
				dataContract.add(contract);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataContract;
	}
	@Override
	public List<SatisContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SatisContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SatisContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
