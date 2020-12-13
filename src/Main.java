import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player("권재영", "한손검", 50, 100, 1);
        Enemy enemy = new Enemy("이시헌", 10, 100, 1);


        System.out.println("0) exit, 1) battle, 10) 도움말");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input.equals("1")) {
                int returnValue = getBattleWinner(player, enemy);
                switch (returnValue) {
                    case 0:
                        System.out.println("무승부입니다. 후훗");
                        break;
                    case 1:
                        System.out.println("축하합니다. 이겼습니다.");
                        enemy = new Enemy("이시헌", 10, 100, 1);
                        break;
                    case 2:
                        System.out.println("눈앞이 캄캄해졌습니다.");
                        return;
                    case -1:
                        System.out.println("에러");
                        break;
                }

            } else if (input.equals("10")) {
                System.out.println("0) exit, 1) battle, 10) 도움말");
            }

        }
    }

    public static int getBattleWinner(Player player, Enemy enemy) {
        enemy.hp -= player.atk;
        player.hp -= enemy.atk;

        if (enemy.hp > 0 && player.hp > 0) {
            System.out.println(player.name +"님의 hp: " + player.hp);
            System.out.println(enemy.name + "님의 hp: " + enemy.hp);
            return 0;
        } else if (enemy.hp <= 0) {
            System.out.println(player.name + "님이 " + enemy.name + "을 쓰러트렸습니다.");
            return 1;
        } else if (player.hp <= 0) {
            System.out.println(enemy.name + "님이 " + player.name + "을 쓰러트렸습니다.");
            return 2;
        } else {
            return -1;
        }

    }
}
