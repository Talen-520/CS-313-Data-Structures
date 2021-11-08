public class SinglyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> n)
    {
      setData(d);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private Node<AnyType> head;

  public SinglyLinkedList()
  {
    theSize = 0;
    head = null;
  }

  ...

}
