package Service;
import DataBase.MyConnection;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UserService {
     private Connection connection;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;
      

    
    public UserService() throws SQLException {
    
    connection=MyConnection.getInstance().getCnx();
   
}
     public void update(User t) {
        try {
            String requete = " update Users set nom=?,prenom=?,login=?,mps=?,adresse=?,email=?,phone=?,type=? where id=?";
                   
            pst = connection.prepareStatement(requete);
            pst.setObject(1,t.getNom());
            pst.setObject(2,t.getPrenom());
            pst.setObject(3,t.getLogin());
            pst.setObject(4,t.getMps());
            //pst.setObject(5,t.getPhotoURL());
            pst.setObject(5,t.getAdresse());
            pst.setObject(6,t.getEmail());
            pst.setObject(7,t.getPhone());
           // pst.setObject(9,t.getScore());
            pst.setObject(8,t.getType());
            pst.setObject(9,t.getId());
            pst.executeUpdate();
            System.out.println("user modif�");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public  User logIn(User t) throws SQLException
    {
       
          
        String req = "SELECT * FROM users where (login = ? and mps = ?)";
            pst = connection.prepareStatement(req);
            pst.setObject(1,t.getLogin());
            pst.setObject(2,t.getMps());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                User u =new User();
                
                return u;
            }
            return null;
}
     public  String password(String email) throws SQLException
    {
       
          
        String req = "SELECT mps FROM users where (email = email)";
           pst = connection.prepareStatement(req);
           // pst.setObject(1,email);
          
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                User u =new User();
                
                return u.getMps();
            }
            return null;}
     
      public void insert(User t) {
     try {
              
            String requete ="insert into users(nom,prenom,login,mps,cin,adresse,email,phone,type) values(?,?,?,?,?,?,?,?,?)";
        
            pst = connection.prepareStatement(requete);
            pst.setObject(1,t.getNom());
            pst.setObject(2,t.getPrenom());
            pst.setObject(3,t.getLogin());
            pst.setObject(4,t.getMps());
            pst.setObject(5,t.getCin());

            pst.setObject(6,t.getAdresse());
            pst.setObject(7,t.getEmail());
            if(t.getPhone()!=-1)
            {
                 pst.setObject(8,t.getPhone());
            }
            else {
                pst.setNull(8, (int)t.getPhone());
            }
           
            pst.setObject(9,"normal");
             
            
            pst.executeUpdate();
            System.out.println("base");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }}
     
      public boolean checkCin(User t)throws SQLException{
        String req = "SELECT * FROM users where "
                   + "(cin = ? )";
            pst = connection.prepareStatement(req);
            pst.setObject(1,t.getCin());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            return false;
    }
    public boolean checkLogin(User t)throws SQLException{
        String req = "SELECT * FROM users where "
                   + "(login = ? )";
            pst = connection.prepareStatement(req);
            pst.setObject(1,t.getLogin());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            return false;
         
        
    }
    public void delete(User supprime)  {
        try {
            String requete = " delete from users where id=?" ;
            pst = connection.prepareStatement(requete);
            pst.setObject(1,supprime.getId());
            pst.executeUpdate();
            System.out.println("user supprim�");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public List<User> getAll() {
       List<User> list = new ArrayList<>();
        String requete = " select * from users" ;
        try {
                ste = connection.createStatement();
                res=ste.executeQuery(requete);
                while(res.next()){
                   
                      System.out.println(res.getInt(1));
                 
                    //System.out.println(res.getString("login_user"));
               User a = new User(res.getString("nom"), res.getString("prenom"), res.getString("login"), res.getString("mps"), res.getInt("cin"), res.getString("adresse"), res.getString("email"), res.getInt("phone"), res.getString("type"));
               list.add(a);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return list ;
    }
         public User getUserByLogin(String login) throws SQLException{
        String requete = " select * from users where (login=?)" ;
         User t = new User();
        try {
           
            
            pst = connection.prepareStatement(requete);
            pst.setObject(1,login);
            ResultSet res= pst.executeQuery();
            while (res.next())
            {
             /*   Blob blob = res.getBlob(7);
                File picture =new File("C:\\Users\\Dhia\\Desktop\\PIDEV\\CRUD\\src\\fixit\\img\\login.bmp");
                InputStream in = (InputStream) blob.getBinaryStream();
                FileOutputStream out = new FileOutputStream(picture);
                byte[] buff = new byte[4096]; 
                int len = 0;

                try {
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                } 
                catch (IOException ex) {
                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }*/

                t = new User(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getString(8), res.getInt(9), res.getString(10));
                
        
            }
        
}
         catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t ;
    }}