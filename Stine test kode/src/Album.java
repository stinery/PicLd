import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Album { //comment
    private List<PictureInfo> album;

    public Album() {
        this.album = new ArrayList<PictureInfo>();
    }

    public void addPicture(String filePath) {
        PictureInfo p = new PictureInfo(filePath);
        this.album.add(p);
    }

    public void removePicture(String filePath) {
        Optional<PictureInfo> o = album.stream().filter(x -> x.getInterestingMetadata().getFilepath().equals(filePath)).findFirst();
        if (o.isPresent()) {
            album.remove(o);
        }
    }

    public void sortIso() {
        album.sort(Comparator.comparing(x -> x.getInterestingMetadata().getISO()));
    }

    public void sortIsoReversed() {
        album.sort(Comparator.comparing(x -> x.getInterestingMetadata().getISO()));
    }

    public void sortDate() {
        album.sort(Comparator.comparing(x -> x.getInterestingMetadata().getDateTime()));
    }



}
