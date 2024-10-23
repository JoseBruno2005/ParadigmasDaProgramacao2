package balanca.exception;

public class DescricaoProdutoInvalida extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "A descrição do produto é inválida! Deve ter pelo menos 3 caracteres.";
    }
}
