package Beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

    public IndexBean() {

    }

    public String redirectToEvaluation() {
        return "evaluation";
    }

    public String redirectToAnswers(){
        return "Answers";
    }
}
