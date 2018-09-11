/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guestbook;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author HP EliteBook 8440p
 */

@Entity
@Table (name="GuestbookEntry")
public class GuestbookEntryPOJO {
    private String email;
    private String comment;
    private int id;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }


    @Column (name="email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column (name="comment")
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

}
