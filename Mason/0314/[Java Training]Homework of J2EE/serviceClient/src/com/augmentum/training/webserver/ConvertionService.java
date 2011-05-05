/**
 * ConvertionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.augmentum.training.webserver;

public interface ConvertionService extends javax.xml.rpc.Service {
    public java.lang.String getConvertionAddress();

    public com.augmentum.training.webserver.Convertion getConvertion() throws javax.xml.rpc.ServiceException;

    public com.augmentum.training.webserver.Convertion getConvertion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
