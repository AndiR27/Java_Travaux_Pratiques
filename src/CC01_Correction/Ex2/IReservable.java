package CC01_Correction.Ex2;

import java.util.List;

public interface IReservable {
    boolean reserver(String id, List<Passager> passagers);
}
