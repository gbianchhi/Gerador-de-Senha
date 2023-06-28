import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    Connection conn;

    // construtor para puxar a conexao criada
    DAO(Connection connection) {
        this.conn = connection;
    }

    // adiconar ao banco de dados
    public void adicionar(String senha) {

        try {
            String sqlString = "INSERT INTO tabela_de_senhas (SENHA) VALUE (?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);

            preparedStatement.setString(1, senha);

            preparedStatement.execute();

            System.out.println("Senha " + senha + " adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // print das senhas salvas
    public void print_tabela() {
        String sqlString = "SELECT * FROM tabela_de_senhas";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
            ResultSet result = preparedStatement.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(result.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();
            while (result.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // fechar conexao
    public void fechar_conexao() {
        try {
            conn.close();
            System.out.println("Conexão fechada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // validar existencia de uma senha
    public int validar_senha(String senha) {
        String sqlString = "select count(*) from tabela_de_senhas where SENHA = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
            preparedStatement.setString(1, senha);
            ResultSet resultado = preparedStatement.executeQuery();
            resultado.next();
            int count = resultado.getInt(1);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

}
