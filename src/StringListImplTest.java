import exceptions.NoItemFoundInArrayException;
import exceptions.OutOfRangeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringListImplTest {


    private StringList stringList;

    @Before
    public void setUp() {
        stringList = new StringListImpl(0);
    }
    @Test
    public void testAddAndGet() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");


        Assert.assertEquals("cherry", stringList.get(2));
    }

    @Test
    public void testAddAtIndex() {
        stringList.add("apple");
        stringList.add("banana");

        stringList.add(1, "cherry");


        Assert.assertEquals("cherry", stringList.get(1));
    }

    @Test
    public void testSet() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        stringList.set(1, "pear");


        Assert.assertEquals("cherry", stringList.get(2));
    }


    @Test
    public void testRemoveByItem() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        stringList.remove("banana");

        Assert.assertEquals("apple", stringList.get(0));
        Assert.assertEquals("cherry", stringList.get(1));
        Assert.assertEquals(2, stringList.size());

        Assert.assertFalse(stringList.contains("banana"));
    }

    @Test
    public void testRemoveByIndex() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        stringList.remove(1);


        Assert.assertEquals(2, stringList.size());
    }

    @Test
    public void testContains() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        Assert.assertTrue(stringList.contains("banana"));
        Assert.assertFalse(stringList.contains("pear"));
    }

    @Test
    public void testIndexOf() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        Assert.assertEquals(1, stringList.indexOf("banana"));
        Assert.assertEquals(-1, stringList.indexOf("pear"));
    }

    @Test
    public void testLastIndexOf() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("banana");

        Assert.assertEquals(3, stringList.lastIndexOf("banana"));
        Assert.assertEquals(-1, stringList.lastIndexOf("pear"));
    }

    @Test
    public void testSize() {
        stringList.add("apple");
        stringList.add("banana");

        Assert.assertEquals(2, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(stringList.isEmpty());

        stringList.add("apple");
        Assert.assertFalse(stringList.isEmpty());
    }

    @Test
    public void testClear() {
        stringList.add("apple");
        stringList.add("banana");

        stringList.clear();

        Assert.assertEquals(0, stringList.size());
        Assert.assertTrue(stringList.isEmpty());
    }
    @Test
    public void testToArray() {

        stringList.add("cherry");

        String[] arr = stringList.toArray();

        Assert.assertArrayEquals(new String[]{"cherry"}, arr);
    }

    @Test
    public void testExtendArray() {
        stringList.add("apple");
        stringList.add("banana");

        int newSize = stringList.extendArray(5);

        Assert.assertEquals(5, newSize);
        Assert.assertEquals(5, stringList.getArr().length);
    }

    @Test
    public void testEquals() {
        StringList otherList = new StringListImpl(0);
        stringList.add("apple");
        stringList.add("banana");
        otherList.add("apple");
        otherList.add("banana");

        Assert.assertTrue(stringList.equals(otherList));
    }
    @Test(expected = OutOfRangeException.class)
    public void testAddAtIndexOutOfRange() {
        stringList.add("apple");

        stringList.add(2, "cherry");
    }

    @Test(expected = NoItemFoundInArrayException.class)
    public void testRemoveByItemItemNotFound() {
        stringList.add("apple");
        stringList.add("banana");

        stringList.remove("cherry");
    }

    @Test(expected = OutOfRangeException.class)
    public void testRemoveByIndexOutOfRange() {
        stringList.add("apple");
        stringList.add("banana");

        stringList.remove(2);
    }

    @Test(expected = OutOfRangeException.class)
    public void testGetOutOfRange() {
        stringList.add("apple");
        stringList.add("banana");
        stringList.get(2);
    }
}
