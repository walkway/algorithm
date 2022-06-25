/**
 * https://programmers.co.kr/learn/courses/30/lessons/92335
 * k진수에서 소수 개수 구하기
 */
class Programmers92335 {

    public int solution(int n, int k) {
        int result = 0;
        StringBuilder number = new StringBuilder();
        while (n > 0) {
            number.append(n % k);
            n /= k;
        }

        number.reverse();
        String[] nums = number.toString().split("0");
        System.out.println(number.toString());
        for (String num : nums) {
            if (num.equals("")) {
                System.out.println("hoi");
                continue;
            }

            if (isPrime(Long.parseLong(num))) {
                result++;
            }
        }

        return result;
    }

    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}