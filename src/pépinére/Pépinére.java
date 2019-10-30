/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pépinére;

import Entites.User;
import Services.Impl.UserService;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Pépinére {
/*public static String get(String url) throws IOException{

String source ="";
URL oracle = new URL(url);
URLConnection yc = oracle.openConnection();
BufferedReader in = new BufferedReader(
new InputStreamReader(
yc.getInputStream()));
String inputLine;

while ((inputLine = in.readLine()) != null)
source +=inputLine;
in.close();
return source;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException {
     /* String a=  get(" http://www.perdu.com ");
        System.out.println(a);*/
     User t = new User();
        UserService su = new UserService();
        su.checkLogin(t);
      
       
        
        // TODO code application logic here
      /*  UserService su=new UserService();
       
       User u = new User(4,"al","a","z","h","f","e",14756214,"de");
        System.out.println(u.getId());
        su.update(u);
       */

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    

    }
    
}
