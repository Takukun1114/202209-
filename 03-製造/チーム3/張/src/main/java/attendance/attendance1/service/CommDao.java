package attendance.attendance1.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CommDao {
	Connection conn;

	public CommDao() {
		String url = "jdbc:mysql://localhost/dev1";
		String uname = "root";
		String password = "Ipszhangxiao1";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn =DriverManager.getConnection(url,uname,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public List<HashMap> select(String sql) {

		List<HashMap> list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				HashMap map = new HashMap();

				int i = rsmd.getColumnCount();
				for (int j = 1; j < i; j++) {
					
						String str = rs.getString(j) == null ? "" : rs.getString(j);
						if (str.equals("null"))
							str = "";
						map.put(rsmd.getColumnName(j), str);
						System.out.println(map);
					
				}
				list.add(map);
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			if (sql.equals("show tables"))
				list = select("select table_name from   INFORMATION_SCHEMA.tables");
			else
				e.printStackTrace();
		}finally {
			
		}
		return list;
	}
	

	
	
	


}
