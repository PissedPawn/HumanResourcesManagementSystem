package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")

@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Email
	@NotBlank
	@NotNull
	@Column(name = "email")
	private String email;

	@NotBlank
	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "password_repeat")
	private String passwordRepeat;

//	public User(String email, String password, String passwordRepeat) {
//		this.email = email;
//		this.password = password;
//		this.passwordRepeat= passwordRepeat;
//
//	}
}
