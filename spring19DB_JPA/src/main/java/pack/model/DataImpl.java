package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); // 엔티티 생명주기 관리, CRUD 수행
		EntityTransaction tx = em.getTransaction(); // transaction 관리 (인터페이스)
		
		List<MemDto> list = null;

		System.out.println("- 전체 자료 읽기");
		list = findAll(em, MemDto.class);
		
		for(MemDto m : list) {
			System.out.println(m.getNum() + "\t" + m.getName() + "\t" + m.getAddr());
		}
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) {
		// JPQL (SQL X)
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}

}
