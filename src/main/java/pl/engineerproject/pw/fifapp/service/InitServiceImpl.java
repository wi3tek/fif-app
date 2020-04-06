package pl.engineerproject.pw.fifapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.engineerproject.pw.fifapp.model.Role;
import pl.engineerproject.pw.fifapp.model.User;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class InitServiceImpl implements InitService {

	private static final String DUMMY_ADMIN_USER = "admin";

	private static final String DUMMY_ADMIN_PASSWORD = "admin12345";

	private static final String DUMMY_EMAIL = "adminfifapp@gmail.com";

	private static final String DUMMY_REGISTRATION_REASON = "-";

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initUser() throws Exception {
// Below initial insert User entity with role Admin
//		User user = new User();
//		user.setUsername(DUMMY_ADMIN_USER);
//		user.setEmail(DUMMY_EMAIL);
//		user.setPassword(passwordEncoder.encode(DUMMY_ADMIN_PASSWORD));
//		user.setRegistrationDate(LocalDateTime.now());
//		user.setRegistrationReason(DUMMY_REGISTRATION_REASON);
//		user.setActiveFlag(true);
//
//		Role roleAdmin = new Role();
//		roleAdmin.setRoleName("ROLE_ADMIN");
//		Role roleUser = new Role();
//		roleUser.setRoleName("ROLE_USER");
//
//		user.getRoles().add(roleAdmin);
//		user.getRoles().add(roleUser);


		Role roleUser = new Role();
		roleUser.setRoleName("ROLE_USER");


		User test1 = new User("test1",passwordEncoder.encode("test1"),"test1@bleble.com", "-",LocalDateTime.now(),true);
		test1.getRoles().add(roleUser);
		userService.saveUser(test1);

		User test2 = new User("test2",passwordEncoder.encode("test2"),"test2@bleble.com", "-",LocalDateTime.now(),true);
		test2.getRoles().add(roleUser);
		userService.saveUser(test2);

		User test3 = new User("test3",passwordEncoder.encode("test3"),"test3@bleble.com", "-",LocalDateTime.now(),true);
		test3.getRoles().add(roleUser);
		userService.saveUser(test3);

		User test4 = new User("test4",passwordEncoder.encode("test4"),"test4@bleble.com", "-",LocalDateTime.now(),true);
		test4.getRoles().add(roleUser);
		userService.saveUser(test4);

		User test5 = new User("test5",passwordEncoder.encode("test5"),"test5@bleble.com", "-",LocalDateTime.now(),true);
		test5.getRoles().add(roleUser);
		userService.saveUser(test5);

		User test6 = new User("test6",passwordEncoder.encode("test6"),"test6@bleble.com", "-",LocalDateTime.now(),true);
		test6.getRoles().add(roleUser);
		userService.saveUser(test6);

		User test7 = new User("test7",passwordEncoder.encode("test7"),"test7@bleble.com", "-",LocalDateTime.now(),true);
		test7.getRoles().add(roleUser);
		userService.saveUser(test7);

		User test8 = new User("test8",passwordEncoder.encode("test8"),"test8@bleble.com", "-",LocalDateTime.now(),true);
		test8.getRoles().add(roleUser);
		userService.saveUser(test8);

		User test9 = new User("test9",passwordEncoder.encode("test9"),"test9@bleble.com", "-",LocalDateTime.now(),true);
		test9.getRoles().add(roleUser);
		userService.saveUser(test9);

		User test10 = new User("test10",passwordEncoder.encode("test10"),"test10@bleble.com", "-",LocalDateTime.now(),true);
		test10.getRoles().add(roleUser);
		userService.saveUser(test10);

		User test11 = new User("test11",passwordEncoder.encode("test11"),"test11@bleble.com", "-",LocalDateTime.now(),true);
		test11.getRoles().add(roleUser);
		userService.saveUser(test11);

		User test12 = new User("test12",passwordEncoder.encode("test12"),"test12@bleble.com", "-",LocalDateTime.now(),true);
		test12.getRoles().add(roleUser);
		userService.saveUser(test12);

		User test13 = new User("test13",passwordEncoder.encode("test13"),"test13@bleble.com", "-",LocalDateTime.now(),true);
		test13.getRoles().add(roleUser);
		userService.saveUser(test13);

		User test14 = new User("test14",passwordEncoder.encode("test14"),"test14@bleble.com", "-",LocalDateTime.now(),true);
		test14.getRoles().add(roleUser);
		userService.saveUser(test14);

	}
}
