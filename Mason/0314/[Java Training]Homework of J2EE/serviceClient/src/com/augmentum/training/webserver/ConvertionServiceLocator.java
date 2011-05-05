/**
 * ConvertionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.augmentum.training.webserver;

public class ConvertionServiceLocator extends org.apache.axis.client.Service implements com.augmentum.training.webserver.ConvertionService {

    public ConvertionServiceLocator() {
    }


    public ConvertionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConvertionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Convertion
    private java.lang.String Convertion_address = "http://localhost:8080/webservicetest/services/Convertion";

    public java.lang.String getConvertionAddress() {
        return Convertion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConvertionWSDDServiceName = "Convertion";

    public java.lang.String getConvertionWSDDServiceName() {
        return ConvertionWSDDServiceName;
    }

    public void setConvertionWSDDServiceName(java.lang.String name) {
        ConvertionWSDDServiceName = name;
    }

    public com.augmentum.training.webserver.Convertion getConvertion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Convertion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConvertion(endpoint);
    }

    public com.augmentum.training.webserver.Convertion getConvertion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.augmentum.training.webserver.ConvertionSoapBindingStub _stub = new com.augmentum.training.webserver.ConvertionSoapBindingStub(portAddress, this);
            _stub.setPortName(getConvertionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConvertionEndpointAddress(java.lang.String address) {
        Convertion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.augmentum.training.webserver.Convertion.class.isAssignableFrom(serviceEndpointInterface)) {
                com.augmentum.training.webserver.ConvertionSoapBindingStub _stub = new com.augmentum.training.webserver.ConvertionSoapBindingStub(new java.net.URL(Convertion_address), this);
                _stub.setPortName(getConvertionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Convertion".equals(inputPortName)) {
            return getConvertion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webserver.training.augmentum.com", "ConvertionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webserver.training.augmentum.com", "Convertion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Convertion".equals(portName)) {
            setConvertionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
