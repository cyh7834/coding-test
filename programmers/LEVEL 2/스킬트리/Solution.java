package programmers;

public class Solution {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index = 0;
        boolean isRightTree = true;
        for (String skill_tree : skill_trees) {
        	char[] charSkillTree = skill_tree.toCharArray();
        	
        	for (char charSkill : charSkillTree) {
        		int foundIndex = skill.indexOf(charSkill);
        		
        		//��ų�� ��ųƮ�� ������ ã�Ƴ� �� �ùٸ� ��ųƮ������ Ȯ���Ѵ�.
        		if (foundIndex == index) {
        			isRightTree = true;
        			index++;
        		}
        		else if (foundIndex != -1 && foundIndex != index) {
        			isRightTree = false;
        			break;
        		}
        	}

        	if (isRightTree)
        		answer++;
        	
        	index = 0;
            isRightTree = true;
        }
        return answer;
    }
}
