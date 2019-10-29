/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greeny;

import DataBase.MyConnection;
import Entities.Event;
import Service.EventService;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author mayssa
 */
public class GREENY { 

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    
    
    public static void main(String[] args) throws ParseException, SQLException  {
        String m = "2019-01-28";
        java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(m);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        Event e = new Event("Greeny", "Ariana", sqlDate, sqlDate, "fini", 20, 20, 5,"");
        EventService eser = new EventService();
        //eser.insererEvenement(e);
        eser.updateEvenement (e,16);
        //eser.deleteEvenementById (5);
        //eser.displayEvenement();
        
        //System.out.println(eser.displayEvenement());
        //eser.selectEvenement();
        //System.out.println(eser.selectEvenement());
        
   
       
    }
    
}
