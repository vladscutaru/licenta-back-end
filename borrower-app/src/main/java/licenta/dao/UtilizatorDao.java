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

import licenta.model.Utilizator;

@Repository
public class UtilizatorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Utilizator save(Utilizator utilizator) {
		sessionFactory.getCurrentSession().save(utilizator);
		return utilizator;
	}

	public Utilizator get(int id) {
		return sessionFactory.getCurrentSession().get(Utilizator.class, id);
	}

	public List<Utilizator> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utilizator> cq = cb.createQuery(Utilizator.class);
		Root<Utilizator> root = cq.from(Utilizator.class);
		cq.select(root);
		Query<Utilizator> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Utilizator utilizator) {
		Session session = sessionFactory.getCurrentSession();
		Utilizator utilizator2 = session.byId(Utilizator.class).load(id);
		utilizator2.setEmail(utilizator.getEmail());
		utilizator2.setParola(utilizator.getParola());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Utilizator utilizator = session.byId(Utilizator.class).load(id);
		session.delete(utilizator);
	}


}
