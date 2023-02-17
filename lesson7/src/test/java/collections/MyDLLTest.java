package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyDLL;


public class MyDLLTest {
    private MyDLL<Integer> testingDLL;

    @BeforeMethod
    public void initDLL() {
        testingDLL = new MyDLL<>();
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(testingDLL.isEmpty());
        testingDLL.add(1);
        Assert.assertFalse(testingDLL.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayWithNullArgument() {
        testingDLL.toArray(null);
    }

    @Test
    public void testToArrayWithEmptyList() {
        Integer[] array = new Integer[0];
        Integer[] result = testingDLL.toArray(array);
        assert result.length == 0;
    }

    @Test
    public void testToArrayWithOneElement() {
        testingDLL.add(1);
        Integer[] array = new Integer[1];
        Integer[] result = testingDLL.toArray(array);
        assert result.length == 1;
        assert result[0] == 1;
    }

    @Test
    public void testToArrayWithMultipleElements() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Integer[] array = new Integer[3];
        Integer[] result = testingDLL.toArray(array);
        assert result.length == 3;
        assert result[0] == 1;
        assert result[1] == 2;
        assert result[2] == 3;
    }

    @Test
    public void testContains() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Assert.assertTrue(testingDLL.contains(2));
        Assert.assertFalse(testingDLL.contains(4));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testContainsWithNullElement() {
        testingDLL.contains(null);
    }

    @Test
    public void testToArrayWithEmptyObject() {
        Object[] result = testingDLL.toArray();
        Assert.assertEquals(result.length, 0);
    }

    @Test
    public void testToArrayWithNonEmptyObject() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Object[] result = testingDLL.toArray();
        Assert.assertEquals(result.length, 3);
        Assert.assertEquals(result[0], 1);
        Assert.assertEquals(result[1], 2);
        Assert.assertEquals(result[2], 3);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddNullElement() {
        testingDLL.add(null);
    }

    @Test
    public void testAdd() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Assert.assertEquals(testingDLL.size(), 3);
        Assert.assertEquals(testingDLL.get(2), Integer.valueOf(3));

    }

    @Test
    public void testAddAll() {
        MyDLL<Integer> list = new MyDLL<>();
        MyDLL<Integer> toAdd = new MyDLL<>();
        toAdd.add(1);
        toAdd.add(2);
        boolean result = list.addAll(toAdd);
        Assert.assertTrue(result);
        Object[] expected = toAdd.toArray();
        Object[] actual = list.toArray();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddAllWithNull() {
        testingDLL.addAll(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testRemoveNull() {
        testingDLL.remove(null);
    }

    @Test
    public void testRemove() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        int removed = testingDLL.remove(1);
        Assert.assertEquals(removed, 2);
        Assert.assertEquals(testingDLL.size(), 2);
        Assert.assertFalse(testingDLL.contains(2));
    }

    @Test
    public void testClear() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        testingDLL.clear();
        Assert.assertTrue(testingDLL.isEmpty());
        Assert.assertEquals(testingDLL.size(), 0);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(testingDLL.size(), 0);
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Assert.assertEquals(testingDLL.size(), 3);
        testingDLL.remove(2);
        Assert.assertEquals(testingDLL.size(), 2);
    }

    @Test
    public void testAddAtIndex() {
        testingDLL.add(1);
        testingDLL.add(3);
        testingDLL.add(4);
        testingDLL.add(1, 2);
        Assert.assertEquals(testingDLL.size(), 4);
        Assert.assertEquals((int) testingDLL.get(0), 1);
        Assert.assertEquals((int) testingDLL.get(1), 2);
        Assert.assertEquals((int) testingDLL.get(2), 3);
        Assert.assertEquals((int) testingDLL.get(3), 4);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddNullElementIndex() {
        testingDLL.add(0, null);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddInvalidIndex() {
        testingDLL.add(1, 2);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsException() {
        testingDLL.get(0);
        testingDLL.get(-1);
        testingDLL.add(1);
        testingDLL.get(1);
    }

    @Test
    public void testGet() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        Assert.assertEquals(testingDLL.get(0), (Integer) 1);
        Assert.assertEquals(testingDLL.get(1), (Integer) 2);
        Assert.assertEquals(testingDLL.get(2), (Integer) 3);

    }

    @Test
    public void testRemoveAtIndex() {
        testingDLL.add(1);
        testingDLL.add(2);
        testingDLL.add(3);
        testingDLL.add(4);
        int removedValue = testingDLL.remove(2);
        Assert.assertEquals(testingDLL.size(), 3);
        Assert.assertEquals(removedValue, 3);
        Assert.assertEquals((int) testingDLL.get(0), 1);
        Assert.assertEquals((int) testingDLL.get(1), 2);
        Assert.assertEquals((int) testingDLL.get(2), 4);

    }
    @Test
    public void testSet() {
        testingDLL.add(0);
        testingDLL.add(1);
        testingDLL.add(2);
        int oldValue = testingDLL.set(0, 10);
        Assert.assertEquals(oldValue, 0);
        Assert.assertEquals(testingDLL.get(0), (Integer) 10);
        oldValue = testingDLL.set(1, 20);
        Assert.assertEquals(oldValue, 1);
        Assert.assertEquals(testingDLL.get(1), (Integer) 20);
        oldValue = testingDLL.set(2, 30);
        Assert.assertEquals(oldValue, 2);
        Assert.assertEquals(testingDLL.get(2), (Integer) 30);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingDLL.set(3, 40));
        Assert.assertThrows(NullPointerException.class, () -> testingDLL.set(0, null));
    }
}

