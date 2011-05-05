package com.augmentum.training.webserver;

public class ConvertionProxy implements com.augmentum.training.webserver.Convertion {
  private String _endpoint = null;
  private com.augmentum.training.webserver.Convertion convertion = null;
  
  public ConvertionProxy() {
    _initConvertionProxy();
  }
  
  public ConvertionProxy(String endpoint) {
    _endpoint = endpoint;
    _initConvertionProxy();
  }
  
  private void _initConvertionProxy() {
    try {
      convertion = (new com.augmentum.training.webserver.ConvertionServiceLocator()).getConvertion();
      if (convertion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)convertion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)convertion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (convertion != null)
      ((javax.xml.rpc.Stub)convertion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.augmentum.training.webserver.Convertion getConvertion() {
    if (convertion == null)
      _initConvertionProxy();
    return convertion;
  }
  
  public double fahrenheitToCentigrade(double f) throws java.rmi.RemoteException{
    if (convertion == null)
      _initConvertionProxy();
    return convertion.fahrenheitToCentigrade(f);
  }
  
  public double centigradeToFahrenheit(double f) throws java.rmi.RemoteException{
    if (convertion == null)
      _initConvertionProxy();
    return convertion.centigradeToFahrenheit(f);
  }
  
  
}