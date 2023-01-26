package org.mcs.algoritm;

import java.util.HashSet;

public class SimpleHashSet {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        hashSet.add(2);
        hashSet.add(6);
        hashSet.add(10);
        System.out.println(hashSet);
    }
}
