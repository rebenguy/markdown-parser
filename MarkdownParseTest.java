//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test public void getLinksFile1() throws IOException {

        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[https://something.com, some-thing.html]",
            links);
    }

    @Test public void getLinksFile2() throws IOException {

        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[hello.com, ucsd.edu, https://docs.google.com/document/d/1LnSfvTG_Hn2fxDtFMuhBhJqsf9336Bm1ljux2Af9FqE/edit, ucsd.edu, cafe.png, http://url/b.jpg]",
            links);
    }

    @Test public void getLinksFile3() throws IOException {

        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[something.html, crystal.com]", links);
    }

    @Test public void getLinksFile4() throws IOException {

        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[https://something.com, some-page.html]", links);
    }

    @Test public void getLinksFile5() throws IOException {

        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[]", links);
    }

    @Test public void getLinksFile6() throws IOException {

        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[]", links);
    }

    @Test public void getLinksFile7() throws IOException {

        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[]", links);
    }

    @Test public void snippet1() throws IOException {

        Path fileName = Path.of("snippet-1.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[`google.com, google.com, ucsd.edu]", links);
    }

    @Test public void snippet2() throws IOException {

        Path fileName = Path.of("snippet-2.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[a.com, a.com(()), example.com]", links);
    }

    @Test public void snippet3() throws IOException {

        Path fileName = Path.of("snippet-3.md");
        String content = Files.readString(fileName);
        String links = MarkdownParse.getLinks(content).toString();

        assertEquals("[https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule]", links);
    }
}
