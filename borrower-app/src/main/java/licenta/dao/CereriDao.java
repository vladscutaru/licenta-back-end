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

import licenta.model.Cereri;

@Repository
public class CereriDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Cereri save(Cereri cereri) {
		sessionFactory.getCurrentSession().save(cereri);
		return cereri;
	}

	public Cereri get(int id) {
		return sessionFactory.getCurrentSession().get(Cereri.class, id);
	}

	public List<Cereri> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Cereri> cq = cb.createQuery(Cereri.class);
		Root<Cereri> root = cq.from(Cereri.class);
		cq.select(root);
		Query<Cereri> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Cereri cereri) {
		Session session = sessionFactory.getCurrentSession();
		Cereri cereri2 = session.byId(Cereri.class).load(id);
		cereri2.setAn(cereri.getAn());
		cereri2.setTelefon(cereri.getTelefon());
		cereri2.setOrfan(cereri.isOrfan());
		cereri2.setSituatieSocialaPrecara(cereri.isSituatieSocialaPrecara());
		cereri2.setSituatieMedicalaSpeciala(cereri.isSituatieMedicalaSpeciala());
		cereri2.setArhiva(cereri.getArhiva());
		cereri2.setCazat(cereri.isCazat());
		cereri2.setCamin(cereri.getCamin());
		cereri2.setEtaj(cereri.getEtaj());
		cereri2.setCamera(cereri.getCamera());
		cereri2.setConfirmat(cereri.isConfirmat());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cereri cereri = session.byId(Cereri.class).load(id);
		session.delete(cereri);
	}


}
