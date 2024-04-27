package com.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
    public static void main( String[] args ){
    	
        SessionFactory sf = null;
        Session s = null;
        Transaction tx = null;
        
        try {
        	
        	sf = new Configuration().configure().buildSessionFactory();
        	s  = sf.openSession();
        	tx = s.beginTransaction();
        	
        /*	User u1 = new User("Santhosh","abc123@email.com","Trichy");
        	User u2 = new User("Gouse","xyz987@email.com","Thuraiyur");
        	
        	Product p1 = new Product("Laptop",45000.00,15);
        	Product p2 = new Product("Mobile",17000.00,25);
        	
        	
        	u1.getProducts().add(p1);
        	u1.getProducts().add(p2);
        	u2.getProducts().add(p2);
        	
        	s.save(u1);
        	s.save(u2);
        	s.save(p1);
        	s.save(p2); */
        	
        
      /*  	User u = s.get(User.class, 2L);
        	
        	Product p = s.get(Product.class, 1L);
        	
        	u.getProducts().add(p); 
        	
        	s.save(u);
        	s.save(p);  */
        	
     /*   	User fetchedUser = s.get(User.class, 1L);
        	
        	System.out.println(fetchedUser);
        	
        	for(Product p : fetchedUser.getProducts()) {
        		System.out.println(p);
        	}  */
        	
       /* 	User fetchedUser = s.get(User.class, 1L);
        	
        	System.out.println(fetchedUser.getEmail());
        	
        	fetchedUser.setEmail("email@gmail.com");
        	
        	System.out.println(fetchedUser);  */
        	
        	User fetchedUser = s.get(User.class, 2L);
        	
        	s.delete(fetchedUser);
        	
        	
        	
        }
        catch(HibernateException e) {
        	if(tx != null)
        		tx.rollback();
        	e.printStackTrace();
        }
        catch(Exception e) {
        	if(tx != null)
        		tx.rollback();
        	e.printStackTrace();
        }
        finally {
			if(tx != null)
				tx.commit();
			if(s != null)
				s.close();
			if(sf != null)
				sf.close();
		}
    }
}
