import java.util.Random;
import java.util.Scanner;

public class Bilhete {
    static final double tarifaBase = 5.20;
    long numero;
    double saldo;
    Usuario usuario;


    public Bilhete(Usuario usuario) {
        Random rd = new Random();
        this.numero = rd.nextLong(1000, 10000);
        this.usuario = usuario;

    }

    public double adicionarSaldo(double entrarSaldo) {
        saldo += entrarSaldo;
        return saldo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String passagemCatraca() {
        if (usuario.perfil.equalsIgnoreCase("Estudante") || (usuario.perfil.equalsIgnoreCase("Professor"))) {
            if (saldo >= tarifaBase / 2) {
                saldo -= tarifaBase / 2;
                return "Passagem liberada";
            } else {
                return "Saldo insuficiente";
            }
        } else {
            if (saldo >= tarifaBase) {
                saldo -= tarifaBase;
                return "Passagem liberada";
            } else {
                return "Saldo insuficiente";
            }
        }
    }
    /* METODO DO PROFESSOR: public String passarNaCatraca(){
        double debito = tarifaBase/2
        if(usuario.perfil.equalsignorecase('comum')){
            debito = tarifaBase
        }
        if(saldo>=debito){
           saldo-=debito
          return "Passagem liberada"
        }
        return "Saldo insuficiente";
    }
     */

}
