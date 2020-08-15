package lk.ijse.hms.repository;

import ik.ijse.hms.config.JPAConfig;
import ik.ijse.hms.entity.Admin;
import ik.ijse.hms.repo.AdminRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@RunWith(SpringRunner.class)
public class JPAConfigTest {

    @Autowired
    AdminRepo adminRepo;

    @Test
    public void testGetAllCustomer() {
        List<Admin> all = adminRepo.findAll();
        for (Admin admin : all) {
            System.out.println(admin.getId());
        }
    }
}
