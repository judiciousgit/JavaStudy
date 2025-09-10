package yxm.day06;

import java.util.ArrayList;
//如果你既想知道它存不存在又想知道它的索引
public class ArrayListDemo5 {
    public static void main(String[] args) {
        ArrayList<user> list = new ArrayList<>();
        user u1=new user(23025001,"zhangsan","123456");
        user u2=new user(23025002,"lisi","123456");
        user u3=new user(23025003,"wangwu","123456");
        list.add(u1);
        list.add(u2);
        list.add(u3);

        Boolean flag = contains(list, 23025001);
        System.out.println(flag);
    }
        public static int getIndex (ArrayList < user > list,int id){
            for (int i = 0; i < list.size(); i++) {
                int uid = list.get(i).getId();
                if (uid == id) {
                    return i;
                }
            }
            return -1;
        }
        public static boolean contains (ArrayList < user > list,int id){
            return getIndex(list, id) >= 0;
        }

}