package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;
import java.util.Comparator;
public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {

    public TelevisionResolutionMakeDescendingComparator() {
    }

    @Override
    public int compare(Television t1, Television t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }
        int resolutionComparison = Integer.compare(t2.getResolution(), t1.getResolution());
        if (resolutionComparison != 0) {
            return  t2.getResolution() - t1.getResolution();
        }

        // If the resolutions are the same, compare the makes in descending order
        return t2.getMake().compareTo(t1.getMake());
    }
}





