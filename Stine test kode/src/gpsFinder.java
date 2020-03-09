import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

//kokt by lukas

public class gpsFinder {
    public static <gpsDirectory> void main(String[] args) throws ImageProcessingException, IOException {
        File bilde = new File("GOPR1206.JPG");

        Metadata meta = ImageMetadataReader.readMetadata(bilde);

        for (Directory directory : meta.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }
        }

        Directory dir = meta.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

        System.out.println("looking for geodata:");
        Collection<GpsDirectory> gpsDirectories = meta.getDirectoriesOfType(GpsDirectory.class);
        String output="gps location not found";
        for (GpsDirectory gpsDirectory : gpsDirectories) {
            // Try to read out the location, making sure it's non-zero
            GeoLocation geoLocation = gpsDirectory.getGeoLocation();
            if (geoLocation != null && !geoLocation.isZero()) {

                output="gps location found: ";
                System.out.println(output+geoLocation);

            }
        }
        System.out.println(output);
    }
}
