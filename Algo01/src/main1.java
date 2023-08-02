public class main1 {

    public static void main(String[]args){
        Nodelist v=new Nodelist();

        Nodelist x=new Nodelist();
        x.addFirst("a");
        x.addFirst("b");
        x.addFirst("c");
        x.addlast("z");

        Lists.zaehler("abcdefg");
       
        x.add(0,"z");
x.add(4,"w");
        x.add(3,"w");
        x.add(1,"w");
        System.out.println(x.displayList());
        System.out.println(x.sizeOf());

    }
}
