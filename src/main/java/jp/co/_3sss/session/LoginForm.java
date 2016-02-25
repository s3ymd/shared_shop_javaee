package jp.co._3sss.session;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jp.co._3sss.User;
import static jp.co._3sss.DatabaseUtil.*;

@ManagedBean
@SessionScoped
public class LoginForm implements Serializable {

    private String loginName;
    private String password;
    
    private User currentUser;
    
    private void createTestUser() {
        if (getUserRepository().findAll().isEmpty()) {
            User temp = new User();
            temp.setLoginName("test");
            temp.setPassword("test");
            getUserRepository().save(temp);
            System.out.println("create test user 'test'");
        }
    }
    
    public String login() {
        createTestUser();
        User user = getUserRepository().findByLoginNameAndPassword(loginName, password);
        if (user == null) {
            return "login";
        } else {
            currentUser = user;
            return "/index?faces-redirect=true";
        }
    }
    
    public void logout() {
        loginName = "";
        password = "";
        currentUser = null;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
