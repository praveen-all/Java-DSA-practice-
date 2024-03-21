public class hacckerrank {
    public static String decryptMessage(String encryptedMessage) {
        int n = encryptedMessage.length();
        String str = "";
        int count = 1;
        int wspace = 0;
        for (int i = 0; i < n - 1; i++) {
            if (encryptedMessage.charAt(i) == ' ')
                wspace++;
            if (encryptedMessage.charAt(i) == encryptedMessage.charAt(i + 1)) {
                count++;
            } else {
                if (count != 1) {
                    str += encryptedMessage.charAt(i - 1);
                    str += count;
                    count = 1;
                } else
                    str += encryptedMessage.charAt(i);
            }

        }
        str+=encryptedMessage.charAt(n-1);
System.out.println(str);
        String aa[] = new String[wspace + 1];
        int j = 0;
          String strr="";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || i==str.length()-1) {
                if(i==str.length()-1)
                    strr+=str.charAt(str.length()-1);
                aa[j] = strr;
                j++;
                strr=new String("");
            }
            strr+=str.charAt(i);
        }
      
         String strp="";
         for(int i=aa.length-1;i>=0;i--){
            strp+=aa[i];
         }
        return strp;
    }

    public static void main(String[] args) {
        String str = "seaside the to sent be to ne2ds army ten of team a";
        System.out.println(decryptMessage(str));
    }
}
