package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyArrayList;
import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }

    @Test
    public void testAdd() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        boolean added = testingArray.add(4);
        Assert.assertTrue(added);
        Assert.assertEquals(testingArray.get(3), Integer.valueOf(4));
    }

    @Test
    public void testAddAll() {
        List<Integer> myList = new ArrayList<>();
        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(1);
        toAdd.add(2);
        toAdd.add(3);
        boolean added = myList.addAll(toAdd);
        Assert.assertTrue(added);
        Assert.assertEquals(myList.size(), 3);
        Assert.assertEquals(myList.get(0), Integer.valueOf(1));
        Assert.assertEquals(myList.get(1), Integer.valueOf(2));
        Assert.assertEquals(myList.get(2), Integer.valueOf(3));
    }

    @Test
    public void testGet() {
        testingArray.add(1);
        testingArray.add(2);
        Assert.assertEquals(testingArray.get(0), Integer.valueOf(1));
        Assert.assertEquals(testingArray.get(1), Integer.valueOf(2));
    }

    @Test
    public void testRemoveIndex() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        Assert.assertEquals(testingArray.remove(1), Integer.valueOf(2));
        Assert.assertEquals(testingArray.size(), 2);
        Assert.assertEquals(testingArray.get(0), Integer.valueOf(1));
        Assert.assertEquals(testingArray.get(1), Integer.valueOf(3));
    }

    @Test
    public void testRemoveElement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.remove("second");
        Assert.assertEquals(2, list.size());
        Assert.assertFalse(list.contains("second"));

    }

    @Test
    public void testSet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String oldValue = list.set(1, "4");
        Assert.assertEquals(oldValue, "2");
        Assert.assertEquals(list.get(1), "4");

    }

    @Test
    public void testIsEmptyWithEmptyList() {

        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test
    public void testContains() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        Assert.assertTrue(list.contains("second"));
        Assert.assertFalse(list.contains("third"));
        Assert.assertFalse(list.contains(null));
    }

    @Test
    public void testToArray() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        Integer[] array = new Integer[3];
        Assert.assertEquals(testingArray.toArray(array), array);
    }

}
