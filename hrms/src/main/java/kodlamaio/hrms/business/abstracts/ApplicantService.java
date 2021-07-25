package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Applicant;

public interface ApplicantService {

	DataResult<List<Applicant>> getAll();
	Result add(Applicant applicant);
	DataResult<Applicant> getById(int id);
}
