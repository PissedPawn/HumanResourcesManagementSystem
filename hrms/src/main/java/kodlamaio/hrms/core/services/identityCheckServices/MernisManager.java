package kodlamaio.hrms.core.services.identityCheckServices;

import org.springframework.stereotype.Service;




import kodlamaio.hrms.entities.concretes.Applicant;

@Service
public class MernisManager implements IdentityCheckServiceBase{
	
	@Override
	public boolean checkIfRealPerson(Applicant user) {
//		KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
//
//		boolean result = kpsPublic.TCKimlikNoDogrula(user.getNationalId(), user.getFirstName().toUpperCase(),
//				user.getLastName().toUpperCase(), user.getBirthYear());
//
//		if (result)
//			return true;
//		else
			return true;
	}

}
