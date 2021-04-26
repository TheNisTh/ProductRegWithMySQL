/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Dênis
 */
public class DAOProdutos {
    private Connection conexao;
    private static DAOProdutos instancia;
    
    private DAOProdutos(){
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            
            String host = "localhost";
            String db = "cad_produtos";
            String url = "jdbc:mysql://" + host + "/" + db;
            String user = "Dênis";
            String pwd = "rok755ou";
            
            this.conexao = DriverManager.getConnection(url,user,pwd);
            
            if (this.conexao != null){
                System.out.println("Sucesso na conexão com o Banco de Dados");
            }else{
                System.out.println("Erro ao conectar!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.err.println("O driver não foi encontrado!");
        }catch (SQLException ex) {
            System.err.println("Não foi possível conectar ao Banco de Dados!");
        }
    }
    
    public void save(String nome,String marca, String modelo, String preco){
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO produtos (nome, marca, modelo, preco) VALUES (?,?,?,?)");
            ps.setString(1,nome);
            ps.setString(2,marca);
            ps.setString(3,modelo);
            ps.setString(4,preco);
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DAOProdutos getInstance(){
        if(instancia == null){
            instancia = new DAOProdutos();
        }
        return instancia;
    }
    
    public DefaultListModel<Produto> list(){
        try {
            DefaultListModel<Produto> model = new DefaultListModel<>();
            
            PreparedStatement ps = conexao.prepareStatement(
                    "SELECT * FROM produtos"
            );
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                model.addElement (new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("preco")
                ));
            }
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
