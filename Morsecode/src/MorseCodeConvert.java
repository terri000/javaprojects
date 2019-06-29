import java.io.*;

public class MorseCodeConvert {
	private MorseCode[] listCodes;

	public MorseCodeConvert(String s) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			LineNumberReader reader = new LineNumberReader(new FileReader(s));
			while ((reader.readLine()) != null);
			int linenumber = reader.getLineNumber();
			listCodes = new MorseCode[linenumber];
			int i = 0;
			String st;
			while ((st = br.readLine()) != null) {
				String[] parts = st.split("\\t");
				if (parts.length > 2 || parts.length < 2) {
					System.out.println("Skipping line: " + st);
				} else {
					String part1 = parts[0];
					String part2 = parts[1];
					if (part1.length() > 1)
						System.out.println("Skipping line: " + st);
					else {
						char c = part1.charAt(0);
						MorseCode morse = new MorseCode(c, part2);
						if (morse.getCode() != null) {
							listCodes[i] = morse;
							++i;
						}
					}
				}
			}
			br.close();
			reader.close();
		} catch (Exception e) {
			System.out.println("java.lang.Exception: Invalid File name: " + s);
			System.exit(1);
		}
	}

	public void printMorseCodeList() {
		int length = listCodes.length;
		for (int i = 0; i < length; i++) {
			if (listCodes[i] != null) {
				System.out.println(listCodes[i].getCh() + " " + listCodes[i].getCode());
			}
		}
	}

	public void convertString(String s) {
		if (s == "" || s == null) {
			System.out.println("");
		} else {
			int length = s.length();
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				int x = c;
				if (x > 96 && x < 123)
					c = Character.toUpperCase(c);
				if (c == ' ') {
					System.out.printf(" ");
				} else {
					for (int j = 0; j < listCodes.length; j++) {

						if (c == listCodes[j].getCh()) {

							System.out.printf(listCodes[j].getCode() + " ");
							break;
						}

						if (listCodes[j+1] == null) {
							System.out.printf("? ");
							break;
						}
					}
				}
			}
		}
		System.out.printf("%n");
	}

	public void convertFile(String s) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			String st;
			while ((st = br.readLine()) != null) {
				if (st == "" || st == null) {
					System.out.println("");
				} else {
					int length = st.length();
					for (int i = 0; i < length; i++) {
						char c = st.charAt(i);
						int x = c;
						if (x > 96 && x < 123)
							c = Character.toUpperCase(c);
						if (c == ' ') {
							System.out.printf(" ");
						} else {
							for (int j = 0; j < listCodes.length; j++) {

								if (c == listCodes[j].getCh()) {

									System.out.printf(listCodes[j].getCode() + " ");
									break;
								}

								if (listCodes[j+1] == null) {
									System.out.printf("? ");
									break;
								}
							}
						}
					}
				}
				System.out.printf("%n");
			}
			br.close();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("java.lang.Exception: Invalid File name: " + s);
		}
	}

}
