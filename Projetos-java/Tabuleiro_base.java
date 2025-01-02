

public abstract class Tabuleiro_base {
    private char tabuleiro[][] = new char[3][3];
    private Jogador p1, p2;
    
    public Tabuleiro_base(Jogador p1, Jogador p2){
        this.p1 = p1;
        this.p2 = p2;
        reiniciarTabuleiro();
    }

    public abstract void exibirTabuleiro();

    public abstract boolean jogar() throws InterruptedException;

    public abstract char verificarVencedor();

    public abstract void reiniciarTabuleiro();

    public abstract void setIniciante(int ini);

    public char[][] getTabuleiro(){
        return  tabuleiro;
    }

    public Jogador getJogador1(){
        return p1;
    }

    public Jogador getJogador2(){
        return p2;
    }
}