public class DynamicArrayQueue<AnyType> implements Queue<AnyType> {
    public static final int DEFAULT_CAPACITY = 2;

    int front;
    int theSize;
    AnyType[] data;

    public DynamicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArrayQueue(int capacity) {
        front = 0;
        theSize = 0;
        data = (AnyType[]) new Object[capacity];
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    /*
     * The file DynamicArrayQueue.java implements a queue using an arrayas
     * storagewhere the queue’s array grows and shrinksin size as discussed in
     * class.You cannot change any of the code that is already in this file.You will
     * write the code for the resize, enqueue, first, and dequeuemethods.
     */
    protected void resize(int newCapacity) {
        int n = size();

        AnyType[] temp = (AnyType[]) new Object[newCapacity];   //initial a temporary array with new compacity
        for (int i = 0; i < n; i++)
            temp[i] = data[i];
        data = temp;            //return array data with new compacty
    }

    public void enqueue(AnyType newValue) {
        // if(data.size==data.capacity)
        int rear = data.length - 1; // rear element in arrayqueue
        if (size() == data.length)
            resize(2 * data.length);    //expand arrayQueue with double size
        data[rear++] = newValue;
        if (rear == data.length)
            rear = 0;
        theSize++;                      //size increased by 1 inorder to add new element to arrayQueue

    }

    public AnyType first() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("IllegalStatement");

        return data[front];
        // code here
    }

    public AnyType dequeue() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("IllegalStatement");
        AnyType result = data[front];
        theSize--;
        for (int i = 0; i < theSize; i++) // fliter first element out of array,move remaing element one foward
            data[i] = data[i + 1];

        data[theSize] = null;
        return result;
        // code here
    }
}
