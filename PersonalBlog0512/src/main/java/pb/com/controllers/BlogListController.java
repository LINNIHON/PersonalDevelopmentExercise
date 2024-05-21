package pb.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import pb.com.models.entity.Admin;
import pb.com.models.entity.Blog;
import pb.com.services.BlogService;

@Controller
public class BlogListController {

    @Autowired
    private HttpSession session;

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/list")
    public String getBlogList(Model model) {
        Admin admin = (Admin) session.getAttribute("loginAdminInfo");

        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            try {
                model.addAttribute("adminName", admin.getName());

                List<Blog> blogList = blogService.selectAllBlog(admin.getAdminId());
                model.addAttribute("blogList", blogList);

                return "blog_list.html";
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
    }
}
