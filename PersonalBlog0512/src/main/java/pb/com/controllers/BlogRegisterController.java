package pb.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pb.com.models.entity.Admin;
import pb.com.models.entity.Blog;
import pb.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogRegisterController {

    @Autowired
    private BlogService blogService;
    
    @Autowired
    private HttpSession session;
    
    @GetMapping("/blog/register")
    public String getBlogRegisterPage(Model model) {
        Admin admin = (Admin) session.getAttribute("loginAdminInfo");
        
        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            model.addAttribute("adminName", admin.getName());
            return "blog_register.html";
        }
    }
    
    @PostMapping("/blog/register/process")
    public String blogRegisterProcess(@RequestParam String title,
                                      @RequestParam String content) {
        Admin admin = (Admin) session.getAttribute("loginAdminInfo");
        
        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            Blog blog = new Blog(admin, title, content);
            blogService.saveOrUpdateBlog(blog);
            return "redirect:/blog/list";
        }
    }
}
