import java.util.*;

public class Main {

    public static int pathFinder(String maze) {
        String[] rows = maze.split("\n");
        int N = rows.length;
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = rows[i].toCharArray();
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                assert current != null;
                if (current[0] == N - 1 && current[1] == N - 1) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];
                    if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol] && grid[newRow][newCol] != 'W') {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            steps++;


        }
        return -1;
    }

    public static int[] reArrenge(int[] s) {
        int[] res = new int[s.length];
        int counter = 0;
        for (int j : s) {
            if (j % 2 == 0) {
                res[counter] = j;
                counter++;
            }
        }
        for (int j : s) {
            if (j % 2 != 0) {
                res[counter] = j;
                counter++;
            }
        }

        return res;
    }
    public static boolean sortArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right)
                left++;
            while (arr[right] % 2 == 1 && left < right)
                right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String d = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                ".....W\n" +
                "....W.", c = ".......\n" + ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......\n" +
                ".......";

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(sortArray(a));
        //System.out.println(Arrays.toString(reArrenge(a)));


        //System.out.println(pathFinder(c));
    }
}