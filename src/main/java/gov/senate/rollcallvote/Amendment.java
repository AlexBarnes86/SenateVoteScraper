package gov.senate.rollcallvote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Amendment {
	@XStreamAlias("amendment_number") private String number;
	@XStreamAlias("amendment_to_amendment_number") private String toAmendmentNumber;
	@XStreamAlias("amendment_to_amendment_to_amendment_number") private String toAmendmentToAmendmentNumber;
	@XStreamAlias("amendment_to_document_number") private String toDocumentNumber;
	@XStreamAlias("amendment_to_document_short_title") private String toDocumentShortTitle;
	@XStreamAlias("amendment_purpose") private String purpose;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getToAmendmentNumber() {
		return toAmendmentNumber;
	}
	public void setToAmendmentNumber(String toAmendmentNumber) {
		this.toAmendmentNumber = toAmendmentNumber;
	}
	public String getToAmendmentToAmendmentNumber() {
		return toAmendmentToAmendmentNumber;
	}
	public void setToAmendmentToAmendmentNumber(String toAmendmentToAmendmentNumber) {
		this.toAmendmentToAmendmentNumber = toAmendmentToAmendmentNumber;
	}
	public String getToDocumentNumber() {
		return toDocumentNumber;
	}
	public void setToDocumentNumber(String toDocumentNumber) {
		this.toDocumentNumber = toDocumentNumber;
	}
	public String getToDocumentShortTitle() {
		return toDocumentShortTitle;
	}
	public void setToDocumentShortTitle(String toDocumentShortTitle) {
		this.toDocumentShortTitle = toDocumentShortTitle;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
