package pb.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pb.com.services.AdminService;

@Controller
public class AdminRegisterController {

    // 管理者サービスを自動的に注入
    @Autowired
    private AdminService adminService;

    // 管理者登録ページの表示を処理するメソッド
    @GetMapping("/admin/register")
    public String getAdminRegisterPage() {
        return "register.html";
    }

    // 管理者登録処理を行うメソッド
    @PostMapping("/admin/register/process")
    public String adminRegisterProcess(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // 新しい管理者を作成し、登録が成功したかどうかを確認
        boolean isRegistered = adminService.createAdmin(name, email, password);

        // 登録が成功しなかった場合（既に存在するメールアドレスの場合）、再度登録ページを表示
        if (!isRegistered) {
            return "register.html";
        }

        // 登録が成功した場合、ログインページにリダイレクト
        return "redirect:/admin/login";
    }
}
