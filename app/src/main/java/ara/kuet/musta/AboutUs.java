package ara.kuet.musta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuet.musta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment {

	public static final String TAG = AboutUs.class.getSimpleName();

	public static AboutUs newInstances(){
		return new AboutUs();
	}

	public AboutUs() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_about, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = (TextView) view.findViewById(R.id.textAbout);
		textView.setText("It's All About Us! by ara");
	}
}
