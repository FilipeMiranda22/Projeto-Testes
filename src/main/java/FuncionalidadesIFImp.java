import models.Raizes;
import models.Usuario;

import javax.management.InvalidAttributeValueException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.management.InvalidAttributeValueException;

public class FuncionalidadesIFImp implements FuncionalidadesIF {
    private BancoDeDados getBancoDeDados() {
        return bancoDeDados;
    }

    private void setBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    private BancoDeDados bancoDeDados;
    private final static Pattern patternEspeciais = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
    private final static Pattern patternNumeros = Pattern.compile("[0-9]");
    private final static Pattern patternMaiusculos = Pattern.compile("[A-Z]");
    private final static Pattern patternMinusculos = Pattern.compile("[a-z]");
    private final static Pattern patternEmail = Pattern.compile("^[a-z0-9.]+@[a-z0-9]+\\..*");

    private boolean validarSenha(String senha) {
        return senha.length() >= 8 &&
                patternEspeciais.matcher(senha).find() &&
                patternNumeros.matcher(senha).results().count() > 2 &&
                patternMaiusculos.matcher(senha).find() &&
                patternMinusculos.matcher(senha).find();
    }

    private boolean validarEmail(String email) {
        return email != null && !email.isBlank() && patternEmail.matcher(email).matches();
    }

    @Override
    public Usuario cadastraUsuario(String nome, String email, String senha) {
        if (!validarSenha(senha)) {
            throw new RuntimeException("Senha invalida");
        }
        if (!validarEmail(email)) {
            throw new RuntimeException("Email invalido");
        }
        if (nome == null || nome.isBlank()) {
            throw new RuntimeException("Nome invalido");
        }

        if (getBancoDeDados() == null) {
            try {
                setBancoDeDados(new BancoDeDados());
            } catch (Exception e) {
                System.out.println("Falha ao iniciar conexão com o banco de dados");
            }
        }

        Usuario usuario = new Usuario(email, senha, nome);
        getBancoDeDados().salvaUsuario(usuario);
        return usuario;
    }

    @Override
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        if (a == 0) {
            throw new RuntimeException("O coeficiente a deve ser diferente de zero!");
        }
        double delta = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        if (delta == 0) {
            return new Raizes();
        } else if (delta > 0) {
            double x1 = (-b + delta) / 2 * a;
            double x2 = (-b - delta) / 2 * a;
            return new Raizes(x1, x2);
        } else {
            throw new RuntimeException("A função não tem raizes reais");
        }
    }

    @Override
    public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
        return angulo1 > 0 && angulo2 > 0 && angulo3 > 0 && (
                (angulo1 + angulo2 + angulo3) == 180
        );
    }

    @Override
    public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
        if (lado1 > 0 && lado2 > 0 && lado3 > 0 ) {
            if (lado1 * lado1 + lado2 * lado2 == lado3 * lado3) {
                return true;
            } else if (lado2 * lado2 + lado3 * lado3 == lado1 * lado1) {
                return true;
            }
            else if (lado3 * lado3 + lado1 * lado1 == lado2 * lado2) {
                return true;
            }
            return false;
        }
        else {
            throw new RuntimeException("Os lados do triangulo devem ser maiores que 0");
        }
    }

    @Override
    public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
        if (ehTriangulo(angulo1, angulo2, angulo3)){
            if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90){
                return "Triangulo Acutangulo";
            }
            else if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90){
                return "Triangulo Retangulo";
            }
            else if (angulo1 > 90 || angulo2 > 90 || angulo3 > 90){
                return "Triangulo Obtusangulo";
            }
        }
        throw new RuntimeException("Os angulos não correspondem a um triângulo");
    }

    @Override
    public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4) {
        if (angulo1 > 0 && angulo2 > 0 && angulo3 > 0 && angulo4 > 0) {
            return angulo1 == 90 && angulo2 == 90 && angulo3 == 90 && angulo4 == 90;
        }
        else {
            throw new RuntimeException("Os ângulos devem ser maiores que 0");
        }
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2) {
        if (lado1 > 0 && lado2 > 0) {
            return lado1 + lado2 + lado1 + lado2;
        }

        throw new RuntimeException("Os valores que representam os lados do retângulo devem ser positivos!");
    }

    @Override
    public double areaRetangulo(double lado1, double lado2) {
        if (lado1 > 0 && lado2 > 0) {
            return BigDecimal.valueOf(lado1 * lado2)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }
        throw new RuntimeException("Os valores que representam os lados do retângulo devem ser positivos!");
    }

    @Override
    public double calculadora(String expressao) {
        try {
            String[] operacao = expressao.trim().split("\\s+");
            if (operacao.length != 3 || operacao[0].isEmpty() || operacao[1].isEmpty() || operacao[2].isEmpty()) {
                throw new InvalidAttributeValueException();
            }

            double resultado;
            double num1 = Double.parseDouble(operacao[0]);
            double num2 = Double.parseDouble(operacao[2]);
            String operador = operacao[1];

            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        throw new ArithmeticException();
                    }
                    break;
                case "**":
                    if (num2 < 0 && num1 == 0 ||  !operacao[2].matches("-?\\d+")) {
                        throw new ArithmeticException();
                    }
                    resultado = Math.pow(num1, num2);
                    break;
                default:
                    throw new ArithmeticException();
            }
            return Double.parseDouble(String.format("%.2f", resultado).replace(",", "."));
        }
        catch(InvalidAttributeValueException ex){
            throw new RuntimeException("Expressão inválida. Sintaxe: \"NUMERO1 OPERADOR NUMERO2\"");
        }
        catch(ArithmeticException ex){
            throw new RuntimeException("\nA operação é inválida. Tente realizar a operação com outros números.\n");
        }
    }

    @Override
    public double areaCirculo(double raio) {
        if (raio > 0) {
            double area = Math.PI * Math.pow(raio, 2);
            return BigDecimal.valueOf(area)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        throw new RuntimeException("O valor do raio deve ser positivo!");
    }

    @Override
    public double perimetroCirculo(double raio) {
        if (raio > 0) {
            double perimetro = 2 * Math.PI * raio;
            return BigDecimal.valueOf(perimetro)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        throw new RuntimeException("\nDados inválidos. Digite um valor numérico e positivo que represente um raio.\n");
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        double distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return BigDecimal.valueOf(distancia)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
