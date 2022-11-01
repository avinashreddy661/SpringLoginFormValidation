package com.schimatic.Login.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.schimatic.Login.dao.LoginDao;
import com.schimatic.Login.model.Login;

@Service("registerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService{

	
	 @Autowired
	 private LoginDao loginDao;
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	public int loginForm(Login login) {
		// TODO Auto-generated method stub
		int n=loginDao.loginForm(login);
		return n;
	}

}
