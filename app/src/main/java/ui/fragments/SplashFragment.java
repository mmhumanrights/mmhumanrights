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

    TextView tv_left, tv_right, splash_textview;
    int position = 0;
    RelativeLayout help_fragment_imageview,description_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_splash, container, false);

        tv_left = (TextView) v.findViewById(R.id.help_tv_back);
        tv_right = (TextView) v.findViewById(R.id.help_tv_next);
        splash_textview = (TextView) v.findViewById(R.id.splash_textview);
        help_fragment_imageview = (RelativeLayout) v.findViewById(R.id.help_fragment_imageview);
        description_layout = (RelativeLayout) v.findViewById(R.id.description_layout);


        Bundle databundle = getArguments();
        if (databundle != null)
            position = databundle.getInt("pagerposition");
        switch (position) {
            case 0:
                tv_left.setText("");
                tv_right.setText("NEXT");
                //description.setText("Swipe right or tap \"Like\" to send a chat request. Swipe Left or tap \"Nope\" to skip.");
                splash_textview.setText("လူ့အခွင့်အရေးဆိုတာ \n" +
                        "ဘာလဲ");
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_yellow));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_yellow));

                break;

            case 1:
                tv_left.setText("BACK");
                tv_right.setText("NEXT");
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                //description.setText("Once your request has been approved, you have a match, showing your vedic score.");
                splash_textview.setText("ကျွန်တော်တို့တွေ\n" +
                        "မှာလူ့အခွင့်အရေး\n" +
                        "ရှိလား");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_white));

                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_blue_dark));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_blue_dark));


                break;
            case 2:
                tv_left.setText("BACK");
                tv_right.setText("NEXT");
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("ကျွန်တော်တို့ရော\n" +
                        "လူ့အခွင့်အရေးတွေ\n" +
                        "ဆုံးရှုံးမှုရှိနေလား");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_red));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_red));

                break;

            case 3:
                tv_left.setText("BACK");
                tv_right.setText("NEXT");
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("အပြည်ပြည်ဆိုင်ရာ\n" +
                        "လူ့အခွင့်အရေး\n" +
                        "ကြေငြာစာတမ်းပါ \n" +
                        "အချက်အလက်တွေက\n" +
                        "ဘာတွေလဲ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_teal));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_teal));

                break;
            case 4:
                tv_left.setText("BACK");
                tv_right.setText("DONE");
                tv_right.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                tv_left.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                //description.setText("You can then start chatting. The rest is up to you… Be nice :)");
                splash_textview.setText("Myanmar Human Rights App \n" +
                        "မှသင့်ကိုလူ့အခွင့်အရေးနှင့်\n" +
                        "ပတ်သက်၍ အသိပညာမျှဝေပါရစေ");
                splash_textview.setTextColor(getActivity().getResources().getColor(R.color.main_white));
                help_fragment_imageview.setBackgroundColor(getActivity().getResources().getColor(R.color.main_blue));
                description_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.main_blue));

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
