package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();


}
