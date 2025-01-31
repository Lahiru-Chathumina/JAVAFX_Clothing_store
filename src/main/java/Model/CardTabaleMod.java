package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardTabaleMod {

    private String itemcode;
    private String Description;
    private int QTYonHand;
    private Double UnitePrice;
    private  Double Total;
}
