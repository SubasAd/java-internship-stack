package org.subasadhikari;


import org.subasadhikari.binaryTree.BinaryTree;

import java.util.Comparator;

class Main{
    public static void main(String[] args) throws Exception {

        BinaryTree <Integer>bt = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if(integer.intValue() < t1.intValue()) return -1;
                if(integer.intValue()>t1.intValue()) return 1;
                return 0;
            }
        });
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(8);
        bt.insert(3);
        bt.search(8);
        System.out.println(bt.orderTraverse(0));
        System.out.println(bt.orderTraverse(1));
        System.out.println(bt.orderTraverse(2));



    }
}