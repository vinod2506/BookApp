package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	private int userId;
	@Column(unique = true,nullable = false )
	private String userName;
	private String password;
	private String email;
	private String mobile;
	@Lob
	private byte[] photo;
	@Transient
	private String photos;
}
