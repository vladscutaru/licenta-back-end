package licenta.dao;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import licenta.model.User;
import licenta.utils.KeyValue;
import licenta.utils.SecurityUtils;

@Repository
public class UserDaoImp extends BaseRepository implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User get(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public User update(long id, User user) {
		Session session = sessionFactory.getCurrentSession();

		User user2 = session.byId(User.class).load(id);
		user2.setBorrowerScore(user.getBorrowerScore());
		user2.setCity(user.getCity());
		user2.setEmail(user.getEmail());
		user2.setId(user.getId());
		user2.setLenderScore(user.getLenderScore());
		user2.setName(user.getName());
		user2.setRating(user.getRating());
		user2.setScore(user.getScore());
		user2.setTelephone(user.getTelephone());
		user2.setType(user.getType());
		user2.setPhoto(user.getPhoto());

		session.flush();
		return user2;

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
	}

	@Override
	public int getEmail(String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email = :myemail ");
		query.setParameter("myemail", password);
		
		List resultList=query.getResultList();
		int resultNo = resultList.size();

		return resultNo;
	}

	@Override
	public long login(KeyValue kv) {
Session session = sessionFactory.getCurrentSession();

	    CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> root = query.from(User.class);

        query = query.select(root)
                .where(cb.equal(root.get("email"), kv.getKey()));

        try {
            User curentUser= session.createQuery(query).getSingleResult();
            String newPassword;
            try {
    			 newPassword=
    					SecurityUtils.getMD5Hash(
    							kv.getValue());
    		} catch (NoSuchAlgorithmException e) {
    			e.printStackTrace();
    			return -1;
    			
    		}
           
            if(curentUser.getPassword().equals(newPassword)){
            	return curentUser.getId();
            	
            }
            else{
            	return -1;
            }
        } catch (NoResultException nre) {
            return -1;
        }
	}

	@Override
	public User getByEmail(String email) {
//		Session session = sessionFactory.getCurrentSession();
//		TypedQuery<User> query = session.createQuery(" from User  where name = ? ",User.class);
//		//query.setParameter(1, email);
//		query.setParameter(0, email);
//		User result=query.getSingleResult();
//		return result;
		
		Session session = sessionFactory.getCurrentSession();
		
	    
	    
	    
	    CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> root = query.from(User.class);

        query = query.select(root)
                .where(cb.equal(root.get("email"), email));

        try {
            return session.createQuery(query).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
	}

	@Override
	public List<String> getAllEmails() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		List<User> userList= query.getResultList();
		List<String> returnList= new ArrayList<String>();
		for(User user:userList){
			returnList.add(user.getEmail());
		}
		return returnList;
	}

}
