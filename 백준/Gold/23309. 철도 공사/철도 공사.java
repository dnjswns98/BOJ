import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int x;
		Node prev;
		Node next;
		
		public Node() {}

		public Node(int x) {
			this.x = x;
		}
	}
	
	static class NodeList {
		Node head;
		Node tail;
		
		public NodeList() {
			head = new Node();
			tail = new Node();
			link(head, tail);
		}
		
		void link(Node front, Node back) {
			front.next = back;
			back.prev = front;
		}
		
		void insert(Node newNode) { // 오른쪽 끝에 삽입
			link(tail.prev, newNode);
			link(newNode, tail);
		}
		
		void insertFront(Node cur, Node newNode) {
			link(cur.prev, newNode);
			link(newNode, cur);
		}
		
		void insertBack(Node cur, Node newNode) {
			link(newNode, cur.next);
			link(cur, newNode);
		}
		
		void removeFront(Node cur) {
			link(cur.prev.prev, cur);
		}
		
		void removeBack(Node cur) {
			link(cur, cur.next.next);
		}
		
		void makeCircle() {
			link(tail.prev, head.next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Node[] node = new Node[1000001];
		NodeList list = new NodeList();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			node[x] = new Node(x);
			list.insert(node[x]);
		}
		list.makeCircle();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b;
			switch(com) {
			case "BN":
				b = Integer.parseInt(st.nextToken());
				node[b] = new Node(b);
				sb.append(node[a].next.x).append('\n');
				list.insertBack(node[a], node[b]);
				break;
			case "BP":
				b = Integer.parseInt(st.nextToken());
				node[b] = new Node(b);
				sb.append(node[a].prev.x).append('\n');
				list.insertFront(node[a], node[b]);
				break;
			case "CP":
				sb.append(node[a].prev.x).append('\n');
				list.removeFront(node[a]);
				break;
			case "CN":
				sb.append(node[a].next.x).append('\n');
				list.removeBack(node[a]);
				break;
			}
		}
		
		System.out.println(sb);
	}
}
