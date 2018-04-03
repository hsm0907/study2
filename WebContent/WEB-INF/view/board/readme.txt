-- 생성해야할것

vo : com.study.board.vo : Board
Dao : com.study.board.dao : BoardDaoJDBC
	 + getBoardList(Connection conn)
	 + getBoard(Connection conn, int bo_no)
	 + insertBoard(Connection conn, Board board)
	 + updateBoard(Connection conn, Board board)
	 
Service : com.study.board.service : BoardServiceImpl
	 + getBoardList()
	 + getBoard(int bo_no)
	 + registBoard(Board board)
	 + modifyBoard(Board board)