package collections;

import exceptions.EmptyQueueException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyQueue;

import static org.junit.Assert.assertEquals;


public class MyQueueTest {

    private MyQueue<Integer> testingQueue;

    @BeforeMethod
    public void initQueue() {
        testingQueue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        Assert.assertEquals(testingQueue.size(), 3);
        Assert.assertFalse(testingQueue.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testEnqueueNullPointerQueue() {
        testingQueue.enqueue(null);
    }

    @Test
    public void testDequeue() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        Assert.assertEquals(testingQueue.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(testingQueue.size(), 2);
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testDequeueEmptyQueue() {
        testingQueue.dequeue();
    }

    @Test
    public void testPeek() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        assertEquals(testingQueue.peek(), Integer.valueOf(1));

    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testPeekEmptyQueue() {
        testingQueue.peek();
    }

    @Test
    public void testDequeueAll() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        Assert.assertEquals(testingQueue.size(), 3);
        testingQueue.dequeueAll();
        Assert.assertTrue(testingQueue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(testingQueue.isEmpty());
        testingQueue.enqueue(1);
        Assert.assertFalse(testingQueue.isEmpty());
    }

    @Test
    public void testEqualsSameQueue() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        MyQueue<Integer> testingQueue2 = new MyQueue<>();
        testingQueue2.enqueue(1);
        testingQueue2.enqueue(2);
        testingQueue2.enqueue(3);
        Assert.assertTrue(testingQueue.equals(testingQueue2));
    }

    @Test
    public void testEqualsDifferentQueue() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        MyQueue<Integer> testingQueue2 = new MyQueue<>();
        testingQueue2.enqueue(4);
        testingQueue2.enqueue(5);
        testingQueue2.enqueue(6);
        Assert.assertFalse(testingQueue.equals(testingQueue2));
    }

    @Test
    public void testEqualsNull() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        MyQueue<Integer> testingQueue2 = new MyQueue<>();
        Assert.assertFalse(testingQueue.equals(testingQueue2));
    }

    @Test
    public void testToArray() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        Object[] array = testingQueue.toArray();
        assertEquals(array.length, 3);
        assertEquals(array[0], 1);
        assertEquals(array[1], 2);
        assertEquals(array[2], 3);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayWithNullHolder() {
        testingQueue.enqueue(1);
        testingQueue.enqueue(2);
        testingQueue.enqueue(3);
        testingQueue.toArray(null);
    }

    @Test
    public void testIsFull() {
        Assert.assertFalse(testingQueue.isFull());
    }

    @Test
    public void testSize() {
        assert testingQueue.size() == 0;
        testingQueue.enqueue(1);
        assert testingQueue.size() == 1;
        testingQueue.enqueue(2);
        assert testingQueue.size() == 2;
        testingQueue.dequeue();
        assert testingQueue.size() == 1;
        testingQueue.enqueue(3);
        assert testingQueue.size() == 2;
    }
}
