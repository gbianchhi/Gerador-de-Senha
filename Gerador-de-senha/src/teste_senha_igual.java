import java.sql.Connection;

public class teste_senha_igual {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.fazer_conexao();
        DAO dao = new DAO(conn);

        if (dao.validar_senha("MdzZwNwA") > 0) {
            System.out.println("ja existe");
        } else {
            System.out.println("nao existe");
        }

        dao.print_tabela();
    }

}
