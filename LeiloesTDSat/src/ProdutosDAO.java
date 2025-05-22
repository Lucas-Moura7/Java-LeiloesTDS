/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
        try
        (PreparedStatement prep = conn.prepareStatement(sql)){
        prep.setString(1, produto.getNome());
        prep.setDouble(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
        }
        
        
     public ArrayList<ProdutosDTO> listarProdutos(){
        conn = new conectaDAO().connectDB();
        String sql = "SELECT * FROM produtos";
        
        try(PreparedStatement prep = conn.prepareStatement(sql)){
            resultset = prep.executeQuery();
            
            listagem = new ArrayList<>();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));      
                produto.setNome(resultset.getString("nome"));
                produto.setValor((int) resultset.getDouble("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
    }
        
        return listagem;
    }
    
     
     public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        ArrayList<ProdutosDTO> listaVendidos = new ArrayList<>();
        conn = new conectaDAO().connectDB();
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        
        try(PreparedStatement prep = conn.prepareStatement(sql)){
            resultset = prep.executeQuery();
            
            listaVendidos = new ArrayList<>();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));      
                produto.setNome(resultset.getString("nome"));
                produto.setValor((int) resultset.getDouble("valor"));
                produto.setStatus(resultset.getString("status"));
                listaVendidos.add(produto);
            }
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
    }
         
        return listaVendidos;
    }
        
}

