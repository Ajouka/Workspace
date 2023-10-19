public class main2 {


    public static int umtausch (int x,int y){
        String s=String.valueOf(x);
        String res="";


        for(int i=0;i<s.length()-y;i++)
            res+=s.charAt(i);
        for (int i=1;i<y;i++)
            res+=s.charAt(s.length()-i);


     return Integer.parseInt(res);
    }




    public static void main(String[]args){

        System.out.println(umtausch(1234,3));



    }

}
