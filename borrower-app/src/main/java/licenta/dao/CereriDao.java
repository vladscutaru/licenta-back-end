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

import licenta.model.Camera;
import licenta.model.Cerere;

@Repository
public class CereriDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Cerere save(Cerere admin) {
		sessionFactory.getCurrentSession().save(admin);
		return admin;
	}

	public Cerere get(int id) {
		return sessionFactory.getCurrentSession().get(Cerere.class, id);
	}

	public List<Cerere> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Cerere> cq = cb.createQuery(Cerere.class);
		Root<Cerere> root = cq.from(Cerere.class);
		cq.select(root);
		Query<Cerere> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Cerere cerere) {
		Session session = sessionFactory.getCurrentSession();
		Cerere cerere2 = session.byId(Cerere.class).load(id);
		cerere2.setAn(cerere.getAn());
		cerere2.setTelefon(cerere.getTelefon());
		cerere2.setOrfan(cerere.isOrfan());
		cerere2.setSituatieSocialaPrecara(cerere.isSituatieSocialaPrecara());
		cerere2.setSituatieMedicalaSpeciala(cerere.isSituatieMedicalaSpeciala());
		cerere2.setArhiva(cerere.getArhiva());
		cerere2.setCazat(cerere.isCazat());
		cerere2.setCamin(cerere.getCamin());
		cerere2.setEtaj(cerere.getEtaj());
		cerere2.setCamera(cerere.getCamera());
		cerere2.setStatus(cerere.getStatus());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cerere cerere = session.byId(Cerere.class).load(id);
		session.delete(cerere);
	}

	public List<Cerere> getByIdStudent(int idStudent) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Cerere> q = session.createQuery("SELECT c from Cerere c WHERE c.idStudent=:idStudent");
		q.setParameter("idStudent", idStudent);
        List<Cerere> toateCererile=q.getResultList();
        return toateCererile;
	}

	public List<Cerere> getByIdCamin(int idCamin) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Cerere> query = cb.createQuery(Cerere.class);
        Root<Cerere> root = query.from(Cerere.class);
        query.select(root).where(cb.equal(root.get("camin"), idCamin));
        Query<Cerere> q=session.createQuery(query);
        List<Cerere> toateCererile=q.getResultList();
        return toateCererile;
	}

}
