package kodlamaio.hrms.core.services.identityCheckServices;

import kodlamaio.hrms.entities.concretes.Applicant;


public interface IdentityCheckServiceBase {

	boolean checkIfRealPerson(Applicant user);
}
