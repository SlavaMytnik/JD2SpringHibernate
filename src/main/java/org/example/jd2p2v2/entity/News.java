package org.example.jd2p2v2.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = EntityAttr.TABLE_NEWS)
public final class News implements Serializable {
	private static final long serialVersionUID = -7058269670927190600L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = EntityAttr.ID)
	private int id;
	
	@Column(name = EntityAttr.TITLE)
	private String title;
	
	@Column(name = EntityAttr.BRIEF)
	private String brief;
	
	@Column(name = EntityAttr.CONTENT)
	private String content;
	
	@Column(name = EntityAttr.DATE)
	private LocalDateTime date;
	
	@Column(name = EntityAttr.STATUS)
	private String status;

	public News() {
		super();
	}

	public News(final int id, final String title,
			final String brief) {
		super();

		this.id = id;
		this.title = title;
		this.brief = brief;
	}

	public News(int id, String title, String brief, String content, LocalDateTime date, String status) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
		this.status = status;
	}

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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		News news = (News) o;
		return id == news.id
				&& Objects.equals(title, news.title)
				&& Objects.equals(brief, news.brief)
				&& Objects.equals(content, news.content)
				&& Objects.equals(date, news.date)
				&& Objects.equals(status, news.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, brief, content, date, status);
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", brief='" + brief + '\'' +
				", content='" + content + '\'' +
				", date=" + date +
				", status='" + status + '\'' +
				'}';
	}
}
