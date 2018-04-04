package main.service;

import main.dao.UserDao;
import main.dao.UserDaoSystem;
import main.models.Message;
import main.models.Player;
import main.models.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;


    @Test
    public void registUser() {
        User newUser = new User("password", "login", "password");
        assertEquals(userService.registUser(newUser), new Message<String>(true, "USER_SUCCESSFULLY_REGISTERED"));
        assertEquals(userService.registUser(newUser), new Message<String>(false, "USER_ALREADY_EXISTS"));
    }

    @Test
    public void login() {
    }

    @Test
    public void getUserData() {
    }

    @Test
    public void getScoreBoard() {
    }

    @Test
    public void getPlayer() {

        Long testId = null;
        assertEquals(userService.getPlayer(testId), new Message<String>(false, "NOT_LOGINED"));


        testId = 8L;
        assertEquals(userService.getPlayer(testId), new Message<String>(false, "INVALID_SESSION_ID"));

        testId = 1L;
        final User testUser = userDao.getById(testId);
        assertEquals(userService.getPlayer(testId), new Message<Player>(true, new Player(testUser)));

    }

    @Test
    public void editUser() {
    }

    @Test
    public void loguot() {
    }

    @Test
    public void getUsersFromBD() {
    }
}