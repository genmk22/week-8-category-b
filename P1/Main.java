class Student{String name;Student(String n){name=n;}}
interface WashType{String getName();int getMinutes();int getPrice();}
class QuickWash implements WashType{public String getName(){return "Quick";}public int getMinutes(){return 30;}public int getPrice(){return 20;}}
class NormalWash implements WashType{public String getName(){return "Normal";}public int getMinutes(){return 45;}public int getPrice(){return 30;}}
class HeavyWash implements WashType{public String getName(){return "Heavy";}public int getMinutes(){return 60;}public int getPrice(){return 45;}}
class WashingMachine{private boolean busy;boolean isBusy(){return busy;}void start(){if(busy)throw new IllegalStateException("Machine busy");busy=true;}void finish(){busy=false;}}
class WashCycle{Student student;WashingMachine machine;WashType type;WashCycle(Student s,WashingMachine m,WashType t){student=s;machine=m;type=t;}int book(){machine.start();return type.getPrice();}void finish(){machine.finish();}}
public class Main{public static void main(String[]a){WashingMachine m=new WashingMachine();WashCycle c=new WashCycle(new Student("Asha"),m,new NormalWash());System.out.println(c.book());c.finish();}}