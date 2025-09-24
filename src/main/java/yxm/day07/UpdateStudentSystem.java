package yxm.day07;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class UpdateStudentSystem {
    public static void main(String[] args) {
        ArrayList<User22> list = new ArrayList<>();
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录，2注册，3忘记密码，4退出");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1 -> registerFunctions(list);
                case 2 -> loginFunctions(list);
                case 3 -> forgotPassword(list);
                case 4 -> {
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
                default -> System.out.println("无当前选项");
            }
        }
    }
    public static void registerFunctions(ArrayList<User22> list) {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    User22 user = new User22();
    String userName;
    String password;
    System.out.println("请输入用户名：");
    while(true) {
        userName=sc.next();
        boolean flag1 = contains(list, userName);
        if (flag1) {
            System.out.println("用户名已注册");
            break;
        }
        else{
            System.out.println("该用户名未注册，请先注册");
            return;
        }
    }
    int count=0;
    while (count<3) {
            System.out.println("请输入密码：");
            password = sc1.next();
            while(true) {
                String confirmPassword = getCode();
                System.out.println("验证码是" + confirmPassword);
                System.out.println("请输入验证码：");
                String confirmPassword1 = sc2.next();
                if (confirmPassword1.equals(confirmPassword)) {
                    System.out.println("验证成功");
                    break;
                }
                else{
                    System.out.println("验证错误，请重新输入验证码");
                    continue;
                }
            }
            User22 user1 = new User22(userName,password,null,null);
            boolean flag1=confirmUser22(list,user1);
            if(flag1) {
                System.out.println("用户登陆成功,开始使用学生管理系统");
                StudentManagementSystem  ss = new StudentManagementSystem();
                ss.StartStudentSystem();
                break;
            }
            else{
                count++;
                System.out.println("登陆失败，用户名或者密码错误。还剩下"+(3-count)+"机会");
                continue;
            }
        }
}
    public static void loginFunctions(ArrayList<User22> list) {
        Scanner sc = new Scanner(System.in);
        String userName;
        String password;
        String idNumber;
        String phoneNumber;
        while(true) {
            System.out.println("请输入用户名（长度不能低于3大于15，也不能全是数字）:" );
            userName = sc.next();
            boolean flag1=checkUserName(list,userName);
            if (flag1) {
                boolean flag = contains(list, userName);
                if (flag) {
                    System.out.println("该用户名已存在，请重新输入用户名");
                    continue;
                } else {
                    System.out.println("用户名设置成功,请输入其他数据");
                    break;
                }
            }
            else{
                System.out.println("用户名格式错误，请重新输入");
            }
        }
        while(true) {
            System.out.println("请输入密码");
            Scanner sc1 = new Scanner(System.in);
            password = sc1.next();
            System.out.println("请再次输入密码");
            Scanner sc2 = new Scanner(System.in);
            String newPassword = sc2.next();
            if (password.equals(newPassword)) {
                System.out.println("密码设置成功,请输入其他数据");
                break;
            } else {
                System.out.println("两次输入密码不一致，请重新输入密码");
                continue;
            }
        }
        while(true) {
            System.out.println("请输入身份证号：");
            Scanner sc3 = new Scanner(System.in);
            idNumber = sc3.next();
            boolean flag2=checkIdNumber(list,idNumber);
            if (flag2) {
                System.out.println("身份证号输入成功，请输入其他信息");
                break;
            }
            else{
                System.out.println("身份证号输入格式存在问题，请重新输入");
                continue;
            }
        }
        while(true) {
            System.out.println("请输入手机号码：");
            Scanner sc4 = new Scanner(System.in);
            phoneNumber = sc4.next();
            boolean flag3=checkPhoneNumber(list,phoneNumber);
            if (flag3) {
                System.out.println("手机号码格式正确，输入成功");
                break;
            }
            else{
                System.out.println("手机号码格式不正确，请重新输入");
                continue;
            }

        }
        User22 user = new User22(userName,password,idNumber,phoneNumber);
        list.add(user);
        System.out.println("用户注册成功");
        printList(list);
    }
    public static void forgotPassword(ArrayList<User22> list) {
        System.out.println("忘记密码");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName;
        String phoneNumber;
        String idNumber;
        User22 user=new User22();
        while(true) {
            userName=sc.next();
            boolean flag1 = contains(list, userName);
            if (flag1) {
                System.out.println("用户名存在");
                Scanner sc1 = new Scanner(System.in);
                Scanner sc2 = new Scanner(System.in);
                System.out.println("请输入身份证号：");
                 idNumber=sc1.next();
                System.out.println("请输入手机号码：");
                phoneNumber=sc2.next();
                int i=getIndex1(list,userName);
                user = list.get(i);
                if(user.getIdNumber().equals(user.getIdNumber())&&user.getPhoneNumber().equals(user.getPhoneNumber())){
                    System.out.println("当前用户身份证号与手机号码一致");
                    break;
                }
                else{
                    System.out.println("当前用户身份证号与手机号码不一致，账号信息不匹配，修改失败！");
                    return;
                }
            }
            else{
                System.out.println("该用户名未注册，请先注册");
                return;
            }
        }
        String newPassword;
        while (true) {
            System.out.println("请输入密码：");
            Scanner sc1 = new Scanner(System.in);
            newPassword = sc1.next();
            System.out.println("请再次输入密码");
            Scanner sc2 = new Scanner(System.in);
            String newPassword1 = sc2.next();
            if (newPassword.equals(newPassword1)) {
                user.setPassword(newPassword);
                System.out.println("密码修改成功");
                return;
            } else {
                System.out.println("两次输入密码不一致，请重新输入密码");
                continue;
            }
        }
    }
    public static boolean checkUserName (ArrayList < User22 > list, String userName){
        int length = userName.length();
        if (length < 3 || length > 15) {
            return false;
        }
        for (int i = 0; i < userName.length(); i++) {
            char ch = userName.charAt(i);
            if (('a' > ch || ch > 'z') && ('A' > ch || ch > 'Z') && ('0' > ch || ch > '9')) {
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < userName.length(); i++) {
            char ch = userName.charAt(i);
            if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {
                count++;
                break;
            }
        }
        return count>0?true:false;
    }
    public static boolean contains(ArrayList<User22> list, String userName) {
        for (int i = 0; i < list.size(); i++) {
            User22 user = list.get(i);
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkIdNumber(ArrayList < User22 > list, String idNumber) {
        int length=idNumber.length();
        if (length !=18) {
            return false;
        }
        if(idNumber.charAt(0)=='0'){
            return false;
        }
        for (int i = 0; i < idNumber.length()-1; i++) {
            char ch = idNumber.charAt(i);
            if (ch<'0' || ch>'9') {
                return false;
            }
        }
        char ch=idNumber.charAt(17);
        if (( '0'>ch || ch > '9') &&ch != 'X' && ch != 'x') {
            return false;
        }
        return true;
    }
    public static boolean checkPhoneNumber(ArrayList < User22 > list, String phoneNumber) {
        int length=phoneNumber.length();
        if(length!=11){
            return false;
        }
        if(phoneNumber.charAt(0)=='0'){
            return false;
        }
        for(int i=0;i<phoneNumber.length();i++){
            char ch = phoneNumber.charAt(i);
            if(ch<'0' || ch>'9') {
                return false;
            }
        }
        return true;
    }
    public static void printList(ArrayList<User22> list) {
        for (int i = 0; i < list.size(); i++) {
            User22 user = list.get(i);
            System.out.println(user.getUserName()+"\t"+user.getPassword()+"\t"+user.getIdNumber()+"\t"+user.getPhoneNumber());
        }
    }
    public static String getCode(){
        //创建一个字母集合，从立马抽取
        ArrayList<Character>list=new ArrayList<>();
        //添加26个大小写字母
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        //StringBuilder 是 Java 中用于高效拼接字符串的一个类,长度是可变的
        StringBuilder code=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<4;i++){
           int index=random.nextInt(list.size());
           code.append(list.get(index));//拼接
        }
        int number=random.nextInt(10);
        int index=random.nextInt(5);
        code.insert(index,number);
        //也可以通过把字符串改成字符数组在数组中修改，然后在创建一个新的字符串，拿着最后一个索引，跟随机索引进行交换
        //code.append(number);
//        char [] arr=code.toString().toCharArray();
//        int randomIndex=random.nextInt(arr.length);
//        char temp =arr[randomIndex];
//        arr[randomIndex]=arr[arr.length-1];
//        arr[arr.length-1]=temp;
//        return new String(arr);
        return code.toString();
    }
    public static boolean confirmUser22(ArrayList<User22> list,User22 user){
        for (int i = 0; i < list.size(); i++) {
            User22 user2 = list.get(i);
            if (user.getPassword().equals(user2.getPassword())&&user.getUserName().equals(user2.getUserName())) {
                return true;
            }
//            else if(user.getIdNumber().equals(user2.getIdNumber())&&user.getPhoneNumber().equals(user2.getPhoneNumber())) {
//                return true;
//            }
        }
        return false;
    }
    public static int getIndex1(ArrayList<User22> list, String userName){
        for (int i = 0; i < list.size(); i++) {
            User22 user2 = list.get(i);
            if (user2.getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }
}
 class User22{
    private String userName;
    private String password;
    private String idNumber;
    private String phoneNumber;
    public User22(){}
    public User22(String userName, String password, String idNumber, String phoneNumber){
        this.userName=userName;
        this.password=password;
        this.idNumber=idNumber;
        this.phoneNumber=phoneNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}