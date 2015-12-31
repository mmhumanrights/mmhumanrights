package ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import base.BaseFragment;

/**
 * Created by winhtaikaung on 12/30/15.
 */
public class SplashFragment extends BaseFragment {

    TextView tv_left, tv_right, splash_textview,help_text;
    int position = 0;
    RelativeLayout help_fragment_imageview,description_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_splash, container, false);

        tv_left = (TextView) v.findViewById(R.id.help_tv_back);
        tv_right = (TextView) v.findViewById(R.id.help_tv_next);
        splash_textview = (TextView) v.findViewById(R.id.splash_textview);
        help_text = (TextView) v.findViewById(R.id.help_text);
        help_fragment_imageview = (RelativeLayout) v.findViewById(R.id.help_fragment_imageview);
        description_layout = (RelativeLayout) v.findViewById(R.id.description_layout);


        Bundle databundle = getArguments();
        if (databundle != null)
            position = databundle.getInt("pagerposition");
        switch (position) {
            case 0:
                tv_left.setText("");
                tv_right.setText(getActivity().getResources().getString(R.string.next));
                //description.setText("Swipe right or tap \"Like\" to send a chat request. Swipe Left or tap \"Nope\" to skip.");
                splash_textview.setText("လူ့အခွင့်အရေးဆိုတာ \n" +
                        "ဘာလဲ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_yellow));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_yellow));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_yellow));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));

                break;

            case 1:
                tv_left.setText(getActivity().getResources().getString(R.string.prev));
                tv_right.setText(getActivity().getResources().getString(R.string.next));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_orange_light));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_orange_light));
                //description.setText("Once your request has been approved, you have a match, showing your vedic score.");
                splash_textview.setText("ကျွန်တော်တို့တွေ\n" +
                        "မှာရောလူ့အခွင့်အရေး\n" +
                        "ရှိလား");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_orange_light));

                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));


                break;
            case 2:
                tv_left.setText(getActivity().getResources().getString(R.string.prev));
                tv_right.setText(getActivity().getResources().getString(R.string.next));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_red));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_red));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("ကျွန်တော်တို့ရော\n" +
                        "လူ့အခွင့်အရေးတွေ\n" +
                        "ဆုံးရှုံးမှုရှိနေလား");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_red));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));

                break;

            case 3:
                tv_left.setText(getActivity().getResources().getString(R.string.prev));
                tv_right.setText(getActivity().getResources().getString(R.string.next));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_cyan));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_cyan));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("အပြည်ပြည်ဆိုင်ရာ\n" +
                        "လူ့အခွင့်အရေး\n" +
                        "ကြေငြာစာတမ်းပါ \n" +
                        "အချက်အလက်တွေက\n" +
                        "ဘာတွေလဲ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_cyan));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));

                break;
            case 4:
                tv_left.setText(getActivity().getResources().getString(R.string.prev));
                tv_right.setText(getActivity().getResources().getString(R.string.next));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_android_green));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_android_green));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("ဒါတွေအားလုံးကို\n" +
                        "မကြာခင်သိရမှာပါ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_android_green));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));

                break;
            case 5:
                tv_left.setText(getActivity().getResources().getString(R.string.prev));
                tv_right.setText(getActivity().getResources().getString(R.string.done));
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_light_yellow));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_light_yellow));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                help_text.setVisibility(View.VISIBLE);
                help_text.setText("(ရပြီ) ကိုနှိပ်ပါ");
                help_text.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                splash_textview.setText("ဒီ App လေးမှ\n" +
                        "သင့်ကို\n" +
                        "လူ့အခွင့်အရေးနှင့်\n" +
                        "ပတ်သက်၍ အသိပညာ\n" +
                        "မျှဝေပါရစေ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_light_yellow));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_black));

                break;
            default:
                tv_left.setText("");
                tv_right.setText("NEXT");
                break;
        }

        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INavigationListener navListener = (INavigationListener)getActivity();
                navListener.onNavigationClickListener(tv_left.getText().toString());
            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INavigationListener navListener = (INavigationListener)getActivity();
                navListener.onNavigationClickListener(tv_right.getText().toString());
            }
        });

        return v;
    }

    public interface INavigationListener{
        void onNavigationClickListener(String nav);
    }
}
