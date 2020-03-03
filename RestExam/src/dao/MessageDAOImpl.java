package dao;

import model.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MessageDAOImpl implements MessageDAO {
    @PersistenceContext(unitName = "RestExamPU")
    EntityManager em;

    @Override
    public void create(Message message) {
        em.persist(message);
    }

    @Override
    public List<Message> getAll(Long lastId) {
//        return em.createQuery("FROM Message  AS m", Message.class).getResultList();
        TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE m.id > ?1", Message.class);
        return query.setParameter(1,lastId).getResultList();
    }
}
