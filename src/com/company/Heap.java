package com.company;
import java.util.ArrayList;

/**
 * Created by HuangXiang on 1/18/16.
 */
public class Heap <K extends Comparable>{
    private ArrayList<K> storage;
    private int size;

    public Heap(){
        storage = new ArrayList<K>();
        storage.add(null);
        size = 0;
    }

    public Heap(K[] array){
        storage = new ArrayList<K>(array.length + 1);
        storage.add(null); // The first is like a sentinel node
        size = 0;
        for (K element : array){
            this.add(element);
        }
    }

    public K peek(){
        return storage.get(1);
    }

    private void swap(int loc1, int loc2){
        K tmp = storage.get(loc1);
        storage.set(loc1, storage.get(loc2));
        storage.set(loc2, tmp);
    }

    public K pop(){
        int i = 1;
        K val = storage.get(i);
        storage.set(i, storage.get(size));
        this.size --;
        while (i <= size / 2) {
            K current = storage.get(i);
            K left = storage.get(i * 2);
            K right = (i * 2 + 1) <= size?storage.get(i * 2 + 1):current;
            if (current.compareTo(left) <= 0 && current.compareTo(right) <= 0) break;
            if (left.compareTo(right) > 0) {
                swap (i, i * 2 + 1);
                i = i * 2 + 1;
            }else{
                swap (i, i * 2);
                i = i * 2;
            }
        }
        return val;
    }

    public int size(){
        return size;
    }

    public void add(K ele){
        this.storage.add(ele);
        this.size ++;
        int startloc = this.size;
        int parent = startloc / 2;
        if (parent > 0){
            while (storage.get(startloc).compareTo(storage.get(parent)) < 0 ){
                swap (startloc, parent);
                startloc = parent;
                parent = startloc / 2;
                if (parent == 0) break;
            }
        }
    }


    public void print(){
        for (int i = 1; i < storage.size(); i++){
            System.out.println(storage.get(i).toString());
        }
    }

    public static void main(String[] args) {
        Integer[] trial = {2,6,4,1,2,5,3,0,7,-1};
        Heap<Integer> h = new Heap(trial);
        h.print();
        System.out.println("Getting everything");
        while (h.size > 0){
            System.out.println(h.pop());
        }
    }


}
