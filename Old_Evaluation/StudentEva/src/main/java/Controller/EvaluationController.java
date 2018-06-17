package Controller;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import EvaluationDatabase.Database_Manager;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author csc4810
 */
@ManagedBean
@SessionScoped
public class EvaluationController {
    //Kurs
    private String kurs;
    
    //Note
    private String note;

    //Plattformen
    private String[] plattformen;

    private String feedback;
    //Constructor
    public EvaluationController() {
        
    }
   
   public String getKurs() {
       return kurs;
   }

   public void setKurs(String kurs) {
       this.kurs = kurs;
   }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }


   public String[] getPlattformen() {
       return plattformen;
   }
   
   public void setPlattformen(String[] plattformen) {
       this.plattformen = plattformen;
   }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String submit() {
        Database_Manager dbm = new Database_Manager();
        dbm.writeToDB(kurs, note, plattformen, feedback);
        return "Success.xhtml";
    }
}

