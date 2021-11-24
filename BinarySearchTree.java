import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
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

  public BinarySearchTree() { makeEmpty(); }

  public void makeEmpty() { root = null; } 

  public boolean isEmpty() { return (root == null); }

  public boolean contains(AnyType v) { return contains(v, root); }

  private boolean contains(AnyType v, Node<AnyType> t)
  {
    if (t == null) return false;

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      return contains(v, t.getLeft());
    else
      if (compareResult > 0)
        return contains(v, t.getRight());
      else
        return true;
  }

  public AnyType findMin() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> minNode = findMin(root);
    return minNode.getData();
  }

  private Node<AnyType> findMin(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getLeft() == null)
        return t;

    return findMin(t.getLeft());
  }

  public AnyType findMax() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> maxNode = findMax(root);
    return maxNode.getData();
  }

  private Node<AnyType> findMax(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getRight() == null)
        return t;

    return findMax(t.getRight());
  }

  public void insert(AnyType v) { root = insert(v, root); }

  private Node<AnyType> insert(AnyType v, Node<AnyType> t)
  {
    if (t == null) return (new Node<>(v, null, null));

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      t.setLeft(insert(v, t.getLeft()));
    else
      if (compareResult > 0)
        t.setRight(insert(v, t.getRight()));
      else
        ;  // Duplicate value, do nothing.

    return t;
  }

  public void remove(AnyType v) { root = remove(v, root); }

  private Node<AnyType> remove(AnyType v, Node<AnyType> t)
  {
    if (t == null) return t;

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      t.setLeft(remove(v, t.getLeft()));
    else
      if (compareResult > 0)
        t.setRight(remove(v, t.getRight()));
      else
        if (t.getLeft() != null && t.getRight() != null)
        {
          Node<AnyType> minNodeRightSubtree = findMin(t.getRight());
          AnyType minNodeRightSubtreeValue = minNodeRightSubtree.getData();
          t.setData(minNodeRightSubtreeValue);
          t.setRight(remove(minNodeRightSubtreeValue, t.getRight()));
        }
        else
        {
          Node<AnyType> childOfT = (t.getLeft() != null) ? t.getLeft() : t.getRight();
          t = childOfT;
        }

    return t;
  }

  public Iterator<AnyType> iterator()
  {
    LinkedList<AnyType> snapshot = new LinkedList<>();

    inOrderTraversal(root, snapshot);
    return snapshot.iterator();
  }

  private void inOrderTraversal(Node<AnyType> t, LinkedList<AnyType> l)
  {
    if (t != null)
    {
      inOrderTraversal(t.getLeft(), l);
      l.add(t.getData());
      inOrderTraversal(t.getRight(), l);
    }
  }
}
