import java.util.Iterator;
import java.util.LinkedList;

public class BinaryTree<AnyType> implements Iterable<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> left;
    private Node<AnyType> right;

    public Node(AnyType d, Node<AnyType> l, Node<AnyType> r)
    {
      setData(d);
      setLeft(l);
      setRight(r);
    }

    public AnyType getData() { return data; }
    public Node<AnyType> getLeft() { return left; }
    public Node<AnyType> getRight() { return right; }

    public void setData(AnyType d) { data = d; }
    public void setLeft(Node<AnyType> l) { left = l; }
    public void setRight(Node<AnyType> r) { right = r; }
  }

  private Node<AnyType> root;

  public BinaryTree() { makeEmpty(); }

  public BinaryTree(AnyType d) { setRoot(d); }

  public void makeEmpty() { root = null; } 

  private Node<AnyType> createNode(AnyType d, Node<AnyType> l, Node<AnyType> r)
  {
    return new Node<AnyType>(d, l, r);
  }

  private Node<AnyType> getRoot() { return root; }

  private Node<AnyType> getLeftChild() { return root.getLeft(); }

  private Node<AnyType> getRightChild() { return root.getRight(); }

  private void setRoot(AnyType d)
  {
    root = createNode(d, null, null);
  }

  private void setLeftChild(Node<AnyType> child)
  {
    root.setLeft(child);
  }

  private void setRightChild(Node<AnyType> child)
  {
    root.setRight(child);
  }

  public void attach(BinaryTree<AnyType> t1, BinaryTree<AnyType> t2)
  {
    Node<AnyType> leftChild, rightChild;

    leftChild = t1.getRoot();
    rightChild = t2.getRoot();

    setLeftChild(leftChild);
    setRightChild(rightChild);

    t1.makeEmpty();
    t2.makeEmpty();
  }

  public Iterator<AnyType> iterator()
  {
    LinkedList<AnyType> snapshot = new LinkedList<>();

    postOrderTraversal(root, snapshot);
    return snapshot.iterator();
  }

  private void postOrderTraversal(Node<AnyType> t, LinkedList<AnyType> l)
  {
    if (t != null)
    {
      postOrderTraversal(t.getLeft(), l);
      postOrderTraversal(t.getRight(), l);
      l.add(t.getData());
    }
  }
}
