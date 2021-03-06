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

import kodlamaio.hrms.business.abstracts.ApplicantService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Applicant;

@RestController
@RequestMapping("/api/applicants")
@CrossOrigin
public class ApplicantsController {

	private ApplicantService applicantService;

	@Autowired
	public ApplicantsController(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	@GetMapping("/getall")
	public DataResult<List<Applicant>> getAll() {
		return applicantService.getAll();

	}
	
	
	@GetMapping("/getbyId")
	public DataResult<Applicant> getbyId(@RequestParam int id) {
		return applicantService.getById(id);

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Applicant applicant) {
		
		return applicantService.add(applicant);

	}

}
