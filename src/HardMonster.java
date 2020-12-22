public class HardMonster extends Monster {

    public HardMonster() {
        super();
        int i = (int) (Math.random() * 3 + 7);
        System.out.println("i = " + i);

        this.name = names[i];
        this.level = i;
        this.maxHp = level * 100;
        this.hp = maxHp;
        this.atk = level * 10;
        this.exp = level * 50;
        this.money = level * 100;
    }
}
