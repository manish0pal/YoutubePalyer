package in.youtubepalyer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity  {
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    YouTubePlayerView youTubeView;
    Button btn1;
    YouTubePlayer.OnInitializedListener mOnOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.playvdobtn);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtubevdoplayer);





        mOnOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("zing4uQ3dR4");
              //  youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubeView.initialize(YoutubeConfig.getApikey(),mOnOnInitializedListener);
            }
        });
    }
}