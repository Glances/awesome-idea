package robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class Robot {

    public static final String API_KEY = "替换成你自己的机器人的apikey";

    public static String getAnswer(String question) throws IOException {
        URL url = getUrl(question);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        String[] ss;
        String s = sb.toString();
        String answer;
        ss = s.split(":");
        answer = ss[ss.length - 1];
        answer = answer.substring(1, answer.length() - 2);
        return answer;
    }

    private static URL getUrl(String question) throws MalformedURLException, UnsupportedEncodingException {
        String info = URLEncoder.encode(question, "utf-8");
        return new URL("http://www.tuling123.com/openapi/api?key=" + API_KEY + "&info=" + info);
    }
}