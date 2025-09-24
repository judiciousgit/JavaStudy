package yxm.day07;
import java.util.Scanner;
import java.util.ArrayList;
public class StudentManagementSystem {
    public static void StartStudentSystem() {
        ArrayList<Student22> list=new ArrayList<>();
        loop:while (true) {
            System.out.println("-------------学生管理系统------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.print("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1"->addStudent(list);
                case "2"->deleteStudent(list);
                case "3"->updateStudent(list);
                case "4"->findStudent(list);
                case "5"->{
                    System.out.println("5:退出");
                    break loop;//如果是break只能跳出第一个switch不能跳出while循环，然而这种是可以跳出双层循环的
                    //System.exit(0) 这种情况就是停止虚拟机运行
                }
                default->System.out.println("没有这个选项");
            }
        }
    }
    public static void addStudent(ArrayList<Student22> list){
        System.out.println("添加学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生的id：");
        String id=sc.next();
        System.out.println("请输入学生的姓名：");
        String name=sc.next();
        System.out.println("请输入学生的年龄：");
        int age=sc.nextInt();
        System.out.println("请输入学生的地址：");
        String address=sc.next();
        Student22 s=new Student22(id,name,age,address);
        int flag=contains(list,id);
        if(flag>=0){
            System.out.println("该学生已在集合中，请勿重复添加");
        }
        else{
            list.add(s);
            System.out.println("学生添加成功");
        }

    }
    public static void deleteStudent(ArrayList<Student22> list){
        System.out.println("删除学生");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入删除学生的id：");
        String id=sc.next();
        int index=getIndex(list,id);
        if(index>=0){
            list.remove(index);
            System.out.println("学生id为"+id+"删除成功");
        }
        else{
            System.out.println("id不存在，回到初始菜单");
            return;
        }
    }
    public static void updateStudent(ArrayList<Student22> list){
        System.out.println("修改学生");
        Scanner sc=new Scanner(System.in);
        int index=getIndex(list,sc.next());
        if(index<0){
            System.out.println("id不存在，回到初始菜单");
            return;
        }
        else{
            Student22 s=list.get(index);
//            System.out.println("请输入新的姓名：");
//            String newName=sc.next();
//            s.setName(newName);
//            System.out.println("请输入新的年龄：");
//            int newAge=sc.nextInt();
//            s.setAge(newAge);
//            System.out.println("请输入新的家庭住址：");
//            String newAddress=sc.next();
//            s.setAddress(newAddress);
            loop:while(true){
                System.out.println("请选择需要修改的信息（1是姓名，2是年龄，3是家庭住址，4是退出）：");
                Scanner sc2=new Scanner(System.in);
                int choose=sc2.nextInt();
                switch(choose){
                    case 1->{
                        System.out.println("请输入新的姓名：");
                        String newName=sc.next();
                        s.setName(newName);
                    }
                    case 2->{
                        System.out.println("请输入新的年龄：");
                        int newAge=sc.nextInt();
                        s.setAge(newAge);
                    }
                    case 3->{
                        System.out.println("请输入新的家庭住址：");
                        String newAddress=sc.next();
                        s.setAddress(newAddress);
                    }
                    case 4->{
                        System.out.println("退出");
                        break loop;
                    }
                    default->System.out.println("没有当前选项");
                }
                System.out.println("学生信息修改成功");
            }
        }
    }
    public static void findStudent(ArrayList<Student22> list){
        System.out.println("查询学生");
        if (list.size()==0){
            System.out.println("当前无学生信息，请添加后再查询");
            //结束方法
            return;
        }
        //打印表头信息
        System.out.println("id\t\t\t姓名\t年龄\t家庭住址");
        for(int i=0;i<list.size();i++){
            Student22 s=list.get(i);
            System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());

        }
    }
    public  static int contains(ArrayList<Student22> list, String id){
//        for(int i=0;i<list.size();i++){
//            Student22 s=list.get(i);
//            if(s.getId().equals(id)) return true;
//        }
//        return false;
        int index=getIndex(list,id)>=0?0:-1;
        return index;

    }
    //根据学号返回索引
    public static int getIndex(ArrayList<Student22> list,String id){
        for(int i=0;i<list.size();i++){
            Student22 s=list.get(i);
            if(s.getId().equals(id)) return i;
        }
        return -1;
    }
}
class Student22{
    private String name;
    private String id;
    private int age;
    private String address;
    public Student22(){};
    public Student22(String id,String name,int age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
