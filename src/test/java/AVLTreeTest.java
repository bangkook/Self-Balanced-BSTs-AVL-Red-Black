import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class AVLTreeTest {
    @Test
    public void InsertTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("hello");
        tree.insert("this");
        tree.insert("is");
        tree.insert("test");
        tree.traverse(tree.getRoot());
        ArrayList<String> InorderTraversal = tree.inorder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("hello");
        expected.add("is");
        expected.add("test");
        expected.add("this");
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());

    }

    @Test
    public void testInsertDuplicate() {
        AVLTree<Integer> tree = new AVLTree<>();
        Assert.assertTrue(tree.insert(10));
        Assert.assertTrue(tree.insert(18));
        Assert.assertTrue(tree.insert(20));
        Assert.assertFalse(tree.insert(10));
        Assert.assertFalse(tree.insert(20));
        ArrayList<Integer> InorderTraversal = tree.inorder();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(18);
        expected.add(20);
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
        Assert.assertEquals(3, tree.size());
    }

    @Test
    public void deleteRootTwoChileTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("musicological");
        tree.insert("forepast");
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("excommunicating");
        tree.insert("music");
        tree.insert("love");
        tree.insert("institutional");
        tree.insert("forever");
        tree.insert("zoo");
        tree.traverse(tree.getRoot());
        tree.delete("institutional");//delete root with two child
        System.out.println("--------------------");
        tree.traverse(tree.getRoot());
        ArrayList<String> InorderTraversal = tree.inorder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("excommunicating");
        expected.add("forepast");
        expected.add("forever");
        expected.add("love");
        expected.add("music");
        expected.add("musicological");
        expected.add("zoo");
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
    }

    @Test
    public void deleteRootOneChildTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("musicological");
        tree.insert("forepast");
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("excommunicating");
        tree.insert("music");
        tree.insert("love");
        tree.insert("institutional");
        tree.insert("forever");
        tree.insert("zoo");
        tree.traverse(tree.getRoot());
        tree.delete("musicological");//delete root with one child
        System.out.println("--------------------");
        tree.traverse(tree.getRoot());
        ArrayList<String> InorderTraversal = tree.inorder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("excommunicating");
        expected.add("forepast");
        expected.add("forever");
        expected.add("institutional");
        expected.add("love");
        expected.add("music");
        expected.add("zoo");
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
    }

    @Test
    public void deleteChildTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("musicological");
        tree.insert("forepast");
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("excommunicating");
        tree.insert("music");
        tree.insert("love");
        tree.insert("institutional");
        tree.insert("forever");
        tree.insert("zoo");
        tree.traverse(tree.getRoot());
        tree.delete("apple");//leave deletion
        System.out.println("--------------------");
        tree.traverse(tree.getRoot());
        ArrayList<String> InorderTraversal = tree.inorder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("excommunicating");
        expected.add("forepast");
        expected.add("forever");
        expected.add("institutional");
        expected.add("love");
        expected.add("music");
        expected.add("musicological");
        expected.add("zoo");
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
    }

    @Test
    public void testHeight() {
        AVLTree<String> tree = new AVLTree<>();
        Assert.assertEquals(0, tree.height());
        tree.insert("alone");
        Assert.assertEquals(1, tree.height());
        tree.insert("Alone");
        Assert.assertEquals(2, tree.height());
        tree.insert("aLone");
        Assert.assertEquals(2, tree.height());
        tree.insert("Ballone");
        Assert.assertEquals(3, tree.height());
    }

    @Test
    public void DeleteInsertTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("musicological");
        tree.insert("forepast");
        tree.insert("apple");
        tree.insert("banana");
        tree.insert("excommunicating");
        tree.insert("music");
        tree.insert("love");
        tree.insert("institutional");
        tree.insert("forever");
        tree.insert("zoo");
        tree.traverse(tree.getRoot());
        tree.delete("music");//delete root with two child
        System.out.println("--------------------");
        tree.traverse(tree.getRoot());
        tree.insert("good");
        System.out.println("--------------------");
        tree.traverse(tree.getRoot());
        ArrayList<String> InorderTraversal = tree.inorder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("excommunicating");
        expected.add("forepast");
        expected.add("forever");
        expected.add("good");
        expected.add("institutional");
        expected.add("love");
        expected.add("musicological");
        expected.add("zoo");
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
    }

    @Test
    public void SizeTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(10);
        tree.insert(18);
        tree.insert(7);
        tree.insert(15);
        tree.insert(16);
        Assert.assertEquals(5, tree.size());
    }

    @Test
    public void EmptyTest() {
        AVLTree<String> tree = new AVLTree<>();
        Assert.assertEquals(0, tree.height());
        Assert.assertEquals(0, tree.size());
    }

    @Test
    public void SearchTest() {
        AVLTree<String> tree = new AVLTree<>();
        tree.insert("Hello");
        tree.insert("I");
        tree.insert("am");
        tree.insert("a");
        tree.insert("CSED");
        tree.insert("student");

        boolean case1 = tree.search("hello");
        Assert.assertFalse(case1);

        boolean case2 = tree.search("Hello");
        Assert.assertTrue(case2);

        boolean case3 = tree.search("Hi");
        Assert.assertFalse(case3);
    }

    @Test
    public void searchDeletedElementTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.delete(4);
        boolean case1 = tree.search(4);
        Assert.assertFalse(case1);
    }

    @Test
    public void traversalTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        ArrayList<Integer> InorderTraversal = tree.inorder();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertArrayEquals(expected.toArray(), InorderTraversal.toArray());
    }
}
