package licenta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import licenta.model.Admin;

@Repository
public class AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Admin save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		return admin;
	}

	public Admin get(int id) {
		return sessionFactory.getCurrentSession().get(Admin.class, id);
	}

	public List<Admin> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Admin> cq = cb.createQuery(Admin.class);
		Root<Admin> root = cq.from(Admin.class);
		cq.select(root);
		Query<Admin> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin2 = session.byId(Admin.class).load(id);
		admin2.setNumeAdmin(admin.getNumeAdmin());
		admin2.setEmailAdmin(admin.getEmailAdmin());
		admin2.setCamin(admin.getCamin());
		admin2.setTelefonAdmin(admin.getTelefonAdmin());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = session.byId(Admin.class).load(id);
		session.delete(admin);
	}

}
