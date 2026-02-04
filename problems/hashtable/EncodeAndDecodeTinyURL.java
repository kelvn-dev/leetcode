package problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";

        String encodedUrl = codec.encode(longUrl);
        String decodedUrl = codec.decode(encodedUrl);
        System.out.println(decodedUrl.equals(longUrl));
    }

    public static class Codec {
        private int id;
        private Map<Integer, String> map;
        private static final String BASE_URL = "http://tinyurl.com/4e9iAk";

        public Codec() {
            id = 1;
            map = new HashMap<>();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(id, longUrl);
            String encodedUrl = BASE_URL + id;
            ++id;
            return encodedUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int id = Integer.parseInt(shortUrl.replace(BASE_URL, ""));
            return map.get(id);
        }
    }
}
