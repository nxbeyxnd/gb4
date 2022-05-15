package ru.alexey.task2;
/* 
30.04.2022: Alexey created this file inside the package: ru.alexey.task2 
*/


import ru.alexey.task2.arrayListImpl.ArrayListImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayListImpl<String> arrayList = new ArrayListImpl();
        List<String> arrayList2 = new ArrayListImpl();




        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");
        arrayList.add("Test6");
        arrayList.add("Test7");
        arrayList.add("Test8");
        arrayList.add("Test");
        arrayList.add(null);

        arrayList.remove(null);
        System.out.println(arrayList);

    }
}
