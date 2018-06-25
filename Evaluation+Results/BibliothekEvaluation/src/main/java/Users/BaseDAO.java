package Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;


/**
 * Generisches Guestbook.BaseDAO mit CRUD-Funktionalit�t
 * @author sonja
 *
 * @param <T> Klasse der zu persistierenden Entit�t
 * @param <PK> Typ des PrimaryKeys dieser Klasse
 */
public abstract class BaseDAO<T, PK extends Serializable> {

	private Class<T> type;
	private SessionFactory factory;
	
	
	public BaseDAO (Class<T> type) {
		// Verbindungsaufbau (gleich f�r alle DAO)
		// mit Hilfe der Hibernate-Konfiguration
		this.type = type;
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(UserEntry.class);


		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		this.factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public void save(T entity) {
		Session s = getSession();
		Transaction tx = s.beginTransaction();
		s.save(entity);
		tx.commit();
		s.close();
	};
	

	public List<T> loadAll() {
		Session s = getSession();
		List<T> entities = s.createCriteria(type).list();
		s.close();
		return entities;
	}
	
	public void tearDown() {
		factory.close();
	}
	
	
	protected Session getSession() {
		return factory.openSession();
	}
}
