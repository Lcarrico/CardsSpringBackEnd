package dev.carrico.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "learner_stack",
            joinColumns = {@JoinColumn(name="learner_id")},
            inverseJoinColumns = {@JoinColumn(name="stack_id")}
    )
    private Set<Stack> stacks = new HashSet<>();

    public Learner(int learnerId, String username, String password, Set<Stack> stacks) {
        this.learnerId = learnerId;
        this.username = username;
        this.password = password;
        this.stacks = stacks;
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

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "learnerId=" + learnerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", stacks=" + stacks +
                '}';
    }
}
