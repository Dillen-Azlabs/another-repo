package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;
import sg.ihh.ms.sdms.app.model.StructuredPagePhotoGallery;

import java.util.List;

@JsonPropertyOrder({"code", "message", "count", "photoGallery"})
public class StructuredPagePhotoGalleryListResponse extends BaseResponse {

    @JsonProperty("photoGallery")
    private List<StructuredPagePhotoGallery> list;

    public StructuredPagePhotoGalleryListResponse(List<StructuredPagePhotoGallery> list) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public StructuredPagePhotoGalleryListResponse(List<StructuredPagePhotoGallery> list, int count) {
        super(HttpStatus.OK);
        this.list = list;
    }

    public List<StructuredPagePhotoGallery> getList() {
        return list;
    }

    public void setList(List<StructuredPagePhotoGallery> list) {
        this.list = list;
    }

}
