package board.vo;

//게시글 정보
public class Board {
	private int num;				//글 번호
	private String id;				//작성자 ID
	private String name;			//작성자 이름
	private String title;			//글 제목
	private String contents;		//글 본문내용
	private String inputdate;		//작성시간
	
	//생성자
	public Board() {
		super();
	}

	public Board(String id, String title, String contents) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Board [num=" + num + ", id=" + id + ", name=" + name + ", title=" + title + ", contents=" + contents
				+ ", inputdate=" + inputdate + "]";
	}
}
