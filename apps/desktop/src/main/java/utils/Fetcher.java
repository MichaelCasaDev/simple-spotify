package utils;

import api.following.Following;
import api.me.Me;
import api.player.Player;
import api.search.Search;
import api.tracks.Tracks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Fetcher {
    private final String baseURI = "https://api.spotify.com/v1/";
    private String authKey;

    public Fetcher(String authKey) {
        this.authKey = authKey;
    }

    public Tracks tracks() throws Exception {
        String xml = fetchData("me/tracks", "GET");
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JAXBContext context = JAXBContext.newInstance(Tracks.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Tracks root = (Tracks) unmarshaller.unmarshal(reader);
        reader.close();

        return root;
    }

    public Player player() throws Exception {
        String xml = fetchData("me/player", "GET");
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JAXBContext context = JAXBContext.newInstance(Player.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Player root = (Player) unmarshaller.unmarshal(reader);
        reader.close();

        return root;
    }

    public Me me() throws Exception {
        String xml = fetchData("me", "GET");
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JAXBContext context = JAXBContext.newInstance(Me.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Me root = (Me) unmarshaller.unmarshal(reader);
        reader.close();

        return root;
    }

    public Search search(String query, String type) throws Exception {
        String xml = fetchData("search?q=" + query + "&type=" + type, "GET");
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JAXBContext context = JAXBContext.newInstance(Search.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Search root = (Search) unmarshaller.unmarshal(reader);
        reader.close();

        return root;
    }

    public Following following() throws Exception {
        String xml = fetchData("me/following?type=artist", "GET");
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JAXBContext context = JAXBContext.newInstance(Following.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Following root = (Following) unmarshaller.unmarshal(reader);
        reader.close();

        return root;
    }

    public void playStopPlayer() throws Exception {
        doRequest("me/player/play", "PUT");
    }

    public void nextPlayer() throws Exception {
        doRequest("me/player/next", "POST");
    }

    public void previousPlayer() throws Exception {
        doRequest("me/player/previous", "POST");
    }

    private void doRequest(String path, String method) throws Exception {
        URL url = new URL(baseURI + path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Authorization", "Bearer " + authKey);
    }

    private String fetchData(String path, String method) throws Exception {
        URL url = new URL(baseURI + path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Authorization", "Bearer " + authKey);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = in.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = in.readLine();
        }
        in.close();

        String content = sb.toString();
        if(content.startsWith("{"))
            return new ConvertJsonToXML().convertToXML(content, "root");
        else
            return "<root></root>";
    }
}
