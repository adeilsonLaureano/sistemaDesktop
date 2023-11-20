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
import javax.swing.table.DefaultTableModel;

import model.FuncionarioModel;
import view.Tela_Funcionarios;

/**
 *
 * @author Aluno_Manha
 */
public class FuncionarioController {
       public void salvar(FuncionarioModel funcionario){
        String sql = "INSERT INTO funcionario(nome, email, status) VALUES(?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //atribuir os valores na tabela
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getEmail());
            pstm.setString(3, "Disponível");
      
            
            //executar a query
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário!!","ERROR", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário!!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }
    
    public List<FuncionarioModel> pegarDoBanco(){
        String sql = "SELECT * FROM funcionario";     
        ArrayList<FuncionarioModel> funcs = new ArrayList<>();  
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
                FuncionarioModel func = new FuncionarioModel();
                
                func.setId(rset.getInt("idfuncionario"));
                func.setNome(rset.getString("nome"));
                func.setEmail(rset.getString("email"));
                func.setStatus(rset.getString("status"));

                
                funcs.add(func);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro ao listar os uncionarios!!");
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
        return funcs;
    }
    
    public void tblListarFuncs(Tela_Funcionarios tl){
        DefaultTableModel model = (DefaultTableModel) tl.tblFuncionarios.getModel();
        List<FuncionarioModel> funcs =  pegarDoBanco();
        
        Object linhas[] = new Object[4];
        
        for (FuncionarioModel funcionario : funcs) {
            linhas[0] = funcionario.getId();
            linhas[1] = funcionario.getNome();
            linhas[2] = funcionario.getEmail();
            linhas[3] = funcionario.getStatus();
            
            model.addRow(linhas);
            
            
        }
    }
    
    public void atualizar(FuncionarioModel func) {
        String sql = "UPDATE funcionario SET nome = ?,email = ?, status = ? WHERE idfuncionario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            //criando conexao com o banco
            conn = Conexao.createConnectionToMySQL();
            //executando a conexao juntamente com a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, func.getNome());
            pstm.setString(2, func.getEmail());
            pstm.setString(3, func.getStatus());
         
            //buscar qual id ira atualizar
            pstm.setInt(4, func.getId());
            //executar a query
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário!!","ERROR", JOptionPane.ERROR_MESSAGE);

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
        String sql = "DELETE FROM funcionario WHERE idfuncionario = ?";
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
            
            JOptionPane.showMessageDialog(null, "Funcionario deletado com sucesso!","CADASTRO", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário!!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /*
    public boolean login(String login, String senha){
        List<FuncionarioModel> funcs = pegarDoBanco();
        boolean check = false;
        for (FuncionarioModel funcionario : funcs) {
            
            if(funcionario.getEmail().equals(login) && funcionario.getSenha().equals(senha)){
                check = true;
            }
            
        }
        return check;
    }
    */
}
