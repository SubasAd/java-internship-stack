package org.subasadhikari.binaryTree;
import java.util.Comparator;
import java.util.LinkedList;

public class BinaryTree<T> {
    /**
     *
     * @param <E>
     */
    private class Node<E>  {
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E data;
    }
    Node<T> Root ;
    Comparator<T> compare;

    /**
     *
     * @param  comparator for the data type
     */
    public BinaryTree(Comparator<T> comparator) {
        this.compare = comparator;

    }

    /**
     * Insert the data in binary tree
     * @param data any object to be inserted
     * @return true if data is inserted
     */
    public boolean insert(T data) throws SameKeyException {
        if(Root == null){
            Root = new Node<>();
            Root.data = data;
            return true;
        }
        if(this.search(data))
        {

                throw new SameKeyException("The key has been already inserted");

        }
        Node<T> iterator = Root;
        while(true){
            if((this.compare.compare(data, iterator.data) ==-1)){
                if(iterator.left ==null){
                    iterator.left = new Node<T>();
                    iterator.left.parent = iterator;
                    iterator = iterator.left;
                    iterator.data = data;
                    return true;
                }else{
                    iterator = iterator.left;
                }

            }
            if((this.compare.compare(data, iterator.data) >=0)){
                if(iterator.right ==null){
                    iterator.right = new Node<T>();
                    iterator.right.parent = iterator;
                    iterator = iterator.right;
                    iterator.data = data;
                    return true;
                }else{
                    iterator = iterator.right;
                }

            }
        }

    }

    /**
     *
     * @param data to be searched
     * @return true if data is present in the binary tree
     */
    public boolean search(T data){
        Node<T> node = searchRecursive(data,this.Root);
        return node != null;
    }

    /**
     * It does inorder traversing if input is 0, preorder if input is 1,otherwise does post order
     * @param x denominator for traversing
     * @return LinkedList of the data of the nodes traversed
     */
    public  LinkedList<T>orderTraverse(int x)
    {
            LinkedList<T> output = new LinkedList<>();
            if(x ==0) inorderTraverse(this.Root,output);
            else if(x==1) preorderTraverse(this.Root,output);
            else postorderTraverse(this.Root,output);
            return output;
    }
    private Node searchRecursive(T data,Node<T>iterator){
        if(iterator == null) return null;
        if(this.compare.compare(iterator.data,data)==0) return iterator;
        if(this.compare.compare(iterator.data,data)==1) return searchRecursive(data,iterator.left);
        if(this.compare.compare(iterator.data,data)==-1) return searchRecursive(data,iterator.right);
        return null;
    }
    private void inorderTraverse(Node<T> iterator, LinkedList<T> list){
        if(iterator ==null) return;
        inorderTraverse(iterator.left,list);
        list.add(iterator.data);
        inorderTraverse(iterator.right,list);
    }
    private void preorderTraverse(Node<T> iterator, LinkedList<T> list){
        if(iterator ==null) return;
        list.add(iterator.data);
        preorderTraverse(iterator.left,list);
        preorderTraverse(iterator.right,list);
    }
    private void postorderTraverse(Node<T> iterator, LinkedList<T> list){
        if(iterator ==null) return;
        postorderTraverse(iterator.left,list);
        postorderTraverse(iterator.right,list);
        list.add(iterator.data);
    }

}
