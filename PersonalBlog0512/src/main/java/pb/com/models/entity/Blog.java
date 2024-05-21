package pb.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Blog {
<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    private String title;
    private String content;

    public Blog() {
    }

    public Blog(Admin admin, String title, String content) {
        this.admin = admin;
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
=======
	//postIdの設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	//adminの設定
	@ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
	private Admin admin;
	//titleの設定
	private String title;
	//contentの設定
	private String content;
	//空のコンストラクタ
	public Blog() {
	}
	//post_idが除くコンストラクタ
	public Blog(Admin admin, String title, String content) {
		this.admin = admin;
		this.title = title;
		this.content = content;
	}
	// Getters and Setters
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
>>>>>>> ec12a215db9cfbba1925897a80736355e81935ec
}
