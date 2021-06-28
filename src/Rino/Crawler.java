package Rino;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.javacodegeeks.com/2020/10/what-is-a-web-crawler-and-how-to-create-one.html");
            Scanner input = new Scanner(new InputStreamReader(url.openStream()));
            input.useDelimiter("\\Z");
            String content = input.next();
            input.close();
            content = content.replaceAll("\\n+","");
            Pattern pattern = Pattern.compile("a\">(.*?)</a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
