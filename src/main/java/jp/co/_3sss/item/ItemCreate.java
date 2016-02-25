package jp.co._3sss.item;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import jp.co._3sss.Item;
import jp.co._3sss.session.LoginForm;
import static jp.co._3sss.DatabaseUtil.*;

@ManagedBean
@RequestScoped
public class ItemCreate implements Serializable {
    
    private String name;
    private Long price;
    
    @ManagedProperty(value="#{loginForm}")
    private LoginForm loginForm;
    
    public String create() {
        
        Item item = new Item();
        item.setName(getName());
        item.setPrice(getPrice());
        getItemRepository().save(item);
        
        return "show?id=" + item.getId() + "&faces-redirect=true";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the loginForm
     */
    public LoginForm getLoginForm() {
        return loginForm;
    }

    /**
     * @param loginForm the loginForm to set
     */
    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

}
