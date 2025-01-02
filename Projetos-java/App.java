public class App {
    public static void main(String[] args) throws Exception {
        Jogador j1 = new Jogador('X');
        Jogador j2 = new Jogador('O');
        Tabuleiro t1= new Tabuleiro(j1, j2);
        t1.exibirTabuleiro();
        t1.setIniciante(1);
        //System.out.println(t1.getJogador1());
        //t1.jogar();
        //t1.exibirTabuleiro();
        switch (t1.verificarVencedor()) {
            case 'E':
                System.out.println("o jogo deu empate");
                break;
            case 'X':
                System.out.println(" o Jogador X venceu");
                break;
            case 'O':
                System.out.println(" o Jogador Bola venceu");
                break;
            default:
                System.out.println(" ouve algum problema");
        }
    }
}
