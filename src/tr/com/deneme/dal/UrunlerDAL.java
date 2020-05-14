package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.KategoryContract;
import tr.com.deneme.types.UrunlerContract;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {
		Connection connection=getConnection();
		
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into Urunler(Adi,KategoriId,Tarih,Fiyat) values ('"+entity.getAdi()+"',"+entity.getKategoriId()+",'"+entity.getTarih()+"',"+entity.getFiyat()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UrunlerContract> GetAll() {
		List<UrunlerContract> dataList=new ArrayList<UrunlerContract>();
		UrunlerContract contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from urunler");
			while(resultset.next())
			{
				contract=new UrunlerContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				contract.setKategoriId(resultset.getInt("kategoriid"));
				contract.setTarih(resultset.getString("tarih"));
				dataList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(UrunlerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
