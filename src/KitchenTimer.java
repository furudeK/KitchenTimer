import java.util.Scanner;

/*
キッチンタイマーのプログラムです。
入力された秒数カウントダウンし、0になったら終了と表示します。
 */


public class KitchenTimer {

    public static int getInput(String strMinOrSec) {
        int num = 0;
        do {
            try {
                System.out.print(strMinOrSec + "を0以上の値で入力してください>>");
                String str = new Scanner(System.in).nextLine();

                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
            }
        } while (num < 0); //マイナスの値が入力された際に、再度入力を促す
        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("キッチンタイマーにセットする分と秒を入力してください。");
        Scanner scanner = new Scanner(System.in);
        String strMin = "分";
        int inputMins = getInput(strMin);
        String strSec = "秒";
        int inputSecs = getInput(strSec);

        int countingSecs = inputMins * 60 + inputSecs;

        //タイマーの値が40秒ならドーラ、それ以外ならムスカ
        if (countingSecs == 40) {
            System.out.println("40秒で支度しな！");
        } else {
            System.out.println("3分間だけ待ってやる by ムスカ大佐\n（※実際は" + inputMins + "分" + inputSecs + "秒待ちます。)");
        }

        try {
            while (countingSecs > 0) {
                System.out.print("残り時間：" + countingSecs / 60 + "分" + countingSecs % 60 + "秒");
                System.out.print("\r"); //残り時間を上書き表示するためにCR文字でカーソルを先頭に移動
                Thread.sleep(1000);
                countingSecs--;
            }
            System.out.println("時間だ by ムスカ大佐");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
