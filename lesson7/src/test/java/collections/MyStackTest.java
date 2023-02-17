package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyStack;

public class MyStackTest {

    private MyStack<Integer> testingStack;

    @BeforeMethod
    public void initStack() {
        testingStack = new MyStack<>();
    }


    @Test
    public void testPush() {
        testingStack.push(6);
        Assert.assertEquals(testingStack.size(), 1);
    }
    @Test
    public void testPop() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertEquals(testingStack.pop(), Integer.valueOf(3));
        Assert.assertEquals(testingStack.size(), 2);
    }

    @Test
    public void testPeek() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertEquals(testingStack.peek(), Integer.valueOf(3));

    }
        @Test
        public void testClear() {
            testingStack.push(1);
            testingStack.push(2);
            testingStack.push(3);
            testingStack.clear();
            Assert.assertTrue(testingStack.isEmpty());
        }
        @Test
    public void testIsEmpty (){
            testingStack.clear();
            Assert.assertTrue(testingStack.isEmpty());
            Assert.assertEquals(testingStack.size(), 0);
        }
    @Test
    public void testToArray() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Object[] expected = {3, 2, 1};
        Assert.assertEquals(testingStack.toArray(), expected);
    }
    @Test
    public void testContains() {
        testingStack.push(1);
        testingStack.push(2);
        Assert.assertTrue(testingStack.contains(2));
        Assert.assertFalse(testingStack.contains(3));
    }
    @Test
    public void testSearch() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertEquals(testingStack.search(2), 2);
        Assert.assertEquals(testingStack.search(4), -1);
    }
    @Test
    public void testEquals() {
        testingStack.push(1);
        testingStack.push(2);
        MyStack<Integer> stack2 = new MyStack<>();
        stack2.push(1);
        stack2.push(2);
        Assert.assertTrue(testingStack.equals(stack2));
    }
    @Test
    public void testSize() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertEquals(testingStack.size(), 3);
    }



}
