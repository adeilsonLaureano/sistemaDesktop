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
import model.AgendamentoModel;
import view.Tela_Agendamentos;

/**
 *
 * @author adeil
 */
public class AgendamentoController {
        public List<AgendamentoModel> pegarDoBanco(){
        String sql = "SELECT * FROM agendamento";     
        ArrayList<AgendamentoModel> ags = new ArrayList<>();  
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
                AgendamentoModel func = new AgendamentoModel();
                
                func.setId(rset.getInt("id"));
                func.setNome(rset.getString("nome"));
                func.setData(rset.getDate("data").toLocalDate());
                func.setHora(rset.getTime("hora").toLocalTime());
                func.setFuncinario(rset.getString("funcionario"));
                func.setServico(rset.getString("servico"));
                func.setPagamento(rset.getString("pagamento"));

                
                ags.add(func);
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
        return ags;
    }
    
    public void tblListar(Tela_Agendamentos tl){
        DefaultTableModel model = (DefaultTableModel) tl.tblAgendamentos.getModel();
        List<AgendamentoModel> ags =  pegarDoBanco();
        
        Object linhas[] = new Object[7];
        
        for (AgendamentoModel agendamento : ags) {
            linhas[0] = agendamento.getId();
            linhas[1] = agendamento.getNome();
            linhas[2] = agendamento.getData();
            linhas[3] = agendamento.getHora();
            linhas[4] = agendamento.getFuncinario();
            linhas[5] = agendamento.getServico();
            linhas[6] = agendamento.getPagamento();
            
            model.addRow(linhas);
            
            
        }
    }
    
        public void excluir(int id){
        String sql = "DELETE FROM agendamento WHERE id = ?";
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
}
