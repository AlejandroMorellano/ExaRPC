package server;

import java.util.ArrayList;
import java.util.Random;

public class Methods {
    DaoCurp daoCurp = new DaoCurp();
    public String obtenerCurp(String nombre, String p_apellido, String m_apellido, String codigoEst, String sexo, int año, int mes,int dia){


        BeanCurp curp = new BeanCurp();

        String a = String.valueOf(año);
        String m = String.valueOf(mes);
        String d = String.valueOf(dia);
        String resultado;
        String CURP = "";

        String mApellido = String.valueOf(m_apellido.charAt(0));
        String mApellido2 = String.valueOf(m_apellido.charAt(1));
        String pApellido4 = String.valueOf(p_apellido.charAt(1));
        String pApellido3 = String.valueOf(p_apellido.charAt(0));
        String pApellido = String.valueOf(p_apellido.charAt(2));
        String pApellido2 = String.valueOf(p_apellido.charAt(4));
        String nom = String.valueOf(nombre.charAt(0));

        String año2 = String.valueOf(a.charAt(2));
        String año3 = String.valueOf(a.charAt(3));

        int random1 = 0;
        int random2 = 0;
        String randomLetras = "abcdefghijklmnopqrstuvwxyz0123456789";

        Random ran = new Random();

        random1 = ran.nextInt(randomLetras.length());
        random2 = ran.nextInt(randomLetras.length());

        char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0',
        '1','2','3','4','5','6','7','8','9'};

        int contador =0;
        //NO JALA
//        String consonante = null;
//        String pimerletra;
        //response = String.valueOf(p_apellido.charAt(0));

//        for(int i=0; i <= consonante.length();i++){
//            if(consonante.charAt(i)!='a'||consonante.charAt(i)!='e'||consonante.charAt(i)!='i'||consonante.charAt(i)!='o'||consonante.charAt(i)!='u'){
//                for(int u=0;u == 2;u++){
//                    pimerletra = consonante.charAt(i)+"";
//                }
//            }
//        }
//NO JALO
//        for(int i = 0;i <= p_apellido.length() - 1;i++){
//            for(int j = 0;j < letras.length;j++){
//                if(contador < 2){
//                    if(p_apellido.charAt(i) == letras[j]){
//                        System.out.println(p_apellido.charAt(i));
//                        nuevo = String.valueOf(p_apellido.charAt(i));
//                        contador ++;
//                    }
//                }
//            }
//        }
//NO JALO
//        for(int i = 0; i <= m_apellido.length()-1;i++){
//            for(int j = 0;j < letras.length;j++){
//                if(contador < 2){
//                    if(m_apellido.charAt(i) == letras[j]){
//                        System.out.println(m_apellido.charAt(i));
//                        nuevo2 = String.valueOf(m_apellido.charAt(i));
//                        contador ++;
//                    }
//                }
//            }
//        }

        //System.out.println("dsadsa"+p_apellido.charAt(0));
        resultado = (pApellido3/*p_apellido.charAt(0)*/+ pApellido4/*p_apellido.charAt(1)*/+ mApellido+ nom+ año2+ año3+m+d+sexo+codigoEst
               +pApellido+pApellido2+mApellido2+letras[random1]+letras[random2]);
  //            p_apellido.charAt(2)+p_apellido.charAt(4)//m_apellido.charAt(1) m_apellido.charAt(1)
       CURP = resultado;

       curp.setNombre(nombre);
       curp.setP_apellido(p_apellido);
       curp.setM_apellido(m_apellido);
       curp.setAño(año);
       curp.setMes(mes);
       curp.setDia(dia);
       curp.setCodigoEst(codigoEst);
       curp.setSexo(sexo);
       curp.setCURP(CURP);

       daoCurp.guardarCurp(curp);

        return  CURP.toUpperCase();
    }

    public String buscarCurp(String CURP){
        String todo = null;
        BeanCurp curp = daoCurp.verCurp(CURP);

        todo = curp.getNombre()+ " " + curp.getP_apellido()+ " " + curp.getM_apellido()+ " " + curp.getAño()+ " " + curp.getMes()+ " " + curp.getDia()+ " " + curp.getCodigoEst()+ " " + curp.getSexo();

        return todo;
    }
}
