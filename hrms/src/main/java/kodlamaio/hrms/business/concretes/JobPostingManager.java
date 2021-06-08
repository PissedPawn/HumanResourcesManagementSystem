package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;


@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao)
	{
		this.jobPostingDao=jobPostingDao;
	}
	@Override
	public Result add(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		
		jobPosting.setStreamDate(LocalDate.now());
		jobPostingDao.save(jobPosting);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobPosting>> getByTitle(String title) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByJobPosition_Title(title));
	}
	@Override
	public DataResult<List<JobPosting>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll());
	}
	@Override
	public DataResult<List<JobPosting>> getAllSortedByStreamDate() {
		// TODO Auto-generated method stub
		 Sort sort = Sort.by(Sort.Direction.DESC, "streamDate");
         return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort));
	}
	@Override
	public DataResult<List<JobPosting>> getByEmployer_CompanyName(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployer_CompanyName(companyName));
	}

}
