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
@Transactional
public class InitServiceImpl implements InitService {

	private static final String DUMMY_ADMIN_USER = "wi3tek";

	private static final String DUMMY_ADMIN_PASSWORD = "spoda12345";

	private static final String DUMMY_EMAIL = "patrykwieteskapw@gmail.com";

	private static final String DUMMY_REGISTRATION_REASON = "ADMIN";

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initUser() throws Exception {
// Below initial insert User entity with role Admin
		User user = new User();
		user.setUsername(DUMMY_ADMIN_USER);
		user.setEmail(DUMMY_EMAIL);
		user.setPassword(passwordEncoder.encode(DUMMY_ADMIN_PASSWORD));
		user.setRegistrationDate(LocalDateTime.now());
		user.setRegistrationReason(DUMMY_REGISTRATION_REASON);
		user.setActiveFlag(true);

		Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		Role roleUser = new Role();
		roleUser.setRoleName("ROLE_USER");

		user.getRoles().add(roleAdmin);
		user.getRoles().add(roleUser);


//		Role roleUser = new Role();
//		roleUser.setRoleName("ROLE_USER");
//		User test1 = new User("test1",passwordEncoder.encode("test1"),"test1@bleble.com", "-",LocalDateTime.now(),true);
//		test1.getRoles().add(roleUser);
		userService.saveUser(user);

	}
}
