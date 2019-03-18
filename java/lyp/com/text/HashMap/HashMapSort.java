package lyp.com.text.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSort {
    public static void main(String args[]){
        HashMap<Integer,User> hashMap = new HashMap<>();

        User user = new User();
        user.setName("张三");
        user.setAge(21);

        hashMap.put(1,user);

        User user2 = new User();
        user2.setName("李四");
        user2.setAge(24);

        hashMap.put(2,user2);

        User user3 = new User();
        user3.setName("王五");
        user3.setAge(23);

        hashMap.put(3,user3);

        System.out.println("排序前"+hashMap);
        HashMap<Integer,User> sortHashMap = sortHashMap(hashMap);
        System.out.println("排序后"+sortHashMap);
    }
        //根据hashmap中user的age属性的倒序排序 并保持 key_value 结构
    private static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> hashMap) {
        //通过hashmap的有序子类 来进行排序  linkedHashMap 是链表的有序结构
        //创建一个有序的hashmap的数据结构
        LinkedHashMap<Integer,User> newHashMap = new LinkedHashMap<>();

        //凡是要对集合的排序首先想到的是集合的工具类进行排序
        //将map的数据结构转换成list结构
        // 把hashmap的键值对拿出来 转到集合里面
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        //把set集合转成list集合
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        //参2 比较器
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //默认排序o1 -o2;
                //反序
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        //将排好序的list转换成linkHashMap  set->list 转换不可逆
        //遍历取出来 放到linkHashMap中
        for (int i =0; i< list.size();i++){
            Map.Entry<Integer, User> entry = list.get(i);
            newHashMap.put(entry.getKey(),entry.getValue());
        }

        return newHashMap;
    }

}
