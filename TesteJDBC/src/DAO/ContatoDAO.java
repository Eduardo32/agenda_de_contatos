/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;
import util.Conexao;

/**
 *
 * @author Eduardo
 */
public class ContatoDAO {
    
    public static ResultSet rs;
    public static String SQL;
    public static List<Contato> contatos;
    
    public static List<Contato> pesquisarContatos (){
        SQL = "SELECT * "
                + "FROM contato "
                + "ORDER BY nome";
        
        //System.out.println(SQL);
        rs = Conexao.retornarDados(SQL);
        
        try {
            contatos = new ArrayList<>();
            
            while(rs.next()) {
                Contato c = new Contato();
                c.setNome(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setEndereco(rs.getString(4));
                contatos.add(c);
            }
            rs.close();
            Conexao.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contatos;
    }
    
    public static List<Contato> buscarContato(String nome) {
        SQL = "SELECT * "
                + "FROM contato "
                + "WHERE nome LIKE '%" + nome + "%' "
                + "ORDER BY nome";
        
        rs = Conexao.retornarDados(SQL);
        
        try {
            contatos = new ArrayList<>();
            
            while(rs.next()) {
                Contato c = new Contato();
                c.setNome(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setEndereco(rs.getString(4));
                contatos.add(c);
            }
            rs.close();
            Conexao.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contatos;
    }
    
    public static void salvarContato(Contato contato) {
        SQL = "INSERT INTO contato(nome, email, endereco) "
                + "VALUE('" + contato.getNome() 
                + "', '" + contato.getEmail() 
                + "', '" + contato.getEndereco() + "')";
        
        Conexao.manipularDados(SQL);
    }
    
    public static void excluirContato(Contato contato) {
        SQL = "DELETE FROM contato "
                + "WHERE nome = '" + contato.getNome() + "'"
                + " && email = '" + contato.getEmail() + "'"
                + " && endereco = '" + contato.getEndereco() + "'";
        
        Conexao.manipularDados(SQL);
    }
    
    public static void alterarContato(Contato contato, Contato novoContato) {
        SQL = "UPDATE contato SET "
                + "nome = '" + novoContato.getNome() + "', "
                + "email = '" + novoContato.getEmail()+ "', "
                + "endereco = '" + novoContato.getEndereco()+ "' "
                + "WHERE "
                + "nome = '" + contato.getNome() + "' "
                + "&& email = '" + contato.getEmail()+ "' "
                + "&& endereco = '" + contato.getEndereco()+ "'";
        
        Conexao.manipularDados(SQL);
    }
}
