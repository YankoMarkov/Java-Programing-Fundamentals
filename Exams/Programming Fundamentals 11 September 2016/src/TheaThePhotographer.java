import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class TheaThePhotographer {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal picturesAmount = new BigDecimal(read.readLine());
        BigInteger timeAmount = new BigInteger(read.readLine());
        BigDecimal totalPicturesPercentage = new BigDecimal(read.readLine());
        BigInteger neededTimeAmount = new BigInteger(read.readLine());

        BigDecimal percent = new BigDecimal("100.0");
        BigDecimal percentage = totalPicturesPercentage.divide(percent);
        BigDecimal filteredPicture = picturesAmount.multiply(percentage);
        BigDecimal filteredPictures = filteredPicture.setScale(0, RoundingMode.CEILING);
        BigInteger totalPicturesSeconds = picturesAmount.toBigInteger().multiply(timeAmount);
        BigInteger totalUploadsTimes = neededTimeAmount.multiply(filteredPictures.toBigInteger());
        BigInteger totalTime = totalPicturesSeconds.add(totalUploadsTimes);

        BigInteger days = totalTime.divide(BigInteger.valueOf(86400));
        BigInteger hours = totalTime.divide(BigInteger.valueOf(3600)).remainder(BigInteger.valueOf(24));
        BigInteger minutes = totalTime.divide(BigInteger.valueOf(60)).remainder(BigInteger.valueOf(60));
        BigInteger seconds = totalTime.remainder(BigInteger.valueOf(60));

        System.out.printf("%01d:%02d:%02d:%02d", days, hours, minutes, seconds);
    }
}
