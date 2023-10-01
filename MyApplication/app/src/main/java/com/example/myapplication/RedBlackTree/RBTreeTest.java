package com.example.myapplication.RedBlackTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {
    RBTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new RBTree<>();
        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
    }

    @Test(timeout=1000)
    public void testInsert() {
        Assert.assertEquals("7 5 9", tree.preOrder());
    }

    @Test(timeout=1000)
    public void testInsertDuplicate() {
        tree.insert(9);
        Assert.assertEquals("7 5 9", tree.preOrder());
    }

    @Test(timeout=1000)
    public void testNodeRed() {
        Assert.assertSame(tree.search(9).colour, Colour.RED);
    }

    @Test(timeout=1000)
    public void testInsertNewNode() {
        tree.insert(12);
        Assert.assertEquals("7 5 9 12", tree.preOrder());
    }

    @Test(timeout=1000)
    public void testNodeRedToBlack() {
        tree.insert(12);
        Assert.assertTrue(tree.search(5).colour == Colour.BLACK && tree.search(9).colour == Colour.BLACK);
    }

    @Test(timeout=1000)
    public void testInsertNewNodeRed() {
        tree.insert(12);
        Assert.assertSame(tree.search(12).colour, Colour.RED);
    }

    @Test(timeout=1000)
    public void testInsertNewNodeNoColourChange() {
        tree.insert(12);
        tree.insert(8);
        Assert.assertTrue(tree.search(5).colour == Colour.BLACK
                && tree.search(9).colour == Colour.BLACK
                && tree.search(8).colour == Colour.RED
                && tree.search(12).colour == Colour.RED);
    }


    @Test(timeout=1000)
    public void testInsertRotateRight() {
        tree.insert(12);
        tree.insert(8);
        tree.insert(11);
        tree.insert(10);

        Assert.assertEquals("7 5 9 8 11 10 12", tree.preOrder());
    }

    @Test(timeout=1000)
    public void testInsertRotateRightRightLeft() {
        tree.insert(12);
        tree.insert(11);

        Assert.assertEquals("7 5 11 9 12", tree.preOrder());
    }

    @Test(timeout=1000)
    public void testSearch1() {
        Assert.assertEquals(7, (int) tree.search(7).key);
    }

    @Test(timeout=1000)
    public void testSearch2() {
        Assert.assertEquals(5, (int) tree.search(5).key);
    }

    @Test(timeout=1000)
    public void testSearch3() {
        Assert.assertNull(tree.search(-3));
    }

    @Test(timeout=1000)
    public void testSearch4() {
        Assert.assertNull(tree.search(26));
    }
}
