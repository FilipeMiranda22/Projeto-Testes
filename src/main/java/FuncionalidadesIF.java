import models.Raizes;
import models.Usuario;

public interface FuncionalidadesIF {
    // Arthur RF1
    Usuario cadastraUsuario(String nome, String email, String senha);

    // Arthur RF2
    Raizes calculaFuncaoSegundoGrau(double a, double b, double c);

    // Arthur RF3
    boolean ehTriangulo(double angulo1, double angulo2, double angulo3);

    // Filipe RF5
    boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3);

    // Filipe RF4
    String classificaTriangulo(double angulo1, double angulo2, double angulo3);

    // Filipe RF6
    boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4);

    // Elismar RF7
    double perimetroRetangulo(double lado1, double lado2);

    // Elismar RF7
    double areaRetangulo(double lado1, double lado2);

    // FAZER JUNTO RF8
    double calculadora(String expressao);

    // Elismar RF9
    double areaCirculo(double raio);

    // Elismar RF9
    double perimetroCirculo(double raio);

    // Elismar RF10
    double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2);
}