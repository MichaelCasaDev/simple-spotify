import ui.Gestore;
import utils.Fetcher;

public class Main {
    public static void main(String[] args) {
        try {
            Fetcher fetcher = new Fetcher("BQABCQbCqODuLOXFzjOXj-8E-W1lGH9Xeq7n95bgFRlm_Z8DUFuU_8Fj7CZCN2U21Qc4Flo8WtVbLBVauwLsFFweUNG1u5j1g0vb4Y2uB6QbxtKJLzwEH1RmFltLlhC8F_uQPhu9AzEOIgoFzYNR07qV3Lxg18LN-BTFHpI5tTFpJqTMcBmiTPfPJKniStCcFrkGwOryDykmqgzQyElr8DN-JnR-enEtjnseMq25EcqGztUvh51x7dk");
            Gestore frame = new Gestore(fetcher);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
