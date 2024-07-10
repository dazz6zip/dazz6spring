package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); // 엔티티 생명주기 관리, CRUD 수행
		EntityTransaction tx = em.getTransaction(); // transaction 관리 (인터페이스)
		// transaction 의 이해 필요
		
		List<MemDto> list = null;
		
		try {
			/* 레코드 추가 */
//			tx.begin();
//			MemDto dto1 = new MemDto();
//			dto1.setNum(4);
//			dto1.setName("고길동");
//			dto1.setAddr("서초구 방배동");
//			em.persist(dto1); // INSERT
//			tx.commit();
			
			/* 레코드 수정 */
//			tx.begin();
//			MemDto dto2 = em.find(MemDto.class, 4);
//			dto2.setName("바보");
//			tx.commit();
			
			/* 레코드 삭제 */
//			tx.begin();
//			MemDto dto3 = em.find(MemDto.class, 4);
//			em.remove(dto3);
//			tx.commit();
			
			/* 부분 자료 읽기 (한 개) */
			System.out.println("\n- 부분 자료 읽기 (단일 Entity) - find() method");
			// find(Class<T> entityClass, Object pk)
			MemDto mdto = em.find(MemDto.class, 2); // pk가 1인 자료 보기
			System.out.println(mdto.getNum() + "\t" + mdto.getName() + "\t" + mdto.getAddr());
			
			/* 부분 자료 읽기 (두 개 이상) */
			System.out.println("\n- 부분 자료 읽기 (다중 Entity) - LIKE etc");
			List<MemDto> listPart = findByAddr(em, "강남");
			for(MemDto lp : listPart) {
				System.out.println(lp.getNum() + "\t" + lp.getName() + "\t" + lp.getAddr());
			}
				
			/* 전체 자료 읽기 */
			System.out.println("\n- 전체 자료 읽기 (JPQL)");
//			list = findAll(em, MemDto.class);
//			for(MemDto m : list) {
//				System.out.println(m.getNum() + "\t" + m.getName() + "\t" + m.getAddr());
//			}
			list = em.createQuery("SELECT e FROM MemDto AS e", MemDto.class).getResultList();
			// Hibernate: select e from MemDto as e // RDBMS 종류에 상관없이 공통적으로 사용함
			// DB Dialect 에 의한 실제 SQL : select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("selectDataAll() ERROR : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em, String ss) {
		// addr 이 특정 접두사로 시작하는 레코드 읽기
		String jpql = "SELECT m FROM MemDto AS m WHERE m.addr LIKE :ss";
		TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
		// TypedQuery<Entity> query = em.createQuery(String jpql, Class EntityClass)
		// ㄴ JPQL을 작성하고 실행하는 역할
		query.setParameter("ss", ss + "%"); // SQL LIKE 연산을 위한 %
		return query.getResultList();
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) {
		// JPQL (SQL X)
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
		// cla.getName() : pack.model.MemDto
		// cla.getSimpleName() : MemDto
	}
}
