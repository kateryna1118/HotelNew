/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.softserve.hotel.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.softserve.hotel.domain.Person;

/**
 *
 * @author Kateryna
 */
@Repository
public class PersonDAO implements IPersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    public void updatePerson(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    public void removePerson(Long id) {
        Person toDelete = (Person) sessionFactory.getCurrentSession().
                get(Person.class, id);
        if (toDelete != null) {
            sessionFactory.getCurrentSession().delete(toDelete);
        }
    }

    public Person getPerson(Long id) {
        Person toReturn = (Person) sessionFactory.getCurrentSession().
                get(Person.class, id);
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        List<Person> persons = sessionFactory.getCurrentSession().
                createQuery("from Person").list();
        return persons;
    }
}
