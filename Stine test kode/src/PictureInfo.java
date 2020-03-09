import java.util.List;

public class PictureInfo {
    private InterestingMetadata interestingMetadata;
    private List<String> tags;

    public PictureInfo(String filepath, List<String> tags) {
        this.interestingMetadata = new InterestingMetadata(filepath);
        this.tags = tags;
    }

    public boolean addTags(String tag) {
        tags.add(tag);
        return true;
    }
}
