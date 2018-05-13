import java.util.ArrayList;
import java.util.Map;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet {

	private Map<String, ArrayList<Integer>> sysnetMap;
	private Digraph digraph;
	private int graphLength;

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		if (null == synsets || null == hypernyms) {
			throw new IllegalArgumentException();
		}

		processSysnsets(synsets);
	}

	// returns all WordNet nouns
	public Iterable<String> nouns() {
		return null;
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		return false;
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB) {
		return -1;
	}

	// a synset (second field of synsets.txt) that is the common ancestor of
	// nounA and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB) {
		return null;
	}

	private void processSysnsets(String synsets) {
		In in = new In(synsets);
		try {
			String line = null;
			while ((line = in.readLine()) != null) {
				String[] lineElement = line.split(",");
				String id = lineElement[0];
				String[] elements = lineElement[1].split(" ");
				for (String element : elements) {
					if (sysnetMap.containsKey(element)) {
						ArrayList<Integer> idList = sysnetMap.get(element);
						idList.add(new Integer(id));
						sysnetMap.put(element, idList);
					} else {
						ArrayList<Integer> idList = new ArrayList<>();
						idList.add(new Integer(id));
						sysnetMap.put(element, idList);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	// do unit testing of this class
	public static void main(String[] args) {

	}
}