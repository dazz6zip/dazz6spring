package pack.model;

import org.springframework.stereotype.Service;

import pack.contoller.DataBean;

@Service
public class InputModel {
	public String computePrice(DataBean bean) {
		String data = "품명 : " + bean.getSang() + ", 금액 : " + (bean.getSu() * bean.getDan());
		return data;
	}
}
