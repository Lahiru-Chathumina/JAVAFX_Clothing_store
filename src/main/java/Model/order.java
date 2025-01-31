package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class order {
    private String id;
    private String date;
    private String customerID;
    private List<orderDetail>orderDiteil;

}
