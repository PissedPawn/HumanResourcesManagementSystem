package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Applicant;

public interface ApplicantDao extends JpaRepository<Applicant, Integer> {

	Applicant getById(int id);
}
