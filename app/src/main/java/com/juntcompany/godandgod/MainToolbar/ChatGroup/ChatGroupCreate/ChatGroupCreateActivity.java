package com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateBottom.ChatGroupCreateBottomFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateMiddle.ChatGroupCreateMiddleFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupCreate.ChatGroupCreateTop.ChatGroupCreateTopFragment;
import com.juntcompany.godandgod.MainToolbar.ChatGroup.ChatGroupFragment;
import com.juntcompany.godandgod.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChatGroupCreateActivity extends AppCompatActivity {

    public static Activity createChatActivity;
    private int TAKE_GALLERY = 2; // 앨범선택에 대한 리턴 코드값 설정
    int picAdd = 0;
    Drawable inputBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group_create);


        createChatActivity = ChatGroupCreateActivity.this;
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        View titleView = getLayoutInflater().inflate(R.layout.toolbar_chat_group_create, null);
        actionBar.setCustomView(titleView);

        ChatGroupCreateTopFragment tf = new ChatGroupCreateTopFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ChatGroupCreateTopContainer, tf)
                .commit();
        ChatGroupCreateBottomFragment bf = new ChatGroupCreateBottomFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ChatGroupCreateBottomContainer, bf)
                .commit();

        TextView groupCreateOk = (TextView) findViewById(R.id.groupCreateOk);


        groupCreateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText groupNameInput = (EditText) findViewById(R.id.groupNameInput);
                Post post = new Post();
                post.postChatLeftGroupPicture = inputBitmap;
                post.postChatLeftGroupName = groupNameInput.getText().toString();;
                post.postChatLeftGroupUser = "김세종 외 1명";
                post.postChatRightGroupPicture = getResources().getDrawable(R.drawable.groupnew);
                post.postChatRightGroupName = "새 그룹";
                post.postChatRightGroupUser = "그룹 만들기";
                ChatGroupFragment.mAdapter.add(post);
                finish();
            }
        });


    }

    public void chatGroupCreateClick(View v) {
        final ImageView groupPictureInput = (ImageView) findViewById(R.id.groupPictureInput);
        switch (v.getId()) {
            case R.id.groupPictureInput:

                if (picAdd == 0) {
                    picAdd = 1;
                    groupPictureInput.setVisibility(View.VISIBLE);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    startActivityForResult(intent, TAKE_GALLERY);

                } else if (picAdd == 1) {
                    picAdd = 0;
                    groupPictureInput.setVisibility(View.GONE);
                }
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_GALLERY) {
            if (data != null) {
                Log.e("Test", "result = " + data);

                Uri thumbnail = data.getData();
                try {
                    Uri selectedImage = data.getData();

                    Bitmap bp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);


                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    bp.compress(Bitmap.CompressFormat.JPEG, 80, baos);

                    byte[] imageByte = baos.toByteArray();

                    final ImageView groupPictureInput = (ImageView) findViewById(R.id.groupPictureInput);
                    groupPictureInput.setBackground(null);
                    groupPictureInput.setImageBitmap(BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length));
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
