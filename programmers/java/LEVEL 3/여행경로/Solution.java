class Solution {
    public String[] solution(String[][] tickets) {
        ArrayList<String[]> answerList = new ArrayList<>();
        int ticketLength = tickets.length;

        for (int i = 0; i < ticketLength; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] visit = new boolean[ticketLength];
                ArrayList<Integer> order = new ArrayList<>();

                dfs(i, visit, order, tickets, answerList);
            }
        }

        int answerListSize = answerList.size();
        String minimumTicketName = "";

        if (answerListSize > 1) {
            for (int i = 1; i < ticketLength + 1; i++) {
                for (int j = 0; j < answerListSize; j++) {
                    String currentTicketName = answerList.get(j)[i];

                    if (j == 0)
                        minimumTicketName = currentTicketName;
                    else {
                        if (currentTicketName.compareTo(minimumTicketName) < 0)
                            minimumTicketName = currentTicketName;
                    }
                }

                Iterator<String[]> iter = answerList.iterator();

                while(iter.hasNext()) {
                    String[] ticketList = (String[]) iter.next();

                    if (minimumTicketName.compareTo(ticketList[i]) < 0)
                        iter.remove();
                }

                answerListSize = answerList.size();

                if (answerListSize == 1)
                    break;
            }

        }

        return answerList.get(0);
    }

    private void dfs(int index, boolean[] visit, ArrayList<Integer> order,
                            String[][] tickets, ArrayList<String[]> answerList) {
        visit[index] = true;
        order.add(index);

        String nextTrip = tickets[index][1];
        int ticketLength = tickets.length;

        for (int i = 0; i < ticketLength; i++) {
            if (!visit[i] && tickets[i][0].equals(nextTrip)) {
                dfs(i, visit, order, tickets, answerList);
            }
        }

        int orderSize = order.size();

        if (orderSize == ticketLength) {
            String[] orderArray = new String[orderSize + 1];

            for (int j = 0; j < orderSize; j++) {
                orderArray[j] = tickets[order.get(j)][0];

                if (j == orderSize - 1){
                    orderArray[j + 1] = tickets[order.get(j)][1];
                }
            }

            answerList.add(orderArray);
        }

        visit[index] = false;
        order.remove(orderSize - 1);
    }
}