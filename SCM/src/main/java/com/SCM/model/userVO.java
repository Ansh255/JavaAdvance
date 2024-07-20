package com.SCM.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.apache.coyote.http11.filters.VoidOutputFilter;


@Entity
@Table(name="uservo")
public class userVO {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
    @Size(min = 2, max = 30)
	@Column(name="name")
	private String name;
	
	
	@Column(name="email")
	private String email;
	
	@NotNull
    @Size(min = 6, max = 65)
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="about")
	private String about;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	private ContactVO contactvo;

	public ContactVO getContactvo() {
		return contactvo;
	}

	public void setContactvo(ContactVO contactvo) {
		this.contactvo = contactvo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
}
