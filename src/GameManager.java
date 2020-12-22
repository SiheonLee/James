import java.util.Scanner;

public class GameManager {

    public static void startGame(Player player) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu(); // 메뉴 보이기.

            String input = sc.nextLine();
            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input.equals("1")) {
                Monster monster = selectMonster(); // 원하는 레벨의 몬스터 생성
                System.out.println("적의 레벨: " + monster.level);

                int returnValue = fight(player, monster);
                switch (returnValue) {
                    case 0:
                        System.out.println("무승부입니다.");
                        break;
                    case 1:
                        System.out.println("축하합니다. 이겼습니다.");
                        break;

                    case 2:
                        System.out.println("졌습니다. 경험치가 감소합니다.");

                        // 플레이어는 회복
                        player.heal();
                        break;
                }

            } else if (input.equals("2")) {
                player.heal();
            } else if (input.equals("3")) {
                player.showStatus();
            } else if (input.equals("10")) {
                System.out.println("원하는 옵션의 번호를 입력해주세요.");
            }
        }
    }


    static void showMenu() {
        System.out.println("0) exit  1) fight  2) heal  3) status  10) help");
    }

    static Monster selectMonster() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***********************");
        System.out.println("몬스터를 선택하세요.");
        System.out.println("1) 초급 (level 1 ~ 3)");
        System.out.println("2) 중급 (level 4 ~ 6)");
        System.out.println("3) 고급 (level 7 ~ 9)");

        Monster monster;

        String input = sc.nextLine();

        if (input.equals("1")) {
            monster = new EasyMonster();
            return monster;
        } else if (input.equals("2")) {
            monster = new NormalMonster();
            return monster;
        } else if (input.equals("3")) {
            monster = new HardMonster();
            return monster;
        } else {
            System.out.println("Wrong Input");
            return null;
        }
    }



    public static int fight(Player player, Monster monster) {
        Scanner sc = new Scanner(System.in);

        System.out.println("####################");
        System.out.println("전투를 시작합니다!");
        while (true) {
            System.out.println("1) fight 2) run");
            String input = sc.nextLine();

            if (input.equals("1")) {
                // 공격권을 위한 주사위를 던진다.
                player.rollDice();
                monster.rollDice();

                // 주사위 숫자가 크거나 같을 때 플레이어가 우선 공격한다.
                if (player.dice >= monster.dice) {
                    player.attack(monster);
                    monster.showHp();
                    if (monster.hp <= 0) {
                        System.out.println(player.name + "님이 " + monster.name + "을 쓰러트렸습니다.");
                        player.expUp(monster.exp);
                        player.moneyUp(monster.money);
                        return 1;
                    }

                    monster.attack(player);
                    player.showHp();
                    if (player.hp <= 0) {
                        System.out.println(monster.name + "님이 " + player.name + "을 쓰러트렸습니다.");
                        player.exp -= player.exp / 2;
                        return 2;
                    }

                } else {
                    monster.attack(player);
                    player.showHp();
                    if (player.hp <= 0) {
                        System.out.println(monster.name + "님이 " + player.name + "을 쓰러트렸습니다.");
                        player.exp -= player.exp / 2;
                        return 2;
                    }

                    player.attack(monster);
                    monster.showHp();
                    if (monster.hp <= 0) {
                        System.out.println(player.name + "님이 " + monster.name + "을 쓰러트렸습니다.");
                        player.expUp(monster.exp);
                        player.moneyUp(monster.money);
                        return 1;
                    }
                }

            } else if (input.equals("2")) {
                System.out.println("아직 개발중입니다.");
            } else {
                System.out.println("잘못 입력하셨습니다.");
                break;
            }
        }

        return 2;

    }

}
