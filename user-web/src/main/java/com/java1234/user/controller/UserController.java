package com.java1234.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java1234.user.entity.User;
import com.java1234.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User userResulr = userService.login(user);
		if (null == userResulr) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "index";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);

			return "redirect:/success.jsp";
		}
	}
}
