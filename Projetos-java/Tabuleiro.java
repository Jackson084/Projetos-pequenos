
public class Tabuleiro extends Tabuleiro_base implements TabUi{
    
    private int QmJoga=0;//criado para alternar os jogadores
    private Jogador jogadorAtual;// pra definir o jogador atual
    // para receber o oposto do atual
    private  int partidas;// para definir a quantidaades de partidas
    

    
    public Tabuleiro(Jogador p1, Jogador p2){ //construtor
        super(p1, p2);

        for (int i = 0; i < 5; i++) {
            System.out.println(" \n");// apenas para puar linhas 
        }  
        //reiniciarTabuleiro();// adiciona os asteriscos no tabuleiro 
        
        QmJoga=1;// inicializo com 1
        

    }
    @Override
    public void exibirTabuleiro() {
        char[][] tabuleiro = getTabuleiro();
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j]='*';
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
        desenheTabuleiro(getTabuleiro());
       // desenho do tauleiro, sem necessidade, mas ele exibe o tabuleiro
    }

    @Override
    public boolean jogar() throws InterruptedException { // essa exeção é para usar o metodo de parar o tempo
        char[][] tabuleiro = getTabuleiro();

        if (QmJoga == 1) {
            jogadorAtual = getJogador1();// inicializo a logica, ela vai depender se o set foi adicionado ou não
        } else {
            jogadorAtual = getJogador2();// se qmjoga==1 o jogador 1 joga, se não, o sjogador 2 joga
        }
        /*if(QmJoga>1){
            QmJoga=1;
            
        }else if(QmJoga==1){
            QmJoga++;
        }*/
        //Jogador jj=new Jogador('x');
        boolean caboJogo = false; // inicializo se o jogo cabou como falso
        partidas=-1; // professor, aqui é menos um pq quando eu boto 0, no loop ele já icrementa 1
        while (!caboJogo) { // loop para caso
            Thread.sleep(2000); //tempo parado
            partidas++; // imcremento, a cada vez que o loop rodar ele adciona mais 1
            exibirTabuleiro(); // exibe
            System.out.println("Jogador " + QmJoga + " (" + jogadorAtual.getMarcador() + "), escolha sua jogada:");
            // aqui ele printa o marcado, se for x printa x ,se não, printa O
            int linha, coluna; // criado pra não usar for 
            do {
                linha = jogadorAtual.escolherLinha();
                coluna = jogadorAtual.escolherColuna();
            }while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '*'); /*
            
            se linha menor que 0 OU linha maior que 2 OU coluna Manor que 0 OU coluna maior que 2 OU
            tabuleiro não tiver um asterisco ele coloca o marcador na posição */
            tabuleiro[linha][coluna] = jogadorAtual.getMarcador(); // como
            //tabuleiro[jj.escolherLinha()][jj.escolherColuna()]=getJogador1(); eu fiz isso kkkk
             // Verificar vencedor
            
            if (verificarVencedor() != '*') {
                exibirTabuleiro();
                //System.out.println("Jogador " + QmJoga + " venceu!");
                return true;
            }
            // Verificar empate
            if (partidas == 8 ) {
                exibirTabuleiro();
                //System.out.println("Empate!");
                return false;
            }
            if (QmJoga == 1) {
                QmJoga=2;
            } else {
                QmJoga=1;
            }            
            if (QmJoga == 1) {
                jogadorAtual = getJogador1();
               
            } else {
                jogadorAtual = getJogador2();
            }
         
        }
        return false;
    }

    @Override
    public char verificarVencedor() {
        int cont=0;
        char[][] tabuleiro=getTabuleiro();
        for (int i = 0; i < 3; i++) {
            if(tabuleiro[i][0]!='*' && tabuleiro[i][0]==tabuleiro[i][1]
            && tabuleiro[i][0]==tabuleiro[i][2]){
                cont++;
                return jogadorAtual.getMarcador(); // aqui vai retornar humm... as colunas, legal.
            }
            if(tabuleiro[0][i]!='*' && tabuleiro[0][i]==tabuleiro[1][i]
            && tabuleiro[0][i]==tabuleiro[2][i]){
                cont++;
                return jogadorAtual.getMarcador(); // aqui vai retornar as linhas.
            }  
        }
        if(tabuleiro[0][0]!='*' && tabuleiro[0][0]==tabuleiro[1][1]
            && tabuleiro[0][0]==tabuleiro[2][2]){
                cont++;
                return jogadorAtual.getMarcador(); // aqui vai retornar a diagonal a esquerda.
        }
        if(tabuleiro[0][2]!='*' && tabuleiro[0][2]==tabuleiro[1][1]
            && tabuleiro[0][2]==tabuleiro[2][0]){
                cont++;
                return jogadorAtual.getMarcador(); // aqui vai retornar as diagonais a direita.
        }
        if(cont==0 && partidas==8){
            return 'E';
        }
        
        
        
        return '*';
        
            
    }
    public boolean verificarEmpate(){
        if(verificarVencedor()!=jogadorAtual.getMarcador()){
            return true;
        }
        return false;
    }

    @Override
    public void reiniciarTabuleiro() {
        char[][] tabuleiro = getTabuleiro();
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j]='*';
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
       
    }

    @Override
    public void setIniciante(int ini) {
        if(ini==1){
            QmJoga=1;
        }else if(ini==2){
            QmJoga=2;
        }else{
            QmJoga=1;
        }
        
    }
    @Override
    public Jogador getJogador1() {
        return super.getJogador1();
    }
    @Override
    public Jogador getJogador2() {
        return super.getJogador2();
    }
    @Override
    public char[][] getTabuleiro() {
        return super.getTabuleiro();
    }
  

    @Override
    public void desenheTabuleiro(char[][] tab) {
        char[][] tabuleiro=getTabuleiro();
     
        System.out.println();
        
        System.out.println(" " + tabuleiro[0][0] + "| " + tabuleiro[0][1] + "| " + tabuleiro[0][2]);
        System.out.println("--|--|--");
        System.out.println(" " + tabuleiro[1][0] + "| " + tabuleiro[1][1] + "| " + tabuleiro[1][2]);
        System.out.println("--|--|--");
        System.out.println(" " + tabuleiro[2][0] + "| " + tabuleiro[2][1] + "| " + tabuleiro[2][2]);
        
    }
    
}
/*public static void veQmJoga(Jogador davez, int partidas, Jogador p1, Jogador p2){
        if(){ eu pensei em fazer isso 

        }
        switch (partidas) {
            case 1:
                davez=getJogador1();
                break;
            case 2:
                davez=p2;
                break;
            case 3:
                davez=p1;
                break;
            case 4:
                davez=p2;
                break;
            case 5:
                davez=p1;
                break;
            case 6:
                davez=p2;
                break;
            case 7:
                davez=p1;
                break;
            case 8:
                davez=p2;
                break;
            case 9:
                davez=p1;
                break;
            default:
                throw new AssertionError();
        }

    }
}
 */
