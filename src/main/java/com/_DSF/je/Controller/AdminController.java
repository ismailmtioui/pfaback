package com._DSF.je.Controller;

import com._DSF.je.Entity.Admin;
import com._DSF.je.Service.AdminService;
import com._DSF.je.Util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerAdmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image) {

        try {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(PasswordUtil.hashPassword(password));
            admin.setEmail(email);
            admin.setImage(image.getBytes());

            adminService.registerAdmin(admin);
            return new ResponseEntity<>("Admin registered successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while processing the image", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }
}
