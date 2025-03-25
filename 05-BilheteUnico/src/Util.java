import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

//Nesse codigo realizei 3 tipos de validacoes das opcoes. A 2° segue a ideia do professor, as outras 2 realizadas inteiramente por mim.
public class Util {

    private Bilhete[] bilhete = new Bilhete[3];
    private int index = 0;

    public void menuPrincipal() {
        String selecao = "1- Admin \n 2- Usuario \n 3-Sair";
        int opcao;
        do {
            opcao = parseInt(showInputDialog(null, selecao));
            if (opcao == 1) {
                administrador();
            } else if (opcao == 2) {
                usuario();
            } else if (opcao != 3) {
                showMessageDialog(null, "Opcao invalida.");
            }
        } while (opcao != 3);
    }

    private void usuario() {
        int option;
        String selecao = "1- Consultar saldo do bilhete \n 2- Carregar bilhete \n 3- Passar na catraca \n 4- Menu principal";
        do {
            option = parseInt(showInputDialog(null, selecao));
            if (option < 1 || option > 4) {
                showMessageDialog(null, "Opcao invalida.");
            } else {
                switch (option) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        carregarBilhete();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;
                }
            }
        } while (option != 4);


    }

    private void administrador() {
        int option;
        String selecao = "1- Emitir novo bilhete. \n 2- Listar bilhetes. \n 3- Deletar um bilhete. \n 4- Menu principal. ";
        do {
            option = parseInt(showInputDialog(null, selecao));
            switch (option) {
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhete();
                    break;
                case 3:
                    deletarBilhete();
                    break;
                case 4:
                    break;
                default:
                    showMessageDialog(null, "Opcao invalida.");
                    break;
            }
        } while (option != 4);
    }

    private void emitirBilhete() {
        String nome;
        String perfil;
        long cpf;
        if (index < bilhete.length) {
            nome = showInputDialog(null, "Digite seu nome: ");
            cpf = parseLong(showInputDialog(null, "Digite seu cpf: "));
            perfil = showInputDialog(null, "Digite seu perfil(Comum/Professor/Estudante)");
            Usuario usuario = new Usuario(nome, cpf, perfil);
            bilhete[index] = new Bilhete(usuario);
            //OUTRO METODO:: REMOVER LINHA DE CIMA
            //            bilhete[index] = new Bilhete(new Usuario(nome,cpf,perfil));
            // OU         bilhete[index++] = new Bilhete(new Usuario(nome,cpf,perfil));
            //bilhete[++index] serve para incrementar 1 antes de rodar. O ++ depois serve para incrementar DEPOIS, economizando codigo.
            index++;
        } else {
            showMessageDialog(null, "Limite de bilhetes alcançado, entre em contato com a administração.");
        }
    }
    private void listarBilhete() {
        DecimalFormat df = new DecimalFormat("0.00");
        String auxiliar = "";
        for (int i = 0; i < index; i++) {
            auxiliar += "Número do bilhete: " +bilhete[i].numero +"\n";
            auxiliar+=  "Nome do usuario: " +bilhete[i].usuario.nome +"\n";
            auxiliar+=  "Tipo de tarifa (perfil): " +bilhete[i].usuario.perfil  +"\n";
            auxiliar+=  "Saldo do usuario: " +df.format(bilhete[i].saldo) +"\n";
            auxiliar+= "---------------------------------------------------------------- \n";
        }
        showMessageDialog(null, auxiliar);
    }

    private void deletarBilhete() {

    }
    private int verificarUsuario(){
        long cpfUsuario;
        cpfUsuario = parseLong(showInputDialog(null, "Digite seu cpf"));
        for (int i = 0; i < index; i++) {
            if(cpfUsuario == bilhete[i].usuario.cpf){
                return i;
            }
        }
        showMessageDialog(null,"Cpf nao encontrado.");
        return -1;
    }
    private void consultarSaldo(){
        int posicao = verificarUsuario();
        if (posicao!=-1){
            showMessageDialog(null, bilhete[posicao].consultarSaldo());

        }
    }
    private void carregarBilhete(){
        double entrarSaldo=0;
        int posicao = verificarUsuario();
        if (posicao!=-1){
            entrarSaldo = parseDouble(showInputDialog(null,"Digite o valor a adicionar: "));
            bilhete[posicao].adicionarSaldo(entrarSaldo);
        }
    }
    private void passarNaCatraca(){
        int posicao = verificarUsuario();
        if (posicao!=-1){
            showMessageDialog(null,bilhete[posicao].passagemCatraca());

        }
    }
}
