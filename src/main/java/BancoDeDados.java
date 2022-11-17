import models.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BancoDeDados {
    private static final Path CAMINHO_ARQUIVO = Paths.get("./banco.txt");
    private File arquivo;

    public BancoDeDados() throws IOException {
        File arquivoAux = new File(CAMINHO_ARQUIVO.toUri());
        if (arquivoAux.createNewFile()) {
            System.out.println("Criando novo arquivo");
        }
        setArquivo(arquivoAux);
    }

    public void salvaUsuario(Usuario usuario) {
        try (FileWriter writer = new FileWriter(getArquivo(), true)) {
            writer.write(String.format("%s;%s;%s", usuario.getNome(), usuario.getEmail(), usuario.getSenha()));
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    private File getArquivo() {
        return arquivo;
    }

    private void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}
