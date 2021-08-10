package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.MyUserDetails;
import kodlamaio.hrms.entities.concretes.User;

@Service

public class UserManager implements UserService {
	
	private UserDao userDao;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserManager(UserDao userDao,  PasswordEncoder passwordEncoder) {
		super();
		this.userDao = userDao;
		this.passwordEncoder=passwordEncoder;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<User> user = userDao.findByUserName(username);
		user.get().setPassword(passwordEncoder.encode(user.get().getPassword()));
		
		return user.map(MyUserDetails::new).get();
	}
}
