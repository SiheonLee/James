public class Player extends Unit implements Fightable, Runnable {
    // 추가변수 : 경험치, 목표경험치, 돈
    int exp;
    int goalExp;
    int money;

    // 생성자
    public Player(String name) {
        super(name);
        // Overriding
        this.atk = 80;

        this.exp = 0;
        this.goalExp = 100;
        this.money = 0;
    }

    void showStatus() {
        System.out.println("----------------------");
        System.out.println(this.name + "님의 상태");
        System.out.println("레벨: " + this.level);
        System.out.println("최대 체력: " + this.maxHp);
        System.out.println("현재 체력: " + hp);
        System.out.println("공격력: " + atk);
        System.out.println("경험치: " + exp);
        System.out.println("목표 경험치: " + goalExp);
        System.out.println("돈: " + money);
        System.out.println("----------------------");
    }

    // 회복기능.
    void heal() {
        if (hp == maxHp) {
            System.out.println("최대 체력입니다.");
        } else if (hp <= 0) {
            hp = maxHp;
            System.out.println("체력이 회복되었습니다.");
        } else if (money > 10) {
            hp = maxHp;
            money -= 10;
            System.out.println("체력이 회복되었습니다.");
        } else {
            System.out.println("돈이 부족합니다.");
        }
    }

    // 경험치 증가
    void expUp(int exp) {
        this.exp += exp;
        System.out.println("==========================");
        System.out.println(exp + "경험치를 얻었습니다.");
        System.out.println("현재 경험치: " + this.exp);
        System.out.println("목표 경험치: " + this.goalExp);
        // 레벨업하는지 확인
        if (this.exp >= goalExp) {
            levelUp();
        }

    }

    // 돈 증가
    void moneyUp(int money) {
        this.money += money;
        System.out.println("===========================");
        System.out.println(money + "골드를 얻었습니다.");
        System.out.println("현재 보유한 돈: " + this.money);
    }

    // 레벨업
   void levelUp() {
        // 레벨업하면 레벨 증가와 함꼐 목표 경험치 증가, 최대체력과 공격력이 증가됩니다.
        // 경헙치는 목표 경험치를 뻄.

        exp = exp - goalExp;
        goalExp += 100;
        level += 1;
        maxHp += 100;
        hp = maxHp;
        atk += 10;
       System.out.println("==========================");
       System.out.println("레벨업 하셨습니다! 현재 레벨은 " + this.level + "입니다.");
   }
}
