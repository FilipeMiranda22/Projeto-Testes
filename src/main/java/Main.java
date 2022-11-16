public class Main {
    public static void main(String[] args) {
        FuncionalidadesIFImp fun = new FuncionalidadesIFImp();

        System.out.println(fun.ehTriangulo(10, 10, 160));
        System.out.println(fun.calculaFuncaoSegundoGrau(1, -3, -10));
        System.out.println(fun.ehTrianguloRetangulo(3,4,5));
        System.out.println(fun.classificaTriangulo(63.4, 71.6, 45));
        System.out.println(fun.classificaTriangulo(19.4, 126.9, 33.7));
        System.out.println(fun.classificaTriangulo(51.3, 90, 38.7));
        System.out.println(fun.ehRetangulo(90, 90, 90, 90));
    }
}
