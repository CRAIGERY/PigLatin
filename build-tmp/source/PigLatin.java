import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	for(int a = 0; a < sWord.length(); a++)
	{
		if(sWord.charAt(a) == 'a' ||sWord.charAt(a) == 'e' ||sWord.charAt(a) == 'i' ||sWord.charAt(a) == 'o' ||sWord.charAt(a) == 'u' )
		{
			return a;
		}
	}
	return -1;
}

public String pigLatin(String sWord)
//returns piglatin equivalent of sWord
{
	if(sWord.charAt(0) == 'a' || sWord.charAt(0) == 'e' ||sWord.charAt(0) == 'i' ||sWord.charAt(0) == 'o' ||sWord.charAt(0) == 'u')
	{
		return sWord + "way";
	}
	if(sWord.charAt(0) == 'q' && sWord.charAt(1) == 'u')
	{
		return(sWord.substring(2, sWord.length()) + "quay");
	}	
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	if((findFirstVowel(sWord.charAt(0) + "") == -1) && (findFirstVowel(sWord) != -1))
	{
		return sWord.substring(findFirstVowel(sWord), sWord.length()) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
	}

	else
	{
		return "ERROR!";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
