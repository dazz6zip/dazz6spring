package pack.model;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource ds;
	
	public DataDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<DataDto> selectAll() {
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM sangdata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DataDto dto = new DataDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll ERROR : " + e.getMessage());
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				if (pstmt!= null) {
					pstmt.close();
				}
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("selectAll - finally ERROR : " + e2.getMessage());
			}
		}
		
		return list;
	}
}
