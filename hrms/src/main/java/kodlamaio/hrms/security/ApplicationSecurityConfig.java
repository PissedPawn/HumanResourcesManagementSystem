package kodlamaio.hrms.security;

import static kodlamaio.hrms.security.ApplicationUserRole.*;
import static kodlamaio.hrms.security.ApplicationUserPermission.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {

		this.passwordEncoder = passwordEncoder;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http

				.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/applicants/**")
				                                       .hasAuthority(APPLICANT_WRITE.getPermission())
				.antMatchers(HttpMethod.GET, "/api/applicants/**")
				                                        .hasAnyRole(EMPLOYER.name(), ADMIN.name(), APPLICANT.name())
				.antMatchers("/", "index", "/css/*", "/js/*").permitAll()

				.anyRequest().authenticated().and().httpBasic();
		
		
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails lalehUser = User.builder().username("Laleh").password(passwordEncoder.encode("mestan"))
				//.roles(APPLICANT.name())
				.authorities(APPLICANT.getGrantedAuthorities())
				.build();

		UserDetails vuqarUser = User.builder().username("Vuqar").password(passwordEncoder.encode("vuqar"))
				//.roles(ADMIN.name())
				.authorities(ADMIN.getGrantedAuthorities())
				.build();

		UserDetails qunduzUser = User.builder().username("Qunduz").password(passwordEncoder.encode("qunduz"))
				//.roles(EMPLOYER.name())
				.authorities(EMPLOYER.getGrantedAuthorities())
				.build();

		return new InMemoryUserDetailsManager(lalehUser, vuqarUser, qunduzUser);
	}
}
