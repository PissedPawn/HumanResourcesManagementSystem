package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_postings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {

	@Id
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="job_requirements")
	private String jobReqirements;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="number_of_openings")
	private int numberOfOpenings;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name= "employer_id")
	private Employer employer;
	
	
	
	
	
	
}
