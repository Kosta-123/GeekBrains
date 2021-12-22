
package dto.Delete;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
@Getter
@Setter
public class DeleteImageResponse
{

    @JsonProperty("status")
    public Integer status;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("data")
    public String data;


}
