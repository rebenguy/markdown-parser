//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )

        int currentIndex = 0;

        while(currentIndex < markdown.length()) {
        
            int openBracket = markdown.indexOf("[", currentIndex);

            int closeBracket = markdown.indexOf("]", openBracket);

            if(openBracket == -1 || closeBracket == -1) {
                break;
            }

            char paren = '(';
            char colo = ':';
            char next = markdown.charAt(closeBracket + 1);
            
            if (next == paren) {
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
                if(openParen == -1 || closeParen == -1){
                    break;
                }
            }
            else if (next == colo) {
                int colon = markdown.indexOf(":", closeBracket);
                int dot = markdown.indexOf(".", colon);
                toReturn.add(markdown.substring(colon + 1, dot + 4));
                currentIndex = dot + 4;
            }
            else {
                break;
            }

        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }

}
