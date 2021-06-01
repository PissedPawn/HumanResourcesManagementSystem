package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity

@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")

@NoArgsConstructor
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	public Employer(String email, String password, String passwordRepeat, 
			String companyName, String website,String phoneNumber)
	{
		super(email, password, passwordRepeat);
		this.companyName=companyName;
		this.website=website;
		this.phoneNumber=phoneNumber;
		}
}
