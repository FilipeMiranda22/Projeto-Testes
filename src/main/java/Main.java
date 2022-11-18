public class Main {
    public static void main(String[] args) {
        FuncionalidadesIF fun = new FuncionalidadesIFImp();

        System.out.println(fun.ehTriangulo(10, 10, 160));
        System.out.println(fun.calculaFuncaoSegundoGrau(1, -3, -10));

        fun.cadastraUsuario("Arthur", "arthu2r@email.com", "ABC#12das@bbbb");
    }
}
