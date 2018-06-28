package GuestbookDB;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="GUESTBOOKENTRY")
public class GuestbookEntry {
    public int id;
    public String name;
    public String comment;

    @Id
    @GeneratedValue (strategy=IDENTITY)
    @Column (name="id")
    public int getId() { return id; }

    @Column(name="name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name="comment")
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
