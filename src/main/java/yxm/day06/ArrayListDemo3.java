package yxm.day06;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListDemo3 {
    public static void main(String[] args){
        //采用直接赋值的形式
        ArrayList<Students11> list=new ArrayList<>();
        Students11 stu1=new Students11("张三",25);
        Students11 stu2=new Students11("李四",24);
        Students11 stu3=new Students11("王五",22);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        System.out.println(list.size());
        for (Students11 students11 : list) {
            System.out.println(students11.getName() + students11.getAge());
        }
        //用户自己输入学生的信息
        ArrayList<Students11> list1=new ArrayList<>();
        for(int i=0;i<3;i++){
            Scanner sc=new Scanner(System.in);
            Students11 s=new Students11();      //注意这个学生创建对象放在循环之外和里面效果是不一样的
            System.out.print("请输入学生的姓名:");
            String name=sc.next();
            System.out.print("请输入学生的年龄:");
            int age=sc.nextInt();
            s.setName(name);
            s.setAge(age);
            list1.add(s);
        }
        System.out.println(list1.size());
        for (Students11 students11 : list1) {
            System.out.println(students11.getName() + students11.getAge());
        }
    }
}
class Students11{
    String name;
    int age;
    public Students11(){}
    public Students11(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
