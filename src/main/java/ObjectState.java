import org.hibernate.Session;

import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class ObjectState {
 
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setId(123);
		student.setsName("Radha");
		student.setPassoutYear(2021);
		
		
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
	}

}
