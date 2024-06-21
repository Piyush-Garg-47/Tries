public class StartWithProblem {
    static class Node{
        Node children[] = new Node[26] ;
        boolean eow =false ;
         Node(){
            for(int i =0 ; i<26 ; i++){
                children[i] = null ; 
            }
         }
     }
     public static Node root = new Node() ; 
     public static void insert (String word ){
        Node curr = root ; 
        int level =0 ;
        int len = word.length() ;
        int idx = 0 ;
        for( ; level<word.length() ; level++){
            idx = word.charAt(level) - 'a';
           if(curr.children[idx] == null){
               curr.children[idx] = new Node();
           } 
           curr = curr.children[idx] ; 
        }
        curr.eow = true ;
     }
     public static void search (String key){
        Node curr = root ; 
        int level =0 ;
        int len = key.length() ;
        int idx = 0 ;
        for( ; level<len; level++){
            idx = key.charAt(level) - 'a';
           if(curr.children[idx] == null){
               curr.children[idx] = new Node();
           } 
           curr = curr.children[idx] ; 
        }
        curr.eow = true ;
     }
      public static boolean StartWith(String prefix ){
        Node curr = root ; 
        for(int i =0 ; i<prefix.length() ;i++){
            int idx = prefix.charAt(i) -'a';
            if(curr.children[idx] == null){
                return false ; 
            }
            curr=curr.children[idx] ;
        }
         return true ; 
      }
     public static void main(String[] args) {
        String  words [] ={"apple" ,"app" ,"mango", "man" , "woman"} ;
        String prefix1 ="app" ;
        String prefix2 ="moon" ;
        for(int i=0 ; i<words.length ; i++){
            insert(words[i]);
           }
           System.out.println(StartWith(prefix2));
  }
}
