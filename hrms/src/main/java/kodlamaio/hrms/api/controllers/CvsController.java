package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

	private CvService cvService;
	
	@Autowired
	public CvsController(CvService cvService)
	{
		this.cvService=cvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv)
	{
		return cvService.add(cv);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll()
	{
		return cvService.getAll();
	}
	
	@GetMapping("/getAllDtos")
	public DataResult<List<CvDto>> getAllDtos()
	{
		return cvService.getAllCvDtos();
	}
	
}
