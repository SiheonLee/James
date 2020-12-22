import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 생성자 활용 플레이어 설정
        // 2. 상속, 인터페이스로 구조 잡기
        // 3. 전투 시스템 구현
        // 오버라이딩, 오버로딩, static, final, getter, setter, 접근제어자, 예외
        // 게임 저장하기, 불러오기 구현

        Scanner sc = new Scanner(System.in);

        // 캐릭터 설정
        System.out.println("어서오세요. 플레이어의 이름을 정해주세요.");
        String str = sc.nextLine();

        Player player = new Player(str);

        GameManager.startGame(player);

    }
}
