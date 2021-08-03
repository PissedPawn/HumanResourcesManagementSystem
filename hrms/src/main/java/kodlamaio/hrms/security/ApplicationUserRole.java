package kodlamaio.hrms.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;
import static kodlamaio.hrms.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
	APPLICANT(Sets.newHashSet(APPLICANT_WRITE)),
	EMPLOYER(Sets.newHashSet(EMPLOYER_ADDJOB, EMPLOYER_SEEJOB, EMPLOYER_SEECV, EMPLOYER_WRITE)),
	ADMIN(Sets.newHashSet(EMPLOYER_ADDJOB, EMPLOYER_SEEJOB, APPLICANT_SEEJOB, APPLICANT_SEECV, APPLICANT_ADDCV,EMPLOYER_SEECV));

	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;

	}
}
