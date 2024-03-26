public class Main {
    public static void main(String[] args) {
        converter1 cn=new converter1();
        //System.out.println(cn.converter("hi i am done"));
        converter2 cn2=new converter2();
        //System.out.println(cn2.converter("Tare ajouka 13"));
        //System.out.println(cn2.converter("Tare ajouka 13"));
        converter3 cn3=new converter3('_');
        //System.out.println(cn3.converter("Tarek Ajouka 30"));


        multi cnM=new multi();

        cnM.addConverter(cn);
        cnM.addConverter(cn2);
        cnM.addConverter(cn3);


        System.out.println(cnM.converter("Tarek Ajouka 30"));
        System.out.println(cnM.converter("Tarek Ajouka 30"));
    }
}