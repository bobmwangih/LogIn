package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.UserBo;
import models.User;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public ModelAndView getRegistration(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		
		ConfigurableApplicationContext cp = new ClassPathXmlApplicationContext("resource/ApplicationContext.xml");
		UserBo ub =(UserBo) cp.getBean("bizLogic");
		int i = ub.createUser(new User(name,email,password));
		cp.close();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("nm", name);
		mv.addObject("em", email);
		mv.addObject("ps",password);
		
		return mv;
		
	}

}
