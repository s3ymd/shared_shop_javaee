package jp.co._3sss.item;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jp.co._3sss.Item;
import static jp.co._3sss.DatabaseUtil.*;

@ManagedBean
@RequestScoped
public class ItemIndex {
    private List<Item> itemList;
    
    public void preRender() {
        itemList = getItemRepository().findAll();
    }
    
    /**
     * @return the items
     */
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> itemList) {
        this.itemList = itemList;
    }
}
