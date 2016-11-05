/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Fabiano
 */
public class DaoLogin {
    DaoLogin daoLogin = null;
   
       public DaoLogin() throws SQLException {
   
            try {
                  Class.forName("com.mysql.jdbc.Driver");
                  System.out.println("Instalou driver");
            } catch (ClassNotFoundException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
   
            String url = "jdbc:mysql://localhost:3306/pessoa";
            String user = "root";
            String password = "123456";
            daoLogin = (DaoLogin) DriverManager.getConnection(url, user, password);
       }
   
       public void closeConnection() throws SQLException {
   
            daoLogin.closeConnection();
       }
   
       // cadastra no banco um usuario passado como parametro
       public boolean insertUsuario(Usuario usuario) {
   
            Statement st = null;
            ResultSet rs = null;
   
            try {
                  st = daoLogin.createStatement();
   
                  PreparedStatement preparedStatement = daoLogin
                            .prepareStatement("insert into usuario(id, nome, senha) values(?,?,?)");
                  preparedStatement.setInt(1, usuario.getId());
                  preparedStatement.setString(2, usuario.getNome());
                  preparedStatement.setString(3, usuario.getSenha());
                  
   
                  preparedStatement.execute();
                  return true;
            } catch (SQLException ex) {
                  Logger lgr = Logger.getLogger(Connection.class.getName());
                  lgr.log(Level.SEVERE, ex.getMessage(), ex);
                  return false;
   
            }
       }
       
       //lista todos os usuarios cadastrados no banco de dados
       public List<Usuario> listUsuario() {
   
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
   
            Statement st = null;
            ResultSet rs = null;
   
            try {
                  st = daoLogin.createStatement();
                  String sql = "select * from usuario ";
                 rs = st.executeQuery(sql);
   
                  while (rs.next()) {
   
                       Usuario usuario = new Usuario();
                       usuario.setId(rs.getInt(1));
                       usuario.setNome(rs.getString(2));
                       usuario.setSenha(rs.getString(3));
                       lista.add(usuario);
                  }
   
            } catch (SQLException ex) {
                  Logger lgr = Logger.getLogger(Connection.class.getName());
                  lgr.log(Level.SEVERE, ex.getMessage(), ex);
   
            } finally {
                  try {
                       if (rs != null) {
                            rs.close();
                       }
                       if (st != null) {
                            st.close();
                       }
                       if (daoLogin != null) {
                            daoLogin.closeConnection();
                       }
   
                  } catch (SQLException ex) {
                       Logger lgr = Logger.getLogger(Connection.class.getName());
                       lgr.log(Level.WARNING, ex.getMessage(), ex);
                  }
            }
            return lista;
       }

    private Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private PreparedStatement prepareStatement(String insert_into_usuarioid_nome_senha_values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }

