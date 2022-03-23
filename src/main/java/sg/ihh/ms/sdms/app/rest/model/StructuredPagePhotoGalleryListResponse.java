package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPageCardCarousel;
import sg.ihh.ms.sdms.app.model.StructuredPagePhotoGallery;

import java.util.List;

@JsonPropertyOrder({"code", "message", "photoGallery"})
public class StructuredPagePhotoGalleryListResponse extends BaseResponse {

    @JsonProperty("photoGallery")
    private StructuredPagePhotoGallery structuredPagePhotoGallery;

    public StructuredPagePhotoGalleryListResponse(StructuredPagePhotoGallery structuredPagePhotoGallery) {
        super(HttpStatus.OK);
        this.structuredPagePhotoGallery = structuredPagePhotoGallery;
    }

    public StructuredPagePhotoGallery getStructuredPagePhotoGallery() {
        return structuredPagePhotoGallery;
    }

    public void setStructuredPagePhotoGallery(StructuredPagePhotoGallery structuredPagePhotoGallery) {
        this.structuredPagePhotoGallery = structuredPagePhotoGallery;
    }
}
