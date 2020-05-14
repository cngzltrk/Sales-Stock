package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.PersonelContract;
import tr.com.deneme.types.Yetkiler;

public class YetkilerDAL extends ObjectHelper implements DALInterfaces<Yetkiler> {

	@Override
	public void Insert(Yetkiler entity) {
		Connection connection=getConnection();
				
				try {
					Statement statement=connection.createStatement();
					statement.executeUpdate("insert into yetkiler (adi) values ('"+entity.getAdi()+"')" );
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public List<Yetkiler> GetAll() {
		List<Yetkiler> yetkilerList=new ArrayList<Yetkiler>();
		Yetkiler contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from Yetkiler");
			while(resultset.next())
			{
				contract=new Yetkiler();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("adi"));
				
				yetkilerList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yetkilerList;
	}

	@Override
	public Yetkiler Delete(Yetkiler entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(Yetkiler entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Yetkiler> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
