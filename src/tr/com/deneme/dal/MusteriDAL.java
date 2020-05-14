package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.complex.types.StokSumContractComplex;
import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.MusteriContract;

public class MusteriDAL extends ObjectHelper implements DALInterfaces<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		Connection connection=getConnection();
		
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into musteri (AdiSoyadi,Telefon,Adres,SehirId) values ('"+entity.getAdiSoyadi()+"','"+entity.getTelNo()+"','"+entity.getAdres()+"',"+entity.getSehirId()+")" );
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MusteriContract> GetAll() {
		List<MusteriContract> dataContract=new ArrayList<MusteriContract>();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resulSet=statement.executeQuery("select * from musteri");
			while(resulSet.next())
			{
				MusteriContract contract=new MusteriContract();
				contract.setId(resulSet.getInt("id"));
				contract.setAdiSoyadi(resulSet.getString("adisoyadi"));
				contract.setTelNo(resulSet.getString("telefon"));
				contract.setAdres(resulSet.getString("adres"));
				contract.setSehirId(resulSet.getInt("sehirid"));
				dataContract.add(contract);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataContract;
	}

	@Override
	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(MusteriContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
