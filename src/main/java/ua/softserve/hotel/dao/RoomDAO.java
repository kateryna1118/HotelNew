
package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.softserve.hotel.domain.Room;

/**
 *
 * @author Kateryna
 */
public class RoomDAO implements IRoomDAO{

    @Autowired
    private SessionFactory sessionFactory;

    
    public void addRoom(Room room) {
        sessionFactory.getCurrentSession().save(room);
    }

    
    public void updateRoom(Room room) {
        sessionFactory.getCurrentSession().update(room);
    }

    
    public void removeRoom(Long id) {
        Room toDelete = (Room) sessionFactory.getCurrentSession().
				get(Room.class, id);
		if (toDelete != null) {
			sessionFactory.getCurrentSession().delete(toDelete);
		}
    }

    
    public Room getRoom(Long id) {
      Room toReturn = (Room) sessionFactory.getCurrentSession().
				get(Room.class, id);
		return toReturn;
    }

    @SuppressWarnings("unchecked")
    
    public List<Room> getAllRooms() {
       List<Room> rooms = sessionFactory.getCurrentSession().
				createQuery("from Room").list();
		return rooms;
	}

}
