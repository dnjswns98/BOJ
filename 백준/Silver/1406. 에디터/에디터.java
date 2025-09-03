import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		char c;
		Node prev;
		Node next;

		public Node() {
		}

		public Node(char c) {
			this.c = c;
		}
	}

	static class NodeList {
		Node head;
		Node tail;

		void init() {
			head = new Node();
			tail = new Node();
			link(head, tail);
		}

		void link(Node front, Node back) {
			front.next = back;
			back.prev = front;
		}

		void add(Node node) { // 끝에 삽입
			link(tail.prev, node);
			link(node, tail);
		}

		void remove(Node node) {
			link(node.prev, node.next);
		}

		void insert(Node cur, char c) {
			Node newNode = new Node(c);
			if (cur.prev != null) {
				link(cur.prev, newNode);
				link(newNode, cur);
			}
			else {
				link(newNode, cur.next);
				link(cur, newNode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		NodeList list = new NodeList();
		list.init();
		for (int i = 0; i < str.length(); i++) {
			Node newNode = new Node(str.charAt(i));
			list.add(newNode);
		}
		Node cur = list.tail;

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String com = br.readLine();
			switch (com.charAt(0)) {
			case 'L':
				if (cur.prev != list.head)
					cur = cur.prev;
				break;
			case 'D':
				if (cur.next != null)
					cur = cur.next;
				break;
			case 'B':
				if (cur.prev != list.head) {
					list.remove(cur.prev);
				}
				break;
			case 'P':
				char c = com.charAt(2);
				list.insert(cur, c);
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Node node = list.head.next; node.next != null; node = node.next) {
			sb.append(node.c);
		}
		System.out.println(sb);
	}
}
