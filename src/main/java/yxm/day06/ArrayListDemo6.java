package yxm.day06;
import java.util.ArrayList;
public class ArrayListDemo6 {
    public static void main(String[] args) {
        ArrayList<Phoness> list = new ArrayList<>();
        Phoness p1 = new Phoness("小米", 1000);
        Phoness p2 = new Phoness("苹果", 8000);
        Phoness p3 = new Phoness("锤子", 2999);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ArrayList<Phoness> phonessInfoList = getPhonessInfo(list);
        for (Phoness p : phonessInfoList) {
            System.out.println(p.getName()+p.getPrice());
        }
    }
    public static ArrayList<Phoness> getPhonessInfo(ArrayList<Phoness> list){
        ArrayList<Phoness> resultList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Phoness p=list.get(i);
            if(p.getPrice()<3000){
                resultList.add(p);
            }
        }
        return resultList;
    }
}
class Phoness{
    String name;
    double price;
    public Phoness(){};
    public Phoness(String name,double price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
