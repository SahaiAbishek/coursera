import java.util.Comparator;

import coursera.Stack;
import edu.princeton.cs.algs4.MinPQ;

public class Solver {

	private MinPQ<Node> pqBoard;
	private MinPQ<Node> pqTwinBoard;
	private Node finalNode = null;
	private boolean solvable = false;

	private class Node {
		private Node prev = null;
		private Board board = null;

		public Node(Node prev, Board board) {
			this.prev = prev;
			this.board = board;
		}

	}

	private Comparator<Node> boardComparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.board.manhattan() - o2.board.manhattan();
		}
	};

	public Solver(Board initial) {
		pqBoard = new MinPQ<>(boardComparator);
		pqTwinBoard = new MinPQ<>(boardComparator);

		Node node = new Node(null, initial);
		Node twinNode = new Node(null, initial.twin());

		while (!node.board.isGoal() && !twinNode.board.isGoal()) {
			for (Board board : node.board.neighbors()) {
				if (node.prev != null && !board.equals(node.prev.board)) {
					Node neighbour = new Node(node, board);
					pqBoard.insert(neighbour);
				}
			}

			for (Board twinBoard : twinNode.board.neighbors()) {
				if (node.prev != null && !twinBoard.equals(node.prev.board)) {
					Node neighbour = new Node(node, twinBoard);
					pqBoard.insert(neighbour);
				}
			}

			node = pqBoard.delMin();
			twinNode = pqTwinBoard.delMin();
		}
		if (node.board.isGoal()) {
			solvable = true;
			finalNode = node;
		}
	}

	public boolean isSolvable() {
		return solvable;
	}

	public int moves() {
		int moves = 0;
		if (!isSolvable()) {
			return -1;
		}
		Node current = finalNode;
		while (current.prev != null) {
			moves++;
			current = current.prev;

		}
		return moves;
	}

	public Iterable<Board> solution() {
		if (isSolvable()) {
			Node current = finalNode;
			Stack<Board> stk = new Stack<>();
			while (current.prev != null) {
				stk.push(current.board);
				current = current.prev;
			}
			return stk;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

	}
}