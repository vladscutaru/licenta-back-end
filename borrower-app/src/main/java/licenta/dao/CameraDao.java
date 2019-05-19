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

@Repository
public class CameraDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Camera save(Camera camera) {
		sessionFactory.getCurrentSession().save(camera);
		return camera;
	}

	public Camera get(int id) {
		return sessionFactory.getCurrentSession().get(Camera.class, id);
	}
	
	public List<Camera> getByCamin(int idCamin) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Camera> query = cb.createQuery(Camera.class);
        Root<Camera> root = query.from(Camera.class);
        query.select(root).where(cb.equal(root.get("camin"), idCamin));
        Query<Camera> q=session.createQuery(query);
        List<Camera> toateCamerele=q.getResultList();
        return toateCamerele;
	}

	public List<Camera> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Camera> cq = cb.createQuery(Camera.class);
		Root<Camera> root = cq.from(Camera.class);
		cq.select(root);
		Query<Camera> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Camera camera) {
		Session session = sessionFactory.getCurrentSession();
		Camera camera2 = session.byId(Camera.class).load(id);
		camera2.setNumarLocuri(camera.getNumarLocuri());
		camera2.setLocuriOcupate(camera.getLocuriOcupate());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Camera camera = session.byId(Camera.class).load(id);
		session.delete(camera);
	}
}
