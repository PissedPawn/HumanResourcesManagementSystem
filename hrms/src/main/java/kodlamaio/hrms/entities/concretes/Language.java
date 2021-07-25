package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"})
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@Column(name="name")
	private String name;
	
	@Column(name="writing")
	private int writingId;
	
	@Column(name="listening")
	private int listeningId;
	
	@Column(name="speaking")
	private int speakingId;
	
	@Column(name="reading")
	private int readingId;
	
	@OneToMany(mappedBy="language")
	private List<Cv> cvs;
	
	
}
