package utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.nio.charset.StandardCharsets;

public class ConvertJsonToXML {
    public String convertToXML(String jsonString, String root) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<"+root+">\n" + XML.toString(jsonObject) + "\n</"+root+">";

        byte[] bytes = xml.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

        return utf8EncodedString;
    }
}