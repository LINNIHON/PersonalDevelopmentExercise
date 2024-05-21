package pb.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pb.com.services.LoginService;
import pb.com.models.entity.Admin;

@Controller
public class LoginController {
    
    // ログインサービスを自動的に注入
    @Autowired
    private LoginService loginService;

    // セッション管理用のHttpSessionを自動的に注入
    @Autowired
    private HttpSession session;

    // ログイン画面の表示を処理するメソッド
    @GetMapping("/admin/login")
    public String getLoginPage() {
        return "login.html";
    }

    // ログイン処理を行うメソッド
    @PostMapping("/admin/login/process")
    public String loginProcess(@RequestParam String email, @RequestParam String password) {
        // ログインチェックを行い、結果をAdminオブジェクトに格納
        Admin admin = loginService.loginCheck(email, password);

        // ログイン成功の場合、セッションに管理者情報を保存し、ブログリストページにリダイレクト
        if (admin != null) {
            session.setAttribute("loginAdminInfo", admin);
            return "redirect:/blog/list"; // ログイン成功後のリダイレクト先
        } else {
            // ログイン失敗の場合、再度ログインページを表示
            return "login.html"; 
        }
    }

    // ログイン画面から新規登録画面への遷移を処理するメソッド
    @GetMapping("/admin/login/register")
    public String redirectToRegisterPage() {
        return "redirect:/admin/register";
    }
}
