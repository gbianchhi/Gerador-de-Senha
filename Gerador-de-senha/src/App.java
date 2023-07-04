import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        Gerador gerador = new Gerador();

        String senha = gerador.gerarSenha(8);
        System.out.println(senha);

        Conexao conexao = new Conexao();
        Connection con = conexao.fazer_conexao();

        DAO dao = new DAO(con);

        if (dao.validar_senha(senha) > 0) {
            System.out.println("Senha ja existente. Gere uma nova senha.");
            dao.fechar_conexao();
        } else {
            dao.adicionar(senha);
            dao.print_tabela();
            dao.fechar_conexao();

        }

    }
}
