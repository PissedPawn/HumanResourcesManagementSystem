package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingWithJobPositionCityEmployerDto {

	private int id;

	private String jobRequirements;

	private int salaryMin;

	private int salaryMax;

	private LocalDate applicationDeadline;

	private int numberOfOpenings;

	private LocalDate streamDate;
	
	private String title;

	private String cityName;

	private String companyName;
}
