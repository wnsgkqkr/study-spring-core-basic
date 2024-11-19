package study.core.sigleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드 10000 -> 20000으로 변경

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제 코드
    }

    public int getPrice() {
        return this.price;
    }
}
