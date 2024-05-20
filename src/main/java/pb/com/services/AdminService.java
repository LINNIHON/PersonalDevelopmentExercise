package pb.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pb.com.models.dao.AdminDao;
import pb.com.models.entity.Admin;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    // 保存処理（登録処理）
    public boolean createAdmin(String name, String email, String password) {
        if (adminDao.findByEmail(email) == null) {
            adminDao.save(new Admin(name, email, password));
            return true;
        } else {
            return false;
        }
    }

}
