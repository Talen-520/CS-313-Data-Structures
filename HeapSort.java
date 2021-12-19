import java.util.Arrays;

public class HeapSort<AnyType extends Comparable<? super AnyType>>
{
  private int theSize;
  private AnyType[] values;

  public HeapSort()
  {
    theSize = 0;
    values = null;
  }

  private int size() { return theSize; }

  private int parent(int i) { return ((i - 1) / 2); }

  private int leftChild(int i) { return (2 * i + 1); }

  private int rightChild(int i) { return (2 * i + 2); }

  private boolean hasLeftChild(int i) { return (leftChild(i) < size()); }

  private boolean hasRightChild(int i) { return (rightChild(i) < size()); }

  public void setValues(AnyType[] items)
  {
    bottomUpHeapConstruction(items);
  }

  private void bottomUpHeapConstruction(AnyType[] items)
  {
    int n;

    n = items.length;
    theSize = n;
    values = Arrays.copyOfRange(items, 0, n);
    heapify();
  }

  private void heapify()
  {
    int i, startIndex;

    startIndex = parent(size()-1);
    for (i = startIndex; i >= 0; i--) downHeapBubbling(i);
  }

  private void downHeapBubbling(int index)
  {
    int leftChildIndex, rightChildIndex, largestChildIndex;
    AnyType downBubbleValue;

    downBubbleValue = values[index];
    while (hasLeftChild(index))
    {
      leftChildIndex = leftChild(index);
      largestChildIndex = leftChildIndex;
      if (hasRightChild(index))
      {
        rightChildIndex = rightChild(index);
        if (values[leftChildIndex].compareTo(values[rightChildIndex]) < 0)
          largestChildIndex = rightChildIndex;
      }
      if (values[largestChildIndex].compareTo(downBubbleValue) <= 0) break;
      values[index] = values[largestChildIndex];
      index = largestChildIndex;
    }
    values[index] = downBubbleValue;
  }

  private void deleteMaximum()
  {
    swap(0, size()-1);
    theSize--;
    downHeapBubbling(0);
  }

  private void swap(int i, int j)
  {
    AnyType temp;

    temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }

  public void getSortedValues(AnyType[] items)
  {
    int i, n;

    n = values.length;
    for (i = 0; i < n; i++) items[i] = values[i];
  }

  public void performHeapSort()
  {
    int i, n;

    n = size();
    for (i = 0; i < n; i++)
    {
      deleteMaximum();
    }
  }
}
