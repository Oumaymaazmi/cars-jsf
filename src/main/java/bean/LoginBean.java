package bean;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;



@Named("loginBean")
@SessionScoped 
public class LoginBean implements Serializable{ 

   private static final long serialVersionUID = -5433850275008415405L; 
      private String login = "James"; 
      private String password = "007"; 
      private DB  database;
      private  DBCollection collection;
      
    public  void startConnection() {
    		MongoClient mongoClient = new MongoClient();
    		this.database = mongoClient.getDB("test");
    		mongoClient.getDatabaseNames().forEach(System.out::println);
    		this.database.createCollection("users", null);
    		this.database.getCollectionNames().forEach(System.out::println);
    		System.out.println("logged in");
    		}
   public  void insertData(String name, String password) {
   		 this.collection = this.database.getCollection("users");
   		BasicDBObject document = new BasicDBObject();
   		document.put("name", name);
   		document.put("password", password);
   		this.collection.insert(document);
   		System.out.println("inserted");
   	}
      
      public String getLogin() { 
          System.out.println( "in getLogin" ); return login; 
     } 
      public void setLogin(String login) { 
          System.out.println( "in setLogin with " + login ); 
          this.login = login; 
     } 
      public String getPassword() { 
          System.out.println( "in getPassword" ); 
          return password; 
    } 
      public void setPassword(String password) { 
          System.out.println( "in setPassword with " + password ); 
          this.password = password; 
      } 
      public String returnAction() { 
           System.out.println( "in returnAction" ); 
           this.startConnection();
           this.insertData(login, password);
           return password.equals( "007" ) ? "success" : "failure"; 
           
     }
}

