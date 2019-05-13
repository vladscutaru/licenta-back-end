package licenta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import licenta.model.Camera;
import licenta.model.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Student save(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return student;
	}	
	
	public Student get(int id) {
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}
	
	public List<Student> getByCamin(int idCamin) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(cb.equal(root.get("camin"), idCamin));
        Query<Student> q=session.createQuery(query);
        List<Student> camere=q.getResultList();
        return camere;
	}
	
	public List<Student> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query<Student> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(int id, Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student student2 = session.byId(Student.class).load(id);
		student2.setAn(student.getAn());
		student2.setTelefon(student.getTelefon());
		student2.setOrfan(student.isOrfan());
		student2.setSituatieSocialaPrecara(student.isSituatieSocialaPrecara());
		student2.setSituatieMedicalaSpeciala(student.isSituatieMedicalaSpeciala());
		student2.setArhiva(student.getArhiva());
		student2.setCazat(student.isCazat());
		student2.setCamin(student.getCamin());
		student2.setEtaj(student.getEtaj());
		student2.setCamera(student.getCamera());
		student2.setConfirmat(student.isConfirmat());
		session.flush();
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.byId(Student.class).load(id);
		session.delete(student);
		
	}
	
	
}
