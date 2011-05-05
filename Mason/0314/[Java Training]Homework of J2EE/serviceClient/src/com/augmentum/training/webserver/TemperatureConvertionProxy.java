package com.augmentum.training.webserver;

public class TemperatureConvertionProxy implements com.augmentum.training.webserver.TemperatureConvertion {
  private String _endpoint = null;
  private com.augmentum.training.webserver.TemperatureConvertion temperatureConvertion = null;
  
  public TemperatureConvertionProxy() {
    _initTemperatureConvertionProxy();
  }
  
  public TemperatureConvertionProxy(String endpoint) {
    _endpoint = endpoint;
    _initTemperatureConvertionProxy();
  }
  
  private void _initTemperatureConvertionProxy() {
    try {
      temperatureConvertion = (new com.augmentum.training.webserver.TemperatureConvertionServiceLocator()).getTemperatureConvertion();
      if (temperatureConvertion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)temperatureConvertion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)temperatureConvertion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (temperatureConvertion != null)
      ((javax.xml.rpc.Stub)temperatureConvertion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.augmentum.training.webserver.TemperatureConvertion getTemperatureConvertion() {
    if (temperatureConvertion == null)
      _initTemperatureConvertionProxy();
    return temperatureConvertion;
  }
  
  public java.lang.String convertTemperature(java.lang.String s) throws java.rmi.RemoteException{
    if (temperatureConvertion == null)
      _initTemperatureConvertionProxy();
    return temperatureConvertion.convertTemperature(s);
  }
  
  
}