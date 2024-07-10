package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
		// JOIN
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			// JPQL 사용
			String jpql = "SELECT j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail FROM Jikwon AS j JOIN j.buser AS b";
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();
			
			System.out.println("\n- JPQL 사용");
			for (Object[] result : results) {
				int year = getMyYear((Date)result[3]);
				System.out.println(result[0] + "\t" + result[1] + "\t" + result[2] + "\t" + year);
			}
			
			// Native SQL 사용
			String sql = "SELECT jikwon_no, jikwon_name, buser_name, DATE_FORMAT(jikwon_ibsail, '%Y') FROM jikwon INNER JOIN buser ON buser_num = buser_no";
			Query qr = em.createNativeQuery(sql);
			List<Object[]> rst = qr.getResultList();
			
			System.out.println("\n- SQL 사용");
			for (Object[] r : rst) {
				System.out.println(r[0] + "\t" + r[1] + "\t" + r[2] + "\t" + r[3]);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}
	
	private static int getMyYear(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.YEAR);
	}
}
