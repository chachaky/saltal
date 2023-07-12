import java.util.*;

/**
 * packageName    : PACKAGE_NAME   <br>
 * fileName       : back_2644   <br>
 * author         : YoungSeok Kim   <br>
 * date           : 2023-07-12   <br>
 * description   <br><br>
 */
public class back_2644 {

    static int[] depth;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 전체 사람의 수
        int person1 = scanner.nextInt(); // 촌수를 계산해야 하는 첫 번째 사람
        int person2 = scanner.nextInt(); // 촌수를 계산해야 하는 두 번째 사람
        int m = scanner.nextInt(); // 부모 자식 관계의 개수

        depth = new int[n + 1]; // 각 사람의 촌수를 저장할 배열
        graph = new ArrayList<>(); // 인접 리스트로 그래프를 구현

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 각 노드(사람)에 빈 리스트를 할당하여 초기화
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(); // 부모
            int y = scanner.nextInt(); // 자식
            graph.get(x).add(y); // 부모와 자식 간의 관계를 인접 리스트에 추가
            graph.get(y).add(x); // 자식과 부모 간의 관계도 인접 리스트에 추가 (양방향)
        }

        int result = calculateChonSu(person1, person2); // 촌수 계산
        System.out.println(result); // 결과 출력
    }

    public static int calculateChonSu(int start, int end) {
        if (start == end) {
            return 0; // 시작 노드와 목표 노드가 같으면 촌수는 0
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        depth[start] = 1; // 시작 노드의 촌수는 1로 설정

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (depth[next] == 0) { // 방문하지 않은 노드라면
                    queue.offer(next); // 큐에 추가하여 탐색
                    depth[next] = depth[current] + 1; // 부모와의 촌수에 1을 더하여 자식의 촌수 계산

                    if (next == end) {
                        return depth[next] - 1; // 목표 노드에 도달한 경우 해당 노드의 촌수 반환
                    }
                }
            }
        }

        return -1; // 탐색이 종료되었을 때 목표 노드에 도달하지 못한 경우 -1 반환
    }


}
