package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.Customer;
import pack.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository crps;

	public void printAllData() {
		crps.findAll().forEach(c -> {
			System.out.println(c);
		});
	}

	public void updateData(String name) {
		// 이름으로 수정 대상 자료 찾기
		Customer customer = crps.findByName(name);

		if (customer != null) {
			// 나이와 성별 수정
			customer.setAge("35");
			customer.setGender("여");
			crps.save(customer);
			System.out.println("자료 수정 성공 : " + customer);
		} else {
			System.out.println(name + " 님의 자료가 없습니다." );
		}
	}
	
	public void deleteData(String name) {
		// 이름으로 삭제 대상 자료 찾기
		Customer customer = crps.findByName(name);

		if (customer != null) {
			crps.delete(customer);
			System.out.println("자료 삭제 성공");
		} else {
			System.out.println(name + " 님의 자료가 없습니다." );
		}
	}
}
