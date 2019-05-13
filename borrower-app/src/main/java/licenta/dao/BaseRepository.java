package licenta.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 


public class BaseRepository{
        
        @PersistenceContext private EntityManager em;
       
        protected BaseRepository() { }
       
        protected EntityManager getEntityManager() {
                return em;
        }
       
        public void flush() {
                em.flush();
        }
 
        
        public <T> T loadEntity(Object pk, Class<T> clazz) {
                T entity = em.find(clazz, pk);
                return entity;
        }
 
        
        public <T> T mergeEntity(T entityToBePersisted) {
                T merged = em.merge(entityToBePersisted);
                return merged;
        }
 
       
       
}