package board.vo;

public class Board {
	private int num;
	private String id, title, contents, inputdate;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int num, String id, String title, String contents, String inputdate) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.inputdate = inputdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", id=" + id + ", title=" + title + ", contents=" + contents + ", inputdate="
				+ inputdate + "]";
	}
	
}
