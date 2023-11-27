package corbaServer;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import service.ConversionImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionServer {
    public static void main(String[] args) throws NamingException, InvalidName, AdapterInactive, WrongPolicy, ServantNotActive {
        //a.
        ORB orb = ORB.init(args, null);

        //c.
        Context ctx = new InitialContext();
        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        //d.
        ConversionImpl od = new ConversionImpl();
        ctx.rebind("OD", poa.servant_to_reference(od));
        orb.run();
    }
}
