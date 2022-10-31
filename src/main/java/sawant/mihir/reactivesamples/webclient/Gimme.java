package sawant.mihir.reactivesamples.webclient;

public record Gimme(String postLink, String subreddit, String title,
                    String url, boolean nsfw, boolean spoiler,
                    String author, int ups, String[] preview) {
}
