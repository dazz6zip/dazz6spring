package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@SpringBootApplication
public class WDazz6Spr19JpaJoinApplication {

//	1. application 에서 SQL 처리용 메소드 연습
//	2. @MVC로 회원자료 처리
//	3. @MVC로 직원자료 처리 (JOIN)
//	4. JPQL 연습용 화면 작성 (Ajax)

	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private DeptRepository drps;
	
	@Autowired
	private EmpRepository erps;

	@PostConstruct // 생성자 이후 자동 실행
	public void initMembers() {
		// hibernate 객체 사용 : JPQL로 dept, emp 샘플 데이터 저장
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			List<String> queries = new ArrayList<String>();
			queries.add("INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");

			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);");

			// 반복 처리로 쿼리 실행
			for (String q : queries) {
				em.createNativeQuery(q).executeUpdate();
			}

			tx.commit();
		} catch (Exception e) {
			System.out.println("initMember ERROR : " + e.getMessage());
			tx.rollback();
		} finally {
			em.close();
		}
		
		/*
		// 사원번호
		Emp e1 =  erps.findById(7788).get();
		System.out.println(e1.getDept().getDname() + " " +  e1.getEname() + " 사원");
		
		// 직원 추가 (40번 부서, Olivia)
		Dept dnum = drps.findById(40).get();
		System.out.println(dnum.getDname() + " " + dnum.getDeptno());
		
		// 40번 부서의 다른 정보를 이용해 직원 정보를 저장할 것이 아니라면 find 없이 부서 번호만 Dept 객체에 넣음 
		// lombok builder 사용, Dept 객체를 Builder pattern 으로 생성
		Dept d = Dept.builder().deptno(40).build();
		System.out.println(d.getDeptno());
		
		Emp my = Emp.builder()
				.empno(8000)
				.ename("Olivia")
				.dept(d)
				.build();
		
		erps.save(my);
		
		// 부서 정보 읽기 : 10번
		Dept dept10 = drps.findById(10).get();
		System.out.println("부서명 : " + dept10.getDname());
		System.out.println("부서 위치 : " + dept10.getLoc());
		System.out.println("근무 인원 수 : " + dept10.getList().size());
		System.out.print("직원 : ");
		for (Emp e : dept10.getList()) {
			System.out.print(e.getEname() + ", ");
		}
		System.out.println("\n");
		*/
	}

	public static void main(String[] args) {
		SpringApplication.run(WDazz6Spr19JpaJoinApplication.class, args);
	}

}
