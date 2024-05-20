package pb.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	//admin_idの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	//nameの設定
	private String name;
	
	//emailの設定
	private String email;
	
	//passwordの設定
	private String password;
	
    //空のコンストラクタ
	public Admin() {
	}

	//admin_idが除くコンストラクタ
	public Admin(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	//getter and setter
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	
	
	
	
}
