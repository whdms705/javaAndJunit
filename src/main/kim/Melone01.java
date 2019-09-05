package main.kim;

public class Melone01 {
    public static void main(String[] args) {
        String s = "abcd";
        int left=1;
        int right=2;
        long start = System.nanoTime();
        System.out.println(solution(s,left,right));
        long end = System.nanoTime();
        System.out.println("실행시간 : "+(end-start)/100);
    }

    public static String solution(String s,int left ,int right){
        int leng = s.length();
        char[] ch = s.toCharArray();
        char[] tm = new char[leng];

        if(leng>1){
            if(left>0){
                for(int i =0;i<leng;i++){
                    int index = i-(left%leng);
                    if(index<0){
                        index+=leng;
                    }
                    tm[index] = ch[i];
                }
            }
            ch = tm.clone();
            if(right>0){
                for(int i =0;i<leng;i++){
                    int index = (i+right)%leng;
                    tm[index] = ch[i];
                }
            }
        }
        return String.valueOf(tm);
    }

    public static String solution2(String s,int left ,int right){
        int leng = s.length();

        String result = "";
        if(leng>1){
            if(left>0){
                String move = s.substring(0,left);
                String stop = s.substring(left,leng);
                result = stop+move;
            }
            String temp = result;
            result= "";
            if(right>0){
                String move = temp.substring(leng-right,leng);
                String stop = temp.substring(0,leng-right);
                result = move+stop;
            }
        }
        return result;
    }
}
