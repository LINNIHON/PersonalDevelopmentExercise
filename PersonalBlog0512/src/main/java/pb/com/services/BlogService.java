package pb.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pb.com.models.dao.AdminDao;
import pb.com.models.dao.BlogDao;
import pb.com.models.entity.Admin;
import pb.com.models.entity.Blog;

@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminService adminService;

    public List<Blog> selectAllBlog(Integer adminId) {
        return blogDao.findAllByAdmin_AdminId(adminId);
    }

    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    public Blog saveOrUpdateBlog(Blog blog) {
        return blogDao.save(blog);
    }

    public Blog getBlogById(Integer id) {
        return blogDao.findByPostId(id);
    }

    @Transactional
    public Blog createBlogPost(String adminEmail, String title, String content) {
        Admin admin = adminService.findAdminByEmail(adminEmail);
        if (admin == null) {
            throw new IllegalArgumentException("Admin not found");
        }
        Blog blog = new Blog(admin, title, content);
        return blogDao.save(blog);
    }

    @Transactional
    public boolean deleteBlog(Integer blogId) {
        try {
            blogDao.deleteByPostId(blogId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Blog> getAllBlogsByAdminId(Integer adminId) {
        return blogDao.findAllByAdmin_AdminId(adminId);
    }
}

