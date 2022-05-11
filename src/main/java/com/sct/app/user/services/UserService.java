package com.sct.app.user.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sct.app.user.model.UserVO;
import com.sct.app.user.repository.UserRepository;

@Configuration
@ComponentScan({ "com.sct.app" })
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<UserVO> getEmployeeByUserAndPass(UserVO userVO) {
		Optional<UserVO> employee = null;
		if (userVO.getUsername() == null) {
			return employee;
		}
		try {
			Long d = Long.parseLong(userVO.getUsername());
			employee = (Optional<UserVO>) userRepository.findByEmpIdAndPass(d, userVO.getPassword());
		} catch (NumberFormatException nfe) {
			return null;
		}
		return employee;
	}

}
