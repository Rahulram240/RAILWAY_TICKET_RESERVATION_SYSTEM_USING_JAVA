import java.util.*;
public class TicketBook {
    static int aLB = 2;
    static int aMB = 1;
    static int aUB = 1;
    static int aRAC = 1;
    static int aWL = 1;

    static List<Integer> lBP = new ArrayList<>(Arrays.asList(1,2)); 
    static List<Integer> mBP = new ArrayList<>(Arrays.asList(1)); 
    static List<Integer> uBP = new ArrayList<>(Arrays.asList(1)); 
    static List<Integer> racP = new ArrayList<>(Arrays.asList(1)); 
    static List<Integer> wlP = new ArrayList<>(Arrays.asList(1 )); 

    static Queue<Integer> racList=new LinkedList<>();
    static Queue<Integer> wlList=new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    static Map<Integer,Passenger> passenger_stored_data = new HashMap<>();

    public void bookTicket(Passenger p,int snumber,String allotedBerth){
        p.number=snumber;
        p.alloted=allotedBerth;
        passenger_stored_data.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.err.println("\nPassenger id: "+p.passengerId);
        System.err.println("Passenger name: "+p.name);
        System.err.println("Passenger age: "+p.age);
        System.err.println("Passenger gender: "+p.gender);
        System.err.println("Alloted berth "+snumber+allotedBerth);
        System.err.println("Booked Successfully.....\n\n");
    }
    public void racTicket(Passenger p,int snumber,String RACBerth){
        p.number=snumber;
        p.alloted=RACBerth;
        passenger_stored_data.put(p.passengerId, p);
        racList.add(p.passengerId);
        System.err.println("\nPassenger id: "+p.passengerId);
        System.err.println("Passenger name: "+p.name);
        System.err.println("Passenger age: "+p.age);
        System.err.println("Passenger gender: "+p.gender);
        System.err.println("Alloted berth "+snumber+RACBerth);
        System.err.println("RAC BERTH GIVEN.....\n\n");
    }

    public void wlTicket(Passenger p,int snumber,String wlBerth){
        p.number=snumber;
        p.alloted=wlBerth;
        passenger_stored_data.put(p.passengerId, p);
        wlList.add(p.passengerId);
        System.err.println("\nPassenger id: "+p.passengerId);
        System.err.println("Passenger name: "+p.name);
        System.err.println("Passenger age: "+p.age);
        System.err.println("Passenger gender: "+p.gender);
        System.err.println("Alloted berth "+snumber+wlBerth);
        System.err.println("WAITING LIST GIVEN.....\n\n");
    }

    public void cancelTicket(int id) {
        Passenger p = TicketBook.passenger_stored_data.get(id);
        if (p == null) {
            System.err.println("Passenger not Found");
            return;
        }
    
        TicketBook.passenger_stored_data.remove(id);
        TicketBook.bookedTicketList.remove(Integer.valueOf(id));  
        int psnumber = p.number;
        System.out.println("Cancelled Successfully");
    
        if (p.alloted.equals("L")) {
            TicketBook.lBP.add(psnumber);
            TicketBook.aLB++;
        } else if (p.alloted.equals("M")) {
            TicketBook.mBP.add(psnumber);
            TicketBook.aMB++;
        } else if (p.alloted.equals("U")) {
            TicketBook.uBP.add(psnumber);
            TicketBook.aUB++;
        }
    
       
        if (!TicketBook.racList.isEmpty()) {
            Passenger passengerfromRAC = TicketBook.passenger_stored_data.get(TicketBook.racList.poll());
            int pracsnumber = passengerfromRAC.number;
            TicketBook.racP.add(pracsnumber);
            TicketBook.aRAC++;
    
            if (!TicketBook.wlList.isEmpty()) {
                Passenger passengerfromwl = TicketBook.passenger_stored_data.get(TicketBook.wlList.poll());
                int pwlnumber = passengerfromwl.number;
                TicketBook.wlP.add(pwlnumber);
    
                passengerfromwl.number = TicketBook.racP.get(0);
                passengerfromwl.alloted = "RAC";
                TicketBook.racP.remove(0);
                TicketBook.racList.add(passengerfromwl.passengerId);
                TicketBook.aWL++;
                TicketBook.aRAC--;
            }
            Main.bookTicket(passengerfromRAC);
        }
    }
    


    public void passengerDetails(){
        if(passenger_stored_data.isEmpty()){
            System.err.println("\nNo Passengers Details Not Found\n");
        }
        else{
            for(Passenger p:passenger_stored_data.values()){
                System.out.println("\n\nPassenger id: "+p.passengerId);
                System.out.println("Passenger name: "+p.name);
                System.out.println("Passenger age: "+p.age);
                System.out.println("Passenger Gender: "+p.gender);
                System.out.println("Alloted Berth: "+p.number+p.alloted);
                System.out.println("Passenger Child Name: "+p.cname);
                System.out.println("Passenger Child Age: "+p.cage);
                System.out.println();
            }
        }
    }

}
