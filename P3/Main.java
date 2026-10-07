abstract class Seat{String id;Seat(String i){id=i;}abstract int getPrice();}
class RegularSeat extends Seat{RegularSeat(String i){super(i);}int getPrice(){return 150;}}
class PremiumSeat extends Seat{PremiumSeat(String i){super(i);}int getPrice(){return 250;}}
class ReclinerSeat extends Seat{ReclinerSeat(String i){super(i);}int getPrice(){return 400;}}
class Show{String name;java.util.Set<String> booked=new java.util.HashSet<>();Show(String n){name=n;}boolean reserve(Seat s){return booked.add(s.id);}void release(Seat s){booked.remove(s.id);}}
class Booking{java.util.List<Seat> seats=new java.util.ArrayList<>();Show show;Booking(Show s,Seat... ss){if(ss.length<1||ss.length>6)throw new IllegalArgumentException();show=s;for(Seat x:ss)if(!show.reserve(x))throw new IllegalStateException("Seat already booked");java.util.Collections.addAll(seats,ss);}int total(){int n=0;for(Seat s:seats)n+=s.getPrice();return n;}void cancel(){for(Seat s:seats)show.release(s);}}
public class Main{public static void main(String[]a){Show s=new Show("Premiere");Booking b=new Booking(s,new RegularSeat("A1"),new RegularSeat("A2"),new PremiumSeat("F5"));System.out.println(b.total());b.cancel();}}