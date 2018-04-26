package main.services;

import main.dao.UserDao;
import main.domain.User;
import main.models.error.ErrorStackMessages;
import main.models.error.ErrorTypes;
import main.models.Message;
import main.models.PlayerMessage;
import main.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    public static final long TEST_ID = 8L;
    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Mock
    private HttpSession httpSession;


    @Test
    public void registUser() throws Exception {
        final User newUser = new User( (long) 9,"dsf", "login", "password", null, 0, 0);

        ErrorStackMessages errorStackMessages = new ErrorStackMessages();
//        errorStackMessages.addFieldError("email", ErrorTypes.getErrorsMap().get(ErrorTypes.getUserAlreadyExists()));
        errorStackMessages.addGlobalError(ErrorTypes.getErrorsMap().get(ErrorTypes.getIncorrectEmailOrPassword()));

//        assertEquals(userService.registUser(newUser, httpSession), new Message<>(true, new PlayerMessage(newUser)));
        assertEquals(userService.registUser(newUser, httpSession), new Message<>(false, errorStackMessages));
    }

    @Test
    public void login() {

        final User newUser = new User( (long) 9,"dsf", "login", "password", null, 0, 0);

        ErrorStackMessages errorStackMessages = new ErrorStackMessages();
        errorStackMessages.addGlobalError(ErrorTypes.getErrorsMap().get(ErrorTypes.getIncorrectEmailOrPassword()));

        //assertEquals(userService.login(newUser, httpSession), new Message<>(true, new PlayerMessage(newUser)));
        assertEquals(userService.login(newUser, httpSession), new Message<>(false, errorStackMessages));
    }

    @Test
    public void getPlayer() {

        ErrorStackMessages errorStackMessages = new ErrorStackMessages();
        errorStackMessages.addGlobalError(ErrorTypes.getErrorsMap().get(ErrorTypes.getNotFound()));

        assertEquals(userService.getPlayer(null), new Message<>(false, errorStackMessages));


        Long testId = TEST_ID;
        assertEquals(userService.getPlayer(testId), new Message<>(false, errorStackMessages));

        testId = 1L;
//        final User testUser = userDao.getById(testId);
        //assertEquals(userService.getPlayer(testId), new Message<>(true, new PlayerMessage(userDao.getById(testId))));

    }

    @Test
    public void editUser() throws Exception{

        ErrorStackMessages errorStackMessages = new ErrorStackMessages();
        errorStackMessages.addGlobalError(ErrorTypes.getErrorsMap().get(ErrorTypes.getNotAuthorized()));

        assertEquals(userService.editUser(null, httpSession), new Message<>(false, errorStackMessages));

        final User testUser = new User( (long) 9,"dsf", "login", "password", null, 0, 0);
        userService.registUser(testUser, httpSession);

        final Long testId = (Long) httpSession.getAttribute("userId");
        final User curUser = userDao.getById(testId);

        if (curUser == null) {
            assertEquals(userService.editUser(null, httpSession), new Message<>(false, errorStackMessages));
        }
        else {
            final User newUser = new User(null, "name", "login2", "password2", null, 0, 0);

            if (newUser.getEmail() != null) {
                curUser.setEmail(newUser.getEmail());
            }
            if (newUser.getNickname() != null) {
                curUser.setNickname(newUser.getNickname());
            }
            if (newUser.getPassword() != null) {
                curUser.setPassword(newUser.getPassword());
            }
            userDao.update(curUser);

            assertEquals(userService.editUser(newUser, httpSession), new Message<>(true, new PlayerMessage(curUser)));
        }
    }

    @Test
    public void logout() throws Exception{

        ErrorStackMessages errorStackMessages = new ErrorStackMessages();
        errorStackMessages.addGlobalError(ErrorTypes.getErrorsMap().get(ErrorTypes.getNotAuthorized()));

        assertEquals(userService.loguot(httpSession), new Message<>(false, errorStackMessages));

        final User testUser = new User( (long) 9,"dsf", "login", "password", null, 0, 0);
        userService.registUser(testUser, httpSession);

        final Long testId = (Long) httpSession.getAttribute("userId");
        final User curUser = userDao.getById(testId);
        if (curUser == null) {
            assertEquals(userService.loguot(httpSession), new Message<>(false, errorStackMessages));
        }
        else
            assertEquals(userService.loguot(httpSession), new Message<>(true));
    }

}