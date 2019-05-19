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

import licenta.model.Camin;

@Repository
public class CaminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Camin save(Camin camin) {
		sessionFactory.getCurrentSession().save(camin);
		return camin;
	}

	public Camin get(int id) {
		return sessionFactory.getCurrentSession().get(Camin.class, id);
	}

	public List<Camin> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Camin> cq = cb.createQuery(Camin.class);
		Root<Camin> root = cq.from(Camin.class);
		cq.select(root);
		Query<Camin> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Camin camin) {
		Session session = sessionFactory.getCurrentSession();
		Camin camin2 = session.byId(Camin.class).load(id);
		camin2.setLocuriOcupate(camin.getLocuriOcupate());
		camin2.setNumeSefCamin(camin.getNumeSefCamin());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Camin camin = session.byId(Camin.class).load(id);
		session.delete(camin);
	}


}
