package 그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 짐을 쪼갤 수 있는 배낭 문제는 그리디로 해결할 수 있다.
 */
public class 배낭_문제_그리디 {
    static class Cargo {
        int price; // ㄱㅏ치
        int weight; // 무게
        float unitPrice; // 단가

        public Cargo(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        public void setUnitPrice(float unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    static float fractionalKnapSack(List<Cargo> cargoList) {
        int capacity = 15;
        float totalValue = 0; // 담을 수 있는 최대 값

        for (Cargo cargo : cargoList) {
            cargo.setUnitPrice((float) cargo.price / cargo.weight);
        }

        cargoList.sort(Comparator.comparingDouble(c -> c.unitPrice * -1));
        for (Cargo cargo : cargoList) {
            System.out.println(cargo.unitPrice);
        }

        for (Cargo cargo : cargoList) {
            if (capacity - cargo.weight >= 0) {
                totalValue += cargo.price;
                capacity -= cargo.weight;
            } else {
                totalValue += cargo.unitPrice * capacity;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        List<Cargo> cargoList = new ArrayList<>();

        cargoList.add(new Cargo(4, 12));
        cargoList.add(new Cargo(2, 1));
        cargoList.add(new Cargo(10, 4));
        cargoList.add(new Cargo(1, 1));
        cargoList.add(new Cargo(2, 2));

        System.out.println("result = " + fractionalKnapSack(cargoList));
    }
}
