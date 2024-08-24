public class Passenger {
    static int id=1;
    String name;
    int age;
    String gender;
    String bp;
    String cname;
    int cage;
    int passengerId=id++;
    String alloted;
    int number;

    public Passenger(String name,int age,String gender,String bp,String cname,int cage){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.bp=bp;
        this.cname=cname;
        this.cage=cage;
        alloted=" ";
        number=-1;
    }
}
