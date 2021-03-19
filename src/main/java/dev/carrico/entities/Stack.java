package dev.carrico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="stack")
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stack_id")
    private int stackId;

    @Column(name = "stack_name")
    private String stackName;

    @Column(name = "description")
    private String description;

    public Stack(int stackId, String stackName, String description) {
        this.stackId = stackId;
        this.stackName = stackName;
        this.description = description;
    }

    public Stack(){}

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stackId=" + stackId +
                ", stackName='" + stackName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
