package yxm.day06;
import java.util.ArrayList;
//本练习主要是为了练习基本数据类型对应的包装类，其中要注意的是char --Character;int--Integer,其他的都是首字母变成大写就可以了
public class ArrayListDemo2 {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Character> list1=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list1.add('a');
        list1.add('b');
        list1.add('c');
        System.out.print("[");
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){
                System.out.print(list.get(i));
            }
            else{
                System.out.print(list.get(i)+",");
            }
        }
        System.out.println("]");
        System.out.print("[");
        for(int i=0;i<list1.size();i++){
            if(i==list1.size()-1){
                System.out.print(list1.get(i));
            }
            else{
                System.out.print(list1.get(i)+",");
            }
        }
        System.out.println("]");
    }
}
