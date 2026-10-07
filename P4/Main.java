abstract class MembershipPlan{abstract double fee(int months);}
class MonthlyPlan extends MembershipPlan{double fee(int m){return 1000*m;}}
class QuarterlyPlan extends MembershipPlan{double fee(int m){return m==3?2700:1000*m;}}
class AnnualPlan extends MembershipPlan{double fee(int m){return m==12?9000:1000*m;}}
class Member{String name;Member(String n){name=n;}}
class Membership{Member member;MembershipPlan plan;String status="Active";Membership(Member m,MembershipPlan p){member=m;plan=p;}double fee(int months){return plan.fee(months);}void freeze(){if(status.equals("Active"))status="Frozen";}void unfreeze(){if(status.equals("Frozen"))status="Active";}void expire(){status="Expired";}void checkIn(){if(!status.equals("Active"))throw new IllegalStateException("Check-in not allowed");}}
public class Main{public static void main(String[]a){System.out.println(new Membership(new Member("Asha"),new QuarterlyPlan()).fee(3));}}