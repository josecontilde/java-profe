package Conexion;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;



public class Conexion {
    String bd="";
    //String hosting="www.informaticoslp.com";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String pass="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd) {
        this.bd =bd;
    }
    
    public Connection conectar(){
        
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,user,pass);
            System.out.println("------------------------------------");
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO "+ ex);
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public static void main(String[] args) {
        Conexion conexion=new Conexion("informaticoslp_gnth");
        conexion.conectar();
        
    }/*/
    
    
}