class Solution {
    public boolean backspaceCompare(String s, String t) {

     Stack<Character> stackS = new Stack<>();
     Stack<Character> stackT = new Stack<>();

     for(char ch : s.toCharArray()){
        if( ch == '#'){
            if(!stackS.isEmpty()){
                 stackS.pop();
            }
        }else{
             stackS.push(ch);
        }
     }

     for(char ch : t.toCharArray()){
        if(ch == '#'){
            if(!stackT.isEmpty()){
                stackT.pop();
            }
        }else{
            stackT.push(ch);
        }
     }
      
      return stackS.equals(stackT);
    }
}