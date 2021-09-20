package kodlamaio.hrms.security;

import static kodlamaio.hrms.security.ApplicationUserRole.*;

import java.util.concurrent.TimeUnit;

import static kodlamaio.hrms.security.ApplicationUserPermission.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private UserDetailsService userDetailsService;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {

		this.passwordEncoder = passwordEncoder;
		this.userDetailsService= userDetailsService;
		
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//
//		http
//
////				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
////				.and()
//		        .csrf().disable()
//				.authorizeRequests()
//				
//				.antMatchers("/").permitAll()
//
//				.anyRequest().authenticated().and().formLogin()
//			    .loginPage("/login").permitAll()
//			    .defaultSuccessUrl("/applicants", true)
//			    .and().rememberMe().tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)).key("blahblahblah")
//			    .and()
//			    .logout()
//			    .logoutUrl("/logout")
//			    .clearAuthentication(true)
//			    .invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID", "remember-me")
//				.logoutSuccessUrl("/login");
//
//	}
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.userDetailsService(userDetailsService);
//	}
	
	

//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails lalehUser = User.builder().username("Laleh").password(passwordEncoder.encode("mestan"))
//				// .roles(APPLICANT.name())
//				.authorities(APPLICANT.getGrantedAuthorities()).build();
//
//		UserDetails vuqarUser = User.builder().username("Vuqar").password(passwordEncoder.encode("vuqar"))
//				// .roles(ADMIN.name())
//				.authorities(ADMIN.getGrantedAuthorities()).build();
//
//		UserDetails qunduzUser = User.builder().username("Qunduz").password(passwordEncoder.encode("qunduz"))
//				// .roles(EMPLOYER.name())
//				.authorities(EMPLOYER.getGrantedAuthorities()).build();
//
//		return new InMemoryUserDetailsManager(lalehUser, vuqarUser, qunduzUser);
//	}
}
