public class GeneralTreeVersion1<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private List<Node<AnyType>> children;

    public Node(AnyType newValue)
    {
      data = newValue;
      children = new List<Node<AnyType>>();
    }
  }

  private Node<AnyType> root;

  public GeneralTreeVersion1()
  {
    root = null;
  }

  public GeneralTreeVersion1(AnyType newValue)
  {
    root = new Node<>(newValue);
  }

// Code to implement a general tree.

}
