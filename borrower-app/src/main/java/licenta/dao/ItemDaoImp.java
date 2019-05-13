package licenta.dao;

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

import licenta.model.Item;
import licenta.model.User;

@Repository
public class ItemDaoImp implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Item save(Item item) {
		sessionFactory.getCurrentSession().save(item);
		return item;
	}

	@Override
	public Item get(long id) {
		return sessionFactory.getCurrentSession().get(Item.class, id);
	}

	@Override
	public List<Item> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		Root<Item> root = cq.from(Item.class);
		cq.select(root);
		Query<Item> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Item item) {
		Session session = sessionFactory.getCurrentSession();

		Item item2 = session.byId(Item.class).load(id);
		item2.setDescription(item.getDescription());
		item2.setName(item.getName());
		item2.setOwner(item.getOwner());
		item2.setPeriod(item.getPeriod());
		item2.setPrice(item.getPrice());
		item2.setUsage(item.getUsage());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Item item = session.byId(Item.class).load(id);
		session.delete(item);
	}

	@Override
	public List<Item> getItemsByUser(User user) {

		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Item> query = cb.createQuery(Item.class);

		Root<Item> root = query.from(Item.class);

		query = query.select(root).where(cb.equal(root.get("owner"), user));

		try {
			return session.createQuery(query).getResultList();
		} catch (NoResultException nre) {
			return null;
		}
	}

	
}
