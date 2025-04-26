class UserSolution {

	final int MIN_ID = 1;
	final int MAX_ID = 100000;
	final int MIN_TEAM = 1;
	final int MAX_TEAM = 5;
	final int MIN_SCORE = 1;
	final int MAX_SCORE = 5;

	class Node {
		int id;
		int team;
		int score;
		Node prev;
		Node next;

		public Node() {
		}

		public Node(int id, int team, int score) {
			this.id = id;
			this.team = team;
			this.score = score;
		}
	}

	class Team {
		// 헤드와 꼬리는 값이 들어있지 않은 빈 노드임
		Node head;
		Node tail;

		void initialize() {
			head = new Node();
			tail = new Node();
			link(head, tail);
		}

		void link(Node front, Node back) {
			front.next = back;
			back.prev = front;
		}

		void insert(Node node) { // 뒤로 삽입
			link(tail.prev, node);
			link(node, tail);
		}

		void remove(Node node) { // 현재 노드의 앞과 뒤를 연결
			link(node.prev, node.next);
		}

		void splice(Team back) {
			link(tail.prev, back.head.next);
			link(back.tail.prev, tail);
			back.initialize();
		}

		boolean isEmpty() {
			if (head.next == tail)
				return true;

			return false;
		}
	}

	Node[] soldier;
	Team[][] team; // [팀번호][점수]

	public void init() {
		team = new Team[MAX_TEAM + 1][MAX_SCORE + 1];
		for (int i = 1; i <= MAX_TEAM; i++) {
			for (int j = 1; j <= MAX_SCORE; j++) {
				team[i][j] = new Team();
				team[i][j].initialize();
			}
		}
		soldier = new Node[MAX_ID + 1];
	}

	public void hire(int mID, int mTeam, int mScore) {
		soldier[mID] = new Node(mID, mTeam, mScore);
		team[mTeam][mScore].insert(soldier[mID]);
	}

	public void fire(int mID) {
		int teamID = soldier[mID].team;
		int score = soldier[mID].score;
		team[teamID][score].remove(soldier[mID]);
	}

	public void updateSoldier(int mID, int mScore) {
		// 삽입을 먼저 하게 되면 다른 그룹의 prev, next가 연결되기때문에 삭제 먼저 해야함.
		fire(mID);
		soldier[mID].score = mScore;
		int teamID = soldier[mID].team;
		team[teamID][mScore].insert(soldier[mID]);
	}

	public void updateTeam(int mTeam, int mChangeScore) {
		if (mChangeScore > 0) {
			for (int i = MAX_SCORE - 1; i >= MIN_SCORE; i--) {
				int score = i + mChangeScore;
				if (score > MAX_SCORE)
					score = MAX_SCORE;

				team[mTeam][score].splice(team[mTeam][i]);
			}
		} else if (mChangeScore < 0) {
			for (int i = MIN_SCORE + 1; i <= MAX_SCORE; i++) {
				int score = i + mChangeScore;
				if (score < MIN_SCORE)
					score = MIN_SCORE;

				team[mTeam][score].splice(team[mTeam][i]);
			}
		}
	}

	public int bestSoldier(int mTeam) {
		int maxID = 0;
		
		for(int i = MAX_SCORE; i>=MIN_SCORE; i--) {
			if(!team[mTeam][i].isEmpty()) {
				for(Node cur = team[mTeam][i].head.next; cur != null; cur = cur.next) {
					if(maxID < cur.id) maxID = cur.id;
				}
				
				if(maxID != 0) break;
			}
		}
		
		return maxID;
	}
}