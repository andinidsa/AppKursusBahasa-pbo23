
package kursus_bahasa;

public class Kursus_Bahasa {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
        public void run ()
        {
            new FormLogin().setVisible(true);
        }
       }
      );
    }
    
}