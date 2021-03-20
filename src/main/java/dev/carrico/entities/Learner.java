package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name="learner")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "learner_id")
    private int learnerId;

    @Column(name = "username")
    private String username;

    @Column(name = "passname")
    private String password;

    public Learner(int learnerId, String username, String password) {
        this.learnerId = learnerId;
        this.username = username;
        this.password = password;
    }

    public Learner(){}

    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "learnerId=" + learnerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
