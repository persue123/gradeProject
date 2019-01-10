package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.SysUser;

@Repository
public interface SysUserRepo extends JpaRepository<SysUser, Long>{
	

	public SysUser findByLoginNameAndPassword(String loginname, String password);
	public SysUser findByLoginName(String loginname);

}
