package Beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SuccessBean {

    public SuccessBean() {

    }

    public String redirect() {
        return "index";
    }
}
