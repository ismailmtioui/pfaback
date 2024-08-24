package com._DSF.je.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._DSF.je.Entity.Admin;
import com._DSF.je.Repository.AdminRepository;
import com._DSF.je.Util.PasswordUtil;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin registerAdmin(Admin admin) {
        admin.setPassword(PasswordUtil.hashPassword(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
