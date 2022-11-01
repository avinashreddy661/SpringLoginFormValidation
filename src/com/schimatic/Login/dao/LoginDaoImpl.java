package com.schimatic.Login.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.schimatic.Login.dao.LoginDao;
import com.schimatic.Login.model.Login;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	@Autowired
	 private SessionFactory sessionFactory;
	
	@Override
	public int loginForm(Login login) {
		// TODO Auto-generated method stub
		
		String ur=login.getUserName();
		String pwd=login.getPassword();
		int q=0;
		sessionFactory.getCurrentSession();
		
        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        String hql = "FROM Register r WHERE r.userName= :u and r.password= :p";
        Query query = session.createQuery(hql);
        query.setParameter("u",ur);
        query.setParameter("p",pwd);
        List li = query.list();
		q=li.size();
		tx.commit();
		session.close();
		return q;
	}

}
