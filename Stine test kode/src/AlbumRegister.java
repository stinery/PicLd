import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumRegister {
    private List<Album> albums;

    public AlbumRegister() {
        albums = new ArrayList<Album>();
    }

    public void addAlbum(String name) {
        Album a = new Album(name);
        albums.add(a);
    }

    public Album findAlbumByName(String albumName) {
        Optional<Album> a = albums.stream().filter(x -> x.getName().equals(albumName)).findFirst();
        if(a.isPresent()){
            return a.get();
        }
        return null;
    }

    public void addPhoto(String albumName, String filePath) {
        findAlbumByName(albumName).addPicture(filePath);
    }
}
