package Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class orderDetail {
    private String oderID;
    private String itemCode;
    private Integer Qty;
    private Double unitePrce;

}
