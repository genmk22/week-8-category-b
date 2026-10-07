import java.util.*;
class Student{String name,department;List<NotificationChannel> channels;Student(String n,String d,NotificationChannel...c){name=n;department=d;channels=Arrays.asList(c);}}
interface NotificationChannel{void send(Student s,Notice n);}
class EmailChannel implements NotificationChannel{public void send(Student s,Notice n){System.out.println("Email -> "+s.name+": "+n.title);}}
class SmsChannel implements NotificationChannel{public void send(Student s,Notice n){System.out.println("SMS -> "+s.name+": "+n.title);}}
class AppChannel implements NotificationChannel{public void send(Student s,Notice n){System.out.println("App -> "+s.name+": "+n.title);}}
class Notice{String title;Set<String> departments;Notice(String t,String...d){if(t==null||t.trim().isEmpty()||d.length==0)throw new IllegalArgumentException();title=t;departments=new HashSet<>(Arrays.asList(d));}}
class NoticeBoard{List<Student> students=new ArrayList<>();void add(Student s){students.add(s);}void post(Notice n){for(Student s:students)if(n.departments.contains(s.department))for(NotificationChannel c:s.channels)c.send(s,n);}}
public class Main{public static void main(String[]a){NoticeBoard b=new NoticeBoard();b.add(new Student("Asha","CSE",new EmailChannel(),new AppChannel()));b.post(new Notice("Exam Notice","CSE"));}}