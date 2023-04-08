package cscd212classes.lab2;
import cscd212comparators.lab2.TelevisionModelScreenSizeComparator;
        import cscd212comparators.lab2.TelevisionResolutionMakeDescendingComparator;
        import cscd212comparators.lab2.TelevisionScreenSizeComparator;
        import java.util.Objects;


public class Television implements Comparable<Television> {

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;






    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = (resolution == 2160);
    }




    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getScreenSize() {
        return screenSize;
    }

    public int getResolution() {
        return resolution;
    }


    @Override
    public String toString() {
        String tvType = smart && !fourK ? "smart tv" : "tv";
        String resolutionStr = fourK ? "4K resolution" : resolution + " resolution";
        return make + "-" + model + ", " + screenSize + " inch " + tvType + " with " + resolutionStr;
    }




    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Television other = (Television) o;
        return fourK == other.fourK &&
                screenSize == other.screenSize &&
                smart == other.smart &&
                resolution == other.resolution &&
                make.equals(other.make) &&
                model.equals(other.model);
    }


    @Override
    public int hashCode() {

        return this.make.hashCode()+ this.model.hashCode()+ this.resolution+Boolean.hashCode(this.smart)+Boolean.hashCode(this.fourK);
    }

    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        int makeComparison = make.compareTo(another.make);
        if (makeComparison != 0) {
            return makeComparison;
        }
        int modelComparison = model.compareTo(another.model);
        if (modelComparison != 0) {
            return modelComparison;
        }
        if (screenSize != another.screenSize) {
            return screenSize - another.screenSize;
        }
        return Integer.compare(resolution, another.resolution);
    }


}

