package pb.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import pb.com.models.dao.BlogDao;
import pb.com.models.entity.Admin;
import pb.com.models.entity.Blog;

@Controller
public class BlogListController {
    
    // セッション管理用のHttpSessionを自動的に注入
    @Autowired
    private HttpSession session;

    // Blogデータベースアクセスオブジェクトを自動的に注入
    @Autowired
    private BlogDao blogDao;

    // ブログリストの表示を処理するメソッド
    @GetMapping("/blog/list")
    public String getBlogList(Model model) {
        // セッションからログイン中の管理者情報を取得
        Admin admin = (Admin) session.getAttribute("loginAdminInfo");

        // 管理者情報がセッションにない場合、ログインページにリダイレクト
        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            try {
                // 管理者の名前をモデルに追加
                model.addAttribute("Name", admin.getName());
                // すべてのブログを取得し、モデルに追加
                List<Blog> blogs = blogDao.findAll();
                model.addAttribute("blogs", blogs);
                // blog_list.htmlテンプレートを表示
                return "blog_list.html";
            } catch (Exception e) {
                // エラーハンドリング（例外発生時にスタックトレースを出力し、エラーページを表示）
                e.printStackTrace();
                return "error.html"; 
            }
        }
    }
}
