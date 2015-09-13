package com.bootvideo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.VideoView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    

	@Override
	protected void onStart() {
		super.onStart();
		String pathString = "android.resource://" + getPackageName() + "/" +R.raw.video;
		Uri uri = Uri.parse(pathString);  
		if (uri != null) {
			VideoView videoView = (VideoView)this.findViewById(R.id.videoview);    
			videoView.setVideoURI(uri);    
			videoView.start();    
			videoView.requestFocus();
			videoView.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					MainActivity.this.finish();
				}
			});
		}
	}
}
