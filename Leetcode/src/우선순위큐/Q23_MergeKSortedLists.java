package 우선순위큐;

import java.util.PriorityQueue;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Q23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        ListNode root = new ListNode(0); // dummy 값
        ListNode tail = root;

        // 우선 각 연결 리스트의 첫 번째 노드를 우선순위 큐에 저장
        for (ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        // 큐가 모두 빌 때까지 반복
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null) {
                pq.add(tail.next);
            }
        }

        return root.next;
    }
}
