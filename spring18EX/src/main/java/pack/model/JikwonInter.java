package pack.model;

import java.util.List;

public interface JikwonInter {
	List<JikwonDto> selectJikwonAll();
	List<JikwonDto> selectBuserCount();
	List<JikwonDto> selectMaxPay();
}
