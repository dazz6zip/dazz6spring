package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.BuserDto;
import pack.dto.GogekDto;
import pack.dto.JikwonDto;

@Repository
public class TestDao {

	@Autowired
	private JikwonInterface jitf;
	
	@Autowired
	private GogekInterface gitf;

	public List<JikwonDto> getAll() {
		return jitf.findAll().stream().map(JikwonDto::toDto).toList();
	}
	
//	public boolean checkGogek() {
//		return gitf.findById(null)
//	}
	
	public List<GogekDto> getGogekData(String no) {
		return gitf.findAll().stream().map(GogekDto::toDto).toList();
	}

}
