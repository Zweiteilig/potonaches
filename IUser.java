package com.potonaches.valueobj;


/**
 * Write a description of interface IUser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IUser 
{
    public int getId( );
    public int setRole(Role r); 
    public String getEmail( );
    public void setEmail( String e );
    public String getFirstName( );
    public void setFirstName( String f );
    public String getLastName( );
    public void setLastName( String l );
    public String getCodename( );
    public Role[] getRoles( int userId );
    public byte[] getEncryptedPassword( );
    public boolean setCodename( String name );  
    public void setEncryptedPassword(byte[] pword);
};
