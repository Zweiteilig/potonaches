package com.potonaches.valueobj;
/**
 * Write a description of class Person here.
 *
 * @author h.westmoreland
 * @version 01-23-2019
 */
public class Person implements IUser
{
    private int userRowId = 0;
    private int uniqueHash = 1;
    private String consumerEmail;
    private String consumerTelnum;    
    private String consumerColor;
    private Role[] userRoles = null;
    private String consumerCodename;
    private byte[] encryptedPasscode ;   
    private String consumerFirstname;
    private String consumerLastname;
    private String consumerPasscode;
    private String consumerDescription;
    private java.sql.Date consumerDateCreated;
    
    /**
     * Constructor for 
     *  objects of class Person
     */
    public Person(){ 
    }
    public int getId( ){
        return this.userRowId;
    }
    public int setRole(Role r){
        this.userRoles[0] = r;
        return userRoles.length;
    }    
    public Role getRole(final int rID){
        return userRoles[rID];
    }  
    public Role[] getRoles( int userId ){
        return this.userRoles;
    }
    public String getFirstname() {
        return this.consumerFirstname;
    }
    public void setFirstname(String fname) {
        this.consumerFirstname = fname;
    }
    public String getLastname() {
        return this.consumerLastname;
    }
    public void setLastname(String lName) {
        this.consumerLastname = lName;
    }
        public byte[] getEncryptedPassword( ) {
        return this.encryptedPasscode;
    }
    public void setEncryptedPassword(byte[] encryptedPword) {
        this.encryptedPasscode = encryptedPword;
    }
    public java.sql.Date getCreateDate() {
        return this.consumerDateCreated;
    }
    public void setCreateDate(java.sql.Date date) {
        this.consumerDateCreated = date;
    }    
    public String getEmail() {
        return this.consumerEmail;
    }
    public void setEmail(String email) {
        this.consumerEmail = email;
    }
    public String getTelnum() {
        return this.consumerTelnum;
    }
    public void setTelnum(String telnum) {
        this.consumerTelnum = telnum;
    }
    public String getDescription( ){
        return this.consumerDescription;
    }
    public void setDescription( java.lang.String descr ){
        this.consumerDescription = descr;
    }    
    public String getCodename( ){
        return this.consumerCodename;
    }
    public boolean setCodename( String name  ){
        if(name == null )return false;
        if(name != null && name.length()>5)
        this.consumerCodename = name;
        return true;
    }    
    public String getFirstName( ){
        return this.consumerFirstname;
    }
    public void setFirstName( String f ){
        this.consumerFirstname = f;
    }    
    public String getLastName( ){
        return this.consumerLastname;
    }
    public void setLastName( String l ){
        this.consumerLastname = l;
    }    
    
};

