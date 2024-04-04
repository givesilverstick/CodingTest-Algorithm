class Solution {
    public String solution(String my_string) {
        char[] vowel = {'a', 'i', 'o', 'e', 'u'};
        String answer = "";
        for (int i=0; i<my_string.length(); i++) {
            boolean isVowel = false;
            for (int j=0; j<vowel.length; j++) {
                if (my_string.charAt(i) == vowel[j]) {
                    isVowel = true;
                }
            }
            if (!isVowel) {
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}