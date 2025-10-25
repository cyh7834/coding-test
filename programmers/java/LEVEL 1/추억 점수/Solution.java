class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            nameMap.put(name[i], yearning[i]);
        }

        for (String[] p : photo) {
            int score = 0;

            for (String photoName : p) {
                Integer year = nameMap.get(photoName);

                if (year != null)
                    score += year;
            }

            answer.add(score);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}