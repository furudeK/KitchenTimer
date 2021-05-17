import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/*
キッチンタイマーのプログラムです。
入力された秒数カウントダウンし、0になったら終了と表示します。
 */


public class KitchenTimer  {
    //分と秒の入力を受け取り、返すメソッド
    public static int getInput(String strMinOrSec){
        int num = 0;
        do{
            try {
                System.out.println(strMinOrSec+"を0以上の値で入力してください>>");
                String str = new Scanner(System.in).nextLine();
                num= Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
            }
        }while((num < 0)); //マイナスの値が入力された際に、再度入力を促す

        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("キッチンタイマーにセットする分と秒を入力してください。");
        Scanner scanner = new Scanner(System.in);
        String min = "分";
        int inputMins = getInput(min);
        String sec = "秒";
        int inputSecs = getInput(sec);
        System.out.println("3分間だけ待ってやる by ムスカ大佐\n（※実際は"+inputMins+"分"+inputSecs+"秒待ちます。)");

        int countingSecs = inputMins * 60 + inputSecs;

        try {
            while (countingSecs > 0) {
                System.out.println(countingSecs);
                Thread.sleep(1000);
                countingSecs--;
            }
            System.out.println("時間だ by ムスカ大佐");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
