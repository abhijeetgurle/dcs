
package org.me.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://calculator.me.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * @param i
     * @param j
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Add")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Add", targetNamespace = "http://calculator.me.org/", className = "org.me.calculator.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://calculator.me.org/", className = "org.me.calculator.AddResponse")
    @Action(input = "http://calculator.me.org/Calculator/AddRequest", output = "http://calculator.me.org/Calculator/AddResponse")
    public int add(
        @WebParam(name = "i", targetNamespace = "")
        int i,
        @WebParam(name = "j", targetNamespace = "")
        int j);

}