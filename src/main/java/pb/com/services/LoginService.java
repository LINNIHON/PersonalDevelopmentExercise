package pb.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pb.com.models.dao.AdminDao;
import pb.com.models.entity.Admin;

@Service
public class LoginService {
    @Autowired
    private AdminDao adminDao;

    // ログイン処理
    public Admin loginCheck(String email, String password) {
        return adminDao.findByEmailAndPassword(email, password);
    }
}
