public class Solution {
    public long totalSalary(String[] relations) {
        int numberOfEmp = relations.length;
        long[] eachSalary = new long[numberOfEmp];
        long result = 0;

        for (int i = 0; i < numberOfEmp; i++)
            result += getSalary(eachSalary, relations, i);

        return result;
    }

    public long getSalary(long[] eachSalary, String[] relations, int empNum) {
        if (eachSalary[empNum] > 0)
            return eachSalary[empNum];

        int numberOfEmp = relations.length;
        char[] relation = relations[empNum].toCharArray();
        long salary = 0;
        boolean noRelation = true;

        for (int i = 0; i < numberOfEmp; i++) {
            if (i == empNum)
                continue;

            if (relation[i] == 'Y') {
                noRelation = false;
                salary += getSalary(eachSalary, relations, i);
            }
        }

        eachSalary[empNum] = noRelation ? 1 : salary;

        return eachSalary[empNum];
    }
}