package other;

import java.util.regex.Pattern;

public class RabinKarpAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEK";
		int p = 101;
		search(text, pattern, p);

	}
	public static void search(String text, String pattern, int p) {
		int h = 1;
		int hash_pattent = 0;
		int hash_text_window = 0;
		
		for (int i = 0; i < pattern.length()-1; i++) {
			h = (h*26) % p;	
		}
		for (int i = 0; i < pattern.length(); i++) {
			hash_pattent = (26 * hash_pattent + pattern.charAt(i)) % p;
			hash_text_window = (26 * hash_text_window + text.charAt(i)) % p;
		}
		for (int i = 0; i < text.length() - pattern.length(); i++) {
			if(hash_text_window == hash_pattent) {
				for (int j = 0; j < pattern.length(); j++) {
					if( text.charAt(i+j) != pattern.charAt(j) ) {
						break;
					}
					if(j == pattern.length())
						System.out.println("patter found at index "+ i);
				}
				
			}
			if ( i < text.length() - pattern.length() ) 
            { 
                hash_text_window = (26*(hash_text_window - text.charAt(i)*h) + text.charAt(i+pattern.length()))%p; 
                if (hash_text_window < 0) 
                	hash_text_window = (hash_text_window + p); 
            } 
		}
	}
}
