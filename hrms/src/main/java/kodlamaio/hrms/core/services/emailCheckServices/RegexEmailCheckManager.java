package kodlamaio.hrms.core.services.emailCheckServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class RegexEmailCheckManager implements EmailCheckServiceBase {
	
	Pattern pattern;
	Matcher matcher;
	
	 private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    public RegexEmailCheckManager()
	    {
	        pattern = Pattern.compile(EMAIL_REGEX);
	    }

	    /**
	     * Validate hex with regular expression
	     *
	     * @param email email for validation
	     * @return true valid email, false invalid email
	     */
	   

	@Override
	public boolean ifEmailIsValid(String email) {
		  matcher = pattern.matcher(email);
	        return matcher.matches();
		
	}

}
