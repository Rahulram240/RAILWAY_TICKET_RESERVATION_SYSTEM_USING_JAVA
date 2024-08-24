import java.util.Scanner;
public class Main{
    public static void bookTicket(Passenger p){
        TicketBook tb =new TicketBook();

        if (TicketBook.aWL == 0) {
            System.out.println("NO TICKETS AVAILABLE");
            return;
        }

        else if(p.age > 60 && TicketBook.aLB>0){
            System.out.println("As you're a senior Citizen we're arranging you a Lower Berth");
            tb.bookTicket(p, TicketBook.lBP.get(0), "L");
            TicketBook.lBP.remove(0);
            TicketBook.aLB--;
        }
        else if(!p.cname.equals("null")&& TicketBook.aLB>0){
            System.err.println("As you've a child we arranged a Lower Berth ");
            tb.bookTicket(p, TicketBook.lBP.get(0), "L");
            TicketBook.lBP.remove(0);
            TicketBook.aLB--;
        }
        else if((p.bp.equals("L") && TicketBook.aLB>0)|| (p.bp.equals("M") && TicketBook.aMB>0)|| (p.bp.equals("U") && TicketBook.aUB>0)){
            if(p.bp.equals("L")){
                System.err.println("Lower Berth Given");
                tb.bookTicket(p, TicketBook.lBP.get(0), "L");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--;
            }
            else if(p.bp.equals("M")){
                System.err.println("Middle Berth Given");
                tb.bookTicket(p, TicketBook.mBP.get(0), "M");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;
            }
            else if(p.bp.equals("U")){
                System.err.println("Upper Berth Given");
                tb.bookTicket(p, TicketBook.uBP.get(0), "U");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--; 
            }
        }
            else if(TicketBook.aLB>0){
                System.err.println("Lower Berth Given");
                tb.bookTicket(p, TicketBook.lBP.get(0), "L");
                TicketBook.lBP.remove(0);
                TicketBook.aLB--; 
            }
            else if(TicketBook.aMB>0){
                System.err.println("Middle Berth Given");
                tb.bookTicket(p, TicketBook.mBP.get(0), "M");
                TicketBook.mBP.remove(0);
                TicketBook.aMB--;  
            }
            else if(TicketBook.aUB>0){
                System.err.println("Upper Berth Given");
                tb.bookTicket(p, (TicketBook.uBP.get(0)), "U");
                TicketBook.uBP.remove(0);
                TicketBook.aUB--;
            }
            else if(TicketBook.aRAC>0){
                System.err.println("RAC given");
                tb.racTicket(p, TicketBook.racP.get(0), "RAC");
                TicketBook.racP.remove(0);
                TicketBook.aRAC--;
            }
            else if(TicketBook.aWL>0){
                System.err.println("Waiting List Given");
                tb.wlTicket(p, TicketBook.wlP.get(0), "WL");
                TicketBook.wlList.remove(0);
                TicketBook.aWL--;
            }
        }

        public static void CancelTicket(int id){
            TicketBook tb=new TicketBook();
            if(!TicketBook.passenger_stored_data.containsKey(id)){
                System.err.println("Passenger not Found");
            }
            else{
              tb.cancelTicket(id);  
            }
        }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Boolean l=true;
        while(l){
            System.err.println("\n1.Book \n2.Cancel \n3.Available tickets \n4.Exit");
            int n=s.nextInt();
            switch (n) {
                case 1:
                System.err.println("Enter the name: ");
                String name=s.next();
                System.err.println("Enter the age: ");
                int age=s.nextInt();
                System.err.println("Enter the Gender: [M,F]");
                String gender=s.next();
                String cname = "null";
                int cage = 0;

                if(gender.equals("F")){
                    System.err.println("\n1.Do you have any Child with you ?,press 1\n2.If you don't have any child ,press 2");
                    int gc=s.nextInt();
                    if(gc == 1){
                        System.err.println("Enter the Child Name = ");
                        cname = s.next();
                        System.err.println("Enter the Child's age = ");
                        cage = s.nextInt();
                    } 
                }
                System.err.println("Enter the passenger berth preference:[L,M,U]");
                String bp=s.next();
                Passenger p=new Passenger(name, age, gender, bp,cname ,cage);
                bookTicket(p); 
                break;
                case 2:
                System.err.print("Enter the Passenger Id : ");
                int id=s.nextInt();
                CancelTicket(id);
                break;
                case 3:
                TicketBook tb=new TicketBook();
                tb.passengerDetails();
                break;
                case 5:
                l=false;
                break;
                default:
                break;
            }   
        }
    }
}