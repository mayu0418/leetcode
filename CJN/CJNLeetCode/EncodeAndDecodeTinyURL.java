public class Codec {
 private String curString;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl)  {
        curString = longUrl.substring((longUrl.length()-1)/2);
        return longUrl.replace(curString,"");
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl)  {
        return shortUrl+curString;
    }
}
