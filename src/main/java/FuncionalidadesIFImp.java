import models.Raizes;
import models.Usuario;

public class FuncionalidadesIFImp implements FuncionalidadesIF {
    @Override
    public Usuario cadastraUsuario(String nome, String email, String senha) {
        return null;
    }

    @Override
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        return null;
    }

    @Override
    public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
        return false;
    }

    @Override
    public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
        return false;
    }

    @Override
    public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
        return null;
    }

    @Override
    public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4) {
        return false;
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2) {
        return 0;
    }

    @Override
    public double areaRetangulo(double lado1, double lado2) {
        return 0;
    }

    @Override
    public double calculadora(String expressao) {
        return 0;
    }

    @Override
    public double areaCirculo(double raio) {
        return 0;
    }

    @Override
    public double perimetroCirculo(double raio) {
        return 0;
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        return 0;
    }
}
