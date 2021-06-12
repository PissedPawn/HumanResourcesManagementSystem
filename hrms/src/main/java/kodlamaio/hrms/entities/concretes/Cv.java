package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

	@Id
	@Column(name="id")
	private int id;
	
	
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne()
	@JoinColumn(name="job_experience_id")
	private JobExperience jobExperience;
}
