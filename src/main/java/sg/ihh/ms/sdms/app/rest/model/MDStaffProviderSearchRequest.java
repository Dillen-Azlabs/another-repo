package sg.ihh.ms.sdms.app.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class MDStaffProviderSearchRequest {

     @JsonProperty("searchTerm")
    private String searchTerm;

    @JsonProperty("orderBy")
    @Valid
    @NotEmpty(message = "orderBy is mandatory")
    private List<OrderRequest> orderList;

    @JsonProperty("offset")
    @Min(0)
    private int offset = -1;

    @JsonProperty("pageSize")
    @Min(1)
    private int pageSize = -1;

    public MDStaffProviderSearchRequest() {
        // Empty Constructor
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<OrderRequest> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderRequest> orderList) {
        this.orderList = orderList;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
