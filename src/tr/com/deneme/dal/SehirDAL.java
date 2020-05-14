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
import tr.com.deneme.types.SehirConract;

public class SehirDAL extends ObjectHelper implements DALInterfaces<SehirConract>{

	@Override
	public void Insert(SehirConract entity) {
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into sehir (sehir) values ('"+entity.getSehir()+"')" );
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SehirConract> GetAll() {
		List<SehirConract> sehirList=new ArrayList<SehirConract>();
		SehirConract contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from sehir");
			while(resultset.next())
			{
				contract=new SehirConract();
				contract.setId(resultset.getInt("Id"));
				contract.setSehir(resultset.getString("Sehir"));
				sehirList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sehirList;
	}

	@Override
	public SehirConract Delete(SehirConract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SehirConract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SehirConract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
