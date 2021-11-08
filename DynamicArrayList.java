import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayList<AnyType> implements List<AnyType>
{
  private static final int DEFAULT_CAPACITY = 2;

  private int theSize;
  private AnyType [] data;

  public DynamicArrayList()
  {
    this(DEFAULT_CAPACITY);
  }

  public DynamicArrayList(int capacity)
  {
    theSize = 0;
    data = (AnyType[]) new Object[capacity];
  }

  public void clear()
  {
    int n = size();

    for (int i=0; i < n; i++) data[i] = null;
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }

  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException
  {
    if (i < 0 || i >= n)
      throw new IndexOutOfBoundsException("Illegal index: " + i);
  }

  public AnyType get(int index)
  {
    checkIndex(index, size());
    return data[index];
  }

  public AnyType set(int index, AnyType newValue)
  {
    checkIndex(index, size());
    AnyType oldValue = data[index];
    data[index] = newValue;
    return oldValue;
  }

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }

  protected void resize(int newCapacity)
  {
    int n = size();

    AnyType[] temp = (AnyType[]) new Object[newCapacity];
    for (int i=0; i < n; i++) temp[i] = data[i];
    data = temp;
  }

  public void add(int index, AnyType newValue) throws IndexOutOfBoundsException
  {
    int n = size();

    checkIndex(index, n+1);
    if (n == data.length) resize(2 * data.length);
    for (int i=n-1; i >= index; i--) data[i+1] = data[i];
    data[index] = newValue;
    theSize++;
  }

  public AnyType remove(int index) throws IndexOutOfBoundsException
  {
    int n = size();

    checkIndex(index, n);
    if (n <= (data.length / 4)) resize(data.length / 2);
    AnyType oldValue = data[index];
    for (int i=index; i < n-1; i++) data[i] = data[i+1];
    data[n-1] = null;
    theSize--;
    return oldValue;
  }

  public Iterator<AnyType> iterator()
  {
    return new ArrayListIterator();
  }

  private class ArrayListIterator implements Iterator<AnyType>
  {
    private int cursor;

    public ArrayListIterator()
    {
      cursor = 0;
    }

    public boolean hasNext()
    {
      return (cursor < size());
    }

    public AnyType next()
    {
      if (!hasNext())
        throw new NoSuchElementException();

      return DynamicArrayList.this.get(cursor++);
    }

    public void remove()
    {
      DynamicArrayList.this.remove(--cursor);
    }
  }
}
