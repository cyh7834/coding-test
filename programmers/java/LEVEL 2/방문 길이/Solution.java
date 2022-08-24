import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int row = 0;
        int col = 0;
        char[] dir = dirs.toCharArray();
        HashSet<String> road = new HashSet<>();

        for (char direction : dir) {
            if (direction == 'U') {
                if (row < 5)
                    addRoad(road, row, col, ++row, col);
            }
            else if (direction == 'D') {
                if (row > -5)
                    addRoad(road, row, col, --row, col);
            }
            else if (direction == 'L') {
                if (col > -5)
                    addRoad(road, row, col, row, --col);
            }
            else if (direction == 'R') {
                if (col < 5)
                    addRoad(road, row, col, row, ++col);
            }
        }

        return road.size();
    }

    private void addRoad(HashSet<String> road, int fromRow, int fromCol, int toRow, int toCol) {
        String road1 = new StringBuilder().append(fromRow).append(fromCol).append(toRow).append(toCol).toString();
        String road2 = new StringBuilder().append(toRow).append(toCol).append(fromRow).append(fromCol).toString();

        if (!road.contains(road1) && !road.contains(road2)) {
            road.add(road1);
        }
    }
}