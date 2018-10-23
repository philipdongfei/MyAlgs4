

public static int[] readDates(String name)
{
    In in = new In(name);
    Queue<Character> q = new Queue<Character>();
    while (!in.isEmpty())
        q.enqueue(StdIn.readChar());

    int N = q.size(); 
    int[] a = new int[3];
    String temp = "";
    int k = 0;

    for (int i = 0; i < N; i++) {
        char c = q.dequeue();
        if (c == '/') {
            a[k] = Integer.parseInt(temp);
            k++;
            temp = "";
        } else {
            temp += c;
        }
    }
    a[k] = Integer.parseInt(temp);

    return a;
}
