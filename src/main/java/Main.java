public class Main {
    public static void main(String[] args) {
        FuncionalidadesIFImp fun = new FuncionalidadesIFImp();

        System.out.println(fun.ehTriangulo(10, 10, 160));
        System.out.println(fun.calculaFuncaoSegundoGrau(1, -3, -10));

        System.out.println(fun.perimetroRetangulo(5, 5));
        System.out.println(fun.areaRetangulo(5, 5));
        System.out.println(fun.areaCirculo(2.72));
        System.out.println(fun.perimetroCirculo(2.72));
        System.out.println(fun.distanciaEntreDoisPontos(2, 3, 4, 5));

    }
}
