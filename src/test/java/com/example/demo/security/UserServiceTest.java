package com.example.demo.security;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.security.User.LoginProvider;

@SpringBootTest
//@WithMockUser - not needed
public class UserServiceTest {
	
	private static final String USER_ROLE_NAME = "ROLE_USER";
	
	@MockBean
	private RoleRepository roleRepository;
	
	@MockBean
	private UserRepository userRepository;
		
	@Autowired
	private UserService userService;
	
	@Test
	void testRegisterUser() {
		
		Role role = new Role(USER_ROLE_NAME);
		User user = new User("user", StringUtils.repeat("A", 60), LoginProvider.INTERNAL,"User","User");
		user.addRole(role);
		
		given(roleRepository.findByName(USER_ROLE_NAME)).willReturn(Optional.of(role));
		userService.registerUser(user);
		
		verify(userRepository, times(1)).save(user);
		
	}

}
