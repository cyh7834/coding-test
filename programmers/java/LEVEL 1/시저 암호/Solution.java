class Solution {
  public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        int charArrayLength = charArray.length;

        for (int i = 0; i < charArrayLength; i++) {
            if (charArray[i] == ' ')
                continue;

            int charToInt = (int) charArray[i];

            if (charToInt >= 66 && charToInt <= 90 && charToInt + n > 90)
                charToInt = charToInt - 26;
            else if (charToInt >= 98 && charToInt <= 122 && charToInt + n > 122)
                charToInt = charToInt - 26;
            
            charArray[i] = (char) (charToInt + n);
        }
      
        return new String(charArray);
  }
}