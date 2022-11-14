public interface FuncionalidadesIF {
    Usuario cadastraUsuario(String nome, String email, String senha);

    Raizes calculaFuncaoSegundoGrau(double a, double b, double c);

    boolean ehTriangulo(double angulo1, double angulo2, double angulo3);

    boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3);

    String classificaTriangulo(double angulo1, double angulo2, double angulo3);

    boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4);

    double perimetroRetangulo(double lado1, double lado2);

    double areaRetangulo(double lado1, double lado2);

    double calculadora(String expressao);

    double areaCirculo(double raio);

    double perimetroCirculo(double raio);

    double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2);
}