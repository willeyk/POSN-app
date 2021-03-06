package com.posn.main.main.wall;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.posn.constants.Constants;
import com.posn.R;
import com.posn.datatypes.WallPost;


/**
 * This activity class allows the user to view the full video that was clicked from a wall post
 * <ul><li>This class is not used as the video posts are not implemented</ul>
 **/
public class VideoPlayerActivity extends Activity
   {
      /**
       * This method is called when the activity needs to be created and handles the interface elements.
       * <ul><li>Fetches the wall post object that was passed in by the wall fragment
       * <li>Loads the video to the videoview</ul>
       **/
      @Override
      protected void onCreate(Bundle savedInstanceState)
         {
            super.onCreate(savedInstanceState);

            // load the user interface layout from the xml file
            setContentView(R.layout.activity_video_player);

            // get the wall post object that was passed from the wall fragment
            WallPost wallPost = getIntent().getExtras().getParcelable("post");

            // check if the wall object exists
            if (wallPost != null)
               {
                  // create the video file path
                  String filepath = Constants.multimediaFilePath + "/" + wallPost.postID + ".mp4";

                  // get the video view from the layout
                  VideoView videoView = (VideoView) findViewById(R.id.video);

                  // create a new media controller and set it to the video view
                  MediaController mc = new MediaController(this);
                  videoView.setMediaController(mc);
                  mc.setAnchorView(videoView);

                  // set the video path and play the video
                  videoView.setVideoPath(filepath);
                  videoView.start();
               }
         }
   }
