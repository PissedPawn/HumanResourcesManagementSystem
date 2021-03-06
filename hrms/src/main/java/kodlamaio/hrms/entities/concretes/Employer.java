package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings" })
@PrimaryKeyJoinColumn(name = "employer_id", referencedColumnName = "id")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

}
