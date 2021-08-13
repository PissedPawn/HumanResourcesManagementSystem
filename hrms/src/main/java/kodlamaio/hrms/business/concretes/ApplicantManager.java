package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApplicantService;
import kodlamaio.hrms.core.services.emailCheckServices.EmailCheckServiceBase;
import kodlamaio.hrms.core.services.identityCheckServices.IdentityCheckServiceBase;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ApplicantDao;
import kodlamaio.hrms.entities.concretes.Applicant;

@Service
public class ApplicantManager implements ApplicantService {
	
	final String ROLE_APPLICANT= "ROLE_APPLICANT";

	private ApplicantDao applicantDao;
	private EmailCheckServiceBase emailCheckService;
	private IdentityCheckServiceBase identityCheckService;

	@Autowired
	public ApplicantManager(ApplicantDao applicantDao, EmailCheckServiceBase emailCheckService,
			IdentityCheckServiceBase identityCheckService) {
		this.applicantDao = applicantDao;
		this.emailCheckService = emailCheckService;
		this.identityCheckService = identityCheckService;
	}

	@Override
	public DataResult<List<Applicant>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Applicant>>(applicantDao.findAll(), "Listed");
	}
	
	@Override
	
	public DataResult<Applicant> getById(int id)
	{
		return new SuccessDataResult<Applicant>(applicantDao.getById(id));
	}

	@Override
	public Result add(Applicant applicant) {
		if (applicant.getFirstName() == "" || applicant.getLastName() == "" || applicant.getBirthYear() == 0
				|| applicant.getEmail() == "" || applicant.getPassword() == "" || applicant.getPasswordRepeat() == "") {
			return new ErrorResult("Fill in blanks");
		}

		if (!emailCheckService.ifEmailIsValid(applicant.getEmail())) {
			return new ErrorResult("Enter a valid email");
		}

		if (!applicant.getPassword().equals(applicant.getPasswordRepeat())) {
			return new ErrorResult("Passwords don`t match");
		}

		if (!identityCheckService.checkIfRealPerson(applicant)) {
			return new ErrorResult("Not a real person");
		}

		for (Applicant user : applicantDao.findAll()) {
			if (user.getEmail().equals(applicant.getEmail()))
				return new ErrorResult("Email has been used");

			if (user.getNationalId().equals(applicant.getNationalId()))
				return new ErrorResult("Id has been used");

		}
		
		applicant.setRoles(ROLE_APPLICANT);

		applicantDao.save(applicant);

		return new SuccessResult("Added");
	}

}
