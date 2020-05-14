package tr.com.deneme.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.deneme.core.ObjectHelper;
import tr.com.deneme.interfaces.DALInterfaces;
import tr.com.deneme.types.AccountsContract;
import tr.com.deneme.types.PersonelContract;

public class AccountsDAL extends ObjectHelper implements DALInterfaces<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection=getConnection();
		
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("insert into accounts (YetkiId,PersonelId,Sifre) values ("+entity.getYetkiId()+","+entity.getPersonelId()+",'"+entity.getSifre()+"')" );
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public List<AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountsContract> GetById(int Id) {
		
		return null;	
	}
	public AccountsContract GetSingle(int personelId,String sifre) {
		AccountsContract contract=new AccountsContract();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			
			ResultSet resultset=statement.executeQuery("select p.id,p.email,y.adi,a.sifre,a.personelid,a.yetkiid From accounts a "
					+ "left join personel p on a.personelid=p.id "
					+ "left join yetkiler y on a.yetkiid =y.id "
					+ "where a.personelid ="+personelId+" and a.sifre ='"+sifre.trim()+"' ;");
			while(resultset.next())
			{
				contract.setPersonelId(resultset.getInt("personelid"));
				contract.setSifre(resultset.getString("sifre"));
				contract.setId(resultset.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contract;	
	}
	public AccountsContract GetYetkiId(int personelId) {
		AccountsContract contract=new AccountsContract();
		Connection connection=getConnection();
		try {
			Statement statement=connection.createStatement();
			
			ResultSet resultset=statement.executeQuery("select a.yetkiid From accounts a "
					+ "where a.personelid ="+personelId+" ;");
			while(resultset.next())
			{
				contract.setYetkiId(resultset.getInt("yetkiid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contract;	
	}
	
}
