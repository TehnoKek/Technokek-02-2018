package main.dao;




import main.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public  class UserDaoTest {


    @Autowired
    private UserDaoSystem userDao;

    private final User testUser;


    public UserDaoTest() {
        this.testUser = new User((long)1,"test", "e.mail@mail.ru", "test", "sdfsd",0,0);
    }

    @Test
    public void signUpSuccess(){
        User test = new User((long)1,"test", "e.mail@mail.ru", "test", "sdfsd",0,0);
        userDao.save(test);
    }

    @Test
    public void signUpDuplicateEmail(){
        userDao.save(testUser);
        try {
            userDao.save(testUser);
        } catch (DuplicateKeyException e) {
            return;
        }
        fail("Key duplicated");
    }


    @Test
    public void loginCorrect(){
        userDao.save(testUser);
        final User user = userDao.getById(testUser.getId());

        assertEquals(testUser.getNickname(), user.getNickname());
        assertEquals(testUser.getPassword(), user.getPassword());
        assertEquals(testUser.getEmail(), user.getEmail());
    }

    @Test
    public void deleteUser(){
        userDao.save(testUser);
        userDao.delete(testUser.getId().intValue());
        final User user = userDao.getById(testUser.getId());
        assertEquals(user, null);
    }

    @Test
    public void userCorrectUpdate(){
        userDao.save(testUser);
        testUser.setNickname("newTest");
        userDao.update(testUser);
        final User user = userDao.getById(testUser.getId());
        assertEquals(user, testUser);
    }

    @Test
    public void findAllUserSuccess() {
        final List<User> usersList = userDao.findAll();
        assertTrue( usersList.isEmpty());
    }

}
