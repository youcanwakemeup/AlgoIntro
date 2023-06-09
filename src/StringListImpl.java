import exceptions.NoItemFoundInArrayException;
import exceptions.OutOfRangeException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private String[] arr;
    public StringListImpl(int size) {
        this.arr = new String[size];
    }

    @Override
    public Object[] getArr() {
        return arr;
    }
    private void checkIfArgumentIsNull(String item) {
        if (item == null) {
            throw new NullPointerException("Пустое значение");
        }
    }
    @Override
    public String add(String item) {
        checkIfArgumentIsNull(item);
        String[] newArr = new String[arr.length + 1];
        newArr[arr.length] = item;
        arr = newArr;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > arr.length || index < 0) {
            throw new OutOfRangeException("Нет такого индекса");
        }
        checkIfArgumentIsNull(item);
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = item;
        if (newArr.length - (index + 1) >= 0)
            System.arraycopy(arr, index + 1 - 1, newArr, index + 1, newArr.length - (index + 1));
        arr = newArr;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= arr.length || index < 0) {
            throw new OutOfRangeException("Нет такого индекса");
        }
        checkIfArgumentIsNull(item);
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkIfArgumentIsNull(item);
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoItemFoundInArrayException("Не найден такой элемент");
        }

        String[] newArr = new String[arr.length - 1];
        int newArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            newArr[newArrIndex] = arr[i];
            newArrIndex++;
        }
        arr = newArr;
        return item;
    }



    @Override
    public String remove(int index) {
        if (index >= arr.length || index < 0) {
            throw new OutOfRangeException("Нет такого индекса");
        }
        String[] newArr = new String[arr.length - 1];
        String removedElem = arr[index];
        for (int i = 0; i < newArr.length; i++) {
            if (i != index) {
                newArr[i] = arr[i];
            }
        }
        arr = newArr;
        return removedElem;
    }

    @Override
    public boolean contains(String item) {
        checkIfArgumentIsNull(item);
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoItemFoundInArrayException("Не найден такой элемент");
        }
        for (String str : this.arr) {
            if (Objects.equals(str, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkIfArgumentIsNull(item);
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoItemFoundInArrayException("Не найден такой элемент");
        }
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(this.arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkIfArgumentIsNull(item);
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoItemFoundInArrayException("Не найден такой элемент");
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Objects.equals(this.arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= arr.length || index < 0) {
            throw new OutOfRangeException("Нет такого индекса");
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(arr, otherList.getArr());
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        return arr.length == 0;
    }

    @Override
    public void clear() {
        arr = new String[0];
    }

    @Override
    public String[] toArray() {
        String[] newArr = new String[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        return arr;
    }

    @Override
    public int extendArray(int newSize) {
        String[] newArr = new String[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        return newSize;
    }
}
