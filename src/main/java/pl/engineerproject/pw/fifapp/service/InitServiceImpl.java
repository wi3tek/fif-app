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

	private static final String DUMMY_ADMIN_USER = "wi3tek";

	private static final String DUMMY_ADMIN_PASSWORD = "12345";

	private static final String DUMMY_EMAIL = "patrykwieteskapw@gmail.com";

	private static final String DUMMY_REGISTRATION_REASON = "Proszę o dodanie";

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initUser() throws Exception {

		User user = new User();
		user.setUsername(DUMMY_ADMIN_USER);
		user.setEmail(DUMMY_EMAIL);
		user.setPassword(passwordEncoder.encode(DUMMY_ADMIN_PASSWORD));
		user.setRegistrationDate(LocalDateTime.now());
		user.setRegistrationReason(DUMMY_REGISTRATION_REASON);
		user.setActiveFlag(true);

		Role roleAdmin = new Role();
		roleAdmin.setRoleName("ADMIN");
		Role roleUser = new Role();
		roleUser.setRoleName("USER");

		user.getRoles().add(roleAdmin);
		user.getRoles().add(roleUser);

		userService.saveUser(user);

		User user1 = new User();
		user1.setUsername(DUMMY_ADMIN_USER+"2");
		user1.setEmail("zz"+DUMMY_EMAIL);
		user1.setPassword(passwordEncoder.encode(DUMMY_ADMIN_PASSWORD));
		user1.setRegistrationDate(LocalDateTime.now());
		user1.setRegistrationReason(DUMMY_REGISTRATION_REASON+" no i także tego");
		user1.setActiveFlag(true);

		user1.getRoles().add(roleUser);

		userService.saveUser(user1);
	}
}
