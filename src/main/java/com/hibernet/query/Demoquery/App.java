package com.hibernet.query.Demoquery;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.model.Laptop;
import com.hibernate.model.Student;

public class App
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();

    	session.beginTransaction();
//    	Random r = new Random();
//
//    	for(int i=1;i<=50;i++) {
//    		Student s = new Student();
//    		s.setRollno(i);
//    		s.setName("Name" + i);
//    		s.setMarks(r.nextInt(100));
//    		session.persist(s);
//    	}

//    	Query q = session.createQuery("from Student where marks > 50");
//    	List<Student> students = q.list();
//    	
//    	for(Student s : students) {
//    		System.out.println(s);
//    	}
    	
//    	Query q = session.createQuery("from Student where rollno = 7");
//    	Student student = (Student) q.uniqueResult();
//    	System.out.println(student);
    	
    	//sql with hibernate(Native query)
//    	SQLQuery query = session.createSQLQuery("select * from student where marks>60");
//    	query.addEntity(Student.class);
//    	List<Student> students = query.list();
//    	
//    	for(Student s : students) {
//    		System.out.println(s);
//    	}
    	
    	SQLQuery query = session.createSQLQuery("select rollno,marks from student where marks>60");
    	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List<Student> students = query.list();
    	
    	for(Object s : students) {
    		Map m = (Map)s;
    		System.out.println(m.get("rollno") + " : " + m.get("marks"));
    	}
    	session.getTransaction().commit();
    }
}
