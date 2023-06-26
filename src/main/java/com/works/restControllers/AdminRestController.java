package com.works.restControllers;

import com.works.Models.Admin;
import com.works.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {
    final AdminService adminService;

    @PostMapping("/login")
    public boolean login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

}
