package login;

// Importação das classes necessárias para conexão com banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User_DAO {

    // Método responsável por conectar ao banco de dados
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();

            // URL de conexão com usuário e senha embutidos
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Estabelece conexão com o banco
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            // Exceção ignorada (não recomendado)
        }

        // Retorna a conexão (pode ser null)
        return conn;
    }

    // Variável pública usada para armazenar o nome recuperado
    public String nome = "";

    // Indica se o usuário foi encontrado ou não
    public boolean result = false;

    // Método que verifica se existe um usuário com login e senha informados
    public boolean verificarUsuario(String login, String senha) {

        String sql = "";  // String que armazenará a consulta SQL

        // Obtém conexão com o banco
        Connection conn = conectarBD();

        // Montagem da instrução SQL (concatenação simples — vulnerável a SQL Injection)
        sql = "select nome from usuarios ";
        sql += " where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            // Criação do Statement para enviar comandos ao banco
            Statement st = conn.createStatement();

            // Execução da consulta SQL
            ResultSet rs = st.executeQuery(sql);

            // Verifica se o resultado retornou algum registro
            if (rs.next()) {
                // Obtém o valor da coluna "nome"
                nome = rs.getString("nome");

                // Marca que encontrou um usuário válido
                result = true;
            }

        } catch (Exception e) {
            // Exceção silenciosa (não recomendado)
        }

        // Retorna true se o usuário foi encontrado, false caso contrário
        return result;
    }
} // fim da classe