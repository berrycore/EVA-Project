package berry.eva.dbstore;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class CrudManager {

	private static final String NAME_SPACE = "jsh.myMapper";

	private SqlSession getSession() {
		String path_config = "jsh/mybatis_config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(path_config);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
	
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
	
}
