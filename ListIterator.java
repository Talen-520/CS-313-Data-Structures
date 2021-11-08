public interface ListIterator<AnyType>
{
  boolean hasPrevious();

  boolean hasNext();

  AnyType previous();

  AnyType next();

  void add(AnyType newValue);

  void remove();
}
