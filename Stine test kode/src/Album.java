import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Album { //comment
    private String name;
    private List<PictureInfo> pictures;

    public Album(String name) {
        this.name = name;
        this.pictures = new ArrayList<PictureInfo>();
    }

    public void addPicture(String filePath) {
        PictureInfo p = new PictureInfo(filePath);
        this.pictures.add(p);
    }

    public void removePicture(String filePath) {
        Optional<PictureInfo> o = pictures.stream().filter(x -> x.getInterestingMetadata().getFilepath().equals(filePath)).findFirst();
        if (o.isPresent()) {
            pictures.remove(o);
        }
    }

    public void sortIso() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getISO()));
    }

    public void sortIsoReversed() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getISO()));
    }

    public void sortDate() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getDateTime()));
    }

    public void sortExposureTime() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getExposureTime()));
    }

    public void sortFileSize() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getFileSize()));
    }

    public void sortFileName() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().getFileName()));
    }

    public void sortFlashUsed() {
        pictures.sort(Comparator.comparing(x -> x.getInterestingMetadata().isFlashUsed()));
    }



}
