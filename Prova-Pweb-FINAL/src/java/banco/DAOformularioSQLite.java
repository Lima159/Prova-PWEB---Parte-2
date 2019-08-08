/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import negocio.Formulario;

/**
 *
 * @author Aluno
 */
public class DAOformularioSQLite implements DAOformulario{

    @Override
    public boolean inserir(Formulario form) throws Exception {
        Connection conn = BDConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("insert into FORMULARIO (DESTINATARIO,TELDESTINATARIO,EMAILDESTINATARIO,"
                + "REMETENTE,TELREMETENTE,EMAILREMETENTE,DATA) values (?,?,?,?,?,?,?)");
        pst.setString(1, form.getDestinatario());
        pst.setString(2, form.getTelDestinatario());
        pst.setString(3, form.getEmailDestinatario());
        pst.setString(4, form.getRemetente());
        pst.setString(5, form.getTelRemetente());
        pst.setString(6, form.getEmailRemetente());
        pst.setString(7, form.getData());
        pst.executeUpdate();
        pst.close();
        return true;
    }
 
    @Override
    public boolean remover(Formulario form) throws Exception {
        Connection conn = BDConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("delete from FORMULARIO where DESTINATARIO=? and TELDESTINATARIO=?"
                + " and EMAILDESTINATARIO=? and REMETENTE=? and TELREMETENTE=? and EMAILREMETENTE=? and DATA=?");
        pst.setString(1, form.getDestinatario());
        pst.setString(2, form.getTelDestinatario());
        pst.setString(3, form.getEmailDestinatario());
        pst.setString(4, form.getRemetente());
        pst.setString(5, form.getTelRemetente());
        pst.setString(6, form.getEmailRemetente());
        pst.setString(7, form.getData());
        pst.executeUpdate();
        pst.close();
        
        return true;
    }
    
    @Override
    public Formulario atualizar(Formulario form, Formulario novo) throws Exception {
        Connection conn = BDConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("update FORMULARIO set DESTINATARIO=?, TELDESTINATARIO=?, OPERADORA=?, "
                + "EMAILDESTINATARIO=?, REMETENTE=?, TELREMETENTE=?, EMAILREMETENTE=?, DATA=?"
                + " DESTINATARIO=? and TELDESTINATARIO=?"
                + " and EMAILDESTINATARIO=? and REMETENTE=? and TELREMETENTE=? and EMAILREMETENTE=? and DATA=?");
        
        pst.setString(1, novo.getDestinatario());
        pst.setString(2, novo.getTelDestinatario());
        pst.setString(3, novo.getEmailDestinatario());
        pst.setString(4, novo.getRemetente());
        pst.setString(5, novo.getTelRemetente());
        pst.setString(6, novo.getEmailRemetente());
        pst.setString(7, novo.getData());
        
        pst.setString(8, form.getDestinatario());
        pst.setString(9, form.getTelDestinatario());
        pst.setString(10, form.getEmailDestinatario());
        pst.setString(11, form.getRemetente());
        pst.setString(12, form.getTelRemetente());
        pst.setString(13, form.getEmailRemetente());
        pst.setString(14, form.getData());
        pst.executeUpdate();
        pst.close();
        
        return novo;
    
    }
    
    @Override
    public List<Formulario> buscar(Formulario form) throws Exception {
        Connection conn = BDConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("select * from FORMULARIO where DESTINATARIO=? and TELDESTINATARIO=?"
                + " and EMAILDESTINATARIO=? and REMETENTE=? and TELREMETENTE=? and EMAILREMETENTE=? and DATA=? ");
        pst.setString(1, form.getDestinatario());
        pst.setString(2, form.getTelDestinatario());
        pst.setString(3, form.getEmailDestinatario());
        pst.setString(4, form.getRemetente());
        pst.setString(5, form.getTelRemetente());
        pst.setString(6, form.getEmailRemetente());
        pst.setString(7, form.getData());
        ResultSet rs=pst.executeQuery();
        
        List<Formulario> lista=new ArrayList<Formulario>();
        while(rs.next()){
            Formulario temp=new Formulario();
            
            temp.setDestinatario(rs.getString("DESTINATARIO"));
            temp.setTelDestinatario(rs.getString("TELDESTINATARIO"));
            temp.setEmailDestinatario(rs.getString("EMAILDESTINATARIO"));
            temp.setRemetente(rs.getString("REMETENTE"));
            temp.setTelRemetente(rs.getString("TELREMETENTE"));
            temp.setEmailRemetente(rs.getString("EMAILREMETENTE"));
            temp.setData(rs.getString("DATA"));
                        
            lista.add(temp);
        }
        
        return lista;
    }
    
    @Override
    public List<Formulario> listar() throws Exception {
        Connection conn = BDConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("select * from FORMULARIO");
       
        ResultSet rs=pst.executeQuery();
        
        List<Formulario> lista=new ArrayList<Formulario>();
        while(rs.next()){
            Formulario temp=new Formulario();
            temp.setDestinatario(rs.getString("DESTINATARIO"));
            temp.setTelDestinatario(rs.getString("TELDESTINATARIO"));
            temp.setEmailDestinatario(rs.getString("EMAILDESTINATARIO"));   
            temp.setRemetente(rs.getString("REMETENTE"));
            temp.setTelRemetente(rs.getString("TELREMETENTE"));
            temp.setEmailRemetente(rs.getString("EMAILREMETENTE"));
            temp.setData(rs.getString("DATA"));
  
            lista.add(temp);
        }
        
        return lista;
    }
}
