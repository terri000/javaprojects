
public class MorseCode {
private char ch;
private String code;
public MorseCode(char ch, String code) {
	try {
	ch = Character.toUpperCase(ch);
	int x = ch;
	if(x < 32 || x > 90)
		throw new Exception();
	else {
		this.ch = ch;
		this.code = code;
	}
	}
	catch(Exception e) {
		System.out.println(e + ": Out-of-range Character: "+ ch);
	}
}
public char getCh() {return ch;}
public void setCh(char ch) {this.ch = ch;}
public String getCode() {return code;}
public void setCode(String code){this.code = code;}


}
