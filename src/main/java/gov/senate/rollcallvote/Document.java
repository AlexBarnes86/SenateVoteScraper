package gov.senate.rollcallvote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("document")
public class Document {
	@XStreamAlias("document_congress") private String congress;
	@XStreamAlias("document_type") private String type;
	@XStreamAlias("document_number") private String number;
	@XStreamAlias("document_name") private String name;
	@XStreamAlias("document_title") private String title;
	@XStreamAlias("document_short_title") private String shortTitle;
	
	public String getCongress() {
		return congress;
	}
	public void setCongress(String congress) {
		this.congress = congress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
}
