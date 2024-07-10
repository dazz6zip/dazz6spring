package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor // 여기까지 lombok annotation, Entity는 hibernate
@Table(name="mem") // DB의 특정 테이블과 매핑
@Entity 
public class MemDto { 
	// 카멜 케이스로 작성하면 자동으로 언더 스코어 네이밍 컨벤션 (스네이크 케이스) 로 변환하여 매핑
	// MemDto -> mem_dto / DB 테이블명과 다르기 때문에 Entity 어노테이션 name 에 명시
	
	@Id // PK
	@Column(name="num") // 변수 이름과 컬럼명이 다를 경우 (혹은 위처럼 변환되어 달라질 경우) Column 어노테이션 name 에 명시
	private int num;
	
	@Column(name="name", nullable=true) // nullable true : null, false : not null
	private String name;
	
	private String addr;
}	