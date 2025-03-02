package 그리디;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 짐을 쪼갤 수 있는 배낭 문제는 그리디로 해결할 수 있다.
 */
public class 배낭_문제_그리디 {
    static class Cargo {
        // 가치($)
        int price;
        // 무게(kg)
        int weight;
        // 단가($/kg)
        float unitPrice;

        public Cargo(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        public void setUnitPrice(float unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    public static float fractionalKnapsack(List<Cargo> cargo) {
        // 용량
        int capacity = 15;
        // 담을 수 있는 최댓값
        float totalValue = 0;

        //단가를 계산해 업데이트
        for (Cargo c : cargo) {
            c.unitPrice = ((float) c.price / c.weight);
        }

        //단가 역순으로 정렬
        cargo.sort(Comparator.comparingDouble(a -> a.unitPrice * -1));

        // 배낭에 단가 역순으로 담긴 짐의 최댓값 계산
        for (Cargo c : cargo) {
            // 짐을 쪼개도 되지 않는 경우 전체 가격 증가
            if (capacity >= c.weight) {
                totalValue += c.price;
                capacity -= c.weight;
            } else { // 짐을 쪼개는 경우(마지막으로 더함)
                float fraction = (float) capacity / c.weight;
                totalValue += c.price * fraction;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        List<Cargo> cargo = new ArrayList<>();
        cargo.add(new Cargo(4, 10));
        cargo.add(new Cargo(2, 1));
        cargo.add(new Cargo(10, 4));
        cargo.add(new Cargo(1, 1));
        cargo.add(new Cargo(2, 2));

        float result = fractionalKnapsack(cargo);
    }
}
