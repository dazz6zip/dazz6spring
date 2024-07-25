package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository mrps;

	@Override 
	public void getList(Model model) { 
		/*
		// 방법 1)
		// - Member Entity -> MemberDto 객체로 전달
		
		List<Member> entityList = mrps.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		for (Member m : entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(m.getNum());
			dto.setName(m.getName());
			dto.setAddr(m.getAddr());
			list.add(dto);
		}
		
		
		
		// 방법 2)
		// - List<Member>를 Stream으로 변경하여 map() 사용
		// - List<MemberDto>로 변경하기
		
		List<MemberDto> list = mrps.findAllByOrderByNumDesc()
								.stream() // stream 변환
								.map(item -> MemberDto.toDto(item)) // function 실행할 수 있는 map 사용
								.toList(); // List로 변환
		*/
		
		// 방법 3)
		// - 람다 표현식을 메소드 참조 표현식으로 기술
		// 클래스명::메소드명
		List<MemberDto> list = mrps.findAllByOrderByNumDesc()
									.stream() // stream 변환
									.map(MemberDto::toDto) // .map(item -> MemberDto.toDto(item)) 과 같은 의미
									.toList(); // List로 변환
		
		model.addAttribute("list", list);
		// 컨트롤러에 MemberDto가 담긴 list 전달
	}

	@Override
	public void insert(MemberDto dto) {
		// JPA 작업 영역 내로 들어갈 때 일반 자료 전달용 객체 (DTO, FormBean) 를 대응 Entity 로 변환 
		mrps.save(Member.toEntity(dto));
	}

	@Override
	public void getData(Long num, Model model) {
		Member m = mrps.findById(num).get();
		model.addAttribute("dto", MemberDto.toDto(m));
	}

	@Override
	public void update1(MemberDto dto) {
		mrps.save(Member.toEntity(dto));
	}

	@Transactional
	@Override
	public void update2(MemberDto dto) {
		// 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = mrps.findById(dto.getNum()).get();
	    Member m2 = mrps.findById(dto.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1 == m2 : " + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기
	    m1.setName(dto.getName());
	    m1.setAddr(dto.getAddr());
	    
	    // 이 방법을 사용할 경우 @Transactional 어노테이션 필수!
	}

	@Override
	public void delete(Long num) {		
		mrps.deleteById(num);
	}

}
