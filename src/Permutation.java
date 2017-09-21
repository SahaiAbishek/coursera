import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

	public static void main(String[] args) {

		int k = new Integer(args[0]);

		String str = StdIn.readString();
		RandomizedQueue<String> rq = new RandomizedQueue<>();

		rq.enqueue(str);

		while (!StdIn.isEmpty()) {
			str = StdIn.readString();
			rq.enqueue(str);
		}

		for (int i = 0; i <= k; i++) {
			StdOut.println(rq.dequeue());
		}

	}
}
