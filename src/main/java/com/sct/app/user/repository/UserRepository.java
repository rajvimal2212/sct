package com.sct.app.user.repository;
import org.springframework.data.jpa.repository.Query;

import com.sct.app.user.model.UserVO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO, Long>{
	
	    @Query("SELECT t FROM UserVO t where t.username = ?1 AND t.password= ?2")
	    Optional<UserVO> findByUserAndPass(final String username, final String password);
	    
	    @Query("SELECT t FROM UserVO t where t.id = ?1 AND t.password= ?2")
	    Optional<UserVO> findByEmpIdAndPass(final Long username, final String password);
	    
	    @Query("SELECT t FROM UserVO t where t.username = ?1")
	    Optional<UserVO> findEmployeeByUser(final String username);
	    
	    @Query("SELECT t FROM UserVO t where t.id = ?1")
	    Optional<UserVO> findEmployeeById(final Long empId);
	    
	    @Query("SELECT t FROM UserVO t where t.id = ?1 AND t.password= ?2")
	    Optional<UserVO> findByEmpIdbyExistingPwd(final Long empId, final String oldpassword);
	    
	    @Query("SELECT t FROM UserVO t where t.email= ?1")
	    Optional<UserVO> findByEmpIdAndEmail(final String email);

}
