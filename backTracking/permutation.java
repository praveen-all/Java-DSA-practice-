public class permutation {
    public static void permu(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            String newstr=str.substring(0, i)+str.substring(i+1);
            permu(newstr, ans+cur);

        }
    }
    public static void main(String[] args) {
        permu("abc", "");
    }
}
