package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DataImpl implements DataInterface {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	List<GogekDto> list = null;
	
	@Override
	public List<GogekDto> selectDataAll() {
		
		try {
			list = em.createQuery("SELECT e FROM GogekDto AS e", GogekDto.class).getResultList();
			System.out.println("번호\t이름\t전화");
			for (GogekDto g : list) {
				System.out.println(g.getNo() + "\t" + g.getName() + "\t" + g.getTel());
			}
		}  catch (Exception e) {
			tx.rollback();
			System.out.println("selectDataAll() ERROR : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		DataImpl impl = new DataImpl();
		impl.selectDataAll();
	}
}
