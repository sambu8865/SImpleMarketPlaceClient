package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public Connection.Place[] places(java.lang.String search, java.lang.String placename) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.places(search, placename);
  }
  
  public java.lang.String signUp(java.lang.String fullname, java.lang.String email, java.lang.String phonenumber, java.lang.String pwd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(fullname, email, phonenumber, pwd);
  }
  
  public int addPlace(Connection.Add place) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addPlace(place);
  }
  
  public java.lang.String lastLogin(int userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.lastLogin(userid);
  }
  
  public int reviewPlace(Connection.Review review1) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.reviewPlace(review1);
  }
  
  public int deleteReview(int reviewid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteReview(reviewid);
  }
  
  public Connection.Place[] userplaces(int userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.userplaces(userid);
  }
  
  public Connection.Review[] reviewgen(int placeid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.reviewgen(placeid);
  }
  
  public java.lang.String getusername(java.lang.String userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getusername(userid);
  }
  
  public int signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(username, password);
  }
  
  public Connection.Review[] reviews(int userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.reviews(userid);
  }
  
  public int deletePlace(int placeid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deletePlace(placeid);
  }
  
  
}