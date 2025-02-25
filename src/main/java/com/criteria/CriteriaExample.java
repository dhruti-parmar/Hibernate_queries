package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		
	    	Configuration cfg = new Configuration();
	    	cfg.configure().addAnnotatedClass(Student.class);
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session session = sf.openSession();

	    	session.beginTransaction();
	    	
	    	Criteria c = session.createCriteria(Student.class);
			
//	    	c.add(Restrictions.gt("marks", 60));
//	    	c.add(Restrictions.le("marks", 35));
	    	c.add(Restrictions.like("name", "Dhruti%"));
	    	
			List<Student>students = c.list();
			
			for(Student s : students) {
				System.out.println(s);
			}
	    	session.getTransaction().commit();
	 }
}

