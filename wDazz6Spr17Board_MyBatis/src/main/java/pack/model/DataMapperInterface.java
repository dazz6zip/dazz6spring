package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMapperInterface {
	// 추상 메소드명은 mapper.xml의 ID명과 일치해야 함
	
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	int insert(BoardBean bean);
	int update(BoardBean bean);
	void updateReadcnt(String num);
	int delete(String num);
}
