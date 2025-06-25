package DAO;

import util.Conexao;
import java.sql.*;
import model.User;
import view.Simulador;

public class UserDAO {
    
public void cadastrarUser(User usuario) {
    String SQL_CADASTRO = "INSERT INTO cadastro (user, password) VALUES (?, ?)";
    String SQL_DADOS = "INSERT INTO dados (valor, cadastro_id) VALUES (?, ?)";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement stmtCadastro = conn.prepareStatement(SQL_CADASTRO, Statement.RETURN_GENERATED_KEYS)
    ) {
        // Inserir na tabela cadastro
        stmtCadastro.setString(1, usuario.getUser());
        stmtCadastro.setString(2, usuario.getPassword());
        stmtCadastro.executeUpdate();

        // Obter o ID gerado
        ResultSet generatedKeys = stmtCadastro.getGeneratedKeys();
        if (generatedKeys.next()) {
            int cadastroId = generatedKeys.getInt(1);

            // Inserir na tabela dados
            try (PreparedStatement stmtDados = conn.prepareStatement(SQL_DADOS)) {
                stmtDados.setDouble(1, 1.0); // valor = 1
                stmtDados.setInt(2, cadastroId); // cadastro_id
                stmtDados.executeUpdate();
            }
        } else {
            throw new SQLException("Erro ao obter o ID do usuário recém-cadastrado.");
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir usuário e dados.", e);
    }
}

    
    public void redefinirSenha(String userName, String senha){
        
        int cadastroId = obterIdUsuario(userName);
        if (cadastroId == -1) {
            throw new RuntimeException("Usuário não encontrado");
        }
        
        String SQL = "UPDATE cadastro SET password = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, senha);
            stmt.setInt(2, cadastroId);

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao redefinir senha", e);
        }
    }
    
    public void excluirUsuario(String user){
        String SQL = "DELETE FROM cadastro WHERE user = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            
            stmt.setString(1, user);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir");
        }
    }
    
    public boolean consultarLogin(User usuario, String userName, String senha){
        
        String SQL = "SELECT * FROM cadastro WHERE user = ? AND password = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getPassword());

            ResultSet resultSearch = stmt.executeQuery();
            return resultSearch.next();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar usuário", e);
        }
    }
        
    public void preencherTabela(){
        String SQL = "SELECT * FROM cadastro WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            
//            stmt.setString(1, user);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir");
        }
    }

    public int obterIdUsuario(String userName) {
        String SQL = "SELECT id FROM cadastro WHERE user = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, userName);
            
            ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            return -1; // Usuário não encontrado
        }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter ID do usuário", e);
        }
    }

    public void inserirValorParaUsuario(double valor, String userName) {
        int cadastroId = obterIdUsuario(userName);
        if (cadastroId == -1) {
            throw new RuntimeException("Usuário não encontrado. Verifique login.");
        }

        String SQL = "UPDATE dados SET valor = ? WHERE cadastro_id = ?";
        try (Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setDouble(1, valor);
            stmt.setInt(2, cadastroId);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir valor para o usuário", e);
        }
    }
}

