/**
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 * 행렬의 곱셈
 */
class Programmers12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }

            }
        }
        return answer;
    }
}