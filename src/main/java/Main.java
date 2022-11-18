
public class Main {
    public static void main(String[] args) {
        FuncionalidadesIFImp fun = new FuncionalidadesIFImp();

        while (true) {
            InterfaceTexto.opcoes();
            int opcao = InterfaceTexto.capturaOpcao();
            if (opcao == 0) {
                break;
            }

            InterfaceTexto.executaFuncao(opcao, fun);
        }
    }
}
