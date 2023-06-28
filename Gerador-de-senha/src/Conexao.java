
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String URL = "jdbc:mysql://localhost:3306/senhas";
    private String USUARIO = "root";
    private String SENHA = "";

    // conectar com SQL
    public Connection fazer_conexao() {

        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
