
    import java.util.PriorityQueue;
    import java.util.Comparator;
    
    // Node class for Huffman Tree
    class Node {
        char ch;
        int freq;
        Node left, right;
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }
    }
    
    // Comparator for PriorityQueue
    class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.freq - b.freq;
        }
    }
    
    public class HuffmanCoding {
        // Generate Huffman Codes
        public static void generateCodes(Node root, String code, StringBuilder result) {
            if (root == null) return;
            // Leaf node
            if (root.left == null && root.right == null) {
                result.append(root.ch).append(": ").append(code).append("\n");
            }
            generateCodes(root.left, code + "0", result);
            generateCodes(root.right, code + "1", result);
        }
        
        // Build Huffman Tree and encode
        public static void huffmanEncode(char[] chars, int[] freqs) {
            PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
            // Create leaf nodes and add to PriorityQueue
            for (int i = 0; i < chars.length; i++) {
                pq.add(new Node(chars[i], freqs[i]));
            }
            
            // Build the Huffman Tree
            while (pq.size() > 1) {
                Node left = pq.poll();
                Node right = pq.poll();
                Node newNode = new Node('-', left.freq + right.freq);
                newNode.left = left;
                newNode.right = right;
                pq.add(newNode);
            }
            
            // Root of the Huffman Tree
            Node root = pq.poll();
            
            // Generate and print Huffman Codes
            StringBuilder result = new StringBuilder();
            generateCodes(root, "", result);
            System.out.println(result.toString());
        }
    
        public static void main(String[] args) {
            char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
            int[] freqs = { 5, 9, 12, 13, 16, 45 };
            System.out.println("Huffman Codes:");
            huffmanEncode(chars, freqs);
        }
    }
    