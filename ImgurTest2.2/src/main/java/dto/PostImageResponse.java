package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostImageResponse
{

    @JsonProperty("status")
    public Integer status;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("data")
    public Data data;

}
