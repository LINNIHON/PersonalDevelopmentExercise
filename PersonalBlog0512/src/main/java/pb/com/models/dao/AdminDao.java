package pb.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pb.com.models.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
    //保存処理と更新処理　インサートとアップデート
	Admin save(Admin admin); // 管理者情報をデータベースに保存または更新します。
	//SELECT * FROM admin WHERE email = ?
	//用途：管理者の登録処理をするときに、同じメールアドレスはあってはならない
	Admin findByEmail(String email); // 管理者のメールアドレスに基づいて管理者情報を検索します。
	//SELECT * FROM admin WHERE email AND password = ?
	//用途：ログイン処理と使用。入力したメールアドレスとパスワードが一致しているときだけデータを取得
	Admin findByEmailAndPassword(String email, String password); // メールアドレスとパスワードに基づいて管理者情報を検索します。
	
	 Admin findByAdminId(Integer adminId);
}
