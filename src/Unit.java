public class Unit {
    // 변수: 이름, 레벨, 최대체력, 현재체력, 공격력, 주사위

    String name;
    int level;
    int maxHp;
    int hp;
    int atk;
    int dice;

    Unit() {
    }

    // 생성자
    Unit(String name) {
        this(name, 1);
    }

    Unit(String name, int level) {
        this.name = name;
        this.level = level;
        this.maxHp = level * 100;
        this.hp = maxHp;
        this.atk = level * 10;
    }

    // 멤버가 죽었는지 확인하는 메소드
//     boolean isDead() {
//         if (this.hp <= 0) return true;
//         else return false;
//    }

    void showHp() {
        System.out.println(this.name + "님의 hp: " + this.hp);
    }

    // 공격기능
    void attack(Unit unit) {
        unit.hp -= this.atk;
    }

    // 공격권을 위해 멤버의 주사위를 무작위로 굴림.
    public void rollDice() {
        this.dice = (int)(Math.random() * 6 + 1);
        System.out.println(this.name + "님의 주사위: " + this.dice);
    }
}
