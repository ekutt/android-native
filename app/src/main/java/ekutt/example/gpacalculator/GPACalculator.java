package ekutt.example.gpacalculator;
import java.util.*;

public class GPACalculator {

  static {
    System.loadLibrary("gpaCalc-jni");
  }

  public GPACalculator()
  {
    nativeObjectHandle = nativeCreateObject();
  }

  public List<Result> calculateGPAs()
  {
    return calculateGPAs(nativeObjectHandle);
  }

  public void addGrade(String name, float grade, int credit)
  {
    addGrade(nativeObjectHandle, name, grade, credit);
  }

  public void clearData()
  {
    clearData(nativeObjectHandle);
  }

  private long nativeObjectHandle;

  private native long nativeCreateObject();
  private native List<Result> calculateGPAs(long nativeObjectHandle);
  private native void clearData(long nativeObjectHandle);
  private native void addGrade(long nativeObjectHandle, String name, float grade, int credits);
}
