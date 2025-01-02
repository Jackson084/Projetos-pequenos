import java.util.Random;

public class Jogador {
   private char marcador;
   private Random r = new Random();

   public Jogador(char var1) {
      if (!this.setMarcador(var1)) {
         System.out.println("Jogador com marca inv\u00e1lida! Utilizando marca padr\u00e3o!");
      }

   }

   public int escolherLinha() {
      return this.r.nextInt(5) - 1;
   }

   public int escolherColuna() {
      return this.r.nextInt(5) - 1;
   }

   public char getMarcador() {
      return this.marcador;
   }

   public boolean setMarcador(char var1) {
      if (var1 != 'X' && var1 != 'O') {
         this.marcador = '*';
         return false;
      } else {
         this.marcador = var1;
         return true;
      }
   }
}