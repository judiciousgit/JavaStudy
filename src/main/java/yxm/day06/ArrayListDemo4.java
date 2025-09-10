package yxm.day06;
/*main方法定义一个集合，存入三个用户对象。定义一个方法，根据
id查找对应的与用户信息，如果存在，返回true，如果不存在返回false*/
import java.util.ArrayList;
class arraylistdemo4 {
    public static void main(String[] args){
     ArrayList<user> list=new ArrayList<>();
     user u1=new user(23025001,"zhangsan","123456");
     user u2=new user(23025002,"lisi","123456");
     user u3=new user(23025003,"wangwu","123456");
     list.add(u1);
     list.add(u2);
     list.add(u3);
     //不用定义方法的方式
//     Scanner sc=new Scanner(System.in);
//     System.out.print("请输入用户的id:");
//     int count=0;
//     for(int i=0;i<list.size();i++){
//         int x=sc.nextInt();
//         if(x==list.get(i).getId()){
//             System.out.println("true");
//             break;
//         }
//         else{
//             count++;
//             if(count==list.size()){
//                 System.out.println("false");
//             }
//         }
//   }
          Boolean flag=contains(list,23025001);
          System.out.println(flag);
          int index=getIndex(list,23025001);
          System.out.println(index);

    }
    //return 会直接结束整个方法，不再继续循环。
    public static  boolean contains(ArrayList<user> list, int id){
        for(int i=0;i<list.size();i++){
            int uid=list.get(i).getId();
            if(uid==id){
                return true;
            }
        }
        return false;
    }
    //存在返回索引，不存在返回-1
    public static  int getIndex(ArrayList<user> list, int id){
        for(int i=0;i<list.size();i++){
            int uid=list.get(i).getId();
            if(uid==id){
                return i;
            }
        }
        return -1;
    }
}

 class user{
    int id;
    String username;
    String password;
    public user(){}
    public user(int id,String username,String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
