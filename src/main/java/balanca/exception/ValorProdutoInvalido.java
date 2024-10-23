package balanca.exception;

public class ValorProdutoInvalido extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "O valor do produto é inválido! Deve ser maior que 0.";
    }
}
