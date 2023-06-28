
import java.util.Random;

public class Gerador {

    String senha_gerada;

    // caracteres que poderão compor a senha
    private String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

    // função de gerar senha
    public String gerarSenha(int tamanho) {
        StringBuilder senha = new StringBuilder(tamanho);
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(indice));
            senha_gerada = senha.toString();

        }

        return senha_gerada;

    }

}