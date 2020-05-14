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
import tr.com.deneme.types.PersonelContract;

public class PersonelDAL  extends ObjectHelper implements DALInterfaces<PersonelContract>{

	@Override
	public void Insert(PersonelContract entity) {
		Connection connection=getConnection();
				
				try {
					Statement statement=connection.createStatement();
					statement.executeUpdate("insert into personel (AdiSoyadi,Email) values ('"+entity.getAdiSoyadi()+"','"+entity.getEmail()+"')" );
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public List<PersonelContract> GetAll() {
		List<PersonelContract> personelList=new ArrayList<PersonelContract>();
		PersonelContract contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from Personel");
			while(resultset.next())
			{
				contract=new PersonelContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdiSoyadi(resultset.getString("AdiSoyadi"));
				contract.setEmail(resultset.getString("Email"));
				personelList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personelList;
	}

	@Override
	public PersonelContract Delete(PersonelContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(PersonelContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
