package system.service;

/**
 * Service for Security.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */
public interface SecurityService {

    String findLoggedInEmployeeLogin();

    void autoLogin(String login, String password);
}
