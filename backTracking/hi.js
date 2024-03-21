function hello(str,s,i){
    if(i==str.length){
        console.log(s);
        return ;
    }
    hello(str,s+str.charAt(i),i+1);
    hello(str,s,i+1);
}
hello("abc","",0);