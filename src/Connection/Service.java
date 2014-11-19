/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public Connection.Place[] places(java.lang.String search, java.lang.String placename) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String fullname, java.lang.String email, java.lang.String phonenumber, java.lang.String pwd) throws java.rmi.RemoteException;
    public int addPlace(Connection.Add place) throws java.rmi.RemoteException;
    public java.lang.String lastLogin(int userid) throws java.rmi.RemoteException;
    public int reviewPlace(Connection.Review review1) throws java.rmi.RemoteException;
    public int deleteReview(int reviewid) throws java.rmi.RemoteException;
    public Connection.Place[] userplaces(int userid) throws java.rmi.RemoteException;
    public Connection.Review[] reviewgen(int placeid) throws java.rmi.RemoteException;
    public java.lang.String getusername(java.lang.String userid) throws java.rmi.RemoteException;
    public int signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public Connection.Review[] reviews(int userid) throws java.rmi.RemoteException;
    public int deletePlace(int placeid) throws java.rmi.RemoteException;
}
