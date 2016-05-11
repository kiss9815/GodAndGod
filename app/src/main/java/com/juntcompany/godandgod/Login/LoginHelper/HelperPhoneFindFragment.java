package com.juntcompany.godandgod.Login.LoginHelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class HelperPhoneFindFragment extends Fragment {

    public HelperPhoneFindFragment() {

    }

    String Title = "휴대폰 번호";

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_helper_phone_find, container, false);
        HelperActivity.fNum = 2;
        ((HelperActivity) getActivity()).setActionTitle(Title);
        Spinner s = (Spinner) view.findViewById(R.id.helperspinner);
        String[] str = getResources().getStringArray(R.array.nation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity().getApplication(), android.R.layout.simple_list_item_1, str);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view,
                                                                   int position, long id) {
                                           final View helperview = inflater.inflate(R.layout.fragment_helper_phone_find, container, false);

                                            TextView tv = (TextView) helperview.findViewById(R.id.nationNum);

                                            switch (position){
                                                case 0:
                                                    tv.setText(" ");
                                                    break;
                                                case 1:
                                                    tv.setText("+82");
                                                    break;
                                                case 2:
                                                    tv.setText("+84");
                                                    break;
                                                case 3:
                                                    tv.setText("+86");
                                                    break;
                                                case 4:
                                                    tv.setText("+87");
                                                    break;
                                                default:
                                                    return;
                                            }

                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                                        }

                                    }
        );
        return view;
    }


}
