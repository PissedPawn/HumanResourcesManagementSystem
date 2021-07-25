package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithJobPositionCityEmployerDto;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return jobPostingService.add(jobPosting);
	}

	@GetMapping("/getByTitle")
	public DataResult<List<JobPosting>> getByTitle(@RequestParam String title) {
		return jobPostingService.getByTitle(title);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll() {
		return jobPostingService.getAll();
	}

	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobPosting>> getAllSortedByStreamDate() {
		return jobPostingService.getAllSortedByStreamDate();
	}

	@GetMapping("/getAllByCompanyName")
	public DataResult<List<JobPosting>> getByEmployer_CompanyName(@RequestParam String companyName) {
		return jobPostingService.getByEmployer_CompanyName(companyName);
	}

	@GetMapping("/getallPostings")
	public DataResult<List<JobPostingWithJobPositionCityEmployerDto>> getJobPostings() {
		return jobPostingService.getJobPostings();
	}

}
