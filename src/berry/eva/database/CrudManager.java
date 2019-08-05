package berry.eva.database;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import berry.eva.application.R;
import berry.eva.database.dao.DAO_policy;
import berry.eva.database.dao.DAO_projects;

public final class CrudManager {

	//private static final String NAME_SPACE = "berry.eva.database.myMapper";

	private SqlSession getSession() {
		//String path_config = "berry/eva/database/mybatis_config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(R.MyBatis.PATH_CONFIG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
	
	public List<DAO_projects> select_projects_all(){
		SqlSession ss = getSession();
		List<DAO_projects> list = null;
		try {
			String query = R.MyBatis.NAME_SPACE + ".select_projects_all";
			list = ss.selectList(query);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return list;
	}
	
	public Integer insert_project(DAO_projects dao) {
		Integer resultCode = null;
		SqlSession ss = getSession();
		try {
			String query = R.MyBatis.NAME_SPACE + ".insert_project";
			resultCode = ss.insert(query, dao);	
			if(resultCode == 1) {
				ss.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return resultCode;
	}
	
	public Integer insert_policy(DAO_policy dao) {
		Integer resultCode = null;
		SqlSession ss = getSession();
		try {
			String query = R.MyBatis.NAME_SPACE + ".insert_policy";
			resultCode = ss.insert(query, dao);
			if(resultCode == 1) {
				ss.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return resultCode;
	}
	
	/**
	public ArrayList<String> getColumnName(){
		SqlSession ss = getSession();
		ArrayList<String> list_columnName = null;
		try {
			String query = "select * from empl_info where 1=2";
			Statement stmt = ss.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			list_columnName = new ArrayList<String>();
			for( int i = 1; i<=columnCount; i++) {
				String name = meta.getColumnName(i);
				list_columnName.add(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return list_columnName;
	}

	public List<Object> select_employee_all(){
		SqlSession ss = getSession();
		List<Object> list = new ArrayList<Object>();
		try {
			String query = NAME_SPACE + ".select_employee_all";
			list = ss.selectList(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return list;
	}
	*/
}
