package com.exadel.user.base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MySQLInteraction {
	
	public Session connect() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
	}
	
	public void close(Session session) {
		session.getTransaction().commit();
		session.close();
	}
	
	public List<User> load() {
		Session session = connect();
		Criteria crit = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = crit.list();
		close(session);
		return users;
	}
	
	public void save(User user) {
		Session session = connect();
		session.save(user);
		close(session);
	}
	
	public void delete(int id) {
		User user = getUser(id);
		Session session = connect();
		session.delete(user);
		close(session);
	}
	
	public void update(User user) {
		Session session = connect();
		session.update(user);
		close(session);
	}
	
	public User getUser(int id) {
		Session session = connect();
		Criteria crit = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = crit.add(Restrictions.eq("userID", id)).list();
		User user = new User();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() == id) {
				user = users.get(i);
			}
		}
		return user;
	}
}
