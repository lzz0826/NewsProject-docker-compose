package tw.tony.com.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("news")
public class AllNewsDetailed {
	
	@TableId(type = IdType.AUTO)
	private Integer id;
	
	private String title;
	
	private String tag;

	private String author;
	
	private String content;
	
	private String createTime;
	
	
	//0 = 公開  1 = 下架  2 = 刪除
	@TableField("release_state")
	private Integer releaseState;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public Integer getReleaseState() {
		return releaseState;
	}


	public void setReleaseState(Integer releaseState) {
		this.releaseState = releaseState;
	}


	@Override
	public String toString() {
		return "AllNewsDetailed [id=" + id + ", title=" + title + ", tag=" + tag + ", author=" + author + ", content="
				+ content + ", createTime=" + createTime + ", releaseState=" + releaseState + "]";
	}


	
	
	
	

}
