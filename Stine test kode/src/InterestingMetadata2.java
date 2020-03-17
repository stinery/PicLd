import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class InterestingMetadata2 {
    private String filepath;
    private Date dateTime;
    private int ISO;
    private double exposureTime;
    private String GPSLatitude;
    private String GPSLongitude;
    private int fileSize;
    private String fileName;

    public InterestingMetadata2(String filepath){
        this.filepath = filepath;
        File file =  new File(filepath);
        this.fileName = file.getName();
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            ExifSubIFDDirectory subIfd = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            this.ISO = subIfd.getInteger(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);
            this.exposureTime = subIfd.getDoubleObject(ExifSubIFDDirectory.TAG_EXPOSURE_TIME);
            this.dateTime = subIfd.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
