package pb.com.models.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pb.com.models.entity.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer> {
    
    // 保存処理と更新処理　インサートとアップデート
    Blog save(Blog blog);

    // 管理者IDでブログを取得するメソッド
    List<Blog> findAllByAdmin_AdminId(Integer adminId);

    // SELECT * FROM blog WHERE post_id= ?
    Blog findByPostId(Integer postId);

    // DELETE FROM blog WHERE post_id = ?
    void deleteByPostId(Integer postId);
}

