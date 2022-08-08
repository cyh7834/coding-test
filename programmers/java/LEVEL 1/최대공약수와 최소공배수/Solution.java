class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = lcm(n, m, gcd);
        
        return new int[]{gcd, lcm};
    }

    public int lcm(int n, int m, int gcd) {
        return n * m / gcd;
    }

    public int gcd(int n, int m) {
        while (m != 0) {
            int c = n % m;
            n = m;
            m = c;
        }

        return n;
    }
}