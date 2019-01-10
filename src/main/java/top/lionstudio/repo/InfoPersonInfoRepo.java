package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.InfoPersonInfo;

@Repository
public interface InfoPersonInfoRepo extends JpaRepository<InfoPersonInfo, Long>{
	public InfoPersonInfo findByPersonId(Integer personId);

}
