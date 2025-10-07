public int solution(int[][] sizes) {
        int numberOfCard = sizes.length;
        int widthMax = 0, heightMax = 0;

        for (int i = 0; i < numberOfCard; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                widthMax = Math.max(widthMax, sizes[i][0]);
                heightMax = Math.max(heightMax, sizes[i][1]);
            }
            else {
                widthMax = Math.max(widthMax, sizes[i][1]);
                heightMax = Math.max(heightMax, sizes[i][0]);
            }
        }

        return widthMax * heightMax;
    }