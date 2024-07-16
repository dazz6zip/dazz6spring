package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public ArrayList<DataDto> searchJikwon(String jik) {
		ArrayList<DataDto> list = new ArrayList<DataDto>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM jikwon WHERE jikwon_jik = ?");
			pstmt.setString(1, jik);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DataDto dto = new DataDto();
				dto.setNo(rs.getString("jikwon_no"));
				dto.setName(rs.getString("jikwon_name"));
				dto.setGen(rs.getString("jikwon_gen"));
				dto.setPay(rs.getString("jikwon_pay"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("searchJikwon ERROR : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("searchJikwon - finally ERROR : " + e2.getMessage());
			}
		}

		return list;
	}
}
