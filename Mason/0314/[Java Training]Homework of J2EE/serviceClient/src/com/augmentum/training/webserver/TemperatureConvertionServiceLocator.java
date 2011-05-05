/**
 * TemperatureConvertionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.augmentum.training.webserver;

public class TemperatureConvertionServiceLocator extends org.apache.axis.client.Service implements com.augmentum.training.webserver.TemperatureConvertionService {

    public TemperatureConvertionServiceLocator() {
    }


    public TemperatureConvertionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TemperatureConvertionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TemperatureConvertion
    private java.lang.String TemperatureConvertion_address = "http://localhost:8080/webservicetest/services/TemperatureConvertion";

    public java.lang.String getTemperatureConvertionAddress() {
        return TemperatureConvertion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TemperatureConvertionWSDDServiceName = "TemperatureConvertion";

    public java.lang.String getTemperatureConvertionWSDDServiceName() {
        return TemperatureConvertionWSDDServiceName;
    }

    public void setTemperatureConvertionWSDDServiceName(java.lang.String name) {
        TemperatureConvertionWSDDServiceName = name;
    }

    public com.augmentum.training.webserver.TemperatureConvertion getTemperatureConvertion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TemperatureConvertion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTemperatureConvertion(endpoint);
    }

    public com.augmentum.training.webserver.TemperatureConvertion getTemperatureConvertion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.augmentum.training.webserver.TemperatureConvertionSoapBindingStub _stub = new com.augmentum.training.webserver.TemperatureConvertionSoapBindingStub(portAddress, this);
            _stub.setPortName(getTemperatureConvertionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTemperatureConvertionEndpointAddress(java.lang.String address) {
        TemperatureConvertion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.augmentum.training.webserver.TemperatureConvertion.class.isAssignableFrom(serviceEndpointInterface)) {
                com.augmentum.training.webserver.TemperatureConvertionSoapBindingStub _stub = new com.augmentum.training.webserver.TemperatureConvertionSoapBindingStub(new java.net.URL(TemperatureConvertion_address), this);
                _stub.setPortName(getTemperatureConvertionWSDDServiceName());
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
        if ("TemperatureConvertion".equals(inputPortName)) {
            return getTemperatureConvertion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webserver.training.augmentum.com", "TemperatureConvertionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webserver.training.augmentum.com", "TemperatureConvertion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TemperatureConvertion".equals(portName)) {
            setTemperatureConvertionEndpointAddress(address);
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
