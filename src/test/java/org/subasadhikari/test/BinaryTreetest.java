package org.subasadhikari.test;
import org.junit.Test;
import org.subasadhikari.binaryTree.BinaryTree;
import org.subasadhikari.binaryTree.SameKeyException;
import org.junit.function.ThrowingRunnable;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class BinaryTreetest {
    @Test
   public void testInsertionAndSearch() throws SameKeyException {
        // Creating a binary tree of integers
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if(integer < t1) return -1;
                if(integer > t1) return 1;
                return 0;
            }
        });

        // Inserting elements
        assertTrue(binaryTree.insert(10));
        assertTrue(binaryTree.insert(5));
        assertTrue(binaryTree.insert(15));
        assertTrue(binaryTree.insert(3));

        // Searching for existing and non-existing elements
        assertTrue(binaryTree.search(10));
        assertTrue(binaryTree.search(5));
        assertTrue(binaryTree.search(15));
        assertTrue(binaryTree.search(3));
        assertFalse(binaryTree.search(8));

        // Inserting a new element
        assertTrue(binaryTree.insert(8));

        // Searching for the newly inserted element
        assertTrue(binaryTree.search(8));
    }

    @Test
    public void testTraversal() throws SameKeyException {
        // Creating a binary tree of integers
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        });

        // Inserting elements
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(8);

        // Inorder traversal: 3 -> 5 -> 8 -> 10 -> 15
        LinkedList<Integer> inorderList = binaryTree.orderTraverse(0);
        assertEquals(5, inorderList.size());
        assertEquals(3, (int) inorderList.get(0));
        assertEquals(5, (int) inorderList.get(1));
        assertEquals(8, (int) inorderList.get(2));
        assertEquals(10, (int) inorderList.get(3));
        assertEquals(15, (int) inorderList.get(4));

        // Preorder traversal: 10 -> 5 -> 3 -> 8 -> 15
        LinkedList<Integer> preorderList = binaryTree.orderTraverse(1);
        assertEquals(5, preorderList.size());
        assertEquals(10, (int) preorderList.get(0));
        assertEquals(5, (int) preorderList.get(1));
        assertEquals(3, (int) preorderList.get(2));
        assertEquals(8, (int) preorderList.get(3));
        assertEquals(15, (int) preorderList.get(4));

        // Postorder traversal: 3 -> 8 -> 5 -> 15 -> 10
        LinkedList<Integer> postorderList = binaryTree.orderTraverse(2);
        assertEquals(5, postorderList.size());
        assertEquals(3, (int) postorderList.get(0));
        assertEquals(8, (int) postorderList.get(1));
        assertEquals(5, (int) postorderList.get(2));
        assertEquals(15, (int) postorderList.get(3));
        assertEquals(10, (int) postorderList.get(4));
    }
    @Test
    public void testInsertionAndSearchWithException() throws SameKeyException {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if(integer < t1) return -1;
                if(integer > t1) return 1;
                return 0;
            }
        });
        assertTrue(binaryTree.insert(5));
        assertTrue(binaryTree.insert(10));


        Exception exception = assertThrows(SameKeyException.class,()-> binaryTree.insert(5));
        assertEquals("The key has been already inserted",exception.getMessage());

    }

}

