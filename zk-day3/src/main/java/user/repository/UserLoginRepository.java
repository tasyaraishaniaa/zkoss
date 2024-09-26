package user.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.entity.UserLogin;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserLoginRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public UserLogin get(String username) throws NoResultException {
        Query query = em.createQuery("SELECT u FROM UserLogin u WHERE u.username = :username", UserLogin.class);
        query.setParameter("username", username);
        return (UserLogin) query.getSingleResult();
    }
}
