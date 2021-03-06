package jp.co._3sss.item;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import jp.co._3sss.DatabaseUtil;
import jp.co._3sss.DatabaseUtil;
import jp.co._3sss.Item;
import jp.co._3sss.Item;
import static jp.co._3sss.DatabaseUtil.*;

@ManagedBean
@RequestScoped
public class ItemEdit {
    private Long id;
    private String name;
    private Long price;
    
    public void preRender() {
        Item item = getItemRepository().findOne(id);
        id = item.getId();
        name = item.getName();
        price = item.getPrice();
    }

    public String update() {
        Item item = getItemRepository().findOne(id);
        item.setName(name);
        item.setPrice(price);
        getItemRepository().save(item);
        
        return "show?id=" + item.getId() + "&faces-redirect=true";

    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
}
