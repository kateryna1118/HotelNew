package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.HotelOrder;

/**
 *
 * @author Kateryna
 */
@Repository
public class OrderDAO implements IOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrder(HotelOrder order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void updateOrder(HotelOrder order) {
        sessionFactory.getCurrentSession().update(order);
    }

    public void removeOrder(Long id) {
        HotelOrder toDelete = (HotelOrder) sessionFactory.getCurrentSession().
                get(HotelOrder.class, id);
        if (toDelete != null) {
            sessionFactory.getCurrentSession().delete(toDelete);
        }
    }

    public HotelOrder getOrder(Long id) {
        HotelOrder toReturn = (HotelOrder) sessionFactory.getCurrentSession().
                get(HotelOrder.class, id);
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    public List<HotelOrder> getAllOrders() {
        List<HotelOrder> orders = sessionFactory.getCurrentSession().
                createQuery("from Order").list();
        return orders;
    }
}
