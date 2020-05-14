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

public class KategoryDAL extends ObjectHelper implements  DALInterfaces<KategoryContract> {

	@Override
	public void Insert(KategoryContract entity) {
		Connection connection=getConnection();
		
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into kategori (Adi,ParentId) values ('"+entity.getAdi()+"',"+entity.getParentId()+")" );
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<KategoryContract> GetAll() {
		List<KategoryContract> kategoriList=new ArrayList<KategoryContract>();
		KategoryContract contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from Kategori");
			while(resultset.next())
			{
				contract=new KategoryContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				contract.setParentId(resultset.getInt("ParentId"));
				kategoriList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kategoriList;
	}
	public List<KategoryContract> GetAllParentId() {
		List<KategoryContract> kategoriList=new ArrayList<KategoryContract>();
		KategoryContract contract;
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from Kategori where ParentId=0;");
			while(resultset.next())
			{
				contract=new KategoryContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				contract.setParentId(resultset.getInt("ParentId"));
				kategoriList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kategoriList;
	}

	@Override
	public KategoryContract Delete(KategoryContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(KategoryContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KategoryContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
