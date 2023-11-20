/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.UsuarioModel;

/**
 *
 * @author Aluno_Manha
 */
public class UsuarioController {
       public void salvar(UsuarioModel usuario){
        String sql = "INSERT INTO usuario(nome, cpf, telefone, endereco, email, senha) VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //atribuir os valores na tabela
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getTelefone());
            pstm.setString(4, usuario.getEndereco());
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getSenha());
      
            
            //executar a query
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!!","ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }            
                
            }
            catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
    
    public List<UsuarioModel> pegarDoBanco(){
        String sql = "SELECT * FROM usuario";     
        ArrayList<UsuarioModel> users = new ArrayList<>();  
        Connection conn = null;
        PreparedStatement pstm = null;
        //classe para recuperar os dados os dados no banco *select*
        ResultSet rset = null;
        
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                UsuarioModel user = new UsuarioModel();
                
                user.setId(rset.getInt("idusuario"));
                user.setNome(rset.getString("nome"));
                user.setCpf(rset.getString("cpf"));
                user.setTelefone(rset.getString("telefone"));
                user.setEndereco(rset.getString("endereco"));
                user.setEmail(rset.getString("email"));
                user.setSenha(rset.getString("senha"));

                
                users.add(user);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro ao listar!!");
        }
        finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }            
                
            }
            catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
        return users;
    }
    
    public void atualizar(UsuarioModel user) {
        String sql = "UPDATE usuario SET nome = ?, cpf = ?, telefone = ?, endereco = ?, email = ?, senha = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getCpf());
            pstm.setString(3, user.getTelefone());
            pstm.setString(4, user.getEndereco());
            pstm.setString(5, user.getEmail());
            pstm.setString(6, user.getSenha());
         
            //buscar qual id ira atualizar
            pstm.setInt(7, user.getId());
            //executar a query
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "atualizado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!","ERROR", JOptionPane.ERROR_MESSAGE);

        }
        finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }            
                
            }
            catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM usuario WHERE idusuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //qual o registro id deseja deletar
            pstm.setInt(1, id);
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "deletado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }            
                
            }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar!!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /*
    public boolean login(String login, String senha){
        List<ClienteModel> users = pegarDoBanco();
        boolean check = false;
        for (UsuarioModel usuario : users) {
            
            if(usuario.getEmail().equals(login) && usuario.getSenha().equals(senha)){
                check = true;
            }
            
        }
        return check;
    }
    */
}
