package rmiClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ConversionClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        // Recherche de l'objet distant dans le registre RMI
        IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/conversionObject");

        // La méthode lookup retourne une instance de l'interface distante (IConversion)
        // car IConversion étend l'interface Remote

        // Appel de la méthode distante pour convertir un montant

        System.out.println(stub.convertirMontant(700));
    }
}