package com.works.service;

import com.works.Models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class AdminService {
    final HttpServletRequest request;
    final HttpServletResponse response;

    public boolean login(Admin admin){
        if (admin.getEmail().equals("mert@mail.com") && admin.getPassword().equals("12345")){
            request.getSession().setAttribute("user",admin.getEmail());
            return true;
        }

        return false;
    }

}
