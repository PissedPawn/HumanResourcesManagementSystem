package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithJobPositionCityEmployerDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

	List<JobPosting> getByJobPosition_Title(String title);

	List<JobPosting> getByEmployer_CompanyName(String companyName);

	@Query(value ="Select new kodlamaio.hrms.entities.dtos.JobPostingWithJobPositionCityEmployerDto(jp.id, jp.jobRequirements, jp.salaryMin, jp.salaryMax,  jp.streamDate,jp.numberOfOpenings, jp.applicationDeadline, jp.city.cityName, jp.jobPosition.title, jp.employer.companyName) From JobPosting jp")
	List<JobPostingWithJobPositionCityEmployerDto> getJobPostingWithDetails();

}
