package pb.com.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pb.com.models.entity.Blog;
@Repository
@Transactional
public interface BlogDao extends JpaRepository<Blog, Integer> {

	//保存処理と更新処理　インサートとアップデート
    Blog save(Blog blog);// ブログ情報をデータベースに保存または更新します

    //SELECT * FROM blog 
    //用途：ブログの一覧を表示させるときに使用
    List<Blog> findAll();

    //SELECT * FROM blog WHERE title = ?
    //用途：ブログの登録チェックに使用（同じブログタイトルがされないようにする）
    Blog findByTitle(String title);

    //SELECT * FROM blog WHERE post_id= ?
    //用途：編集画面を表示する際に使用
    Blog findByPostId(Integer postId);

    //DELECT FROM blog WHERE post_id = ?
    //用途：削除使用します
    void deleteByPostId(Integer postId);
}
