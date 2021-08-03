package kodlamaio.hrms.security;

public enum ApplicationUserPermission {

	APPLICANT_ADDCV("applicant:addCV"), EMPLOYER_ADDJOB("employer:addJob"), APPLICANT_SEECV("applicant:seeCV"),
	APPLICANT_SEEJOB("applicant:seeJob"), EMPLOYER_SEECV("employer:seeCV"), EMPLOYER_SEEJOB("employer:seeJob"),
	APPLICANT_WRITE("applicant:write"), EMPLOYER_WRITE("employer:write");

	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
