package balanca.exception;

import java.io.IOException;

public class DiretorioInvalido extends IOException {
    @Override
    public String getMessage() {
        return "O diretório especificado é inválido ou não tem permissão de escrita!";
    }
}
