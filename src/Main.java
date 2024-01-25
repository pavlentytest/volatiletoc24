import java.sql.SQLOutput;

public class Main {
    /*
    Игровое приложение
     - 1 поток UI
     - 2 поток Logic
     */

    private volatile boolean flag;
    Runnable ui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stop UI!");
            flag = true;
            System.out.println("Flag = "+flag);
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // логика игры!!!
            }
            System.out.println("Stop Logic!");
        }
    };
    public void doStart() {
        new Thread(ui).start();
        System.out.println("Start UI!");
        new Thread(logic).start();
        System.out.println("Start Logic!");
    }


    public static void main(String[] args) {
        new Main().doStart();
    }
}