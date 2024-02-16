import java.util.ArrayList;
import java.util.HashMap;

public class ImpfPriorisierung {

    public class PriorityException extends RuntimeException{

        public PriorityException(String fehlertext) {
            super(fehlertext);
        }
    }
    private HashMap<String,Integer> gruppen=new HashMap<>();
    public void addiereGruppe(int prioritaet,String gruppe){
       if(prioritaet<1){
           return;
       }



       else if (gruppen.containsKey(gruppe)&&gruppen.get(gruppe)!=prioritaet){
           throw new PriorityException("diese Gruppe hat schon eine Prioritaet im System ");


       }
       else gruppen.put(gruppe,prioritaet);


    }
    public int getPrioritaet(String gruppe){
        return gruppen.getOrDefault(gruppe, -1);
       }


    public ArrayList<String> getGruppe(int prioritaet){
    ArrayList<String> result=new ArrayList<>();
    for(String i:gruppen.keySet()){
        if(gruppen.get(i)==prioritaet)
            result.add(i);
    }
    return result;
    }

    @Override
    public String toString() {
        return "ImpfPriorisierung{" +
                "gruppen=" + gruppen +
                '}';
    }

    public static void main(String[]args){
        ImpfPriorisierung x=new ImpfPriorisierung();
        x.addiereGruppe(1,"U80");
        x.addiereGruppe(1,"U70");
        x.addiereGruppe(1,"U70");
        x.addiereGruppe(2,"U50");
        //x.addiereGruppe(5,"U70");
        x.addiereGruppe(-1,"U60");
        System.out.println(x.toString());
        System.out.println(x.getGruppe(1));
        System.out.println(x.getPrioritaet("U50"));




    }



}
