package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.SangpumDto;

@Repository
public class DataDao {

	@Autowired
	private DataRepository drst;

	public List<SangpumDto> getSangpumAll() {
//	public List<SangpumDto> slist = drst.findAll().stream().map(SangpumDto::toDto).toList();
	return drst.findAll().stream()
			.map(s -> SangpumDto.builder()
				.code(s.getCode())
				.sang(s.getSang())
				.su(s.getSu())
				.dan(s.getDan())
				.build())
			.collect(Collectors.toList());
	}
}
