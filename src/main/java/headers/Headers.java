package headers;

import com.github.tomakehurst.wiremock.http.HttpHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Headers {
    private static String contentType = "application/json";
    private static String contentTypeWithCharset = contentType + "; charset=UTF-8";

    public static String getHeaderContentType() {
        return "Content-Type";
    }

    public static String getContentType() { return contentType; }

    public static String getContentTypeWithCharset() {
        return contentTypeWithCharset;
    }

    public static String getHeaderAccept() {return "Accept";}

    public static List<HttpHeader> getPostCallbackHeaders() {
        List<HttpHeader> headers = new ArrayList<>();

        headers.add(new HttpHeader(getHeaderAccept(), "*/*"));
        headers.add(new HttpHeader(getHeaderContentType(), contentTypeWithCharset));

        return headers;
    }

    public static Map<String, String> getRestAssuredRequestHeaders() {
        HashMap<String, String> headers = new HashMap<>();

        headers.put(getHeaderAccept(), contentType);
        headers.put(getHeaderContentType(), contentType);

        return headers;
    }
}
