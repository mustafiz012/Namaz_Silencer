package ara.kuet.musta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuet.musta.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SunriseFragment extends Fragment {


	public SunriseFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.sunrise_fragment, container, false);
	}


}