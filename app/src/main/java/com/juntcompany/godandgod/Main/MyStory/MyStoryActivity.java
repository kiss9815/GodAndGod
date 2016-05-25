package com.juntcompany.godandgod.Main.MyStory;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.Main.Friend.FriendFragment;
import com.juntcompany.godandgod.Main.Home.HomeAdapter;
import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.Main.Live.LiveFragment;
import com.juntcompany.godandgod.Main.Love.LoveFragment;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyProfilePostViewHolder;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyprofileFragment;
import com.juntcompany.godandgod.Main.Video.VideoFragment;
import com.juntcompany.godandgod.R;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyStoryActivity extends AppCompatActivity {
    int picAdd = 0;
    private int TAKE_CAMERA = 1; // 카메라 리턴 코드값 설정
    private int TAKE_GALLERY = 2; // 앨범선택에 대한 리턴 코드값 설정
    Drawable inputBitmap;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_story);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("게시글");
        View titleView = getLayoutInflater().inflate(R.layout.toolbar_writestory, null);
        actionBar.setCustomView(titleView);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        final TextView InputOkStory = (TextView) findViewById(R.id.inputStoryOk);
        Button picAddBtn = (Button) findViewById(R.id.addpicBtn);
        Button userAddBtn = (Button) findViewById(R.id.addUserBtn);
        ImageView myProfileUserPicture = (ImageView) findViewById(R.id.myProfileUserPicture);
        myProfileUserPicture.setBackground(sendData.postHomeUserPicture);
        picAddBtn.setOnClickListener(new View.OnClickListener() {
            ImageView pictureAdd = (ImageView) findViewById(R.id.myStoryPicture);

            @Override
            public void onClick(View v) {
                if (picAdd == 0) {
                    picAdd = 1;
                    pictureAdd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    startActivityForResult(intent, TAKE_GALLERY);

                } else if (picAdd == 1) {
                    picAdd = 0;
                    pictureAdd.setVisibility(View.GONE);
                }
            }
        });
        userAddBtn.setOnClickListener(new View.OnClickListener() {
            ImageView pictureAdd = (ImageView) findViewById(R.id.myStoryPicture);

            @Override
            public void onClick(View v) {
                if (picAdd == 0) {
                    picAdd = 1;
                    pictureAdd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, TAKE_CAMERA);

                } else if (picAdd == 1) {
                    picAdd = 0;
                    pictureAdd.setVisibility(View.GONE);
                }
            }
        });

        final EditText myStory = (EditText) findViewById(R.id.myStoryInput);

        myStory.setOnClickListener(new View.OnClickListener() {
            ImageView hintImage = (ImageView) findViewById(R.id.hintImage);

            @Override
            public void onClick(View v) {
                hintImage.setVisibility(View.GONE);
                myStory.setHint("");
            }
        });


        myStory.addTextChangedListener(new TextWatcher() {
            ImageView hintImage = (ImageView) findViewById(R.id.hintImage);

            EditText myStory = (EditText) findViewById(R.id.myStoryInput);

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (myStory.getText().length() == 0) {
                    hintImage.setVisibility(View.VISIBLE);
                    myStory.setHint("          무슨 이야기를 나누고 싶나요?");
                    InputOkStory.setFocusable(false);
                    InputOkStory.setTextColor(Color.GRAY);

                } else {
                    hintImage.setVisibility(View.GONE);
                    InputOkStory.setFocusable(true);
                    InputOkStory.setTextColor(Color.WHITE);
                }
            }


            @Override
            public void afterTextChanged(Editable arg0) {
                // 입력이 끝났을 때
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에
            }
        });

        InputOkStory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText myStoryInput = (EditText)findViewById(R.id.myStoryInput);
                sendData sendData = new sendData();
                if( MainActivity.storyLine == 0) {
                    sendData.postHomeUserName = "GnD";
                    sendData.postHomeTextTime = "2시간 전";
                    sendData.postHomeContentPic = inputBitmap;
                    sendData.postHomeContent = myStoryInput.getText().toString();
                    sendData.postHomeUserLikeNum = "10000";
                    sendData.postHomeUserCommentNum = "100000";
                    HomeFragment.mAdapter.add(sendData);
                }
                else if(MainActivity.storyLine == 1) {
                    sendData.postMyProfileUserName = "GnD";
                    sendData.postMyProfileTextTime = "2시간 전";
                    sendData.postMyProfileContentPic = inputBitmap;
                    sendData.postMyProfileContent = myStoryInput.getText().toString();
                    sendData.postMyProfileUserLikeNum = "10000";
                    sendData.postMyProfileUserCommentNum = "100000";
                    ProfileMyprofileFragment.mAdapter.add(sendData);
                }
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_CAMERA) {
                if (data != null) {
                    Log.e("Test", "result = " + data);
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    if (thumbnail != null) {
                        ImageView Imageview = (ImageView) findViewById(R.id.myStoryPicture);
                        Imageview.setImageBitmap(thumbnail);
                    }
                }

            } else if (requestCode == TAKE_GALLERY) {
                if (data != null) {
                    Log.e("Test", "result = " + data);

                    Uri thumbnail = data.getData();
                    try {
                        Uri selectedImage = data.getData();

                        Bitmap bp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);


                        ByteArrayOutputStream baos = new ByteArrayOutputStream();

                        bp.compress(Bitmap.CompressFormat.JPEG, 80, baos);

                        byte[] imageByte = baos.toByteArray();

                        ImageView Iv = (ImageView) findViewById(R.id.myStoryPicture);

                        Iv.setImageBitmap(BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length));
                        inputBitmap = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length));

                        int len;

                        final int size = 512;

                        byte[] sendByte = new byte[size];

                        ByteArrayInputStream bais = new ByteArrayInputStream(imageByte);


                        sendByte[0] = 6;

                        sendByte[1] = 26;

                        sendByte[2] = 18;


                        while ((len = bais.read(sendByte)) != -1) {

                            if (len < 512) {

                                byte[] EOF = new byte[len];

                                for (int eof = 0; eof < EOF.length; eof++) {

                                    EOF[eof] = sendByte[eof];

                                }


                            } else {


                            }

                        }


                        sendByte[0] = 26;

                        sendByte[1] = 6;

                        sendByte[2] = 18;


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }

}
