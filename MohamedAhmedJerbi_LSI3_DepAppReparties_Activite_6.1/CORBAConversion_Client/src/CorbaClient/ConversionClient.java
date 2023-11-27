package CorbaClient;

import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class ConversionClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        Object ref = ctx.lookup("OD");
        IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object)ref);
        System.out.println(stub.conversionMontant(70.00));
        System.out.println(stub.conversionMontant(150.00));
    }
}
