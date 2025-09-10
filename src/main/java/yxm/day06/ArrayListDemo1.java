package yxm.day06;

import java.util.ArrayList;
public class ArrayListDemo1 {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<String> list =new ArrayList<>();
        //添加元素
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        //删除元素有两种方式其中有直接打出要删除的元素（删除正确与否通过boolean来反映出来）、通过索引进行删除
        boolean result1=list.remove("ccc");
        System.out.println(result1);
        boolean result2=list.remove("ddd");
        System.out.println(result2);
        String str=list.remove(0);
        System.out.println(str);
        //修改元素
        String str1=list.set(0,"ddd");
        System.out.println(str1);//str1是被覆盖的元素
        //查询元素
        String str2=list.get(0);
        System.out.println(str2);
        //遍历
        for(int i=0;i<list.size();i++){//注意这里是size不是length
            String str3=list.get(i);//元素
            System.out.print(str3);
        }
    }
}
