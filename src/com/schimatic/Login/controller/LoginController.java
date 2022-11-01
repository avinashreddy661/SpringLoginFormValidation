package com.schimatic.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schimatic.Login.model.Login;
import com.schimatic.Login.service.LoginService;
import com.schimatic.Login.valid.LoginValidator;
import com.schimatic.Login.bean.LoginBean;


@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("command")LoginBean loginBean){
		return new ModelAndView("loginForm");
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView log(@ModelAttribute("command")LoginBean loginBean,
	   BindingResult result) {
		LoginValidator lv=new LoginValidator();
		lv.validate(loginBean, result);
		if(result.hasErrors())
		{
			return new ModelAndView("loginForm");
		}
		else
		{
			int n=loginService.loginForm(prepareModel(loginBean));
			if(n==0)
			{
				return new ModelAndView("Fail"); 
			}
	    return new ModelAndView("Success");
		}  
	 }
	private Login prepareModel(LoginBean loginBean) {
		// TODO Auto-generated method stub
		Login login=new Login();
		login.setUserName(loginBean.getUsername());
		login.setPassword(loginBean.getPassword());
		return login;
	}
	
}
