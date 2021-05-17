import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/*
キッチンタイマーのプログラムです。
入力された秒数カウントダウンし、0になったら終了と表示します。
 */

public class KitchenTimer  {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("キッチンタイマーにセットする分と秒を入力してください。");
        System.out.print("分を入力してください>>");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        System.out.print("秒を入力してください>>");
        int sec = scanner.nextInt();
        System.out.println("3分間だけ待ってやる by ムスカ大佐\n（※実際は"+min+"分"+sec+"秒待ちます。)");

        //minをsecに変換します
        sec = sec + min * 60;

        //隠しコマンド（入力された時間がマイナスならドーラ
        if(sec < 0){
            System.out.println("そんな時間は存在しないよ。40秒で支度しな！");
            sec = 40;
        }

        try {
            for (int i = 0; sec > 0; i++) {
                System.out.println(sec);
                Thread.sleep(1000);
                sec --;
            }

            System.out.println("時間だ by ムスカ大佐");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
