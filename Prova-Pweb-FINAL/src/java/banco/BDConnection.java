package banco;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDConnection {
    
    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Aluno\\Desktop\\Prova-Pweb-FINAL\\banco\\banco.db", "root", "123456");
        System.out.println("Conexão aberta");
        return conn;
    }
            
    public static void closeConnection(Connection conn){
        if(conn != null){
            try{
            System.out.println("Conexão fechada");
            conn.close();
            }catch(SQLException e){
                throw new BDExcecao(e.getMessage());
            }
        }
    }
    
}
