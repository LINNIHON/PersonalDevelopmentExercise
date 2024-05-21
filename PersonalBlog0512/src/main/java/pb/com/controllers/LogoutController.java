package pb.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    // ログアウト処理を行うメソッド
    @GetMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // セッションを無効化する
            session.invalidate();
        }
        // ログインページにリダイレクト
        return "redirect:/admin/login";
    }
}
