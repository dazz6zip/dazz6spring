package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private EmpRepository erps;
	
	@Autowired
	private DeptRepository drps;
	
	@GetMapping("/employee/elist")
	public String employeeElistGet(Model model) {
		// 모든 직원 정보 출력
		List<Emp> list = erps.findAll(); // 기본 메소드
//		List<Emp> list = erps.findAllByOrderByEmpnoAsc();
//		List<Emp> list = erps.getListAll();
//		List<Emp> list = erps.getList(1500);
		
		model.addAttribute("list", list);
		
		return "/employee/elist";
	}
	
	@GetMapping("/employee/dept")
	public String employeeDeptGet(@RequestParam("deptno") int no, Model model) {
		DeptDto dto = DeptDto.toDto(drps.findById(no).get());
		// Contoller 영역이므로 Dto 변환
		model.addAttribute("dto", dto);
		return "/employee/dept";
	}
	
	/* JPQL 연습장 관련 */
	@GetMapping("/jpql")
	public String jqpl() {
		return "jpql";
	}
	
	@ResponseBody // JSON 모양으로 return
	@PostMapping("jpql/test")
	public List<EmpListDto> jpqlTestPost(@RequestParam("query") String query) {
//		System.out.println(query);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<EmpListDto> list = null;
		try {
			// 전달받은 query (JPQL) 실행
			TypedQuery<Emp> tq = em.createQuery(query, Emp.class);
			list = tq.getResultStream()
					.map(EmpListDto::toDto)
					.toList();
			tx.commit(); // SELECT의 경우 불필요
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return list;
	}
	
	
}











