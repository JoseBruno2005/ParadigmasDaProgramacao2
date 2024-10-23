package balanca.exception;

public class ProdutoOuCamposNulos extends NullPointerException{

    @Override
    public String getMessage() {
        return "Produto ou um dos campos estão nulos!";
    }

}
