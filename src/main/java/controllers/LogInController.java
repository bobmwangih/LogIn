package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.UserBo;

@Controller
public class LogInController {
	
	@RequestMapping("/login")
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		ConfigurableApplicationContext cp =new ClassPathXmlApplicationContext("resource/ApplicationContext.xml");
		UserBo ub = (UserBo) cp.getBean("bizLogic");
		
		boolean stat = ub.logInUser(email, password);
		
		if (stat == true) {
			ModelAndView mv1 = new ModelAndView();
			mv1.setViewName("display.jsp");
			mv1.addObject("nm", email);
			mv1.addObject("pas", password);
			return mv1;
		} else {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("failed.jsp");
			return mv2;
		}
	
	}
	

}
