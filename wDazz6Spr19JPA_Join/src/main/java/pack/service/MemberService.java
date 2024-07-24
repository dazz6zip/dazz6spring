package pack.service;

import org.springframework.ui.Model;

import pack.dto.MemberDto;

public interface MemberService {
	
	// 회원 자료 전체 읽기
	public void getList(Model model);
	
	// 자료 추가하기 (FormBean 권장)
	public void insert(MemberDto dto);
	
	// 단일 회원 자료 읽기
	public void getData(Long num, Model model);
	
	// 자료 수정하기 1
	public void update1(MemberDto dto);
	
	// 자료 수정하기 2
	public void update2(MemberDto dto);
	
	// 자료 삭제하기
	public void delete(Long num);
}
