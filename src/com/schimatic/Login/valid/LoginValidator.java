package com.schimatic.Login.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.schimatic.Login.bean.LoginBean;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginBean.class.isAssignableFrom(clazz);
	}
	
	Pattern pattern;
	 Matcher matcher;
	 Pattern pattern1;
	 Matcher matcher1;

	  private static final String USERNAME_PATTERN = "^[a-zA-z][a-z0-9]*$";
	  private static final String PASSWORD_PATTERN = "^[a-zA-z]((?=.*[0-9])[A-za-z0-9/@/./_])*{8,16}$";

	 public LoginValidator(){
		  pattern = Pattern.compile(USERNAME_PATTERN);
		  pattern1 = Pattern.compile(PASSWORD_PATTERN);
	  }


	  /**
	   * Validate username with regular expression
	   * @param username username for validation
	   * @return true valid username, false invalid username
	   */
	  
	
	@Override
	public void validate(Object target, Errors errors) {
	  
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		LoginBean p = (LoginBean) target;
		String ur=p.getUsername();
		String pwd=p.getPassword();
		if(ur.length()!=0)
		{
		if(ur.contains("username"))
		{
			 errors.rejectValue("username", "username.not.username");
		}
		if(ur.contains("Username"))
		{
			 errors.rejectValue("username", "username.not.username");
		}
		if(ur.contains("password"))
		{
			 errors.rejectValue("username", "username.not.password");
		}
		if(ur.contains("Password"))
		{
			 errors.rejectValue("username", "username.not.password");
		}
		if(ur.length()<6)
		{
			errors.rejectValue("username", "username.not.min6");
		}
		if(ur.length()>16)
		{
			errors.rejectValue("username", "username.not.max16");
		}
		matcher = pattern.matcher(ur);
		if(!matcher.matches())
		{
			errors.rejectValue("username", "username.not.valid");
		}
		}
		if(pwd.length()<8)
		{
			errors.rejectValue("password", "password.not.min6");
		}
		if(pwd.length()>=8)
		{
			if(pwd.contains("username"))
			{
				 errors.rejectValue("password", "password.not.username");
			}
			if(pwd.contains("Username"))
			{
				 errors.rejectValue("password", "password.not.username");
			}
			if(pwd.contains("password"))
			{
				 errors.rejectValue("password", "password.not.password");
			}
			if(pwd.contains("Password"))
			{
				 errors.rejectValue("password", "password.not.password");
			}
			if(pwd.length()>16)
			{
				errors.rejectValue("password", "password.not.max6");
			}
			matcher1 = pattern1.matcher(pwd);
			if(!matcher1.matches())
			{
				errors.rejectValue("password", "password.not.valid");
			}
		
		String[] p3=pwd.split("@");
		String[] p4=pwd.split("\\.");
		String[] p5=pwd.split("_");
		int count1 = pwd.length() - pwd.replaceAll("\\@","").length();
		int count2 = pwd.length() - pwd.replaceAll("\\_","").length();
		int count3 = pwd.length() - pwd.replaceAll("\\.","").length();
		if(count1 == 0 &&count2 == 0 && count3 == 0)
		{
			errors.rejectValue("password", "password.not.contain.splchar");
		}
		if((p3.length >2)&(p4.length > 2)&(p5.length > 2))
		{
			errors.rejectValue("password", "password.contain.onlyone.splchar");
		}
		if((p3.length ==2)&(p4.length == 2))
		{
			errors.rejectValue("password", "password.contain.onlyone.splchar");
		}
		if((p4.length ==2)&(p5.length == 2))
		{
			errors.rejectValue("password", "password.contain.onlyone.splchar");
		}
		if((p3.length ==2)&(p5.length == 2))
		{
			errors.rejectValue("password", "password.contain.onlyone.splchar");
		}
		if(ur.length()>=6)
		{
			String s1=ur.substring(1, 5);
			if(pwd.contains(s1))
			{
				errors.rejectValue("password", "password.not.contain.username");
			}
		}
		}
	}

}
