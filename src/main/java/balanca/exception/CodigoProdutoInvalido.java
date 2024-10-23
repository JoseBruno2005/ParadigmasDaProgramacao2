package balanca.exception;

public class CodigoProdutoInvalido extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "O código do produto é inválido! Deve ser maior que 0.";
    }
}
