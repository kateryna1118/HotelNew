package ua.softserve.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.hotel.dao.IRoleDAO;
import ua.softserve.hotel.domain.Role;


/**
 *
 * @author Kateryna
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RoleDAOTest {

    @Autowired
    private IRoleDAO roleDAO;

    @Ignore
    @Test
    public void testSave() throws Exception {
        Role role = new Role();
        role.setDescription("description");
        role.setName("name");

        System.out.println(role);
        roleDAO.addRole(role);
        List<Role> roleList = roleDAO.getAllRoles();

        Assert.assertEquals(role, roleList.get(roleList.size() - 1));
        Assert.assertEquals(role.getDescription(),
                roleList.get(roleList.size() - 1).getDescription());
    }

    @Ignore
    @Test
    public void testGet() throws Exception {

        Role role = new Role();
        role.setDescription("discription");
        role.setName("name");

        roleDAO.addRole(role);
        List<Role> rolelList = roleDAO.getAllRoles();

        Role loadedRole = rolelList.get(rolelList.size() - 1);
        Long loadedId = loadedRole.getId();
        Assert.assertEquals(loadedRole, roleDAO.getRole(loadedId));
    }
}
