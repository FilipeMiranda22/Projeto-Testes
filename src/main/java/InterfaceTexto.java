import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceTexto {
    private final static Scanner sc = new Scanner(System.in);

    public static void opcoes() {
        System.out.println("Digite a opção desejada (0 para sair):");
        System.out.println("1 = Cadastro de usuário\n2 = Raizes de segundo grau");
        System.out.println("3 = É triangulo?\n4 = Classificar triangulo");
        System.out.println("5 = Verificar se triangulo é retangulo\n6 = É retangulo?");
        System.out.println("7 = Área e perimetro do retangulo\n8 = Calculadora");
    }

    public static int capturaOpcao() {
        int opcao;
        try {
            opcao = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Entrada inválida", e);
        }
        if (opcao < 0 || opcao > 8) {
            throw new RuntimeException("Entrada inválida");
        }
        return opcao;
    }

    public static void executaFuncao(int opcao, FuncionalidadesIF funcionalidadesIF) {
        try {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuario:");
                    var nome = sc.next();
                    sc.nextLine();
                    System.out.println("Digite o email do usuario:");
                    var email = sc.next();
                    sc.nextLine();
                    System.out.println("Digite a senha do usuario:");
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
                    System.out.printf("Raizes: %s\n", raizes);
                    break;
                case 3:
                    System.out.println("Digite o angulo 1:");
                    var a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 2:");
                    var a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 3:");
                    var a3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((funcionalidadesIF.ehTriangulo(a1, a2, a3) ? "É" : "Não é") + " triangulo");
                    break;
                case 4:
                    System.out.println("Digite o angulo 1:");
                    a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 2:");
                    a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 3:");
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
                    System.out.println((funcionalidadesIF.ehTrianguloRetangulo(l1, l2, l3) ? "É" : "Não é") + " retangulo");
                    break;
                case 6:
                    System.out.println("Digite o angulo 1:");
                    a1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 2:");
                    a2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 3:");
                    a3 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o angulo 4:");
                    var a4 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println((funcionalidadesIF.ehRetangulo(a1, a2, a3, a4) ? "É" : "Não é") + " retangulo");
                    break;
                case 7:
                    System.out.println("Digite um lado:");
                    l1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o outro lado:");
                    l2 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Area: " + funcionalidadesIF.areaRetangulo(l1, l2));
                    System.out.println("Perimetro: " + funcionalidadesIF.perimetroRetangulo(l1, l2));
                    break;
                case 8:
                    System.out.println("Digite uma expressão do tipo \"1 + 1\":");
                    var exp = sc.next();
                    sc.nextLine();
                    System.out.printf("Resultado: %.3f\n", funcionalidadesIF.calculadora(exp));
                    break;
            }
        } catch (InputMismatchException e) {
            throw new RuntimeException("Entradas invalidas para a opção " + opcao);
        }
    }
}
