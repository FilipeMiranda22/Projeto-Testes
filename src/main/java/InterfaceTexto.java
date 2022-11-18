import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceTexto {
    private final static Scanner sc = new Scanner(System.in);

    public static void opcoes() {
        System.out.println("Digite a opção desejada (0 para sair):");
        System.out.println("1 = Cadastro de usuário\n2 = Raízes de segundo grau");
        System.out.println("3 = É triângulo?\n4 = Classificar triângulo");
        System.out.println("5 = Verificar se triângulo é retângulo\n6 = É retângulo?");
        System.out.println("7 = Área e perímetro do retângulo\n8 = Calculadora");
        System.out.println("9 = Área e perímetro do círculo\n10 = Distância entre dois pontos");
    }

    public static int capturaOpcao() {
        int opcao;
        try {
            opcao = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Entrada inválida", e);
        }
        if (opcao < 0 || opcao > 10) {
            throw new RuntimeException("Entrada inválida");
        }
        return opcao;
    }

    public static void executaFuncao(int opcao, FuncionalidadesIF funcionalidadesIF) {
        try {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário:");
                    var nome = sc.next();
                    sc.nextLine();
                    System.out.println("Digite o email do usuário:");
                    var email = sc.next();
                    sc.nextLine();
                    System.out.println("Digite a senha do usuário:");
                    var senha = sc.nextLine();
                    var usuario = funcionalidadesIF.cadastraUsuario(nome, email, senha);
                    System.out.printf("Usuário criado: %s\n", usuario);
                    break;
                case 2:
                    System.out.println("Digite o coeficiente a:");
                    var a = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o coeficiente b:");
                    var b = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o coeficiente c:");
                    var c = sc.nextDouble();
                    sc.nextLine();
                    var raizes = funcionalidadesIF.calculaFuncaoSegundoGrau(a, b, c);
                    System.out.printf("Raízes: %s\n", raizes);
                    break;
                case 3:
                    System.out.println("Digite o ângulo 1:");
                    var a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 2:");
                    var a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 3:");
                    var a3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((funcionalidadesIF.ehTriangulo(a1, a2, a3) ? "É um" : "Não é um") + " triângulo");
                    break;
                case 4:
                    System.out.println("Digite o ângulo 1:");
                    a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 2:");
                    a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 3:");
                    a3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(funcionalidadesIF.classificaTriangulo(a1, a2, a3));
                    break;
                case 5:
                    System.out.println("Digite o lado 1:");
                    var l1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o lado 2:");
                    var l2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o lado 3:");
                    var l3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((funcionalidadesIF.ehTrianguloRetangulo(l1, l2, l3) ? "É um triângulo" : "Não é um triângulo") + " retângulo");
                    break;
                case 6:
                    System.out.println("Digite o ângulo 1:");
                    a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 2:");
                    a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 3:");
                    a3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o ângulo 4:");
                    var a4 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((funcionalidadesIF.ehRetangulo(a1, a2, a3, a4) ? "É um" : "Não é um") + " retângulo");
                    break;
                case 7:
                    System.out.println("Digite um lado:");
                    l1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o outro lado:");
                    l2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Área: " + funcionalidadesIF.areaRetangulo(l1, l2));
                    System.out.println("Perímetro: " + funcionalidadesIF.perimetroRetangulo(l1, l2));
                    break;
                case 8:
                    System.out.println("Digite uma expressão do tipo \"1 + 1\":");
                    sc.nextLine();
                    var exp = sc.nextLine();
                    System.out.printf("Resultado: %.3f\n", funcionalidadesIF.calculadora(exp));
                    break;
                case 9:
                    System.out.println("Digite o raio do círculo:");
                    var r = sc.nextDouble();
                    sc.nextLine();
                    System.out.printf("Área do círculo: %.2f\n", funcionalidadesIF.areaCirculo(r));
                    System.out.printf("Perímetro do círculo: %.2f\n", funcionalidadesIF.perimetroCirculo(r));
                    break;
                case 10:
                    System.out.println("Digite a posição do ponto a(x,y). Ex: 4,6");
                    String[] aAux = sc.next().split(",");
                    sc.nextLine();
                    var xa = Double.parseDouble(aAux[0]);
                    var ya = Double.parseDouble(aAux[1]);
                    System.out.println("Digite a posição do ponto b(x,y). Ex: 5,8:");
                    String[] bAux = sc.next().split(",");
                    var xb = Double.parseDouble(bAux[0]);
                    var yb = Double.parseDouble(bAux[1]);
                    System.out.printf("A distância entre os dois pontos é: %.2f\n", funcionalidadesIF.distanciaEntreDoisPontos(xa, ya, xb, yb));
                    break;
            }
        } catch (InputMismatchException | IndexOutOfBoundsException | NumberFormatException e) {
            throw new RuntimeException("Entradas inválidas para a opção " + opcao);
        }
    }
}
