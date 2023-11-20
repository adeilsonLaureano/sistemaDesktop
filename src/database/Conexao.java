/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno_Manha
 */
public class Conexao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/eletrotech_bd";
    //Método de conex~~ao com o banco
    public static Connection createConnectionToMySQL() throws Exception{
        //carrega a classe de conexão java na biblioteca jdbc mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        //cria a conexão com o banco
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    
    public static void main(String[] args) {
        try{
            Connection conn = createConnectionToMySQL();
            if(conn != null){
                System.out.println("Conexão realizada com sucesso!");
            }
        }
        catch(Exception e){
            System.out.println("Erro ao conectar: "+e);
        }
    }
    

}
