import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class InterestingMetadata2 {
    private String filepath;
    private Date dateTime;
    private int ISO;
    private double exposureTime;
    private boolean isFlashUsed;
    private GeoLocation location;
    private double fileSize;
    private String fileName;

    public InterestingMetadata2(String filepath){
        this.filepath = filepath;
        File file =  new File(filepath);
        this.fileName = file.getName();
        this.fileSize = file.length()/(1024*1024);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            ExifSubIFDDirectory subIfd = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            GpsDirectory gps = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            location = gps.getGeoLocation();
            this.ISO = subIfd.getInteger(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);
            this.exposureTime = subIfd.getDoubleObject(ExifSubIFDDirectory.TAG_EXPOSURE_TIME);
            this.dateTime = subIfd.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
            Optional<Tag> flash = subIfd.getTags().stream().filter(x -> x.getTagName().equals("Flash")).findFirst();
            if(flash.isPresent()) {
                if(flash.get().getDescription().equals("Flash fired")) {
                    this.isFlashUsed = true;
                }
                else {
                    this.isFlashUsed = false;
                }
            }
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
