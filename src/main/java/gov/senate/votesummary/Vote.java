package gov.senate.votesummary;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("vote")
public class Vote {
	@XStreamAlias("vote_number") private String number;
	@XStreamAlias("vote_date") private String date;
	@XStreamAlias("issue") private Issue issue;
	@XStreamAlias("question") private String question;
	@XStreamAlias("result") private String result;
	@XStreamAlias("vote_tally") private VoteTally tally;
	@XStreamAlias("title") private String title;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public VoteTally getTally() {
		return tally;
	}
	public void setTally(VoteTally tally) {
		this.tally = tally;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
