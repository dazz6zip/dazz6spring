package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	@Override
	public List<JikwonDTO> jikwonList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		List<JikwonDTO> jikwonList = null;
		
		try {
			jikwonList = em.createQuery("SELECT new pack.model.JikwonDTO(e.no, e.name, e.team, e.year) FROM JikwonDTO AS e", JikwonDTO.class).getResultList();
		} catch (Exception e) {
			System.out.println("jikwonList() ERROR : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return jikwonList;
	}
	
	@Override
	public List<Object[]> teamCount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		List<Object[]> teamCount = null;
		
		try {
			teamCount = em.createQuery("SELECT e.team, COUNT(e) FROM JikwonDTO AS e GROUP BY e.team", Object[].class).getResultList();
		} catch (Exception e) {
			System.out.println("teamCount() ERROR : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return teamCount;
	}
}
