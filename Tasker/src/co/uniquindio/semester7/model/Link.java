package co.uniquindio.semester7.model;

public class Link {
	private int id;
	private String link;
	private Class classAssociated;

	public Link(String link, Class classAssociated) {
		this.link = link;
		this.classAssociated = classAssociated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Class getClassAssociated() {
		return classAssociated;
	}

	public void setClassAssociated(Class classAssociated) {
		this.classAssociated = classAssociated;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", link=" + link + "]";
	}

}
