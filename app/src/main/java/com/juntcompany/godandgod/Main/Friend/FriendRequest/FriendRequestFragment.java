package com.juntcompany.godandgod.Main.Friend.FriendRequest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestBottom.FriendRequestBottomFragment;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestTop.FriendRequestTopFragment;
import com.juntcompany.godandgod.Main.Profile.ProfileMainFragment;
import com.juntcompany.godandgod.R;

public class FriendRequestFragment extends Fragment {

    public FriendRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FriendRequestTopFragment ftmain = new FriendRequestTopFragment();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.containerTop, ftmain)
                .commit();
        FriendRequestBottomFragment fbmain = new FriendRequestBottomFragment();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.containerBottom, fbmain)
                .commit();
        return inflater.inflate(R.layout.fragment_friend_request, container, false);
    }

}
