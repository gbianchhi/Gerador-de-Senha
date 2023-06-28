
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String URL = "";
    private String USUARIO = "";
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
