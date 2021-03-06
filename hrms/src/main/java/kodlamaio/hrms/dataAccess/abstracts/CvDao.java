package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer> {

	@Query("select new kodlamaio.hrms.entities.dtos.CvDto(cv.id, cv.language.name, cv.jobExperience.companyName, cv.university.universityName) From Cv cv")
	List<CvDto> getCvDtos();
}
