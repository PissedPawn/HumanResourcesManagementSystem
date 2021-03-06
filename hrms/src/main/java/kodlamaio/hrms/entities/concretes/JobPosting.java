package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_requirements")
	private String jobRequirements;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="number_of_openings")
	private int numberOfOpenings;
	
	@Column(name="stream_date")
	private LocalDate streamDate;

	@Column(name="work_condition")
	private String workCondition;
	
	@Column(name="part_time")
	private boolean partTime;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name= "employer_id")
	private Employer employer;

}
