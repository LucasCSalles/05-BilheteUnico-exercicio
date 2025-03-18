import java.util.Scanner;

public class Usuario {
    Scanner entradas = new Scanner(System.in);

    String nome;
    long cpf;
    String perfil;

    public Usuario(String nome, long cpf, String perfil){
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public void cadastroUsuario(){
        System.out.println("Digite o nome do usuario: ");
        nome = entradas.next();
        System.out.println("Digite o seu CPF: ");
        cpf = entradas.nextLong();
        System.out.println("Digite seu perfil(Estudante/Proessor/Comum): ");
        perfil = entradas.next();
    }
}
