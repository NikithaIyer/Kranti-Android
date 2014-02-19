package com.change.kranti;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import repository.IssueRepository;



public class CaptureIssueActivity extends Activity {
    private IssueRepository issueRepository;
    private Uri fileUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        issueRepository = new IssueRepository(getApplicationContext());
        setContentView(R.layout.create);
    }


    public void submit(View view) {

        EditText description = (EditText) findViewById(R.id.descriptionText);
        EditText title = (EditText) findViewById(R.id.titleText);
        String issueTitle =  title.getText().toString();
        String issueDescription =  description.getText().toString();
        issueRepository.createIssue(issueTitle,issueDescription);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    public void callCamera(View view) {
      Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      startActivityForResult(cameraIntent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageBitmap(photo);
        }
    }
}
