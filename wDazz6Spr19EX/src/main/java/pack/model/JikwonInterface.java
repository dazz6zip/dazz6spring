package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;

public interface JikwonInterface extends JpaRepository<Jikwon, String> {

}
