package db_connect;

public class BbsVO {
	int id;
	String title;
	String content;
	String writer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "BbsVO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}
