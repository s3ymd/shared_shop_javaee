package jp.co._3sss.item;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static jp.co._3sss.DatabaseUtil.*;

@ManagedBean
@RequestScoped
public class ItemDelete {
    
    public String delete(Long id) {
        getItemRepository().delete(id);
        return "index";
    }
}
