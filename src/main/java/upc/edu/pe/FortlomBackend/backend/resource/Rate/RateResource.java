package upc.edu.pe.FortlomBackend.backend.resource.Rate;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.FortlomBackend.backend.resource.Artist.ArtistResource;
import upc.edu.pe.FortlomBackend.backend.resource.Fanatic.FanaticResource;
@Getter
@Setter
public class RateResource {


    private Long id;
    private Long rates;
    private ArtistResource artist;
    private FanaticResource fanatic;


}
