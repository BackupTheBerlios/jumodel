package travel.test;

import javax.faces.event.ValueChangeEvent;

public class Bean {

	private String prr;
	private String tekst="nic";
	private String longTekst="hhh";
	private String temp="To jest bardzo d³ugi tekst. Kamil jest g³upi." +
			"Unable to install breakpoint in pack.Account$$EnhancerByCGLIB$$c7f2c4f0"
+"due to missing line number attributes. Modify compiler options to generate "
+"line number attributes.";
	static int pollTestInt=0;
	private boolean pollTest=true;
	static int licznik=0;
	
	public String getLongTekst() {
		return longTekst;
	}
	public void setLongTekst(String longTekst) {
		this.longTekst = longTekst;
	}
	public Bean() {
		// TODO Auto-generated constructor stub
	}
	public void onWritingCharInTextArea(ValueChangeEvent event) {
		System.out.println("jestem w evencie");
		System.out.println(event.getNewValue());
	}
	
	public String typingTextAction() {
		longTekst=temp.substring(0, licznik++);
		if (licznik==temp.length()) {licznik=0;
		pollTestInt++;
		if (pollTestInt==10) pollTest=false;
		}
		return "ok";
	}
	
	public String getPrr() {
		return prr;
	}

	public void setPrr(String prr) {
		this.prr = prr;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public boolean isPollTest() {
		return pollTest;
	}
	public void setPollTest(boolean pollTest) {
		this.pollTest = pollTest;
	}

}
