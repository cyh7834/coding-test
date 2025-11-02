class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int minWallet, maxWallet, minBill, maxBill;

        if (wallet[0] <= wallet[1]) {
            minWallet = wallet[0];
            maxWallet = wallet[1];
        }
        else {
            minWallet = wallet[1];
            maxWallet = wallet[0];
        }

        if (bill[0] <= bill[1]) {
            minBill = bill[0];
            maxBill = bill[1];
        }
        else {
            minBill = bill[1];
            maxBill = bill[0];
        }

        while ((minBill > minWallet) || (maxBill > maxWallet)) {
            if (bill[0] >= bill[1])
                bill[0] = bill[0] / 2;
            else
                bill[1] = bill[1] / 2;

            if (bill[0] <= bill[1]) {
                minBill = bill[0];
                maxBill = bill[1];
            }
            else {
                minBill = bill[1];
                maxBill = bill[0];
            }

            answer++;
        }

        return answer;
    }
}