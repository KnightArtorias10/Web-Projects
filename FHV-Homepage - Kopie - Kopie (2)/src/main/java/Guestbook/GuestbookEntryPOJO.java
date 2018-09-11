/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guestbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author HP EliteBook 8440p
 */

@Entity
@Table (name="GuestbookEntry")
public class GuestbookEntryPOJO {
    private String email;
    private String comment;

    @Column (name="email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column (name="comment")
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

}
