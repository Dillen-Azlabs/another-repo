package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.CentreServicePhotoGallery;
import sg.ihh.ms.sdms.app.model.StructuredPagePhotoGallery;

@JsonPropertyOrder({"code", "message", "photoGallery"})
public class CentreServiceSubPhotoGalleryResponse extends BaseResponse{

    @JsonProperty("photoGallery")
    private CentreServicePhotoGallery centreServicePhotoGallery;

    public CentreServiceSubPhotoGalleryResponse(CentreServicePhotoGallery centreServicePhotoGallery) {
        super(HttpStatus.OK);
        this.centreServicePhotoGallery = centreServicePhotoGallery;
    }

    public CentreServicePhotoGallery getCentreServicePhotoGallery() {
        return centreServicePhotoGallery;
    }

    public void setCentreServicePhotoGallery(CentreServicePhotoGallery centreServicePhotoGallery) {
        this.centreServicePhotoGallery = centreServicePhotoGallery;
    }
}
