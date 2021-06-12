package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="universities")
@AllArgsConstructor
@NoArgsConstructor
public class University {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="uniersity_name")
	private String universityName;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="start_year")
	private int startYear;
	
	@Column(name="graduation_year")
	private int graduationYear;
	
	@OneToMany(mappedBy="university")
	private List<Cv> cvs;
	
	
}
