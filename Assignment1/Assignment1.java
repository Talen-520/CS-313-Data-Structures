public class Assignment1 {
    public static void main(String[] args) {
        DynamicArrayQueue<String> fileLines;
        InputReader ir;
        String filename;

        filename = args[0];
        ir = new InputReader(filename);
        fileLines = ir.readAndReturnFileLines();
        while (!fileLines.isEmpty()) {
            System.out.println(fileLines.dequeue());
        }
    }
}
