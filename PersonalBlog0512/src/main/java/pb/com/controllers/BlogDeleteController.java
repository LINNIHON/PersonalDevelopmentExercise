package pb.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pb.com.models.entity.Admin;
import pb.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogDeleteController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private HttpSession session;

    @DeleteMapping("/blog/delete/{id}")
    public String blogDelete(@PathVariable("id") Integer blogId) {
        Admin admin = (Admin) session.getAttribute("loginAdminInfo");

        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            if(blogService.deleteBlog(blogId)) {
                return "redirect:/blog/list";
            } else {
                return "redirect:/blog/list/edit" + blogId;
            }
        }
    }
}
