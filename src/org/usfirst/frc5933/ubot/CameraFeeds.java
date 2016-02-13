package org.usfirst.frc5933.ubot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraFeeds
{
    private final int camFront = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);;
    private final int camRear = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    private int curCam = camFront;
    private Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);;
    private CameraServer server = CameraServer.getInstance();

    public void init()
    {
        changeCam(camRear);
    }

    public void run()
    {
        /*
        if(curCam == camRear)
            changeCam(camFront);

        if(contr.getButton(Config.CameraFeeds.btCamRight))
            changeCam(camRear);
        */
    }

    /**
     * Stop aka close camera stream
     */
    public void end()
    {
        NIVision.IMAQdxStopAcquisition(curCam);
    }

    public void changeCam() {
        if (curCam == camFront) {
            changeCam(1);
        } else {
            changeCam(0);
        }
    }

    /**
     * Change the camera to get imgs from to a different one
     * @param newId for camera
     */
    public void changeCam(int newId)
    {
        NIVision.IMAQdxStopAcquisition(curCam);
        NIVision.IMAQdxConfigureGrab(newId);
        NIVision.IMAQdxStartAcquisition(newId);
        curCam = newId;
        updateCam();
    }

    /**
     * Get the img from current camera and give it to the server
     */
    public void updateCam()
    {
        NIVision.IMAQdxGrab(curCam, frame, 1);
        server.setImage(frame);
    }
}