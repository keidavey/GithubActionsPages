package com.chromatech.Cucumber_BDD_Testing.Constants.screenRecording;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import com.chromatech.utils.CommonMethods;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil extends ScreenRecorder {

    public static ScreenRecorder screenRecorder;
    public String name;

    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    /**
     * Creates a new movie file using the specified file format.
     *
     * @param fileFormat the file format to use for the movie file
     * @return the created movie file
     * @throws IOException if an I/O error occurs while creating the file or determining the extension
     */
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    /**
     * Determines whether screen recording should be enabled based on the configuration file.
     * The method loads the configuration file "src/main/resources/config/localTestSettings.properties"
     * and retrieves the value for the key "recordScreen". If the value is "true" (case-insensitive),
     * the method returns true, indicating that screen recording should be enabled. Otherwise, it returns false.
     *
     * @return true if screen recording should be enabled, false otherwise
     */
    private static boolean shouldRecord() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/config/localTestSettings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return properties.getProperty("recordScreen").equalsIgnoreCase("true");
    }

    /**
     * Starts the screen recording if screen recording is enabled.
     *
     * @param methodName the name of the method being recorded
     * @throws Exception if an error occurs while starting the screen recording
     */
    public static void startRecording(String methodName) throws Exception {
        if (shouldRecord()) {
            File file = new File("./test-recordings/");

            Dimension browserSize = CommonMethods.getBrowserDimensions();
            Point browserPosition = CommonMethods.getBrowserPosition();

            Rectangle captureSize = new Rectangle(browserPosition.x, browserPosition.y, browserSize.getWidth(), browserSize.getHeight());

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

            screenRecorder = new ScreenRecorderUtil(gc, captureSize,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_JPEG, CompressorNameKey, ENCODING_QUICKTIME_JPEG, DepthKey, 24, FrameRateKey, Rational.valueOf(30), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null, file, methodName);
            screenRecorder.start();
        }
    }

    /**
     * Stops the screen recording if screen recording is enabled.
     *
     * @throws Exception if an error occurs while stopping the screen recording
     */
    public static void stopRecording() throws Exception {
        if (shouldRecord()) {
            screenRecorder.stop();
        }
    }

    /**
     * Returns the most recently modified file in the specified directory.
     *
     * @param directoryFilePath the path to the directory
     * @return the most recently modified file, or null if the directory is empty or does not exist
     */
    public static File getLastModified(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(file -> file.isFile() && file.getName().endsWith(".mov"));
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        return chosenFile;
    }

    /**
     * Converts a .mov file to .mp4 format.
     *
     * @param movFilePath The path of the .mov file to be converted.
     * @param mp4FilePath The path where the converted .mp4 file should be saved.
     * @throws Exception if any error occurs during the conversion process.
     */
    public static void convertMovToMp4(String movFilePath, String mp4FilePath) throws Exception {
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(movFilePath);
        frameGrabber.start();

        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(mp4FilePath, frameGrabber.getImageWidth(), frameGrabber.getImageHeight());

        // Set video quality
        double videoQuality = 0.25;  // High quality
        // double videoQuality = 0.8;  You can use this for lower quality
        recorder.setVideoQuality(videoQuality);

        recorder.start();

        Frame frame;
        while ((frame = frameGrabber.grabFrame()) != null) {
            recorder.record(frame);
        }

        recorder.stop();
        frameGrabber.stop();

        // Delete .mov file after conversion
        File movFile = new File(movFilePath);
        if(movFile.delete()) {
            System.out.println(".mov file deleted successfully");
        } else {
            System.out.println("Failed to delete .mov file");
        }
    }

    /**
     * Determines whether logging should occur after certain steps based on the value in the configuration file.
     * The method loads the configuration file "src/main/resources/config/localTestSettings.properties"
     * and retrieves the value for the key "logAfterSteps". If the value is "true" (case-insensitive), the method
     * returns true, indicating that logging should occur after steps. Otherwise, it returns false.
     *
     * @return true if logging should occur after steps, false otherwise.
     */
    private static boolean shouldLogAfterSteps() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/config/localTestSettings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return properties.getProperty("logAfterSteps").equalsIgnoreCase("true");
    }

    /**
     * Determines whether logging should occur after certain steps based on the value in the configuration file.
     * The method loads the configuration file "src/main/resources/config/localTestSettings.properties"
     * and retrieves the value for the key "logAfterSteps". If the value is "true" (case-insensitive), the method
     * returns true, indicating that logging should occur after steps. Otherwise, it returns false.
     *
     * @return true if logging should occur after steps, false otherwise.
     */
    public static boolean logAfterSteps() {
        return shouldLogAfterSteps();
    }
}