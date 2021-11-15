public class GeneralTreeVersion2<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> firstChild;
    private Node<AnyType> nextSibling;

    public Node(AnyType newValue)
    {
      data = newValue;
      firstChild = null;
      nextSibling = null;
    }
  }

  private Node<AnyType> root;

  public GeneralTreeVersion2()
  {
    root = null;
  }

  public GeneralTreeVersion2(AnyType newValue)
  {
    root = new Node<>(newValue);
  }

// Code to implement a general tree.

}
