/**
 * TemperatureConvertionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.augmentum.training.webserver;

public interface TemperatureConvertionService extends javax.xml.rpc.Service {
    public java.lang.String getTemperatureConvertionAddress();

    public com.augmentum.training.webserver.TemperatureConvertion getTemperatureConvertion() throws javax.xml.rpc.ServiceException;

    public com.augmentum.training.webserver.TemperatureConvertion getTemperatureConvertion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
