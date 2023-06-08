package com.company.Admin;
import java.io.Serializable;
import java.util.UUID;

public class User {

    private String name;
    private String userName;
    private String password;
    private String type;
    String uniqueID = UUID.randomUUID().toString();

    public User(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return uniqueID;
    }

    public void setId(String id) {
        this.uniqueID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUserName() {
        return userName;
    }

    public User(String name,String password,String type,String userName){
        this.userName=userName;
        this.name=name;
        this.password=password;
        this.type = type;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Name : "+getName()
                +"\nPassword : "+getPassword()
                +"\nID : "+getId()
        +"\ntype : "+getType();
    }



}
