package user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User> queryAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void delete(Integer id) {
        User u = get(id);
        if(u != null) {
            em.remove(u);
        }
    }

    @Transactional
    public User save(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Transactional
    public User update(User user) {
        User selectedUser = get(user.getId());
        selectedUser.setUsername(user.getUsername());
        selectedUser.setGender(user.getGender());
        selectedUser.setBirthday(user.getBirthday());
        selectedUser.setAge(user.getAge());
        selectedUser.setProvince(user.getProvince());
        selectedUser.setCity(user.getCity());
        em.merge(selectedUser);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> search(String keyword) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username LIKE :keyword");
        query.setParameter("keyword", "%" + keyword + "%");
        List<User> resultList = query.getResultList();
        return resultList;
    }

}
