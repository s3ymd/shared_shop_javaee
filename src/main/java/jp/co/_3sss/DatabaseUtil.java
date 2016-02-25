package jp.co._3sss;

import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

public class DatabaseUtil {
    private static ApplicationContext getApplicationContext() {
        return FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
    }
    
    public static ItemRepository getItemRepository() {
        return getApplicationContext().getBean(ItemRepository.class);
    }
    
    public static UserRepository getUserRepository() {
        return getApplicationContext().getBean(UserRepository.class);
    }
}
