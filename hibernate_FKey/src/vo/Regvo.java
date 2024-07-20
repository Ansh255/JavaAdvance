package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Register_table")
public class Regvo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RegId")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@ManyToOne
	@JoinColumn(name = "login_id")
	private Loginvo loginvo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Loginvo getLoginvo() {
		return loginvo;
	}

	public void setLoginvo(Loginvo loginvo) {
		this.loginvo = loginvo;
	}

}
