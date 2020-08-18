package com.sarkariblackboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "loginform";
    }

    @RequestMapping(value = "/loginsuccess")
    public String loginsuccessmethod(HttpSession session) {
        System.out.println("success..........");

//        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
//        User us = user.viewUser(userid);
//        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        String page = "";
//        String rolea = "ROLE_ADMIN";
//        String rolet = "ROLE_TEACHER";
//        String roles = "ROLE_STUDENT";
//        String roleg = "ROLE_GUARDIAN";
//        for (GrantedAuthority authority : authorities) {
//
//            if (authority.getAuthority().equals(rolea)) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("Userphone", us.getPhone());
//                session.setAttribute("email", us.getEmailid());
//                session.setAttribute("UserId", userid);
//                session.setAttribute("markCart", new ArrayList<MarksCart>());
//                page = "redirect:/adminpanel";
//            } else if (authority.getAuthority().equals(rolet)) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("Userphone", us.getPhone());
//                session.setAttribute("email", us.getEmailid());
//                session.setAttribute("role", us.getRole());
//                session.setAttribute("UserId", userid);
//                session.setAttribute("teinfo", ts.showOneTeacherbyEmail(userid));
//                page = "redirect:/teacherpanel";
//            } else if (authority.getAuthority().equals(roles)) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("email", us.getEmailid());
//                session.setAttribute("UserId", userid);
//                session.setAttribute("role", us.getRole());
//                session.setAttribute("stinfo", std.showOneStudentbyEmail(userid));
//                page = "redirect:/studentpanel";
//            }else if (authority.getAuthority().equals(roleg)) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("Userphone", us.getPhone());
//                session.setAttribute("email", us.getEmailid());
//                session.setAttribute("UserId", userid);
//                page = "redirect:/guardianpanel";
//            }else {
//                page = "redirect:/";
//            }
//
//        }
        return "page";
    }
}
