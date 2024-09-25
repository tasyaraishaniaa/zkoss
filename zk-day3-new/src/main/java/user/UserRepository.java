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

//    public static List<User> users = new ArrayList<>();
//
//    static {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            users.add(new User(
//                    "JohnDoe",
//                    "Male",
//                    sdf.parse("1990-01-01"),
//                    34,
//                    "Jakarta",
//                    "Jakarta Pusat"
//            ));
//            users.add(new User(
//                    "JaneSmith",
//                    "Female",
//                    sdf.parse("1992-05-15"),
//                    31,
//                    "Jawa Barat",
//                    "Bandung"
//            ));
//            users.add(new User(
//                    "MikeJohnson",
//                    "Male",
//                    sdf.parse("1985-09-30"),
//                    38,
//                    "Banten",
//                    "Tangerang"
//            ));
//            users.add(new User(
//                    "EmilyDavis",
//                    "Female",
//                    sdf.parse("1988-12-22"),
//                    35,
//                    "Jakarta",
//                    "Jakarta Barat"
//            ));
//            users.add(new User(
//                    "ChrisBrown",
//                    "Male",
//                    sdf.parse("1993-06-10"),
//                    30,
//                    "Jawa Barat",
//                    "Tangerang Selatan"
//            ));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

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
    public void delete(User user) {
        User u = get(user.getId());
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

}
