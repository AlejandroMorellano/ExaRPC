package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.Methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws XmlRpcException, MalformedURLException {

        Scanner leer = new Scanner(System.in);

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String response2 = null,response = null, nombre = null, p_apellido = null;
        String m_apellido = null, /*año = null, //mes = null, //dia = null,*/ codigoEst = null, sexo = null, persona = null;
        int opc, opc2, mes = 0, año = 0, dia = 0;

        do {
            System.out.println("1.- Registrar\n" +
                    "2.- Consulta\n" +
                    "3.- Salir\n");
            opc = leer.nextInt();

            switch (opc) {
                case 1:

                    System.out.println("1.- Morelos-MS\n" +
                            "2.- AguasCalientes-AS");

                    System.out.println("Coloca tu codigo de estado(letras)");
                    codigoEst = leer.next();
                    System.out.println("Anota tu sexo (H o M");
                    sexo = leer.next();
                    System.out.println("Anota tu nombre (mayusculas)");
                    nombre = leer.next();
                    System.out.println("Anota tu apellido paterno (mayusculas)");
                    p_apellido = leer.next();
                    System.out.println("Anota tu apellido materno (mayusculas)");
                    m_apellido = leer.next();
                    System.out.println("Anota tu año de nacimiento");
                    año = leer.nextInt();
                    System.out.println("Anota tu mes de nacimiento (numero 01)");
                    mes = leer.nextInt();
                    System.out.println("Anota tu dia de nacimiento");
                    dia = leer.nextInt();
                    //System.out.println("El curp es: "+p_apellido.charAt(0)+ p_apellido.charAt(1)+ m_apellido.charAt(0)+ nombre.charAt(0)+ año.charAt(2)+ año.charAt(3)+mes+dia+sexo+codigoEst
                      //      +p_1
                    //      apellido.charAt(2)+p_apellido.charAt(4)+m_apellido.charAt(1)+m_apellido.charAt(0)+año.charAt(1));
                    Object[] data = {nombre, p_apellido, m_apellido, codigoEst, sexo, año, mes, dia};
                    response = (String) client.execute("Methods.obtenerCurp",data);
                    System.out.println("El curp es -> "+response);
                    break;
                case 2:
                    System.out.println("Coloca la curp");
                    persona = leer.next();
                    Object[] data2 = {persona};
                    response2 = (String) client.execute("Methods.buscarCurp",data2);
                    System.out.println("Consulto -> "+response2);
                    break;
            }
        } while (opc != 3);
    }

//    public static String obtenerCurp(String nombre, String p_apellido, String m_apellido, String año, String mes, String dia){
//        String nom = nombre;
//        String a_ape = p_apellido;
//        String m_ape = m_apellido;
//        String fe = año;
//
//        String resultado;
//
//        resultado = String.valueOf(nom.charAt(0)+a_ape.charAt(0)+ a_ape.charAt(1)+ m_ape.charAt(0)+ fe.charAt(2)+ fe.charAt(3)+mes+dia);
//
//        return  resultado;
//    }

}
