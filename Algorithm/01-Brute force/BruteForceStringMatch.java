public class BruteForceStringMatch {
    private static int bruteForceStringMatch(String [] text, String [] pattern){
        for (int i=0; i<text.length-1 - pattern.length-1 ; i++){
            int j = 0;
            while( j<pattern.length && pattern[j].equals(text[i+j])){
                if( j == pattern.length-1){
                    return i+1;
                }
                j++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String [] text = {"N", "O", "B", "O", "D", "Y","_","N","O","T","I","C","E","D","_","H","I","M"};
        String [] pattern = {"N","O","T"};
        System.out.print(bruteForceStringMatch(text, pattern));
    }    
}
